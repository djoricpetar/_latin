package org.latin.noun;

public class GenitiveSingularEqualToRule extends NounRule {

	private final String word;
	
	public GenitiveSingularEqualToRule(BasicNoun basicNoun, String word) {
		super(basicNoun);
		this.word = word;
	}
	
	@Override
	public boolean accept() {
		return basicNoun.getGenitiveSingular().equals(word);
	}

	@Override
	public String toString() { 
		return "Genitive singular of " + basicNoun + " equals to \"" + word.toUpperCase() + "\""; 
	}
	
}
