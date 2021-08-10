import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Food;
import com.example.repsitory.FoodRepo;

public class MainDriver {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	public static FoodRepo foodRepo = appContext.getBean("foodRepo", FoodRepo.class);
	
	public static void main(String[] args) {
		//Insert some food
		Food f1 = new Food("Chicken", 400);
		foodRepo.insert(f1);
		
		f1 = new Food("Toast", 7.3);
		foodRepo.insert(f1);
		
		f1 = new Food("Pizza", 4750);
		foodRepo.insert(f1);
		
		f1 = new Food("Pasta", 250);
		foodRepo.insert(f1);
	}
	
}
