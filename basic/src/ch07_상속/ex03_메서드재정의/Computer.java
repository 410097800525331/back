package ch07_상속.ex03_메서드재정의;

/**
 * 자식 클래스: Computer
 * 부모 클래스: Calculator
 */
public class Computer extends Calculator {
	// 메서드 오버라이딩
	// @애노테이션
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}