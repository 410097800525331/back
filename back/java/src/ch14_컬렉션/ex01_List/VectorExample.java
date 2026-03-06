package ch14_컬렉션.ex01_List;

import java.util.List;
import java.util.Vector;
/**
 * Vector
 * 	- 동기화(synchronized) 메서드로 구성
 *  -> 멀티 스레드 환경에서 안전하게 객체를 추가/삭제
 *  
 *  객체 생성
 *  	List<E> list = new Vector<E>(); // E에 지정된 타입의 객체만 저장
 *  	List<E> list = new Vector<>();
 *  	List list = new Vector(); // 모든 타입의 객체 저장
 *  
 *  
 */
// ThreadA와 ThreadB에서 동시에 Board 객체를 
// Vector에 각각 1000개씩 추가한 후 전체 저장된 수를 출력
public class VectorExample {
	public static void main(String[] args) {
		//Vector 컬렉션 생성
		List<Board> list = new Vector<>();
	
		//작업 스레드 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				//객체 1000개 추가
				for(int i=0; i<1000; i++) {
					list.add(new Board("제목A"+i, "내용A"+i, "글쓴이A"+i));
					Board b = list.get(i);
					System.out.println(b.getSubject() + "\t" + b.getContent() +
							"\t" + b.getWriter());
				}
			}
		};
		
		//작업 스레드 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				//객체 1000개 추가
				for(int i=0; i<1000; i++) {
					list.add(new Board("제목B"+i, "내용B"+i, "글쓴이B"+i));
					Board b = list.get(i);
					System.out.println(b.getSubject() + "\t" + b.getContent() +
							"\t" + b.getWriter());
				}
			}
		};
		
		//작업 스레드 실행
		threadA.start();
		threadB.start();
		
		//작업 스레드들이 모두 종료될때까지 메인 스레드를 기다리게함
		try {
			threadA.join();
			threadB.join();
		} catch(Exception e) {
		}
		
		//저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수: " + size);		
		System.out.println();		
	}
}