package org.latin.noun;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.latin.common.Declination;
import org.latin.common.Gender;
import org.latin.common.Position;
import org.logic_with_oop.Rule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name="NOUN")
public class Noun {

	@EmbeddedId
	private @Getter @Setter BasicNoun basicNoun;

	@Enumerated(EnumType.STRING)
	@Column(length=3)
	private @Getter @Setter Declination declination;

	@Transient
	private @Getter Rule rule;
	
	@MapKeyEnumerated(EnumType.STRING)
	@ElementCollection(targetClass = String.class)
	private Map<Position, String> positions;
	
	public Noun(BasicNoun basicNoun) { 
		this.basicNoun = basicNoun;
	}
	
	public Noun(BasicNoun basicNoun, Declination declination, Map<Position, String> positions) { 
		this.declination = declination;
		this.positions = positions;
		this.basicNoun = basicNoun;
	}
		
	public Noun(BasicNoun basicNoun, Declination declination, Rule rule, Map<Position, String> positions) { 
		this(basicNoun, declination, positions);
		this.rule = rule;
	}

	public String get(Position position) { 
		return positions.get(position);
	}
	
	public Gender getGender() { 
		return basicNoun.getGender();
	}

}
