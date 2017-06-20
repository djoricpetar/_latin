package org.latin.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.latin.verb.Position;
import org.latin.verb.Verb;
import org.latin.verb.VerbFactory;

public class VerbTest extends VerbTests{

	private VerbFactory verbFactory = new VerbFactory();
	
	// wrapper method to protect tests from future design changes
	private Verb createVerb(String firstPersonSingularPresent, String infinitive, String firstPersonSingularPerfect, String fourth) {
		return verbFactory.buildFrom(firstPersonSingularPresent, infinitive, firstPersonSingularPerfect, fourth);
	}
	
	private void helpMethod(Verb verb, String[] modifications, Position[] positions) { 
		assertEquals(modifications[0], verb.get(positions[0]));
		assertEquals(modifications[2], verb.get(positions[2]));
		assertEquals(modifications[4], verb.get(positions[4]));
		
		assertEquals(modifications[1], verb.get(positions[1]));
		assertEquals(modifications[3], verb.get(positions[3]));
		assertEquals(modifications[5], verb.get(positions[5]));
	}
	
	private void testPresent(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_PRESENT, 	Position.FIRST_PERSON_PLURAL_PRESENT,
				Position.SECOND_PERSON_SINGULAR_PRESENT, 	Position.SECOND_PERSON_PLURAL_PRESENT,
				Position.THIRD_PERSON_SINGULAR_PRESENT,		Position.THIRD_PERSON_PLURAL_PRESENT
		} );
	}
	
	private void testImperfect(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_IMPERFECT, 	Position.FIRST_PERSON_PLURAL_IMPERFECT,
				Position.SECOND_PERSON_SINGULAR_IMPERFECT, 	Position.SECOND_PERSON_PLURAL_IMPERFECT,
				Position.THIRD_PERSON_SINGULAR_IMPERFECT,	Position.THIRD_PERSON_PLURAL_IMPERFECT
		} );
	}
	
	public void testImperative(Verb verb, String[] modifications) {
		assertEquals(modifications[0], verb.get(Position.SECOND_PERSON_SINGULAR_IMPERATIVE));	
		assertEquals(modifications[1], verb.get(Position.SECOND_PERSON_PLURAL_IMPERATIVE));
	}

	private void testFuturI(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_FUTUR_I, 	Position.FIRST_PERSON_PLURAL_FUTUR_I,
				Position.SECOND_PERSON_SINGULAR_FUTUR_I, 	Position.SECOND_PERSON_PLURAL_FUTUR_I,
				Position.THIRD_PERSON_SINGULAR_FUTUR_I,		Position.THIRD_PERSON_PLURAL_FUTUR_I
		} );
	}
	
	private void testPerfect(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_PERFECT, 	Position.FIRST_PERSON_PLURAL_PERFECT,
				Position.SECOND_PERSON_SINGULAR_PERFECT, 	Position.SECOND_PERSON_PLURAL_PERFECT,
				Position.THIRD_PERSON_SINGULAR_PERFECT,		Position.THIRD_PERSON_PLURAL_PERFECT
		} );
	}
		
	private void testPlusQuamPerfect(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_PLUS_QUAM_PERFECT, 	Position.FIRST_PERSON_PLURAL_PLUS_QUAM_PERFECT,
				Position.SECOND_PERSON_SINGULAR_PLUS_QUAM_PERFECT, 	Position.SECOND_PERSON_PLURAL_PLUS_QUAM_PERFECT,
				Position.THIRD_PERSON_SINGULAR_PLUS_QUAM_PERFECT,	Position.THIRD_PERSON_PLURAL_PLUS_QUAM_PERFECT
		} );
	}
		
	
	private void testFuturII(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_FUTUR_II, 	Position.FIRST_PERSON_PLURAL_FUTUR_II,
				Position.SECOND_PERSON_SINGULAR_FUTUR_II, 	Position.SECOND_PERSON_PLURAL_FUTUR_II,
				Position.THIRD_PERSON_SINGULAR_FUTUR_II,	Position.THIRD_PERSON_PLURAL_FUTUR_II
		} );
	}
			
	private void testPassivePresent(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_PASSIVE_PRESENT, 	Position.FIRST_PERSON_PLURAL_PASSIVE_PRESENT,
				Position.SECOND_PERSON_SINGULAR_PASSIVE_PRESENT, 	Position.SECOND_PERSON_PLURAL_PASSIVE_PRESENT,
				Position.THIRD_PERSON_SINGULAR_PASSIVE_PRESENT,		Position.THIRD_PERSON_PLURAL_PASSIVE_PRESENT
		} );
	}
		
	
	
	private void testPassiveImperfect(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_PASSIVE_IMPERFECT, 	Position.FIRST_PERSON_PLURAL_PASSIVE_IMPERFECT,
				Position.SECOND_PERSON_SINGULAR_PASSIVE_IMPERFECT, 	Position.SECOND_PERSON_PLURAL_PASSIVE_IMPERFECT,
				Position.THIRD_PERSON_SINGULAR_PASSIVE_IMPERFECT,	Position.THIRD_PERSON_PLURAL_PASSIVE_IMPERFECT
		} );
	}
	
	private void testPassiveFuturI(Verb verb, String[] modifications) { 
		helpMethod(verb, modifications, new Position[]{
				Position.FIRST_PERSON_SINGULAR_PASSIVE_FUTUR_I, 	Position.FIRST_PERSON_PLURAL_PASSIVE_FUTUR_I,
				Position.SECOND_PERSON_SINGULAR_PASSIVE_FUTUR_I, 	Position.SECOND_PERSON_PLURAL_PASSIVE_FUTUR_I,
				Position.THIRD_PERSON_SINGULAR_PASSIVE_FUTUR_I,		Position.THIRD_PERSON_PLURAL_PASSIVE_FUTUR_I
		} );
	}
	/*	
		assertEquals(modifications[0], verb.getFirstPersonSingularPassiveFuturI());
		assertEquals(modifications[2], verb.getSecondPersonSingularPassiveFuturI());
		assertEquals(modifications[4], verb.getThirdPersonSingularPassiveFuturI());
		
		assertEquals(modifications[1], verb.getFirstPersonPluralPassiveFuturI());
		assertEquals(modifications[3], verb.getSecondPersonPluralPassiveFuturI());
		assertEquals(modifications[5], verb.getThirdPersonPluralPassiveFuturI());
	}
	

	
	*/
	
	@Test
	public void whenEndsWithAThenPresentModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testPresent(verb, new String[] {
				"voco",		"vocamus",
				"vocas",	"vocatis",
				"vocat",	"vocant"
		});
	}
	
	@Test
	public void whenEndsWithAThenImperfectModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testImperfect(verb, new String[] {
				"vocabam",		"vocabamus",
				"vocabas",		"vocabatis",
				"vocabat",		"vocabant"
		});
	}
	

	@Test
	public void whenEndsWIthAThenImperativeModificationsCorrect() { 
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
		
		testImperative(verb, new String[] {
				"voca",		"vocate"
		});
	}
	
	
	@Test
	public void whenEndsWithAThenFuturIModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testFuturI(verb, new String[] {
				"vocabo",		"vocabimus",
				"vocabis",		"vocabitis",
				"vocabit",		"vocabunt"
		});
	}	
	
	@Test
	public void whenEndsWithAThenPerfectModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testPerfect(verb, new String[] {
				"vocavi",		"vocavimus",
				"vocavisti",	"vocavistis",
				"vocavit",		"vocaverunt"
		});
	}	
	
	@Test
	public void whenEndsWithAThenPlusQuamPerfecttModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testPlusQuamPerfect(verb, new String[] {
				"vocaveram",	"vocaveramus",
				"vocaveras",	"vocaveratis",
				"vocaverat",	"vocaverant"
		});
	}	
	
	@Test
	public void whenEndsWithAThenFuturIIModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testFuturII(verb, new String[] {
				"vocavero",		"vocaverimus",
				"vocaveris",	"vocaveritis",
				"vocaverit",	"vocaverint"
		});
	}	
	
	@Test
	public void whenEndsWithAThenPassivePresentModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testPassivePresent(verb, new String[] {
				"vocor",	"vocamur",
				"vocaris",	"vocamini",
				"vocatur",	"vocantur"
		});
	}	
	
	@Test
	public void whenEndsWithAThenPassiveImperfectModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testPassiveImperfect(verb, new String[] {
				"vocabar",		"vocabamur",
				"vocabaris",	"vocabamini",
				"vocabatur",	"vocabantur"
		});
	}
	
	@Test
	public void whenEndsWithAThenPassiveFuturIModificationsCorrect() {
		Verb verb = createVerb("voco", "vocare", "vocavi", "vocatum");
			
		testPassiveFuturI(verb, new String[] {
				"vocabor",		"vocabimur",
				"vocaberis",	"vocabimini",
				"vocabitur",	"vocabuntur"
		});
	}

	@Test
	public void whenSecondConjugationThenPresentModificationsCorrect() {
		Verb verb = createVerb("video", "videre", "vidi", "visum"); 
			
		testPresent(verb, new String[] {
				"video",	"videmus",
				"vides",	"videtis",
				"videt",	"vident"
		});
	}
	
	@Test
	public void whenSecondConjugationThenImperativeModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testImperative(verb, new String[] {
				"sede", "sedete"
		});
	}
	
	@Test
	public void whenSecondConjugationThenImpperfectModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testImperfect(verb, new String[] {
				"sedebam",	"sedebamus",
				"sedebas",	"sedebatis",
				"sedebat",	"sedebant"
		});
	}
	
	@Test
	public void whenSecondConjugationThenFuturIModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testFuturI(verb, new String[] {
				"sedebo",	"sedebimus",
				"sedebis",	"sedebitis",
				"sedebit",	"sedebunt"
		});
	}
	
	@Test
	public void whenSecondConjugationThenPerfectModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testPerfect(verb, new String[] {
				"sedi",		"sedimus",
				"sedisti",	"sedistis",
				"sedit",	"sederunt"
		});
	}
	
	@Test
	public void whenSecondConjugationThenPlusquamModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testPlusQuamPerfect(verb, new String[] {
				"sederam",	"sederamus",
				"sederas",	"sederatis",
				"sederat",	"sederant"
		});
	}
	
	@Test
	public void whenSecondConjugationThenFuturIIModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testFuturII(verb, new String[] {
				"sedero",	"sederimus",
				"sederis",	"sederitis",
				"sederit",	"sederint"
		});
	}
	
	@Test
	public void whenSecondConjugationThenPasivePresentModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testPassivePresent(verb, new String[] {
				"sedeor",	"sedemur",
				"sederis",	"sedemini",
				"sedetur",	"sedentur"
		});
	}
	
	@Test
	public void whenSecondConjugationThenPassiveImperfectModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testPassiveImperfect(verb, new String[] {
				"sedebar",		"sedebamur",
				"sedebaris",	"sedebamini",
				"sedebatur",	"sedebantur"
		});
	}
	
	@Test
	public void whenSecondConjugationThenPassiveFuturIModificationsCorrect() {
		Verb verb = createVerb("sedeo", "sedere", "sedi", "sesum"); 
			
		testPassiveFuturI(verb, new String[] {
				"sedebor",		"sedebimur",
				"sedeberis",	"sedebimini",
				"sedebitur",	"sedebuntur"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenPresentModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testPresent(verb, new String[] {
				"cano",		"canimus",
				"canis",	"canitis",
				"canit",	"canunt"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenImperativeModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testImperative(verb, new String[] {
				"cane",		"canite",
		});
	}

	@Test
	public void whenThirdAConjugationThenImperfectModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testImperfect(verb, new String[] {
				"canebam",	"canebamus",
				"canebas",	"canebatis",
				"canebat",	"canebant"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenFuturIModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testFuturI(verb, new String[] {
				"canam",	"canemus",
				"canes",	"canetis",
				"canet",	"canent"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenPerfectModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testPerfect(verb, new String[] {
				"cecini",		"cecinimus",
				"cecinisti",	"cecinistis",
				"cecinit",		"cecinerunt"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenPlusquamperfectModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testPlusQuamPerfect(verb, new String[] {
				"cecineram", 	"cecineramus",
				"cecineras",	"cecineratis",
				"cecinerat",	"cecinerant"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenFuturIIModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testFuturII(verb, new String[] {
				"cecinero", 	"cecinerimus",
				"cecineris",	"cecineritis",
				"cecinerit",	"cecinerint"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenPassivePresentModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testPassivePresent(verb, new String[] {
				"canor", 	"canimur",
				"caneris",	"canimini",
				"canitur",	"canuntur"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenPassiveImperfectModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testPassiveImperfect(verb, new String[] {
				"canebar", 		"canebamur",
				"canebaris",	"canebamini",
				"canebatur",	"canebantur"
		});
	}
	
	@Test
	public void whenThirdAConjugationThenPassiveFuturIModificationsCorrect() {
		Verb verb = createVerb("cano", "canere", "cecini", "cantum");
			
		testPassiveFuturI(verb, new String[] {
				"canar", 	"canemur",
				"caneris",	"canemini",
				"canetur",	"canentur"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenPresentModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testPresent(verb, new String[] {
				"facio",	"facimus",
				"facis",	"facitis",
				"facit",	"faciunt"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenImperativetModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testImperative(verb, new String[] {
				"face", 	"facite"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenImperfectModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testImperfect(verb, new String[] {
				"faciebam",	"faciebamus",
				"faciebas",	"faciebatis",
				"faciebat",	"faciebant"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenFuturIModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testFuturI(verb, new String[] {
				"faciam",	"faciemus",
				"facies",	"facietis",
				"faciet",	"facient"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenPerfectModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testPerfect(verb, new String[] {
				"feci",		"fecimus",
				"fecisti",	"fecistis",
				"fecit",	"fecerunt"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenPlusquamperfectModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testPlusQuamPerfect(verb, new String[] {
				"feceram",	"feceramus",
				"feceras",	"feceratis",
				"fecerat",	"fecerant"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenFuturIIModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testFuturII(verb, new String[] {
				"fecero",	"fecerimus",
				"feceris",	"feceritis",
				"fecerit",	"fecerint"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenPassivePresentModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testPassivePresent(verb, new String[] {
				"facior",	"facimur",
				"faceris",	"facimini",
				"facitur",	"faciuntur"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenPassiveImperfectModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testPassiveImperfect(verb, new String[] {
				"faciebar",		"faciebamur",
				"faciebaris",	"faciebamini",
				"faciebatur",	"faciebantur"
		});
	}
	
	@Test
	public void whenThirdBConjugationThenPassiveFuturIModificationsCorrect() {
		Verb verb = createVerb("facio", "facere", "feci", "fctum");
			
		testPassiveFuturI(verb, new String[] {
				"faciar",		"faciemur",
				"facieris",		"faciemini",
				"facietur",		"facientur"
		});
	}
	
	@Test
	public void whenFourthConjugationThenPresentModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum");
			
		testPresent(verb, new String[] {
				"audio",	"audimus",
				"audis",	"auditis",
				"audit",	"audint"
		});
	}
	
	@Test
	public void whenFourthConjugationThenImpperativeModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum");
			
		testImperative(verb, new String[] {
				"audi", "audite"
		});
	}
	
	@Test
	public void whenFourthConjugationThenImpperfectModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testImperfect(verb, new String[] {
				"audiebam",	"audiebamus",
				"audiebas",	"audiebatis",
				"audiebat",	"audiebant"
		});
	}
	
	@Test
	public void whenFourthConjugationThenFuturIModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testFuturI(verb, new String[] {
				"audiam",	"audiemus",
				"audies",	"audietis",
				"audiet",	"audient"
		});
	}
	
	@Test
	public void whenFourthConjugationThenPerfectModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testPerfect(verb, new String[] {
				"audivi",		"audivimus",
				"audivisti",	"audivistis",
				"audivit",		"audiverunt"
		});
	}
	
	@Test
	public void whenFourthConjugationThenPlusquamModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testPlusQuamPerfect(verb, new String[] {
				"audiveram",	"audiveramus",
				"audiveras",	"audiveratis",
				"audiverat",	"audiverant"
		});
	}
	
	@Test
	public void whenFourthConjugationThenFuturIIModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testFuturII(verb, new String[] {
				"audivero",		"audiverimus",
				"audiveris",	"audiveritis",
				"audiverit",	"audiverint"
		});
	}
	
	@Test
	public void whenFourthConjugationThenPassivePresentModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testPassivePresent(verb, new String[] {
				"audior",	"audimur",
				"audiris",	"audimini",
				"auditur",	"audiuntur"
		});
	}
	
	@Test
	public void whenFourthConjugationThenPassiveImperfectModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testPassiveImperfect(verb, new String[] {
				"audiebar",		"audiebamur",
				"audiebaris",	"audiebamini",
				"audiebatur",	"audiebantur"
		});
	}
	
	@Test
	public void whenFourthConjugationThenPassiveFuturIModificationsCorrect() {
		Verb verb = createVerb("audio", "audire", "audivi", "auditum"); 
			
		testPassiveFuturI(verb, new String[] {
				"audiar",	"audiemur",
				"audieris",	"audiemini",
				"audietur",	"audientur"
		});
	}
}
