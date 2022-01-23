package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//스프링을 설치 했기때문에 사용 가능

public class Client {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		Phone p = (Phone)factory.getBean("iphone");
		
	}
}
