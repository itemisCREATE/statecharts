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
package org.yakindu.sct.simulation.runtime.stext.builder.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.yakindu.sct.simulation.runtime.EvaluationException;
import org.yakindu.sct.simulation.runtime.stext.Constant;
import org.yakindu.sct.simulation.runtime.stext.Expression;
import org.yakindu.sct.simulation.runtime.stext.Scope;
import org.yakindu.sct.simulation.runtime.stext.Statement;
import org.yakindu.sct.simulation.runtime.stext.StatementSequence;
import org.yakindu.sct.simulation.runtime.stext.Trigger;
import org.yakindu.sct.simulation.runtime.stext.Variable;
import org.yakindu.sct.simulation.runtime.stext.VariableRef;
import org.yakindu.sct.simulation.runtime.stext.builder.BuilderException;
import org.yakindu.sct.simulation.runtime.stext.builder.ExpressionBuilder;


/**
 * @author terflothl@itemis.de
 */
public class BuilderTest extends TestCase {

	static class TestScope extends Scope {

		public List<String> trace = new ArrayList<String>();
		public String called;
		public String raised;
		
		@Override
		public Variable getVariable(String varName) {
			trace.add("var:" + varName);
			return super.getVariable(varName);
		}

		@Override
		public void call(String procedureId) {
			trace.add("call:" + procedureId);
			super.call(procedureId);
			called = procedureId;
		}

		@Override
		public void raise(String signal) {
			trace.add("raise:" + signal);
			super.raise(signal);
			raised = signal;
		}
		
		
	}
	
