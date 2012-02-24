package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.test_expression.Test_ExpressionCycleBasedStatemachine;

public class TestExpressionCycleBasedStatemachine {

	private Test_ExpressionCycleBasedStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_ExpressionCycleBasedStatemachine();
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
				statemachine.getVarVar3(), Math.pow(10, -8));

		statemachine.raiseEvent1(0);
		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1,
				statemachine.getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3,
				statemachine.getVarVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12,
				statemachine.getVarVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 7,
				statemachine.getVarVar1());

		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1,
				statemachine.getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3,
				statemachine.getVarVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12,
				statemachine.getVarVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 8,
				statemachine.getVarVar1());

		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1,
				statemachine.getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3,
				statemachine.getVarVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12,
				statemachine.getVarVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 9,
				statemachine.getVarVar1());

		statemachine.raiseEvent1(0);
		statemachine.runCycle();
		assertEquals("Default.Var5 value not set correct: ", true,
				statemachine.getVarVar5());
		assertEquals("Other.Var3 value not set correct: ", 962.24,
				statemachine.getVarVar3(), Math.pow(10, -8));

		statemachine.raiseEvent1(0);
		statemachine.runCycle();
		assertEquals("Other.Var3 value not set correct: ", 962.24,
				statemachine.getVarVar3(), Math.pow(10, -8));

	}
}
