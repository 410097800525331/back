package ch02_데이터와변수;

/**
 * 실수 타입
 * 1. float   4byte(32bit)
 * 2. double  8byte(64bit)
 * 
 * 형식: 부호(signed: +, -) + 가수(mantissa) + 지수(exponent)
 */
public class Ex06_실수 {

	public static void main(String[] args) {
		// 정밀도 확인
		// float 리터럴은 끝에 f 또는 F를 붙인다
		float var1 = 0.1234567890123456789f;
		double var2 = 0.1234567890123456789;
		
		double var3 = 3e6; // 10을 거듭해서 6번 곱함
		float var4 = 3e6F;
		double var5 = 2e-3;
		
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
	}

}
