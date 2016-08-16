/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.extensions.SExecExtensions;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.naming.TreeNamingService;
import org.yakindu.sct.model.sexec.transformation.FlowOptimizer;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeNamingServiceTest extends ModelSequencerTest {
	@Inject
	protected SCTUnitTestModels testModels;

	@Inject
	FlowOptimizer optimizer;

	@Inject
	protected TreeNamingService statechartNamingService;
	
	@Inject 
	protected TreeNamingService executionflowNamingService;

	private List<Statechart> statecharts;

	@Before
	public void setupNamingService() {
		statecharts = Collections.emptyList();

		try {
			statecharts = testModels.loadAllStatecharts();
		} catch (Exception e) {
			fail(e.getMessage());
		}

		optimizer.inlineReactions(false);
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
	public void testDefaultNamingServiceState_NoDoubles() {

		for (Statechart statechart : statecharts) {

			// Transform statechart
			ExecutionFlow flow = sequencer.transform(statechart);
			flow = optimizer.transform(flow);
			
			List<String> names = new ArrayList<String>();

//			statechartNamingService.setMaxLength(0);
//			statechartNamingService.setSeparator('_');
			
			executionflowNamingService.setMaxLength(0);
			executionflowNamingService.setSeparator('_');
			
			// Initialize naming services for statechart and ExecutionFlow
//			statechartNamingService.initializeNamingService(statechart);
			executionflowNamingService.initializeNamingService(flow);

			for(ExecutionState state : flow.getStates())
			{
				String name = executionflowNamingService.getShortName(state);
				assertEquals(names.contains(name), false);
				names.add(name);
			}
//			SExecExtensions ext = new SExecExtensions();
//			for(Step step : ext.getAllFunctions(flow))
//			{
//				String name = executionflowNamingService.getShortName(step);
//				assertEquals(names.contains(name), false);
//				names.add(name);
//			}
				
			// Check for equality
			//checkNameEquality(flow, statechartNamingService, flowNamingService);
//			stringListsEqual(statechartNamingService.getTreeContents(), executionflowNamingService.getTreeContents());
		}
	}
	
	private void stringListsEqual(List<String> onelist, List<String> otherlist)
	{
		onelist.sort(null);
		otherlist.sort(null);
		assertEquals(onelist, otherlist);
	}
}