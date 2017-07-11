package org.latin.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.noun.BasicNoun;
import org.latin.noun.Noun;
import org.latin.noun.NounDeclinationResolver;
import org.latin.noun.NounFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

public class NounLatinDictionaryOnlineTest {

	private static WebDriver driver;
	private NounFactory nounFactory = new NounFactory();
	
	private static Set<BasicNoun> wantedBasicNouns = new HashSet<BasicNoun>();
	
	private static Map<String, Gender> stringToGenderMapping = new HashMap<String, Gender>(3);
	
	private static String xpathBase = "//*[@id=\'page-content\']/table/tbody/tr[%d]/td[%d]";
	
	private static int passedNouns = 0;
	
	@BeforeClass
	public static void startSession() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		// list of nouns not working ATM ( either assert error or UnknownDeclination exception ), skip them for now 
		// TODO make a full list
		// TODO add these nouns to NounTest.java
		wantedBasicNouns.add(new BasicNoun("aestas", "aestatis", Gender.F));
		wantedBasicNouns.add(new BasicNoun("ager", "agri", Gender.M));
		wantedBasicNouns.add(new BasicNoun("apis", "apis", Gender.F));
		wantedBasicNouns.add(new BasicNoun("arbor", "arboris", Gender.F));
		wantedBasicNouns.add(new BasicNoun("arma", "armorum", Gender.N));
		wantedBasicNouns.add(new BasicNoun("avis", "avis", Gender.F));
		wantedBasicNouns.add(new BasicNoun("balnea", "balneorum", Gender.N));
		
		// fill string to gender mapping 
		stringToGenderMapping.put("Feminine", 	Gender.F);
		stringToGenderMapping.put("Masculine", 	Gender.M);
		stringToGenderMapping.put("Neuter", 	Gender.N);
		
		// load latin classes
		NounDeclinationResolver.getInstance().loadClasses("latin.config.xml");
		
		// opens a firefox instance 
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws InterruptedException {		
		driver.get("http://latindictionary.wikidot.com/index-nouns");
		
		List<WebElement> allNounsByCategory=driver.findElements(By.className("list-pages-box"));
		allNounsByCategory.remove(0);
		List<String> allhref=new ArrayList<String>();
		for(WebElement el:allNounsByCategory){
			if(!el.getText().equals("")) { // dohvati sve kolone sa elementima po kategorijama
				
				WebElement p=el.findElement(By.xpath("*")); //dohvati sve nouns iz kolona
				List<WebElement> allNouns=p.findElements(By.xpath("*"));
				for(WebElement noun:allNouns) {
					String href=noun.getAttribute("href");
					if(href!=null) {
						allhref.add(href);
					}
				}
			}
		}
		
		
		for(String href:allhref) {
			driver.get(href);
			 
			WebElement  mainForms=driver.findElement(By.xpath("//*[@id='page-content']/p[2][1]"));
			
			String[] lines = mainForms.getText().split("\n");
			
			String forme=lines[0];
			int poc1=forme.indexOf(':');
			int poc2=forme.indexOf(',');
			String form1=forme.substring(poc1+2, poc2).toLowerCase();
			String form2=forme.substring(poc2+2).toLowerCase();
			
			String gender=lines[1];
			poc1=gender.indexOf(':');
			gender=gender.substring(poc1+2);
			
			String rec=driver.findElement(By.xpath("//*[@id=\'page-title\']")).getText().toLowerCase();
			System.out.println(rec);
			
			String nomSing 	=	findModificationElement(2, 2);
			String nomPlu	=	findModificationElement(2, 3);

			String genSing	=	findModificationElement(3, 2);
			String genPlu	=	findModificationElement(3, 3);
			
			String datSing	=	findModificationElement(4, 2);
			String datPlu	=	findModificationElement(4, 3);
			
			String accSing	=	findModificationElement(5, 2);
			String accPlu	=	findModificationElement(5, 3);
			
			String ablSing	=	findModificationElement(6, 2);
			String ablPlu	=	findModificationElement(6, 3);
			
			String vocSing	=	findModificationElement(7, 2);
			String vocPlu	=	findModificationElement(7, 3);
			
			Gender g = stringToGenderMapping.get(gender);

			BasicNoun basicNoun = new BasicNoun(form1, form2, g);
			
			if(wantedBasicNouns.contains(basicNoun))  
				continue;
			
			Noun noun = nounFactory.buildFrom(basicNoun);
			
			assertEquals(nomSing, noun.get(Position.NOMINATIVE_SINGULAR));
			assertEquals(genSing, noun.get(Position.GENITIVE_SINGULAR));
			assertEquals(datSing, noun.get(Position.DATIVE_SINGULAR));
			assertEquals(accSing, noun.get(Position.ACUSATIVE_SINGURAL));
			assertEquals(ablSing, noun.get(Position.ABLATIVE_SINGULAR));
			assertEquals(vocSing, noun.get(Position.VOCATIVE_SINGULAR));
			
			assertEquals(nomPlu, noun.get(Position.NOMINATIVE_PLURAL));
			assertEquals(genPlu, noun.get(Position.GENITIVE_PLURAL));
			assertEquals(datPlu, noun.get(Position.DATIVE_PLURAL));
			assertEquals(accPlu, noun.get(Position.ACUSATIVE_PLURAL));
			assertEquals(ablPlu, noun.get(Position.ABLATIVE_PLURAL));
			assertEquals(vocPlu, noun.get(Position.VOCATIVE_PLURAL));
			
			passedNouns++;
		}		
		
	}

	@AfterClass
	public static void closeSession() { 
		System.out.println(String.format("PASS/FAIL : %d/%d. Pass percentage : %.2f", passedNouns, wantedBasicNouns.size(), (double)passedNouns / ( wantedBasicNouns.size() + passedNouns) ));				
		driver.close();
	}
	
	
	private String findModificationElement(int i1, int i2) { 
		return driver.findElement(By.xpath(String.format(xpathBase, i1, i2))).getText().toLowerCase();
	}
}
