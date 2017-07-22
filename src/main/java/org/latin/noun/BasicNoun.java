package org.latin.noun;

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

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode 
public class BasicNoun  {
	
	protected @Getter @Setter String nominativeSingular;
	
	protected @Getter @Setter String genitiveSingular;
	
	protected @Getter @Setter Gender gender;
	
	/* support for nouns created from adjectives */
	private @Getter Class<?> adjectiveClassName;
	
	public BasicNoun(String nominativeSingular, String genitiveSingular, Gender gender) { 
		this(nominativeSingular, genitiveSingular, gender, null);
	}

	@Override
	public String toString() {
		return "(" + nominativeSingular + ", " + genitiveSingular + ", " + gender + ")";
	}
}
