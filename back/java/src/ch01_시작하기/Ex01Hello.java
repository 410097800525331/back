package ch01_시작하기;
/* package 패키지명;
 *  1. 소문자로 기록
 *  2. 숫자로 시작❌
 *  3. 특수문자는 .과 _
 *  4. 예약어(키워드) 사용❌ - public, class, package, ...
 */
/**
 * 문서 주석(Javadoc): alt+shift+J
 * @author 작성자명 
 * 기능: Hello 
 * 작성일: 2025-12-09
 */
/*
 * 접근제한자 class 클래스명 { 코드 }
 * 1. 파스칼 표기법(관례) - 단어별 첫 글자를 대문자
 * 2. _, $, 숫자
 * 3. 예약어(키워드) 사용❌ - public, class, package, ...
 */
public class Ex01Hello {
	/*
	 * 여러 줄 주석: 영역 선택 후 ctrl+shift+/
	 */

	// 문자: char
	// 문자열: String
	// 정수: byte, short, int, long
	// 실수: float, double
	// 불: boolean
	// 배열: []
	// void: 메서드의 리턴 값이 없음!
	// 접근제한자 static void main(데이터타입 인자) 
	// - 프로그램의 시작점
	public static void main(String[] args) {
		// ctrl+N: 새 문서
		// ctrl+/ : 한 줄 주석
		// ctrl+shift+L : 단축키 목록
		// ctrl++/- : 코드뷰의 글자 크기를 확대/축소
		// F2 또는 alt+shift+R : 이름 바꾸기
		// alt+↑↓ : 선택한 영역(줄 단위) 위치 이동
		// ctrl+alt+↑↓ : 선택한 영역(줄 단위) 복제
		// ctrl+d : 선택한 영역(줄 단위) 삭제
		// ctrl+M : 코드뷰 최대화/원래대로
		// ctrl+space : 자동 완성
		// ctrl+F11 : 실행
		// ctrl+i : 선택한 영역 자동 들여쓰기 
		// ctrl+shift+f : 자동 들여쓰기
		// alt+shift+Y : 줄 바꿈(토글)
		
		// char 문자: 문자 1자 -> 예) 'A', 'a', '가'
		// String "문자열"
		// 객체.메서드(인자)
		// print() - 줄 바꿈❌❌
		System.out.print("Hello, Java ");
		// println() - 줄 바꿈⭕
		System.out.println("Hello, Java");
		System.out.print("Hello, Java ");

	}

}
