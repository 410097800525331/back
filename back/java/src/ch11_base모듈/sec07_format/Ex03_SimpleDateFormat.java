package ch11_base모듈.sec07_format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class Ex03_SimpleDateFormat {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// getTime(): Calendar 객체를 Data 객체로 변환
		System.out.println( sdf.format(now.getTime()) );

		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println( sdf.format(now.getTime()) );

		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println( sdf.format(now.getTime()) );

		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println( sdf.format(now.getTime()) );

		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println( sdf.format(now.getTime()) );

		sdf = new SimpleDateFormat("이달의 d번째 날");
		System.out.println( sdf.format(now.getTime()) );
	}
}