package ch02_데이터와변수;

/**
 * 정수의 타입
 * 1. byte  1byte
 * 2. short 2byte
 * 3. int   4byte = 32bit -> 2의 32승 -> 4,294,967,296 -> +-21억
 * 4. long  8byte
 * 5. char  2byte
 */
public class Ex02_정수리터럴 {

	public static void main(String[] args) {
		// 리터럴(Literal)
		// - 프로그램 코드에서 직접 값으로 표현된 데이터
		// - 변수에 저장되는 실제 값
		
		int var1 = 0b1011; // 0b___, 2진수 1011
		int var2 = 0206;   // 0____, 8진수 20
		int var3 = 365;    // 10진
		int var4 = 0xB3;   // 0x___, 16진수

		// 출력
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
	}

}
