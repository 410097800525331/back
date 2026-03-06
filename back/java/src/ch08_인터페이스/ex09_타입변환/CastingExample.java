package ch08_인터페이스.ex09_타입변환;

public class CastingExample {
	public static void main(String[] args) {
		// 인터페이스 변수에 구현 객체 대입
		// 자동 타입 변환
		Vehicle vehicle = new Bus();

		// 인터페이스를 통해서 호출
		vehicle.run();
		//vehicle.checkFare(); (x)

		// 강제 타입 변환후 호출
		// Type mismatch: cannot convert from Vehicle to Bus
//		Bus bus = vehicle; 
		Bus bus = (Bus) vehicle; 
		bus.run();
		bus.checkFare();
	}
}