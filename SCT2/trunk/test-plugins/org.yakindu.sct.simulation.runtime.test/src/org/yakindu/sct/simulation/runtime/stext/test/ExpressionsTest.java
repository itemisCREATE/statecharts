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
package org.yakindu.sct.simulation.runtime.stext.test;

import static org.yakindu.sct.simulation.runtime.stext.CoreFunction.BIT_AND;
import static org.yakindu.sct.simulation.runtime.stext.CoreFunction.BIT_COMPLEMENT;
import static org.yakindu.sct.simulation.runtime.stext.CoreFunction.BIT_OR;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.yakindu.sct.simulation.runtime.EvaluationException;
import org.yakindu.sct.simulation.runtime.stext.Assert;
import org.yakindu.sct.simulation.runtime.stext.Assign;
import org.yakindu.sct.simulation.runtime.stext.BinaryOperation;
import org.yakindu.sct.simulation.runtime.stext.Conditional;
import org.yakindu.sct.simulation.runtime.stext.Constant;
import org.yakindu.sct.simulation.runtime.stext.Expression;
import org.yakindu.sct.simulation.runtime.stext.ProcedureCall;
import org.yakindu.sct.simulation.runtime.stext.Raise;
import org.yakindu.sct.simulation.runtime.stext.Scope;
import org.yakindu.sct.simulation.runtime.stext.Statement;
import org.yakindu.sct.simulation.runtime.stext.StatementSequence;
import org.yakindu.sct.simulation.runtime.stext.UnaryOperation;
import org.yakindu.sct.simulation.runtime.stext.Variable;
import org.yakindu.sct.simulation.runtime.stext.VariableRef;

public class ExpressionsTest extends TestCase {

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

	
	public void testScopeVarAccess() {

		assertNull(scope.getVariable("a"));
		assertNull(scope.getValue("a"));
		
		scope.addVariable(new Variable("a"));
		assertNotNull(scope.getVariable("a"));
		scope.getVariable("a").setValue(42);
		assertEquals(42, scope.getValue("a"));
	}
	
	/** 
	 * The initial value of a variable must be null
	 */
	public void testInitialVariableValue() {
		assertNull( (new Variable("b")).getValue() );
	}
	
	
	/** 
	 * A procedure call must be delegated to the scope instance.
	 */
	public void testProcedureCall() {
		Statement stmt = new ProcedureCall("do");
		
		stmt.execute(scope);
		assertEquals("do", scope.called);
	}
	

	/** 
	 * A signal raise must be delegated to the scope instance.
	 */
	public void testRaise() {
		Statement stmt = new Raise("signal");
		
		stmt.execute(scope);
		assertEquals("signal", scope.raised);
	}
	
	

	/**
	 * An assignment must change a variable value
	 */
	public void testAssignConstant() {
		scope.addVariable(new Variable("a"));
		
		Statement stmt = new Assign(new VariableRef("a"), new Constant(1));
		
		// stmt = ASSIGN(VAR("a"), CONST(1));
		
		stmt.execute(scope);
		assertEquals(scope.getValue("a"), new Integer(1));
	}

	
	/**
	 * An assignment must change a variable value
	 */
	public void testAssignFromVar() {
		scope.addVariable(new Variable("a"));
		scope.addVariable(new Variable("b"));
		scope.getVariable("a").setName(getName());
		
		Statement stmt = new Assign(new VariableRef("b"), new VariableRef("a"));
		
		stmt.execute(scope);
		assertEquals(scope.getValue("a"), scope.getValue("b"));
	}

	
	
	/** 
	 * A statement sequence must execute all containing statements in the defined order. 
	 */
	public void testStatementSequence() {
		scope.addVariable(new Variable("a"));

		StatementSequence seq = new StatementSequence();
		seq.add( new Raise("signal"));
		seq.add( new ProcedureCall("proc"));
		seq.add( new Assign(new VariableRef("a"), new Constant(1)) );
		
		seq.execute(scope);
		
		assertEquals(3, scope.trace.size());
		assertEquals("raise:signal", scope.trace.get(0));
		assertEquals("call:proc", scope.trace.get(1));
		assertEquals("var:a", scope.trace.get(2));
	}
	
	
	/** 
	 * An empty statement sequence must have no side effects. 
	 */
	public void testEmptyStatementSequence() {
		scope.addVariable(new Variable("a"));

		StatementSequence seq = new StatementSequence();
		
		seq.execute(scope);
		
		assertEquals(0, scope.trace.size());
	}
	

