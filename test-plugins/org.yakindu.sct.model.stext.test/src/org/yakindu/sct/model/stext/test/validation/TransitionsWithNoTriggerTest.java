/**
 * Copyright (c) 2015 itemis AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test.validation;

import static org.eclipse.xtext.EcoreUtil2.eAllOfType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.firstNamed;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.validation.STextValidationMessages;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

/** 
 * @author terfloth - Initial contribution
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class TransitionsWithNoTriggerTest extends AbstractSTextValidationTest implements STextValidationMessages {
	
	
	
	private Entry entry;
	protected State stateA;
	private State stateB;
	private State stateC;
	private State stateD;
	private Choice choice;
	private State stateE;
	private Transition entryToStateA;
	private Transition stateAToStateB;
	private Transition stateBToStateC;
	private Transition stateCToStateD;
	private Transition choiceToStateE;
	private State stateBB;
	private Entry entryB;
	private Exit exitB;
	private Region regionB;
	private Transition entryBToStateBB;
	private Transition stateBBToExitB;

	
	@Override @Before 
	public void setup() {
		super.setup();
		
		StextFactory stextFactory = StextFactory.eINSTANCE;
		
		Region region = factory.createRegion();

		entry = factory.createEntry();
		stateA = factory.createState();
		stateA.setName("A");
		stateB = factory.createState();
		stateB.setName("B");
		stateC = factory.createState();
		stateC.setName("C");
		stateD = factory.createState();
		stateD.setName("D");
		choice = factory.createChoice();
		stateE = factory.createState();
		stateE.setName("E");
		entryToStateA = createTransition(entry, stateA);
		stateAToStateB = createTransition(stateA, stateB);
		stateBToStateC = createTransition(stateB, stateC);

		stateCToStateD = createTransition(stateC, stateD);
		stateCToStateD.setSpecification("always");
		ReactionTrigger triggerCToD = stextFactory.createReactionTrigger();
		triggerCToD.getTriggers().add(stextFactory.createAlwaysEvent());
		stateCToStateD.setTrigger(triggerCToD);
		
		choiceToStateE = createTransition(choice, stateE);

		stateBB = factory.createState();
		stateBB.setName("BB");
		entryB = factory.createEntry();
		exitB = factory.createExit();

		regionB = factory.createRegion();
		regionB.getVertices().add(entryB);
		regionB.getVertices().add(stateBB);
		regionB.getVertices().add(exitB);
		stateB.getRegions().add(regionB);
		entryBToStateBB = createTransition(entryB, stateBB);
		stateBBToExitB = createTransition(stateBB, exitB);

		region.getVertices().add(entry);
		region.getVertices().add(stateA);
		region.getVertices().add(stateB);
		region.getVertices().add(stateC);
		region.getVertices().add(stateD);
		statechart.getRegions().add(region);	
	}

	
	
	/** A transition from an entry to a state must have no trigger. */
	@Test public void noTriggerOnTopLevelEntryToState() {

		assertTrue(validator.validate(entryToStateA, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	/** A transition from an entry to a state must have no trigger. */
	@Test public void noTriggerOnSubStateEntryToState() {

		assertTrue(validator.validate(entryBToStateBB, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	/** No trigger on a transition from a choice to a state is valid. */
	@Test public void noTriggerOnChoiceToState() {

		assertTrue(validator.validate(choiceToStateE, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	/** A transition from a state with exit may have no trigger. */
	@Test public void noTriggerOnExitTransition() {

		assertTrue(validator.validate(stateBToStateC, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	/** A transition between two regular states (with no exit) should have a trigger. */
	@Test public void missingTriggerOnStateToState() {

		assertTrue(validator.validate(stateAToStateB, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
	}

	/** A transition from a state to an exit should have a trigger. */
	@Test public void missingTriggerOnStateToExit() {

		assertTrue(validator.validate(stateBBToExitB, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
	}

	/** A transition from a state to a state with a trigger must issue no warning. */
	@Test public void existingTriggerOnStateToState() {

		assertTrue(validator.validate(stateCToStateD, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	
	/**
	 * The outgoing transitions of a sync (fork / join) node must not have any
	 * trigger part. Thus empty transitions must not have any warning. This test
	 * case addresses a bug #75 (
	 * https://code.google.com/a/eclipselabs.org/p/yakindu/issues/detail?id=75 )
	 * .
	 */
	@Test public void noTriggerOnSyncOutgoing() {
		statechart = loadStatechart("ValidEmptyTransitionFromSync.sct");
		
		Region validRegion = firstNamed(eAllOfType(statechart, Region.class), "valid");
		Synchronization sync = eAllOfType(validRegion, Synchronization.class).get(0);
		
		for (Transition t : sync.getOutgoingTransitions()) {
			assertTrue(validate(t));
			assertIssueCount(diagnostics, 0);
		}
	}

	/**
	 * If a sync node has multiple incoming transitions then the transitions can omit the trigger.
	 */
	@Test public void noTriggerOnSyncIncoming() {
		statechart = loadStatechart("ValidEmptyTransitionFromSync.sct");
		
		Region validRegion = firstNamed(eAllOfType(statechart, Region.class), "valid");
		Synchronization sync = eAllOfType(validRegion, Synchronization.class).get(0);
		
		for (Transition t : sync.getIncomingTransitions()) {
			assertTrue(validate(t));
			assertIssueCount(diagnostics, 0);
		}
	}

	
	/**
	 * If a sync node has multiple incoming transitions then the transitions can omit the trigger.
	 */
	@Test public void missingTriggerOnSyncSingleIncoming() {
		statechart = loadStatechart("ValidEmptyTransitionFromSync.sct");
		
		Region validRegion = firstNamed(eAllOfType(statechart, Region.class), "warning");
		Synchronization sync = eAllOfType(validRegion, Synchronization.class).get(0);
		
		assertEquals(1, sync.getIncomingTransitions().size());
		assertTrue(validate(sync.getIncomingTransitions().get(0)));
		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, ISSUE_TRANSITION_WITHOUT_TRIGGER);
	}

	
	
	protected boolean validate(EObject obj) {
		return validator.validate(obj, diagnostics,
				new HashMap<Object, Object>());
	}
	
	protected Statechart loadStatechart(String modelName) {
		return AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR
						+ modelName);
	}


}
