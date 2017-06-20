package org.latin.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.latin.adjective.Adjective;
import org.latin.common.Position;
import org.latin.noun.Noun;

public class AdjectiveTest extends AdjectiveTests {
	
	// wrapper method to protect tests from future design changes
	private Adjective createAdjective(String nominativeSinM, String nominativeSinF, String nominativeSinN) {
		return adjectiveFactory.buildFrom(nominativeSinM, nominativeSinF, nominativeSinN);
	}
	
	private void checkModificationsHelpMethod(String nomM, String nomF, String nomN, String[] modifications) { 
		Adjective adjective = createAdjective(nomM, nomF, nomN);
		
		Noun masculinum = adjective.getAdjectiveMasculinum();
		Noun femininum 	= adjective.getAdjectiveFemininum();
		Noun neutrum	= adjective.getAdjectiveNeutrum();
		
		assertEquals(modifications[0], 		masculinum.get(Position.NOMINATIVE_SINGULAR));
		assertEquals(modifications[2],		masculinum.get(Position.GENITIVE_SINGULAR));
		assertEquals(modifications[4],		masculinum.get(Position.DATIVE_SINGULAR));
		assertEquals(modifications[6],		masculinum.get(Position.ACUSATIVE_SINGURAL));
		assertEquals(modifications[8],		masculinum.get(Position.VOCATIVE_SINGULAR));
		assertEquals(modifications[10],		masculinum.get(Position.ABLATIVE_SINGULAR));
	
		assertEquals(modifications[1], 		masculinum.get(Position.NOMINATIVE_PLURAL));
		assertEquals(modifications[3],		masculinum.get(Position.GENITIVE_PLURAL));
		assertEquals(modifications[5],		masculinum.get(Position.DATIVE_PLURAL));
		assertEquals(modifications[7],		masculinum.get(Position.ACUSATIVE_PLURAL));
		assertEquals(modifications[9],		masculinum.get(Position.VOCATIVE_PLURAL));
		assertEquals(modifications[11],		masculinum.get(Position.ABLATIVE_PLURAL));

		assertEquals(modifications[12], 	femininum.get(Position.NOMINATIVE_SINGULAR));
		assertEquals(modifications[14],		femininum.get(Position.GENITIVE_SINGULAR));
		assertEquals(modifications[16],		femininum.get(Position.DATIVE_SINGULAR));
		assertEquals(modifications[18],		femininum.get(Position.ACUSATIVE_SINGURAL));
		assertEquals(modifications[20],		femininum.get(Position.VOCATIVE_SINGULAR));
		assertEquals(modifications[22],		femininum.get(Position.ABLATIVE_SINGULAR));
	
		assertEquals(modifications[13], 	femininum.get(Position.NOMINATIVE_PLURAL));
		assertEquals(modifications[15],		femininum.get(Position.GENITIVE_PLURAL));
		assertEquals(modifications[17],		femininum.get(Position.DATIVE_PLURAL));
		assertEquals(modifications[19],		femininum.get(Position.ACUSATIVE_PLURAL));
		assertEquals(modifications[21],		femininum.get(Position.VOCATIVE_PLURAL));
		assertEquals(modifications[23],		femininum.get(Position.ABLATIVE_PLURAL));

		assertEquals(modifications[24], 	neutrum.get(Position.NOMINATIVE_SINGULAR));
		assertEquals(modifications[26],		neutrum.get(Position.GENITIVE_SINGULAR));
		assertEquals(modifications[28],		neutrum.get(Position.DATIVE_SINGULAR));
		assertEquals(modifications[30],		neutrum.get(Position.ACUSATIVE_SINGURAL));
		assertEquals(modifications[32],		neutrum.get(Position.VOCATIVE_SINGULAR));
		assertEquals(modifications[34],		neutrum.get(Position.ABLATIVE_SINGULAR));
	
		assertEquals(modifications[25], 	neutrum.get(Position.NOMINATIVE_PLURAL));
		assertEquals(modifications[27],		neutrum.get(Position.GENITIVE_PLURAL));
		assertEquals(modifications[29],		neutrum.get(Position.DATIVE_PLURAL));
		assertEquals(modifications[31],		neutrum.get(Position.ACUSATIVE_PLURAL));
		assertEquals(modifications[33],		neutrum.get(Position.VOCATIVE_PLURAL));
		assertEquals(modifications[35],		neutrum.get(Position.ABLATIVE_PLURAL));

	}
	
	/* 
	 * Testing 1. declination
	 */
	
	@Test
	public void whenFirstDeclinationThenSuccessfullyStored()  {
		checkModificationsHelpMethod("magnus", "magna", "magnum", new String[] {
				"magnus",	"magni",
				"magni",	"magnorum",
				"magno",	"magnis",
				"magnum",	"magnos",
				"magne",	"magni",
				"magno",	"magnis",
				
				"magna", 	"magnae",
				"magnae",	"magnarum",
				"magnae",	"magnis",
				"magnam",	"magnas",
				"magna",	"magnae",
				"magna",	"magnis",
				
				"magnum",	"magna",
				"magni",	"magnorum",
				"magno",	"magnis",
				"magnum",	"magna",
				"magnum",	"magna",
				"magno",	"magnis"
		});
	}
	
	/*
	 *  Testing 2. declination 
	 */
	
