package org.latin.common;

import org.logic_with_oop.Rule;

public class StringsEqual implements Rule {
	private final String string1;
	private final String string2;
	
	public StringsEqual(String string1, String string2) { 
		this.string1 = string1;
		this.string2 = string2;
	}
	
	@Override
	public boolean accept() {
		return string1.equals(string2);
	}
}
