package org.latin.adjective;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// TODO add tests for basic adjective equality
public class BasicAdjective {
	
	protected @Getter @Setter String nominativeSingularMasculinum;
	
	protected @Getter @Setter String nominativeSingularFemininum;
	
	protected @Getter @Setter String nominativeSingularNeutrum;
	
	@Override
	public String toString() { 
		return "(" + nominativeSingularMasculinum + ", " + nominativeSingularFemininum + ", " + nominativeSingularNeutrum + ")";
	}
}
