package BeanScope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		// load xml
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach basec_1 = ctx.getBean("baseball", Coach.class);	
		Coach basec_2 = ctx.getBean("baseball", Coach.class);
		System.out.println(basec_1.equals(basec_2));
		
		Coach basketc_1 = ctx.getBean("basketball", Coach.class);
		Coach basketc_2 = ctx.getBean("basketball", Coach.class);
		System.out.println(basketc_1.equals(basketc_2));
		
		ctx.close();
	}

}
