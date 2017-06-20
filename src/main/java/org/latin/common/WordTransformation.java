package org.latin.common;

import org.latin.adjective.BasicAdjective;
import org.latin.noun.BasicNoun;

import lombok.NonNull;

public class WordTransformation {

	public static String stripLastNCharacters(String word, int n) { 
		return word.substring(0, word.length() - n);
	}
	
	private static boolean wordHasNonExistingE(final @NonNull String firstModification, final @NonNull String secondModification) {
		char thirdCharNom 	= firstModification.charAt(firstModification.length()-3);
		char secondCharNom 	= firstModification.charAt(firstModification.length()-2);
		char firstCharNom 	= firstModification.charAt(firstModification.length()-1);
		
		char thirdCharGen 	= secondModification.charAt(secondModification.length()-3);
		char secondCharGen 	= secondModification.charAt(secondModification.length()-2);
		
		return
				secondCharNom == 'e' && thirdCharNom == thirdCharGen && firstCharNom == secondCharGen;
	}
	
	public static boolean wordHasNonExistingE(BasicNoun basicNoun) { 
		return wordHasNonExistingE(basicNoun.getNominativeSingular(), basicNoun.getGenitiveSingular());
	}
	
	public static boolean wordHasNonExistingE(BasicAdjective basicAdjective) { 
		return wordHasNonExistingE(basicAdjective.getNominativeSingularMasculinum(), basicAdjective.getNominativeSingularFemininum());
	}
	
	public static String fullModification(final @NonNull String nominativeSingular,final @NonNull String genitiveSingular) {
		if ( !genitiveSingular.startsWith("-") )
			return genitiveSingular;
		
		char firstLetterInShortGenitiveForm = genitiveSingular.charAt(1);
			
		int lastIndexOfFirstLeeterOfGenitiveForm = nominativeSingular.lastIndexOf(firstLetterInShortGenitiveForm);
		
		if( nominativeSingular.replaceAll("[^aeiou]", "").length() == 1 && !endsWithTwoConsonants(nominativeSingular) && genitiveSingular.length() == 2)
			return nominativeSingular + genitiveSingular.substring(1);
		
		if( lastIndexOfFirstLeeterOfGenitiveForm == -1 )
			return stripLastNCharacters(nominativeSingular, 2) + genitiveSingular.substring(1);
		
		return	
			nominativeSingular.substring(0, lastIndexOfFirstLeeterOfGenitiveForm) + genitiveSingular.substring(1);
	}
	
	public static boolean endsWithTwoConsonants(final @NonNull String nominativeSingular) {		
		char firstChar = nominativeSingular.charAt(nominativeSingular.length()-1);
		char secondChar = nominativeSingular.charAt(nominativeSingular.length()-2);
		
		return isConsonant(firstChar) && isConsonant(secondChar);
	}
	
	private static boolean isConsonant(char c) { 
		return ! "aeiou".contains(String.valueOf(c));
	}
}
