package org.latin.common;

import org.logic_with_oop.Rule;

public interface Satisfier<BasicWord> {
	public Rule isSatisfiableBy(BasicWord basicWord);
}
