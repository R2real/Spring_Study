package test;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml") ;
		
		Phone phone = (Phone)factory.getBean("iPhone");
		
		phone.volumeDown();
		
		factory.close();
		
		
	}
}
