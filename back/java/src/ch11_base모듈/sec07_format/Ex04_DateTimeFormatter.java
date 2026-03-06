package ch11_base모듈.sec07_format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * java.time.LocalDateTime & java.time.format.DateTimeFormatter
 * - Java 8부터 도입된 현대적인 날짜/시간 API
 */
public class Ex04_DateTimeFormatter {
    public static void main(String[] args) {
        // 1. 현재 날짜와 시간 가져오기 (Calendar.getInstance() 대체)
        LocalDateTime now = LocalDateTime.now();

        // 2. DateTimeFormatter를 사용하여 형식 지정
        // format() 메서드에 formatter를 직접 전달합니다.
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(dtf));

        dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        System.out.println(now.format(dtf));

        dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println(now.format(dtf));

        dtf = DateTimeFormatter.ofPattern("오늘은 E요일");
        System.out.println(now.format(dtf));

        // D: 올해의 몇 번째 날
        dtf = DateTimeFormatter.ofPattern("올해의 D번째 날");
        System.out.println(now.format(dtf));

        // d: 이달의 몇 번째 날
        dtf = DateTimeFormatter.ofPattern("이달의 d번째 날");
        System.out.println(now.format(dtf));
    }
}