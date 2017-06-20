package org.latin.adjc_declination.provider;

import org.latin.adjective.AdjectiveSatisfier;
import org.latin.adjective.BasicAdjective;
import org.latin.common.Gender;
import org.latin.common.WordHasNonExistingERule;
import org.latin.noun.Noun;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.NotRule;
import org.logic_with_oop.Rule;

public class Declination02a extends AdjectiveSatisfier {

	@Override
	public Rule isSatisfiableBy(BasicAdjective basicAdjective) {
		return 
				new AndRule(
							basicModificationsEndWith(basicAdjective, "er", "era", "erum"),
							new NotRule( new WordHasNonExistingERule(basicAdjective))
						);
	}

	@Override
	public Noun getNounMasculinum() {
		return createNoun(basicAdjective.getNominativeSingularMasculinum(), "-eri", Gender.M);
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
