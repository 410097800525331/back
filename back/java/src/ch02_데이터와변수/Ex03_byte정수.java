package ch02_데이터와변수;

/**
 * 단위: bit(비트) - byte(바이트)
 * 데이터 용량: 
 * 	1000byte = 1KB (킬로)
 * 	1000KB = 1MB (메가)
 * 	1000MB = 1GB (기가)
 *  1000GB = 1TB (테라)
 * 	
 * 
 * 정수의 타입
 * 1. byte	1byte = 8bit -> 2의 8승 -> 256가지 숫자 -> -128~127
 * 2. short	2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> -32768~32767
 * 3. int	4byte = 32bit -> 2의 32승 -> 4,294,967,296 -> +-21억
 * 4. long	8byte = 64bit -> 2의 64승 -> +-922경
 * 5. char	2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> 0 ~ 65565(유니코드)
 */
// 리팩터링(refactoring)은 코드의 외부 동작을 바꾸지 않으면서 내부 구조를 개선하는 작업
// 다른 이름으로 저장하면 Refactoring 되지 않음!
// 클래스명은 *.java 파일명과 같아야 한다.
public class Ex03_byte정수 {

	public static void main(String[] args) {
		// 선택한 영역 복제: ctrl+alt+↑↓
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
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
