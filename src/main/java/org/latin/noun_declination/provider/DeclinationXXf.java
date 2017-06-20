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

public class DeclinationXXf extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getGenitiveSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return defualtSuffixesMapCreation(new String[] {
				"",		"ia",
				"is",	"ium",
				"i",	"ibus",
				"",		"ia",
				"",		"ia",
				"i",	"ibus"
		});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
							new OrRule(
									new NominativeSingularEndsWithRule(basicNoun, "x"),
									new NominativeSingularEndsWithRule(basicNoun, "ns")
									),
							new OrRule(
									new GenitiveSingularEndsWithRule(basicNoun, "icis"),
									new GenitiveSingularEndsWithRule(basicNoun, "ntis")
									),
							new IsGenderEqualsRule(basicNoun, Gender.N)
						);
	}

	@Override
	public Declination pretty() {
		return null;
	}
	
	@Override
	protected void registerIrregularModifications() {
		updatePosition(Position.NOMINATIVE_SINGULAR, basicNoun.getNominativeSingular());
		updatePosition(Position.ACUSATIVE_SINGURAL,  basicNoun.getNominativeSingular());
		updatePosition(Position.VOCATIVE_SINGULAR,   basicNoun.getNominativeSingular());
	}
}
