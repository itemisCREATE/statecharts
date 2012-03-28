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

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.interpreter.stext.StextStatementInterpreter;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionContextImpl;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class STextInterpreterTest extends AbstractSTextTest {

	@Inject
	private ExecutionContextImpl context;
	@Inject
	private StextStatementInterpreter interpreter;

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
		assertEquals(false, getContext().getVariable("myBool").getValue());
	}

	@Test
	public void testFloatVariableAssignment() {
		executeWithDefaultScope("myReal = 42.0");
		assertEquals(42.0f, getContext().getVariable("myReal").getValue());
	}

	@Test
	public void testStringVariableAssignment() {
		executeWithDefaultScope("myString = 'fortytwo'");
		assertEquals("fortytwo", getStringValue());
	}

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
		assertEquals(false, getContext().getVariable("myBool").getValue());
	}

	@Test
	public void testBitwiseXor() {
		executeWithDefaultScope("myInt = 0xF0F0 ^ 0xFF00");
		assertEquals(0x0FF0, getContext().getVariable("myInt").getValue());

	}

	@Test
	public void testBitwiseOr() {
		executeWithDefaultScope("myInt = 0xF0F0 | 0xFFFF");
		assertEquals(0xFFFF, getContext().getVariable("myInt").getValue());
	}

	@Test
	public void testBitwiseAnd() {
		executeWithDefaultScope("myInt = 0xF0F0 & 0xFFFF");
		assertEquals(0x0F0F0, getContext().getVariable("myInt").getValue());
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
	public void testStringEqual() {
		executeWithDefaultScope("myBool = 'string' == 'string'");
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
	public void testStringNotEqual() {
		executeWithDefaultScope("myBool = 'string' != 'string2'");
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
		executeWithDefaultScope("myReal = +1.0");
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
		executeWithDefaultScope("myReal = -1.0f");
		assertEquals(-1.0f, getFloatValue());
	}

	@Test
	public void testIntPlus() {
		executeWithDefaultScope("myInt = 42 + 1");
		assertEquals(43, getIntValue());
	}

	@Test
	public void testFloatPlus() {
		executeWithDefaultScope("myReal = 42.0 + 1.0");
		assertEquals(43.0f, getFloatValue());
	}

	@Test
	public void testIntMinus() {
		executeWithDefaultScope("myInt = 42 - 1");
		assertEquals(41, getIntValue());
	}

	@Test
	public void testFloatMinus() {
		executeWithDefaultScope("myReal = 42.0f - 1.0f");
		assertEquals(41.0f, getFloatValue());
	}

	@Test
	public void testIntMultiply() {
		executeWithDefaultScope("myInt = 42 * 2");
		assertEquals(84, getIntValue());
	}

	@Test
	public void testFloatMultiply() {
		executeWithDefaultScope("myReal = 42.0f * 2.0f");
		assertEquals(84.0f, getFloatValue());
	}

	@Test
	public void testIntDivide() {
		executeWithDefaultScope("myInt = 42 / 2");
		assertEquals(21, getIntValue());
	}

	@Test
	public void testFloatDivide() {
		executeWithDefaultScope("myReal = 42.0f / 2.0f");
		assertEquals(21.0f, getFloatValue());
	}

	@Test
	public void testIntModulo() {
		executeWithDefaultScope("myInt = 42 % 2");
		assertEquals(0, getIntValue());
	}

	@Test
	public void testFloatModulo() {
		executeWithDefaultScope("myReal = 42.0f % 2.0f");
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
		executeWithDefaultScope("myReal = 42.0");
		System.out.println(getFloatValue());
		executeWithDefaultScope("myReal+=42.0");
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
		executeWithDefaultScope("myReal=42.0f");
		executeWithDefaultScope("myReal-=10.0");
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
		executeWithDefaultScope("myReal=42.0f");
		executeWithDefaultScope("myReal*=1.0");
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
		executeWithDefaultScope("myReal=42.0f");
		executeWithDefaultScope("myReal/=1.0f");
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
		executeWithDefaultScope("myReal=42.0f");
		executeWithDefaultScope("myReal%=1.0f");
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

	@Test
	public void testPlainTrue() {
		assertEquals(true, executeExpression("", "true"));
	}

	@Test
	public void testPlainFalse() {
		assertEquals(false, executeExpression("", "false"));
	}

	// Convenience...

	@Before
	public void setup() {
		initContext();
	}

	private void initContext() {
		// "event abc operation foo() var myInt : integer var MyBool : boolean
		// var myReal : real
		ExecutionVariable myInt = new ExecutionVariable("myInt", Integer.class,
				0);
		context.declareVariable(myInt);
		ExecutionVariable myBool = new ExecutionVariable("myBool",
				Boolean.class, false);
		context.declareVariable(myBool);
		ExecutionVariable myReal = new ExecutionVariable("myReal", Float.class,
				0.0f);
		context.declareVariable(myReal);
		ExecutionVariable myString = new ExecutionVariable("myString",
				String.class, "");
		context.declareVariable(myString);
		ExecutionEvent event = new ExecutionEvent("abc", Integer.class);
		context.declareEvent(event);
	}

	protected Object getBoolValue() {
		return context.getVariable("myBool").getValue();
	}

	protected Object getIntValue() {
		return context.getVariable("myInt").getValue();
	}

	protected Object getFloatValue() {
		return context.getVariable("myReal").getValue();
	}

	protected Object getStringValue() {
		return context.getVariable("myString").getValue();
	}

	protected Object executeWithDefaultScope(String expression) {
		Scope defaultScope = createDefaultScope();
		Expression statement = (Expression) parseExpression(expression,
				defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	protected Object execute(String scope, String expression) {
		Scope defaultScope = createContextScope(scope);
		Expression statement = (Expression) parseExpression(expression,
				defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	protected Object executeExpression(String scope, String expression) {
		Scope defaultScope = createContextScope(scope);
		Statement statement = (Statement) parseExpression(expression,
				defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	public IExecutionContext getContext() {
		return context;
	}

	@After
	public void tearDown() {
		context = null;
	}

	protected static final class TestExecutionContext extends
			ExecutionContextImpl {

		public String lastProcedureId;

		@Override
		public void call(String procedureId) {
			super.call(procedureId);
			lastProcedureId = procedureId;
		}
	}

}
