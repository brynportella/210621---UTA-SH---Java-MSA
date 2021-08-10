import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.SuperVillainService;

public class MainDriver {
	
	//This is how we'd do it without DI
	//private static SuperVillainService villServ = new SuperVillainService();
	
	//With spring we done need to instantiate out instance of the SuperVillainService
	private static SuperVillainService vServ;
	
	public static void main(String[] args) {
		
		//Our IOC Container, ApplicationContext needs to reference the beans.xml file to configure our beans
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		//the application context creates an instance, the getBeans() method only refers to that instance
		//(because by defualt spring creates singletons)
		vServ = appContext.getBean("SuperVillainServiceBean", SuperVillainService.class);
		vServ = appContext.getBean("SuperVillainServiceBean", SuperVillainService.class);
		vServ = appContext.getBean("SuperVillainServiceBean", SuperVillainService.class);
		
		System.out.println("Counter"+ SuperVillainService.counter);
		
		cleanPrint(vServ.getAllVills());
		
	}
	
	public static <T> void cleanPrint(List<T> myList) {
		System.out.println("The List: ");
		for(T listItme: myList) {
			System.out.println(listItme);
		}
	}
	
}
