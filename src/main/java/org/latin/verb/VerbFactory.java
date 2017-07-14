package org.latin.verb;

import org.latin.common.UnknownDeclination;

public class VerbFactory {
	
	private ConjugationResolver conjugationResolver = ConjugationResolver.getInstance();
	
	public void setDeclinationResolver(ConjugationResolver conjugationResolver) {
		this.conjugationResolver = conjugationResolver;
	}
	
	public Verb buildFrom(final String firstPersonSingularPresent, final String infinitive, final String firstPersonSingularPerfect, final String participPerfectPassive) { 
		return buildFrom(
				new BasicVerb(firstPersonSingularPresent.toLowerCase(), infinitive.toLowerCase(), firstPersonSingularPerfect.toLowerCase(), participPerfectPassive.toLowerCase()));
	}
	
	private Verb buildFrom(BasicVerb basicVerb)  {		
		VerbSatisfier declination = (VerbSatisfier) conjugationResolver.resolveFrom(basicVerb)
														.orElseThrow(UnknownDeclination::new);
		declination.setBasicVerb(basicVerb);
		
		return new Verb(basicVerb, declination.getPositions());
	}
}
