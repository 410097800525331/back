package ch09_중첩선언과익명객체.ex05_외부클래스객체접근;

public class AMain {
	public static void main(String[] args) {
		//A2 객체 생성
		A a = new A();

		//A2 메서드 호출
		a.useB();
	}
}