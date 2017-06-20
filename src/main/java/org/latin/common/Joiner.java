package org.latin.common;

public class Joiner {

	private String word;
	
	public Joiner() { 
		word = "";
	}
	
	public Joiner join(String suffix) { 
		word += suffix;
		return this;
	}
	
	public Joiner and(String suffix) { 
		 word += suffix;
		 word.replace("ao", "o");
		 return this;
	}
	
	public String build() { 
		return word;
	}
}
