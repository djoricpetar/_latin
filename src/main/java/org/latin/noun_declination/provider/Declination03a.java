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

public class Declination03a extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getGenitiveSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"",		"es",
				"is",	"um",
				"i",	"ibus",
				"em",	"es",
				"",		"es",
				"e",	"ibus"
			});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new OrRule(
							new AndRule(
									new NominativeSingularEndsWithRule(basicNoun, "or"),
									new GenitiveSingularEndsWithRule  (basicNoun, "oris"),
									new IsGenderEqualsRule(basicNoun, Gender.M)
								),
							new AndRule(
									new NominativeSingularEndsWithRule(basicNoun, "as"),
									new GenitiveSingularEndsWithRule  (basicNoun, "atis"),
									new IsGenderEqualsRule(basicNoun, Gender.F)
								)
						);
	}

	@Override
	public Declination pretty() {
		return Declination.III;
	}
	
	@Override
	protected void registerIrregularModifications() {
		updatePosition(Position.NOMINATIVE_SINGULAR, basicNoun.getNominativeSingular());
		updatePosition(Position.VOCATIVE_SINGULAR,   basicNoun.getNominativeSingular());
	}
}
