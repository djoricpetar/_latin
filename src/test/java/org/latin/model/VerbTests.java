package org.latin.model;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.latin.adjective.AdjectiveDeclinationResolver;
import org.latin.noun.NounDeclinationResolver;
import org.latin.verb.ConjugationResolver;
import org.xml.sax.SAXException;

public class VerbTests {

	private static final String configFile = "latin.config.xml";
	
	@BeforeClass
	public static void loadClasses() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		AdjectiveDeclinationResolver.getInstance().loadClasses(configFile);
		NounDeclinationResolver.getInstance().loadClasses(configFile);
		ConjugationResolver.getInstance().loadClasses(configFile);
	}
	
}
