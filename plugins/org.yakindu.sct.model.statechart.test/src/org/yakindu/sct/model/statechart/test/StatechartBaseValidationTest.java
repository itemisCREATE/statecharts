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
package org.yakindu.sct.model.statechart.test;

import java.util.HashMap;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.yakindu.model.sct.statechart.Entry;
import org.yakindu.model.sct.statechart.FinalState;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartFactory;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.model.sct.statechart.Vertex;
import org.yakindu.model.sct.statechart.util.StatechartValidator;
import static org.yakindu.model.sct.statechart.util.StatechartValidator.*;

/**
 * Test of all validation rules that test very basic properties of statecharts.
 * 
 * @author terfloth
 */
public class StatechartBaseValidationTest extends TestCase {
	

	static {
		// set up EMF - the EPackage.Registry requires a context class loader ...
		if (Thread.currentThread().getContextClassLoader() == null) {
			Thread.currentThread().setContextClassLoader(StatechartBaseValidationTest.class.getClassLoader());	
		}
		StatechartPackage.eINSTANCE.eClass();
	}
	
	protected StatechartFactory factory;
	protected StatechartValidator validator;
	protected BasicDiagnostic diagnostics;
	
	protected Statechart statechart;
	protected Region region;
	private State state;


	@Override
	protected void setUp() throws Exception {
		super.setUp();
		validator = new StatechartValidator();
		diagnostics = new BasicDiagnostic();
		factory = StatechartFactory.eINSTANCE;
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
		createTransition(entry, state);
				
		assertTrue(validator.validate(state,  diagnostics, new HashMap<Object,Object>()));
		assertIssueCount(diagnostics, 0);
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
		assertWarning(diagnostics, StatechartValidator.ISSUE_FINAL_STATE_OUTGOING_TRANSITION);
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
