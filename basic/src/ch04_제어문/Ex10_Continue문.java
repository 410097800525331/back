package ch04_제어문;

/**
 * break 문
 * - 제어문 종료
 * continue(계속)
 */
public class Ex10_Continue문 {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}

	}

}
