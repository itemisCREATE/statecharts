package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_expression.Test_ExpressionStatemachine;

public class TestExpressionCycleBasedStatemachine {

	private Test_ExpressionStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_ExpressionStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testCycles() {
		assertEquals("Var3 value not set correct: ", 2405.6,
				statemachine.getVar3(), Math.pow(10, -8));

		statemachine.raiseEvent1(0);
		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getSCIOther().getVar1());
		assertEquals("Default.Var2 value not set correct: ", 1,
				statemachine.getVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3,
				statemachine.getVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12,
				statemachine.getVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 7,
				statemachine.getVar1());

		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getSCIOther().getVar1());
		assertEquals("Default.Var2 value not set correct: ", 1,
				statemachine.getVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3,
				statemachine.getVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12,
				statemachine.getVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 8,
				statemachine.getVar1());

		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getSCIOther().getVar1());
		assertEquals("Default.Var2 value not set correct: ", 1,
				statemachine.getVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3,
				statemachine.getVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12,
				statemachine.getVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 9,
				statemachine.getVar1());

		statemachine.raiseEvent1(0);
		statemachine.runCycle();
		assertEquals("Default.Var5 value not set correct: ", true,
				statemachine.getVar5());
		assertEquals("Other.Var3 value not set correct: ", 962.24,
				statemachine.getVar3(), Math.pow(10, -8));

		statemachine.raiseEvent1(0);
		statemachine.runCycle();
		assertEquals("Other.Var3 value not set correct: ", 192.448,
				statemachine.getVar3(), Math.pow(10, -8));

	}
}
