package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.yakindu.base.base.NamedElement;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.AssignmentOperator;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.Literal;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.RealLiteral;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;

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
		assertClass(Execution.class, step);
		Execution exec = (Execution) step;
		assertTrue(exec.getStatement() instanceof AssignmentExpression);
		AssignmentExpression assignment = (AssignmentExpression) exec
				.getStatement();
		assertEquals(operator, assignment.getOperator());

		Expression varRef = assignment.getVarRef();
		if (varRef instanceof ElementReferenceExpression) {
			ElementReferenceExpression elementRef = (ElementReferenceExpression) varRef;
			assertEquals(variableName,
					((NamedElement) elementRef.getReference()).getName());
		} else if (varRef instanceof FeatureCall) {
			FeatureCall call = (FeatureCall) varRef;
			assertEquals(variableName,
					((NamedElement) call.getFeature()).getName());
		}
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
				currentValue = Long.toString(((IntLiteral) literal)
						.getValue());
			}
			else if (literal instanceof RealLiteral) {
				currentValue = Double.toString(((RealLiteral) literal)
						.getValue());
			}
			else if (literal instanceof StringLiteral) {
				currentValue = (((StringLiteral) literal)
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

	@SuppressWarnings("unchecked")
	/**
	 * Assertion, that the given Object is of type T. If it is, the casted object is returned.
	 * @param clazz
	 * @param actual
	 * @return
	 */
	public static <T> T assertClass(Class<T> clazz, Object actual) {
		assertTrue(clazz.getSimpleName() + " expected, but got "
				+ actual.getClass().getSimpleName(), clazz.isInstance(actual));
		return (T) actual;
	}

	public static void assertedOrder(Step step,
			Collection<? extends ExecutionState> currentStates,
			List<? extends AbstractStep> requiredSteps) {
		assertedOrder_intern(step, currentStates, requiredSteps);
		if (!requiredSteps.isEmpty()) {
			fail("Step was missing: " + requiredSteps.toString());
		}
	}

	private static void assertedOrder_intern(Step step,
			Collection<? extends ExecutionState> currentStates,
			List<? extends AbstractStep> requiredSteps) {
		if (requiredSteps.isEmpty()) {
			return;
		}
		boolean found = false;

		Iterable<Step> next = null;
		if (requiredSteps.get(0).matches(step)) {
			found = true;
			AbstractStep matched = requiredSteps.remove(0);
			if (matched.isLeaf()) {
				return;
			}
			next = matched.next();
		}
		if (next == null) {
			next = findNext(step, currentStates, requiredSteps);
		}
		if (next != null) {
			for (Step s : next) {
				assertedOrder_intern(s, currentStates, requiredSteps);
			}
		} else if (found == false) {
			fail("Step without match: " + step);
		}
	}

	protected static Iterable<Step> findNext(Step step,
			Collection<? extends ExecutionState> currentStates,
			List<? extends AbstractStep> requiredSteps) {
		if (step instanceof Sequence) {
			return ((Sequence) step).getSteps();
		} else if (step instanceof Call) {
			return Collections.singleton(((Call) step).getStep());
		} else if (step instanceof StateSwitch) {
			StateCase stateCase = null;
			StringBuilder sb = new StringBuilder();
			for (StateCase caze : ((StateSwitch) step).getCases()) {
				sb.append(", " + caze.getState().getName());
				if (stateCase == null
						&& currentStates.contains(caze.getState())) {
					stateCase = caze;
				}
			}
			assertNotNull("No state case found for " + currentStates + " in "
					+ sb.toString(), stateCase);
			return Collections.singleton(stateCase.getStep());
		}
		return null;
	}

	public abstract static class AbstractStep {
		public abstract boolean matches(Step s);

		public abstract boolean isLeaf();

		public abstract Iterable<Step> next();

	}

	public static class StepNode extends AbstractStep {
		public final Step step;
		protected boolean leaf;

		public boolean matches(Step s) {
			return s == step;
		}

		public boolean isLeaf() {
			return leaf;
		}

		public Iterable<Step> next() {
			return null;
		}

		public StepNode(Step step) {
			assertNotNull(step);
			this.step = step;
			leaf = false;
		}

		@Override
		public String toString() {
			return step.toString();
		}
	}

	public static class StepLeaf extends StepNode {
		public StepLeaf(Step step) {
			super(step);
			leaf = true;
		}
	}

	public static class StepHistory extends StepNode {
		private final boolean history;

		public StepHistory(Step step, boolean withHistory) {
			super(step);
			this.history = withHistory;
			leaf = false;
			assertClass(HistoryEntry.class, step);
		}

		@Override
		public Iterable<Step> next() {
			if (history) {
				return Collections.singleton(((HistoryEntry) step)
						.getHistoryStep());
			} else {
				return Collections.singleton(((HistoryEntry) step)
						.getInitialStep());
			}
		}
	}

	public static class StepSaveHistory extends AbstractStep {
		private final ExecutionRegion region;

		public StepSaveHistory(ExecutionRegion region) {
			this.region = region;
		}

		@Override
		public boolean matches(Step s) {
			if (s instanceof SaveHistory
					&& ((SaveHistory) s).getRegion() == region) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isLeaf() {
			return true;
		}

		@Override
		public Iterable<Step> next() {
			return null;
		}
	}
}
