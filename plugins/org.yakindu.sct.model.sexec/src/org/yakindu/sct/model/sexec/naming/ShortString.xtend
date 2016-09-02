package org.yakindu.sct.model.sexec.naming

import java.lang.String

class ShortString {
	/*
	 * Class that manages a string and shortened versions of it.
	 */
	private String originalString;
	
	private int[] cutArray;
	private int[] previous_cutArray;
	
	final static public int cost_lowercase_vocals = 1;
	final static public int cost_underscore = 1;
	final static public int cost_lowercase_consonants = 2;
	final static public int cost_Uppercase = 3;
	final static public int cost_digit = 10;
	final static public int cost_firstLetter = 10;
	
	
	new(String s)
	{
		if(s == null) {
			originalString = "";
		} else {
			originalString = s;
		}
		cutArray = newIntArrayOfSize(size);
		previous_cutArray = newIntArrayOfSize(size);
		reset();
		saveCurrentToPrevious();
	}
	
	def public getOriginalString()
	{
		originalString
	}
	
	def private int size()
	{
		// instead of saving originalString.length as an own member
		originalString.length
	}
	
	def public reset()
	{
		// Reset cut_array so that the shortened String is equal to the original String.
		saveCurrentToPrevious();
		for(var i=0; i<size; i++) {
			cutArray.set(i, 1);
		}
	}
	
	def private saveCurrentToPrevious()
	{
		// save current cut-state to previous_cutArray.
		for(var i=0; i<size; i++) {
			previous_cutArray.set(i, cutArray.get(i));
		}
	}
	
	def public rollback()
	{
		for(var i=0; i<size; i++) {
			cutArray.set(i, previous_cutArray.get(i));
		}
	}
	
	def public String getShortenedString()
	{
		var sb = new StringBuilder();
		
		for(var i=0; i<size; i++) {
			if(cutArray.get(i) != 0) {
				sb.append(originalString.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	def public int getShortenedSize()
	{
		var length = 0;
		for(var i=0; i<size; i++)
		{
			if(cutArray.get(i) != 0) {
				length += 1;
			}
		}
		
		return length;
	}
	
	def public int getCutCostFactor()
	{
		return 10 + (getCutRatio()*10) as int;
	}
	
	def public int getCutCost()
	{
		if(1.0 - getCutRatio() < 0.001) {
			return Integer.MAX_VALUE;
		}
		var cost = 0;
		
		for(var i=0; i<size; i++) {
			if(cutArray.get(i) == 0) {
				cost += getBaseCutCost(i);
			}
		}
		
		return cost * getCutCostFactor;
	}
	
	def public int getBaseCutCost(int index)
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
	
	def public removeCheapestChar()
	{
		// saveCurrentToPrevious(); - done in removeIndex(i);
		var cheapestOperation_cost = Integer.MAX_VALUE;
		var cheapestOperation_index = 0;
		for(var i=0; i<size; i++) {
			if(cutArray.get(i) != 0) {
				var cost = getBaseCutCost(i);
				if(cost < cheapestOperation_cost) {
					cheapestOperation_cost = cost;
					cheapestOperation_index = i;
				}
			}
		}
		
		removeIndex(cheapestOperation_index);
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
		
		return rem as float / size as float;
	}
	
	def public removeIndex(int index)
	{
		saveCurrentToPrevious();
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