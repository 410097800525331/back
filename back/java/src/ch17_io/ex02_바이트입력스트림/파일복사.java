package ch17_io.ex02_바이트입력스트림;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 파일 복사
 *  - FileInputStream에서 읽은 바이트를 FileOutputStream으로 출력하는 것이다. 
 */
// 임의의 그림 파일을 하나 준비해 파일 이름을 test.png로 변경한 다음 C:/Temp 폴더에 저장한다.
public class 파일복사 {
	public static void main(String[] args) throws Exception {
		// 이미지는 28KB
		String originalFileName = "D:/wi/git/back/basic/src/ch17_입출력/temp/test.jpg";
		String targetFileName = "D:/wi/git/back/basic/src/ch17_입출력/temp/test2.jpg";
		
		// 1. 입출력 스트림 생성
		InputStream is = new FileInputStream(originalFileName);
		OutputStream os = new FileOutputStream(targetFileName);
		
//		// 배열 생성 - 읽은 바이트를 1024B(=1KB)씩 저장
//		byte[] data = new byte[1024];
//		while(true) {
//			// 최대 1024 바이트를 읽고, 배열에 저장, 읽은 바이트는 리턴
//			int num = is.read(data);
//			// 파일을 다 읽으면 while 문 종료
//			if(num == -1) break;
//			// 읽은 바이트 수 만큼 출력
//			os.write(data, 0, num);
//		}
		
		// 입력스트림.transferTo(출력스트림)
		// - Java 9부터 입력 스트림에서 출력 스트림으로 바이트 복사
		is.transferTo(os);
		
		// 내부 버퍼 잔류 바이트를 출력하고 버퍼를 비움
		os.flush();
		os.close();
		is.close();
		
		System.out.println("복사가 잘 되었습니다.");
	}
}