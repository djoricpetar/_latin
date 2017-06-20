package org.latin.properties.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DeclinationRulesReader implements DeclinationRulesPropertyReader {

	private final String propertyFileName;
	
	private final String TAG_NAME;
	private final String ATTRIBUTE_NAME = "class";
	
	public DeclinationRulesReader(String tagName, String propertyFileName) {
		this.propertyFileName = propertyFileName;
		this.TAG_NAME = tagName;
	}
	
	@Override
	public List<String> retrieveDeclinationRules() throws ParserConfigurationException, SAXException, IOException {
		List<String> rules = new ArrayList<String>();
		

    	File fXmlFile = new File(propertyFileName);
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document doc = dBuilder.parse(fXmlFile);

    	//optional, but recommended
    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    	doc.getDocumentElement().normalize();

    	NodeList nList = doc.getElementsByTagName(TAG_NAME);

    	for (int temp = 0; temp < nList.getLength(); temp++) {

    		Node nNode = nList.item(temp);

    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
    			rules.add( eElement.getAttribute(ATTRIBUTE_NAME));
    		}
    	}
		
	    return rules;
	}

}
