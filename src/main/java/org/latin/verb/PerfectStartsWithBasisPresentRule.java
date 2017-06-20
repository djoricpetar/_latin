package org.latin.verb;

import org.latin.common.WordTransformation;

public class PerfectStartsWithBasisPresentRule extends VerbRule {
	
	public PerfectStartsWithBasisPresentRule(BasicVerb basicVerb) {
		super(basicVerb);
	}

	@Override
	public boolean accept() {
		return basicVerb.getFirstPersonSingularPerfect().startsWith(WordTransformation.stripLastNCharacters(basicVerb.getInfinitive(), 3));
	}

	@Override
	public String toString() { 
		return "Perfect of " + basicVerb + " starts with basis present";
	}
}
