package ch06_클래스.ex11_상수;

/**
 * 25.상수(Constant)
 *  - 불변의 값을 저장하는 필드
 *  - 상수는 객체마다 저장할 필요가 없고, 여러 개의 값을 가져도 안 되기 대문에
 *    static 이면서 final(최종)인 특성을 가져야 한다.
 *  - 초깃값은 선언 시 주는 것일 일반적이지만,
 *  - 복잡한 초기화가 필요할 경우에는 정적 블록에서 초기화할 수도 있다.
 *  
 * 상수 이름 정의
 *  - 상수 이름은 모두 대문자로 스네이크 케이스로 작성 (관례)
 *    
 *     	static final 타입 변수 [=초깃값];
 *     
 * Math.PI
 * 	- 자바에서 제공하는 상수
 */
public class Earth {
	// 선언시 초기화
	// 지구 반지름: 6,371km
	// static final 타입 변수 [=초깃값];
	static final double EARTH_RADIUS = 6400;
	// 지구 표면적
	static final double EARTH_SERFACE_AREA;
	
	// 정적 블록에서 초기화
	// 구의 표면적: 4파이r제곱
	static {
		// Cannot make a static reference to the non-static field EARTH_SERFACE_AREA
		EARTH_SERFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
	
}









