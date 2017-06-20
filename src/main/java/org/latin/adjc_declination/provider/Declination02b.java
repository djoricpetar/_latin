package org.latin.adjc_declination.provider;

import org.latin.adjective.AdjectiveSatisfier;
import org.latin.adjective.BasicAdjective;
import org.latin.common.Gender;
import org.latin.common.WordHasNonExistingERule;
import org.latin.common.WordTransformation;
import org.latin.noun.Noun;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

public class Declination02b extends AdjectiveSatisfier {

	@Override
	public Rule isSatisfiableBy(BasicAdjective basicAdjective) {
		return 
				new AndRule(
							basicModificationsEndWith(basicAdjective, "er", "a", "um"),
							new WordHasNonExistingERule(basicAdjective)
						);
	}

	@Override
	public Noun getNounMasculinum() {
		return createNoun(basicAdjective.getNominativeSingularMasculinum(), WordTransformation.stripLastNCharacters(basicAdjective.getNominativeSingularFemininum(), 1) + "i", Gender.M);
	}

	@Override
	public Noun getNounFemininum() {
		return createNoun(basicAdjective.getNominativeSingularFemininum(), "-ae", Gender.F);
	}

	@Override
	public Noun getNounNeutrum() {
		return createNoun(basicAdjective.getNominativeSingularNeutrum(), "-i", Gender.N);
	}
	
}
