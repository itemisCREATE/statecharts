package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;

public class Assert {

	public static void assertCall(Sequence seq, int pos, Step target) {
		assertCall(seq.getSteps().get(pos), target);
	}

	public static void assertCall(Step step, Step target) {
		assertNotNull("Step is null", step);
		assertNotNull("No target specified", target);
		assertTrue("Step is no Call (was " + step.getClass().getName() + ")",
				step instanceof Call);

		assertSame(target, ((Call) step).getStep());
	}

	public static void assertAssignment(Sequence seq, int pos,
			String variableName, AssignmentOperator operator, String value) {
		assertAssignment(seq.getSteps().get(pos), variableName, operator, value);
	}

	public static void assertAssignment(Step step, String variableName,
			AssignmentOperator operator, String value) {
		assertTrue(step instanceof Execution);
		Execution exec = (Execution) step;
		assertTrue(exec.getStatement() instanceof Assignment);
		Assignment assignment = (Assignment) exec.getStatement();
		assertEquals(operator, assignment.getOperator());
		assertEquals(variableName, assignment.getVarRef().getName());
		assertExpressionEquals(value, assignment.getExpression());
	}

	public static void assertExpressionEquals(String expected,
			Expression current) {
		String currentValue = null;
		if (current instanceof PrimitiveValueExpression) {
			Literal literal = ((PrimitiveValueExpression) current).getValue();
			if (literal instanceof BoolLiteral) {
				currentValue = Boolean.toString(((BoolLiteral) literal)
						.isValue());
			} else if (literal instanceof IntLiteral) {
				currentValue = Integer.toString(((IntLiteral) literal)
						.getValue());
			}
		}
		assertEquals(expected, currentValue);
	}

	public static StateCase assertedStateCase(Step step, ExecutionState state) {

		assertNotNull("Step is null", step);
		assertNotNull("No state specified", state);
		assertTrue("Step is no StateSwitch (was " + step.getClass().getName()
				+ ")", step instanceof StateSwitch);

		for (StateCase sCase : ((StateSwitch) step).getCases()) {
			if (sCase.getState() == state)
				return sCase;
		}

		fail("No case for state '" + state.getSimpleName() + "' exists.");
		return null;
	}

	/**
	 * @deprecated Already Sequence in this case. Assert will never fail
	 */
	@Deprecated
	public static Sequence assertedSequence(Sequence step) {
		return step;
	}

	public static Sequence assertedSequence(Step step) {

		assertNotNull("Step is null", step);
		assertTrue("Step is no Sequence (was " + step.getClass().getName()
				+ ")", step instanceof Sequence);

		return (Sequence) step;
	}

	public static StateSwitch assertedSwitch(Step step) {

		assertNotNull("Step is null", step);
		assertTrue("Step is no StateSwitch (was " + step.getClass().getName()
				+ ") '" + stepAsString(step) + "'", step instanceof StateSwitch);

		return (StateSwitch) step;
	}

	public static ExecutionState assertedState(ExecutionFlow flow, int idx,
			String id) {

		assertTrue("Execution flow does not contain an state #" + idx + "!",
				flow.getStates().size() > idx);
		ExecutionState es = flow.getStates().get(idx);
		assertEquals("wrong state id !", id, es.getName());

		return es;
	}

	public static void assertSequenceSize(int size, Step seq) {
		assertNotNull("Sequence is null", seq);
		assertTrue(
				"Step is no Sequence (was " + seq.getClass().getName() + ")",
				seq instanceof Sequence);
		assertEquals("Sequence has wrong number of steps: "
				+ stepListAsString((Sequence) seq), size, ((Sequence) seq)
				.getSteps().size());

	}

	public static void assertStateSwitch(Step step, ExecutionState... states) {

		assertNotNull("Step is null", step);
		assertTrue("Step is no StateSwitch (was " + step.getClass().getName()
				+ ")", step instanceof StateSwitch);

		List<ExecutionState> stateList = Arrays.asList(states);
		List<ExecutionState> stateCases = new ArrayList<ExecutionState>();

		for (StateCase aCase : ((StateSwitch) step).getCases()) {
			stateCases.add(aCase.getState());
		}

		assertEquals("StateSwitch cases do not match!", stateList, stateCases);
	}

	public static String stepListAsString(Sequence seq) {
		String r = "";

		for (Step s : seq.getSteps()) {
			// if (s instanceof Call) r += "call to : " +
			// ((Call)s).getStep().getComment();
			// else if (s instanceof StateSwitch) r += "switch on " +
			// ((StateSwitch)s).getStateConfigurationIdx();
			// else r += s;
			//
			r += stepAsString(s) + "; ";
		}

		return r;
	}

	public static String stepAsString(Step step) {
		if (step instanceof Call)
			return "call to : " + ((Call) step).getStep().getComment();
		else if (step instanceof StateSwitch)
			return "switch on "
					+ ((StateSwitch) step).getStateConfigurationIdx();

		return step.toString();
	}

	public static void assertedOrder(Step step,
			List<? extends ExecutionState> currentStates,
			List<? extends StepNode> requiredSteps) {
		assertedOrder_intern(step, currentStates, requiredSteps);
		if (!requiredSteps.isEmpty()) {
			fail("Step was missing: " + requiredSteps.toString());
		}
	}

	private static void assertedOrder_intern(Step step,
			List<? extends ExecutionState> currentStates,
			List<? extends StepNode> requiredSteps) {
		if (requiredSteps.isEmpty()) {
			return;
		}
		boolean found = false;

		if (step == requiredSteps.get(0).step) {
			found = true;
			StepNode removed = requiredSteps.remove(0);
			if (removed instanceof StepLeaf) {
				return;
			}
		}
		if (step instanceof Sequence) {
			for (Step subStep : ((Sequence) step).getSteps()) {
				assertedOrder_intern(subStep, currentStates, requiredSteps);
			}
		} else if (step instanceof Call) {
			assertedOrder_intern(((Call) step).getStep(), currentStates,
					requiredSteps);
		} else if (step instanceof StateSwitch) {
			StateCase stateCase = null;
			StringBuilder sb = new StringBuilder();
			for (StateCase caze : ((StateSwitch) step).getCases()) {
				sb.append(", " + caze.getState().getName());
				if (stateCase == null
						&& caze.getState() == currentStates.get(0)) {
					currentStates.remove(0);
					stateCase = caze;
				}
			}
			assertNotNull("No state case found for " + currentStates + " in "
					+ sb.toString(), stateCase);
			assertedOrder_intern(stateCase.getStep(), currentStates,
					requiredSteps);
		} else if (found == false) {
			fail("Step without match: " + step);
		}
	}

	public static class StepNode {
		public final Step step;

		public StepNode(Step step) {
			assertNotNull(step);
			this.step = step;
		}

		@Override
		public String toString() {
			return step.toString();
		}
	}

	public static class StepLeaf extends StepNode {
		public StepLeaf(Step step) {
			super(step);
		}
	}
}
