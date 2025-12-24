package ch06_클래스.ex14_게터세터;

public class CarMain {

	public static void main(String[] args) {
		Car myCar = new Car();
				
		// 음수로 입력하면 세터 메서드에서 0으로 처리
		myCar.setSpeed(-50);
		int result = myCar.getSpeed();
		System.out.println("현재 속도는 " + result + "km입니다.");
		
		myCar.setSpeed(50);
		result = myCar.getSpeed();
		System.out.println("현재 속도는 " + result + "km입니다.");
		
		// 멈춤
		if (!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("현재 속도는 " + myCar.getSpeed());

		
	}

}