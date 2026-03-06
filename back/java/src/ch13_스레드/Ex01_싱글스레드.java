package ch13_스레드;

import java.awt.Toolkit;

/** 
 * 1. 순차적 실행 (Sequential Execution)
 *  - 싱글 스레드에서는 메인 스레드 하나가 위에서 아래로 코드를 훑으며 내려옵니다. 
 *    따라서 비프음이 울리는 동안에는 "띵"이라는 글자가 화면에 찍히지 않습니다.
 * 2. Thread.sleep(500)
 *  - 500은 밀리초(ms) 단위입니다. 
 *    $1000ms = 1초$이므로, 0.5초마다 한 번씩 작업을 수행하도록 속도를 조절하는 역할을 합니다.
 * 3. 멀티 스레드와의 차이
 *  - 만약 소리와 글자가 동시에 나오게 하고 싶다면, 
 *    별도의 스레드(Thread 또는 Runnable)를 생성하여 비프음 로직을 분리해야 합니다.
 */

/**
 * 메인 스레드가 동시에 두 가지 작업을 처리할 수 없음
 * -> 비프(beep)음을 모두 발생한 다음에 프린팅 
 */
import java.awt.Toolkit; // 비프음 사용을 위한 패키지 임포트

public class Ex01_싱글스레드 {
    // 메인 스레드(Main Thread)가 시작되는 지점
    public static void main(String[] args) {
        
        // 1. 비프음을 발생시키기 위한 Toolkit 객체 생성
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // [첫 번째 작업] 비프음 5번 발생
        for(int i=0; i<5; i++) {
            toolkit.beep(); // 시스템 비프음 재생
            System.out.println("소리가 난다.");
            
            try { 
                // 0.5초(500ms) 동안 현재 스레드(메인 스레드)를 일시 정지
                Thread.sleep(500); 
            } catch(Exception e) {
                // Thread.sleep은 예외 처리가 필수입니다.
            }
        }

        // [두 번째 작업] 콘솔에 "띵" 문자열 5번 출력
        // 싱글 스레드이므로 위쪽의 for문(비프음)이 모두 종료되어야만 아래 코드가 실행됩니다.
        for(int i=0; i<5; i++) {
            System.out.println("띵"); // 콘솔에 출력
            
            try { 
                // 0.5초(500ms) 동안 현재 스레드(메인 스레드)를 일시 정지
                Thread.sleep(500); 
            } catch(Exception e) {
                // 예외 처리
            }
        }
    }
}
