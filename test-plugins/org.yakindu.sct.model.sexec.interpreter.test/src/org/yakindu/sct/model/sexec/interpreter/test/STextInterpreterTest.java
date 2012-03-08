/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.test;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class STextInterpreterTest extends AbstractSTextTest {

//	@Test
//	public void testRaise() {
//		executeWithDefaultScope("raise abc");
//		assertTrue(getContext().getRaisedEvents().size() == 1);
//	}
//
//	@Test
//	public void testRaiseWithValue() {
//		executeWithDefaultScope("raise abc:42");
//		assertTrue(getContext().getRaisedEvents().size() == 1);
//		assertEquals(42, getContext().getRaisedEvents().get(0).getValue());
//	}

//	@Test
//	public void testProcedureCall() {
//		executeWithDefaultScope("foo()");
//		assertEquals("foo", getContext().lastProcedureId);
//	}

	@Test
	public void testIntVariableAssignment() {
		executeWithDefaultScope("myInt = 42");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testHexVariableAssignment() {
		executeWithDefaultScope("myInt = 0xFF");
		assertEquals(0xFF, getIntValue());
	}

	@Test
	public void testBoolTrueVariableAssignment() {
		executeWithDefaultScope("myBool = true");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testBoolFalseVariableAssignment() {
		executeWithDefaultScope("myBool = false");
		assertEquals(false, getContext().getVariable("myBool")
				.getValue());
	}

	@Test
	public void testFloatVariableAssignment() {
		executeWithDefaultScope("myFloat = 42.0");
		assertEquals(42.0f, getContext().getVariable("myFloat")
				.getValue());
	}

	//
	// @Test
	// public void testStringVariableAssignment() {
	// executeWithDefaultScope("a = \"fortytwo\";");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals("fortytwo", scope.getValue("a"));
	// }
	//
	// @Test
	// public void testIntStringVariableAssignment() {
	// executeWithDefaultScope("a = \"42\";");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals("42", scope.getValue("a"));
	// }
	//
	@Test
	public void testConditionalTrue() {
		executeWithDefaultScope("myInt = true ? 42 : 1");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testConditionalFalse() {
		executeWithDefaultScope("myInt = false ? 42 : 1");
		assertEquals(1, getIntValue());
	}

	@Test
	public void testNestedExpression() {
		executeWithDefaultScope("myInt = (1 + 1) * 2");
		assertEquals(4, getIntValue());
	}

	@Test
	public void testBooleanOr() {
		executeWithDefaultScope("myBool = true || false");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testBooleanAnd() {
		executeWithDefaultScope("myBool = true && false");
		assertEquals(false, getContext().getVariable("myBool")
				.getValue());
	}

	@Test
	public void testBitwiseXor() {
		executeWithDefaultScope("myInt = 0xF0F0 ^ 0xFF00");
		assertEquals(0x0FF0, getContext().getVariable("myInt")
				.getValue());

	}

	@Test
	public void testBitwiseOr() {
		executeWithDefaultScope("myInt = 0xF0F0 | 0xFFFF");
		assertEquals(0xFFFF, getContext().getVariable("myInt")
				.getValue());
	}

	@Test
	public void testBitwiseAnd() {
		executeWithDefaultScope("myInt = 0xF0F0 & 0xFFFF");
		assertEquals(0x0F0F0, getContext().getVariable("myInt")
				.getValue());
	}

	@Test
	public void testBoolEqual() {
		executeWithDefaultScope("myBool = false == false");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntEqual() {
		executeWithDefaultScope("myBool = 1 == 1");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatEqual() {
		executeWithDefaultScope("myBool = 1.0f == 1.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testBoolNotEqual() {
		executeWithDefaultScope("myBool = true != false");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntNotEqual() {
		executeWithDefaultScope("myBool = 1 != 2");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatNotEqual() {
		executeWithDefaultScope("myBool = 1.0f != 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntGreaterEqual() {
		executeWithDefaultScope("myBool = 2 >= 1");
		assertEquals(true, getBoolValue());

	}

	@Test
	public void testFloatGreaterEqual() {
		executeWithDefaultScope("myBool = 2.0f >= 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntSmallerEqual() {
		executeWithDefaultScope("myBool = 1 <= 2");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatSmallerEqual() {
		executeWithDefaultScope("myBool = 2.0f <= 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntGreater() {
		executeWithDefaultScope("myBool = 2 > 1");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatGreater() {
		executeWithDefaultScope("myBool = 2.1f > 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntSmaller() {
		executeWithDefaultScope("myBool = 1 < 2");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatSmaller() {
		executeWithDefaultScope("myBool = 2.0f < 2.1f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntPositive() {
		executeWithDefaultScope("myInt = + 1");
		assertEquals(1, getIntValue());
		executeWithDefaultScope("myInt = +2");
		assertEquals(2, getIntValue());
	}

	@Test
	public void testFloatPositive() {
		executeWithDefaultScope("myFloat = +1.0");
		assertEquals(1.0f, getFloatValue());
	}

	@Test
	public void testIntNegative() {
		executeWithDefaultScope("myInt = - 1");
		assertEquals(-1, getIntValue());
		executeWithDefaultScope("myInt = -2");
		assertEquals(-2, getIntValue());

	}

	// @Test
	// public void testIntNegativeVar() {
	// RTVariable a = new RTVariable("a");
	// scope.addVariable(a);
	// scope.setVariableValue(a, 42);
	// executeWithDefaultScope("a = -a;");
	// stmt.execute(scope);
	//
	// assertEquals(-42, scope.getValue("a"));
	// }

	@Test
	public void testFloatNegative() {
		executeWithDefaultScope("myFloat = -1.0f");
		assertEquals(-1.0f, getFloatValue());
	}

	@Test
	public void testIntPlus() {
		executeWithDefaultScope("myInt = 42 + 1");
		assertEquals(43, getIntValue());
	}

	@Test
	public void testFloatPlus() {
		executeWithDefaultScope("myFloat = 42.0 + 1.0");
		assertEquals(43.0f, getFloatValue());
	}

	@Test
	public void testIntMinus() {
		executeWithDefaultScope("myInt = 42 - 1");
		assertEquals(41, getIntValue());
	}

	@Test
	public void testFloatMinus() {
		executeWithDefaultScope("myFloat = 42.0f - 1.0f");
		assertEquals(41.0f, getFloatValue());
	}

	@Test
	public void testIntMultiply() {
		executeWithDefaultScope("myInt = 42 * 2");
		assertEquals(84, getIntValue());
	}

	@Test
	public void testFloatMultiply() {
		executeWithDefaultScope("myFloat = 42.0f * 2.0f");
		assertEquals(84.0f, getFloatValue());
	}

	@Test
	public void testIntDivide() {
		executeWithDefaultScope("myInt = 42 / 2");
		assertEquals(21, getIntValue());
	}

	@Test
	public void testFloatDivide() {
		executeWithDefaultScope("myFloat = 42.0f / 2.0f");
		assertEquals(21.0f, getFloatValue());
	}

	@Test
	public void testIntModulo() {
		executeWithDefaultScope("myInt = 42 % 2");
		assertEquals(0, getIntValue());
	}

	@Test
	public void testFloatModulo() {
		executeWithDefaultScope("myFloat = 42.0f % 2.0f");
		assertEquals(0.0f, getFloatValue());
	}

	@Test
	public void testIntLeft() {
		executeWithDefaultScope("myInt = 42 << 2");
		assertEquals(168, getIntValue());
	}

	// @Test
	// public void testFloatLeft() {
	// try {
	// executeWithDefaultScope("a = 42.0f << 2.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(168, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	@Test
	public void testIntRight() {
		executeWithDefaultScope("myInt = 42 >> 2");
		assertEquals(10, getIntValue());
	}

	// @Test
	// public void testFloatRight() {
	// try {
	// executeWithDefaultScope("a = 42.0f >> 2.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(168, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	@Test
	public void testIntAnd() {
		executeWithDefaultScope("myInt= 9 & 12");
		assertEquals(8, getIntValue());
	}

	//
	// @Test
	// public void testFloatAnd() {
	// try {
	// executeWithDefaultScope("a= 9.0f & 12.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(8.0f, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	@Test
	public void testIntXor() {
		executeWithDefaultScope("myInt= 9 ^ 12");
		assertEquals(5, getIntValue());
	}

	// @Test
	// public void testFloatXor() {
	// try {
	// executeWithDefaultScope("a= 9.0f ^ 12.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(5.0f, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	@Test
	public void testIntOr() {
		executeWithDefaultScope("myInt= 9 | 12");
		assertEquals(13, getIntValue());
	}

	// @Test
	// public void testFloatOr() {
	// try {
	// executeWithDefaultScope("a= 9.0f | 12.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(13.0f, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	@Test
	public void testIntBitComplement() {
		executeWithDefaultScope("myInt= ~9");
		assertEquals(-10, getIntValue());
	}

	// @Test
	// public void testFloatBitComplement() {
	// try {
	// executeWithDefaultScope("a= ~9.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(-10.0f, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	@Test
	public void testNot() {
		executeWithDefaultScope("myBool = ! true");
		assertEquals(false, getBoolValue());
	}

	@Test
	public void testPrirority() {
		executeWithDefaultScope("myInt = 1 + 2 * 3");
		assertEquals(7, getIntValue());
	}

	@Test
	public void testNested() {
		executeWithDefaultScope("myInt = (1 + 2) * 3");
		assertEquals(9, getIntValue());
	}

	@Test
	public void testIntPlusAssign() {
		executeWithDefaultScope("myInt=42");
		executeWithDefaultScope("myInt+=42");
		assertEquals(84, getIntValue());
	}

	@Test
	public void testFloatPlusAssign() {
		executeWithDefaultScope("myFloat = 42.0");
		System.out.println(getFloatValue());
		executeWithDefaultScope("myFloat+=42.0");
		assertEquals(84.0f, getFloatValue());
	}

	@Test
	public void testIntMinusAssign() {
		executeWithDefaultScope("myInt=42");
		executeWithDefaultScope("myInt-=10");
		assertEquals(32, getIntValue());
	}

	@Test
	public void testFloatMinusAssign() {
		executeWithDefaultScope("myFloat=42.0f");
		executeWithDefaultScope("myFloat-=10.0");
		assertEquals(32.0f, getFloatValue());
	}

	@Test
	public void testIntMultAssign() {
		executeWithDefaultScope("myInt=42");
		executeWithDefaultScope("myInt*=1");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testFloatMultAssign() {
		executeWithDefaultScope("myFloat=42.0f");
		executeWithDefaultScope("myFloat*=1.0");
		assertEquals(42.0f, getFloatValue());
	}

	@Test
	public void testIntDivAssign() {
		executeWithDefaultScope("myInt=42");
		executeWithDefaultScope("myInt/=1");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testFloatDivAssign() {
		executeWithDefaultScope("myFloat=42.0f");
		executeWithDefaultScope("myFloat/=1.0f");
		assertEquals(42.0f, getFloatValue());
	}

	@Test
	public void testIntModAssign() {
		executeWithDefaultScope("myInt=42");
		executeWithDefaultScope("myInt%=1");
		assertEquals(0, getIntValue());
	}

	@Test
	public void testFloatModAssign() {
		executeWithDefaultScope("myFloat=42.0f");
		executeWithDefaultScope("myFloat%=1.0f");
		assertEquals(0.0f, getFloatValue());
	}

	@Test
	public void testIntLeftAssign() {
		executeWithDefaultScope("myInt=42");
		executeWithDefaultScope("myInt<<=1");
		assertEquals(84, getIntValue());
	}

	// @Test
	// public void testFloatLeftAssign() {
	// try {
	// executeWithDefaultScope("a=42.0f; a<<=1.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(168, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	// @Test
	// public void testIntRightAssign() {
	// executeWithDefaultScope("a=42; a>>=1;");
	// assertEquals(21, scope.getValue("a"));
	// }

	// @Test
	// public void testFloatRightAssign() {
	// try {
	// executeWithDefaultScope("a=42.0f; a>>=1.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(168, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }
	//
	// @Test
	// public void testIntAndAssign() {
	// executeWithDefaultScope("a=9; a&=12;");
	// assertEquals(8, scope.getValue("a"));
	// }
	//
	// @Test
	// public void testFloatAndAssign() {
	// try {
	// executeWithDefaultScope("a=42.0f; a&=1.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(168, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }
	//
	// @Test
	// public void testIntXorAssign() {
	// executeWithDefaultScope("a=9; a^=12;");
	// assertEquals(5, scope.getValue("a"));
	// }

	// @Test
	// public void testFloatXorAssign() {
	// try {
	// executeWithDefaultScope("a=42.0f; a^=1.0f;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(168, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }
	//
	// @Test
	// public void testIntOrAssign() {
	// executeWithDefaultScope("a=9; a|=12;");
	// assertEquals(13, scope.getValue("a"));
	// }

	// @Test
	// public void testFloatOrAssign() {
	// try {
	// executeWithDefaultScope("a=42.0; a|=1.0;");
	// scope.addVariable(new RTVariable("a"));
	// stmt.execute(scope);
	//
	// assertEquals(168, scope.getValue("a"));
	// fail("EvaluationException expected");
	// } catch (EvaluationException e) {
	// }
	// }

	@Test public void testPlainTrue() {
		assertEquals(true, executeExpression("", "true"));
	}
	
	@Test public void testPlainFalse() {
		assertEquals(false, executeExpression("", "false"));
	}
}
