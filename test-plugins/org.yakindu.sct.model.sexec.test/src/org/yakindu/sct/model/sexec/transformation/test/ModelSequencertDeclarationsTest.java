package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.TYPE_INTEGER;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createRegion;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createState;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createStatechart;
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory._createTransition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createEventDefinition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInterfaceScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createInternalScope;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createOperation;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createOperationCall;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createReactionEffect;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createReactionTrigger;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createRegularEventSpec;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createValue;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory._createVariableDefinition;
import static org.yakindu.sct.model.stext.test.util.StextTestFactory.createGuardExpression;

import org.junit.Test;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Declaration;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

public class ModelSequencertDeclarationsTest extends ModelSequencerTest {

	/**
	 * the scope name must be mapped.
	 */
	@Test
	public void testScopeName() {
		InterfaceScope scope = _createInterfaceScope("abc", null);
		assertEquals(scope.getName(), ((InterfaceScope) structureMapping.mapScope(scope)).getName());
	}

	/**
	 * An InternalScope must be mapped to an InternalScope.
	 */
	@Test
	public void testMapEmptyInternalScope() {
		InternalScope scope = _createInternalScope(null);
		Scope _scope = structureMapping.mapScope(scope);

		assertTrue(_scope instanceof InternalScope);
	}

	@SuppressWarnings("unused")
	@Test
	public void testMapScope() {

		InterfaceScope scope = _createInterfaceScope(null, null);
		EventDefinition e1 = _createEventDefinition("e1", scope);
		EventDefinition e2 = _createEventDefinition("e2", scope);
		VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, scope);

		Scope _scope = structureMapping.mapScope(scope);

		assertTrue(_scope instanceof InterfaceScope);
		assertEquals(3, _scope.getDeclarations().size());

		for (int i = 0; i < _scope.getDeclarations().size(); i++) {
			Declaration s_decl = scope.getDeclarations().get(i);
			Declaration r_decl = _scope.getDeclarations().get(i);

			assertNotSame(s_decl, r_decl);
			assertEquals(s_decl.getName(), r_decl.getName());
			assertEquals(s_decl.getClass(), r_decl.getClass());
		}
	}

	/**
	 * The event refs used in the trigger condition must refer to the event
	 * declarations in the flow model and not the sc source model.
	 */
	@Test
	public void testTriggerEventDeclarationIntegrity() {

		Statechart sc = _createStatechart("test");
		InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		EventDefinition e1 = _createEventDefinition("e1", s_scope);
		Region r = _createRegion("main", sc);
		State s1 = _createState("S1", r);
		State s2 = _createState("S2", r);
		Transition t = _createTransition(s1, s2);
		ReactionTrigger tr1 = _createReactionTrigger(t);
		_createRegularEventSpec(e1, tr1);

		ExecutionFlow flow = sequencer.transform(sc);

		EventDefinition _e1 = (EventDefinition) flow.getScopes().get(0).getDeclarations().get(0);
		assertNotSame(e1, _e1);
		assertEquals(e1.getName(), _e1.getName());

		assertEquals(2, flow.getStates().size());
		assertEquals(s1.getName(), flow.getStates().get(0).getSimpleName());
		Step step = flow.getStates().get(0).getReactSequence().getSteps().get(0);
		If _if = (If) assertedSequence(assertedSequence(step).getSteps().get(0)).getSteps().get(0);

		ElementReferenceExpression _ere = (ElementReferenceExpression) _if.getCheck().getCondition();
		assertSame(_e1, _ere.getReference());
	}

	/**
	 * The OperationCalls must map to Operations in Scopes inside the Flow..
	 */
	@Test
	public void testOperationMapping() {

		Statechart sc = _createStatechart("test");
		InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		OperationDefinition _operation = _createOperation("value", s_scope);
		Region r = _createRegion("main", sc);
		State s1 = _createState("S1", r);
		State s2 = _createState("S2", r);
		Transition t = _createTransition(s1, s2);
		ReactionTrigger tr = _createReactionTrigger(t);
		tr.setGuard(createGuardExpression(_createValue(true)));
		ReactionEffect tr1 = _createReactionEffect(t);
		FeatureCall _operationCall = _createOperationCall(_operation);
		tr1.getActions().add(_operationCall);

		ExecutionFlow flow = sequencer.transform(sc);

		OperationDefinition _o1 = (OperationDefinition) flow.getScopes().get(0).getDeclarations().get(0);
		assertNotSame(_operation, _o1);
		assertEquals(_operation.getName(), _o1.getName());

		Step step = flow.getStates().get(0).getReactSequence().getSteps().get(0);
		If _if = (If) assertedSequence(assertedSequence(step).getSteps().get(0)).getSteps().get(0);
		Step thenSequence = assertedSequence(((Call) _if.getThenStep()).getStep()).getSteps().get(1);
		Execution call = (Execution) assertedSequence(thenSequence).getSteps().get(0);
		assertNotSame(_operationCall, call.getStatement());
		assertSame(_o1, ((FeatureCall) call.getStatement()).getFeature());
	}
}
