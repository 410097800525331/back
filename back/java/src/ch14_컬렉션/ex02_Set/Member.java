package ch14_컬렉션.ex02_Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Member {
	private String name;
	private int age;

//	public Member(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//				
//	//hashCode 재정의
//	@Override
//	public int hashCode() {
//		return name.hashCode() + age;
//	}
//
//	//equals 재정의
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Member target) {
//			return target.name.equals(name) && (target.age==age) ;
//		} else {
//			return false;
//		}
//	}
}