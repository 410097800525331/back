package ch06_클래스.ex09_정적멤버;

/**
 * 메모리 공간
 * 1. 메서드 영역 - 클래스
 * 2. 힙 영역 - 객체 생성
 * 3. 스택 영역 - 매개변수
 * 
 * 정적 멤버 사용
 * 	- 클래스가 메모리에 로딩되면 정적 멤버를 바로 사용할 수 있다.
 *  - 클래스 이름과 함께 도트(.) 연산자로 접근하면 된다.
 *  - 객체를 생성하여 객체 참조 변수로도 접근 가능하다.
 *  -> 그러나, 정적 요소는 클래스 이름으로 접근하는 것이 좋다.
 *  -> The static method plus(int, int) 
 *     from the type Calculator2 should be accessed in a static way 
 *     (Calculator2 타입의 정적 메서드 plus(int, int)는 정적 방식으로 접근해야 합니다.)
 * 
 * 		클래스명.필드명;
 * 		클래스명.메서드명();
 */
public class CalculatorMain {

	public static void main(String[] args) {
		// 객체 생성
		Calculator myCal = new Calculator();
		
		// 클래스명.필드명;
//		double result1 = 10 * 10 * myCal.pi;
		double result1 = 10 * 10 * Calculator.pi;
		System.out.println("result1: " + result1);

//		int result2 = myCal.add(10, 5);
		int result2 = Calculator.add(10, 5);
		System.out.println("result2: " + result2);
		
		// 참고: 인스턴스 멤버 사용
		System.out.println(Calculator.pi);
//		System.out.println(Calculator.color); X
		System.out.println(myCal.color);
		
//		Calculator.setColor("흰색");
		myCal.setColor("흰색");
		System.out.println(myCal.color);
	}

}
