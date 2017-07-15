package org.latin.adjective;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
// TODO add tests for basic adjective equality
public class BasicAdjective {
	
	private @Getter String nominativeSingularMasculinum;
	
	private @Getter String nominativeSingularFemininum;
	
	private @Getter String nominativeSingularNeutrum;
	
	@Override
	public String toString() { 
		return "(" + nominativeSingularMasculinum + ", " + nominativeSingularFemininum + ", " + nominativeSingularNeutrum + ")";
	}
}