	@Test
	public void when2aDeclinationThenSuccessfullyStored()  {
		checkModificationsHelpMethod("miser", "misera", "miserum", new String[] {
				"miser", 	"miseri",
				"miseri",	"miserorum",
				"misero",	"miseris",
				"miserum",	"miseros",
				"miser",	"miseri",
				"misero",	"miseris",
				
				"misera", 	"miserae",
				"miserae",	"miserarum",
				"miserae",	"miseris",
				"miseram",	"miseras",
				"misera",	"miserae",
				"misera",	"miseris",
				
				"miserum", 	"misera",
				"miseri",	"miserorum",
				"misero",	"miseris",
				"miserum",	"misera",
				"miserum",	"misera",
				"misero",	"miseris"
		});
	}
	
	@Test
	public void when2bDeclinationThenSuccessfullyStored()  {
		checkModificationsHelpMethod("pulcher", "pulchra", "pulchrum", new String[] {
				"pulcher", 	"pulchri",
				"pulchri",	"pulchrorum",
				"pulchro",	"pulchris",
				"pulchrum",	"pulchros",
				"pulcher",	"pulchri",
				"pulchro",	"pulchris",
				
				"pulchra", 	"pulchrae",
				"pulchrae",	"pulchrarum",
				"pulchrae",	"pulchris",
				"pulchram",	"pulchras",
				"pulchra",	"pulchrae",
				"pulchra",	"pulchris",
				
				"pulchrum", "pulchra",
				"pulchri",	"pulchrorum",
				"pulchro",	"pulchris",
				"pulchrum",	"pulchra",
				"pulchrum",	"pulchra",
				"pulchro",	"pulchris"
		});
	}
	
	
	@Test
	public void when2bDeclinationThenSuccessfullyStored_SAME_butIncomplete()  {
		checkModificationsHelpMethod("pulcher", "-chra", "-chrum", new String[] {
				"pulcher", 	"pulchri",
				"pulchri",	"pulchrorum",
				"pulchro",	"pulchris",
				"pulchrum",	"pulchros",
				"pulcher",	"pulchri",
				"pulchro",	"pulchris",
				
				"pulchra", 	"pulchrae",
				"pulchrae",	"pulchrarum",
				"pulchrae",	"pulchris",
				"pulchram",	"pulchras",
				"pulchra",	"pulchrae",
				"pulchra",	"pulchris",
				
				"pulchrum", "pulchra",
				"pulchri",	"pulchrorum",
				"pulchro",	"pulchris",
				"pulchrum",	"pulchra",
				"pulchrum",	"pulchra",
				"pulchro",	"pulchris"
		});
	}
	
	/* 
	 * Testing 3. declination
	 */
	
	@Test
	public void when3ADeclinationThenSuccessfullyStored()  {
		checkModificationsHelpMethod("celeber", "celebris", "celebre", new String[] {
				"celeber",	"celebres",
				"celebris",	"celebrium",
				"celebri",	"celebribus",
				"celebrem",	"celebres",
				"celeber",	"celebres",
				"celebri",	"celebribus",
				
				"celebris", "celebres",
				"celebris",	"celebrium",
				"celebri",	"celebribus",
				"celebrem",	"celebres",
				"celebris",	"celebres",
				"celebra",	"celebribus",
				
				"celebre",	"celebria",
				"celebris",	"celebrium",
				"celebri",	"celebribus",
				"celebre",	"celebria",
				"celebre",	"celebria",
				"celebri",	"celebribus"
		});
	}
	
	@Test
	public void when3bDeclinationThenSuccessfullyStored()  {
		checkModificationsHelpMethod("tristis", "tristis", "triste", new String[] {
				"tristis",	"tristes",
				"tristis",	"tristium",
				"tristi",	"tristibus",
				"tristem",	"tristes",
				"tristis",	"tristes",
				"tristi",	"tristibus",
				
				"tristis",	"tristes",
				"tristis",	"tristium",
				"tristi",	"tristibus",
				"tristem",	"tristes",
				"tristis",	"tristes",
				"tristi",	"tristibus",
				
				"triste",	"tristia",
				"tristis",	"tristium",
				"tristi",	"tristibus",
				"triste",	"tristia",
				"triste",	"tristia",
				"tristi",	"tristibus"
		});
	}
	
	@Test
	public void when3cDeclinationThenSuccessfullyStored()  {
		checkModificationsHelpMethod("constans", "constans", "constans", new String[] {
				"constans",		"constantes",
				"constantis",	"constantium",
				"constanti",	"constantibus",
				"constantem",	"constantes",
				"constans",		"constantes",
				"constanti",	"constantibus",
				
				"constans",		"constantes",
				"constantis",	"constantium",
				"constanti",	"constantibus",
				"constantem",	"constantes",
				"constans",		"constantes",
				"constanti",	"constantibus",
				
				"constans",		"constantia",
				"constantis",	"constantium",
				"constanti",	"constantibus",
				"constans",		"constantia",
				"constans",		"constantia",
				"constanti",	"constantibus",
		});
	}
	
	@Test
	public void when3DDeclinationThenSuccessfullyStored()  {
		checkModificationsHelpMethod("felix", "felix", "felix", new String[] {
				"felix",	"felices",
				"felicis",	"felicium",
				"felici",	"felicibus",
				"felicem",	"felices",
				"felix",	"felices",
				"felici",	"felicibus",
				
				"felix",	"felices",
				"felicis",	"felicium",
				"felici",	"felicibus",
				"felicem",	"felices",
				"felix",	"felices",
				"felici",	"felicibus",
				
				"felix",	"felicia",
				"felicis",	"felicium",
				"felici",	"felicibus",
				"felix",	"felicia",
				"felix",	"felicia",
				"felici",	"felicibus"
		});
	}
}
