package ch02_데이터와변수;


/** shift+alt+j(주석)
 * 타입 변환
 * 1. 자동 타입 변환: 값의 허용 범위가 작은 타입이 허용 범위 큰 타입으로 대입될 때 발생
 * 2. 강제 타입 변환: 큰 허용 범위 타입을 작은 허용 범위 타입으로 쪼개어서 저장하는 것(형식: 작은타입 변수 = (작은타입) 변수)
 */
public class Ex10_타입변환 {

	public static void main(String[] args) {
		// 자동 타입 변환
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue: " + intValue);
		
		// char -> short
		char charValue = 10;
		short shortValue = charValue;
		System.out.println("shortValue: " + shortValue);
		
		// int -> long
		intValue = 50;
		long longValue = intValue;
		System.out.println("longValue: " + longValue);
		
		// long -> float
		longValue = 100;
		float flaotValue = longValue;
		System.out.println("flaotValue: " + flaotValue);
		
		// float -> double
		floatValue = 100.5f;
		double doubleValue = floatValue;
		System.out.println("doubleValue: " + doubleValue);

		// 강제 타입 변환
		int var1 = 10;
		// 타입 변수명 = (타입) 변수명;
		byte var2 = (byte) var1;
	}

}
