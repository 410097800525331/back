package ch07_상속.ex02_부모생성자호출;

/**
 * super()
 * 	- 부모의 기본 생성자 호출
 *  - 컴파일 과정에서 자동 추가된다.
 *
 * 1. 부모의 기본 생성자가 있는 경우
 *  - 자식 생성자에서 super() 생략 가능
 *
 * 2. 부모 클래스에 기본 생성자가 없고, 매개변수를 갖는 생성자만 있는 경우
 *  - super(매개값,...) 코드를 직접 지정해야 한다.
 *  - 자식 생성자의 맨 첫 줄에서만 사용 가능!
 *
 *  	// 자식 생성자
 *  	public 자식클래스() {
 *  		super(매개값, ...);
 *  	}
 */
public class SmartPhone extends Phone {
	
	// 기본 생성자
	SmartPhone() {
		super();
		System.out.println("SmartPhone 기본 생성자가 실행됨!");
	}
	
	// 매개변수가 있는 생성자
	SmartPhone(String model, String color){
		// super()
		// - 부모 생성자를 호출한다.
		// - 없을 경우 자동 생성된다.
		// - 직접 기록할 경우 생성자의 첫 줄에 기록한다.
		super(model, color);
		this.model = model;
		this.color = color;
		// Constructor call must be the first statement in a constructor
		// this.필드 = 매개변수
		// Phone 클래스의 필드를 상속 받아 사용!
		System.out.println("SmartPhone 매개변수 생성자가 실행됨!");
	}


	
}