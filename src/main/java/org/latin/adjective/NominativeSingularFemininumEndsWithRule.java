package org.latin.adjective;

public class NominativeSingularFemininumEndsWithRule extends AdjectiveRule {

	private final String suffix;
	
	public NominativeSingularFemininumEndsWithRule(BasicAdjective basicAdjective, String suffix) {
		super(basicAdjective);
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept() {
		return basicAdjective.getNominativeSingularFemininum().endsWith(suffix);
	}

	@Override
	public String toString() { 
		return "Nominative singular of " + basicAdjective + "ends with \"" + suffix.toUpperCase() + "\"";
	}
}
