package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.naming.ShortString;

import com.google.common.primitives.Shorts;

public class ShortStringTest {
	private ShortString shortstr;
	
	@Test
	public void originalStringTest()
	{
		shortstr = new ShortString("ShortStringTest");
		
		assertEquals("ShortStringTest", shortstr.getShortenedString());
	}
	
	@Test
	public void vocalsTest()
	{
		shortstr = new ShortString("YakinduStatechartTools");
		
		shortstr.removeVocals();
		
		assertEquals("YkndSttchrtTls", shortstr.getShortenedString());
	}
	
	@Test
	public void underscoreTest()
	{
		shortstr = new ShortString("main_region_State_B");
		
		shortstr.removeUnderscores();
		
		assertEquals("mainregionStateB", shortstr.getShortenedString());
	}
	
	@Test
	public void costVocalsTest()
	{
		shortstr = new ShortString("YakinduStatechartTools");
		
		shortstr.removeVocals();
		
		assertEquals(8*ShortString.cost_lowercase_vocals, shortstr.getCutCost());
	}
	
	@Test
	public void costFirstLetterTest()
	{
		shortstr = new ShortString("all");
		
		shortstr.removeVocals();
		
		int expectedCost = 
				1 * ShortString.cost_firstLetter +
				1 * ShortString.cost_lowercase_vocals;
		
		assertEquals(expectedCost, shortstr.getCutCost());
	}
	
	@Test
	public void costFirstUppercaseTest()
	{
		shortstr = new ShortString("ATest");
		
		shortstr.removeIndex(0);
		
		int expectedCost = 
				1 * ShortString.cost_firstLetter + 
				1 * ShortString.cost_Uppercase;
		
		assertEquals(expectedCost, shortstr.getCutCost());
	}
}
