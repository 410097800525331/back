package ch08_인터페이스.ex01_인터페이스;

/**
 * 인터페이스(Interface)?
 *  - 서로 다른 두 개 이상의 시스템, 장치, 또는 소프트웨어 구성 요소가 
 *    정보를 주고받을 수 있도록 하는 접점이나 규격을 의미하며, 
 *    사용자와 기기 사이의 소통 창구(UI), 프로그램 간의 통신 규칙(API), 
 *    또는 프로그래밍 언어에서의 추상적인 약속(클래스 구현) 등 
 *    다양한 맥락에서 쓰이는 범용적인 개념입니다.
 *    
 * 인터페이스(interface)
 *  - 클래스가 반드시 구현해야 하는 메서드의 규약(Contract)
 *  - 몸체가 없는 메서드만 선언하고({}괄호 없다), 
 *    실제 구현은 implements(구현)한 클래스에서 정의
 * 	- 다형성 구현에 주된 기술
 * 
 * 인터페이스 선언
 * 	- interface 키워드를 사용한다.
 *  - 접근제한자는 public 또는 default -> 클래스와 같다.
 *  
 *  	[public] interface 인터페이스명 {
 *  		// public 상수 필드
 *  		// public 추상 메서드
 *  
 *  		// Java 8+
 *  		// public 디폴트 메서드
 *  		// public 정적 메서드
 *  
 *  		// Java 9+
 *  		// private 메서드
 *  		// private 정적 메서드
 *
 * 		}
 * 
 */
public interface RemoteControl {
	//public 추상(abstract) 메소드? body가 없는 메서드
	// Abstract methods do not specify(지정하다) a body
	public void turnOn();
}




