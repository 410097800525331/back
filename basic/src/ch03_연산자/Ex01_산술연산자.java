package ch03_연산자;

/**
 * 산술연산자
 * 		+	덧셈, 부호(양수), 문자열 결합
 * 		-	뺄셈, 부호(음수)
 * 		*	곱셈
 *		/	나눗셈
 *		%	나머지
 *		++	1씩 증가
 *		--	1씩 감소
 *	1. int 타입보다 작은 타입(byte, short, char)은 
 *	   연산 시 int 타입으로 자동 변환되어 연산
 *	2. 그 외는 연산에 사용된 가장 큰 타입으로 자동 변환되어 연산
 *		예) byte + int + long + double -> 모두 double으로 변환
 *		예) byte + int + float -> 모두 float으로 변환
 *		예) byte + int + long -> 모두 long으로 변환
 *		예) byte + short -> 모두 int로 변환
 */
public class Ex01_산술연산자 {

	public static void main(String[] args) {
		// 부호 연산
		System.out.println("부호 연산 ------------------------");
		int x = -100;
		x = -x;
		
		byte b = 100;
		// byte의 유효 범위: -128~127
		// 연산 시 byte, short, char 타입의 경우 int로 바뀐다.
		// 64 + 32 + 4 = 100
		// 64 32 16 8 4 2 1
		//  1  1  0 0 1 0 0
		// 01100100
		// 강제 타입 변환: 큰 -> 작은
		byte y = (byte)-b;
		// 00000000 00000000 00000000 01100100
		int y2 = -b;
		
		System.out.println("x: " + x); // 100
		System.out.println("y: " + y); // -100
		System.out.println("y2: " + y2); // -100
		
		System.out.println();
		System.out.println("증감 연산 ------------------------");
		// 재할당⭕, 재선언❌❌
		x = 10;
		int y3 = 10;
		int z;
		
		x++; // 후위 연산(Postfix), 11
		++x; // 전위 연산(Prefix), 12
		System.out.println("x=" + x); // 12	

		y3--; // 후위 연산, 9
		--y3; // 전위 연산, 8
		System.out.println("y3=" + y3); // 8

		// z에 x를 할당 후, x를 1증가
		z = x++;
		System.out.println("z=" + z); // 12
		System.out.println("x=" + x); // 13
		
		// x를 1증가 후, 증가된 x를 z에 할당
		z = ++x;
		System.out.println("z=" + z); // 14 
		System.out.println("x=" + x); // 14
		
		// 1. x를 1증가 -> 15
		// 2. x와 y3를 더함 -> 15 + 8 -> 23
		// 3. z에 할당 -> 23
		// 4. y3가 1증가 -> 9
		z = ++x + y3++;
		System.out.println("z=" + z); // 23
		System.out.println("x=" + x); // 15
		System.out.println("y3=" + y3); // 9
		
		System.out.println();
		System.out.println("산술 연산 ------------------------");
		byte v1 = 10;
		byte v2 = 4;
		int v3 = 5;
		long v4 = 10L;
		
		//byte, short, char 피연산자는 int 타입으로 자동 변환 후 연산
		int result1 = v1 + v2; // 10 + 4		
		System.out.println("result1: " + result1); // 14
		
		//모든 피연산자는 long 타입으로 자동 변환 후 연산
		// -> 연산에 사용된 가장 큰 타입으로 변환
		long result2 = v1 + v2 - v4; // 10L + 4L - 10L 	
		System.out.println("result2: " + result2); // 4
		
		//double 타입으로 강제 변환 후 연산
		double result3 = (double) v1 / v2;	// 10.0 / 4
		System.out.println("result3: " + result3); // 2.5
		
		
		
		int result4 = v1 % v2; // 10 / 4
		System.out.println("result4: " + result4); // 2
		
		
		System.out.println();
		System.out.println("오버플로우/언더플로우 ------------------------");
		// 오버플로우(Overflow)
		byte var1 = 125; // -128~127
		for(int i=0; i<5; i++) { //{ }를 5번 반복 실행
			//++ 연산은 var1의 값을 1 증가시킨다.
			var1++; // 126 -> 127 -> -128 -> -127 -> -126
			System.out.println("var1: " + var1);
		}

		System.out.println("-----------------------");

		// 언더플로우(Underflow)
		byte var2 = -125;
		for(int i=0; i<5; i++) { //{ }를 5번 반복 실행
			//-- 연산은 var2의 값을 1 감소시킨다.
			var2--; // -126 -> -127 -> -128 -> 127 -> 126
			System.out.println("var2: " + var2);
		}
		
		// 오버플로우
		int a = 1000000; // +-2,100,000,000
		int b2 = 1000000;
		int c = a * b2; // 1,000,000,000,000
		System.out.println(c); // -727379968
		
		// long 타입
		long a1 = 1000000;
		long b3 = 1000000;
		long c2 = a1 * b3;
		System.out.println(c2); // 1000000000000
		
		System.out.println();
		System.out.println("정확한 계산 ------------------------");
		// 정확한 계산
		// 부동 소수점 방식을 사용하는 실수 타입에서는
		// 결과 값이 정확이 0.3이 되지 않는다. -> 정수 타입을 사용!
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		// 1.0 - 7.0 * 0.1 -> 1.0 - 0.7 -> 0.3
		double result = apple - number*pieceUnit;
		// 0.29999999999999993
		System.out.println("사과 1개에서 남은 양: " + result); 
		
		// 1 * 10 -> 10
		int totalPieces = apple * 10;
		// 10 - 7 -> 3
		int result5 = totalPieces - number; 
		System.out.println("10조각에서 남은 조각: " + result5);
		// 3 / 10.0 -> 0.3
		System.out.println("사과 1개에서 남은 양: " + result5/10.0);

		
		System.out.println();
		System.out.println("Infinity & NaN ------------------------");
		int o = 5;
		double p = 0.0;
		//잘못된 코드
		double q = o / p;
		System.out.println(q); // Infinity(무한대)	
		System.out.println(q + 2); // Infinity
		
		q = o % p;
		System.out.println(q); // NaN(Not a Number)
		System.out.println(q + 2); // NaN
		
		
		//알맞은 코드
		// Double.isInfinite(값)
		// 	-> 값이 Infinity이면 true, 아니면 false
		// Double.isNaN(값)
		// 	-> 값이 NaN이면 true, 아니면 false
		if(Double.isInfinite(q) || Double.isNaN(q)) { 
			System.out.println("값 산출 불가"); 
		} else { 
			System.out.println(q + 2); 
		}

	}
}