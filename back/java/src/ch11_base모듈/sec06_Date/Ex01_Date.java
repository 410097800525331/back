package ch11_base모듈.sec06_Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date
 * 	- 날짜를 표현하는 클래스로 객체 간에 날짜 정보를 주고받을 때 사용된다.
 * 
 * 		// 생성자
 * 		Date(): 컴퓨터의 현재 날짜를 읽어 Date 객체로 만든다.
 * 
 *  
 * java.util.Calendar
 * 	- 다양한 시간대별로 날짜와 시간을 얻을 때 사용
 * java.time.LocalDateTime 
 * 	- 날짜와 시간을 조작할 때 사용
 * java.text.SimpleDateFormat
 * 
 */
/**
 * java.text.SimpleDateFormat
 *  - 날짜를 형식화된 문자열로 변환
 * 
 * shift+alt+a: 다중 커서
 * 패턴 문자(대소문자 구별함!)
 *  y: 년
 *  M: 월	
 *  d: 일(1~31)
 *  D: 월 구분이 없는 일(1~365)
 *  E: 요일
 *  a: 오전/오후
 *  w: 년의 몇 번째 주
 *  W: 월의 몇 번째 주
 *  H: 시(0~23)
 *  h: 시(1~12)
 *  K: 시(0~11)
 *  k: 시(1~24)
 *  m: 분
 *  s: 초
 *  S: 밀리세컨드(1/1000초)
 *    
 */

public class Ex01_Date {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		String strNow1 = now.toString();
		System.out.println(strNow1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 w번째 주 a hh:mm:ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}
}