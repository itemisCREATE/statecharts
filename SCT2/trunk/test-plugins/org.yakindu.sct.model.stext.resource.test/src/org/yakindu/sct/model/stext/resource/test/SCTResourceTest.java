/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.resource.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.resource.impl.StextResource;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTResourceTest {

	private StextFactory stextFac = StextFactory.eINSTANCE;

	private StextResource res;

	@Before
	public void setUp() throws Exception {
		Injector injector = STextActivator.getInstance().getInjector(STextActivator.ORG_YAKINDU_SCT_MODEL_STEXT_STEXT);
		ResourceSet resourceSet = new ResourceSetImpl();
		res = new StextResource(URI.createURI("test.test"));
		res.eAdapters().add(new ContextElementAdapter(new IContextElementProvider() {
			public EObject getContextObject() {
				return res.getContents().get(0);
			}
		}));
		resourceSet.getResources().add(res);
		injector.injectMembers(res);
	}

	@After
	public void tearDown() throws Exception {
		res = null;
	}

	@Test
	public void testFragments() throws Exception {
		SCTUnitTestModels models = new SCTUnitTestModels();
		List<Statechart> originalStatecharts = models.loadAllStatecharts();
		List<Statechart> targetStatecharts = models.loadAllStatecharts();
		for (int i = 0; i < originalStatecharts.size(); i++) {
			Statechart statechart = originalStatecharts.get(i);
			Statechart targetStatechart = targetStatecharts.get(i);
			Resource targetResource = targetStatechart.eResource();
			assertTrue(statechart != targetStatechart);
			assertTrue(EcoreUtil.equals(statechart, targetStatechart));
			TreeIterator<EObject> allContents = EcoreUtil.getAllContents(statechart.eResource(), true);
			while (allContents.hasNext()) {
				EObject next = allContents.next();
				String fragment = EcoreUtil.getURI(next).fragment();
				EObject targetObject = targetResource.getEObject(fragment);
				assertNotNull("Could not resolve fragment " + fragment + " for EObject " + next + "in statechart "
						+ statechart.getName(), targetObject);
				assertTrue(EcoreUtil.equals(next, targetObject));
			}
		}
	}

	@Test
	public void testStatechartParsing() {
		Statechart statechart = createStatechart("internal: event Event1");
		assertEquals(0, statechart.getScopes().size());
		res.getContents().add(statechart);
		assertEquals(1, statechart.getScopes().size());
		Scope scope = statechart.getScopes().get(0);
		assertTrue(scope instanceof InternalScope);
		EList<Declaration> declarations = ((InternalScope) scope).getDeclarations();
		Declaration declaration = declarations.get(0);
		assertTrue(declaration instanceof EventDefinition);
		assertEquals("" + res.getSyntaxDiagnostics(), 0, res.getSyntaxDiagnostics().size());
	}

	@Test
	public void testTransitionParsing() throws Exception {
		Transition transition = createTransition("after 10 s [true] / 3 * 3");
		assertNull(transition.getTrigger());
		assertNull(transition.getEffect());
		res.getContents().add(transition);
		assertNotNull(transition.getTrigger());
		assertNotNull(transition.getEffect());
	}

	@Test
	public void testStateParsing() throws Exception {
		State state = createState("entry / 3 * 3");
		assertEquals(0, state.getReactions().size());
		res.getContents().add(state);
		assertEquals(1, state.getReactions().size());
		assertEquals("" + res.getSyntaxDiagnostics(), 0, res.getSyntaxDiagnostics().size());
	}

	public void testInvalidExpressionParsing() {
		State state = createState("This is not a valid expression");
		res.getContents().add(state);
		assertEquals(1, res.getSyntaxDiagnostics().size());
		assertTrue(res.getErrors().get(0) instanceof XtextSyntaxDiagnostic);
	}

	@Test
	public void testStatechartSerializing1() throws Exception {
		res.setSerializerEnabled(true);
		Statechart statechart = createStatechart("internal: event Event1");
		res.getContents().add(statechart);
		Scope internalScope = (InternalScope) statechart.getScopes().get(0);
		Event event = internalScope.getEvents().get(0);
		event.setName("Event2");
		assertEquals("internal: event Event2\n", statechart.getSpecification());
		assertEquals("" + res.getSyntaxDiagnostics(), 0, res.getSyntaxDiagnostics().size());
	}

	@Test
	public void testTransitionSerializing() throws Exception {
		res.setSerializerEnabled(true);
		Transition transition = createTransition("after 10\n s [true] / 3 * 3");
		res.getContents().add(transition);
		ReactionTrigger trigger = (ReactionTrigger) transition.getTrigger();
		TimeEventSpec timeTrigger = stextFac.createTimeEventSpec();
		timeTrigger.setType(TimeEventType.EVERY);
		timeTrigger.setUnit(TimeUnit.SECOND);
		PrimitiveValueExpression exp = stextFac.createPrimitiveValueExpression();
		IntLiteral literal = stextFac.createIntLiteral();
		literal.setValue(42);
		exp.setValue(literal);
		timeTrigger.setValue(exp);
		trigger.getTriggers().add(timeTrigger);
		assertEquals("after 10\n s , every 42 s [true] / 3 * 3", transition.getSpecification());
		assertEquals("" + res.getErrors(), 0, res.getErrors().size());
	}

	@Test
	public void testStateSerializing() throws Exception {
		res.setSerializerEnabled(true);
		State state = createState("entry / 3 * 3");
		res.getContents().add(state);
		LocalReaction reaction = (LocalReaction) state.getLocalReactions().get(0);
		ReactionTrigger trigger = (ReactionTrigger) reaction.getTrigger();
		ExitEvent exitEvent = stextFac.createExitEvent();
		trigger.getTriggers().add(exitEvent);
		assertEquals("entry , exit / 3 * 3", state.getSpecification());
		assertEquals("" + res.getErrors(), 0, res.getErrors().size());
	}

	@Test
	public void testLinkingSuccess() throws Exception {
		Statechart statechart = createStatechart("internal: event Event1");
		res.getContents().add(statechart);
		Transition transition = createTransition("Event1 [true] / 3 * 3");
		res.getContents().add(transition);
		res.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		assertEquals("" + res.getLinkingDiagnostics(), 0, res.getLinkingDiagnostics().size());
		ReactionTrigger trigger = (ReactionTrigger) transition.getTrigger();
		RegularEventSpec eventSpec = (RegularEventSpec) trigger.getTriggers().get(0);
		ElementReferenceExpression expression = (ElementReferenceExpression) eventSpec.getEvent();
		EventDefinition reference = (EventDefinition) expression.getReference();
		assertNotNull(reference);
		assertEquals("Event1", reference.getName());
	}

	@Test
	public void testLinkingError1() throws Exception {
		Statechart statechart = createStatechart("internal: event Event1");
		res.getContents().add(statechart);
		Transition transition = createTransition("Event2 [true] / 3 * 3");
		res.getContents().add(transition);
		res.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		System.out.println(res.getLinkingDiagnostics());
		assertEquals(1, res.getLinkingDiagnostics().size());
	}

	@Test
	public void testLinkingError2() throws Exception {
		Statechart statechart = createStatechart("internal: event Event1");
		res.getContents().add(statechart);
		Transition transition = createTransition("Event1 [true] / 3 * 3");
		res.getContents().add(transition);
		statechart.setSpecification("internal: event Event2");
		res.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		assertEquals(1, res.getLinkingDiagnostics().size());
	}

	@Test
	public void testParsingOnLoad() throws Exception {
		File tmpFile = File.createTempFile("SCTResource", "test.test");
		tmpFile.deleteOnExit();
		URI uri = URI.createFileURI(tmpFile.getPath().toString());
		Resource resource = new XMIResourceImpl(uri);
		Statechart statechart = createStatechart("internal: event Event1");
		resource.getContents().add(statechart);
		Transition transition = createTransition("Event1 [true] / 3 * 3");
		resource.getContents().add(transition);
		resource.save(Collections.EMPTY_MAP);

		res.setURI(uri);
		res.load(Collections.EMPTY_MAP);
		statechart = (Statechart) res.getContents().get(0);
		transition = (Transition) res.getContents().get(1);

		assertEquals("" + res.getErrors(), 0, res.getErrors().size());
		ReactionTrigger trigger = (ReactionTrigger) transition.getTrigger();
		RegularEventSpec eventSpec = (RegularEventSpec) trigger.getTriggers().get(0);
		ElementReferenceExpression expression = (ElementReferenceExpression) eventSpec.getEvent();
		EventDefinition reference = (EventDefinition) expression.getReference();
		assertNotNull(reference);
		assertEquals("Event1", reference.getName());
	}

	@Test
	public void testRemoveOrphanedSyntaxDiagnostics() throws Exception {
		Statechart statechart = createStatechart("invalid expression");
		res.getContents().add(statechart);
		assertEquals(1, res.getSyntaxDiagnostics().size());
		statechart.setSpecification("internal: event Event1");
		assertEquals(0, res.getSyntaxDiagnostics().size());
	}

	@Test
	public void testRemoveOrphanedLinkingDiagnostics() throws Exception {
		Statechart statechart = createStatechart("internal: event Event1");
		res.getContents().add(statechart);
		Transition transition = createTransition("Event2 [true] / 3 * 3");
		res.getContents().add(transition);
		res.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		assertEquals(1, res.getLinkingDiagnostics().size());
		transition.setSpecification("Event1 [true] / 3 * 3");
		res.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		assertEquals(0, res.getLinkingDiagnostics().size());
	}

	protected Statechart createStatechart(String exp) {
		Statechart statechart = SGraphFactory.eINSTANCE.createStatechart();
		statechart.setSpecification(exp);
		return statechart;
	}

	protected Transition createTransition(String exp) {
		Transition transition = SGraphFactory.eINSTANCE.createTransition();
		transition.setSpecification(exp);
		return transition;
	}

	protected State createState(String exp) {
		State state = SGraphFactory.eINSTANCE.createState();
		state.setSpecification(exp);
		return state;
	}
}
