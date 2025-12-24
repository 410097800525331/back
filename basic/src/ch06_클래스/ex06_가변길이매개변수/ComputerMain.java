package ch06_클래스.ex06_가변길이매개변수;

public class ComputerMain {

	public static void main(String[] args) {
		Computer myComputer = new Computer();
		
		int result1 = myComputer.sum(1, 2, 3);
		int result2 = myComputer.sum(1, 2, 3, 4, 5);
		
		System.out.println("result1: " + result1); // 6
		System.out.println("result2: " + result2); // 15
		
		// 배열을 직접 매개값으로 지정
		int[] values = {10, 20, 30};
		int result3 = myComputer.sum(values);
		System.out.println("result3: " + result3); // 60
		
		// Syntax error on token ".", @ expected after this token
		int result4 = myComputer.sum( new int[] {10, 20, 30, 40, 50});
		System.out.println("result4: " + result4);
		
		
	}

}