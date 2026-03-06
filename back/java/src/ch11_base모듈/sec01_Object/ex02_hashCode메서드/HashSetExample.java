package ch11_base모듈.sec01_Object.ex02_hashCode메서드;

import java.util.HashSet;
/**
 * Set은 동등 객체를 중복 저장하지 않는다.
 * 	예) Hashset
 * hashcode()와 equals() 메서드를 이용해서 동등 객체인지 판단한다.
 */
// ctrl+shift+o: 자동 임포트
public class HashSetExample {
	public static void main(String[] args) {
		HashSet hashSet = new HashSet();

		// add(): 객체 삽입
		Student s1 = new Student(1, "홍길동");
		hashSet.add(s1);
		// size(): 객체 수
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s2 = new Student(1, "홍길동");
		hashSet.add(s2); // 동등 객체는 저장되지 않는다.
		System.out.println("저장된 객체 수: " + hashSet.size());

		Student s3 = new Student(2, "홍길동");
		hashSet.add(s3); // s3는 s1과 동등객체가 아니므로 저장된다.
		System.out.println("저장된 객체 수: " + hashSet.size());
		System.out.println("hashSet: " + hashSet);
	}
}