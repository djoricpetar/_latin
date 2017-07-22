package org.latin.verb;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// TODO add tests for basic verb equality
public class BasicVerb {
	
	protected @Getter @Setter String firstPersonSingularPresent;
	
	protected @Getter @Setter String infinitive;
	
	protected @Getter @Setter String firstPersonSingularPerfect;
	
	protected @Getter @Setter String participPerfectPassive;
	
	@Override 
	public String toString() { 
		return "(" + firstPersonSingularPresent + ", " + infinitive + ", " + firstPersonSingularPerfect + ")";
	}
}
