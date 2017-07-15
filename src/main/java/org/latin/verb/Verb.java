package org.latin.verb;

import java.util.Map;

import org.latin.adjective.Adjective;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public final class Verb {

	private final @Getter Adjective adjective;
	
	private final Map<Position, String> positions;
	
	public String get(Position position) { return positions.get(position); }
	
}
