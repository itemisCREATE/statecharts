/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test;

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator.*;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.validation.Check;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Test of all validation rules that test very basic properties of statecharts.
 * 
 * @author terfloth
 * @author muelder - additions
 * @author antony -additions
 */
@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class SGraphJavaValidationTest {

	static {
		// set up EMF - the EPackage.Registry requires a context class loader
		// ...
		if (Thread.currentThread().getContextClassLoader() == null) {
			Thread.currentThread().setContextClassLoader(SGraphJavaValidationTest.class.getClassLoader());
		}
		SGraphPackage.eINSTANCE.eClass();
	}

	protected SGraphFactory factory;
	protected StextFactory sTextFactory;

	@Inject
	protected SGraphJavaValidator validator;

	protected BasicDiagnostic diagnostics;

	protected Statechart statechart;
	protected Region region;
	private State state;

	@Before
	public void setUp() throws Exception {
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
		state.setName(getClass().getSimpleName());
		region.getVertices().add(state);
	}

	/**
	 * A regular state must have a name.
	 */
	@Test
	public void stateWithoutName() {
		prepareStateTest();

		state.setName(null);
		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}

	/**
	 * A states name must not be empty.
	 */
	@Test
	public void nameIsNotEmpty() {
		prepareStateTest();

		state.setName("");
		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}

	/**
	 * A state name with just white spaces is not valid.
	 */
	@Test
	public void stateWithWhitespaceName() {
		prepareStateTest();

		state.setName(" 	");
		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}

	/**
	 * A state must be reachable.
	 */
	@Test
	public void vertexNotReachable() {
		prepareStateTest();

		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	/**
	 * A transition to a sub entry is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubstate() {
		prepareStateTest();

		State stateA = factory.createState();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);

		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(stateC);

		validate(state);
		assertNoIssues(diagnostics);
	}

	/**
	 * A transition to a sub entry is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubentry() {
		prepareStateTest();

		State stateA = factory.createState();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);

		Entry entry = factory.createEntry();
		subRegion.getVertices().add(entry);

		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(entry);

		Transition t2 = factory.createTransition();
		t2.setSource(entry);
		t2.setTarget(stateC);

		validate(state);
		assertNoIssues(diagnostics);
	}

	/**
	 * A transition to a sub choice is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubchoice() {
		prepareStateTest();

		State stateA = factory.createState();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);

		Choice choice = factory.createChoice();
		subRegion.getVertices().add(choice);

		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(choice);

		Transition t2 = factory.createTransition();
		t2.setSource(choice);
		t2.setTarget(stateC);

		validate(state);
		assertNoIssues(diagnostics);
	}

	/**
	 * If an incoming transitions is part of an external transition path that
	 * only consists of pseudo states and only has state predecessors within the
	 * state then the state is not reachable and the validation must fail with
	 * an error.
	 */
	@Test
	public void vertexNotReachable_FailOnExternalPseudoPath() {
		prepareStateTest();

		Choice choice = factory.createChoice();
		region.getVertices().add(choice);

		createTransition(state, choice);
		createTransition(choice, state);

		validate(state);
		assertIssue(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	/**
	 * If an incoming transitions is part of an external transition path to an
	 * internal state that only consists of pseudo states and only has state
	 * predecessors within the state then the state is not reachable and the
	 * validation must fail with an error.
	 */
	@Test
	public void vertexNotReachable_FailOnExternalPseudoPathToSubstate() {
		prepareStateTest();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateA = factory.createState();
		subRegion.getVertices().add(stateA);

		Choice choice = factory.createChoice();
		region.getVertices().add(choice);

		createTransition(stateA, choice);
		createTransition(choice, stateA);

		validate(state);
		assertIssue(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	/**
	 * A regular state may be a dead end.
	 */
	@Test
	public void stateDeadEnd() {
		prepareStateTest();

		validator.validate(state, diagnostics, new HashMap<Object, Object>());
		assertNoIssue(diagnostics, ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION);
	}

	/**
	 * A valid regular state must produce no issues.
	 */
	@Test
	public void validState() {
		prepareStateTest();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);

		validate(state);
		// assertTrue(validator.validate(state, diagnostics,
		// new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	/**
	 * An initial entry should have no incoming transition
	 */
	@Test
	public void incomingTransitionCount() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(state, entry);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		validator.validate(entry, diagnostics, new HashMap<Object, Object>());
		assertWarning(diagnostics, ISSUE_INITIAL_ENTRY_WITH_IN_TRANS);
	}

	/**
	 * A valid entry should have No issues
	 */
	@Test
	public void validInitialEntry() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertTrue(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	/**
	 * An initial entry should have an outgoing transition
	 */
	@Test
	public void initialEntryWithoutOutTransition() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		validator.validate(entry, diagnostics, new HashMap<Object, Object>());
		assertWarning(diagnostics, ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS);
	}

	/**
	 * An entry should not have more than one outgoing transition
	 */
	@Test
	public void entryMultipleOutTransition() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);

		entry.setKind(EntryKind.SHALLOW_HISTORY);

		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);

		entry.setKind(EntryKind.DEEP_HISTORY);

		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);

	}

	@Test
	public void disallowTrigger() {
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
	@Test
	public void finalStateIsolated() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);

		assertFalse(validate(finalState));

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	/**
	 * A positive case for a valid final state.
	 */
	@Test
	public void finalStateValid() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);
		createTransition(state, finalState);

		assertTrue(validate(finalState));
		assertIssueCount(diagnostics, 0);
	}

	/**
	 * A final state should have no outgoing transitions
	 */
	@Test
	public void outgoingTransitionCount() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, finalState);
		createTransition(finalState, state);

		validate(finalState);

		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, ISSUE_FINAL_STATE_OUTGOING_TRANSITION);
	}

	/**
	 * A choice must have at least one outgoing transition
	 */
	@Test
	public void choiceOutgoingTransitions() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		Choice choice = factory.createChoice();
		region.getVertices().add(choice);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, choice);

		assertFalse(validator.validate(choice, diagnostics, new HashMap<Object, Object>()));

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_CHOICE_WITHOUT_OUTGOING_TRANSITION);
	}

	

	@Test
	public void synchronizationTransitionCount() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR
				+ "SynchronizationTransitionCount.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Synchronization) {
				assertTrue(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 2);
		assertWarning(diagnostics, ISSUE_SYNCHRONIZATION_TRANSITION_COUNT);
	}

	@Test
	public void orthogonalStates() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "NotOrthogonalRegion01.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Synchronization) {
				assertFalse(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 2);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_ORTHOGONAL);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_ORTHOGONAL);

		diagnostics = new BasicDiagnostic();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "NotOrthogonalRegion02.sct");
		iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Synchronization) {
				assertFalse(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 2);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_WITHIN_SAME_PARENTSTATE);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_WITHIN_SAME_PARENTSTATE);

		diagnostics = new BasicDiagnostic();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "NotOrthogonalRegion03.sct");
		iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Synchronization) {
				assertFalse(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 2);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_WITHIN_SAME_PARENTSTATE);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_WITHIN_SAME_PARENTSTATE);
	}

	@Test
	public void orthogonalStatesValid() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "OrthogonalRegion01.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Synchronization) {
				assertTrue(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 0);
	}

	
	@Test
	public void regionCantBeEnteredUsingShallowHistory() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR
				+ "RegionCantBeEnteredUsingShallowHistory.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof State) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY);
	}


	/**
	 * checks that each @Check method of {@link STextJavaValidator} has a @Test
	 * method in this class with the same name
	 */
	// TODO: Create abstract test class for SGraphJavaValidatorTest and
	// STextJAvaValidatorTest
	@Test
	public void testAllChecksHaveTests() throws Exception {
		Iterable<Method> methods = Lists.newArrayList(SGraphJavaValidator.class.getMethods());
		methods = Iterables.filter(methods, new Predicate<Method>() {
			public boolean apply(Method input) {
				return input.getAnnotation(Check.class) != null;
			}
		});
		for (Method checkMethod : methods) {
			Method testMethod = getClass().getMethod(checkMethod.getName());
			assertNotNull("Missing @Test Annotation for method " + checkMethod.getName(),
					testMethod.getAnnotation(Test.class));
		}
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

	protected void assertNoIssues(BasicDiagnostic diag) {
		assertIssueCount(diag, 0);
	}

	protected void assertIssueCount(BasicDiagnostic diag, int count) {
		int c = diagnostics.getChildren().size();
		assertEquals("expected " + count + " issue(s) but were " + c + " [" + diag.toString() + "]", count, c);
	}

	protected Diagnostic issueByName(BasicDiagnostic diag, String message) {
		for (Diagnostic issue : diag.getChildren()) {
			if (message.equals(issue.getMessage()))
				return issue;
		}

		return null;
	}

	protected boolean validate(EObject obj) {
		return validator.validate(obj, diagnostics, new HashMap<Object, Object>());
	}

}
