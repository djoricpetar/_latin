package org.latin.adjective;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode 
// TODO add tests for basic adjective equality
public class BasicAdjective implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Getter @Setter String nominativeSingularMasculinum;
	
	private @Getter @Setter String nominativeSingularFemininum;
	
	private @Getter @Setter String nominativeSingularNeutrum;
	
	@Override
	public String toString() { 
		return "(" + nominativeSingularMasculinum + ", " + nominativeSingularFemininum + ", " + nominativeSingularNeutrum + ")";
	}
}
