package org.latin.verb;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.latin.adjective.Adjective;
import org.latin.adjective.AdjectiveFactory;
import org.latin.common.Satisfier;
import org.latin.common.WordTransformation;
import org.logic_with_oop.Rule;

import com.google.common.collect.ImmutableMap;

import lombok.Getter;

/*
 * 1. specto spectare spectavi spectatum
 * 2. video videre vidi visum
 * 3a. cano canere cecini cantum
 * 3b. facio facere feci factum
 * 4. audio audire audivi auditum
 * 
 */

public abstract class VerbSatisfier implements Satisfier<BasicVerb> {

	protected @Getter BasicVerb basicVerb;
	
	protected @Getter String basisPresent;
	
	protected @Getter String basisPerfect;
	
	protected Map<Position, String> suffixes = new HashMap<Position, String>(56);
	
	protected Map<Position, String> positions = new HashMap<Position, String>(56);
	
	public void setBasicVerb(BasicVerb basicVerb) { 
		this.basicVerb = basicVerb;
		
		basisPresent = provideBasisPresent();
		if(basisPresent == null ) { 
			throw new IllegalStateException("You must provide basis present for : " + this.getClass());
		}
		
		basisPerfect = provideBasisPerfect();
		if(basisPerfect == null ) { 
			throw new IllegalStateException("You must provide basis perfect for : " + this.getClass());
		}
		
		suffixes.putAll(provideSuffixesForPresent());
		suffixes.putAll(provideSuffixesForImperative());
		suffixes.putAll(provideSuffixesForImperfect());
		suffixes.putAll(provideSuffixesForFuturI());
		suffixes.putAll(provideSuffixesForPerfect());
		suffixes.putAll(provideSuffixesForPlusQuamPerfect());
		suffixes.putAll(provideSuffixesForFuturII());
		suffixes.putAll(provideSuffixesForPassivePresent());
		suffixes.putAll(provideSuffixesForPassiveImperfect());
		suffixes.putAll(provideSuffixesForPassiveFuturI());
				
		Stream.of(Position.values())
						.forEach(position -> 
									positions.put(position, ( position.builtWith() == BuiltWith.BASIS_PRESENT ? basisPresent : basisPerfect ) + suffixes.get(position)));		
		
		registerIrregularPositions();
	}
	
	protected Adjective createAdjective() { 
		String basis = WordTransformation.stripLastNCharacters(basicVerb.getParticipPerfectPassive(), 2);
		return 
				new AdjectiveFactory().buildFrom(basis + "us", basis + "a", basis + "um"); 
	}
	
	public String get(Position position) { 
		return positions.get(position);
	}
	
	public Map<Position, String> getPositions() { 
		return positions;
	}
	
	protected abstract void registerIrregularPositions();
	
	protected void updatePosition(Position position, String modification) { 
		positions.put(position, modification);
	}
	
	/**
	 * BasicVerb object is implicitly given for this method
	 * and basis can be extracted from that
	 */
	protected abstract String provideBasisPresent();
	
	protected abstract String provideBasisPerfect();
	
	public abstract Rule isSatisfiableBy(BasicVerb basicVerb);

	public abstract ConjugationPretty pretty();
	
	private Map<Position, String> defualtMapCreation(Position[] positions, String[] suffixes) { 
		return ImmutableMap.<Position, String>builder()
				.put(positions[0], 	suffixes[0])	.put(positions[1],	suffixes[1])
				.put(positions[2],	suffixes[2])	.put(positions[3],	suffixes[3]) 
				.put(positions[4],	suffixes[4]) 	.put(positions[5],	suffixes[5]) 
				.build();
	}
	
	/* PRESENT */
	
