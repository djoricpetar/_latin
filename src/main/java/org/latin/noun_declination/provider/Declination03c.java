package org.latin.noun_declination.provider;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.latin.common.WordTransformation;
import org.latin.noun.BasicNoun;
import org.latin.noun.CreatedFromAjdectiveRule;
import org.latin.noun.GenitiveSingularEndsWithRule;
import org.latin.noun.IsGenderEqualsRule;
import org.latin.noun.NominativeAndGenitiveEqualLengthRule;
import org.latin.noun.NominativeSingularEndsWithRule;
import org.latin.noun.NominativeSingularEndsWithTwoConsonantsRule;
import org.latin.noun.NounSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.NotRule;
import org.logic_with_oop.OrRule;
import org.logic_with_oop.Rule;

public class Declination03c extends NounSatisfier {

	@Override
	protected String provideBase() {
		return WordTransformation.stripLastNCharacters(basicNoun.getGenitiveSingular(), 2);
	}

	@Override
	protected Map<Position, String> provideSuffixes() {
		return this.defualtSuffixesMapCreation( new String[] { 	
				"",		"es",
				"is",	"ium",
				"i",	"ibus",
				"em",	"es",
				"",		"es",
				"e",	"ibus"
			});
	}

	@Override
	public Rule isSatisfiableBy(BasicNoun basicNoun) {
		return 
				new AndRule(
							new OrRule(
										new IsGenderEqualsRule(basicNoun, Gender.M),
										new IsGenderEqualsRule(basicNoun, Gender.F)
									),
							new OrRule(
										new NominativeSingularEndsWithTwoConsonantsRule(basicNoun),
										new NominativeAndGenitiveEqualLengthRule(basicNoun)
									),
							
							/*
							 * Following rules are exceptions rather than rules stated in book. 
							 * They are explicitly stated here to avoid collision with other declinations
							 * ( which was discovered during testing ).
							 */
							
							new NotRule(
										new AndRule(
													new NominativeSingularEndsWithRule(basicNoun, "us"),
													new GenitiveSingularEndsWithRule  (basicNoun, "us")
												)
									),
							new NotRule(
										new AndRule(
													new NominativeSingularEndsWithRule(basicNoun, "es"),
													new GenitiveSingularEndsWithRule  (basicNoun, "ei")
												)
								),
							new NotRule(
										new AndRule(
													new NominativeSingularEndsWithRule(basicNoun, "is"),
													new GenitiveSingularEndsWithRule  (basicNoun, "is")
												)
								),
							new CreatedFromAjdectiveRule(basicNoun, null)
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
