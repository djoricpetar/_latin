package org.latin.verb;

import java.util.Map;

import org.latin.adjective.Adjective;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Verb {

	private @Getter Adjective adjective;
	
	protected @Getter @Setter Map<Position, String> positions;
	
	public String get(Position position) { 
		return positions.get(position); 
	}
}
