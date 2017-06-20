package org.latin.noun;

public class CreatedFromAjdectiveRule extends NounRule {

	private final Class<?> createdFromAdjective;
	
	public CreatedFromAjdectiveRule(BasicNoun basicNoun, Class<?> createdFromAdjective) { 
		super(basicNoun);
		this.createdFromAdjective = createdFromAdjective;
	}
	
	@Override
	public boolean accept() {
		return basicNoun.getAdjectiveClassName() == createdFromAdjective;
	}

	@Override
	public String toString() { 
		return "Noun : " + basicNoun + " created from adjective : " + createdFromAdjective;
	}
}
