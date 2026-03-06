package ch11_base모듈.sec01_Object.ex01_equals메서드;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	// Member obj1 = new Member("blue");
	// Member obj2 = new Member("blue");
	// Member obj3 = new Member("red");
	// obj1.equals(obj3)
	@Override
	public boolean equals(Object obj) {
		// if(obj instanceof Member)
		// Member target = (Member) obj
		if(obj instanceof Member target) {
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	} // equals 끝
}