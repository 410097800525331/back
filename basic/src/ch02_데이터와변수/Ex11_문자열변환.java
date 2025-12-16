package ch02_데이터와변수;

/**
 * 문자열을 기본 타입으로 변환
 * 	Byte.parseByte(문자열)
 * 	Short.parseShort(문자열)
 * 	Integer.parseInt(문자열)
 * 	Long.parseLong(문자열)
 * 	Float.parseFloat(문자열)
 * 	Double.parseDouble(문자열)
 * 	Boolean.parseBoolean(문자열)
 */
public class Ex11_문자열변환 {

	public static void main(String[] args) {
		// 문자열 -> 기본타입
		// 숫자로 바뀔 수 있는 문자열만 가능
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		// "true", "false"만 불로 변환 가능
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1: " + value1);
		System.out.println("value2: " + value2);
		System.out.println("value3: " + value3);
		
		// 기본타입 -> 문자열
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		System.out.println("str3: " + str3);

	}

}
