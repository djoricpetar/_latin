package org.latin.noun;

public final class NominativeSingularEqualToRule extends NounRule {

	private final String word;
	
	public NominativeSingularEqualToRule(BasicNoun basicNoun, String word) {
		super(basicNoun);
		this.word = word;
	}
	
	@Override
	public boolean accept() {
		return basicNoun.getNominativeSingular().equals(word);
	}

	@Override
	public String toString() { 
		return "Nominative singular of " + basicNoun + " equal to \"" + word.toUpperCase() + "\"";
	}
	
}
