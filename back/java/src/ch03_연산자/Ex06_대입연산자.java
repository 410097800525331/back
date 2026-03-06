package ch03_연산자;

/**
 * 대입 연산자
 * 		=
 * 		+=
 * 		-=
 * 		*=
 * 		/=
 * 		%=
 */
public class Ex06_대입연산자 {

	/*
	 * 여러 줄 주석: /*엔터
	 * JavaDoc: /**엔터
	 * 실행: ctrl+F11 (참고 vscode는 ctrl+F5)
	 */
	public static void main(String[] args) {
		int result = 0;		
		result += 10; // result = result + 10;
		System.out.println("result=" + result);		
		result -= 5; // result = result - 5;
		System.out.println("result=" + result);		
		result *= 3; // result = result * 3;
		System.out.println("result=" + result);		
		result /= 5; // result = result / 5;
		System.out.println("result=" + result);		
		result %= 3; // result = result % 3;
		System.out.println("result=" + result);	

	}

}
