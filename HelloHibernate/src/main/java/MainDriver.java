import com.example.dao.SuperVillainDao;
import com.example.model.SuperVillain;
import com.example.util.HibernateUtil;

public class MainDriver {
	
	public static void main(String args[]) {
		
		SuperVillainDao sDao = new SuperVillainDao();
		
		SuperVillain s1 = new SuperVillain(1, "Magneto", "Magnets", 1_000_000_000);
		
		SuperVillain s2 = new SuperVillain(2, "Joker", "Crazy", 50_000_000);
		
		sDao.insert(s1);
		
		sDao.insert(s2);
		
		SuperVillain savedVill = sDao.selectVillain(2);
		
		System.out.println(savedVill);
		
		HibernateUtil.closeSes();
		
	}
	
}
