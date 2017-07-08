package org.latin.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.latin.adjective.AdjectiveDeclinationResolver;
import org.latin.noun.NounDeclinationResolver;
import org.latin.verb.ConjugationResolver;
import org.latin.verb.Position;
import org.latin.verb.Verb;
import org.latin.verb.VerbFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

public class VerbLatinDictionaryOnlineTest {

	private static final String configFile = "latin.config.xml";
	
	private static WebDriver driver;
	private VerbFactory verbFactory = new VerbFactory();
	
	@BeforeClass
	public static void startSession() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		// load latin classes
		AdjectiveDeclinationResolver.getInstance().loadClasses(configFile);
		NounDeclinationResolver.getInstance().loadClasses(configFile);
		ConjugationResolver.getInstance().loadClasses(configFile);
		
		// opens a firefox instance 
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		// and goes to google main page
		driver.get("http://www.google.com");
		
		// noun creation example
		Verb verb = verbFactory.buildFrom("voco", "vocare", "vocavi", "vocatum");
		
		assertEquals("voco", verb.get(Position.FIRST_PERSON_SINGULAR_PRESENT));
		
	}

	
	@AfterClass
	public static void closeSession() { 
		driver.close();
	}

}
