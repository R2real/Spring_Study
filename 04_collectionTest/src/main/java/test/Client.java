package test;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml") ;
		
		
		CollectionTest ct=(CollectionTest)factory.getBean("ct");
		Set<String> datas = ct.getNameSet();
			for(String v: datas ) {
				System.out.println(v);
			}
		factory.close();
		
		
	}
}
