package org.latin.adjective;

import org.latin.common.UnknownDeclination;
import org.latin.common.WordTransformation;
import org.latin.noun.Noun;

public final class AdjectiveFactory {

	private AdjectiveDeclinationResolver declinationResolver = AdjectiveDeclinationResolver.getInstance();
	
	public Adjective buildFrom(String nominativeSingularMasculium, String nominativeSingularFemininum, String nominativeSingularNeutrum) { 
		String nominativeSinMResult = nominativeSingularMasculium.toLowerCase();
		
		String nominativeSinFResult = WordTransformation.fullModification(nominativeSinMResult, nominativeSingularFemininum.toLowerCase());
		String nominativeSinNResult = WordTransformation.fullModification(nominativeSinMResult, nominativeSingularNeutrum  .toLowerCase());
	
		return this.buildFrom(new BasicAdjective(nominativeSinMResult, nominativeSinFResult, nominativeSinNResult));
	}
	
	public Adjective buildFrom(BasicAdjective basicWord)  {		
		AdjectiveSatisfier declination = (AdjectiveSatisfier) declinationResolver.resolveFrom(basicWord)
														.orElseThrow(UnknownDeclination::new);
				
		declination.setBasicAdjective(basicWord);
	
		Noun masculinum	= declination.getNounMasculinum();
		Noun femininum 	= declination.getNounFemininum ();
		Noun neutrum	= declination.getNounNeutrum   ();
				
		return new Adjective(masculinum, femininum, neutrum);
	}
}
