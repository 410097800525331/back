package ch07_상속.ex06_타입변환;

public class Child extends Parent {
	// 필드 선언
	public String field2;
	
	// method2는 부모 메서드를 재정의
	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}

	// method3은 자식 메서드
	public void method3() {
		System.out.println("Child-method3()");
	}
}