package ch05_참조타입;
/**
 * 참조 타입은 null 값을 가질 수 있다.
 * 
 * null?
 * 	- 참조 타입 변수가 아직 번지를 저장하고 있지 않다는 뜻!
 * 
 * 예외(Exception)?
 * 	- 프로그램 실행 도중에 발행하는 오류
 * 
 * NullPointerException?
 * 	- 변수가 null인 상태에서 객체의 데이터나 메서드를 사용하려 할 때 발생
 * 
 * JVM(자바 가상 머신)이 쓰레기(Garbage)를 자동으로 처리한다.
 * 
 * 가비지 컬렉션(Garbage Collection, GC)
 * 	- 더 이상 사용되지 않는 메모리 영역을 자동으로 찾아 해제하는 메모리 관리 기법입니다. 
 *    프로그래머가 직접 메모리 할당 및 해제를 관리하는 대신, 
 *    가비지 컬렉터가 유효하지 않은 객체(쓰레기)를 식별하고 제거하여 
 *    메모리 부족을 방지하고 효율적인 시스템 운영을 돕는 자동화된 프로세스입니다. 
 *    자바, 자바스크립트, .NET 등 현대 프로그래밍 언어에서 널리 사용됩니다. 
 */
public class Ex02_null {

	public static void main(String[] args) {
	
		// Exception(예외)
		int[] intArray = null;
		//intArray[0] = 10; //NullPointerException

		String str = null;
		// length() -> 문자열의 개수
		//System.out.println("총 문자 수: " + str.length() ); //NullPointerException
		
		String hobby = "여행";
		hobby = null; // "여행"에 해당하는 String 객체를 쓰레기(Garbage)로 만듦

		String kind1 = "자동차";
		String kind2 = kind1; // kind1 변수에 저장되어 있는 번지를 kind2 변수에 대입
		kind1 = null; // "자동차"에 해당하는 String 객체는 쓰레기가 아님
		System.out.println("kind2: " + kind2);

	}

}
