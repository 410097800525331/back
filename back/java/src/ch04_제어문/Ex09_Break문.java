package ch04_제어문;
/**
 * break 문
 * 	- 제어문(switch, for, while, do~while)을 탈출!
 *  - 제어문이 중첩 되어있을 경우 가장 가까운 제어문을 탈출!
 */
public class Ex09_Break문 {

	public static void main(String[] args) {
		int count = 0;
		while (count < 3) {
			while(true) {
				// 1~6 사이 정수
				int num = (int)(Math.random()*6) + 1;
				System.out.println(num);
				// 1줄 실행문 -> 중괄호 생략 가능
				if(num == 6) break;
			}
			count++;
			System.out.println("count: " + count);
		}
		
		System.out.println("프로그램 종료");
		
		// break 라벨(label);
		//  - 라벨이 일치하는 제어문 종료
		Outter: for(char upper='A'; upper<='Z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower=='g') {
					break Outter;
				}
			}
		}
		System.out.println("프로그램 실행 종료");

	}

}
