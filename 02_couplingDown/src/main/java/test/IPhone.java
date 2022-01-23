package test;

public class IPhone implements Phone{
	public void volumeUp() {
		System.out.println("아이폰 소리 ++");
	}
	public void volumeDown() {
		System.out.println("아이폰 소리 --");
	}
	public void msg() {
		System.out.println("아이폰 문자보내");
	}
	
	public void initMethod() {
		System.out.println("아이폰을 초기화 할때 작업이 들어가는 메서드");
	}
	public void destroyMethod() {
		System.out.println("아이폰 객체가 삭제될때 처리할 작업이 들어가는 메서드");
	}
	
}

