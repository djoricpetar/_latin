package org.latin.jpa;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.latin.adjective.AdjectiveDeclinationResolver;
import org.latin.common.Gender;
import org.latin.noun.BasicNoun;
import org.latin.noun.Noun;
import org.latin.noun.NounDeclinationResolver;
import org.latin.noun.NounFactory;
import org.latin.verb.ConjugationResolver;
import org.latin.verb.VerbFactory;

/**
 * 
 * For quick checks only
 * 
 * @author petarDj
 *
 */
@Ignore
public class ORMTest {

	 private static SessionFactory factory; 
	 private static NounFactory nounFactory = new NounFactory();
	 private static VerbFactory verbFactory = new VerbFactory();
	 
	 
	 private static String configFile = "latin.config.xml";
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AdjectiveDeclinationResolver.getInstance().loadClasses(configFile);
		NounDeclinationResolver.getInstance().loadClasses(configFile);
		ConjugationResolver.getInstance().loadClasses(configFile);
	    
	      try{
	    	  factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	  
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Scanner sc = new Scanner(System.in);
		String se= sc.nextLine();
		System.out.println(se);
		sc.close();
		
		factory.close();
	}

	@Test
	public void test() {
	      /* Add few employee records in database */
		
//		addEmployee("puella", "puellae", Gender.F);
		addEmployee("felix", "felix", null, null, Gender.M);
//		addEmployee("voco", "vocare", "vocavi", "vocatum");
	}
	
	public static BasicNoun addEmployee(String a1, String a2, String a3, String a4, Gender a5){
	    Session session = factory.openSession();
	    Transaction tx = null;
	    BasicNoun employeeID = null;
	    try{
	       tx = session.beginTransaction();
	       
//	       BasicNoun word = new BasicNoun(a1, a2, a5);
//	       Noun word = nounFactory.buildFrom(a1, a2, a3);
	       Noun word = new Noun(new BasicNoun(a1, a2, a5));
//	       Verb word = verbFactory.buildFrom(a1, a2, a3, a4);
//	       Verb word = new Verb(new BasicVerb(a1, a2, a3, a4));
	       
	       session.save(word); 
	       tx.commit();
	    }catch (Exception e) {
	       if (tx!=null) tx.rollback();
	       throw e;
	    }finally {
	       session.close(); 
	    }
	    return employeeID;
	 }

}
