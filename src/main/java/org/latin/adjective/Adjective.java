package org.latin.adjective;

import org.latin.noun.Noun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Adjective {
	
	private @Getter Noun adjectiveMasculinum;
	
	private @Getter Noun adjectiveFemininum;
	
	private @Getter Noun adjectiveNeutrum;
}
