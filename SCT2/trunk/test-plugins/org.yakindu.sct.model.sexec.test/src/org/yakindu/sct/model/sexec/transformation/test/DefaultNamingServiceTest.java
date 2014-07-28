package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.inject.Inject;

public class DefaultNamingServiceTest extends ModelSequencerTest {

	@Inject
	protected SCTUnitTestModels testModels;

	@Inject
	protected INamingService statechartNamingService;

	@Inject
	protected INamingService flowNamingService;
	
	@Ignore
	@Test
	public void testDefaultNamingServiceState_NameMatch() {

		List<Statechart> statecharts = Collections.emptyList();

		try {
			statecharts = testModels.loadAllStatecharts();
		} catch (Exception e) {
			fail(e.getMessage());
		}

		for (Statechart statechart : statecharts) {
			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			if (statecharts.indexOf(statechart) == 4) {
				System.out.println();
			}
			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			for (ExecutionState state : flow.getStates()) {
				if (state.getSourceElement() instanceof State) {
					assertEquals(flowNamingService.getShortName(state),
							statechartNamingService
									.getShortName((State) state
											.getSourceElement()));
				}
			}
		}
	}
}
