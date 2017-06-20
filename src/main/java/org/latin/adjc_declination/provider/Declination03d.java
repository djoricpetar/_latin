package org.latin.adjc_declination.provider;

import org.latin.adjective.AdjectiveSatisfier;
import org.latin.adjective.BasicAdjective;
import org.latin.common.Gender;
import org.latin.noun.Noun;
import org.logic_with_oop.Rule;

public class Declination03d extends AdjectiveSatisfier {

	@Override
	public Rule isSatisfiableBy(BasicAdjective basicAdjective) {
		return basicModificationsEndWith(basicAdjective, "x", "x", "x");
	}

	@Override
	public Noun getNounMasculinum() {
		return createNoun(basicAdjective.getNominativeSingularMasculinum(), "-icis", Gender.M);
	}

	@Override
	public Noun getNounFemininum() {
		return createNoun(basicAdjective.getNominativeSingularFemininum(), "-icis", Gender.F);
	}

	@Override
	public Noun getNounNeutrum() {
		return createNoun(basicAdjective.getNominativeSingularNeutrum(), "-icis", Gender.N);
	}

}
