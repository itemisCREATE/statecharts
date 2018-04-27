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

import static org.junit.Assert.assertEquals;
import static org.yakindu.sct.model.sgraph.validation.EntryExitValidator.*;

import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.EntryExitValidator;

import com.google.inject.Inject;

/**
 * 
 * Tests for {@link EntryExitValidator}
 *
 */
public class EntryExitValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<EntryExitValidator> tester;

	/**
	 * An initial entry should have no incoming transition
	 */
	@Test
	public void initialEntryWithoutIncomingTransitions() {
		State state = createState();
		Region region = (Region) state.eContainer();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(state, entry);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		tester.validate(entry).assertWarning(INITIAL_ENTRY_NO_IN_TRANSITION_CODE);
	}

	/**
	 * A valid entry should have No issues
	 */
	@Test
	public void validInitialEntry() {
		State state = createState();
		Region region = (Region) state.eContainer();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		tester.validate(entry).assertOK();
	}

	/**
	 * An initial entry should have an outgoing transition
	 */
	@Test
	public void initialEntryWithoutOutgoingTransition() {
		State state = createState();
		Region region = (Region) state.eContainer();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		tester.validate(entry).assertWarning(INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);

	}

	/**
	 * An entry should not have more than one outgoing transition
	 */
	@Test
	public void initialEntryWithMultipleOutgoingTransition() {
		State state = createState();
		Region region = (Region) state.eContainer();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		tester.validate(entry).assertError(INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);

		entry.setKind(EntryKind.DEEP_HISTORY);
		tester.validate(entry).assertError(INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);

		entry.setKind(EntryKind.SHALLOW_HISTORY);
		tester.validate(entry).assertError(INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);
	}

	/**
	 * An entry should not have more than one outgoing transition
	 */
	@Test
	public void DeepHistoryWithMultipleOutgoingTransition() {
		State state = createState();
		Region region = (Region) state.eContainer();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		tester.validate(entry).assertError(INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);

		entry.setKind(EntryKind.SHALLOW_HISTORY);
		tester.validate(entry).assertError(INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);

		entry.setKind(EntryKind.DEEP_HISTORY);
		tester.validate(entry).assertError(INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);
	}

	/**
	 * An exit node should have at leat one incoming transition.
	 */
	@Test
	public void exitWithoutIncomingTransition() {
		State state = createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);

		tester.validate(exit).assertWarning(EXIT_AT_LEAST_ONE_IN_TRANSITION_CODE);
	}

	/**
	 * An exit node must have no outgoing transitions.
	 */
	@Test
	public void exitWithOutgoingTransition() {
		State state = createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);
		State s = factory.createState();
		subRegion.getVertices().add(s);
		createTransition(exit, s);
		createTransition(s, exit);

		tester.validate(exit).assertError(EXIT_NO_OUTGOING_TRANSITION_CODE);
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
		tester.validate(exit).assertError(EXIT_NO_TOPLEVEL_REGION_CODE);
	}

	/**
	 * Tests a scenario where no issues for an exit nodes exists.
	 */
	@Test
	public void cleanExit() {
		State state = createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);
		State s = factory.createState();
		subRegion.getVertices().add(s);
		Transition t = factory.createTransition();
		t.setTarget(exit);
		t.setSource(s);

		tester.validate(exit).assertOK();
	}

	@Test
	public void disallowTrigger() {
		State state = createState();
		Region region = ((Region) state.eContainer());
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		Transition trans = createTransition(entry, state);
		trans.setTrigger(sTextFactory.createReactionTrigger());
		tester.validate(entry).assertError(ENTRY_NO_TRIGGER_CODE);
	}

	@Test
	public void regionCantBeEnteredUsingShallowHistory() {
		Statechart statechart = loadStatechart("RegionCantBeEnteredUsingShallowHistory.sct");
		AssertableDiagnostics result = tester.validate(statechart);
		result.assertDiagnosticsCount(2);

		result.assertAny(
				AssertableDiagnostics.errorCode(REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY_CODE));
		result.assertAny(AssertableDiagnostics
				.errorCode(REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY_CODE));
	}

	@Test
	public void validTransitionToInnerChoice() {
		Statechart statechart = loadStatechart("ValidTransitionToInnerChoice.sct");
		tester.validate(statechart).assertOK();
	}

	@Override
	protected Statechart loadStatechart(String path) {
		return super.loadStatechart("entry/" + path);
	}
}
