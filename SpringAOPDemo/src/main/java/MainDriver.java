import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.myapp.ProxyApp;

public class MainDriver {
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProxyApp myApp = appContext.getBean("appProxy", ProxyApp.class);
		
		myApp.drawCartoon('h', 0);
		myApp.drawRickAndMorty(0);
		myApp.drawNature();
		
		try {
			myApp.drawSpace();
		} catch(Exception e) {
			System.out.println("whoops");
		}
		
		myApp.sculptPottery();
	}
	
}
