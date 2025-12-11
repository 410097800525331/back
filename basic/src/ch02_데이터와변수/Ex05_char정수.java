package ch02_데이터와변수;

public class Ex05_char정수 {

	public static void main(String[] args) {
		// 문자(글자 1자)는 단일 따움표, 문자열(1자 이상)은 이중 따음표로 묶는다.
		
		// 문자 저장
		char var1 = 'A';
		char var2 = '가';
		// 문자열 저장
		String var5 = "A";
		String var7 = ""; // ""은 빈문자열 가능(''은 불가능)
		// 유니코드 직접 저장
		char var3 = 65;
		char var4 = 44032;
		char var6 = 0x0041;
		
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
		System.out.println("var6: " + var6);
	}

}
