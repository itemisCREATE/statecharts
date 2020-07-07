package org.yakindu.sct.model.sexec.interpreter.test

import org.junit.Before
import org.junit.Test
import org.yakindu.base.expressions.interpreter.base.IInterpreter
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

import static org.junit.Assert.assertEquals
import org.yakindu.base.expressions.interpreter.base.ExpressionInterpreter

class ExpressionExecutionTest {

	extension ExpressionBuilder exprBuilder
	extension IInterpreter exprInterpreter
	
	@Before def void setUp() {
		exprBuilder = new ExpressionBuilder
		exprInterpreter = new ExpressionInterpreter
	} 
	
	@Test def void testPrimitiveIntegerValueExpression() {
		assertEquals(42L, _integer(42).evaluate());
	} 
			
	@Test def void testPrimitiveDoubleValueExpression() {
		assertEquals(4.2, _double(4.2).evaluate());
	} 	

	@Test def void testPrimitiveFloatValueExpression() {
		assertEquals(4.2f, _float(4.2f).evaluate());
	} 	

	@Test def void testTrue() {
		assertEquals(Boolean.TRUE, _true.evaluate());
	} 	

	@Test def void testFalse() {
		assertEquals(Boolean.FALSE, _false.evaluate());
	} 	

	@Test def void testParenthesisOfInteger() {
		assertEquals(42L, _parenthesis(_integer(42)).evaluate )
	}

	@Test def void testLogicalOr() {
		assertEquals(true, _or(_true, _false ).evaluate )
		assertEquals(true, _or(_false, _true ).evaluate )
		assertEquals(true, _or(_true, _true ).evaluate )
		assertEquals(false, _or(_false, _false ).evaluate )
	}

	@Test def void testLogicalAnd() {
		assertEquals(false, _and(_true, _false ).evaluate )
		assertEquals(false, _and(_false, _true ).evaluate )
		assertEquals(true, _and(_true, _true ).evaluate )
		assertEquals(false, _and(_false, _false ).evaluate )
	}

	@Test def void testPlusMinus() {
		assertEquals(30L, _integer(10)._plus(_integer(20)).evaluate )
		assertEquals(10l, _integer(30)._minus(_integer(20)).evaluate )
		assertEquals(17l, _integer(30)._plus(_integer(2))._minus(_integer(20)._minus(_integer(5))).evaluate )
	}

	@Test def void testMultiplicative() {
		assertEquals(200L, _integer(10)._multiply(_integer(20)).evaluate )
		assertEquals(3l, _integer(30)._divide(_integer(10)).evaluate )
		assertEquals(4l, _integer(10)._modulo(_integer(6)).evaluate )
	}

	@Test def void testBitwise() {
		assertEquals(4L, _integer(7)._bitwiseAnd(_integer(28)).evaluate )
		assertEquals(31l, _integer(7)._bitwiseOr(_integer(28)).evaluate )
		assertEquals(27l, _integer(7)._bitwiseXor(_integer(28)).evaluate )
	}

}