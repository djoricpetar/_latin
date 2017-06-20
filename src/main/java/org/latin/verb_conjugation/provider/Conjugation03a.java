package org.latin.verb_conjugation.provider;

import java.util.Map;

import org.latin.common.WordTransformation;
import org.latin.verb.BasicVerb;
import org.latin.verb.ConjugationPretty;
import org.latin.verb.FirstPersonSingularPresentEndsWithRule;
import org.latin.verb.PerfectStartsWithBasisPresentRule;
import org.latin.verb.Position;
import org.latin.verb.VerbSatisfier;
import org.logic_with_oop.AndRule;
import org.logic_with_oop.NotRule;
import org.logic_with_oop.Rule;

public class Conjugation03a extends VerbSatisfier {

	@Override
	protected String provideBasisPresent() {
		return WordTransformation.stripLastNCharacters(basicVerb.getInfinitive(), 3);
	}

	@Override
	protected String provideBasisPerfect() {
		return WordTransformation.stripLastNCharacters(basicVerb.getFirstPersonSingularPerfect(), 1);
	}

	@Override
	public Rule isSatisfiableBy(BasicVerb basicVerb) {
		return
				new AndRule(
							new NotRule(
										new PerfectStartsWithBasisPresentRule(basicVerb)
									),
							new NotRule(
										new FirstPersonSingularPresentEndsWithRule(basicVerb, "io")
									)							
						);
	}

	@Override
	public ConjugationPretty pretty() {
		return ConjugationPretty.III;
	}

	@Override
	protected Map<Position, String> provideSuffixesForPresent() {
		return defualtPresentMapCreation(new String[] {
				"o",	"imus",
				"is",	"itis",
				"it",	"unt"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForImperative() {
		return defualtImperativeMapCreation(new String[] { 
				"e",		"ite"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForImperfect() {
		return defualtImperfectMapCreation(new String[] {
				"ebam",	"ebamus",
				"ebas",	"ebatis",
				"ebat",	"ebant"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForFuturI() {
		return defualtFuturIMapCreation(new String[] {
				"am",	"emus",
				"es",	"etis",
				"et",	"ent"
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
				"or",	"imur",
				"eris",	"imini",
				"itur",	"untur"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPassiveImperfect() {
		return defualtPassiveImperfectMapCreation(new String[] {
				"ebar",		"ebamur",
				"ebaris",	"ebamini",
				"ebatur",	"ebantur"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPassiveFuturI() {
		return defualtPassiveFuturIMapCreation(new String[] {
				"ar",		"emur",
				"eris",		"emini",
				"etur",		"entur"
		});
	}

	@Override
	protected void registerIrregularPositions() {}

}
