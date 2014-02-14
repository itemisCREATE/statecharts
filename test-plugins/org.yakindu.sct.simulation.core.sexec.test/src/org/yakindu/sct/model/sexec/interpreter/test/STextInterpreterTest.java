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

import static org.junit.Assert.assertEquals;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.types.ITypeSystem;
import org.yakindu.base.types.InferredType;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.simulation.core.sexec.interpreter.IStatementInterpreter;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable;
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionEventImpl;
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionVariableImpl;

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
	private ExecutionContext context;
	@Inject
	private IStatementInterpreter interpreter;
	@Inject
	private ITypeSystem typeSystem;

	@Test
	public void testIntVariableAssignment() {
		executeWithDefaultScope("intVar = 42");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testHexVariableAssignment() {
		executeWithDefaultScope("intVar = 0xFF");
		assertEquals(0xFF, getIntValue());
	}

	@Test
	public void testBoolTrueVariableAssignment() {
		executeWithDefaultScope("boolVar = true");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testBoolFalseVariableAssignment() {
		executeWithDefaultScope("boolVar = false");
		assertEquals(false, getContext().getVariable("boolVar").getValue());
	}

	@Test
	public void testFloatVariableAssignment() {
		executeWithDefaultScope("realVar = 42.0");
		assertEquals(42.0f, getContext().getVariable("realVar").getValue());
	}

	@Test
	public void testStringVariableAssignment() {
		executeWithDefaultScope("stringVar = 'fortytwo'");
		assertEquals("fortytwo", getStringValue());
	}

	@Test
	public void testConditionalTrue() {
		executeWithDefaultScope("intVar = true ? 42 : 1");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testConditionalFalse() {
		executeWithDefaultScope("intVar = false ? 42 : 1");
		assertEquals(1, getIntValue());
	}

	@Test
	public void testNestedExpression() {
		executeWithDefaultScope("intVar = (1 + 1) * 2");
		assertEquals(4, getIntValue());
	}

	@Test
	public void testBooleanOr() {
		executeWithDefaultScope("boolVar = true || false");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testBooleanAnd() {
		executeWithDefaultScope("boolVar = true && false");
		assertEquals(false, getContext().getVariable("boolVar").getValue());
	}

	@Test
	public void testBitwiseXor() {
		executeWithDefaultScope("intVar = 0xF0F0 ^ 0xFF00");
		assertEquals(0x0FF0, getContext().getVariable("intVar").getValue());

	}

	@Test
	public void testBitwiseOr() {
		executeWithDefaultScope("intVar = 0xF0F0 | 0xFFFF");
		assertEquals(0xFFFF, getContext().getVariable("intVar").getValue());
	}

	@Test
	public void testBitwiseAnd() {
		executeWithDefaultScope("intVar = 0xF0F0 & 0xFFFF");
		assertEquals(0x0F0F0, getContext().getVariable("intVar").getValue());
	}

	@Test
	public void testBoolEqual() {
		executeWithDefaultScope("boolVar = false == false");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntEqual() {
		executeWithDefaultScope("boolVar = 1 == 1");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatEqual() {
		executeWithDefaultScope("boolVar = 1.0f == 1.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testStringEqual() {
		executeWithDefaultScope("boolVar = 'string' == 'string'");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testBoolNotEqual() {
		executeWithDefaultScope("boolVar = true != false");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntNotEqual() {
		executeWithDefaultScope("boolVar = 1 != 2");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatNotEqual() {
		executeWithDefaultScope("boolVar = 1.0f != 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testStringNotEqual() {
		executeWithDefaultScope("boolVar = 'string' != 'string2'");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntGreaterEqual() {
		executeWithDefaultScope("boolVar = 2 >= 1");
		assertEquals(true, getBoolValue());

	}

	@Test
	public void testFloatGreaterEqual() {
		executeWithDefaultScope("boolVar = 2.0f >= 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntSmallerEqual() {
		executeWithDefaultScope("boolVar = 1 <= 2");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatSmallerEqual() {
		executeWithDefaultScope("boolVar = 2.0f <= 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntGreater() {
		executeWithDefaultScope("boolVar = 2 > 1");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatGreater() {
		executeWithDefaultScope("boolVar = 2.1f > 2.0f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntSmaller() {
		executeWithDefaultScope("boolVar = 1 < 2");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testFloatSmaller() {
		executeWithDefaultScope("boolVar = 2.0f < 2.1f");
		assertEquals(true, getBoolValue());
	}

	@Test
	public void testIntPositive() {
		executeWithDefaultScope("intVar = + 1");
		assertEquals(1, getIntValue());
		executeWithDefaultScope("intVar = +2");
		assertEquals(2, getIntValue());
	}

	@Test
	public void testFloatPositive() {
		executeWithDefaultScope("realVar = +1.0");
		assertEquals(1.0f, getFloatValue());
	}

	@Test
	public void testIntNegative() {
		executeWithDefaultScope("intVar = - 1");
		assertEquals(-1, getIntValue());
		executeWithDefaultScope("intVar = -2");
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
		executeWithDefaultScope("realVar = -1.0f");
		assertEquals(-1.0f, getFloatValue());
	}

	@Test
	public void testIntPlus() {
		executeWithDefaultScope("intVar = 42 + 1");
		assertEquals(43, getIntValue());
	}

	@Test
	public void testFloatPlus() {
		executeWithDefaultScope("realVar = 42.0 + 1.0");
		assertEquals(43.0f, getFloatValue());
	}

	@Test
	public void testIntMinus() {
		executeWithDefaultScope("intVar = 42 - 1");
		assertEquals(41, getIntValue());
	}

	@Test
	public void testFloatMinus() {
		executeWithDefaultScope("realVar = 42.0f - 1.0f");
		assertEquals(41.0f, getFloatValue());
	}

	@Test
	public void testIntMultiply() {
		executeWithDefaultScope("intVar = 42 * 2");
		assertEquals(84, getIntValue());
	}

	@Test
	public void testFloatMultiply() {
		executeWithDefaultScope("realVar = 42.0f * 2.0f");
		assertEquals(84.0f, getFloatValue());
	}

	@Test
	public void testIntDivide() {
		executeWithDefaultScope("intVar = 42 / 2");
		assertEquals(21, getIntValue());
	}

	@Test
	public void testFloatDivide() {
		executeWithDefaultScope("realVar = 42.0f / 2.0f");
		assertEquals(21.0f, getFloatValue());
	}

	@Test
	public void testIntModulo() {
		executeWithDefaultScope("intVar = 42 % 2");
		assertEquals(0, getIntValue());
	}

	@Test
	public void testFloatModulo() {
		executeWithDefaultScope("realVar = 42.0f % 2.0f");
		assertEquals(0.0f, getFloatValue());
	}

	@Test
	public void testIntLeft() {
		executeWithDefaultScope("intVar = 42 << 2");
		assertEquals(168, getIntValue());
	}

	@Test
	public void testIntRight() {
		executeWithDefaultScope("intVar = 42 >> 2");
		assertEquals(10, getIntValue());
	}

	@Test
	public void testIntAnd() {
		executeWithDefaultScope("intVar= 9 & 12");
		assertEquals(8, getIntValue());
	}

	@Test
	public void testIntXor() {
		executeWithDefaultScope("intVar= 9 ^ 12");
		assertEquals(5, getIntValue());
	}

	@Test
	public void testIntOr() {
		executeWithDefaultScope("intVar= 9 | 12");
		assertEquals(13, getIntValue());
	}

	@Test
	public void testIntBitComplement() {
		executeWithDefaultScope("intVar= ~9");
		assertEquals(-10, getIntValue());
	}

	@Test
	public void testNot() {
		executeWithDefaultScope("boolVar = ! true");
		assertEquals(false, getBoolValue());
	}

	@Test
	public void testPrirority() {
		executeWithDefaultScope("intVar = 1 + 2 * 3");
		assertEquals(7, getIntValue());
	}

	@Test
	public void testNested() {
		executeWithDefaultScope("intVar = (1 + 2) * 3");
		assertEquals(9, getIntValue());
	}

	@Test
	public void testIntPlusAssign() {
		executeWithDefaultScope("intVar=42");
		executeWithDefaultScope("intVar+=42");
		assertEquals(84, getIntValue());
	}

	@Test
	public void testFloatPlusAssign() {
		executeWithDefaultScope("realVar = 42.0");
		executeWithDefaultScope("realVar+=42.0");
		assertEquals(84.0f, getFloatValue());
	}

	@Test
	public void testIntMinusAssign() {
		executeWithDefaultScope("intVar=42");
		executeWithDefaultScope("intVar-=10");
		assertEquals(32, getIntValue());
	}

	@Test
	public void testFloatMinusAssign() {
		executeWithDefaultScope("realVar=42.0f");
		executeWithDefaultScope("realVar-=10.0");
		assertEquals(32.0f, getFloatValue());
	}

	@Test
	public void testIntMultAssign() {
		executeWithDefaultScope("intVar=42");
		executeWithDefaultScope("intVar*=1");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testFloatMultAssign() {
		executeWithDefaultScope("realVar=42.0f");
		executeWithDefaultScope("realVar*=1.0");
		assertEquals(42.0f, getFloatValue());
	}

	@Test
	public void testIntDivAssign() {
		executeWithDefaultScope("intVar=42");
		executeWithDefaultScope("intVar/=1");
		assertEquals(42, getIntValue());
	}

	@Test
	public void testFloatDivAssign() {
		executeWithDefaultScope("realVar=42.0f");
		executeWithDefaultScope("realVar/=1.0f");
		assertEquals(42.0f, getFloatValue());
	}

	@Test
	public void testIntModAssign() {
		executeWithDefaultScope("intVar=42");
		executeWithDefaultScope("intVar%=1");
		assertEquals(0, getIntValue());
	}

	@Test
	public void testFloatModAssign() {
		executeWithDefaultScope("realVar=42.0f");
		executeWithDefaultScope("realVar%=1.0f");
		assertEquals(0.0f, getFloatValue());
	}

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
		// "event abc operation foo() var intVar : integer var boolVar : boolean
		// var realVar : real
		ExecutionVariable intVar = new ExecutionVariableImpl();
		intVar.setName("intVar");
		intVar.setFqName("intVar");
		intVar.setType(new InferredType(typeSystem.getIntegerType()));
		intVar.setValue(0);
		context.getSlots().add(intVar);

		ExecutionVariable boolVar = new ExecutionVariableImpl();
		boolVar.setName("boolVar");
		boolVar.setFqName("boolVar");
		boolVar.setType(new InferredType(typeSystem.getBooleanType()));
		boolVar.setValue(false);
		context.getSlots().add(boolVar);

		ExecutionVariable realVar = new ExecutionVariableImpl();
		realVar.setName("realVar");
		realVar.setFqName("realVar");
		realVar.setType(new InferredType(typeSystem.getRealType()));
		realVar.setValue(0.0f);
		context.getSlots().add(realVar);

		ExecutionVariable stringVar = new ExecutionVariableImpl();
		stringVar.setName("stringVar");
		stringVar.setFqName("stringVar");
		stringVar.setType(new InferredType(typeSystem.getStringType()));
		stringVar.setValue("");
		context.getSlots().add(stringVar);

		ExecutionEvent event = new ExecutionEventImpl();
		event.setName("abc");
		event.setFqName("abc");
		event.setType(new InferredType(typeSystem.getIntegerType()));
		context.getSlots().add(event);
	}

	protected Object getBoolValue() {
		return context.getVariable("boolVar").getValue();
	}

	protected Object getIntValue() {
		return context.getVariable("intVar").getValue();
	}

	protected Object getFloatValue() {
		return context.getVariable("realVar").getValue();
	}

	protected Object getStringValue() {
		return context.getVariable("stringVar").getValue();
	}

	protected Object executeWithDefaultScope(String expression) {
		Scope defaultScope = internalScope();
		Expression statement = (Expression) parseExpression(expression, defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	protected Object execute(String scope, String expression) {
		Scope defaultScope = createInternalScope(scope);
		Expression statement = (Expression) parseExpression(expression, defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	protected Object executeExpression(String scope, String expression) {
		Scope defaultScope = createInternalScope(scope);
		Expression statement = (Expression) parseExpression(expression, defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	public ExecutionContext getContext() {
		return context;
	}

	@After
	public void tearDown() {
		context = null;
	}
}
