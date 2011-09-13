/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test;

import static org.yakindu.sct.model.sgraph.util.SGraphValidator.ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS;
import static org.yakindu.sct.model.sgraph.util.SGraphValidator.ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS;
import static org.yakindu.sct.model.sgraph.util.SGraphValidator.ISSUE_INITIAL_ENTRY_WITH_IN_TRANS;
import static org.yakindu.sct.model.sgraph.util.SGraphValidator.ISSUE_NODE_NOT_REACHABLE;
import static org.yakindu.sct.model.sgraph.util.SGraphValidator.ISSUE_STATE_WITHOUT_NAME;
import static org.yakindu.sct.model.sgraph.util.SGraphValidator.ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION;
import static org.yakindu.sct.model.sgraph.util.SGraphValidator.ISSUE_ENTRY_WITH_TRIGGER;

import java.util.HashMap;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.util.SGraphValidator;
import org.yakindu.sct.model.stext.stext.StextFactory;

/**
 * Test of all validation rules that test very basic properties of statecharts.
 * 
 * @author terfloth
 */
public class SGraphBaseValidationTest extends TestCase {
	

	static {
		// set up EMF - the EPackage.Registry requires a context class loader ...
		if (Thread.currentThread().getContextClassLoader() == null) {
			Thread.currentThread().setContextClassLoader(SGraphBaseValidationTest.class.getClassLoader());	
		}
		SGraphPackage.eINSTANCE.eClass();
	}
	
	protected SGraphFactory factory;
	protected StextFactory sTextFactory;
	protected SGraphValidator validator;
	protected BasicDiagnostic diagnostics;
	
	protected Statechart statechart;
	protected Region region;
	private State state;


