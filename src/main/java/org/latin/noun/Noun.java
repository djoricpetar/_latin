package org.latin.noun;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.logic_with_oop.Rule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Noun {

	private final @Getter Gender gender;
	
	private final @Getter Declination declination;

	private final @Getter Rule rule;
	
	private Map<Position, String> positions;
	
	public String get(Position position) {	// TODO see lombok's functionality for this and update everywhere	
		return positions.get(position);
	}
}
