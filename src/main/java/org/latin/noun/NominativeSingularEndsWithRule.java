package org.latin.noun;

public class NominativeSingularEndsWithRule extends NounRule {

	private final String suffix;
	
	public NominativeSingularEndsWithRule(BasicNoun basicNoun, String suffix) {
		super(basicNoun);
		this.suffix = suffix;
	}

	@Override
	public boolean accept() {
		return basicNoun.getNominativeSingular().endsWith(suffix);
	}

	@Override
	public String toString() { 
		return "Nominative singular of " + basicNoun + " ends with \"" + suffix.toUpperCase() + "\"";
	}
	
}
