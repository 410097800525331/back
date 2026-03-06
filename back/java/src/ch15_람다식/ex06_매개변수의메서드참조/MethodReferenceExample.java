package ch15_람다식.ex06_매개변수의메서드참조;

/**
 * 매개변수의 메서드 참조
 *  	: a 매개변수의 메서드를 호출해서 b 매개변수를 매개값으로 사용하는 경우
 *  
 *  	(a, b) -> {a.staticMethod(b);}
 *  	클래스 :: staticMethod
 * 
 */
public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		person.ordering(
			//(a, b) -> {return a.compareToIgnoreCase(b);}
			(a, b) -> a.compareToIgnoreCase(b)
		);
		person.ordering(String :: compareToIgnoreCase);
	}
}