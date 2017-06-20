package org.latin.verb;

public final class FirstPersonSingularPresentEndsWithRule extends VerbRule {

	private String suffix;
	
	public FirstPersonSingularPresentEndsWithRule(BasicVerb basicVerb, String suffix) {
		super(basicVerb);
		this.suffix = suffix;
	}

	@Override
	public boolean accept() {
		return basicVerb.getFirstPersonSingularPresent().endsWith(suffix);
	}

}
