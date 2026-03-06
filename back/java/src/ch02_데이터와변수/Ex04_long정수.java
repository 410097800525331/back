package ch02_데이터와변수;

/**
 * 정수의 타입
 * 1. byte	1byte = 8bit -> 2의 8승 -> 256가지 숫자 -> -128~127
 * 2. short	2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> -32768~32767
 * 3. int	4byte = 32bit -> 2의 32승 -> 4,294,967,296 -> +-21억
 * 4. long	8byte = 64bit -> 2의 64승 -> +-922경
 * 5. char	2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> 0 ~ 65565(유니코드)
 */
public class Ex04_long정수 {

	public static void main(String[] args) {
		// 선택한 영역 복제: ctrl+alt+↑↓
		// 찾기/바꾸기: ctrl+f
		// alt+shift+a -> 다중 커서 편집 상태에서 shift+방향키로 다중 커서 생성 후 수정
		long var1 = -128;
		long var2 = -30;
		long var3 = 0;
		long var4 = 30;
		long var5 = 127;
		//byte var6 = 128; // 에러? 허용 범위(-128~127) 초과
		// Type mismatch: cannot convert from int to byte
		
		// 출력
		// 코드 실행: ctrl+F11
		System.out.println("var1: " + var1); // 11
		System.out.println("var2: " + var2); // 134
		System.out.println("var3: " + var3); // 365
		System.out.println("var4: " + var4); // 179
		System.out.println("var5: " + var5); // 179
		

	}

}
