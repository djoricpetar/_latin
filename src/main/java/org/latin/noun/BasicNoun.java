package org.latin.noun;

import org.latin.common.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
public final class BasicNoun  {
	
	private final @Getter String nominativeSingular;
	
	private final @Getter String genitiveSingular;
	
	private final @Getter Gender gender;
	
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
