package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.common.WordTransformation;
import org.latin.noun.BasicNoun;
import org.latin.noun.GenitiveSingularEqualToRule;
import org.latin.noun.IsGenderEqualsRule;
import org.latin.noun.NominativeSingularEqualToRule;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.OrRule;
import org.logic_with_oop.Rule;

public class Declination05a extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getGenitiveSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
					"es",	"es",
					"ei",	"erum",
					"ei",	"ebus",
					"em",	"es",
					"es",	"es",
					"e",	"ebus"
				});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new OrRule(
							new AndRule(
										new NominativeSingularEqualToRule(basicNoun, "res"), 
										new GenitiveSingularEqualToRule  (basicNoun, "rei"),
										new IsGenderEqualsRule(basicNoun, Gender.F)
									),
							new AndRule(
										new NominativeSingularEqualToRule(basicNoun, "dies"),
										new GenitiveSingularEqualToRule  (basicNoun, "diei"),
										new IsGenderEqualsRule(basicNoun, Gender.M)
									)
						); 
	}

	@Override
	public Declination pretty() {
		return Declination.V;
	}

	@Override
	protected void registerIrregularModifications() {}
}
