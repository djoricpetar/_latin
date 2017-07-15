package org.latin.selenium;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.latin.adjective.Adjective;
import org.latin.adjective.AdjectiveDeclinationResolver;
import org.latin.adjective.AdjectiveFactory;
import org.latin.common.Position;
import org.latin.noun.NounDeclinationResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

@Ignore
public class AdjectiveLatinDictionaryOnlineTest {

	private static final String configFile = "latin.config.xml";
	
	private static WebDriver driver;
	private AdjectiveFactory adjectiveFactory = new AdjectiveFactory();
	
	@BeforeClass
	public static void startSession() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		// load latin classes
		AdjectiveDeclinationResolver.getInstance().loadClasses(configFile);
		NounDeclinationResolver.getInstance().loadClasses(configFile);
		
		// opens a firefox instance 
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		// and goes to google main page
		driver.get("http://www.google.com");
		
		// noun creation example
		Adjective adjective = adjectiveFactory.buildFrom("pulcher", "pulchra", "pulchrum");
		
		assertEquals("pulcher", adjective.getAdjectiveMasculinum().get(Position.NOMINATIVE_SINGULAR));
		
	}

	
	@AfterClass
	public static void closeSession() { 
		driver.close();
	}

}
