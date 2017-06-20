package org.latin.verb_conjugation.provider;

import java.util.Map;

import org.latin.common.WordTransformation;
import org.latin.verb.BasicVerb;
import org.latin.verb.BasisPresentEndsWithRule;
import org.latin.verb.ConjugationPretty;
import org.latin.verb.PerfectStartsWithBasisPresentRule;
import org.latin.verb.Position;
import org.latin.verb.VerbSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.Rule;

public final class Conjugation01 extends VerbSatisfier {

	@Override
	protected String provideBasisPresent() {
		return WordTransformation.stripLastNCharacters(basicVerb.getInfinitive(), 2);
	}

	@Override
	protected String provideBasisPerfect() {
		return WordTransformation.stripLastNCharacters(basicVerb.getFirstPersonSingularPerfect(), 1);
	}
	
	@Override
	public Rule isSatisfiableBy(BasicVerb basicVerb) {
		return 
				new AndRule(
							new PerfectStartsWithBasisPresentRule(basicVerb),
							new BasisPresentEndsWithRule(basicVerb, "a")
						);
	}

	@Override
	public ConjugationPretty pretty() {
		return ConjugationPretty.I;
	}
	
	@Override
	protected Map<Position, String> provideSuffixesForPresent() {
		return defualtPresentMapCreation(new String[] {
				"o",	"mus",
				"s",	"tis",
				"t",	"nt"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForImperative() {
		return defualtImperativeMapCreation(new String[] { 
				"",		"te"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForImperfect() {
		return defualtImperfectMapCreation(new String[] {
				"bam",	"bamus",
				"bas",	"batis",
				"bat",	"bant"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForFuturI() {
		return defualtFuturIMapCreation(new String[] {
				"bo",	"bimus",
				"bis",	"bitis",
				"bit",	"bunt"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPerfect() {
		return defualtPerfectMapCreation(new String[] {
				"i",	"imus",
				"isti",	"istis",
				"it",	"erunt"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPlusQuamPerfect() {
		return defualtPlusQuamPerfecttMapCreation(new String[] {
				"eram",	"eramus",
				"eras",	"eratis",
				"erat",	"erant"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForFuturII() {
		return defualtFuturIIMapCreation(new String[] {
				"ero",	"erimus",
				"eris",	"eritis",
				"erit",	"erint"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPassivePresent() {
		return defualtPassivePresentMapCreation(new String[] {
				"or",	"mur",
				"ris",	"mini",
				"tur",	"ntur"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPassiveImperfect() {
		return defualtPassiveImperfectMapCreation(new String[] {
				"bar",		"bamur",
				"baris",	"bamini",
				"batur",	"bantur"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPassiveFuturI() {
		return defualtPassiveFuturIMapCreation(new String[] {
				"bor",		"bimur",
				"beris",	"bimini",
				"bitur",	"buntur"
		});
	}

	@Override
	protected void registerIrregularPositions() {
		updatePosition(Position.FIRST_PERSON_SINGULAR_PRESENT, 			WordTransformation.stripLastNCharacters(basicVerb.getFirstPersonSingularPresent(), 1) + suffixes.get(Position.FIRST_PERSON_SINGULAR_PRESENT));
		updatePosition(Position.FIRST_PERSON_SINGULAR_PASSIVE_PRESENT, 	WordTransformation.stripLastNCharacters(basicVerb.getFirstPersonSingularPresent(), 1) + suffixes.get(Position.FIRST_PERSON_SINGULAR_PASSIVE_PRESENT));
	}
	
}