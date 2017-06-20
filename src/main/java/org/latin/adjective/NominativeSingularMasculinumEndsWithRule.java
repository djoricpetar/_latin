package org.latin.adjective;

public final class NominativeSingularMasculinumEndsWithRule extends AdjectiveRule {

	private final String suffix;
	
	public NominativeSingularMasculinumEndsWithRule(BasicAdjective basicAdjective, String suffix) {
		super(basicAdjective);
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept() {
		return basicAdjective.getNominativeSingularMasculinum().endsWith(suffix);
	}

	@Override
	public String toString() { 
		return "Nominative singular masculinum of " + basicAdjective + " ends with \"" + suffix.toUpperCase() + "\"";
	}
}
