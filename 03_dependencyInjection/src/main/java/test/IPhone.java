package test;

public class IPhone implements Phone{
	
	private Watch watch;
	private String uname;
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

