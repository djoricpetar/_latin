package org.latin.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.latin.verb.ESSE;
import org.latin.verb.POSSE;
import org.latin.verb.Position;

public class EsseModificationsTest extends VerbTests {

	@Test
	public void esseModificationsPresent() { 
		assertEquals("sum", 	ESSE.get(Position.FIRST_PERSON_SINGULAR_PRESENT));
		assertEquals("es",  	ESSE.get(Position.SECOND_PERSON_SINGULAR_PRESENT));
		assertEquals("est",  	ESSE.get(Position.THIRD_PERSON_SINGULAR_PRESENT));

		assertEquals("sumus", 	ESSE.get(Position.FIRST_PERSON_PLURAL_PRESENT));
		assertEquals("estis",  	ESSE.get(Position.SECOND_PERSON_PLURAL_PRESENT));
		assertEquals("sunt",  	ESSE.get(Position.THIRD_PERSON_PLURAL_PRESENT));
	}

	@Test
	public void esseModificationsImperfect() { 
		assertEquals("eram", 	ESSE.get(Position.FIRST_PERSON_SINGULAR_IMPERFECT));
		assertEquals("eras",  	ESSE.get(Position.SECOND_PERSON_SINGULAR_IMPERFECT));
		assertEquals("erat",  	ESSE.get(Position.THIRD_PERSON_SINGULAR_IMPERFECT));

		assertEquals("eramus", 	ESSE.get(Position.FIRST_PERSON_PLURAL_IMPERFECT));
		assertEquals("eratis",  ESSE.get(Position.SECOND_PERSON_PLURAL_IMPERFECT));
		assertEquals("erant",  	ESSE.get(Position.THIRD_PERSON_PLURAL_IMPERFECT));
	}
	
	@Test
	public void esseModificationsFuturI() { 
		assertEquals("ero", 	ESSE.get(Position.FIRST_PERSON_SINGULAR_FUTUR_I));
		assertEquals("eris",  	ESSE.get(Position.SECOND_PERSON_SINGULAR_FUTUR_I));
		assertEquals("erit",  	ESSE.get(Position.THIRD_PERSON_SINGULAR_FUTUR_I));

		assertEquals("erimus", 	ESSE.get(Position.FIRST_PERSON_PLURAL_FUTUR_I));
		assertEquals("eritis",  ESSE.get(Position.SECOND_PERSON_PLURAL_FUTUR_I));
		assertEquals("erunt",  	ESSE.get(Position.THIRD_PERSON_PLURAL_FUTUR_I));
	}
	
	@Test
	public void esseModificationsImperative() { 
		assertEquals("es",  	ESSE.get(Position.SECOND_PERSON_SINGULAR_IMPERATIVE));

		assertEquals("este",  	ESSE.get(Position.SECOND_PERSON_PLURAL_IMPERATIVE));
	}
	
	@Test
	public void esseModificationsPerfect() { 
		assertEquals("fui", 		ESSE.get(Position.FIRST_PERSON_SINGULAR_PERFECT));
		assertEquals("fuisti",  	ESSE.get(Position.SECOND_PERSON_SINGULAR_PERFECT));
		assertEquals("fuit",  		ESSE.get(Position.THIRD_PERSON_SINGULAR_PERFECT));

		assertEquals("fuimus", 		ESSE.get(Position.FIRST_PERSON_PLURAL_PERFECT));
		assertEquals("fuistis",  	ESSE.get(Position.SECOND_PERSON_PLURAL_PERFECT));
		assertEquals("fuerunt",  	ESSE.get(Position.THIRD_PERSON_PLURAL_PERFECT));
	}
	
	@Test
	public void posseModificationsPresent() { 
		assertEquals("possum", 		POSSE.get(Position.FIRST_PERSON_SINGULAR_PRESENT));
		assertEquals("potes",  		POSSE.get(Position.SECOND_PERSON_SINGULAR_PRESENT));
		assertEquals("potest",  	POSSE.get(Position.THIRD_PERSON_SINGULAR_PRESENT));

		assertEquals("possumus", 	POSSE.get(Position.FIRST_PERSON_PLURAL_PRESENT));
		assertEquals("potestis",  	POSSE.get(Position.SECOND_PERSON_PLURAL_PRESENT));
		assertEquals("possunt",  	POSSE.get(Position.THIRD_PERSON_PLURAL_PRESENT));
	}
}
