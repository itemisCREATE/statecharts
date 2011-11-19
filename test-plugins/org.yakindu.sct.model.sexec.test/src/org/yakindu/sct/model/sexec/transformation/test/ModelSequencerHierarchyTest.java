package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ModelSequencerHierarchyTest {

	@Inject
	private ModelSequencer sequencer;

	@Before
	public void setup() {
		Injector injector = Guice.createInjector(new SequencerModule());
		injector.injectMembers(this);
	}


	/**
	 * The transition sequence must contain all exit actions for parent states that will be left by a transition.
	 */
	@Test public void testParentEntryDeep() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, s_scope);
			

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createEntryAssignemnt(v1, s1, "1");

					Region r_s1 = _createRegion("r", s1); {
						State s3 = _createState("s3", r_s1); {
							_createEntryAssignemnt(v1, s3, "2");
							
							Region r_s3 = _createRegion("r", s3); {
								State s4 = _createState("s4", r_s3);
								_createEntryAssignemnt(v1, s4, "3");

								State s5 = _createState("s5", r_s3);
							}
						}
					}
				}		
				State s2 = _createState("s2", r); {
					Region r_s1 = _createRegion("r", s2); {
						_createState("s6", r_s1);
					}
				}
			}
		}
	
		_createTransition(findState(sc, "s6"), findState(sc, "s4"));
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getEntryAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getEntryAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getEntryAction());
		
		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());
		assertNull(_s6.getEntryAction());
		
		Reaction _t = _s6.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(5, _effect.getSteps().size());
		
		Call _s4_entryActionCall = (Call) _effect.getSteps().get(4);
		assertSame( _s4.getEntryAction(), _s4_entryActionCall.getStep());	

		Call _s3_entryActionCall = (Call) _effect.getSteps().get(3);
		assertSame( _s3.getEntryAction(), _s3_entryActionCall.getStep());	

		Call _s1_entryActionCall = (Call) _effect.getSteps().get(2);
		assertSame( _s1.getEntryAction(), _s1_entryActionCall.getStep());	
		
	}
	
	
	/**
	 * The transition sequence must contain all exit actions for parent states that will be left by a transition. 
	 * A parent state may have no exit action.
	 * 
	 */
	@Test public void testParentEntryPartial() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, s_scope);
			

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createEntryAssignemnt(v1, s1, "1");

					Region r_s1 = _createRegion("r", s1); {
						State s3 = _createState("s3", r_s1); {
							
							Region r_s3 = _createRegion("r", s3); {
								State s4 = _createState("s4", r_s3);
								_createEntryAssignemnt(v1, s4, "3");

								State s5 = _createState("s5", r_s3);
							}
						}
					}
				}		
				State s2 = _createState("s2", r); {
					Region r_s1 = _createRegion("r", s2); {
						_createState("s6", r_s1);
					}
				}
			}
		}
	
		_createTransition(findState(sc, "s6"), findState(sc, "s4"));
		
		ExecutionFlow flow = sequencer.transform(sc);
			
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getEntryAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNull(_s3.getEntryAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getEntryAction());
		
		ExecutionState _s6 = flow.getStates().get(5);
		assertEquals("sc.r.s2.r.s6", _s6.getName());
		assertNull(_s6.getEntryAction());
		
		Reaction _t = _s6.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(4, _effect.getSteps().size());
		
		Call _s4_entryActionCall = (Call) _effect.getSteps().get(3);
		assertSame( _s4.getEntryAction(), _s4_entryActionCall.getStep());	

		Call _s1_entryActionCall = (Call) _effect.getSteps().get(2);
		assertSame( _s1.getEntryAction(), _s1_entryActionCall.getStep());	
	}
	
	
	
	
	/**
	 * Transitions to sibling state must nut invoke parent exit actions.
	 */
	@Test public void testParentEntryExclusionForSiblingTransitions() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, s_scope);
			

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createEntryAssignemnt(v1, s1, "1");

					Region r_s1 = _createRegion("r", s1); {
						State s3 = _createState("s3", r_s1); {
							_createEntryAssignemnt(v1, s3, "2");

							Region r_s3 = _createRegion("r", s3); {
								State s4 = _createState("s4", r_s3);
								_createEntryAssignemnt(v1, s4, "3");

								State s5 = _createState("s5", r_s3);
							}
						}
					}
				}		
				State s2 = _createState("s2", r); {
					Region r_s1 = _createRegion("r", s2); {
						_createState("s6", r_s1);
					}
				}
			}
		}
	
		_createTransition(findState(sc, "s5"), findState(sc, "s4"));
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getEntryAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getEntryAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getEntryAction());
		
		ExecutionState _s5 = flow.getStates().get(3);
		assertEquals("sc.r.s1.r.s3.r.s5", _s5.getName());
		assertNull(_s5.getEntryAction());
		
		Reaction _t = _s5.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(3, _effect.getSteps().size());
		
		Call _s4_entryActionCall = (Call) _effect.getSteps().get(2);
		assertSame( _s4.getEntryAction(), _s4_entryActionCall.getStep());	
	}


	
	
	
	
	/**
	 * The transition sequence must contain all exit actions for parent states that will be left by a transition.
	 */
	@Test public void testParentExitDeep() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, s_scope);
			

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createExitAssignemnt(v1, s1, "1");

					Region r_s1 = _createRegion("r", s1); {
						State s3 = _createState("s3", r_s1); {
							_createExitAssignemnt(v1, s3, "2");
							
							Region r_s3 = _createRegion("r", s3); {
								State s4 = _createState("s4", r_s3);
								_createExitAssignemnt(v1, s4, "3");

								State s5 = _createState("s5", r_s3);
							}
						}
					}
				}		
				State s2 = _createState("s2", r); {
					Region r_s1 = _createRegion("r", s2); {
						_createState("s6", r_s1);
					}
				}
			}
		}
	
		_createTransition(findState(sc, "s4"), findState(sc, "s6"));
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getExitAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getExitAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getExitAction());
		
		Reaction _t = _s4.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(5, _effect.getSteps().size());
		
		Call _s4_exitActionCall = (Call) _effect.getSteps().get(0);
		assertSame( _s4.getExitAction(), _s4_exitActionCall.getStep());	

		Call _s3_exitActionCall = (Call) _effect.getSteps().get(1);
		assertSame( _s3.getExitAction(), _s3_exitActionCall.getStep());	

		Call _s1_exitActionCall = (Call) _effect.getSteps().get(2);
		assertSame( _s1.getExitAction(), _s1_exitActionCall.getStep());	
		
	}
	
	
	/**
	 * The transition sequence must contain all exit actions for parent states that will be left by a transition. 
	 * A parent state may have no exit action.
	 * 
	 */
	@Test public void testParentExitPartial() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, s_scope);
			

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createExitAssignemnt(v1, s1, "1");

					Region r_s1 = _createRegion("r", s1); {
						State s3 = _createState("s3", r_s1); {
							
							Region r_s3 = _createRegion("r", s3); {
								State s4 = _createState("s4", r_s3);
								_createExitAssignemnt(v1, s4, "3");

								State s5 = _createState("s5", r_s3);
							}
						}
					}
				}		
				State s2 = _createState("s2", r); {
					Region r_s1 = _createRegion("r", s2); {
						_createState("s6", r_s1);
					}
				}
			}
		}
	
		_createTransition(findState(sc, "s4"), findState(sc, "s6"));
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getExitAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNull(_s3.getExitAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getExitAction());
		
		Reaction _t = _s4.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(4, _effect.getSteps().size());
		
		Call _s4_exitActionCall = (Call) _effect.getSteps().get(0);
		assertSame( _s4.getExitAction(), _s4_exitActionCall.getStep());	

		Call _s1_exitActionCall = (Call) _effect.getSteps().get(1);
		assertSame( _s1.getExitAction(), _s1_exitActionCall.getStep());	
		
	}
	

	
	/**
	 * Transitions to sibling state must nut invoke parent exit actions.
	 */
	@Test public void testParentExitExclusionForSiblingTransitions() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, s_scope);
			

			Region r = _createRegion("r", sc); {
				State s1 = _createState("s1", r); {
					_createExitAssignemnt(v1, s1, "1");

					Region r_s1 = _createRegion("r", s1); {
						State s3 = _createState("s3", r_s1); {
							_createExitAssignemnt(v1, s3, "2");

							Region r_s3 = _createRegion("r", s3); {
								State s4 = _createState("s4", r_s3);
								_createExitAssignemnt(v1, s4, "3");

								State s5 = _createState("s5", r_s3);
							}
						}
					}
				}		
				State s2 = _createState("s2", r); {
					Region r_s1 = _createRegion("r", s2); {
						_createState("s6", r_s1);
					}
				}
			}
		}
	
		_createTransition(findState(sc, "s4"), findState(sc, "s5"));
		
		ExecutionFlow flow = sequencer.transform(sc);
		
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());
		assertNotNull(_s1.getExitAction());

		ExecutionState _s3 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r.s3", _s3.getName());
		assertNotNull(_s3.getExitAction());

		ExecutionState _s4 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r.s3.r.s4", _s4.getName());
		assertNotNull(_s4.getExitAction());
		
		Reaction _t = _s4.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(3, _effect.getSteps().size());
		
		Call _s4_exitActionCall = (Call) _effect.getSteps().get(0);
		assertSame( _s4.getExitAction(), _s4_exitActionCall.getStep());	
		
	}


	
	

}
