package ch08_인터페이스.ex03_추상메서드;

public class RemoteControlMain {

	public static void main(String[] args) {
		// 인터페이스 변수 선언
		RemoteControl rc;
		
		// 객체 할당
		rc = new Television();
		rc.turnOn();
		rc.setVolumn(20);
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolumn(-5);
		rc.turnOff();

	}

}
