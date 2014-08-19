package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.transformation.FlowOptimizer;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.inject.Inject;


public class DefaultNamingServiceTest extends ModelSequencerTest {

	@Inject
	protected SCTUnitTestModels testModels;

	@Inject
	FlowOptimizer optimizer;

	@Inject
	protected INamingService statechartNamingService;

	@Inject
	protected INamingService flowNamingService;

	private List<Statechart> statecharts;

	@Before
	public void setupNamingService() {

		statecharts = Collections.emptyList();

		try {
			statecharts = testModels.loadAllStatecharts();
		} catch (Exception e) {
			fail(e.getMessage());
		}

		optimizer.inlineReactions(true);
		optimizer.inlineExitActions(true);
		optimizer.inlineEntryActions(true);
		optimizer.inlineEnterSequences(true);
		optimizer.inlineExitSequences(true);
		optimizer.inlineChoices(true);
		optimizer.inlineEntries(true);
		optimizer.inlineEnterRegion(true);
		optimizer.inlineExitRegion(true);

		// TODO: Why does PerformanceTest doesn't work?
		Statechart statecharttoRemove = null;
		for (Statechart sct : statecharts) {
			if (sct.getName().equals("PerformanceTest")) {
				statecharttoRemove = sct;
			}
		}
		statecharts.remove(statecharttoRemove);
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_0() {

		for (Statechart statechart : statecharts) {

			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(0);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(0);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_31() {

		for (Statechart statechart : statecharts) {

			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(31);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(31);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_15() {

		for (Statechart statechart : statecharts) {

			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(15);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(15);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_7() {

		for (Statechart statechart : statecharts) {

			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(7);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(7);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_4() {

		for (Statechart statechart : statecharts) {

			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(4);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(4);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_3() {

		for (Statechart statechart : statecharts) {

			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(3);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(3);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_2() {

		for (Statechart statechart : statecharts) {
			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(2);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(2);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	@Test
	public void testDefaultNamingServiceState_NameMatch_1() {

		for (Statechart statechart : statecharts) {
			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);

			statechartNamingService.setMaxLength(1);
			statechartNamingService.setSeparator('_');
			flowNamingService.setMaxLength(1);
			flowNamingService.setSeparator('_');

			// Initialize naming services for statechart and ExecutionFlow
			statechartNamingService.initializeNamingService(statechart);
			flowNamingService.initializeNamingService(flow);

			// Check for equality
			checkNameEquality(flow, statechartNamingService, flowNamingService);
		}
	}

	private void checkNameEquality(ExecutionFlow flow,
			INamingService statechartNamingService,
			INamingService flowNamingService) {

		for (ExecutionState state : flow.getStates()) {
			if (state.getSourceElement() instanceof State) {
				assertEquals(flowNamingService.getShortName(state),
						statechartNamingService.getShortName((State) state
								.getSourceElement()));

			}
		}
	}

}
