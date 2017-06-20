package org.latin.noun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.latin.common.Satisfier;
import org.latin.properties.reader.DeclinationRulesReader;
import org.xml.sax.SAXException;

public final class NounDeclinationResolver {

	private static NounDeclinationResolver declinationResolver;
	
	private NounDeclinationResolver() {}
	
	private static List<Satisfier<BasicNoun>> declinations = new ArrayList<Satisfier<BasicNoun>>();
	
	public synchronized static NounDeclinationResolver getInstance() {
		if( declinationResolver == null ) { 
			declinationResolver = new NounDeclinationResolver();
		}
		return declinationResolver;
	}

	public  void loadClasses(String configurationFile) throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		List<String> classNames = new DeclinationRulesReader("declination", configurationFile).retrieveDeclinationRules();
		
		for(String className : classNames) {
			@SuppressWarnings("unchecked")
			Satisfier<BasicNoun> declination = (Satisfier<BasicNoun>) Class.forName(className).newInstance();
			declinations.add(declination);
		}
	}
	
	public Optional<Satisfier<BasicNoun>> resolveFrom(BasicNoun basicNoun) {
		return declinations.stream()
			.filter(declinationRule -> declinationRule.isSatisfiableBy(basicNoun).accept())
			.findFirst();
	}
}
