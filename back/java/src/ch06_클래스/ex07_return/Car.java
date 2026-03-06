package ch06_클래스.ex07_return;

/**
 * return문
 * 	- 메서드의 실행을 강제 종료하고, 
 *  - 호출한 곳으로 값을 되돌려 준다.
 *  
 *  	return [값];
 */
public class Car {
	// 필드 선언
	int gas;
	
	// 리턴값이 없는 메서드
	// 리턴 타입: void
	void setGas(int gas) {
		this.gas = gas;
	}
	
	// 리턴값이 있는 메서드
	// 리턴 타입: boolean -> 메서드 이름은 isXXX~ (관례)
	// This method must return a result of type boolean
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			// false를 리턴하고 메서드 종료
			return false;
		}
		System.out.println("gas가 있습니다.");
		// true를 리턴하고 메서드 종료
		return true;
	}
	
	// 리턴값이 없는 메서드
	// 리턴 타입: void
	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다.(gas잔량: " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다.(gas잔량: " + gas + ")");
				return; // 메서드 종료
			}
		}
	}
	
	
}






