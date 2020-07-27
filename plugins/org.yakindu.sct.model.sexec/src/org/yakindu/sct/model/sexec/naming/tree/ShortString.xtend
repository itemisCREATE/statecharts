/**
 *   Copyright (c) 2016 committers of YAKINDU Statechart Tools.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 * 		@author René Beckmann (beckmann@itemis.de)
 */

package org.yakindu.sct.model.sexec.naming.tree

import org.eclipse.xtend.lib.annotations.Accessors

class ShortString {
	/*
	 * Class that manages a string and shortened versions of it.
	 */
	protected String originalString;
	
	/** Custom factor for the cut cost */
	@Accessors int costFactor = 1; 

	protected int[] cutArray; // holds information if char is cut or not
	protected int[] previous_cutArray; // holds previous state for rollback / undo possibility
	// cost of cutting operations
	final static public int COST_LOWERCASE_VOCALS = 1;
	final static public int COST_UNDERSCORE = 1;
	final static public int COST_LOWERCASE_CONSONANTS = 2;
	final static public int COST_UPPERCASE = 3;
	final static public int COST_DIGIT = 10;
	final static public int COST_FIRSTLETTER = 10;

	new(String s) {
		this(s, 1)
	}
	
	new(String s, int factor) {
		if (s === null) {
			originalString = "";
		} else {
			originalString = s;
		}
		cutArray = newIntArrayOfSize(size);
		previous_cutArray = newIntArrayOfSize(size);
		reset();
		saveCurrentToPrevious();
		costFactor = factor
	}

	def getOriginalString() {
		originalString
	}

	def protected int size() {
		// instead of saving originalString.length as an own member
		originalString.length
	}

	def reset() {
		// Reset cut_array so that the shortened String is equal to the original String.
		saveCurrentToPrevious();
		for (var i = 0; i < size; i++) {
			cutArray.set(i, 1);
		}
	}

	def protected saveCurrentToPrevious() {
		// save current cut-state to previous_cutArray.
		for (var i = 0; i < size; i++) {
			previous_cutArray.set(i, cutArray.get(i));
		}
	}

	def rollback() {
		// return to previous state
		for (var i = 0; i < size; i++) {
			cutArray.set(i, previous_cutArray.get(i));
		}
	}
	
	override toString() {
		shortenedString
	}

	def String getShortenedString() {
		// return the current version of the shortened string according to cutArray
		var sb = new StringBuilder();

		for (var i = 0; i < size; i++) {
			if (cutArray.get(i) != 0) {
				sb.append(originalString.charAt(i));
			}
		}

		sb.toString;
	}

	def int getShortenedSize() {
		var length = 0;
		for (var i = 0; i < size; i++) {
			if (cutArray.get(i) != 0) {
				length += 1;
			}
		}

		return length;
	}

	def int getCutRatioFactor() {
		// factor that takes into account how much of the string is already cut, so that cutting away more characters get's more expensive
		return 10 + (getCutRatio() * 10) as int;
	}

	def int getCutCost() {
		// returns the current cutting cost of the ShortString by iterating over the cutArray and accumulating cost per index
		if (1.0 - getCutRatio() < 0.001) {
			return Integer.MAX_VALUE;
		}
		var cost = 0;

		for (var i = 0; i < size; i++) {
			if (cutArray.get(i) == 0) {
				cost += getBaseCutCost(i);
			}
		}

		return cost * getCutRatioFactor * costFactor;
	}

	def int getBaseCutCost(int index) {
		// returns the cut cost of this char, independent of its cut state.
		var cost = 0;

		var c = originalString.charAt(index);

		if (index == 0) {
			cost += ShortString.COST_FIRSTLETTER;
		}
		if (Character.isDigit(c)) {
			cost += ShortString.COST_DIGIT;
		} else if (Character.isUpperCase(c)) {
			cost += ShortString.COST_UPPERCASE;
		} else if (isLowercaseVocal(c)) {
			cost += ShortString.COST_LOWERCASE_VOCALS;
		} else if (c.toString().equals("_")) {
			cost += ShortString.COST_UNDERSCORE;
		} else {
			cost += ShortString.COST_LOWERCASE_CONSONANTS;
		}

		return cost;
	}

	def removeCheapestChar() {
		// of all possible characters that aren't cut yet, remove the one with the lowest cutting cost.
		// saveCurrentToPrevious(); - done in removeIndex(i);
		var cheapestOperation_cost = Integer.MAX_VALUE;
		var cheapestOperation_index = 0;
		for (var i = 0; i < size; i++) {
			if (cutArray.get(i) != 0) {
				var cost = getBaseCutCost(i);
				if (cost < cheapestOperation_cost) {
					cheapestOperation_cost = cost;
					cheapestOperation_index = i;
				}
			}
		}

		removeIndex(cheapestOperation_index);
	}

	def float getCutRatio() {
		// returns the ratio of characters that are cut.
		1 - ((getShortenedSize as float) / (size as float))
	}

	def removeIndex(int index) {
		saveCurrentToPrevious();
		if (index < size) {
			cutArray.set(index, 0);
		}
	}

	def protected boolean isLowercaseVocal(char c) {
		val s = c.toString();
		return (s == "a" || s == "e" || s == "i" || s == "o" || s == "u");
	}
}
