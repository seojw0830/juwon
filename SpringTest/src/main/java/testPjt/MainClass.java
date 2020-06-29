package testPjt;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
//		TransportationWalk test = new TransportationWalk();
//		
//		test.move();
		
		/*applicationContext(컨테이너)에 빈을 선언 - 컨테이너를 선언 - 컨테이너의 선언된 빈을 통해 기능 활용 가능
		 * 빈을 선언하거나 어노테이션을 많이 활용
		 * */
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		TransportationWalk test = ctx.getBean("tWalk", TransportationWalk.class);
		test.move();
		
		ctx.close();
		
	}
}
