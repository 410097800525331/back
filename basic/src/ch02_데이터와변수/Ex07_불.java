package ch02_데이터와변수;

/**
 * boolean(불)
 * 1. 참과 거짓을 의미하는 놀리 리터럴은 true와 false이다
 * 2. 논리 리터럴은 boolean 타입 변수에 대입한다.
 * 3. boolean 타입 변수는 주로 두 가지 상태값을 지정할 필요가 없을 경우 사용되며
 * 4. 상태값에 따라 조건문과 제어문의 실행 흐름을 변경하는데 사용된다
 */
public class Ex07_불 {

	public static void main(String[] args) {
		boolean stop = true;
		
		// 제어문의 실행 흐름 변경
		if (stop) {
			System.out.println("중지합니다");
		} else {
			System.out.println("시작합니다");
		}
		
		/*
		 * 대입연산자: =
		 * 비교 연산자: ==, !=, >, <, >=, <= (자바스크립트는 === !==)
		 * 논리 연산자: &&(논리곱), ||(논리합), !(논리 부정)
		 * 비교/논리 연산의 결과는 true 또는 false
		 */
		
		int x = 10;
		
		boolean var1 = (x == 20);
		boolean var2 = (x != 20);
		boolean var3 = (x > 20);
//		boolean var4 = (0 < x && < 20);
		boolean var5 = (x < 0 || x > 200);
		
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
//		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
	}

}
