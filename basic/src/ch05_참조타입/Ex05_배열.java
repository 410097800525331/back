package ch05_참조타입;
/**
 * 데이터 타입
 * 	1. 기본 타입
 * 		- 정수 타입: byte, char, short, int, long
 * 		- 실수 타입: float, double
 * 		- 논리 타입: boolean
 * 
 *  2. 참조(객체) 타입
 *  	- 배열(array) 타입: []
 *      - 문자열 타입: String
 *  	- 열거(enum) 타입
 *  	- 클래스(class) 타입
 *  	- 인터페이스(interface) 타입
 *   *  
 *  기본 타입 - 값 자체 저장
 *  	예) int num = 3;
 *  참조 타입 - 번지(주소) 저장
 *  	예) int[] nums = new int[] {1,2,3}
 *  
 *  참조 타입은 null 값을 가질 수 있다. -> 참조하는 주소 값이 없다.
 */
public class Ex01_배열 {

	// args는 String 타입의 배열 변수
	public static void main(String[] args) {
	
		// int 타입의 배열 선언
		// int[] 변수; 또는 int 변수[];
		int[] arr1;
		int[] arr3;

		// 배열 할당 - 리터럴 방식
		arr1 = new int[] { 1, 2, 3 }; 

		// 선언 및 할당
		int[] arr2 = new int[] { 1, 2, 3 };
		arr2[0] = 10;
		
		arr3 = arr2; 
		
		System.out.println(arr1 == arr2); // false
		System.out.println(arr2 == arr3); // true
		
		// Exception(예외)
		int[] intArray = null;
		//intArray[0] = 10; //NullPointerException

		String str = null;
		// length() -> 문자열의 개수
		//System.out.println("총 문자 수: " + str.length() ); //NullPointerException

	}

}