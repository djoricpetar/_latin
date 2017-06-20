package org.latin.model;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.latin.adjective.AdjectiveDeclinationResolver;
import org.latin.adjective.AdjectiveFactory;
import org.latin.noun.NounDeclinationResolver;
import org.xml.sax.SAXException;

public class AdjectiveTests {

	private static final String configFile = "latin.config.xml";
	
	protected AdjectiveFactory adjectiveFactory = new AdjectiveFactory();
	
	@BeforeClass
	public static void setUpBeforeClass() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		AdjectiveDeclinationResolver.getInstance().loadClasses(configFile);
		NounDeclinationResolver.getInstance().loadClasses(configFile);
	}
	
}
