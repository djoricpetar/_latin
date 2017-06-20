package org.latin.noun;

import org.latin.common.WordTransformation;

public final class NominativeSingularEndsWithTwoConsonantsRule extends NounRule {

	public NominativeSingularEndsWithTwoConsonantsRule(BasicNoun basicNoun) {
		super(basicNoun);
	}

	@Override
	public boolean accept() {
		return WordTransformation.endsWithTwoConsonants(basicNoun.getNominativeSingular());
	}

	@Override
	public String toString() { 
		return "Nominative singular of " + basicNoun + " ends with two consonants";
	}
}