	@Override
	protected void setUp() throws Exception {
		super.setUp();
		validator = new SGraphValidator();
		diagnostics = new BasicDiagnostic();
		factory = SGraphFactory.eINSTANCE;
		sTextFactory = StextFactory.eINSTANCE;
		statechart = factory.createStatechart();
		statechart.setName("SC");
	}

	
	protected void prepareStateTest() {
		region = factory.createRegion();
		statechart.getRegions().add(region);
		state = factory.createState();
		state.setName(getName());
		region.getVertices().add(state);
	}
	
	
	/**
	 * A regular state must have a name.
	 */
	public void testStateWithoutName() {
		prepareStateTest();
		
		state.setName(null);
		assertFalse(validator.validate(state,  diagnostics, new HashMap<Object,Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}

	/**
	 * A states name must not be empty.
	 */
	public void testStateWithEmptyName() {
		prepareStateTest();
		
		state.setName("");
		assertFalse(validator.validate(state,  diagnostics, new HashMap<Object,Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}
	
	
	/**
	 * A state name with just white spaces is not valid.
	 */
	public void testStateWithWhitespaceName() {
		prepareStateTest();
		
		state.setName(" 	");
		assertFalse(validator.validate(state,  diagnostics, new HashMap<Object,Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}

	
	/**
	 * A state must be reachable.
	 */
	public void testStateUnreachable() {
		prepareStateTest();
		
		assertFalse(validator.validate(state,  diagnostics, new HashMap<Object,Object>()));
		assertError(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	
	/**
	 * A regular state may be a dead end.
	 */
	public void testStateDeadEnd() {
		prepareStateTest();
		
		validator.validate(state,  diagnostics, new HashMap<Object,Object>());
		assertNoIssue(diagnostics, ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION);
	}

	
	/**
	 * A valid regular state must produce no issues.
	 */
	public void testValidState() {
		prepareStateTest();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);
				
		assertTrue(validator.validate(state,  diagnostics, new HashMap<Object,Object>()));
		assertIssueCount(diagnostics, 0);
	}

	
	/**
	 * An initial entry should have no incoming transition
	 */
	public void testInitialEntryWithIncomingTransition() {
		prepareStateTest();
		
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(state, entry);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertFalse(validator.validate(entry,  diagnostics, new HashMap<Object,Object>()));		
		assertWarning(diagnostics, ISSUE_INITIAL_ENTRY_WITH_IN_TRANS);
	}
	
	
	/**
	 * A valid entry should have No issues
	 */
	public void testValidInitialEntry() {
		prepareStateTest();
		
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertTrue(validator.validate(entry,  diagnostics, new HashMap<Object,Object>()));		
		assertIssueCount(diagnostics, 0);
	}
	
	
	/**
	 * An initial entry should have an outgoing transition
	 */
	public void testInitialEntryWithoutOutTransition() {
		prepareStateTest();
		
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		
		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertFalse(validator.validate(entry,  diagnostics, new HashMap<Object,Object>()));		
		assertWarning(diagnostics, ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS);
	}
	
	/**
	 * An entry should not have more than one outgoing transition
	 */
	public void testEntryMultipleOutTransition() {
		prepareStateTest();
		
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry,	state);
		createTransition(entry, state);
		
		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertFalse(validator.validate(entry,  diagnostics, new HashMap<Object,Object>()));		
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);
		
		entry.setKind(EntryKind.SHALLOW_HISTORY);
		
		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry,  diagnostics, new HashMap<Object,Object>()));		
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);
		
		entry.setKind(EntryKind.DEEP_HISTORY);
		
		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry,  diagnostics, new HashMap<Object,Object>()));		
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);
		

	}
	
	public void testEntryWithTriggeredTransition() {
		prepareStateTest();
		
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		Transition trans = createTransition(entry, state);
		trans.setTrigger(sTextFactory.createReactionTrigger());
		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_TRIGGER);
	}
	
	
	/**
	 * A final state should have at least one incoming transition.
	 */
	public void testFinalStateIsolated() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		
		assertFalse(validator.validate(finalState,  diagnostics, new HashMap<Object,Object>()));
		
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}


	/**
	 * A positive case for a valid final state.
	 */
	public void testFinalStateValid() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);
		createTransition(state, finalState);

		assertTrue(validator.validate(finalState,  diagnostics, new HashMap<Object,Object>()));
		assertIssueCount(diagnostics, 0);
	}

	
	/**
	 * A final state should have at least one incoming transition.
	 */
	public void testFinalStateOutgoingTransitions() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, finalState);
		createTransition(finalState, state);


		assertFalse(validator.validate(finalState,  diagnostics, new HashMap<Object,Object>()));
		
		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, SGraphValidator.ISSUE_FINAL_STATE_OUTGOING_TRANSITION);
	}


	
	
	protected Transition createTransition(Vertex source, Vertex target) {
		Transition trans = factory.createTransition();
		trans.setSource(source);
		trans.setTarget(target);
		source.getOutgoingTransitions().add(trans);
		target.getIncomingTransitions().add(trans);
		return trans;
	}
	

	
	protected void assertError(BasicDiagnostic diag, String message) {
		Diagnostic d = issueByName(diag, message);
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
		assertEquals("Issue '" + message + "' is no error.", Diagnostic.ERROR, d.getSeverity());
	}
	
	protected void assertWarning(BasicDiagnostic diag, String message) {
		Diagnostic d = issueByName(diag, message);
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
		assertEquals("Issue '" + message + "' is no warning.", Diagnostic.WARNING, d.getSeverity());
	}
	

	protected void assertIssue(BasicDiagnostic diag, String message) {
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
	}
	
	protected void assertNoIssue(BasicDiagnostic diag, String message) {
		assertNull("Issue '" + message + "' does exist.", issueByName(diag, message));
	}

	protected void assertIssueCount(BasicDiagnostic diag, int count) {
		int c = diagnostics.getChildren().size();
		assertEquals("expected " + count + " issue(s) but were " + c + " [" + diag.toString() + "]", count, c);
	}
	
	
	protected Diagnostic issueByName(BasicDiagnostic diag, String message) {
		for (Diagnostic issue : diag.getChildren()) {
			if (message.equals(issue.getMessage())) return issue;
		}
		
		return null;
	}

}
