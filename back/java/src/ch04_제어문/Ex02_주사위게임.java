package ch04_제어문;

public class Ex02_주사위게임 {

	public static void main(String[] args) {
		// Math.random(): 0이상 1미만의 난수
		// 0 <= Math.random() < 1
		// 0*6 <= Math.random()*6 < 1*6
		// 0 <= Math.random()*6 < 6
		// (int)0.xxx <= (int)Math.random()*6 < (int)6.xxx
		// 0 <= (int)Math.random()*6 < 6
		// 0+1 <= (int)Math.random()*6+1 < 6+1
		// 1 <= (int)Math.random()*6+1 < 7
		
		// 1~6 사이 정수
		int num = (int)(Math.random()*6) + 1;
		
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		} else if(num==2) {	
			System.out.println("2번이 나왔습니다.");
		} else if(num==3) {
			System.out.println("3번이 나왔습니다.");
		} else if(num==4) {
			System.out.println("4번이 나왔습니다.");
		} else if(num==5) {
			System.out.println("5번이 나왔습니다.");
		} else {
			System.out.println("6번이 나왔습니다.");
		}

	}

}
