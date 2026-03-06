package ch09_중첩선언과익명객체.ex06_중첩인터페이스;

/**
 * 중첩 인터페이스
 * 	- 클래스의 멤버로 선언된 인터페이스
 *  - 왜? 클래스와 긴밀한 관계를 맺는 구현 객체를 만들기 위해서
 *  - 중첩 인터페이스는 암시적으로 static이므로
 *    static을 생략해도 객체 생성 없이 사용할 수 있다.
 */
public class Button {	
	//정적 멤버 인터페이스
	// public [static] interface ClickListener {
	public static interface ClickListener {
		//추상 메소드
		void onClick();
	}
	
	//필드
	private ClickListener clickListener;

// private ClickListener clickListener = 
//	new Button.ClickListener() {
//		@Override
//		public void onClick() {
//			System.out.println("Ok 버튼을 클릭했습니다.");
//		}
//	}
	
	
	//메소드
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		this.clickListener.onClick();
	}
}