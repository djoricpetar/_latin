package org.latin.verb;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public final class ESSE {

	private static final Map<Position, String> positions = ImmutableMap.<Position, String>builder()
			
			.put(Position.FIRST_PERSON_SINGULAR_PRESENT,  "sum")		.put(Position.FIRST_PERSON_PLURAL_PRESENT, 	"sumus")
			.put(Position.SECOND_PERSON_SINGULAR_PRESENT, "es")			.put(Position.SECOND_PERSON_PLURAL_PRESENT, "estis")
			.put(Position.THIRD_PERSON_SINGULAR_PRESENT,  "est")		.put(Position.THIRD_PERSON_PLURAL_PRESENT, 	"sunt")
			
			.put(Position.FIRST_PERSON_SINGULAR_IMPERFECT, "eram")		.put(Position.FIRST_PERSON_PLURAL_IMPERFECT, "eramus")
			.put(Position.SECOND_PERSON_SINGULAR_IMPERFECT, "eras") 	.put(Position.SECOND_PERSON_PLURAL_IMPERFECT, "eratis")
			.put(Position.THIRD_PERSON_SINGULAR_IMPERFECT, "erat") 		.put(Position.THIRD_PERSON_PLURAL_IMPERFECT, "erant")
			
			.put(Position.FIRST_PERSON_SINGULAR_FUTUR_I, "ero")			.put(Position.FIRST_PERSON_PLURAL_FUTUR_I, "erimus")
			.put(Position.SECOND_PERSON_SINGULAR_FUTUR_I, "eris") 		.put(Position.SECOND_PERSON_PLURAL_FUTUR_I, "eritis")
			.put(Position.THIRD_PERSON_SINGULAR_FUTUR_I, "erit") 		.put(Position.THIRD_PERSON_PLURAL_FUTUR_I, "erunt")
			
			.put(Position.SECOND_PERSON_SINGULAR_IMPERATIVE, "es") 		.put(Position.SECOND_PERSON_PLURAL_IMPERATIVE, "este")
			
			.put(Position.FIRST_PERSON_SINGULAR_PERFECT, "fui")			.put(Position.FIRST_PERSON_PLURAL_PERFECT, "fuimus")
			.put(Position.SECOND_PERSON_SINGULAR_PERFECT, "fuisti") 	.put(Position.SECOND_PERSON_PLURAL_PERFECT, "fuistis")
			.put(Position.THIRD_PERSON_SINGULAR_PERFECT, "fuit") 		.put(Position.THIRD_PERSON_PLURAL_PERFECT, "fuerunt")
			
			.build();
	
	public static String get(Position position) { 
		return positions.get(position);
	}
	
}
