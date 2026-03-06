package ch16_스트림.ex04_리소스로부터스트림얻기;

import java.util.stream.IntStream;
/**
 * 숫자 범위로부터 스트림 얻기
 * 	- IntStream 또는 LongStream의 정적 메서드로
 * 	  특정 범위의 정수 스트림을 얻을 수 있다.
 * 	  	- range(시작수, 끝수): 끝 수를 포함하지 않는다.
 *		- rangeClosed(시작수, 끝수): 끝 수를 포함
 *   
 */
public class 숫자범위스트림 {
	public static int sum;

	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
	}
}