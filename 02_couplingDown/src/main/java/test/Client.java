package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//스프링을 설치 했기때문에 사용 가능

public class Client {
	public static void main(String[] args) {

//		 IPhone iphone = new IPhone();  // new 연산자가 Client 코드 내에 직접적으로 들어가있음. == 결합도가 높다고 판단
//		 							    //  사용자가 아이폰을 사용하다가 겔럭시 폰으로 바꾸고 싶어서 바꿨을때,
//		 								//  GalaxyPhone phone = new GalaxyPhone(); 을 해줘도 메서드 명도 다 다르기 때문에 직접 메서드명도 수정을 해줘야함 == 결합도가 높은 코드
//		 iphone.volumeUp();
//		 iphone.msg();
//		

//		
//		//코드의 핵심 1  == 결합도 낮추는 방법
//		//1.설계 : 다형성(상속,오버라이딩 강제) : Phone 이라는 인터페이스 생성
//		Phone phone = new IPhone();
//		phone.volumeDown();
//		phone.msg();
//
//		 factory = new BeanFactory(); 
//		Phone phone = (Phone)factory.getBean(args[0]);
//		phone.volumeUp();
//		phone.msg();
//
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
//		Phone phone = (Phone)factory.getBean("iphone");//init-method 실행 됨.	
//		phone.volumeDown();
//		phone.volumeUp();
//		phone.msg();
//	
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		Phone p1 = (Phone) factory.getBean("galaxyPhone");
		Phone p2 = (Phone) factory.getBean("galaxyPhone");
		Phone p3 = (Phone) factory.getBean("galaxyPhone");
		
		//스프링 컨테이너에게 겔럭시 폰을 세개 요청을 해도 하나의 객체만 생성해줌.
		//실수로 인해 메모리를 많이 사용하지 않음.
		factory.close(); // destroy-method 실행 됨.
	}
}
