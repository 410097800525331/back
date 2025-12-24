package ch06_클래스.ex03_필드초기화;

public class KoreanMain {

	public static void main(String[] args) {
		// 1. 객체 생성(Create)
		// 클래스타입 참조변수 = new 생성자([인자, ...]);
		Korean k1 = new Korean("박자바", "011225-1234567");
		Korean k2 = new Korean("김자바", "930525-2654321");
		
		// 2. 객체 데이터 읽기(Read)
		// 객체.필드
		System.out.println("k1.nation: " + k1.nation);
		System.out.println("k1.name: " + k1.name);
		System.out.println("k1.ssn: " + k1.ssn);
		System.out.println("k2.nation: " + k2.nation);
		
		// final 필드가 아닌 경우 재할당(수정, Update) 가능
		k2.name = "홍길동";
		System.out.println("k2.name: " + k2.name);
		
		// final 필드는 재할당 불가
		// k2.ssn = "930525-16254321"; 에러
		// 에러? The final field Korean.ssn cannot be assigned
		System.out.println("k2.ssn: " + k2.ssn);

	}

}