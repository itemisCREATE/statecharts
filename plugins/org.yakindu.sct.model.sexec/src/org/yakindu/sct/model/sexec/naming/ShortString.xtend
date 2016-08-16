package org.yakindu.sct.model.sexec.naming

import java.lang.String

class ShortString {
	/*
	 * Class that manages a string and shortened versions of it.
	 */
	private String originalString;
	
	private int[] cutArray;
	private int size;
	
	final static public int cost_lowercase_vocals = 1;
	final static public int cost_underscore = 1;
	final static public int cost_lowercase_consonants = 2;
	final static public int cost_Uppercase = 3;
	final static public int cost_digit = 10;
	final static public int cost_firstLetter = 10;
	
	
	new(String s)
	{
		originalString = s;
		size = s.length;
		cutArray = newIntArrayOfSize(size);
		reset();
	}
	
	def public getOriginalString()
	{
		return originalString;
	}
	
	def public reset()
	{
		for(var i=0; i<size; i++) {
			cutArray.set(i, 1);
		}
	}
	
	def public String getShortenedString()
	{
		var ret = "";
		
		for(var i=0; i<size; i++) {
			if(cutArray.get(i) != 0) {
				ret += originalString.charAt(i);
			}
		}
		
		return ret;
	}
	
	def public int getCutCost()
	{
		var cost = 0;
		
		for(var i=0; i<size; i++) {
			if(cutArray.get(i) == 0) {
				cost += getCutCost(i);
			}
		}
		
		return cost;
	}
	
	def public int getCutCost(int index)
	{
		var cost = 0;
		
		var c = originalString.charAt(index);
		
		if(index == 0) {
			cost += cost_firstLetter;
		}
		if(Character.isDigit(c)) {
			cost += cost_digit;
		}
		else if(Character.isUpperCase(c)) {
			cost += cost_Uppercase;
		}
		else if(isLowercaseVocal(c)) {
			cost += cost_lowercase_vocals;
		} 
		else if(c.toString().equals("_")) {
			cost += cost_underscore;
		}
		else {
			cost += cost_lowercase_consonants;
		}
		
		return cost;
	}
	
	def public removeVocals()
	{
		for(var i=0; i<size; i++) {
			if(isLowercaseVocal(i)) {
				cutArray.set(i, 0);
			}
		}
	}
	
	def public removeUnderscores()
	{
		for(var i=0; i<size; i++) {
			if(originalString.charAt(i).toString() == "_") {
				cutArray.set(i, 0);
			}
		}
	}
	
	def public float getCutRatio()
	{
		var rem = 0;
		for(var i=0; i<size; i++)
		{
			if(cutArray.get(i) == 0) {
				rem++;
			}
		}
		
		return rem / size;
	}
	
	def public removeIndex(int index)
	{
		if(index < size) {
			cutArray.set(index, 0);
		}
	}
	
	def private boolean isLowercaseVocal(int i) {
		var c = originalString.charAt(i);
		return isLowercaseVocal(c);
	}
	
	def private boolean isLowercaseVocal(char c) 
	{
		val s = c.toString();
		return (s == "a"|| s == "e" || s == "i" || s == "o" || s == "u");
	}
}