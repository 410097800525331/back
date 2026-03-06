package ch08_인터페이스.ex08_인터페이스상속;

/**
 * 인터페이스 상속
 *  - 다중 상속을 허용한다. 
 *  
 *  	[접근제한자] class 자식클래스 extends 부모클래스1, 부모클래스2, ... {...}
 *  		-> 클래스 다중 상속(x)
 *  	[접근제한자] class 자식클래스 extends 부모클래스 {...}
 *  		-> 클래스는 단일 상속만 가능
 *  
 *  	[접근제한자] interface 자식인터페이스 extends 부모인터페이스1, 부모인터페이스2, ... {...}
 *  		-> 인터페이스 다중 상속 가능!
 *  
 *  	[접근제한자] interface 인터페이스 implements 인터페이스1, 인터페이스2, ... {...}
 *  		-> 인터페이스 다중 구현 가능!
 *  
 */
public interface InterfaceC extends InterfaceA, InterfaceB {
	//추상 메소드
	void methodC();
}