package org.latin.noun;

public final class NominativeAndGenitiveEqualLengthRule extends NounRule {

	public NominativeAndGenitiveEqualLengthRule(BasicNoun basicNoun) {
		super(basicNoun);
	}

	@Override
	public boolean accept() {
		return basicNoun.getNominativeSingular().length() == basicNoun.getGenitiveSingular().length();
	}

	@Override
	public String toString() { 
		return "Nominative and genitive of : " + basicNoun + " are equal length";
	}
}
