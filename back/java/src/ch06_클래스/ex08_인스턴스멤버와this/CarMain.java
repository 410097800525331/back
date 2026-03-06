package ch06_클래스.ex08_인스턴스멤버와this;

public class CarMain {

	public static void main(String[] args) {
		// 객체 생성
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		// 메서드 호출
		myCar.run();
		yourCar.run();
		
		// 필드 사용
		System.out.println(myCar.model);
		System.out.println(yourCar.model);

	}

}
