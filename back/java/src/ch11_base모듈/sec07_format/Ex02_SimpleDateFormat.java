package ch11_base모듈.sec07_format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * java.text.SimpleDateFormat
 *  - 날짜를 형식화된 문자열로 변환
 * 
 * 패턴 문자
 *  y: 년
 *  M: 월
 *  d: 일
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
public class Ex02_SimpleDateFormat {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		
		int year = now.get(Calendar.YEAR); // 년도
		int month = now.get(Calendar.MONTH) + 1; // 월
		int day = now.get(Calendar.DAY_OF_MONTH); // 일
		int day2 = now.get(Calendar.DATE); // 일
		int week = now.get(Calendar.DAY_OF_WEEK); // 요일
		int amPm = now.get(Calendar.AM_PM); // 오전/오후
		int hour = now.get(Calendar.HOUR); // 시
		int minute = now.get(Calendar.MINUTE); // 분
		int second = now.get(Calendar.SECOND); // 초
		
		String strAmPm = null;
		if(amPm == 0) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		String strWeek = null;
		switch(week) {
			case 2: 	strWeek = "월"; break;
			case 3: 	strWeek = "화"; break;
			case 4: 	strWeek = "수"; break;
			case 5: 	strWeek = "목"; break;
			case 6: 	strWeek = "금"; break;
			case 7: 	strWeek = "토"; break;
			default: 	strWeek = "일";
		}

		System.out.println( year + "-" + month + "-" + day );
		System.out.println( year + "년 " + month + "월 " + day + "일" );
		System.out.println( year + "." + month + "." + day + " " + strAmPm + " " + hour + ":" + minute + ":" + second);
		System.out.println( "오늘은 " + strWeek + "요일");
		System.out.println( "이달의 " + day2 + "번째 날");
		System.out.println( "이달의 " + day + "번째 날");

	}
}