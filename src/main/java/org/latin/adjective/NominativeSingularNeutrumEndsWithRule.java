package org.latin.adjective;

public class NominativeSingularNeutrumEndsWithRule extends AdjectiveRule {

	private final String suffix;
	
	public NominativeSingularNeutrumEndsWithRule(BasicAdjective basicAdjective, String suffix) {
		super(basicAdjective);
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept() {
		return basicAdjective.getNominativeSingularNeutrum().endsWith(suffix);
	}

	@Override 
	public String toString() { 
		return "Nominative singular neutrum of " + basicAdjective + " ends with \"" + suffix.toUpperCase() + "\"";
	}
}
