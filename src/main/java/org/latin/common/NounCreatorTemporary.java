package org.latin.common;

import org.latin.noun.Noun;
import org.latin.noun.NounFactory;

public class NounCreatorTemporary {

	public static Noun createNoun(String nominativeSingular, String genitiveSingular, Gender gender) { 
		return createNoun(nominativeSingular, genitiveSingular, gender, null);
	}
	
	public static Noun createNoun(String nominativeSingular, String genitiveSingular, Gender gender, Class<?> adjectiveClazz) { 
		return new NounFactory().buildFrom(nominativeSingular, genitiveSingular, gender, adjectiveClazz);
	}
}
