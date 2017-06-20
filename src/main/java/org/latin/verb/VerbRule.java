package org.latin.verb;

import org.logic_with_oop.Rule;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class VerbRule implements Rule {

	protected final BasicVerb basicVerb;
	
	public abstract boolean accept();

}
