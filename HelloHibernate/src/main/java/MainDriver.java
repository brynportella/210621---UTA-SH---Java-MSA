import java.util.ArrayList;
import java.util.List;

import com.example.dao.CrimeDao;
import com.example.dao.SuperPrisonDao;
import com.example.dao.SuperVillainDao;
import com.example.model.Crime;
import com.example.model.SuperPrison;
import com.example.model.SuperVillain;
import com.example.util.HibernateUtil;

public class MainDriver {
	
	public static void main(String args[]) {
		
		SuperVillainDao sDao = new SuperVillainDao();
		
		CrimeDao cDao = new CrimeDao();
		
		SuperPrisonDao pDao = new SuperPrisonDao();
		
		SuperPrison p1 = new SuperPrison("Azkaban", "UK");
		SuperPrison p2 = new SuperPrison("The Raft", "Ocean");
		
		pDao.insert(p1);
		pDao.insert(p2);
		
		Crime c1 = new Crime("murder", "literally killed someone");
		cDao.insert(c1);
		Crime c2 = new Crime("kidnapping", "literally stealing someone");
		cDao.insert(c2);
		Crime c3 = new Crime("stealing candy from a baby", "cmon man");
		cDao.insert(c3);
		Crime c4 = new Crime("tax evasion", "technically illegal");
		cDao.insert(c4);
		Crime c5 = new Crime("too many typos", "learn to type");
		cDao.insert(c5);
		Crime c6 = new Crime("arson", "some people want to see the world burn");
		cDao.insert(c6);
		
		/*
		List<Crime> cList = new ArrayList<Crime>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c6);
		SuperVillain s1 = new SuperVillain(1, "Magneto", "Magnets", 1_000_000_000, cList, p2);
		p2.getVillList().add(s1);
		
		cList = new ArrayList<Crime>();
		cList.add(c6);
		cList.add(c3);
		cList.add(c4);
		SuperVillain s2 = new SuperVillain(2, "Joker", "Crazy", 50_000_000, cList, p2);
		p2.getVillList().add(s2);
		
		cList = new ArrayList<Crime>();
		cList.add(c5);
		cList.add(c4);
		SuperVillain s3 = new SuperVillain(3, "Thantos", "the powa of fanta", 1_000_000, cList, p1);
		p1.getVillList().add(s3);
		
		sDao.insert(s1);
		
		sDao.insert(s2);
		
		sDao.insert(s3);
		
		SuperVillain savedVill = sDao.selectVillain(2);
		
		SuperVillain savedVill2 = sDao.selectByNameNative("Magneto");
		
		SuperVillain savedVill3 = sDao.selectByNameHQL("Joker");
		
		SuperVillain savedVill4 = sDao.selectByNameCriteria("Thantos");
		*/
		
		List<Crime> cList = new ArrayList<Crime>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c6);
		SuperVillain s4 = new SuperVillain(4, "Test", "testing power", 100, cList, p2);
		sDao.insert(s4);
		
		//System.out.println(savedVill);
		
		//System.out.println(savedVill2);
		
		//System.out.println(savedVill3);
		
		//System.out.println(savedVill4);
		
		//System.out.println(sDao.selectAll());
		
		HibernateUtil.closeSes();
		
	}
	
}
