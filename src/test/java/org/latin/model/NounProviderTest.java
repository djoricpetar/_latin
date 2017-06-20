package org.latin.model;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.latin.common.Gender;
import org.latin.common.UnknownDeclination;
import org.latin.noun.BasicNoun;
import org.latin.noun.NounDeclinationResolver;
import org.latin.noun.NounSatisfier;

/**
 * Implementation specific tests
 * 
 * @author petarDj
 *
 */
public class NounProviderTest extends NounTests {
	
	private void assertThatSameClasses(String nom, String gen, Gender gender, Class<? extends NounSatisfier> clazz) {
		NounSatisfier declination = (NounSatisfier) NounDeclinationResolver.getInstance().resolveFrom(new BasicNoun(nom, gen, gender))
																										.orElseThrow(UnknownDeclination::new);
		
		assertEquals(clazz, declination.getClass());
	}
	
	@Test
	public void whenA_AE_F_then01a() {
		assertThatSameClasses("fabula", "ae", Gender.F, 
								org.latin.noun_declination.provider.Declination01a.class);
	}
	
	@Test
	public void whenER_ERI_M_then02a() {
		assertThatSameClasses("puer", "pueri", Gender.M, 
								org.latin.noun_declination.provider.Declination02a.class);
	}
	
	@Test
	@Ignore("check later, clogging the report")
	public void whenE_IS_N_then02a() {
		assertThatSameClasses("triste", "tristis", Gender.N, 
								org.latin.noun_declination.provider.Declination02a.class);
	}
	
	/*
	 * 	Used as part of Adjective Declination2a masculinum part
	 */
	@Test
	public void whenER_ERI_Mthen02a() { 
		assertThatSameClasses("miser", "miseri", Gender.M, 
								org.latin.noun_declination.provider.Declination02a.class);
	}
	
	/*
	 * 	Used as part of Adjective Declination2a femininum part
	 */
	@Test
	public void whenERA_ERAE_Fthen01a() { 
		assertThatSameClasses("misera", "miserae", Gender.F, 
								org.latin.noun_declination.provider.Declination01a.class);
	}
	
	/*
	 * 	Used as part of Adjective Declination2a neutrum part
	 */
	@Test
	public void whenERUM_ERI_Nthen02d() { 
		assertThatSameClasses("miserum", "miseri", Gender.N, 
								org.latin.noun_declination.provider.Declination02d.class);
	}
	
}
