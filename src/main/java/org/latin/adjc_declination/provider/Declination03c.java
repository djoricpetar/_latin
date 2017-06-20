package org.latin.adjc_declination.provider;

import org.latin.adjective.AdjectiveSatisfier;
import org.latin.adjective.BasicAdjective;
import org.latin.common.Gender;
import org.latin.noun.Noun;
import org.logic_with_oop.Rule;

public class Declination03c extends AdjectiveSatisfier {

	@Override
	public Rule isSatisfiableBy(BasicAdjective basicAdjective) {
		return basicModificationsEndWith(basicAdjective, "ns", "ns", "ns");
	}

	@Override
	public Noun getNounMasculinum() {
		return createNoun(basicAdjective.getNominativeSingularMasculinum(), "-ntis", Gender.M, this.getClass());
	}

	@Override
	public Noun getNounFemininum() {
		return createNoun(basicAdjective.getNominativeSingularFemininum(), "-ntis", Gender.F, this.getClass());
	}

	@Override
	public Noun getNounNeutrum() {
		return createNoun(basicAdjective.getNominativeSingularNeutrum(), "-ntis", Gender.N);
	}

}
