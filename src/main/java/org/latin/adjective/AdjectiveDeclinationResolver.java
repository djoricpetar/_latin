package org.latin.adjective;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.latin.common.Satisfier;
import org.latin.properties.reader.DeclinationRulesReader;
import org.xml.sax.SAXException;

public final class AdjectiveDeclinationResolver {

	private static AdjectiveDeclinationResolver declinationResolver;
	
	private AdjectiveDeclinationResolver() {}
	
	private static List<Satisfier<BasicAdjective>> declinations = new ArrayList<Satisfier<BasicAdjective>>();
	
	public synchronized static AdjectiveDeclinationResolver getInstance() {
		if( declinationResolver == null ) { 
			declinationResolver = new AdjectiveDeclinationResolver();
		}
		return declinationResolver;
	}
	
	public  void loadClasses(String configurationFile) throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		List<String> classNames = new DeclinationRulesReader("adjectiveDeclination", configurationFile).retrieveDeclinationRules();
		
		for(String className : classNames) {
			@SuppressWarnings("unchecked")
			Satisfier<BasicAdjective> declination = (Satisfier<BasicAdjective>) Class.forName(className).newInstance();
			declinations.add(declination);
		}
	}
	
	public Optional<Satisfier<BasicAdjective>> resolveFrom(BasicAdjective basicAdjective) {
		return declinations.stream()
			.filter(declinationRule -> declinationRule.isSatisfiableBy(basicAdjective).accept())
			.findFirst();
	}
}
