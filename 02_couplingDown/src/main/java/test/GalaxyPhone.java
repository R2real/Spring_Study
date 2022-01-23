package test;

public class GalaxyPhone implements Phone{
	public void volumeUp() {
		System.out.println("겔럭시 소리 ++");
	}
	public void volumeDown() {
		System.out.println("겔럭시 소리 --");
	}
	public void msg() {
		System.out.println("겔럭시 문자보내기");
	}
}
