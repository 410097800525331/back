package ch08_인터페이스.ex03_추상메서드;

/**
 * 구현 클래스
 * 	- 인터페이스의 추상 메서드를 반드시 재정의 해야한다.
 * 
 * 		[접근제한자] class 클래스명 implements 인터페이스명 {...}
 */
// RemoteControl 인터페이스를 구현한 Television 클래스
public class Television implements RemoteControl {
	// 필드
	private int volume;

	// 메서드
	@Override
	public void turnOn() {
		System.out.println("Television를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Television를 끕니다.");
	}

	@Override
	public void setVolumn(int volume) {
		if (volume > RemoteControl.MAX_VOLUMN) {
			this.volume = RemoteControl.MAX_VOLUMN;
		} else if (volume < RemoteControl.MIN_VOLUMN) {
			this.volume = RemoteControl.MIN_VOLUMN;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 볼륨은 " + this.volume + "이다.");
	}

}
