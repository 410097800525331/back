package ch12_제네릭.ex02_제네릭타입;

public interface Rentable<P> {
	P rent();
}

// 제네릭을 사용하지 않을 경우
interface Rentable2 {
	Home rent();
}

interface Rentable3 {
	Car2 rent();
}