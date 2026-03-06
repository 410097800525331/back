package ch09_중첩선언과익명객체.ex03_로컬클래스;

/**
 * 중첩(내부) 클래스
 * 	1. 인스턴스 내부 클래스(Non-static Inner Class)
 * 		- 외부 클래스의 인스턴스에 종속되어 정의되는 내부 클래스
 * 	2. 정적 내부 클래스(Static Inner Class)
 * 		- 외부 클래스의 인스턴스와 무관하게 사용 가능한 내부 클래스
 * 	3. 로컬 내부 클래스
 * 		- 생성자, 메서드 또는 블록 내부에서 정의되는 내부 클래스
 */
public class A2 {
	//메소드
	void useB() {
		//로컬 클래스
		class B {
			//인스턴스 필드
			int field1 = 1;

			//정적 필드(Java 17부터 허용)
			static int field2 = 2;

			//생성자
			B() {
				System.out.println("B-생성자 실행");
			}

			//인스턴스 메소드
			void method1() {
				System.out.println("B-method1 실행");
			}

			//정적 메소드(Java 17부터 허용)
			static void method2() {
				System.out.println("B-method2 실행");
			}
		}
		
		//로컬 객체 생성
		B b = new B();
		
		//로컬 객체의 인스턴스 필드와 메소드 사용
		System.out.println(b.field1);
		b.method1();
		
		//로컬 클래스의 정적 필드와 메소드 사용(Java 17부터 허용)
		System.out.println(B.field2);
		B.method2();
	}
}