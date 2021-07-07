import com.example.exceptions.InvalidCredentialsException;
import com.example.models.User;
import com.example.services.UserService;

public class SocialHubDriver {
	
	private static UserService uServ = new UserService();
	
	public static void main(String[] args) {
		
		User morty = uServ.register("Morty", "Smith", "password");
		
		System.out.println(morty);
		
		try {
			uServ.login(morty.getUsername(), "password");
		}
		catch(InvalidCredentialsException e) {
			System.out.println("Oops the user tried logging in with invalid credentials");
		}
		
	}
	
}
