package ch02_데이터와변수;

/**
 * 정수의 타입
 * 1. byte  1byte
 * 2. short 2byte
 * 3. int   4byte = 32bit -> 2의 32승 -> 4,294,967,296 -> +-21억
 * 4. long  8byte
 * 5. char  2byte
 */
// 다른 이름으로 저장하면 Refactoring 되지 않음
public class Ex03_byte정수 {

	public static void main(String[] args) {
		
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
//		byte var6 = 128;  // 에러! 허용 범위 초과
		// Type mismatch: cannot convert from int to byte

		// 출력
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
	}

}
