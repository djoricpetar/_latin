package org.latin.noun;

public class GenitiveSingularEndsWithRule extends NounRule {

	private final String suffix;
	
	public GenitiveSingularEndsWithRule(BasicNoun basicNoun, String suffix) {
		super(basicNoun);
		this.suffix = suffix;
	}

	@Override
	public boolean accept() {
		return basicNoun.getGenitiveSingular().endsWith(suffix);
	}

	@Override 
	public String toString() { 
		return "Genitive singular of " + basicNoun + " ends with \"" + suffix.toUpperCase() + "\"";
	}
}
