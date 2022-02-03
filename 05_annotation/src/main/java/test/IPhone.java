package test;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("iPhone") // == <bean class="" id=""> 등록과 같은 설정!! //IPhone ip = new IPhone(); => 기본 생성자 존재해야함!
public class IPhone implements Phone{
	
	@Resource(name="appleWatch")
	private Watch watch; //IoC가 구현된 코드!
	
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	
	public IPhone() {
		System.out.println("아이폰 생성자1");
	}
	
//  DI를 생성자를 통해 주입
//	public IPhone(Watch watch, String uname) {
//		System.out.println("아이폰 생성자2");
//		this.watch=watch;
//		this.uname=uname;
//		System.out.println(this.uname);
//	}
//	
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	public void msg() {
		System.out.println("아이폰 문자보내기");
	}
}

