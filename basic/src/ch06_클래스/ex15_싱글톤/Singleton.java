package ch06_클래스.ex15_싱글톤;

/**
 * 29.Singleton(싱글톤)?
 * 	- 애플리케이션 전체에서 단 한 개의 객체만 생성해서 사용
 *  - 싱글톤 패턴의 핵심은 생성자를 private 접근 제한하여
 *    외부에서 new 연산자로 생성자를 호출할 수 없도록 막는 것이다.
 */
public class Singleton {
	//private 접근 권한을 갖는 정적 필드 선언과 초기화
	private static Singleton singleton = new Singleton();

	//private 접근 권한을 갖는 생성자 선언
	private Singleton() {
	}

	//public 접근 권한을 갖는 정적 메소드 선언
	public static Singleton getInstance() {
		return singleton;
	}
}