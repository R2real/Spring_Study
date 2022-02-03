package test;

import org.springframework.stereotype.Component;

@Component("smartWatch")
public class SmartWatch implements Watch{

	public SmartWatch() {
		 System.out.println("스마트워치 객체 생성");
	}
	public void volumeUp() {
		System.out.println("스마트워치를 통해서 소리 ++");
	}
	public void volumeDown() {
		System.out.println("스마트워치를 통해서 소리 --");
	}
}