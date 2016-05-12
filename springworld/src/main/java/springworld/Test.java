package springworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Hellospringworld springworld = (Hellospringworld) context.getBean("hellospringworld");
		springworld.setName("Swetha");
		String msg = springworld.sayHello();
		System.out.println(msg);
		
		 springworld = (Hellospringworld) context.getBean("hellospringworld");
		 msg = springworld.sayHello();
		System.out.println(msg);
		
		Person person=(Person)context.getBean(Person.class);
		System.out.println("Loan object"+person.getMyLoan());
		
		
		

	}

}
