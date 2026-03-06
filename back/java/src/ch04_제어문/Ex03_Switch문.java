package ch04_제어문;

/**
 * 조건문
 * 	1. if문
 * 	 - 조건식의 결과가 true, false 두 가지인 경우
 *   - 경우의 수가 많을 수록 else if를 반복적으로 추가
 *   -> 코드가 복잡해 질 수 있다.
 *  2. switch문
 *   - 변수의 값에 따라서 실행문이 결정
 *   -> 경우의 수가 많을 수록 if문 보다 코드가 간결해 진다.
 *   - break를 만나면 switch를 빠져나감!
 *   
 *   	switch (변수) {
 *   		case 값1:
 *   			실행문1;
 *   			break;
 *   		case 값2:
 *   			실행문2;
 *   			break;
 *   		case 값3:
 *   			실행문3;
 *   			break;
 *  		...
 *  		[default:
 *  			실행문n;]
 *      }
 */
public class Ex03_Switch문 {

	public static void main(String[] args) {
		int num = (int)(Math.random()*6) + 1;
		
		switch(num) {
			case 1:
				System.out.println("1번이 나왔습니다.");
				break;
			case 2:
				System.out.println("2번이 나왔습니다.");
				break;
			case 3:
				System.out.println("3번이 나왔습니다.");
				break;
			case 4:
				System.out.println("4번이 나왔습니다.");
				break;
			case 5:
				System.out.println("5번이 나왔습니다.");
				break;
			default:
				System.out.println("6번이 나왔습니다.");
		}
		
		// no break
		int time = (int)(Math.random()*4) + 8;  
		System.out.println("[현재시간: " + time + " 시]");
		
		switch(time) {
			case 8:
				System.out.println("출근합니다.");
			case 9:
				System.out.println("회의를 합니다.");
			case 10:
				System.out.println("업무를 봅니다.");
			default:
				System.out.println("외근을 나갑니다.");
		}
		
		// 두 개이상의 case를 같은 실행문을 적용
		char grade = 'B';
		
		switch(grade) {
			case 'A':
			case 'a':
				System.out.println("우수 회원입니다.");
				break;
			case 'B':
			case 'b':
				System.out.println("일반 회원입니다.");
				break;							
			default:
				System.out.println("손님입니다.");
		}
		
		
		// Java 12 이후
		// switch 문에서 표현식(expressions)을 사용할 수 있다.
		// -> break 대신 화살표(->)와 중괄호({}) 사용! 
		switch(grade) {
			case 'A', 'a' -> {
				System.out.println("우수 회원입니다.");
			}
			case 'B', 'b' -> {
				System.out.println("일반 회원입니다.");
			}						
			default -> {
				System.out.println("손님입니다.");
			}
		}

		// 실행문이 하나이면 중괄호 생략 가능!
		switch(grade) {
			case 'A', 'a' -> System.out.println("우수 회원입니다.");
			case 'B', 'b' -> System.out.println("일반 회원입니다.");						
			default -> System.out.println("손님입니다.");
		}
		
		
		//String grade = "B";
		
		//Java 11 이전 문법
		int score1 = 0;
		switch(grade) {
		    case 'A':
		    	score1 = 100;
		    	break;
		    case 'B':
		    	int result = 100 - 20;
		    	score1 = result;
		    	break;
		    default:
		    	score1 = 60;
		}
		System.out.println("score1: " + score1);
		
		//Java 12부터 가능
		// switch 결과를 변수에 대입
		// switch expressions을 사용하면 switch된 값을 변수에 대입할 수 있다.
		//  - 단일 값일 경우에는 화살표 오른쪽에 값을 기술하고,
		//  - 중괄호를 사용할 경우에는 yeild 키워드로 값을 지정한다.
		//  - 단, 이 경우에는 default가 반드시 존재해야 한다.
		int score2 = switch(grade) {
			case 'A' -> 100;
			case 'B' -> {
				int result = 100 - 20;
				//Java 13부터 가능
				yield result;
			}
			default -> 60;
		};
		System.out.println("score2: " + score2);

	}

}
