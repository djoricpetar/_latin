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
import org.logic_with_oop.OrRule;
import org.logic_with_oop.Rule;

public class DeclinationXXd extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getNominativeSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return defualtSuffixesMapCreation(new String[] {
			"is",	"es",
			"is",	"ium",
			"i",	"ibus",
			"em",	"es",
			"is",	"es",
			"i",	"ibus"
		});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
							new NominativeSingularEndsWithRule(basicNoun, "is"),
							new GenitiveSingularEndsWithRule  (basicNoun, "is"),
							new OrRule(
										new IsGenderEqualsRule(basicNoun, Gender.M),
										new IsGenderEqualsRule(basicNoun, Gender.F)
									)
						);
	}

	@Override
	public Declination pretty() {
		return null;
	}

	@Override
	protected void registerIrregularModifications() {}

}
