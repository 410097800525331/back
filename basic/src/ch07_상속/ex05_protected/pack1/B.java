package ch07_상속.ex05_protected.pack1;

// A와 B는 같은 패키지에 있다.
public class B {
	//메소드 선언
	public void method() {
		A a = new A();		//ok
		a.field = "value"; 	//ok
		a.method(); 		//ok
	}
}