package scope.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InjectionBean injectionBean = 
				ctx.getBean("injectionBean", InjectionBean.class);
		
		DependencyBean dependencyBean01 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		DependencyBean dependencyBean02 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		if(dependencyBean01.equals(dependencyBean02)) {
			System.out.println("dependencyBean01 == dependencyBean02");
		} else {
			System.out.println("dependencyBean01 != dependencyBean02");
		}
		// 한번씩 호출되고 결과는 두개의 객체가 같다. 레퍼런스가 다르지만 같은 메모리 주소에 있는 하나의 객체만 생성되어 그 객체를 가르킨다. 두개의 객체를 생성하려면 prototype을 선언해줌. (싱글톤 - default) 
		// scope에 prototype을 선언한후, 두번씩 호출되고 결과는 두개의 객체가 다르다. prototype을 선언하면 호출할때마다 각각의 객체가 생성됨
		ctx.close();
		
	}
	
}
