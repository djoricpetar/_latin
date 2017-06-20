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

public class DeclinationXXb extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getNominativeSingular(), 1);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation(new String[] {
				"e",	"ia",
				"is",	"ium",
				"i",	"ibus",
				"e",	"ia",
				"e",	"ia",
				"i",	"ibus"
		});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
							new NominativeSingularEndsWithRule(basicNoun, "re"),
							new GenitiveSingularEndsWithRule  (basicNoun, "ris"),
							new IsGenderEqualsRule(basicNoun, Gender.N)
						);
	}

	@Override
	public Declination pretty() {
		return Declination.III;
	}

	@Override
	protected void registerIrregularModifications() {}

}
