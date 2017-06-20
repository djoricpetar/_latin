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

public final class Conjugation03b extends VerbSatisfier {

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
							new FirstPersonSingularPresentEndsWithRule(basicVerb, "io")
						);
	}

	@Override
	public ConjugationPretty pretty() {
		return ConjugationPretty.III;
	}

	@Override
	protected Map<Position, String> provideSuffixesForPresent() {
		return defualtPresentMapCreation(new String[] {
				"io",	"imus",
				"is",	"itis",
				"it",	"iunt"
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
				"iebam",	"iebamus",
				"iebas",	"iebatis",
				"iebat",	"iebant"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForFuturI() {
		return defualtFuturIMapCreation(new String[] {
				"iam",	"iemus",
				"ies",	"ietis",
				"iet",	"ient"
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
				"ior",	"imur",
				"eris",	"imini",
				"itur",	"iuntur"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPassiveImperfect() {
		return defualtPassiveImperfectMapCreation(new String[] {
				"iebar",		"iebamur",
				"iebaris",		"iebamini",
				"iebatur",		"iebantur"
		});
	}

	@Override
	protected Map<Position, String> provideSuffixesForPassiveFuturI() {
		return defualtPassiveFuturIMapCreation(new String[] {
				"iar",		"iemur",
				"ieris",	"iemini",
				"ietur",	"ientur"
		});
	}

	@Override
	protected void registerIrregularPositions() {}

}
