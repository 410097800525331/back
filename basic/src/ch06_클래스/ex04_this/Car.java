package ch06_클래스.ex04_this;

/**
 * 참고: 오버라이딩(overriding): 재정의
 * 
 * 생성자 오버로딩(overloading)이 많은 경우
 * 중복된 코드가 발생할 수 있다.
 * -> 공통 코드를 가진 생성자를 작성하고,
 *    다른 생성자는 this(...)를 사용하여 공통 생성자를 호출한다.
 * 
 * 오버로딩? 이름은 같고, 매개변수의 개수, 타입, 순서가 다른 경우! 
 * 1. 생성자 오버로딩
 * 2. 메서드 오버로딩: 
 * 		예) System.out.println(int x)
 * 		예) System.out.println(double x)
 * 		예) System.out.println(String x)
 * 
 * 생성자
 * 1. this - 클래스(객체) 자기 자신
 * 2. this() - 공통 코드를 가진 생성자 호출
 */
public class Car {
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	// 생성자 오버로딩(Overloading)
	// 커서 위치의 한 줄 코드 삭제: ctrl+d (vscode는 ctrl+x)
	Car(String model) {
		
		// this(model)
		// 에러?
		// -> Recursive(재귀) constructor invocation(호출) Car(String)
		// -> 재귀 생성자 호출 -> 자기 자신을 호출
		
		// this(model, color, maxSpeed);
		// 에러?
		// -> Cannot refer to an instance field color 
		//    while explicitly(명시적인) invoking a constructor
		// -> 생성자를 명시적으로 호출하는 동안 
		//    인스턴스 필드의 color 필드를 참조할 수 없습니다.
		
		this(model, "흰색", 250);
		//this.model = model;
	}
	
	Car(String model, String color) {
		this(model, color, 250);
//		this.model = model;
//		this.color = color;
	}

	// 공통 코드를 가진 생성자
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	// alt+shift+s,o: 생성자 대화상자
	
}