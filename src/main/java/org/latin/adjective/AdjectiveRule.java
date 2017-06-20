package org.latin.adjective;

import org.logic_with_oop.Rule;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AdjectiveRule implements Rule {
	
	protected final BasicAdjective basicAdjective;
	
	public abstract boolean accept(); 

}
