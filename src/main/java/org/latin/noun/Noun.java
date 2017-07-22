package org.latin.noun;

import java.util.Map;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.logic_with_oop.Rule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Noun {

	protected @Getter @Setter Gender gender;
	
	protected @Getter @Setter Declination declination;

	protected @Getter @Setter Map<Position, String> positions;
	
	private @Getter Rule rule;
	
	public String get(Position position) {	// TODO see lombok's functionality for this and update everywhere	
		return positions.get(position);
	}
}
