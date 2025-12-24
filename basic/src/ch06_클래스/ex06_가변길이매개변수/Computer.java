package ch06_클래스.ex06_가변길이매개변수;

public class Computer {
	
	// Syntax error, insert "}" to complete ClassBody
	// 구문 오류, 클래스 안에 중괄호({})을 삽입하라!
	
	// 합계
	// 1~10까지 합
	
	// This method must return a result of type int
	// 가변길이 매개변수
	// 타입 메서드(타입 ... 매개변수)
	// values는 배열 타입 변수처럼 사용된다.
	// int values = {값, 값, 값, ...}
	int sum(int ... values) {
		int sum = 0;
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}