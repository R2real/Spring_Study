package test;

import org.springframework.stereotype.Component;

//@Component("appleWatch")
public class AppleWatch implements Watch{
	public AppleWatch() {
		 System.out.println("애플워치 객체 생성");
	}
	public void volumeUp() {
		System.out.println("애플워치를 통해서 소리 ++");
	}
	public void volumeDown() {
		System.out.println("애플워치를 통해서 소리 --");
	}
}
