package ch08_인터페이스.ex08_인터페이스상속;

// The type InterfaceCImpl must implement the inherited abstract method InterfaceA.methodA()
// InterfaceCImpl 타입은 상속된 추상 메서드 InterfaceA.methodA()를 구현해야 합니다.
// alt+shift+s,v: 추상 메서드 재정의 대화상자
/**
 * 인터페이스 상속
 *  - 자식 인터페이스의 구현 클래스는 자식 인터페이스의 추상 메서드뿐만 아니라
 *    부모 인터페이스의 모든 추상 메서드를 재정의해야 한다.
 *    
 */
public class InterfaceCImpl implements InterfaceC {

	public void methodA() {
		System.out.println("InterfaceCImpl-methodA() 실행");
	}

	public void methodB() {
		System.out.println("InterfaceCImpl-methodB() 실행");
	}

	public void methodC() {
		System.out.println("InterfaceCImpl-methodC() 실행");
	}
}