	/**
	 * The execution of a constant must return the constant value.
	 */
	public void testConstant() {

		Expression exp = new Constant(getName());
		assertEquals(getName(), exp.execute(scope));
	}

	
	/**
	 * The execution of a variable ref as expression must return the variable value.
	 */
	public void testVariableRef() {
		scope.addVariable(new Variable("x"));
		scope.getVariable("x").setValue(getName());
		
		Expression exp = new VariableRef("x");
		assertEquals(getName(), exp.execute(scope));
	}

	
	/**
	 * A conditional expression must return the first value if the condition is true.
	 */
	public void testConditionalTrue() {
		
		Expression exp = new Conditional(
				new Constant(true),
				new Constant("true"),
				new Constant("false"));
		
		assertEquals("true", exp.execute(scope));
	}
	
	
	/**
	 * A conditional expression must return the second value if the condition is true.
	 */
	public void testConditionalFalse() {
		
		Expression exp = new Conditional(
				new Constant(false),
				new Constant("true"),
				new Constant("false"));
		
		assertEquals("false", exp.execute(scope));
	}
	

	
	public void testBooleanOr() {
		Expression exp = 
			new BinaryOperation(BinaryOperation.OR, 
				new Constant(true), 
				new Constant(true));	
		assertTrue(Assert.filterBoolean(exp.execute(scope)));
		
		exp = new BinaryOperation(BinaryOperation.OR, 
				new Constant(false), 
				new Constant(true));	
		assertTrue(Assert.filterBoolean(exp.execute(scope)));
		
		exp = new BinaryOperation(BinaryOperation.OR, 
				new Constant(true), 
				new Constant(false));	
		assertTrue(Assert.filterBoolean(exp.execute(scope)));
			
		exp = new BinaryOperation(BinaryOperation.OR, 
				new Constant(false), 
				new Constant(false));	
		assertFalse(Assert.filterBoolean(exp.execute(scope)));
	}

	
	public void testBooleanOrWithNonBooleanValue() {
		
		try {
			Expression exp = new BinaryOperation(BinaryOperation.OR, 
					new Constant("a"), 
					new Constant(false));	
			exp.execute(scope);
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}

		try {
			Expression exp = new BinaryOperation(BinaryOperation.OR, 
					new Constant(false), 
					new Constant("a"));	
			exp.execute(scope);
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	
	}

	
	public void testBooleanAnd() {
		Expression exp = 
			new BinaryOperation(BinaryOperation.AND, 
				new Constant(true), 
				new Constant(true));	
		assertTrue(Assert.filterBoolean(exp.execute(scope)));
		
		exp = new BinaryOperation(BinaryOperation.AND, 
				new Constant(false), 
				new Constant(true));	
		assertFalse(Assert.filterBoolean(exp.execute(scope)));
		
		exp = new BinaryOperation(BinaryOperation.AND, 
				new Constant(true), 
				new Constant(false));	
		assertFalse(Assert.filterBoolean(exp.execute(scope)));
			
		exp = new BinaryOperation(BinaryOperation.AND, 
				new Constant(false), 
				new Constant(false));	
		assertFalse(Assert.filterBoolean(exp.execute(scope)));
	}

	
	public void testBooleanAndWithNonBooleanValue() {
		
		try {
			Expression exp = new BinaryOperation(BinaryOperation.AND, 
					new Constant("a"), 
					new Constant(false));	
			exp.execute(scope);
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}

		try {
			Expression exp = new BinaryOperation(BinaryOperation.AND, 
					new Constant(true), 
					new Constant("a"));	
			exp.execute(scope);
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	
	}

	
	public void testBitwiseAndOnInteger() {
		Expression exp = 
			new BinaryOperation(BIT_AND, 
				new Constant(0xFE), 
				new Constant(0x03));	
		assertEquals(2, exp.execute(scope));
	}

	
	public void testBitwiseOrOnInteger() {
		Expression exp = 
			new BinaryOperation(BIT_OR, 
				new Constant(0xF0), 
				new Constant(0x0F));	
		assertEquals(0xFF, exp.execute(scope));
	}

	
	
	public void testNonExistingBinaryOperation() {
		try {
			Expression exp = new BinaryOperation("?!", 
				new Constant(1), 
				new Constant(2));
			exp.execute(scope);
			
			fail("EvaluationException expected !");
		} catch (EvaluationException e) {}	
	}

	
	public void testNonExistingUnaryOperation() {
		try {
			Expression exp = new UnaryOperation("?!", new Constant(4));
			exp.execute(scope);
			
			fail("EvaluationException expected !");
		} catch (Exception e) {}	
	}

	
	public void testBitComplement() {
		Expression exp = new UnaryOperation(BIT_COMPLEMENT, new Constant(0xF0F0F0F0));
		assertEquals(0x0F0F0F0F, exp.execute(scope));
	}


}
