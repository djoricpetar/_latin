package org.latin.verb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.latin.common.Satisfier;
import org.latin.properties.reader.DeclinationRulesReader;
import org.xml.sax.SAXException;

public class ConjugationResolver {

	private static ConjugationResolver conjugationResolver;
	
	private ConjugationResolver() {}
	
	private static List<Satisfier<BasicVerb>> conjugations = new ArrayList<Satisfier<BasicVerb>>();
	
	public synchronized static ConjugationResolver getInstance() { 
		if( conjugationResolver == null ) { 
			conjugationResolver = new ConjugationResolver();
		}
		return conjugationResolver;
	}
	
	public void loadClasses(String configurationFile) throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException {
		List<String> classNames = new DeclinationRulesReader("conjugation", configurationFile).retrieveDeclinationRules();
	
		for(String className : classNames) {
			@SuppressWarnings("unchecked")
			Satisfier<BasicVerb> declination = (Satisfier<BasicVerb>) Class.forName(className).newInstance();
			conjugations.add(declination);
		}
	}
	
	public Optional<Satisfier<BasicVerb>> resolveFrom(BasicVerb basicVerb) {
		return conjugations.stream()
			.filter(declinationRule -> declinationRule.isSatisfiableBy(basicVerb).accept())
			.findFirst();
	}
}
