/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test.validation;

import static org.yakindu.sct.model.sgraph.validation.RegionValidator.*;

import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.RegionValidator;

import com.google.inject.Inject;

/**
 * 
 * Tests for {@link RegionValidator}
 *
 */
public class RegionValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<RegionValidator> tester;

	@Test
	public void checkOnlyOneDefaultEntryPermitted() {
		State state = createState();
		Region region = ((Region) state.eContainer());
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		Entry entry2 = factory.createEntry();
		entry2.setName("default");
		region.getVertices().add(entry2);
		createTransition(entry, state);
		createTransition(entry2, state);
		tester.validate(entry).assertError(REGION_MUST_NOT_HAVE_MULTIPLE_DEFAULT_ENTRIES_CODE);
	}

	@Test
	public void regionCantBeEnteredUsingShallowHistory() {
		Statechart statechart = loadStatechart("RegionCantBeEnteredUsingShallowHistory.sct");
		AssertableDiagnostics result = tester.validate(statechart);
		result.assertError(REGION_REQUIRES_DEFAULT_ENTRY_IF_ENTERED_BY_SHALLOW_HISTORY_CODE);
	}

	@Test
	public void validTransitionToInnerChoice() {
		Statechart statechart = loadStatechart("ValidTransitionToInnerChoice.sct");
		tester.validate(statechart).assertOK();
	}

	/**
	 * An exit node must not be used in top level regions.
	 */
	@Test
	public void exitOnStatechart() {
		State state = createState();
		Region region = (Region) state.eContainer();
		Exit exit = factory.createExit();
		createTransition(state, exit);
		region.getVertices().add(exit);
		tester.validate(region).assertError(REGION_NO_EXIT_ON_TOP_LEVEL_CODE);
	}

	@Test
	public void initialEntryWithTransitionToContainer() {
		Statechart statechart = loadStatechart("EntryTransitionToParentState.sct");
		tester.validate(statechart).assertError(REGION_ENTRY_TARGET_MUST_BE_CHILD_CODE);
	}
	
	@Test
	public void historyWithoutOutgoingTransitionNeedsDefaultEntry() {
		Statechart statechart = loadStatechart("HistoryWithoutDefaultEntry.sct");
		tester.validate(statechart).assertWarning(REGION_NEEDS_DEFAULT_ENTRY_WHEN_HISTORY_HAS_NO_OUTGOING_CODE);
	}

	@Override
	protected Statechart loadStatechart(String path) {
		return super.loadStatechart("region/" + path);
	}
}