	protected Map<Position, String> defualtPresentMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_PRESENT,	Position.FIRST_PERSON_PLURAL_PRESENT,
					Position.SECOND_PERSON_SINGULAR_PRESENT,Position.SECOND_PERSON_PLURAL_PRESENT,
					Position.THIRD_PERSON_SINGULAR_PRESENT,	Position.THIRD_PERSON_PLURAL_PRESENT				
				}, 
				suffixes);
	}
		
	protected abstract Map<Position, String> provideSuffixesForPresent();
	
	/* IMPERATIVE */
	
	protected Map<Position, String> defualtImperativeMapCreation(String[] suffixes) { 
		return ImmutableMap.<Position, String>builder()
				.put(Position.SECOND_PERSON_SINGULAR_IMPERATIVE, 	suffixes[0])	 
				.put(Position.SECOND_PERSON_PLURAL_IMPERATIVE,		suffixes[1]) 	
				.build();
	}
	
	protected abstract Map<Position, String> provideSuffixesForImperative();
	
	/* IMPERFECT */
	
	protected Map<Position, String> defualtImperfectMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_IMPERFECT,	Position.FIRST_PERSON_PLURAL_IMPERFECT,
					Position.SECOND_PERSON_SINGULAR_IMPERFECT,	Position.SECOND_PERSON_PLURAL_IMPERFECT,
					Position.THIRD_PERSON_SINGULAR_IMPERFECT,	Position.THIRD_PERSON_PLURAL_IMPERFECT
				}, 
				suffixes);
	}
		
	protected abstract Map<Position, String> provideSuffixesForImperfect();
	
	/* FUTUR I */
	
	protected Map<Position, String> defualtFuturIMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_FUTUR_I,		Position.FIRST_PERSON_PLURAL_FUTUR_I,
					Position.SECOND_PERSON_SINGULAR_FUTUR_I,	Position.SECOND_PERSON_PLURAL_FUTUR_I,
					Position.THIRD_PERSON_SINGULAR_FUTUR_I,		Position.THIRD_PERSON_PLURAL_FUTUR_I
				}, 
				suffixes);
	}
		
	protected abstract Map<Position, String> provideSuffixesForFuturI();
	
	/* PERFECT */
	
	protected Map<Position, String> defualtPerfectMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_PERFECT,		Position.FIRST_PERSON_PLURAL_PERFECT,
					Position.SECOND_PERSON_SINGULAR_PERFECT,	Position.SECOND_PERSON_PLURAL_PERFECT,
					Position.THIRD_PERSON_SINGULAR_PERFECT,		Position.THIRD_PERSON_PLURAL_PERFECT
				}, 
				suffixes);
	}

	protected abstract Map<Position, String> provideSuffixesForPerfect();
	
	/* PLUSQUAMPERFECT */
	
	protected Map<Position, String> defualtPlusQuamPerfecttMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_PLUS_QUAM_PERFECT,	Position.FIRST_PERSON_PLURAL_PLUS_QUAM_PERFECT,
					Position.SECOND_PERSON_SINGULAR_PLUS_QUAM_PERFECT,	Position.SECOND_PERSON_PLURAL_PLUS_QUAM_PERFECT,
					Position.THIRD_PERSON_SINGULAR_PLUS_QUAM_PERFECT,	Position.THIRD_PERSON_PLURAL_PLUS_QUAM_PERFECT
				}, 
				suffixes);
	}

	protected abstract Map<Position, String> provideSuffixesForPlusQuamPerfect();
	
	/* FUTUR II */
	
	protected Map<Position, String> defualtFuturIIMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_FUTUR_II,	Position.FIRST_PERSON_PLURAL_FUTUR_II,
					Position.SECOND_PERSON_SINGULAR_FUTUR_II,	Position.SECOND_PERSON_PLURAL_FUTUR_II,
					Position.THIRD_PERSON_SINGULAR_FUTUR_II,	Position.THIRD_PERSON_PLURAL_FUTUR_II
				}, 
				suffixes);
	}
		
	protected abstract Map<Position, String> provideSuffixesForFuturII();
	
	/* PASSIVE PRESENT */
	
	protected Map<Position, String> defualtPassivePresentMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_PASSIVE_PRESENT,		Position.FIRST_PERSON_PLURAL_PASSIVE_PRESENT,
					Position.SECOND_PERSON_SINGULAR_PASSIVE_PRESENT,	Position.SECOND_PERSON_PLURAL_PASSIVE_PRESENT,
					Position.THIRD_PERSON_SINGULAR_PASSIVE_PRESENT,		Position.THIRD_PERSON_PLURAL_PASSIVE_PRESENT
				}, 
				suffixes);
	}
		
	protected abstract Map<Position, String> provideSuffixesForPassivePresent();
	
	/* PASSIVE IMPERFECT */
	
	protected Map<Position, String> defualtPassiveImperfectMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_PASSIVE_IMPERFECT,	Position.FIRST_PERSON_PLURAL_PASSIVE_IMPERFECT,
					Position.SECOND_PERSON_SINGULAR_PASSIVE_IMPERFECT,	Position.SECOND_PERSON_PLURAL_PASSIVE_IMPERFECT,
					Position.THIRD_PERSON_SINGULAR_PASSIVE_IMPERFECT,	Position.THIRD_PERSON_PLURAL_PASSIVE_IMPERFECT
				}, 
				suffixes);
	}
		
	protected abstract Map<Position, String> provideSuffixesForPassiveImperfect();
	
	/* PASSIVE FUTUR I */
	
	protected Map<Position, String> defualtPassiveFuturIMapCreation(String[] suffixes) { 
		return defualtMapCreation(new Position[] { 
					Position.FIRST_PERSON_SINGULAR_PASSIVE_FUTUR_I,		Position.FIRST_PERSON_PLURAL_PASSIVE_FUTUR_I,
					Position.SECOND_PERSON_SINGULAR_PASSIVE_FUTUR_I,	Position.SECOND_PERSON_PLURAL_PASSIVE_FUTUR_I,
					Position.THIRD_PERSON_SINGULAR_PASSIVE_FUTUR_I,		Position.THIRD_PERSON_PLURAL_PASSIVE_FUTUR_I
				}, 
				suffixes);
	}
		
	protected abstract Map<Position, String> provideSuffixesForPassiveFuturI();
}