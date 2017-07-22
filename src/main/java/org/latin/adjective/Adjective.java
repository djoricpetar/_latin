package org.latin.adjective;

import org.latin.noun.Noun;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Adjective {
	
	protected @Getter @Setter Noun adjectiveMasculinum;
	
	protected @Getter @Setter Noun adjectiveFemininum;
	
	protected @Getter @Setter Noun adjectiveNeutrum;
}
