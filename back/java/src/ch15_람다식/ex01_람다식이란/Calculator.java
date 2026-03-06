package ch15_람다식.ex01_람다식이란;

public class Calculator implements Calculable {

	@Override
	public void calculate(int x, int y) {
		int result = x + y;
		System.out.println("result1: " + result);
	}
	
}
