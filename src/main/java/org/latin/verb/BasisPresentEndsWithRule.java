package org.latin.verb;

import org.latin.common.WordTransformation;

public class BasisPresentEndsWithRule extends VerbRule {
	
	private final String suffix;
	
	public BasisPresentEndsWithRule(BasicVerb basicVerb, String suffix) {
		super(basicVerb);
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept() {
		return WordTransformation.stripLastNCharacters(basicVerb.getInfinitive(), 2).endsWith(suffix);
	}

	@Override
	public String toString() { 
		return "Basis present of : " + basicVerb + " ends with \"" + suffix.toUpperCase() + "\"";
	}
	
}
