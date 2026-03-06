package ch07_상속.ex09_추상클래스;
/**
 * 추상(抽象)? 어떤 대상의 본질적인 특징이나 공통된 속성을 뽑아내어 파악하는 행위
 *  -> 예) 새, 곤충, 물고기 등의 공통점은 동물
 *  
 * 클래스(class)
 *  1. 실체 클래스
 *    - 객체를 생성할 수 있는 클래스
 *  2. 추상 클래스(abstract class)
 *    - 실체 클래스들의 공통적인 필드나 메서드를 추출해서 선언한 클래스
 *    - 클래스 선언 시 abstract 키워드를 사용한다.
 *    - 실체 클래스의 부모 역할을 한다.
 *    - new 연산자를 이용해서 객체를 직접 만들지 못하고, 
 *    	상속을 통해 자식 클래스에서 만들 수 있다.
 *    - 자식 객체가 생성될 때 super()로 추상 클래스의 생성자가 호출되기 때문에 
 *      생성자도 반드시 있어야 한다.
 *    		
 * 		[접근제한자] abstract class 클래스명 {
 * 			// 필드
 * 			// 생성자
 * 			// 메서드
 * 		}
 * 
 */
public abstract class Phone {
	//필드 선언
	String owner;
	
	// Cannot instantiate(인스턴스화) the type Phone
	// Phone 타입의 인스턴스를 생성할 수 없습니다.
	// Phone phone = new Phone("홍길동");

	//생성자 선언
	Phone(String owner) {
		this.owner = owner;
	}

	//메소드 선언
	void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}