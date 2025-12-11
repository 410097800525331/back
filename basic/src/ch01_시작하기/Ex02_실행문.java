package ch01_시작하기;

public class Ex02_실행문 {
	// 클래스 생성 후 main 쓰고 ctrl+spce
	// 프로그램의 시작 진입점
	
	// 컴파일 에러 + 실행 에러
	public static void main(String[] args) {
		// 실행문
		// 정수(Integer): byte, short, char, int, long
		int x, z = 2; // 변수 선언
		x = 1; // 값을 할당
		int y = 2; // 변수 선언 및 할당
		int result = x + y + z; // 변수 선언 및 할당(연산)
		System.out.println(result); // 출력
	}
}
