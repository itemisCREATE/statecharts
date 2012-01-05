package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil.*;

import org.junit.Test;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

 
public class ModelSequencerOrthogonalityTest extends ModelSequencerTest {


	/**
	 * The entry sequence of an and state must perform a entry for all sub regions. 
	 */
	@Test public void testAndStateEntry() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3);
						_createTransition(r3_entry, s3);
					}
				}		
				_createTransition(r_entry, s1);
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		
		ExecutionState _s1 = flow.getStates().get(0);
		assertEquals("sc.r.s1", _s1.getName());

		Sequence s1EnterSeq = _s1.getEnterSequence();
		assertNotNull(s1EnterSeq);
		assertEquals(2, s1EnterSeq.getSteps().size());

		assertCall(s1EnterSeq, 0, flow.getStates().get(1)
				.getEnterSequence());
		assertCall(s1EnterSeq, 1, flow.getStates().get(2)
				.getEnterSequence());
		
	}
	
	
	/**
	 * The transition to a leaf state with orthogonal siblings must invoke the entry sequence of the orthogonal sibling regions. 
	 */
	@Test public void testSiblingRegionEntryOnTargetState() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1); {
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null, r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}		
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				_createTransition(s5, findState(sc, "s3"));
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(3);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(4);
		assertEquals("sc.r.s5", _s5.getName());

		
		Reaction _t = _s5.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong sequence: " + stepList(_effect), 4, _effect.getSteps().size());
		
		assertCall(_effect, 0, _s5.getExitSequence());
		assertCall(_effect, 1, _s2.getEnterSequence());
		assertCall(_effect, 2, _s3.getEnterSequence());
		assertCall(_effect, 3, _s4.getEnterSequence());
	}
	
	
	/**
	 * For all and-states that a on the entry path of a transition the enter sequences for all orthogonal parts must be called.
	 */
	@Test public void testSiblingRegionEntryOnComposite() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3); {
							Region r3a = _createRegion("r3a", s3); {
								Entry r3a_entry = _createEntry(EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3); {
								Entry r3b_entry = _createEntry(EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3); {
								Entry r3c_entry = _createEntry(EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);					
					}

					Region r4 = _createRegion("r4", s1); {
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null, r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}		
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				
				_createTransition(s5, findState(sc, "s3b"));
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3c = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s4 = flow.getStates().get(6);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(7);
		assertEquals("sc.r.s5", _s5.getName());

		
		Reaction _t = _s5.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong sequence: " + stepList(_effect), 7, _effect.getSteps().size());
		
		assertCall(_effect, 0, _s5.getExitSequence());
		assertCall(_effect, 1, _s2.getEnterSequence());
		assertCall(_effect, 2, _s3.getEntryAction());
		assertCall(_effect, 3, _s3a.getEnterSequence());
		assertCall(_effect, 4, _s3b.getEnterSequence());
		assertCall(_effect, 5, _s3c.getEnterSequence());
		assertCall(_effect, 6, _s4.getEnterSequence());
	}
	
	

	/**
	 * Local transition within a region with orthogonal siblings does not have to invoke sibling region entries or exists.
	 */
	@Test public void testSiblingStateTransition() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3); {
							Region r3a = _createRegion("r3a", s3); {
								Entry r3a_entry = _createEntry(EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3); {
								Entry r3b_entry = _createEntry(EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								State s3b2 = _createState("s3b2", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3); {
								Entry r3c_entry = _createEntry(EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);					
					}

					Region r4 = _createRegion("r4", s1); {
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null, r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}		
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				
				_createTransition(findState(sc, "s3b"), findState(sc, "s3b2"));
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3b2 = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b2", _s3b2.getName());
		ExecutionState _s3c = flow.getStates().get(6);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s4 = flow.getStates().get(7);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(8);
		assertEquals("sc.r.s5", _s5.getName());

		
		Reaction _t = _s3b.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(2, _effect.getSteps().size());
		
		assertCall(_effect, 0, _s3b.getExitSequence());
		assertCall(_effect, 1, _s3b2.getEnterSequence());
	}
	
	
	/**
	 * A transition from a state with orthogonal siblings that dives into a non orthogonal sibling state must exclude the source state sibling entry behavior.
	 */
	@Test public void testSourceSiblingEnterExclusion() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3); {
							Region r3a = _createRegion("r3a", s3); {
								Entry r3a_entry = _createEntry(EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3); {
								Entry r3b_entry = _createEntry(EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								State s3b2 = _createState("s3b2", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3); {
								Entry r3c_entry = _createEntry(EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						State s3z = _createState("s3z", r3);
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);					
					}

					Region r4 = _createRegion("r4", s1); {
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null, r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}		
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				
				_createTransition(findState(sc, "s3z"), findState(sc, "s3b2"));
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3b2 = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b2", _s3b2.getName());
		ExecutionState _s3c = flow.getStates().get(6);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s3z = flow.getStates().get(7);
		assertEquals("sc.r.s1.r3.s3z", _s3z.getName());
		ExecutionState _s4 = flow.getStates().get(8);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(9);
		assertEquals("sc.r.s5", _s5.getName());

		
		Reaction _t = _s3z.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong sequence: " + stepList(_effect),  5, _effect.getSteps().size());
		
		assertCall(_effect, 0, _s3z.getExitSequence());
		assertCall(_effect, 1, _s3.getEntryAction());
		assertCall(_effect, 2, _s3a.getEnterSequence());
		assertCall(_effect, 3, _s3b2.getEnterSequence());
		assertCall(_effect, 4, _s3c.getEnterSequence());
	}
	

	/* -------------------------------------------------------------------------------------------
	 * Exit behavior tests
	 * -------------------------------------------------------------------------------------------
	 */

	/**
	 * The transition from a leaf state with orthogonal siblings must invoke the exit sequence of the orthogonal sibling regions. 
	 */
	@Test public void testSiblingRegionExitFromSourceState() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
						State s2b = _createState("s2b", r2);

					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3);
						_createTransition(r3_entry, s3);
					}

					Region r4 = _createRegion("r4", s1); {
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null, r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
						State s4b = _createState("s4b", r4);

					}
				}		
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				_createTransition(findState(sc, "s3"), s5);
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s2b = flow.getStates().get(2);
		assertEquals("sc.r.s1.r2.s2b", _s2b.getName());
		ExecutionState _s3 = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s4 = flow.getStates().get(4);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s4b = flow.getStates().get(5);
		assertEquals("sc.r.s1.r4.s4b", _s4b.getName());
		ExecutionState _s5 = flow.getStates().get(6);
		assertEquals("sc.r.s5", _s5.getName());

		
		Reaction _t = _s3.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(4, _effect.getSteps().size());
		
		Step _switch =  _effect.getSteps().get(0);
		assertStateSwitch(_switch, _s2, _s2b);
		assertCall( assertedSequence(assertedStateCase(_switch, _s2).getStep()), 0, _s2.getExitSequence());
		assertCall( assertedSequence(assertedStateCase(_switch, _s2b).getStep()), 0, _s2b.getExitSequence());

		assertCall(_effect, 1, _s3.getExitSequence());

		_switch =  _effect.getSteps().get(2);
		assertStateSwitch(_switch, _s4, _s4b);
		assertCall( assertedSequence(assertedStateCase(_switch, _s4).getStep()), 0, _s4.getExitSequence());
		assertCall( assertedSequence(assertedStateCase(_switch, _s4b).getStep()), 0, _s4b.getExitSequence());
	
		assertCall(_effect, 3, _s5.getEnterSequence());
	}

	
	
	/**
	 * For a transition all composite state with orthogonal siblings on the exit path must invoke the exit sequence of the orthogonal sibling regions. 
	 */
	@Test public void testSiblingRegionExitOnComposite() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3); {
							Region r3a = _createRegion("r3a", s3); {
								Entry r3a_entry = _createEntry(EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3); {
								Entry r3b_entry = _createEntry(EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3); {
								Entry r3c_entry = _createEntry(EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);					
					}

					Region r4 = _createRegion("r4", s1); {
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null, r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}		
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				
				_createTransition(findState(sc, "s3b"), s5);
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3c = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s4 = flow.getStates().get(6);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(7);
		assertEquals("sc.r.s5", _s5.getName());

		
		Reaction _t = _s3b.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals(6, _effect.getSteps().size());
		
		Step _switch =  _effect.getSteps().get(0);
		assertStateSwitch(_switch, _s2);
		assertCall( assertedSequence(assertedStateCase(_switch, _s2).getStep()), 0, _s2.getExitSequence());

		_switch =  _effect.getSteps().get(1);
		assertStateSwitch(_switch, _s3a);
		assertCall( assertedSequence(assertedStateCase(_switch, _s3a).getStep()), 0, _s3a.getExitSequence());

		assertCall(_effect, 2, _s3b.getExitSequence());

		_switch =  _effect.getSteps().get(3);
		assertStateSwitch(_switch, _s3c);
		assertCall( assertedSequence(assertedStateCase(_switch, _s3c).getStep()), 0, _s3c.getExitSequence());

		_switch =  _effect.getSteps().get(4);
		assertStateSwitch(_switch, _s4);
		assertCall( assertedSequence(assertedStateCase(_switch, _s4).getStep()), 0, _s4.getExitSequence());
	
		assertCall(_effect, 5, _s5.getEnterSequence());
	}
	

	/**
	 * A transition to a state with orthogonal siblings that comes out of a non orthogonal sibling state must exclude the source state sibling exit or enter behavior.
	 */
	@Test public void testSourceSiblingExitExclusion() {
		
		Statechart sc = _createStatechart("sc"); {  
			
			InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
			VariableDefinition v1 = _createVariableDefinition("v1", TYPE_INTEGER, s_scope);

			Region r = _createRegion("r", sc); {
				Entry r_entry = _createEntry(EntryKind.INITIAL, null, r);
				State s1 = _createState("s1", r); {

					Region r2 = _createRegion("r2", s1); {
						Entry r2_entry = _createEntry(EntryKind.INITIAL, null, r2);
						State s2 = _createState("s2", r2);
						_createTransition(r2_entry, s2);
					}
							
					Region r3 = _createRegion("r3", s1); {
						Entry r3_entry = _createEntry(EntryKind.INITIAL, null, r3);
						State s3 = _createState("s3", r3); {
							Region r3a = _createRegion("r3a", s3); {
								Entry r3a_entry = _createEntry(EntryKind.INITIAL, null, r3a);
								State s3a = _createState("s3a", r3a);
								_createTransition(r3a_entry, s3a);
							}
							Region r3b = _createRegion("r3b", s3); {
								Entry r3b_entry = _createEntry(EntryKind.INITIAL, null, r3b);
								State s3b = _createState("s3b", r3b);
								State s3b2 = _createState("s3b2", r3b);
								_createTransition(r3b_entry, s3b);
							}
							Region r3c = _createRegion("r3c", s3); {
								Entry r3c_entry = _createEntry(EntryKind.INITIAL, null, r3c);
								State s3c = _createState("s3c", r3c);
								_createTransition(r3c_entry, s3c);
							}
						}
						State s3z = _createState("s3z", r3);
						_createEntryAssignment(v1, s3, 42);
						_createTransition(r3_entry, s3);					
					}

					Region r4 = _createRegion("r4", s1); {
						Entry r4_entry = _createEntry(EntryKind.INITIAL, null, r4);
						State s4 = _createState("s4", r4);
						_createTransition(r4_entry, s4);
					}
				}		
				_createTransition(r_entry, s1);
				State s5 = _createState("s5", r);
				
				_createTransition(findState(sc, "s3b2"), findState(sc, "s3z"));
			}
		}
			
		ExecutionFlow flow = sequencer.transform(sc);
		
		ExecutionState _s2 = flow.getStates().get(1);
		assertEquals("sc.r.s1.r2.s2", _s2.getName());
		ExecutionState _s3 = flow.getStates().get(2);
		assertEquals("sc.r.s1.r3.s3", _s3.getName());
		ExecutionState _s3a = flow.getStates().get(3);
		assertEquals("sc.r.s1.r3.s3.r3a.s3a", _s3a.getName());
		ExecutionState _s3b = flow.getStates().get(4);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b", _s3b.getName());
		ExecutionState _s3b2 = flow.getStates().get(5);
		assertEquals("sc.r.s1.r3.s3.r3b.s3b2", _s3b2.getName());
		ExecutionState _s3c = flow.getStates().get(6);
		assertEquals("sc.r.s1.r3.s3.r3c.s3c", _s3c.getName());
		ExecutionState _s3z = flow.getStates().get(7);
		assertEquals("sc.r.s1.r3.s3z", _s3z.getName());
		ExecutionState _s4 = flow.getStates().get(8);
		assertEquals("sc.r.s1.r4.s4", _s4.getName());
		ExecutionState _s5 = flow.getStates().get(9);
		assertEquals("sc.r.s5", _s5.getName());

		
		Reaction _t = _s3b2.getReactions().get(0);
		assertTrue(_t.isTransition());
		
		Sequence _effect = (Sequence) _t.getEffect();
		assertEquals("wrong steps: " + stepList(_effect), 4, _effect.getSteps().size());
		
		Step _switch =  _effect.getSteps().get(0);
		assertStateSwitch(_switch, _s3a);
		assertCall( assertedSequence(assertedStateCase(_switch, _s3a).getStep()), 0, _s3a.getExitSequence());

		assertCall(_effect, 1, _s3b2.getExitSequence());

		_switch =  _effect.getSteps().get(2);
		assertStateSwitch(_switch, _s3c);
		assertCall( assertedSequence(assertedStateCase(_switch, _s3c).getStep()), 0, _s3c.getExitSequence());
	
		assertCall(_effect, 3, _s3z.getEnterSequence());

	}
	
	protected String stepList(Sequence seq) {
		String r = "";
		
		for ( Step s : seq.getSteps() ) {
			if (s instanceof Call) r += "call to : " + ((Call)s).getStep().getComment(); 
			else if (s instanceof StateSwitch) r += "switch on " + ((StateSwitch)s).getStateConfigurationIdx(); 
			else  r += s; 
			
			r += "; ";
		}
		
		return r;
	}

}
