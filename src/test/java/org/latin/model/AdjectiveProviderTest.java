package org.latin.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.latin.adjective.AdjectiveDeclinationResolver;
import org.latin.adjective.AdjectiveSatisfier;
import org.latin.adjective.BasicAdjective;
import org.latin.common.UnknownDeclination;

public class AdjectiveProviderTest extends AdjectiveTests {

	private AdjectiveDeclinationResolver declinationResolver = AdjectiveDeclinationResolver.getInstance();
	
	private void assertThatSameClasses(String nomM, String nomF, String nomN, Class<? extends AdjectiveSatisfier> clazz) {
		AdjectiveSatisfier declination = (AdjectiveSatisfier) declinationResolver.resolveFrom(new BasicAdjective(nomM, nomF, nomN))
																											.orElseThrow(UnknownDeclination::new);
		assertEquals(clazz, declination.getClass());
	}
	
	@Test
	public void whenUS_A_UM_then_01a() {
		assertThatSameClasses("magnus", "magna", "magnum",
								org.latin.adjc_declination.provider.Declination01a.class );
	}
	
	@Test
	public void whenER_A_UM_withoutNonExistingE_then_02a() {
		assertThatSameClasses("miser", "misera", "miserum",
								org.latin.adjc_declination.provider.Declination02a.class );
	}

	@Test
	public void whenER_A_UM_withNonExistingE_then_02b() {
		assertThatSameClasses("pulcher", "pulchra", "pulchrum",
								org.latin.adjc_declination.provider.Declination02b.class );
	}
	
	@Test
	public void whenER_IS_E_then_02a() {
		assertThatSameClasses("celeber", "celebris", "celebre",
								org.latin.adjc_declination.provider.Declination03a.class );
	}
}
