package org.latin.verb;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name="VERB")
public final class Verb {

	@EmbeddedId
	private @Getter @Setter BasicVerb basicVerb;
	
	
	/* TODO complex times
	private @Getter Adjective adjective;
	*/
	
	@MapKeyEnumerated(EnumType.STRING)
	@ElementCollection(targetClass = String.class)
	private Map<Position, String> positions;
	
	public Verb(BasicVerb basicVerb, Map<Position, String> positions) { 
		this.positions = positions;
		this.basicVerb = basicVerb;
	}
	
	public Verb(BasicVerb basicVerb) { 
		this.basicVerb = basicVerb;
	}
	
	public String get(Position position) { return positions.get(position); }
	
}
