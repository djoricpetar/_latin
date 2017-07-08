package org.latin.model;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.noun.Noun;
import org.latin.noun.NounDeclinationResolver;
import org.latin.noun.NounFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

public class NounLatinDictionaryOnlineTest {

	private static WebDriver driver;
	private NounFactory nounFactory = new NounFactory();
	
	@BeforeClass
	public static void startSession() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		// load latin classes
		NounDeclinationResolver.getInstance().loadClasses("latin.config.xml");
		
		// opens a firefox instance 
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		// and goes to google main page
		driver.get("http://www.google.com");
		
		// noun creation example
		Noun noun = nounFactory.buildFrom("fabula", "fabulae", Gender.F);
		
		assertEquals("fabula", noun.get(Position.NOMINATIVE_SINGULAR));
		
	}

	
	@AfterClass
	public static void closeSession() { 
		driver.close();
	}
}
