package ch07_상속.ex01_클래스상속;

/**
 * 상속(Inheritance)?
 * 	- 부모 클래스의 필드와 메서드를 자식 클래스에게 물려주는 것
 * 	- 재사용 -> 개발 시간을 단축
 * 	- 부모 클래스를 수정하면 모든 자식 클래스에 수정 효과를 가져온다.
 *  -> 클래스의 수정을 최소화
 *  
 * 클래스 상속
 * 	- 현실에서의 상속은 부모가 자식을 선택해서 물려주지만,
 *  - 프로그램에서는 자식이 부모를 선택한다.
 *  - 자바는 다중 상속을 허용하지 않는다.
 *  
 *  	[접근제한자] class 자식클래스 extends 부모클래스 {...}	
 */

// 자식 클래스
public class SmartPhone extends Phone {
	// 필드
	boolean wifi;
	
//	String model;
//	String color;
	
	
	// 생성자
	SmartPhone(String model, String color){
		// this.필드 = 매개변수
		// Phone 클래스의 필드를 상속 받아 사용!
		this.model = model;
		this.color = color;
	}
	
	// 메서드
	void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	void internet() {
		System.out.println("인터넷을 연결합니다.");
	}
	
}





