package org.latin.noun;

import org.latin.common.Gender;

public class IsGenderEqualsRule extends NounRule {

	private Gender gender;
	
	public IsGenderEqualsRule(BasicNoun basicNoun, Gender gender) {
		super(basicNoun);
		this.gender = gender;
	}
	
	@Override
	public boolean accept() {
		return basicNoun.getGender() == gender;
	}

	@Override
	public String toString() { 
		return "Gender of " + basicNoun + " is " + gender;
	}
}
