package ch08_인터페이스.ex06_private메서드;

/**
 * private 접근제한자
 *  - 현재 중괄호{} 블록 내에서만 사용! -> 캡슐화!
 * 		
 * 		private 리턴타입 메서드명([매개변수, ...]) {...}
 * 		private static 리턴타입 메서드명([매개변수, ...]) {...}
 *  
 * private 메서드와 private 정적 메서드 사용 용도?
 *  -> 디폴트 메서드와 정적 메서드 내에서 중복 코드를 줄이기 위함! 
 *  
 * 디폴트 메서드
 * 	- private 메서드와 private static 메서드를 모두 호출 가능!
 * 정적 메서드
 *  - private static 메서드만 호출 가능
 *  - private 메서드는 호출 불가
 *  
 */
public interface Service {
	//디폴트 메소드
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속 코드");
		// private 메서드 호출
		defaultCommon();
		// private 정적 메서드 호출
		staticCommon();
	}
	
	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속 코드");
		defaultCommon();
	}

	//private 메소드
	private void defaultCommon() {
		System.out.println("defaultMethod 중복 코드A");
		System.out.println("defaultMethod 중복 코드B");
	}

	//정적 메소드
	static void staticMethod1() {
		System.out.println("staticMethod1 종속 코드");
		// private 메서드 호출
		// Cannot make a static reference to the non-static method 
		// defaultCommon() from the type Service
		// Service 타입의 비정적 메서드 
		// defaultCommon()에 대한 정적 참조를 만들지 마십시오.
		// defaultCommon(); 에러
		// private 정적 메서드 호출
		staticCommon();
	}

	static void staticMethod2() {
		System.out.println("staticMethod2 종속 코드");
		staticCommon();
	}

	//private 정적 메소드
	private static void staticCommon() {
		System.out.println("staticMethod 중복 코드C");
		System.out.println("staticMethod 중복 코드D");
	}
}