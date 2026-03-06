package ch11_base모듈.sec02_System;

/**
 * System 클래스의 err 필드
 *	- 콘솔(Console)에 에러 내용 출력
 * 	- 콘솔 종류에 따라 글자색이 빨간색으로 출력된다.
 *
 *		System.err.println("문자열");
 *
 */
public class Ex01_err필드 {

	public static void main(String[] args) {
		try {
			int value = Integer.parseInt("1oo");
		} catch(NumberFormatException e) {
			System.out.println("[에러 내용]");
			System.out.println(e.getMessage());
			System.err.println("[에러 내용]");
			System.err.println(e.getMessage());
		}
	}
}