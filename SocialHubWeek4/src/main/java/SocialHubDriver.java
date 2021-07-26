import java.util.List;
import java.util.Scanner;

import com.example.dao.PostDao;
import com.example.dao.PostDaoConcrete;
import com.example.dao.UserDao;
import com.example.dao.UserDaoConcrete;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;

public class SocialHubDriver {
	
	private static UserDao uDao = new UserDaoConcrete();
	private static PostDao sDao = new PostDaoConcrete();
	
	private static UserService uServ = new UserService(uDao);
	private static PostService pServ = new PostService(sDao);
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		User u = null;
		
		while(!done) {
			if(u == null) {
				System.out.println("Login or signup? Press 1 to signin, 2 to signup");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter you password: ");
					String password = in.nextLine();
					try {
						u = uServ.signIn(username, password);
						System.out.println("Welcome " + u.getFirstName());
					} catch (Exception e) {
						System.out.println("Username or password incorect. Goodbye");
						done = true;
					}
				} else {
					System.out.print("Please enter your first name: ");
					String first = in.nextLine();
					System.out.print("Please enter your last name: ");
					String last = in.nextLine();
					System.out.println("Please enter your email: ");
					String email = in.nextLine();
					System.out.print("Please enter a password: ");
					String password = in.nextLine();
					try {
						u = uServ.signUp(first, last, email, password);
						System.out.println("You may now log in with the username: " + u.getUsername());
					} catch (Exception e) {
						System.out.println("Sorry we could not process your request");
					}
				}
			} else {
				System.out.println("To view posts press 1, to create a post press 2");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					List<User> users = uDao.getAllUsers();
					for(User user: users) {
						user = pServ.loadUserPosts(user);
						for(Post post: user.getPosts()) {
							System.out.println(user.getUsername());
							System.out.println(post.getPostContent());
							System.out.println();
						}
					}
					System.out.println("Are you finished? 1 for yes, 2 for no");
					choice = Integer.parseInt(in.nextLine());
					done = (choice == 1) ? true : false;
				}
				else {
					
					System.out.println("Please enter your post content below:");
					String content = in.nextLine();
					pServ.addPost(u.getId(), u.getId(), content);
					System.out.println("Post was received, are you finished? 1 for yes, 2 for no");
					choice = Integer.parseInt(in.nextLine());
					done = (choice == 1) ? true : false;
					
				}
			}
		}
		in.close();
	}
	
	
}
