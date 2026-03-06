package ch09_중첩선언과익명객체.ex05_외부클래스객체접근;

/**
 * 외부 클래스: class A
 * 내부 클래스: class B
 * 
 * 내부 클래스 안에서 외부 클래스의 객체에 접근하려면?
 * 
 * 		외부클래스명.this
 * 
 */
public class A {
	//A 인스턴스 필드
	String field = "A-field";
	
	//A 인스턴스 메소드
	void method() {
		System.out.println("A-method");
	}
	
	//인스턴스 멤버 클래스
	class B {
		//B 인스턴스 필드
		String field = "B-field";
	
		//B 인스턴스 메소드
		void method() {
			System.out.println("B-method");
		}
	
		//B 인스턴스 메소드
		void print() {
			//B 객체의 필드와 메소드 사용
			// this는 객체 자기 자신
			System.out.println(this.field);
			this.method();
	
			//A 객체의 필드와 메소드 사용
			System.out.println(A.this.field);
			A.this.method();
		}
	}
	
	//A의 인스턴스 메소드
	void useB() {
		B b = new B();
		b.print();
	}	
}