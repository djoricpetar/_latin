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

/**
 * For Declination 3 adjectives e.g. celeber, -bris, M
 * 
 * @author petarDj
 *
 */
public class DeclinationXXa extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(this.basicNoun.getGenitiveSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation(new String[] {
				"er",	"es",
				"is",	"ium",
				"i",	"ibus",
				"em",	"es",
				"er",	"es",
				"i",	"ibus"
		});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return new AndRule(
					new NominativeSingularEndsWithRule(basicNoun, "er"),
					new GenitiveSingularEndsWithRule  (basicNoun, "is")
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
