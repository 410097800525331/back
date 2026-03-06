package ch07_상속.ex01_클래스상속;

// 부모 클래스
class Phone {
	// 필드 선언
	String model;
	String color;
	
	// 메서드 선언
	void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	void sendVoice(String message) {
		System.out.println("나: " + message);
	}
	
	void receiveVoice(String message) {
		System.out.println("너: " + message);
	}
	
	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
