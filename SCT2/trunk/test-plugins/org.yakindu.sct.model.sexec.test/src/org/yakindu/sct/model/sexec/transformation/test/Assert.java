package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.ExecutionState;
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
		assertTrue("Step is no Call (was " + step.getClass().getName() +")", step instanceof Call);
		
		assertSame(target, ((Call)step).getStep());
	}


	public static StateCase assertedStateCase(Step step, ExecutionState state) {

		assertNotNull("Step is null", step);
		assertNotNull("No state specified", state);
		assertTrue("Step is no StateSwitch (was " + step.getClass().getName() +")", step instanceof StateSwitch);

		for ( StateCase sCase : ((StateSwitch)step).getCases()) {
			if ( sCase.getState() == state ) return sCase;
		}
		
		fail("No case for state '" + state.getSimpleName() + "' exists.");
		return null;
	}


	public static void assertStateSwitch(Step step, ExecutionState ... states ) {
		
		assertNotNull("Step is null", step);
		assertTrue("Step is no StateSwitch (was " + step.getClass().getName() +")", step instanceof StateSwitch);
		
		List<ExecutionState> stateList = Arrays.asList(states);
		List<ExecutionState> stateCases = new ArrayList<ExecutionState>();
		
		for (StateCase aCase : ((StateSwitch)step).getCases()) {
			stateCases.add(aCase.getState());
		}
		
		assertEquals("StateSwitch cases do not match!", stateList, stateCases);
	}



}
