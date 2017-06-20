package org.latin.noun;

import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.common.UnknownDeclination;
import org.latin.common.WordTransformation;

/**
 * Builds full Noun with all modifications from basic noun
 * 
 * @author petarDj
 *
 */
public class NounFactory {
	
	private final NounDeclinationResolver declinationResolver = NounDeclinationResolver.getInstance();
	
	public Noun buildFrom(String nominativeSingular, String genitiveSingular, Gender gender) { 
		return this.buildFrom(nominativeSingular, genitiveSingular, gender, null);
	}
	
	public Noun buildFrom(String nominativeSingular, String genitiveSingular, Gender gender, Class<?> adjectiveClazz) {
		String nominativeSingularResult = nominativeSingular.toLowerCase();
		String genitiveSingularResult = WordTransformation.fullModification(nominativeSingularResult, genitiveSingular.toLowerCase());
		
		return buildFrom(new BasicNoun(nominativeSingularResult, genitiveSingularResult, gender, adjectiveClazz));
	}
	
	private Noun buildFrom(BasicNoun basicNoun)  {		
		NounSatisfier declination = (NounSatisfier) declinationResolver.resolveFrom(basicNoun)
														.orElseThrow(UnknownDeclination::new);
		declination.setBasicNoun(basicNoun);
		
		return new Noun(basicNoun.getGender(), declination.pretty(), declination.getRule(), declination.getPositions());
	}
	
	public BasicNoun buildFrom(Noun noun) { 
		return new BasicNoun(noun.get(Position.NOMINATIVE_SINGULAR), noun.get(Position.GENITIVE_SINGULAR), noun.getGender());
	}
}
