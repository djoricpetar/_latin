package org.latin.verb;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public final class POSSE {

	private static final Map<Position, String> positions = ImmutableMap.<Position, String>builder()
			
			.put(Position.FIRST_PERSON_SINGULAR_PRESENT,  "possum")		.put(Position.FIRST_PERSON_PLURAL_PRESENT, 	"possumus")
			.put(Position.SECOND_PERSON_SINGULAR_PRESENT, "potes")		.put(Position.SECOND_PERSON_PLURAL_PRESENT, "potestis")
			.put(Position.THIRD_PERSON_SINGULAR_PRESENT,  "potest")		.put(Position.THIRD_PERSON_PLURAL_PRESENT, 	"possunt")
			
			.build();
	
	public static String get(Position position) {
		return positions.get(position);
	}
	
}
