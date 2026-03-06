package ch11_base모듈.sec03_String;

/**
 * StringBuilder 클래스
 *  - String은 내부 문자열을 수정할 수 없다.(immutable, 불변)
 *  - 내부 버퍼(데이터를 저장하는 메모리)에 문자열을 저장해두고
 *    그 안에서 추가, 수정, 삭제 작업을 하도록 설계되어 있다.
 *  - toString() 메서드를 제외한 다른 메서드는 메서드 체이닝 패턴을 사용할 수 있다.
 *    
 *    StringBuilder append("문자열"): 문자열을 끝에 추가
 *    StringBuilder insert(시작인덱스, "문자열"): 문자열을 지정 위치에 추가
 *    StringBuilder delete(시작인덱스, 끝인덱스): 문자열 일부 삭제
 *    StringBuilder replace(시작인덱스, 끝인덱스, "문자열"): 문자열 일부 대체
 *    
 *    String toString(): 완성된 문자열 리턴
 *    
 */
public class Ex02_StringBuilder {
	public static void main(String[] args) {
		// 메서드 체이닝 패턴 방식
		String data = new StringBuilder()
				// 문자열 뒤에 "DEF"추가
				.append("DEF")
				// 인덱스 0 위치에 "ABC" 추가
				.insert(0, "ABC")
				// 인덱스 3 위치의 문자열 삭제 (인덱스 4는 불포함)
				.delete(3, 4)
				// StringBuilder -> String 로 변환
				.toString();
		System.out.println(data);
		
		// 메서드 체이닝x
		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
		StringBuilder s = sb.append("LMN"); // LMN
		System.out.println(s);
		sb.insert(0, "OPQ"); // OPQLMN
		// 인덱스 3부터 4앞까지(즉, 4는 포함x)
		sb.delete(3, 5); // OPQMN
		
		String data2 = sb.toString();
		System.out.println(data2);
	}
}