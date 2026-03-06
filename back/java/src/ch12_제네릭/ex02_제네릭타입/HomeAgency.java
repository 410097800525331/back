package ch12_제네릭.ex02_제네릭타입;

public class HomeAgency implements Rentable<Home> {
	@Override
	public Home rent() {
		return new Home();
	}
}

class HomeAgency2 implements Rentable2 {
	@Override
	public Home rent() {
		return new Home();
	}
}