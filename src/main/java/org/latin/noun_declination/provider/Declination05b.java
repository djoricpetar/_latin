package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Position;
import org.latin.common.WordTransformation;
import org.latin.noun.BasicNoun;
import org.latin.noun.GenitiveSingularEndsWithRule;
import org.latin.noun.NominativeSingularEndsWithRule;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

public class Declination05b extends NounSatisfier {

	private String pluralValue = "EMPTY";
	
	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getGenitiveSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"es",	"",
				"ei",	"",
				"ei",	"",
				"em",	"",
				"es",	"",
				"e",	""
			});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
							new NominativeSingularEndsWithRule(basicNoun, "es"),
							new GenitiveSingularEndsWithRule  (basicNoun, "ei")
						); 
	}

	@Override
	public Declination pretty() {
		return Declination.V;
	}

	@Override
	protected void registerIrregularModifications() {
		updatePosition(Position.NOMINATIVE_PLURAL, 	pluralValue);
		updatePosition(Position.GENITIVE_PLURAL, 	pluralValue);
		updatePosition(Position.DATIVE_PLURAL, 		pluralValue);
		updatePosition(Position.ACUSATIVE_PLURAL, 	pluralValue);
		updatePosition(Position.VOCATIVE_PLURAL, 	pluralValue);
		updatePosition(Position.ABLATIVE_PLURAL, 	pluralValue);
	}
}
