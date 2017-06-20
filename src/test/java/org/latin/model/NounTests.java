package org.latin.model;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.latin.common.Gender;
import org.latin.noun.Noun;
import org.latin.noun.NounFactory;
import org.latin.noun.NounDeclinationResolver;
import org.xml.sax.SAXException;

public class NounTests {

	protected NounFactory nounFactory = new NounFactory();
	
	@BeforeClass
	public  static void loadClasses() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		NounDeclinationResolver.getInstance().loadClasses("latin.config.xml");
	}

	// wrapper method to protect tests from future design changes
	protected Noun createNoun(String nominativeSingular, String genitiveSingular, Gender gender) {
		return nounFactory.buildFrom(nominativeSingular, genitiveSingular, gender);
	}
	
	protected Noun createNoun(String nominativeSingular, String genitiveSingular, Gender gender, Class<?> adjectiveClazz) {
		return nounFactory.buildFrom(nominativeSingular, genitiveSingular, gender, adjectiveClazz);
	}
}
