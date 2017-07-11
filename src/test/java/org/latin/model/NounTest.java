package org.latin.model;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.common.UnknownDeclination;
import org.latin.noun.BasicNoun;
import org.latin.noun.Noun;

public class NounTest extends NounTests {
	
	/*
	 * Testing declination resolver 
	 */
	
	@Test
	public void whenA_AE_FemininumThenFirstDeclination() {
		Noun noun = createNoun("fabula", "-ae", Gender.F);
		
		assertEquals(Declination.I, noun.getDeclination());
	}
	
	@Test
	public void whenA_AE_MasculinumThenFirstDeclinatinon() {
		Noun noun = createNoun("nauta", "-ae", Gender.M);
		
		assertEquals(Declination.I, noun.getDeclination());
	}
	
	@Test
	public void whenER_I_Masculinum_existingEThenSecondDeclination() {
		Noun noun = createNoun("puer", "pueri", Gender.M);
		
		assertEquals(Declination.II, noun.getDeclination());
	}

	@Test
	public void whenUS_I_MasculinumThenSecondDeclination() {
		Noun noun = createNoun("discipulus", "discipuli", Gender.M);
		
		assertEquals(Declination.II, noun.getDeclination()); 
	}
	
	@Test
	public void whenUM_I_NeutrumThenSecondDeclination() {
		Noun noun = createNoun("bellum", "belli", Gender.N);
		
		assertEquals(Declination.II, noun.getDeclination()); 
	}	
	
	@Test
	public void whenER_I_Masculinum_nonexistingEThenSecondDeclination() {
		Noun noun = createNoun("magister", "magistri", Gender.M);
		
		assertEquals(Declination.II, noun.getDeclination()); 
	}		
	
	@Test
	public void whenVIR_VIRI_Masculinum_ThenSecondDeclination() {
		Noun noun = createNoun("vir", "viri", Gender.M);
		
		assertEquals(Declination.II, noun.getDeclination());  
	}	
	
	@Test
	public void whenER_RIS_M_ThenXXa_3_Declination() {
		Noun noun = createNoun("celeber", "celebris", Gender.M);
		
		assertEquals(Declination.III, noun.getDeclination());  
	}	
	
	@Test
	public void whenRE_RIS_N_ThenXXb_3_Declination() {
		Noun noun = createNoun("celebre", "celebris", Gender.N);
		
		assertEquals(Declination.III, noun.getDeclination());  
	}	
	
	@Test(expected=UnknownDeclination.class)
	public void whenRandomThenUnknownDeclination(){
		createNoun("petar", "djoric", null);
	}
	
	private void checkModificationsHelpMethod(String nom, String gen, Gender gender, String[] modifications) { 
		checkModificationsHelpMethod(nom, gen, gender, null, modifications);
	}
	
	private void checkModificationsHelpMethod(String nom, String gen, Gender gender, Class<?> adjectiveClazz, String[] modifications) { 
		Noun noun = createNoun(nom, gen, gender, adjectiveClazz);
		
		assertEquals(modifications[0], 		noun.get(Position.NOMINATIVE_SINGULAR));
		assertEquals(modifications[2],		noun.get(Position.GENITIVE_SINGULAR));
		assertEquals(modifications[4],		noun.get(Position.DATIVE_SINGULAR));
		assertEquals(modifications[6],		noun.get(Position.ACUSATIVE_SINGURAL));
		assertEquals(modifications[8],		noun.get(Position.VOCATIVE_SINGULAR));
		assertEquals(modifications[10],		noun.get(Position.ABLATIVE_SINGULAR));
	
		assertEquals(modifications[1], 		noun.get(Position.NOMINATIVE_PLURAL));
		assertEquals(modifications[3],		noun.get(Position.GENITIVE_PLURAL));
		assertEquals(modifications[5],		noun.get(Position.DATIVE_PLURAL));
		assertEquals(modifications[7],		noun.get(Position.ACUSATIVE_PLURAL));
		assertEquals(modifications[9],		noun.get(Position.VOCATIVE_PLURAL));
		assertEquals(modifications[11],		noun.get(Position.ABLATIVE_PLURAL));
		
		System.out.println(noun.getRule());
	}
	