	protected TestScope scope;
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scope = new TestScope();
	}
	
	public void testEmptyExpression() {
		Statement stmt = ExpressionBuilder.buildAction("");
		assertNull(stmt);
	}
	

	/**
	 * TODO: check if IllegalArgumentException is the correct one
	 */
	public void testInvalidAction() {
//		try {
			Statement stmt = ExpressionBuilder.buildAction("1");
			assertNull(stmt);
//			fail("IllegalArgumentException expected !");
//		} catch(IllegalArgumentException e) {}
	}

	
	public void testRaise() {
		Statement stmt = ExpressionBuilder.buildAction("raise abc;");
		
		assertNotNull(stmt);
		assertTrue(stmt instanceof StatementSequence);
		
		assertEquals(1, ((StatementSequence)stmt).size());
		
		stmt.execute(scope);
		assertEquals("abc", scope.raised);
	}
	
	public void testProcedureCall() {
		Statement stmt = ExpressionBuilder.buildAction("foo();");
		
		assertNotNull(stmt);
		assertTrue(stmt instanceof StatementSequence);
		
		assertEquals(1, ((StatementSequence)stmt).size());
		
		stmt.execute(scope);
		assertEquals("foo", scope.called);
	}
	
	public void testMultiStatement() {
		Statement stmt = ExpressionBuilder.buildAction("raise(abc);foo();");
		
		assertNotNull(stmt);
		assertTrue(stmt instanceof StatementSequence);
		
		assertEquals(2, ((StatementSequence)stmt).size());
		
		stmt.execute(scope);
		assertEquals("abc", scope.raised);
		assertEquals("foo", scope.called);
	}

	public void testIntVariableAssignment() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));
	}

	public void testHexVariableAssignment() {
		Statement stmt = ExpressionBuilder.buildAction("a = 0xFF;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0xFF, scope.getValue("a"));
	}
	
	public void testBoolTrueVariableAssignment() {
		Statement stmt = ExpressionBuilder.buildAction("a = true;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));
	}

	public void testBoolFalseVariableAssignment() {
		Statement stmt = ExpressionBuilder.buildAction("a = false;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(false, scope.getValue("a"));
	}
	
	public void testFloatVariableAssignment() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(42.0f, scope.getValue("a"));
	}
	
	public void testStringVariableAssignment() {
		Statement stmt = ExpressionBuilder.buildAction("a = \"fortytwo\";");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals("fortytwo", scope.getValue("a"));
	}
	
	public void testIntStringVariableAssignment() {
		Statement stmt = ExpressionBuilder.buildAction("a = \"42\";");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals("42", scope.getValue("a"));
	}
	
	public void testConditioanlTrue() {
		Statement stmt = ExpressionBuilder.buildAction("a = true ? 42 : 1;");
		assertNotNull(stmt);
		
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));	
	}
	
	public void testConditioanlFalse() {
		Statement stmt = ExpressionBuilder.buildAction("a = false ? 42 : 1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(1, scope.getValue("a"));	
	}
	
	public void testBooleanOr() {
		Statement stmt = ExpressionBuilder.buildAction("a = true || false;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testBooleanAnd() {
		Statement stmt = ExpressionBuilder.buildAction("a = true && false;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(false, scope.getValue("a"));	
	}
		
	public void testBitwiseXor() {
		Statement stmt = ExpressionBuilder.buildAction("a = 0xF0F0 ^ 0xFF00;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0x0FF0, scope.getValue("a"));	
	}
	
	public void testBitwiseOr() {
		Statement stmt = ExpressionBuilder.buildAction("a = 0xF0F0 | 0xFFFF;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0xFFFF, scope.getValue("a"));	
	}
	
	public void testBitwiseAnd() {
		Statement stmt = ExpressionBuilder.buildAction("a = 0xF0F0 & 0xFFFF;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0x0F0F0, scope.getValue("a"));	
	}
	
	public void testBoolEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = false == false;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testIntEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 1 == 1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testFloatEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 1.0f == 1.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	

	
	public void testBoolNotEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = true != false;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testIntNotEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 1 != 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testFloatNotEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 1.0f != 2.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	

	public void testIntGreaterEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 2 >= 1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testFloatGreaterEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 2.0f >= 2.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	
	public void testIntSmallerEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 1 <= 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testFloatSmallerEqual() {
		Statement stmt = ExpressionBuilder.buildAction("a = 2.0f <= 2.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	
	public void testIntGreater() {
		Statement stmt = ExpressionBuilder.buildAction("a = 2 > 1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testFloatGreater() {
		Statement stmt = ExpressionBuilder.buildAction("a = 2.1f > 2.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	
	public void testIntSmaller() {
		Statement stmt = ExpressionBuilder.buildAction("a = 1 < 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	public void testFloatSmaller() {
		Statement stmt = ExpressionBuilder.buildAction("a = 2.0f < 2.1f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(true, scope.getValue("a"));	
	}
	
	
	
	public void testIntPositive() {
		Statement stmt = ExpressionBuilder.buildAction("a = +1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(1, scope.getValue("a"));
	}
	
	public void testFloatPositive() {
		Statement stmt = ExpressionBuilder.buildAction("a = +1.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(1.0f, scope.getValue("a"));
	}
	

	public void testIntNegative() {
		Statement stmt = ExpressionBuilder.buildAction("a = -1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(-1, scope.getValue("a"));
	}
	
	public void testFloatNegative() {
		Statement stmt = ExpressionBuilder.buildAction("a = - 1.0f ;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(-1.0f, scope.getValue("a"));
	}
	
	public void testIntPlus() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42 + 1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(43, scope.getValue("a"));
	}
	
	public void testFloatPlus() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42.0 + 1.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(43.0f, scope.getValue("a"));
	}
	
	public void testIntMinus() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42 - 1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(41, scope.getValue("a"));
	}
	
	public void testFloatMinus() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42.0f - 1.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(41.0f, scope.getValue("a"));
	}

	public void testIntMultiply() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42 * 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(84, scope.getValue("a"));
	}
	
	public void testFloatMultiply() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42.0f * 2.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(84.0f, scope.getValue("a"));
	}
	
	public void testIntDivide() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42 / 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(21, scope.getValue("a"));
	}
	
	public void testFloatDivide() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42.0f / 2.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(21.0f, scope.getValue("a"));
	}
	
	public void testIntModulo() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42 % 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0, scope.getValue("a"));
	}
	
	public void testFloatModulo() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42.0f % 2.0f;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0.0f, scope.getValue("a"));
	}
	
	public void testIntLeft() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42 << 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(168, scope.getValue("a"));
	}
	
	public void testFloatLeft() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a = 42.0f << 2.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntRight() {
		Statement stmt = ExpressionBuilder.buildAction("a = 42 >> 2;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(10, scope.getValue("a"));
	}
	
	public void testFloatRight() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a = 42.0f >> 2.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);
	
			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntAnd() {
		Statement stmt = ExpressionBuilder.buildAction("a= 9 & 12;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
	
		assertEquals(8, scope.getValue("a"));
	}
	
	public void testFloatAnd() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a= 9.0f & 12.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);
		
			assertEquals(8.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntXor() {
		Statement stmt = ExpressionBuilder.buildAction("a= 9 ^ 12;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
	
		assertEquals(5, scope.getValue("a"));
	}
	
	public void testFloatXor() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a= 9.0f ^ 12.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);
		
			assertEquals(5.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntOr() {
		Statement stmt = ExpressionBuilder.buildAction("a= 9 | 12;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
		
		assertEquals(13, scope.getValue("a"));
	}	
	
	public void testFloatOr() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a= 9.0f | 12.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);
		
			assertEquals(13.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}	
	
	public void testIntBitComplement() {
		Statement stmt = ExpressionBuilder.buildAction("a= ~9;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
		
		assertEquals(-10, scope.getValue("a"));
	}	
	
	public void testFloatBitComplement() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a= ~9.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);
		
			assertEquals(-10.0f, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}	
	
	public void testNot() {
		Statement stmt = ExpressionBuilder.buildAction("a = ! true;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(false, scope.getValue("a"));
	}

	public void testPrirority() {		
		Statement stmt = ExpressionBuilder.buildAction("a = 1 + 2 * 3;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(7, scope.getValue("a"));
	}
	
	public void testNested() {		
		Statement stmt = ExpressionBuilder.buildAction("a = (1 + 2) * 3;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(9, scope.getValue("a"));
	}
	
	public void testIntPlusAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42; a+=42;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(84, scope.getValue("a"));
	}
	
	public void testFloatPlusAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42.0; a+=42.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(84.0f, scope.getValue("a"));
	}

	public void testIntMinusAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42; a-=10;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(32, scope.getValue("a"));
	}
	
	public void testFloatMinusAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42.0; a-=10.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(32.0f, scope.getValue("a"));
	}
	
	public void testIntMultAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42; a*=1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));
	}
	
	public void testFloatMultAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42.0; a*=1.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(42.0f, scope.getValue("a"));
	}
	
	public void testIntDivAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42; a/=1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(42, scope.getValue("a"));
	}
		
	public void testFloatDivAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42.0; a/=1.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(42.0f, scope.getValue("a"));
	}
	
	public void testIntModAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42; a%=1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0, scope.getValue("a"));
	}
		
	public void testFloatModAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42.0; a%=1.0;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);

		assertEquals(0.0f, scope.getValue("a"));
	}
	
	public void testIntLeftAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42; a<<=1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
	
		assertEquals(84, scope.getValue("a"));
	}
	
	public void testFloatLeftAssign() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a=42.0f; a<<=1.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntRightAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=42; a>>=1;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
	
		assertEquals(21, scope.getValue("a"));
	}
	
	public void testFloatRightAssign() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a=42.0f; a>>=1.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntAndAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=9; a&=12;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
	
		assertEquals(8, scope.getValue("a"));
	}
	
	public void testFloatAndAssign() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a=42.0f; a&=1.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntXorAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=9; a^=12;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
	
		assertEquals(5, scope.getValue("a"));
	}
	
	public void testFloatXorAssign() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a=42.0f; a^=1.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testIntOrAssign() {
		Statement stmt = ExpressionBuilder.buildAction("a=9; a|=12;");
		scope.addVariable(new Variable("a"));
		stmt.execute(scope);
	
		assertEquals(13, scope.getValue("a"));
	}	
	
	public void testFloatOrAssign() {
		try {
			Statement stmt = ExpressionBuilder.buildAction("a=42.0f; a|=1.0f;");
			scope.addVariable(new Variable("a"));
			stmt.execute(scope);

			assertEquals(168, scope.getValue("a"));
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	
		
	/** If there is no builder method for the eClass of an EObject then a BuilderException must be raised.
	 */
	public void testBuildFromUnknownEClass() {
		
		class TestBuilder extends ExpressionBuilder {
			public Object testBuild(EObject obj) {
				return build(obj);
			}
		};
		
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Bla");
		
		DynamicEObjectImpl eObj = new DynamicEObjectImpl(eClass);
		
		TestBuilder builder = new TestBuilder();
		
		try {
			builder.testBuild(eObj);
			
			fail("BuilderException expected!");
		} catch (BuilderException e) {}
	}
	
	
	
	public void testSimpleGuardExpression() {
		Expression expr = ExpressionBuilder.buildGuard("true");
		assertEquals(true, expr.execute(scope));
	}

	
	public void testGuardExpression() {
		Expression expr = ExpressionBuilder.buildGuard("(a % 3) != 0");
		scope.addVariable(new Variable("a"));
		
		scope.getVariable("a").setValue(1);
		assertEquals(true, expr.execute(scope));

		scope.getVariable("a").setValue(3);
		assertEquals(false, expr.execute(scope));
	}
	
	
	public void testTriggerExpression() {
		List<Trigger> triggers = ExpressionBuilder.buildTriggers("e1, after(100), e2");
		
		assertEquals(3, triggers.size());
		
		assertTrue(triggers.get(0) instanceof Trigger.SignalEvent);
		assertEquals("e1", ((Trigger.SignalEvent)triggers.get(0)).getSignal());
		
		assertTrue(triggers.get(1) instanceof Trigger.TimeEvent);
		assertTrue(((Trigger.TimeEvent)triggers.get(1)).getDurationExp() instanceof Constant);

		assertEquals("e2", ((Trigger.SignalEvent)triggers.get(2)).getSignal());
		assertTrue(triggers.get(2) instanceof Trigger.SignalEvent);
	}

	
	public void testTimeTrigger() {
		List<Trigger> triggers = ExpressionBuilder.buildTriggers("after(x)");
		
		assertEquals(1, triggers.size());
		
		assertTrue(triggers.get(0) instanceof Trigger.TimeEvent);
		assertTrue(((Trigger.TimeEvent)triggers.get(0)).getDurationExp() instanceof VariableRef);
	}
}
