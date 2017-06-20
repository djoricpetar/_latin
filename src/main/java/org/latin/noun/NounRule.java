package org.latin.noun;

import org.logic_with_oop.Rule;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NounRule implements Rule {

	protected final BasicNoun basicNoun;
	
	public abstract boolean accept(); 

}
