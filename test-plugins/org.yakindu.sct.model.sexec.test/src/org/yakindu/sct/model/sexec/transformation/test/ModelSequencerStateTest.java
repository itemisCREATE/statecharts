package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ModelSequencerStateTest {

	
	@Inject
	private ModelSequencer sequencer;

	@Before
	public void setup() {
		Injector injector = Guice.createInjector(new SequencerModule());
		injector.injectMembers(this);
	}


	/**
	 * if a state defines a entry action then the execution state must have a entryAction.
	 */
	@Test public void testStateEntryAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction entryAction = _createEntryAction(s2);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());
		
		assertNotNull(_s2.getEntryAction());
		assertNull(_s1.getEntryAction());
	}

	
	/**
	 * entry actions of a substate must not be included in a states entry action list
	 */
	@Test public void testSubStateEntryAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
//		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s2 = _createState("s2", r);
		
		Region s2_r = _createRegion("sub", s2);
		State s2_1 = _createState("s2_1", s2_r);
		LocalReaction entryAction = _createEntryAction(s2_1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		LocalReaction exitAction = _createExitAction(s2_1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("43"), (ReactionEffect) exitAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(0);
		ExecutionState _s2_1 = flow.getStates().get(1);
		assertEquals(s2.getName(), _s2.getSimpleName());
		assertEquals(s2_1.getName(), _s2_1.getSimpleName());
		
		assertNull(_s2.getEntryAction());
		assertNotNull(_s2_1.getEntryAction());

		assertNull(_s2.getExitAction());
		assertNotNull(_s2_1.getExitAction());
}
	
	
	/**
	 * if a state defines a exit action then the execution state must have a exitAction.
	 */
	@Test public void testStateExitAction() {
		Statechart sc = _createStatechart("test");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("main", sc);
		Entry e = _createEntry(EntryKind.INITIAL, null, r);
		State s1 = _createState("s1", r);
		State s2 = _createState("s2", r);
		_createTransition(e, s1);
		_createTransition(s1, s2);
		LocalReaction exitAction = _createExitAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("21"), (ReactionEffect) exitAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals(s1.getName(), _s1.getSimpleName());
		assertEquals(s2.getName(), _s2.getSimpleName());
		
		assertNotNull(_s1.getExitAction());
		assertNull(_s2.getExitAction());
	}
	

	
	/**
	 * A leaf state must have a enter sequence. 
	 * This enter sequence consists of an entry action call and a state enter step.
	 */
	@Test public void testLeafStateEnterSequence() {
		Statechart sc = _createStatechart("cs");
		Scope scope = _createInterfaceScope("interface", sc);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		Region r = _createRegion("r", sc);
		State s1 = _createState("s1", r);
		LocalReaction entryAction = _createEntryAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), (ReactionEffect) entryAction.getEffect());
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals(s1.getName(), _s1.getSimpleName());
		
		assertNotNull(_s1.getEntryAction());
		assertNotNull(_s1.getEnterSequence());
		assertEquals(2, _s1.getEnterSequence().getSteps().size());
		Call entryCall = (Call) _s1.getEnterSequence().getSteps().get(0);
		assertSame(_s1.getEntryAction(), entryCall.getStep());
		
		assertTrue(_s1.getEnterSequence().getSteps().get(1) instanceof EnterState);
	}

	
	/**
	 * A composite state must have a enter sequence. 
	 * This enter sequence consists of an entry action call and a enter sequence call for each sub region.
	 */
	@Test public void testCompositeStateEnterSequence() {
		Statechart sc = _createStatechart("cs"); {
			Scope scope = _createInterfaceScope("interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createEntryAssignemnt(v1, s1, "1");
					Region r1_s1 = _createRegion("r1", s1); {
						Entry e = _createEntry(EntryKind.INITIAL, null, r1_s1);
						State s2 = _createState("s2", r1_s1);
						_createTransition(e, s2);
					}
					Region r2_s1 = _createRegion("r2", s1); {
						Entry e = _createEntry(EntryKind.INITIAL, null, r2_s1);
						State s3 = _createState("s3", r2_s1);
						_createTransition(e, s3);
					}
				}
			}
		}
		
	
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("s1", _s1.getSimpleName());
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("s2", _s2.getSimpleName());
		
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("s3", _s3.getSimpleName());
		
		assertNotNull(_s1.getEntryAction());
		assertNotNull(_s1.getEnterSequence());
		assertEquals(3, _s1.getEnterSequence().getSteps().size());
		Call entryCall = (Call) _s1.getEnterSequence().getSteps().get(0);
		assertSame(_s1.getEntryAction(), entryCall.getStep());
		
		Call subEnterCall1 = (Call) _s1.getEnterSequence().getSteps().get(1);
		assertSame(_s2.getEnterSequence(), subEnterCall1.getStep());

		Call subEnterCall2 = (Call) _s1.getEnterSequence().getSteps().get(2);
		assertSame(_s3.getEnterSequence(), subEnterCall2.getStep());
	}


}
