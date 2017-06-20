package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.common.WordTransformation;
import org.latin.noun.BasicNoun;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.IsRule;
import org.logic_with_oop.Rule;

public class DeclinationXXc extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getNominativeSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"",		"es",
				"is",	"ium",
				"i",	"ibus",
				"em",	"es",
				"",		"es",
				"a",	"ibus"
			});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new IsRule(
							basicNoun.getNominativeSingular().length() == basicNoun.getGenitiveSingular().length()
							&& basicNoun.getNominativeSingular().endsWith("is")
							&& basicNoun.getGenitiveSingular().endsWith("is")
							&& basicNoun.getGender() == Gender.F
							&& basicNoun.getAdjectiveClassName() != org.latin.adjc_declination.provider.Declination03b.class
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
