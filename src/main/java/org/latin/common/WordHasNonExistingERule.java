package org.latin.common;

import org.latin.adjective.BasicAdjective;
import org.latin.noun.BasicNoun;
import org.logic_with_oop.Rule;


/* TODO refactor */ 
public final class WordHasNonExistingERule implements Rule {

	private final BasicNoun basicNoun;
	private final BasicAdjective basicAdjective;
	private boolean itIsNoun = false;
	
	public WordHasNonExistingERule(BasicNoun basicNoun) {
		this.basicNoun = basicNoun;
		this.basicAdjective = null;
		itIsNoun = true;
	}
	
	public WordHasNonExistingERule(BasicAdjective basicAdjective) {
		this.basicAdjective = basicAdjective;
		this.basicNoun = null;
	}
	
	@Override
	public boolean accept() {
		return itIsNoun ? WordTransformation.wordHasNonExistingE(basicNoun) : WordTransformation.wordHasNonExistingE(basicAdjective);
	}

	@Override
	public String toString() { 
		return "Basic noun : " + basicNoun + " has non-existing E";
	}
	
}
