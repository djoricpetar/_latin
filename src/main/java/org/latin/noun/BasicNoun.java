package org.latin.noun;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import org.latin.common.Gender;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Container for main Noun modifications :
 *	<ol>
 *		<li>Nominative Singular</li>
 *		<li>Genitive Singular</li>
 *		<li>Gender</li>
 *	</ol>
 * 
 * @author petarDj
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode 
public final class BasicNoun implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private @Getter @Setter String nominativeSingular;
	
	private @Getter @Setter String genitiveSingular;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="CHARACTER(1)")
	private @Getter @Setter Gender gender;
	
	/**
	 * If not null, tells that this basic noun is not created 
	 * with 'regular' rules described in the book, but with
	 * custom defined rules for nouns created during adjective creation
	 */
	@Transient
	private @Getter Class<?> adjectiveClassName;
	
	public BasicNoun(String nominativeSingular, String genitiveSingular, Gender gender) { 
		this(nominativeSingular, genitiveSingular, gender, null);
	}
	
	@Override
	public String toString() {
		return "(" + nominativeSingular + ", " + genitiveSingular + ", " + gender + ")";
	}
}
