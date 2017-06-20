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

public class Declination04a extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getGenitiveSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"",		"us",
				"us",	"uum",
				"ui",	"ibus",
				"um",	"us",
				"us",	"us",
				"u",	"ibus"
			});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
						new NominativeSingularEndsWithRule(basicNoun, "us"),
						new GenitiveSingularEndsWithRule  (basicNoun, "us"),
						new IsGenderEqualsRule(basicNoun, Gender.M)
					); 
	}

	@Override
	public Declination pretty() {
		return Declination.IV;
	}
	
	@Override
	protected void registerIrregularModifications() {
		updatePosition(Position.NOMINATIVE_SINGULAR, basicNoun.getNominativeSingular());
	}
}
