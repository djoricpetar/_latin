package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.noun.BasicNoun;
import org.latin.noun.GenitiveSingularEqualToRule;
import org.latin.noun.IsGenderEqualsRule;
import org.latin.noun.NominativeSingularEqualToRule;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

public final class Declination02e extends NounSatisfier {
	
	@Override
	protected String provideBase() {
		return "vir";
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
						new NominativeSingularEqualToRule(basicNoun, "vir"),
						new GenitiveSingularEqualToRule  (basicNoun, "viri"),
						new IsGenderEqualsRule(basicNoun, Gender.M)
					); 
	}

	@Override
	public Declination pretty() {
		return Declination.II;
	}

	@Override
	protected void registerIrregularModifications() {
		updatePosition(Position.NOMINATIVE_SINGULAR, basis);
		updatePosition(Position.VOCATIVE_SINGULAR,   basis);
	}
}
