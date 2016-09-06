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
	public void resetTest()
	{
		shortstr = new ShortString("Yakindu");
		
		shortstr.removeIndex(1);
		shortstr.removeIndex(3);
		shortstr.removeIndex(6);
		
		assertEquals("Yknd", shortstr.getShortenedString());
		
		shortstr.reset();
		
		assertEquals("Yakindu", shortstr.getShortenedString());
	}
	
	@Test
	public void rollBackTest()
	{
		shortstr = new ShortString("Yakindu_StatechartTools");
		
		shortstr.removeIndex(0);
		
		shortstr.rollback();
		
		assertEquals("Yakindu_StatechartTools", shortstr.getShortenedString());
	}
	
	@Test
	public void basicCutCostTest()
	{
		shortstr = new ShortString("AAab_7");
		
		assertEquals(ShortString.COST_FIRSTLETTER + ShortString.COST_UPPERCASE, shortstr.getBaseCutCost(0));
		
		assertEquals(ShortString.COST_UPPERCASE, shortstr.getBaseCutCost(1));
		
		assertEquals(ShortString.COST_LOWERCASE_VOCALS, shortstr.getBaseCutCost(2));
		
		assertEquals(ShortString.COST_LOWERCASE_CONSONANTS, shortstr.getBaseCutCost(3));
		
		assertEquals(ShortString.COST_UNDERSCORE, shortstr.getBaseCutCost(4));
		
		assertEquals(ShortString.COST_DIGIT, shortstr.getBaseCutCost(5));
	}
	
	@Test
	public void cutCostFactorTest()
	{
		shortstr = new ShortString("012345");
		
		shortstr.removeIndex(0);
		assertEquals(11, shortstr.getCutCostFactor());
		
		shortstr.removeIndex(1);
		assertEquals(13, shortstr.getCutCostFactor());
		
		shortstr.removeIndex(2);
		assertEquals(15, shortstr.getCutCostFactor());
		
		shortstr.removeIndex(3);
		assertEquals(16, shortstr.getCutCostFactor());
		
		shortstr.removeIndex(4);
		assertEquals(18, shortstr.getCutCostFactor());
		
		shortstr.removeIndex(5);
		assertEquals(20, shortstr.getCutCostFactor());
	}
	
	@Test
	public void cutRatioTest1()
	{
		shortstr = new ShortString("ababababab");
		shortstr.removeIndex(0);
		shortstr.removeIndex(2);
		shortstr.removeIndex(4);
		shortstr.removeIndex(6);
		shortstr.removeIndex(8);
		
		assertEquals(0.5, shortstr.getCutRatio(), 0.01);
	}
	
	@Test
	public void costVocalsTest()
	{
		shortstr = new ShortString("YakinduStatechartTools");
		
		shortstr.removeIndex(1); //a
		shortstr.removeIndex(3); //i
		shortstr.removeIndex(6); //u
		shortstr.removeIndex(9); //a
		shortstr.removeIndex(11); //e
		shortstr.removeIndex(14); // a
		shortstr.removeIndex(18); // o
		shortstr.removeIndex(19); // o
		
		int expectedCost = 8 * ShortString.COST_LOWERCASE_VOCALS * shortstr.getCutCostFactor();
		
		assertEquals(expectedCost, shortstr.getCutCost());
	}
	
	@Test
	public void costFirstLetterTest()
	{
		shortstr = new ShortString("all");
		
		shortstr.removeIndex(0);
		
		int expectedCost = (
				1 * ShortString.COST_FIRSTLETTER +
				1 * ShortString.COST_LOWERCASE_VOCALS
				) * shortstr.getCutCostFactor();
		
		assertEquals(expectedCost, shortstr.getCutCost());
	}
	
	@Test
	public void costFirstUppercaseTest()
	{
		shortstr = new ShortString("ATest");
		
		shortstr.removeIndex(0);
		
		int expectedCost = (
				1 * ShortString.COST_FIRSTLETTER + 
				1 * ShortString.COST_UPPERCASE
				) * shortstr.getCutCostFactor();
		
		assertEquals(expectedCost, shortstr.getCutCost());
	}
}
