package org.latin.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.latin.common.UnknownDeclination;
import org.latin.verb.BasicVerb;
import org.latin.verb.ConjugationResolver;
import org.latin.verb.VerbSatisfier;

public class VerbProviderTest extends VerbTests {

	private final ConjugationResolver resolver = ConjugationResolver.getInstance();
	
	private void assertThatSameClasses(String arg1, String arg2, String arg3, String arg4, Class<? extends VerbSatisfier> clazz) { 
		VerbSatisfier satisfier = (VerbSatisfier) resolver.resolveFrom(new BasicVerb(arg1, arg2, arg3, arg4))
																			.orElseThrow(UnknownDeclination::new);
		assertEquals(clazz, satisfier.getClass());
	}
	
	@Test
	public void whenAThen01ConjugationClassSuccess() { 
		assertThatSameClasses("specto", "spectare", "spectavi", "spectatum", 
													org.latin.verb_conjugation.provider.Conjugation01.class);
	}

	@Test
	public void whenEhen02ConjugationClassSuccess() { 
		assertThatSameClasses("video", "videre", "vidi", "visum", 
													org.latin.verb_conjugation.provider.Conjugation02.class);
	}
	
	@Test
	public void whenEhen03aConjugationClassSuccess() { 
		assertThatSameClasses("cano", "canere", "cecini", "cantum", 
													org.latin.verb_conjugation.provider.Conjugation03a.class);
	}
	
	@Test
	public void whenEhen03bConjugationClassSuccess() { 
		assertThatSameClasses("facio", "facere", "feci", "factum", 
													org.latin.verb_conjugation.provider.Conjugation03b.class);
	}
	
	@Test
	public void whenIhen04ConjugationClassSuccess() { 
		assertThatSameClasses("audio", "audire", "audivi", "auditum", 
													org.latin.verb_conjugation.provider.Conjugation04.class);
	}
}
