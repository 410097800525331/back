package ch02_데이터와변수;

/**
 * 정수의 타입
 * 1. byte	1byte = 8bit -> 2의 8승 -> 256가지 숫자 -> -128~127
 * 2. short	2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> -32768~32767
 * 3. int	4byte = 32bit -> 2의 32승 -> 4,294,967,296 -> +-21억
 * 4. long	8byte = 64bit -> 2의 64승 -> +-922경
 * 5. char	2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> 0 ~ 65565(유니코드)
 */
public class Ex05_char정수 {

	public static void main(String[] args) {
		// ctrl+alt+↑↓	선택한 영역 복제
		// ctrl+F11		실행
		// ctrl+M		코드뷰 최대화
		
		// 문자(글자 1자)는 단일 따옴표, 
		// 문자열(1자 이상)은 이중 따옴표로 묶는다.
		
		// 문자 저장
		char var1 = 'A';
		char var5 = '가';
		//char var7 = ''; //에러
		// 문자열 저장
		String var2 = "A";
		String var8 = "";
		
		// 유니코드 직접 저장
		// 10진수 65와 매핑되는 문자는 'A'
		char var3 = 65;
		// 16진수 0x0041과 매핑되는 문자는 'A'
		char var4 = 0x0041;
		char var6 = 44032;

		// sysout 쓰고, ctrl+space
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
		System.out.println("var6: " + var6);
	}

}
