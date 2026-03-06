package ch09_중첩선언과익명객체.ex02_정적멤버클래스;

public class AExample {
	public static void main(String[] args) {
		// class B가 A의 인스턴스 멤버 일때
		//A a = new A();
		//A.B b = a.new B();
		
		// class B가 A의 정적 멤버 일때
		A.B b = new A.B();
	}
}