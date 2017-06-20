package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.common.WordHasNonExistingERule;
import org.latin.common.WordTransformation;
import org.latin.noun.BasicNoun;
import org.latin.noun.GenitiveSingularEndsWithRule;
import org.latin.noun.IsGenderEqualsRule;
import org.latin.noun.NominativeSingularEndsWithRule;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

/**
 *  -er -i M with non existing E
 * 
 * @author petarDj
 *
 */
public class Declination02b extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getGenitiveSingular(), 1);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"",		"i",
				"i",	"orum",
				"o",	"is",
				"um",	"os",
				"",		"i",
				"o",	"is"
			});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
							new NominativeSingularEndsWithRule(basicNoun, "er"),
							new GenitiveSingularEndsWithRule  (basicNoun, "i"),
							new IsGenderEqualsRule(basicNoun, Gender.M),
							new WordHasNonExistingERule(basicNoun)
						);
	}

	@Override
	public Declination pretty() {
		return Declination.II;
	}

	@Override
	protected void registerIrregularModifications() {
		updatePosition(Position.NOMINATIVE_SINGULAR, basicNoun.getNominativeSingular());
		updatePosition(Position.VOCATIVE_SINGULAR,   basicNoun.getNominativeSingular());
	}
}
