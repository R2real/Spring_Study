 package test;

public class BeanFactory {
	//2.디자인 패턴을 사용 : Factory ==클라이언트가 사용하고자 하는 객체 생성 부분을 캡슐화 == 클라이언트 소스코드 수정이 줄어듬.
	
	//알맞은 객체 이름을 받았을때 객체 생성을 돌려줌 
	public Object getBean(String beanName) {
		if(beanName.equals("iphone")) {
			return new IPhone();
		}else if(beanName.equals("galaxyPhone")) {
			return new GalaxyPhone();
		}
		return null;
	}
}