	/*
	 * Testing modifications for 1. declination ( Declination01.java )
	 */
	@Test
	public void whenDeclination1FeminineNounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("puella", "puellae", Gender.F, new String[] {
				"puella", 	"puellae",
				"puellae",	"puellarum",
				"puellae",	"puellis",
				"puellam",	"puellas",
				"puella",	"puellae",
				"puella",	"puellis"
		});
	}

	@Test
	public void whenDeclination1MasculineNounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("nauta", "nautae", Gender.M, new String[] {
				"nauta",	"nautae",
				"nautae",	"nautarum",
				"nautae",	"nautis",
				"nautam",	"nautas",
				"nauta",	"nautae",
				"nauta",	"nautis"
		});		
	}	
	
	@Test
	public void whenDeclination1FeminineSimpleNounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("puella", "-ae", Gender.F, new String[] {
				"puella", 	"puellae",
				"puellae",	"puellarum",
				"puellae",	"puellis",
				"puellam",	"puellas",
				"puella",	"puellae",
				"puella",	"puellis"
		});
	}	
	
	@Test
	public void whenDeclination1MasculineSimpleNounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("nauta", "-ae", Gender.M, new String[] {
				"nauta",	"nautae",
				"nautae",	"nautarum",
				"nautae",	"nautis",
				"nautam",	"nautas",
				"nauta",	"nautae",
				"nauta",	"nautis"
			});		
	}	
	
	/*
	 * Testing modifications for 2. declination 
	 */
	@Test
	public void whenDeclination2ER_I_EX_ENounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("puer", "pueri", Gender.M, new String[] {
				"puer",		"pueri",
				"pueri",	"puerorum",
				"puero",	"pueris",
				"puerum",	"pueros",
				"puer",		"pueri",
				"puero",	"pueris"
			});	
	}	

	@Test
	public void whenDeclination2ER_I_EX_E_SimpleNounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("puer", "-eri", Gender.M, new String[] {
				"puer",		"pueri",
				"pueri",	"puerorum",
				"puero",	"pueris",
				"puerum",	"pueros",
				"puer",		"pueri",
				"puero",	"pueris"
			});	
	}		
	
	@Test
	public void whenDeclination2ER_I_NON_EX_ENounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("magister", "magistri", Gender.M, new String[] {
				"magister",		"magistri",
				"magistri",		"magistrorum",
				"magistro",		"magistris",
				"magistrum",	"magistros",
				"magister",		"magistri",
				"magistro",		"magistris"
			});	
	}	
	
	@Test
	public void whenDeclination2ER_I_NON_EX_EN_SimpleounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("magister", "-tri", Gender.M, new String[] {
				"magister",		"magistri",
				"magistri",		"magistrorum",
				"magistro",		"magistris",
				"magistrum",	"magistros",
				"magister",		"magistri",
				"magistro",		"magistris"
			});	
	}		

	@Test
	public void whenDeclination2_US_I_M_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("discipulus", "discipuli", Gender.M, new String[] {
				"discipulus",		"discipuli",
				"discipuli",		"discipulorum",
				"discipulo",		"discipulis",
				"discipulum",		"discipulos",
				"discipule",		"discipuli",
				"discipulo",		"discipulis"
			});	
	}
	
	@Test
	public void whenDeclination2_US_I_M_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("discipulus", "-i", Gender.M, new String[] {
				"discipulus",		"discipuli",
				"discipuli",		"discipulorum",
				"discipulo",		"discipulis",
				"discipulum",		"discipulos",
				"discipule",		"discipuli",
				"discipulo",		"discipulis"
			});	
	}
	
	@Test
	public void whenDeclination2_UM_I_N_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("bellum", "belli", Gender.N, new String[] {
				"bellum",		"bella",
				"belli",		"bellorum",
				"bello",		"bellis",
				"bellum",		"bella",
				"bellum",		"bella",
				"bello",		"bellis"
			});	
	}

	@Test
	public void whenDeclination2_UM_I_N_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("bellum", "-i", Gender.N, new String[] {
				"bellum",		"bella",
				"belli",		"bellorum",
				"bello",		"bellis",
				"bellum",		"bella",
				"bellum",		"bella",
				"bello",		"bellis"
			});	
	}	
	
	@Test
	public void whenDeclination2vir_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("vir", "viri", Gender.M, new String[] {
				"vir",		"viri",
				"viri",		"virorum",
				"viro",		"viris",
				"virum",	"viros",
				"vir",		"viri",
				"viro",		"viris"
			});	
	}

	@Test
	public void whenDeclination2vir_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("vir", "-i", Gender.M, new String[] {
				"vir",		"viri",
				"viri",		"virorum",
				"viro",		"viris",
				"virum",	"viros",
				"vir",		"viri",
				"viro",		"viris"
			});	
	}
	
	/*
	 * Testing modifications for 3. declination 
	 */
	@Test
	public void whenDeclination3or_oris_m_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("senator", "senatoris", Gender.M, new String[] {
				"senator",		"senatores",
				"senatoris",	"senatorum",
				"senatori",		"senatoribus",
				"senatorem",	"senatores",
				"senator",		"senatores",
				"senatore",		"senatoribus"
			});	
	}
	
	@Test
	public void whenDeclination3or_oris_m_Simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("senator", "-oris", Gender.M, new String[] {
				"senator",		"senatores",
				"senatoris",	"senatorum",
				"senatori",		"senatoribus",
				"senatorem",	"senatores",
				"senator",		"senatores",
				"senatore",		"senatoribus"
			});	
	}
	
	@Test
	public void whenDeclination3_as_atis_F_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("civitas", "civitatis", Gender.F, new String[] {
				"civitas",		"civitates",
				"civitatis",	"civitatum",
				"civitati",		"civitatibus",
				"civitatem",	"civitates",
				"civitas",		"civitates",
				"civitate",		"civitatibus"
			});	
	}
	
	@Test
	public void whenDeclination3_as_atis_F_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("civitas", "-atis", Gender.F, new String[] {
				"civitas",		"civitates",
				"civitatis",	"civitatum",
				"civitati",		"civitatibus",
				"civitatem",	"civitates",
				"civitas",		"civitates",
				"civitate",		"civitatibus"
			});	
	}	
	
	@Test
	public void whenDeclination3_us_oris_N_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("tempus", "temporis", Gender.N, new String[] {
				"tempus",		"tempora",
				"temporis",		"temporum",
				"tempori",		"temporibus",
				"tempus",		"tempora",
				"tempus",		"tempora",
				"tempore",		"temporibus"
			});	
	}		
	
	@Test
	public void whenDeclination3_us_oris_N_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("tempus", "-oris", Gender.N, new String[] {
				"tempus",		"tempora",
				"temporis",		"temporum",
				"tempori",		"temporibus",
				"tempus",		"tempora",
				"tempus",		"tempora",
				"tempore",		"temporibus"
			});	
	}		
	
	@Test
	public void whenDeclination3_ns_ntis_M_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("mons", "montis", Gender.M, new String[] {
				"mons",		"montes",
				"montis",	"montium",
				"monti",	"montibus",
				"montem",	"montes",
				"mons",		"montes",
				"monte",	"montibus"
			});	
	}	
	
	@Test
	public void whenDeclination3_ns_ntis_M_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("mons", "-ntis", Gender.M, new String[] {
				"mons",		"montes",
				"montis",	"montium",
				"monti",	"montibus",
				"montem",	"montes",
				"mons",		"montes",
				"monte",	"montibus"
			});	
	}		
	
	@Test
	public void whenDeclination3_es_is_F_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("nubes", "nubis", Gender.F, new String[] {
				"nubes",	"nubes",
				"nubis",	"nubium",
				"nubi",		"nubibus",
				"nubem",	"nubes",
				"nubes",	"nubes",
				"nube",		"nubibus"
			});	
	}	
	
	@Test
	public void whenDeclination3_es_is_F_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("nubes", "-is", Gender.F, new String[] {
				"nubes",	"nubes",
				"nubis",	"nubium",
				"nubi",		"nubibus",
				"nubem",	"nubes",
				"nubes",	"nubes",
				"nube",		"nubibus"
			});	
	}		
	
	@Test
	public void whenDeclination3_al_N_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("animal", "animalis", Gender.N, new String[] {
				"animal",	"animalia",
				"animalis",	"animalium",
				"animali",	"animalibus",
				"animal",	"animalia",
				"animal",	"animalia",
				"animali",	"animalibus"
			});	
	}	
	
	@Test
	public void whenDeclination3_al_N_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("animal", "-alis", Gender.N, new String[] {
				"animal",	"animalia",
				"animalis",	"animalium",
				"animali",	"animalibus",
				"animal",	"animalia",
				"animal",	"animalia",
				"animali",	"animalibus"
			});	
	}		
	
	/*
	 * Testing modifications for 4. declination 
	 */
	
	@Test
	public void whenDeclination4_us__us_M_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("magistratus", "magistratus", Gender.M, new String[] {
				"magistratus",	"magistratus",
				"magistratus",	"magistratuum",
				"magistratui",	"magistratibus",
				"magistratum",	"magistratus",
				"magistratus",	"magistratus",
				"magistratu",	"magistratibus"
			});	
	}
	
	@Test
	public void whenDeclination4_us__us_M_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("magistratus", "-us", Gender.M, new String[] {
				"magistratus",	"magistratus",
				"magistratus",	"magistratuum",
				"magistratui",	"magistratibus",
				"magistratum",	"magistratus",
				"magistratus",	"magistratus",
				"magistratu",	"magistratibus"
			});	
	}
	
	@Test
	public void whenDeclination4_u_us_N_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("cornu", "cornus", Gender.N, new String[] {
				"cornu",	"cornua",
				"cornus",	"cornuum",
				"cornu",	"cornibus",
				"cornu",	"cornua",
				"cornu",	"cornua",
				"cornu",	"cornibus"
			});	
	}
	
	@Test
	public void whenDeclination4_u_us_N_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("cornu", "-us", Gender.N, new String[] {
				"cornu",	"cornua",
				"cornus",	"cornuum",
				"cornu",	"cornibus",
				"cornu",	"cornua",
				"cornu",	"cornua",
				"cornu",	"cornibus"
			});	
	}
	
	/*
	 * Testing modifications for 5. declination 
	 */
	
	@Test
	public void whenDeclination5_res_rei_F_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("res", "rei", Gender.F, new String[] {
				"res",	"res",
				"rei",	"rerum",
				"rei",	"rebus",
				"rem",	"res",
				"res",	"res",
				"re",	"rebus"
			});	
	}

	@Test
	public void whenDeclination5_res_rei_F_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("res", "-ei", Gender.F, new String[] {
				"res",	"res",
				"rei",	"rerum",
				"rei",	"rebus",
				"rem",	"res",
				"res",	"res",
				"re",	"rebus"
			});	
	}
	
	@Test
	public void whenDeclination5_dies_diei_M_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("dies", "diei", Gender.M, new String[] {
				"dies",	"dies",
				"diei",	"dierum",
				"diei",	"diebus",
				"diem",	"dies",
				"dies",	"dies",
				"die",	"diebus"
			});	
	}
	
	@Test
	public void whenDeclination5_dies_diei_M_simple_NounCreatedThenModificationsSuccess(){
		checkModificationsHelpMethod("dies", "-ei", Gender.M, new String[] {
				"dies",	"dies",
				"diei",	"dierum",
				"diei",	"diebus",
				"diem",	"dies",
				"dies",	"dies",
				"die",	"diebus"
			});	
	}
	
	// TODO test 5. declination abstract nouns ( Declination05b.java )
	
	/*
	 * Nouns defined for adjective support
	 */
	
	@Test
	public void whenDeclinationXXaThenModificationsSuccess(){
		checkModificationsHelpMethod("celeber", "celebris", Gender.M, new String[] {
				"celeber", 	"celebres",
				"celebris",	"celebrium",
				"celebri",	"celebribus",
				"celebrem",	"celebres",
				"celeber",	"celebres",
				"celebri",	"celebribus"
		});
	}
	
	@Test
	public void whenDeclinationXXbThenModificationsSuccess(){
		checkModificationsHelpMethod("celebre", "celebris", Gender.N, new String[] {
				"celebre", 	"celebria",
				"celebris",	"celebrium",
				"celebri",	"celebribus",
				"celebre",	"celebria",
				"celebre",	"celebria",
				"celebri",	"celebribus"
		});
	}	
	
	@Test @Ignore
	public void whenDeclinationXXXThenModificationsSuccess(){
		checkModificationsHelpMethod("celebris", "celebris", Gender.F, new String[] {
				"celebris", "celebres",
				"celebris",	"celebrium",
				"celebri",	"celebribus",
				"celebrem",	"celebres",
				"celebris",	"celebres",
				"celebri",	"celebribus"
		});
	}
	
	@Test
	public void whenDeclinationXXd_M_ThenModificationsSuccess(){
		checkModificationsHelpMethod("tristis", "tristis", Gender.M, new String[] {
				"tristis", 	"tristes",
				"tristis",	"tristium",
				"tristi",	"tristibus",
				"tristem",	"tristes",
				"tristis",	"tristes",
				"tristi",	"tristibus"
		});
	}	
	
	@Test
	public void whenDeclinationXXd_F_ThenModificationsSuccess(){
		checkModificationsHelpMethod("tristis", "tristis", Gender.F, org.latin.adjc_declination.provider.Declination03b.class, new String[] {
				"tristis", 	"tristes",
				"tristis",	"tristium",
				"tristi",	"tristibus",
				"tristem",	"tristes",
				"tristis",	"tristes",
				"tristi",	"tristibus"
		});
	}	
	
	
	@Test
	public void whenDeclinationXXd_N_ThenModificationsSuccess(){
		checkModificationsHelpMethod("triste", "tristis", Gender.N, new String[] {
				"triste", 	"tristia",
				"tristis",	"tristium",
				"tristi",	"tristibus",
				"triste",	"tristia",
				"triste",	"tristia",
				"tristi",	"tristibus"
		});
	}
	
	@Test
	public void whenDeclinationXXe_M_ThenModificationsSuccess(){
		checkModificationsHelpMethod("felix", "felicis", Gender.M, new String[] {
				"felix", 	"felices",
				"felicis",	"felicium",
				"felici",	"felicibus",
				"felicem",	"felices",
				"felix",	"felices",
				"felici",	"felicibus"
		});
	}
	
	@Test
	public void whenDeclinationXXe_F_ThenModificationsSuccess(){
		checkModificationsHelpMethod("felix", "felicis", Gender.F, new String[] {
				"felix", 	"felices",
				"felicis",	"felicium",
				"felici",	"felicibus",
				"felicem",	"felices",
				"felix",	"felices",
				"felici",	"felicibus"
		});
	}
	
	@Test
	public void whenDeclinationXXe_N_ThenModificationsSuccess(){
		checkModificationsHelpMethod("felix", "felicis", Gender.N, new String[] {
				"felix", 	"felicia",
				"felicis",	"felicium",
				"felici",	"felicibus",
				"felix",	"felicia",
				"felix",	"felicia",
				"felici",	"felicibus"
		});
	}
	
	@Test
	public void whenER_ERI_M_ThenModificationsSuccess(){
		checkModificationsHelpMethod("miser", "miseri", Gender.M, new String[] {
				"miser", 	"miseri",
				"miseri",	"miserorum",
				"misero",	"miseris",
				"miserum",	"miseros",
				"miser",	"miseri",
				"misero",	"miseris"
		});
	}
	
	@Test
	public void whenERA_ERAE_F_ThenModificationsSuccess(){
		checkModificationsHelpMethod("misera", "miserae", Gender.F, new String[] {
				"misera", 	"miserae",
				"miserae",	"miserarum",
				"miserae",	"miseris",
				"miseram",	"miseras",
				"misera",	"miserae",
				"misera",	"miseris"
		});
	}
	
	@Test
	public void whenERUM_ERI_N_ThenModificationsSuccess(){
		checkModificationsHelpMethod("miserum", "miseri", Gender.N, new String[] {
				"miserum", 	"misera",
				"miseri",	"miserorum",
				"misero",	"miseris",
				"miserum",	"misera",
				"miserum",	"misera",
				"misero",	"miseris"
		});
	}
	
	// TESTING for equality 
	@Test
	public void whenSameFieldsThenBasicNounsEqualSuccess() { 
		BasicNoun basicNoun1 = new BasicNoun("puealla", "puellae", Gender.F);
		BasicNoun basicNoun2 = new BasicNoun("puealla", "puellae", Gender.F);

		assertTrue(basicNoun1.equals(basicNoun2));
	}
	
	// TESTING for equality 
	@Test
	public void whenDiffFieldsThenBasicNounsEqualSuccess() { 
		BasicNoun basicNoun1 = new BasicNoun("pueallaa", "puellae", Gender.F);
		BasicNoun basicNoun2 = new BasicNoun("puealla", "puellae", Gender.F);

		assertFalse(basicNoun1.equals(basicNoun2));
	}
	
}
