package org.latin.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.noun.Noun;
import org.latin.noun.NounDeclinationResolver;
import org.latin.noun.NounFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

import com.thoughtworks.selenium.condition.Text;

public class NounLatinDictionaryOnlineTest {

	private static WebDriver driver;
	private NounFactory nounFactory = new NounFactory();
	
	@BeforeClass
	public static void startSession() throws InstantiationException, IllegalAccessException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException { 
		// load latin classes
		NounDeclinationResolver.getInstance().loadClasses("latin.config.xml");
		
		// opens a firefox instance 
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		
		// and goes to google main page
		driver.get("http://latindictionary.wikidot.com/index-nouns");
		
		//System.out.println(driver.getPageSource());
		
		// noun creation example
		//Noun noun = nounFactory.buildFrom("fabula", "fabulae", Gender.F);
		
		List<WebElement> allNounsByCategory=driver.findElements(By.className("list-pages-box"));
		allNounsByCategory.remove(0);
		List<String> allhref=new ArrayList();
		for(WebElement el:allNounsByCategory){
			if(!el.getText().equals("")) { // dohvati sve kolone sa elementima po kategorijama
				
				WebElement p=el.findElement(By.xpath("*")); //dohvati sve nouns iz kolona
				List<WebElement> allNouns=p.findElements(By.xpath("*"));
				for(WebElement noun:allNouns) {
					//System.out.println(noun.getText()+noun.getAttribute("href"));
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
			String nomSing=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[2]/td[2]")).getText().toLowerCase();
			String nomPlu=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[2]/td[3]")).getText().toLowerCase();
			//*[@id="page-content"]/table/tbody/tr[3]/td[2]
			String genSing=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[3]/td[2]")).getText().toLowerCase();
			String genPlu=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[3]/td[3]")).getText().toLowerCase();
			
			String datSing=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[4]/td[2]")).getText().toLowerCase();
			String datPlu=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[4]/td[3]")).getText().toLowerCase();
			
			String accSing=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[5]/td[2]")).getText().toLowerCase();
			String accPlu=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[5]/td[3]")).getText().toLowerCase();
			
			String ablSing=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[6]/td[2]")).getText().toLowerCase();
			String ablPlu=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[6]/td[3]")).getText().toLowerCase();
			
			String vocSing=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[7]/td[2]")).getText().toLowerCase();
			String vocPlu=driver.findElement(By.xpath("//*[@id=\'page-content\']/table/tbody/tr[7]/td[3]")).getText().toLowerCase();
			
			System.out.println("fomre su: "+form1+", "+form2);
			System.out.println("rod je: "+gender);
			System.out.println("nom su: "+nomSing+", "+nomPlu);
			System.out.println("gen su: "+genSing+", "+genPlu);
			System.out.println("dat su: "+datSing+", "+datPlu);
			System.out.println("acc su: "+accSing+", "+accPlu);
			System.out.println("abl su: "+ablSing+", "+ablPlu);
			System.out.println("voc su: "+vocSing+", "+vocPlu);
			Gender g=null;
			switch(gender) {
			case "Femine":{
				g=Gender.F;
				break;
			}
			case "Masculine":{
				g=Gender.M;
				break;
			}
			case "Neuter":{
				g=Gender.N;
				break;
			}
			
			}
			
			
			Noun noun = nounFactory.buildFrom(form1, form2, g);
			
			
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
			
			
			
		}
		
		//*[@id='page-content']/p[2]/strong[1]
		//assertEquals("fabula", noun.get(Position.NOMINATIVE_SINGULAR));
		//*[@id='page-content']/p[2]/text()[1]
		
	}

	
	@AfterClass
	public static void closeSession() { 
		driver.close();
	}
}
