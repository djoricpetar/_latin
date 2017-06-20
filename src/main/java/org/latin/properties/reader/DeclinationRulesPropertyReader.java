package org.latin.properties.reader;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface DeclinationRulesPropertyReader {
	List<String> retrieveDeclinationRules() throws ParserConfigurationException, SAXException, IOException;
}
