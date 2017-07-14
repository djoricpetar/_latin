package org.latin.verb;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
// TODO add tests for basic verb equality
public final class BasicVerb implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length=30)
	private @Getter @Setter String firstPersonSingularPresent;
	
	@Column(length=30)
	private @Getter @Setter String infinitive;
	
	@Column(length=30)
	private @Getter @Setter String firstPersonSingularPerfect;
	
	@Column(length=30)
	private @Getter @Setter String participPerfectPassive;
	
	@Override 
	public String toString() { 
		return "(" + firstPersonSingularPresent + ", " + infinitive + ", " + firstPersonSingularPerfect + ")";
	}
}
