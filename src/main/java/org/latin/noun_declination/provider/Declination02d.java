package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.common.WordTransformation;
import org.latin.noun.BasicNoun;
import org.latin.noun.GenitiveSingularEndsWithRule;
import org.latin.noun.IsGenderEqualsRule;
import org.latin.noun.NominativeSingularEndsWithRule;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

// -um -i N
public final class Declination02d extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getNominativeSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"um",	"a",
				"i",	"orum",
				"o",	"is",
				"um",	"a",
				"um",	"a",
				"o",	"is"
			});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
						new NominativeSingularEndsWithRule(basicNoun, "um"),
						new GenitiveSingularEndsWithRule  (basicNoun, "i"),
						new IsGenderEqualsRule(basicNoun, Gender.N)
					); 
	}

	@Override
	public Declination pretty() {
		return Declination.II;
	}

	@Override
	protected void registerIrregularModifications() {}
}
