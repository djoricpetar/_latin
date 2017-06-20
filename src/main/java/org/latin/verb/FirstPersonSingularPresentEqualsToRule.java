package org.latin.verb;

public final class FirstPersonSingularPresentEqualsToRule extends VerbRule {

	private final String word;

	public FirstPersonSingularPresentEqualsToRule(BasicVerb basicVerb, String word) {
		super(basicVerb);
		this.word = word;
	}
	
	@Override
	public boolean accept() {
		return basicVerb.getFirstPersonSingularPresent().equals(word);
	}
	
	@Override
	public String toString() { 
		return "First person nominative singular of " + basicVerb + " equals to \"" + word.toUpperCase() + "\"";
	}

}
