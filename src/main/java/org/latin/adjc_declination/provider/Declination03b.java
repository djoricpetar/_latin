package org.latin.adjc_declination.provider;

import org.latin.adjective.AdjectiveSatisfier;
import org.latin.adjective.BasicAdjective;
import org.latin.common.Gender;
import org.latin.noun.Noun;
import org.logic_with_oop.Rule;

public class Declination03b extends AdjectiveSatisfier {

	@Override
	public Rule isSatisfiableBy(BasicAdjective basicAdjective) {
		return basicModificationsEndWith(basicAdjective, "is", "is", "e");
	}

	@Override
	public Noun getNounMasculinum() {
		return createNoun(basicAdjective.getNominativeSingularMasculinum(), basicAdjective.getNominativeSingularMasculinum(), Gender.M);
	}

	@Override
	public Noun getNounFemininum() {
		return createNoun(basicAdjective.getNominativeSingularFemininum(), basicAdjective.getNominativeSingularFemininum(), Gender.F, this.getClass());
	}

	@Override
	public Noun getNounNeutrum() {
		return createNoun(basicAdjective.getNominativeSingularNeutrum(), basicAdjective.getNominativeSingularMasculinum(), Gender.N);
	}

}
