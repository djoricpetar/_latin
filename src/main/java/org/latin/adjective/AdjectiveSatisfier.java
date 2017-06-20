package org.latin.adjective;

import org.latin.common.Gender;
import org.latin.common.NounCreatorTemporary;
import org.latin.common.Satisfier;
import org.latin.noun.Noun;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

public abstract class AdjectiveSatisfier implements Satisfier<BasicAdjective>{

	protected BasicAdjective basicAdjective;
	
	public void setBasicAdjective(BasicAdjective basicAdjective) { 
		this.basicAdjective = basicAdjective;
	}
	
	public abstract Rule isSatisfiableBy(BasicAdjective basicAdjective);
	
	protected Rule basicModificationsEndWith(BasicAdjective basicAdjective, String nomMEnding, String nomFEnding, String nomNEnding) { 
		return new AndRule(
					new NominativeSingularMasculinumEndsWithRule(basicAdjective, nomMEnding),
					new NominativeSingularFemininumEndsWithRule (basicAdjective, nomFEnding),
					new NominativeSingularNeutrumEndsWithRule   (basicAdjective, nomNEnding)
				);
	}

	protected Noun createNoun(String nominativeSingular, String genitiveSingular, Gender gender) { 
		return createNoun(nominativeSingular, genitiveSingular, gender, null);
	}
	
	protected Noun createNoun(String nominativeSingular, String genitiveSingular, Gender gender, Class<?> adjectiveClass) { 
		return NounCreatorTemporary.createNoun(nominativeSingular, genitiveSingular, gender, adjectiveClass);
	}
	
	public abstract Noun getNounMasculinum();
	
	public abstract Noun getNounFemininum();
	
	public abstract Noun getNounNeutrum();
}
