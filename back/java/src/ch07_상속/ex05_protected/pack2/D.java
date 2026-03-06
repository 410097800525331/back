package ch07_상속.ex05_protected.pack2;

import ch07_상속.ex05_protected.pack1.A;

// ctrl+shift+o: 자동 임포트
// A cannot be resolved(해결됨) to a type

/**
 * protected 접근 제한자
 * 	- A와 D는 다른 패키지에 있다.
 *    그러나, D는 A를 상속받음!
 *  - new 연산자를 사용해서 생성자를 직접 호출할 수 없다.
 *  -> 자식 생성자에서 super()로 부모 생성자를 호출할 수 있다.
 */
public class D extends A {
	//생성자 선언
	public D() {
		//A() 생성자 호출
		super(); //o
		//A a = new A(); // 에러
	}
	
	//메소드 선언
	public void method1() {
		//A 필드값 변경
		this.field = "value"; 	//o
		//A 메소드 호출
		this.method(); 			//o
	}
	
	//메소드 선언
	public void method2() {
//		A a = new A();		//에러
//		a.field = "value"; 	//에러
//		a.method(); 		//에러
	}	
}







