import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;

import com.example.dao.PostDao;
import com.example.dao.PostDaoConcrete;
import com.example.dao.PostDaoHibernate;
import com.example.dao.UserDao;
import com.example.dao.UserDaoConcrete;
import com.example.dao.UserDaoHibernate;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;
import com.example.utils.HibernateUtil;

public class SocialHubDriver {
	
	private static UserDaoHibernate uDao = new UserDaoHibernate();
	private static PostDaoHibernate pDao = new PostDaoHibernate();
	
	private static UserService uServ = new UserService(uDao);
	private static PostService pServ = new PostService(pDao, uDao);
	
	public static void main(String args[]) {
		
		User u1 = new User(0, "Rick", "Sanchez", "rick@email.com", "password");
		User u2 = new User(0, "Morty", "Smith", "morty@email.com", "password");
		User u3 = new User(0, "Summer", "Smith", "summer@email.com", "password");
		User u4 = new User(0, "Beth", "Smith", "beth@email.com", "password");
		User u5 = new User(0, "Jerry", "Smith", "jerry@email.com", "password");
		
		Post p1 = new Post(u4, "Testing our post table");
		
		u4.getPosts().add(p1);
		
		//uDao.createUser(u3);
		pDao.createPost(p1);
		uDao.createUser(u4);
		/*
		System.out.println("Rick User:");
		System.out.println(uDao.getUserByUserName(u1.getUsername()));
		
		uDao.createUser(u3);
		uDao.createUser(u3);
		
		System.out.println("All Users:");
		System.out.println(uDao.getAllUsers());
		
		u2.setEmail("mortysemail@email.com");
		
		uDao.updateUser(u2);
		
		System.out.println("Updated Morty User:");
		System.out.println(uDao.getUserByUserName(u2.getUsername()));
		
		//uDao.deleteUser(u1);
		
		System.out.println("All Users After Delete:");
		System.out.println(uDao.getAllUsers());
		
		
		//Post p1 = new Post (0, u2, "This is morty's first post");
		
		Post p1 = pServ.addPost(u2, "This is morty's first post");
		
		//List<Post> pList = u2.getPosts();
		//pList.add(p1);
		
		//uDao.updateUser(u2);
		
		System.out.println(uDao.getUserByUserName(u2.getUsername()));
		
		pServ.likePost(u1, p1);
		
		System.out.println("Post1 should now have a like:");
		System.out.println(pDao.getPostById(3));
		
		System.out.println("Rick should have morty's post in his like list");
		System.out.println(uDao.getUserByUserName(u1.getUsername()));
		
		System.out.println("Ricks like list");
		Query q = HibernateUtil.getSession().createNamedQuery("getUsersLikedPosts");
		q.setInteger("id", u1.getId());
		System.out.println(q.getResultList());
		*/
		HibernateUtil.closeSession();
		
		
		/*
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
		*/
	}
	
	
}
