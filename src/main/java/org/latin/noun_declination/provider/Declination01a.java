package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Position;
import org.latin.common.WordTransformation;
import org.latin.noun.BasicNoun;
import org.latin.noun.GenitiveSingularEndsWithRule;
import org.latin.noun.NominativeSingularEndsWithRule;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

public final class Declination01a extends NounSatisfier {
	
	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getNominativeSingular(), 1);
	}
	
	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"a",	"ae",
				"ae",	"arum",
				"ae",	"is",
				"am",	"as",
				"a",	"ae",
				"a",	"is"
			});		
	}

	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
						new NominativeSingularEndsWithRule(basicNoun, "a"),
						new GenitiveSingularEndsWithRule  (basicNoun, "ae")
				);
	}
	
	@Override
	public Declination pretty() {
		return Declination.I;
	}

	@Override
	protected void registerIrregularModifications() {}

}
