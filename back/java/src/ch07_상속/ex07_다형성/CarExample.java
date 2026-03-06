package ch07_상속.ex07_다형성;

public class CarExample {
	public static void main(String[] args) {
		//Car 객체 생성
		Car myCar = new Car();

		//Tire 객체 장착
		//Tire tire = new Tire();
		myCar.tire = new Tire();
		myCar.run(); // 회전합니다.

		// 자동 타입 변환
		//HankookTire 객체 장착
		// Tire를 상위 타입으로 선언 -> 다양한 하위 객체 대입 가능 (다형성)
		myCar.tire = new HankookTire();
		myCar.run(); // 한국 타이어가 회전합니다.

		//KumhoTire 객체 장착
		myCar.tire = new KumhoTire();
		myCar.run(); // 금호 타이어가 회전합니다.
	}
}