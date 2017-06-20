package org.latin.noun;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.latin.common.Declination;
import org.latin.common.Position;
import org.latin.common.Satisfier;
import org.logic_with_oop.Rule;

import com.google.common.collect.ImmutableMap;

public abstract class NounSatisfier implements Satisfier<BasicNoun> {
		
	protected BasicNoun basicNoun;
	
	protected String basis;

	private Rule rule;
	
	private Map<Position, String> positions = new HashMap<Position, String>(12);

	private Map<Position, String> suffixes;

	public void setBasicNoun(BasicNoun basicNoun) {
		this.basicNoun = basicNoun;
		basis = provideBase();
		suffixes = provideSuffixes();
		rule = isSatisfiableBy(basicNoun);
		
		Stream.of(Position.values())
				.forEach(position -> positions.put(position, basis + suffixes.get(position)));
		
		// TODO see if guava can make positions map immutable at this moment
		
		registerIrregularModifications();
	}
	
	/**
	 * BasicNoun object is implicitly given for this method
	 * and basis can be extracted from that
	 */
	protected abstract String provideBase();

	protected abstract Map<Position, String> provideSuffixes();

	protected Map<Position, String> defualtSuffixesMapCreation(String[] suffixes) { 
		return ImmutableMap.<Position, String>builder()
				.put(Position.NOMINATIVE_SINGULAR, 	suffixes[0]) 	.put(Position.NOMINATIVE_PLURAL,	suffixes[1])
				.put(Position.GENITIVE_SINGULAR, 	suffixes[2])	.put(Position.GENITIVE_PLURAL,		suffixes[3]) 
				.put(Position.DATIVE_SINGULAR, 		suffixes[4]) 	.put(Position.DATIVE_PLURAL,		suffixes[5]) 
				.put(Position.ACUSATIVE_SINGURAL,	suffixes[6])	.put(Position.ACUSATIVE_PLURAL,		suffixes[7]) 
				.put(Position.VOCATIVE_SINGULAR,	suffixes[8])	.put(Position.VOCATIVE_PLURAL,		suffixes[9]) 
				.put(Position.ABLATIVE_SINGULAR,	suffixes[10]) 	.put(Position.ABLATIVE_PLURAL,		suffixes[11]) 
				.build();
	}
	
	public abstract Rule isSatisfiableBy(BasicNoun basicNoun);
	
	public abstract Declination pretty();
	
	public Rule getRule() { return rule; }
	
	protected abstract void registerIrregularModifications();
	
	protected void updatePosition(Position position, String modification) { 
		positions.put(position, modification);
	}
	
	public Map<Position, String> getPositions() { return positions;	}
}
