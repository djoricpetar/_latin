package org.latin.verb;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
// TODO add tests for basic verb equality
public final class BasicVerb {
	
	private final @Getter String firstPersonSingularPresent;
	
	private final @Getter String infinitive;
	
	private final @Getter String firstPersonSingularPerfect;
	
	private final @Getter String participPerfectPassive;
	
	@Override 
	public String toString() { 
		return "(" + firstPersonSingularPresent + ", " + infinitive + ", " + firstPersonSingularPerfect + ")";
	}
}
