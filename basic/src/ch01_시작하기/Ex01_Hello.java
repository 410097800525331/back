package ch01_시작하기;
/*
 * package 패키지명;
 * 1. 소문자만
 * 2. 숫자로 시작X
 * 3. 특수문자는 .과 _
 * 4. 예약어X
*/
/**
 * 문서 주석(JAvadoc): alt+shift+J
 * @author 작성자명
 * 작성일: 2025-12-09
 */
/*
 * 접근제한자 class 클래스명 {코드}
 * 1. 파스칼 표기법: 단어별 첫 글자 대문자
 * 2. _, $, 숫자 가능
 * 3. 예약어(키워드) 사용X
 */
public class Ex01_Hello {
	// 문자: char - 문자 1자 예) 'A', 'a', '가'
	// 문자열: string - "문자열"
	// 정수: byte, short, int, long
	// 실수: float, double
	// 불: boolean
	// void: 메서드의 리턴 값이 없음
	// 접근제한자 static void main(데이터타입 인자) - 프로그램의 시작점
	public static void main(String[] args) {
		// ctrl+N: 새 문서
		// ctrl+space: 자동 완성
		// ctrl+F11: 실행
		// F2 또는 alt+shift+r: 이름 바꾸기
		
		// 여러 줄 주석: 영역 선택 후 ctrl+shift+/
		// ctrl+m: 코드뷰 최대화/원래대로
		// ctrl+d: 선택한 영역(줄 단위) 삭제
		// ctrl+alt+방향키: 선택한 영역(줄 단위) 복제
		
		// ctrl+i: 선택한 영역 정렬
		// ctrl+shift+f: 자동 들여쓰기/정렬
		
		// print() - 줄바꿈X
		System.out.print("Hi, JAVA");
		// println() - 줄바꿈O
		System.out.println("자동 완성");
	}

}
 