package ch04_제어문;

/**
 * for 문
 * 	- 정해진 횟수만큼 반복할 경우
 * while 문
 * 	- 반복 횟수가 정해지지 않은 경우
 *  - 조건식이 true일 경우 계속 반복
 *  
 *  	while (조건식) {
 *  		실행문;
 *  	}
 */
public class Ex06_While문 {

	public static void main(String[] args) {
		
		// 1~10까지 정수 출력
		int i = 1;
		while (i<=10) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println();
		// 1~100까지 합
		int sum = 0;
		i = 1;
		
		while(i<=100) {
			sum += i;
			i++;
		}

		System.out.println("1~" + (i-1) + " 합 : " + sum);

	}

}
