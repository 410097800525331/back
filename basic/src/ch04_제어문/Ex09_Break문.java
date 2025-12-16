package ch04_제어문;


/**
 * break문
 * - 제어문(switch, for, while, do~while)을 탈출
 * - 제어문이 중첩 되어있을 경우 가장 가까운 제어문 탈출
 */
public class Ex09_Break문 {

	public static void main(String[] args) {
		while(true) {
			// 1~6 사이 정수
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			// 1줄 실행문 -> 중괄호 생략 가능
			if(num == 6) {
				break;
			}
		}
		System.out.println("프로그램 종료");

	}

}
