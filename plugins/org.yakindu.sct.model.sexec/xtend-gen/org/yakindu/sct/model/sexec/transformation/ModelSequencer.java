package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.SequenceBuilder;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StateVectorBuilder;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.DefaultEvent;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class ModelSequencer {
  
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private StatechartExtensions sct;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private StructureMapping structureMapping;
  
  @Inject
  private BehaviorMapping behaviorMapping;
  
  @Inject
  private SequenceBuilder seqBuilder;
  
  @Inject
  private StateVectorBuilder svBuilder;
  
  @Inject
  private TraceExtensions trace;
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public ExecutionFlow transform(final Statechart sc) {
    {
      ExecutionFlow _create = this.mapping.create(sc);
      final ExecutionFlow ef = _create;
      this.structureMapping.mapScopes(sc, ef);
      this.structureMapping.mapRegularStates(sc, ef);
      this.structureMapping.mapRegions(sc, ef);
      this.structureMapping.mapPseudoStates(sc, ef);
      this.structureMapping.mapTimeEvents(sc, ef);
      this.svBuilder.defineStateVector(ef, sc);
      this.behaviorMapping.mapEntryActions(sc, ef);
      this.behaviorMapping.mapExitActions(sc, ef);
      this.seqBuilder.defineStateEnterSequences(ef, sc);
      this.seqBuilder.defineStateExitSequences(ef, sc);
      this.seqBuilder.defineStatechartEnterSequence(ef, sc);
      this.mapTransitions(sc, ef);
      this.mapLocalReactions(sc, ef);
      this.mapChoiceTransitions(sc, ef);
      this.defineRegularStateReactions(ef, sc);
      this.definePseudoStateReactions(ef, sc);
      this.retargetDeclRefs(ef);
      return ef;
    }
  }
  
  public ExecutionFlow mapChoiceTransitions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<Choice> _allChoices = this.sct.allChoices(statechart);
      final Function1<Choice,ExecutionChoice> _function = new Function1<Choice,ExecutionChoice>() {
          public ExecutionChoice apply(final Choice choice) {
            ExecutionChoice _mapChoiceTransition = ModelSequencer.this.mapChoiceTransition(choice);
            return _mapChoiceTransition;
          }
        };
      IterableExtensions.<Choice>forEach(_allChoices, _function);
      return r;
    }
  }
  
  public ExecutionChoice mapChoiceTransition(final Choice choice) {
    {
      ExecutionChoice _create = this.mapping.create(choice);
      final ExecutionChoice _choice = _create;
      EList<Reaction> _reactions = _choice.getReactions();
      EList<Transition> _outgoingTransitions = choice.getOutgoingTransitions();
      final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
          public Reaction apply(final Transition t) {
            Reaction _mapTransition = ModelSequencer.this.mapTransition(t);
            return _mapTransition;
          }
        };
      List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
      _reactions.addAll(_map);
      return _choice;
    }
  }
  
  public ExecutionFlow mapTransitions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            return (e instanceof org.yakindu.sct.model.sgraph.State);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(content, _function);
      final Iterable<EObject> allStates = _filter;
      final Function1<EObject,ExecutionState> _function_1 = new Function1<EObject,ExecutionState>() {
          public ExecutionState apply(final EObject s) {
            ExecutionState _mapStateTransition = ModelSequencer.this.mapStateTransition(((State) s));
            return _mapStateTransition;
          }
        };
      IterableExtensions.<EObject>forEach(allStates, _function_1);
      return r;
    }
  }
  
  public ExecutionState mapStateTransition(final State state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState _state = _create;
      EList<Reaction> _reactions = _state.getReactions();
      EList<Transition> _outgoingTransitions = state.getOutgoingTransitions();
      final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
          public Reaction apply(final Transition t) {
            Reaction _mapTransition = ModelSequencer.this.mapTransition(t);
            return _mapTransition;
          }
        };
      List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
      _reactions.addAll(_map);
      return _state;
    }
  }
  
  public Reaction mapTransition(final Transition t) {
    {
      Reaction _create = this.mapping.create(t);
      final Reaction r = _create;
      Trigger _trigger = t.getTrigger();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
      if (_operator_notEquals) {
        Trigger _trigger_1 = t.getTrigger();
        Check _mapToCheck = this.mapToCheck(_trigger_1);
        r.setCheck(_mapToCheck);
      }
      Sequence _mapToEffect = this.mapToEffect(t, r);
      r.setEffect(_mapToEffect);
      return r;
    }
  }
  
  public ExecutionFlow mapLocalReactions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            return (e instanceof org.yakindu.sct.model.sgraph.State);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(content, _function);
      final Iterable<EObject> allStates = _filter;
      final Function1<EObject,ExecutionState> _function_1 = new Function1<EObject,ExecutionState>() {
          public ExecutionState apply(final EObject s) {
            ExecutionState _mapStateLocalReactions = ModelSequencer.this.mapStateLocalReactions(((State) s));
            return _mapStateLocalReactions;
          }
        };
      IterableExtensions.<EObject>forEach(allStates, _function_1);
      return r;
    }
  }
  
  public ExecutionState mapStateLocalReactions(final State state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState _state = _create;
      EList<Reaction> _reactions = _state.getReactions();
      EList<org.yakindu.sct.model.sgraph.Reaction> _localReactions = state.getLocalReactions();
      Iterable<LocalReaction> _filter = IterableExtensions.<LocalReaction>filter(_localReactions, org.yakindu.sct.model.stext.stext.LocalReaction.class);
      final Function1<LocalReaction,Boolean> _function = new Function1<LocalReaction,Boolean>() {
          public Boolean apply(final LocalReaction lr) {
            boolean _operator_or = false;
            Trigger _trigger = lr.getTrigger();
            EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
            boolean _isEmpty = _triggers.isEmpty();
            if (_isEmpty) {
              _operator_or = true;
            } else {
              Trigger _trigger_1 = lr.getTrigger();
              EList<EventSpec> _triggers_1 = ((ReactionTrigger) _trigger_1).getTriggers();
              final Function1<EventSpec,Boolean> _function_1 = new Function1<EventSpec,Boolean>() {
                  public Boolean apply(final EventSpec t) {
                    boolean _operator_or_1 = false;
                    boolean _operator_or_2 = false;
                    boolean _operator_or_3 = false;
                    if ((t instanceof org.yakindu.sct.model.stext.stext.RegularEventSpec)) {
                      _operator_or_3 = true;
                    } else {
                      _operator_or_3 = BooleanExtensions.operator_or((t instanceof org.yakindu.sct.model.stext.stext.RegularEventSpec), (t instanceof org.yakindu.sct.model.stext.stext.TimeEventSpec));
                    }
                    if (_operator_or_3) {
                      _operator_or_2 = true;
                    } else {
                      _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, (t instanceof org.yakindu.sct.model.stext.stext.OnCycleEvent));
                    }
                    if (_operator_or_2) {
                      _operator_or_1 = true;
                    } else {
                      _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, (t instanceof org.yakindu.sct.model.stext.stext.AlwaysEvent));
                    }
                    return ((Boolean)_operator_or_1);
                  }
                };
              Iterable<EventSpec> _filter_1 = IterableExtensions.<EventSpec>filter(_triggers_1, _function_1);
              List<EventSpec> _list = IterableExtensions.<EventSpec>toList(_filter_1);
              boolean _isEmpty_1 = _list.isEmpty();
              boolean _operator_not = BooleanExtensions.operator_not(_isEmpty_1);
              _operator_or = BooleanExtensions.operator_or(_isEmpty, _operator_not);
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<LocalReaction> _filter_2 = IterableExtensions.<LocalReaction>filter(_filter, _function);
      final Function1<LocalReaction,Reaction> _function_2 = new Function1<LocalReaction,Reaction>() {
          public Reaction apply(final LocalReaction t_1) {
            Reaction _mapReaction = ModelSequencer.this.mapReaction(t_1);
            return _mapReaction;
          }
        };
      Iterable<Reaction> _map = IterableExtensions.<LocalReaction, Reaction>map(_filter_2, _function_2);
      CollectionExtensions.<Reaction>addAll(_reactions, _map);
      return _state;
    }
  }
  
  public Reaction mapReaction(final LocalReaction lr) {
    {
      Reaction _create = this.mapping.create(lr);
      final Reaction r = _create;
      Trigger _trigger = lr.getTrigger();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
      if (_operator_notEquals) {
        Trigger _trigger_1 = lr.getTrigger();
        Check _mapToCheck = this.mapToCheck(_trigger_1);
        r.setCheck(_mapToCheck);
      }
      Sequence _mapToEffect = this.mapToEffect(lr);
      r.setEffect(_mapToEffect);
      return r;
    }
  }
  
  protected StateVector _stateVector(final Vertex v) {
    return null;
  }
  
  protected StateVector _stateVector(final RegularState s) {
    ExecutionState _create = this.mapping.create(s);
    StateVector _stateVector = _create.getStateVector();
    return _stateVector;
  }
  
  protected StateVector _stateVector(final Choice choice) {
    Region _parentRegion = choice.getParentRegion();
    ExecutionRegion _create = this.mapping.create(_parentRegion);
    StateVector _stateVector = _create.getStateVector();
    return _stateVector;
  }
  
  public Sequence mapToEffect(final Transition t, final Reaction r) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence sequence = _createSequence;
      List<State> _exitStates = this.exitStates(t);
      State _last = IterableExtensions.<State>last(_exitStates);
      final State topExitState = _last;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(topExitState, null);
      if (_operator_notEquals) {
        {
          ArrayList<RegularState> _arrayList = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates = this.sgraph.collectLeafStates(topExitState, _arrayList);
          final List<RegularState> leafStates = _collectLeafStates;
          StateVector _stateVector = this.stateVector(topExitState);
          final StateVector topVector = _stateVector;
          Vertex _source = t.getSource();
          StateVector _stateVector_1 = this.stateVector(_source);
          final StateVector sourceVector = _stateVector_1;
          int _offset = topVector.getOffset();
          int _offset_1 = sourceVector.getOffset();
          Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)_offset), ((Integer)_offset_1));
          int _offset_2 = sourceVector.getOffset();
          int _offset_3 = topVector.getOffset();
          int _operator_minus = IntegerExtensions.operator_minus(((Integer)_offset_2), ((Integer)_offset_3));
          Iterable<Integer> _take = IterableExtensions.<Integer>take(_operator_upTo, _operator_minus);
          final Iterable<Integer> prepositions = _take;
          for (Integer i : prepositions) {
            {
              StateSwitch _defineExitSwitch = this.seqBuilder.defineExitSwitch(topExitState, leafStates, i);
              StateSwitch sSwitch = _defineExitSwitch;
              EList<Step> _steps = sequence.getSteps();
              _steps.add(sSwitch);
            }
          }
        }
      }
      boolean _operator_and = false;
      Vertex _source_1 = t.getSource();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_source_1, null);
      if (!_operator_notEquals_1) {
        _operator_and = false;
      } else {
        Vertex _source_2 = t.getSource();
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals_1, (_source_2 instanceof org.yakindu.sct.model.sgraph.RegularState));
      }
      if (_operator_and) {
        EList<Step> _steps_1 = sequence.getSteps();
        Vertex _source_3 = t.getSource();
        ExecutionState _create = this.mapping.create(((RegularState) _source_3));
        Sequence _exitSequence = _create.getExitSequence();
        Call _newCall = this.mapping.newCall(_exitSequence);
        _steps_1.add(_newCall);
      }
      List<State> _exitStates_1 = this.exitStates(t);
      final Function2<Sequence,State,Sequence> _function = new Function2<Sequence,State,Sequence>() {
          public Sequence apply(final Sequence seq , final State state) {
            Sequence _xblockexpression = null;
            {
              boolean _operator_and_1 = false;
              Vertex _source_4 = t.getSource();
              boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(state, _source_4);
              if (!_operator_notEquals_2) {
                _operator_and_1 = false;
              } else {
                boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(state, topExitState);
                _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals_2, _operator_notEquals_3);
              }
              if (_operator_and_1) {
                Vertex _source_5 = t.getSource();
                StateVector _stateVector_2 = ModelSequencer.this.stateVector(_source_5);
                int _last_1 = ModelSequencer.this.sexec.last(_stateVector_2);
                ExecutionState _create_1 = ModelSequencer.this.mapping.create(state);
                StateVector _stateVector_3 = _create_1.getStateVector();
                int _last_2 = ModelSequencer.this.sexec.last(_stateVector_3);
                boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_last_1), ((Integer)_last_2));
                if (_operator_equals) {
                  {
                    ExecutionState _create_2 = ModelSequencer.this.mapping.create(state);
                    Step _exitAction = _create_2.getExitAction();
                    boolean _operator_notEquals_4 = ObjectExtensions.operator_notEquals(_exitAction, null);
                    if (_operator_notEquals_4) {
                      EList<Step> _steps_2 = seq.getSteps();
                      ExecutionState _create_3 = ModelSequencer.this.mapping.create(state);
                      Step _exitAction_1 = _create_3.getExitAction();
                      Call _newCall_1 = ModelSequencer.this.mapping.newCall(_exitAction_1);
                      _steps_2.add(_newCall_1);
                    }
                    if (ModelSequencer.this._addTraceSteps) {
                      EList<Step> _steps_3 = seq.getSteps();
                      ExecutionState _create_4 = ModelSequencer.this.mapping.create(state);
                      TraceStateExited _newTraceStateExited = ModelSequencer.this.trace.newTraceStateExited(_create_4);
                      _steps_3.add(_newTraceStateExited);
                    }
                  }
                }
              }
              _xblockexpression = (seq);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<State, Sequence>fold(_exitStates_1, sequence, _function);
      boolean _operator_notEquals_5 = ObjectExtensions.operator_notEquals(topExitState, null);
      if (_operator_notEquals_5) {
        {
          ArrayList<RegularState> _arrayList_1 = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates_1 = this.sgraph.collectLeafStates(topExitState, _arrayList_1);
          final List<RegularState> leafStates_1 = _collectLeafStates_1;
          StateVector _stateVector_4 = this.stateVector(topExitState);
          final StateVector topVector_1 = _stateVector_4;
          Vertex _source_6 = t.getSource();
          StateVector _stateVector_5 = this.stateVector(_source_6);
          final StateVector sourceVector_1 = _stateVector_5;
          int _last_3 = this.sexec.last(sourceVector_1);
          int _last_4 = this.sexec.last(topVector_1);
          Iterable<Integer> _operator_upTo_1 = IntegerExtensions.operator_upTo(((Integer)_last_3), ((Integer)_last_4));
          Iterable<Integer> _drop = IterableExtensions.<Integer>drop(_operator_upTo_1, 1);
          final Iterable<Integer> postpositions = _drop;
          for (Integer i_1 : postpositions) {
            {
              StateSwitch _defineExitSwitch_1 = this.seqBuilder.defineExitSwitch(topExitState, leafStates_1, i_1);
              StateSwitch sSwitch_1 = _defineExitSwitch_1;
              EList<Step> _steps_4 = sequence.getSteps();
              _steps_4.add(sSwitch_1);
            }
          }
        }
      }
      Vertex _source_7 = t.getSource();
      boolean _operator_notEquals_6 = ObjectExtensions.operator_notEquals(topExitState, _source_7);
      if (_operator_notEquals_6) {
        {
          ExecutionState _create_5 = this.mapping.create(topExitState);
          Step _exitAction_2 = _create_5.getExitAction();
          boolean _operator_notEquals_7 = ObjectExtensions.operator_notEquals(_exitAction_2, null);
          if (_operator_notEquals_7) {
            EList<Step> _steps_5 = sequence.getSteps();
            ExecutionState _create_6 = this.mapping.create(topExitState);
            Step _exitAction_3 = _create_6.getExitAction();
            Call _newCall_2 = this.mapping.newCall(_exitAction_3);
            _steps_5.add(_newCall_2);
          }
          if (this._addTraceSteps) {
            EList<Step> _steps_6 = sequence.getSteps();
            ExecutionState _create_7 = this.mapping.create(topExitState);
            TraceStateExited _newTraceStateExited_1 = this.trace.newTraceStateExited(_create_7);
            CollectionExtensions.<TraceStateExited>operator_add(_steps_6, _newTraceStateExited_1);
          }
        }
      }
      Effect _effect = t.getEffect();
      boolean _operator_notEquals_8 = ObjectExtensions.operator_notEquals(_effect, null);
      if (_operator_notEquals_8) {
        EList<Step> _steps_7 = sequence.getSteps();
        Effect _effect_1 = t.getEffect();
        Sequence _mapEffect = this.behaviorMapping.mapEffect(_effect_1);
        _steps_7.add(_mapEffect);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_8 = sequence.getSteps();
        ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(r);
        CollectionExtensions.<ReactionFired>operator_add(_steps_8, _newTraceReactionFired);
      }
      List<ExecutionScope> _entryScopes = this.entryScopes(t);
      Iterable<ExecutionScope> _drop_1 = IterableExtensions.<ExecutionScope>drop(_entryScopes, 1);
      List<ExecutionScope> _list = IterableExtensions.<ExecutionScope>toList(_drop_1);
      List<ExecutionScope> _reverse = ListExtensions.<ExecutionScope>reverse(_list);
      final Function2<Sequence,ExecutionScope,Sequence> _function_1 = new Function2<Sequence,ExecutionScope,Sequence>() {
          public Sequence apply(final Sequence seq_1 , final ExecutionScope scope) {
            Sequence _xblockexpression_1 = null;
            {
              if ((scope instanceof org.yakindu.sct.model.sexec.ExecutionRegion)) {
                {
                  ExecutionScope _superScope = scope.getSuperScope();
                  EList<ExecutionScope> _subScopes = _superScope.getSubScopes();
                  final EList<ExecutionScope> siblingRegions = _subScopes;
                  int _indexOf = siblingRegions.indexOf(scope);
                  Iterable<ExecutionScope> _take_1 = IterableExtensions.<ExecutionScope>take(siblingRegions, _indexOf);
                  for (ExecutionScope region : _take_1) {
                    ModelSequencer.this.seqBuilder.addEnterRegion(seq_1, region);
                  }
                }
              }
              if ((scope instanceof org.yakindu.sct.model.sexec.ExecutionState)) {
                {
                  Step _entryAction = ((ExecutionState) scope).getEntryAction();
                  boolean _operator_notEquals_9 = ObjectExtensions.operator_notEquals(_entryAction, null);
                  if (_operator_notEquals_9) {
                    EList<Step> _steps_9 = seq_1.getSteps();
                    Step _entryAction_1 = ((ExecutionState) scope).getEntryAction();
                    Call _newCall_3 = ModelSequencer.this.mapping.newCall(_entryAction_1);
                    _steps_9.add(_newCall_3);
                  }
                  if (ModelSequencer.this._addTraceSteps) {
                    EList<Step> _steps_10 = seq_1.getSteps();
                    TraceStateEntered _newTraceStateEntered = ModelSequencer.this.trace.newTraceStateEntered(((ExecutionState) scope));
                    _steps_10.add(_newTraceStateEntered);
                  }
                }
              }
              _xblockexpression_1 = (seq_1);
            }
            return _xblockexpression_1;
          }
        };
      IterableExtensions.<ExecutionScope, Sequence>fold(_reverse, sequence, _function_1);
      Vertex _target = t.getTarget();
      boolean _operator_notEquals_10 = ObjectExtensions.operator_notEquals(_target, null);
      if (_operator_notEquals_10) {
        {
          Vertex _target_1 = t.getTarget();
          Region _parentRegion = _target_1.getParentRegion();
          CompositeElement _composite = _parentRegion.getComposite();
          EList<Region> _regions = _composite.getRegions();
          final EList<Region> siblingRegions_1 = _regions;
          Vertex _target_2 = t.getTarget();
          if ((_target_2 instanceof org.yakindu.sct.model.sgraph.RegularState)) {
            EList<Step> _steps_11 = sequence.getSteps();
            Vertex _target_3 = t.getTarget();
            ExecutionState _create_8 = this.mapping.create(((RegularState) _target_3));
            Sequence _enterSequence = _create_8.getEnterSequence();
            Call _newCall_4 = this.mapping.newCall(_enterSequence);
            _steps_11.add(_newCall_4);
          } else {
            Vertex _target_4 = t.getTarget();
            if ((_target_4 instanceof org.yakindu.sct.model.sgraph.Choice)) {
              EList<Step> _steps_12 = sequence.getSteps();
              Vertex _target_5 = t.getTarget();
              ExecutionChoice _create_9 = this.mapping.create(((Choice) _target_5));
              Sequence _reactSequence = _create_9.getReactSequence();
              Call _newCall_5 = this.mapping.newCall(_reactSequence);
              _steps_12.add(_newCall_5);
            }
          }
        }
      }
      List<ExecutionScope> _entryScopes_1 = this.entryScopes(t);
      Iterable<ExecutionScope> _drop_2 = IterableExtensions.<ExecutionScope>drop(_entryScopes_1, 1);
      final Function2<Sequence,ExecutionScope,Sequence> _function_2 = new Function2<Sequence,ExecutionScope,Sequence>() {
          public Sequence apply(final Sequence seq_2 , final ExecutionScope scope_1) {
            Sequence _xblockexpression_2 = null;
            {
              if ((scope_1 instanceof org.yakindu.sct.model.sexec.ExecutionRegion)) {
                {
                  ExecutionScope _superScope_1 = scope_1.getSuperScope();
                  EList<ExecutionScope> _subScopes_1 = _superScope_1.getSubScopes();
                  final EList<ExecutionScope> siblingRegions_2 = _subScopes_1;
                  int _indexOf_1 = siblingRegions_2.indexOf(scope_1);
                  int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf_1), ((Integer)1));
                  Iterable<ExecutionScope> _drop_3 = IterableExtensions.<ExecutionScope>drop(siblingRegions_2, _operator_plus);
                  for (ExecutionScope region_1 : _drop_3) {
                    ModelSequencer.this.seqBuilder.addEnterRegion(seq_2, region_1);
                  }
                }
              }
              _xblockexpression_2 = (seq_2);
            }
            return _xblockexpression_2;
          }
        };
      IterableExtensions.<ExecutionScope, Sequence>fold(_drop_2, sequence, _function_2);
      return sequence;
    }
  }
  
  public List<State> exitStates(final Transition t) {
    List<State> _xblockexpression = null;
    {
      Vertex _source = t.getSource();
      List<EObject> _containers = this.sgraph.containers(_source);
      final List<EObject> l = _containers;
      Vertex _target = t.getTarget();
      List<EObject> _containers_1 = this.sgraph.containers(_target);
      l.removeAll(_containers_1);
      Iterable<State> _filter = IterableExtensions.<State>filter(l, org.yakindu.sct.model.sgraph.State.class);
      List<State> _list = IterableExtensions.<State>toList(_filter);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public List<State> entryStates(final Transition t) {
    List<State> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      List<EObject> _containers = this.sgraph.containers(_target);
      final List<EObject> l = _containers;
      Vertex _source = t.getSource();
      List<EObject> _containers_1 = this.sgraph.containers(_source);
      l.removeAll(_containers_1);
      Iterable<State> _filter = IterableExtensions.<State>filter(l, org.yakindu.sct.model.sgraph.State.class);
      List<State> _list = IterableExtensions.<State>toList(_filter);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public List<ExecutionScope> exitScopes(final Transition t) {
    return null;
  }
  
  public List<ExecutionScope> entryScopes(final Transition t) {
    List<ExecutionScope> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      List<EObject> _containers = this.sgraph.containers(_target);
      final List<EObject> l = _containers;
      Vertex _source = t.getSource();
      List<EObject> _containers_1 = this.sgraph.containers(_source);
      l.removeAll(_containers_1);
      final Function1<EObject,ExecutionScope> _function = new Function1<EObject,ExecutionScope>() {
          public ExecutionScope apply(final EObject c) {
            ExecutionScope _xifexpression = null;
            if ((c instanceof org.yakindu.sct.model.sgraph.RegularState)) {
              ExecutionState _create = ModelSequencer.this.mapping.create(((RegularState) c));
              _xifexpression = ((ExecutionScope) _create);
            } else {
              ExecutionScope _xifexpression_1 = null;
              if ((c instanceof org.yakindu.sct.model.sgraph.Region)) {
                ExecutionRegion _create_1 = ModelSequencer.this.mapping.create(((Region) c));
                _xifexpression_1 = ((ExecutionScope) _create_1);
              } else {
                ExecutionScope _xifexpression_2 = null;
                if ((c instanceof org.yakindu.sct.model.sgraph.Statechart)) {
                  ExecutionFlow _create_2 = ModelSequencer.this.mapping.create(((Statechart) c));
                  _xifexpression_2 = ((ExecutionScope) _create_2);
                }
                _xifexpression_1 = _xifexpression_2;
              }
              _xifexpression = _xifexpression_1;
            }
            return _xifexpression;
          }
        };
      List<ExecutionScope> _map = ListExtensions.<EObject, ExecutionScope>map(l, _function);
      List<ExecutionScope> _list = IterableExtensions.<ExecutionScope>toList(_map);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public Sequence mapToEffect(final LocalReaction lr) {
    Sequence _xifexpression = null;
    Effect _effect = lr.getEffect();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
    if (_operator_notEquals) {
      Effect _effect_1 = lr.getEffect();
      Sequence _mapEffect = this.behaviorMapping.mapEffect(_effect_1);
      _xifexpression = _mapEffect;
    }
    return _xifexpression;
  }
  
  public ExecutionFlow defineRegularStateReactions(final ExecutionFlow flow, final Statechart sc) {
    {
      List<RegularState> _allRegularStates = this.sct.allRegularStates(sc);
      final List<RegularState> states = _allRegularStates;
      Iterable<State> _filter = IterableExtensions.<State>filter(states, org.yakindu.sct.model.sgraph.State.class);
      final Function1<State,Boolean> _function = new Function1<State,Boolean>() {
          public Boolean apply(final State s) {
            boolean _isSimple = s.isSimple();
            return ((Boolean)_isSimple);
          }
        };
      Iterable<State> _filter_1 = IterableExtensions.<State>filter(_filter, _function);
      final Function1<State,Sequence> _function_1 = new Function1<State,Sequence>() {
          public Sequence apply(final State s_1) {
            Sequence _defineCycle = ModelSequencer.this.defineCycle(s_1);
            return _defineCycle;
          }
        };
      IterableExtensions.<State>forEach(_filter_1, _function_1);
      Iterable<FinalState> _filter_2 = IterableExtensions.<FinalState>filter(states, org.yakindu.sct.model.sgraph.FinalState.class);
      final Function1<FinalState,Sequence> _function_2 = new Function1<FinalState,Sequence>() {
          public Sequence apply(final FinalState s_2) {
            Sequence _defineCycle_1 = ModelSequencer.this.defineCycle(s_2);
            return _defineCycle_1;
          }
        };
      IterableExtensions.<FinalState>forEach(_filter_2, _function_2);
      return flow;
    }
  }
  
  public void definePseudoStateReactions(final ExecutionFlow flow, final Statechart sc) {
    List<Choice> _allChoices = this.sct.allChoices(sc);
    final Function1<Choice,Sequence> _function = new Function1<Choice,Sequence>() {
        public Sequence apply(final Choice choice) {
          Sequence _defineReaction = ModelSequencer.this.defineReaction(choice);
          return _defineReaction;
        }
      };
    IterableExtensions.<Choice>forEach(_allChoices, _function);
  }
  
  public Sequence defineReaction(final Choice choice) {
    {
      ExecutionChoice _create = this.mapping.create(choice);
      final ExecutionChoice execChoice = _create;
      EList<Reaction> _reactions = execChoice.getReactions();
      final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r) {
            Check _check = r.getCheck();
            boolean _alwaysTrue = ModelSequencer.this.alwaysTrue(_check);
            return ((Boolean)_alwaysTrue);
          }
        };
      Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
      List<Reaction> _list = IterableExtensions.<Reaction>toList(_filter);
      Reaction _head = IterableExtensions.<Reaction>head(_list);
      final Reaction _default_ = _head;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_default_, null);
      if (_operator_notEquals) {
        EList<Reaction> _reactions_1 = execChoice.getReactions();
        EList<Reaction> _reactions_2 = execChoice.getReactions();
        int _size = _reactions_2.size();
        int _operator_minus = IntegerExtensions.operator_minus(((Integer)_size), ((Integer)1));
        _reactions_1.move(_operator_minus, _default_);
      }
      Sequence _createReactionSequence = this.createReactionSequence(execChoice, null);
      final Sequence stateReaction = _createReactionSequence;
      Sequence _reactSequence = execChoice.getReactSequence();
      EList<Step> _steps = _reactSequence.getSteps();
      EList<Step> _steps_1 = stateReaction.getSteps();
      _steps.addAll(_steps_1);
      Sequence _reactSequence_1 = execChoice.getReactSequence();
      _reactSequence_1.setName("react");
      Sequence _reactSequence_2 = execChoice.getReactSequence();
      String _name = choice.getName();
      String _operator_plus = StringExtensions.operator_plus("The reactions of state ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".");
      _reactSequence_2.setComment(_operator_plus_1);
      if (this._addTraceSteps) {
        Sequence _reactSequence_3 = execChoice.getReactSequence();
        EList<Step> _steps_2 = _reactSequence_3.getSteps();
        ExecutionChoice _create_1 = this.mapping.create(choice);
        TraceNodeExecuted _newTraceNodeExecuted = this.trace.newTraceNodeExecuted(_create_1);
        _steps_2.add(0, _newTraceNodeExecuted);
      }
      Sequence _reactSequence_4 = execChoice.getReactSequence();
      return _reactSequence_4;
    }
  }
  
  public boolean alwaysTrue(final Check check) {
    {
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(check, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Statement _condition = check.getCondition();
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, (_condition instanceof org.yakindu.sct.model.stext.stext.PrimitiveValueExpression));
      }
      if (_operator_and) {
        {
          Statement _condition_1 = check.getCondition();
          final PrimitiveValueExpression pve = ((PrimitiveValueExpression) _condition_1);
          boolean _operator_and_1 = false;
          Literal _value = pve.getValue();
          if (!(_value instanceof org.yakindu.sct.model.stext.stext.BoolLiteral)) {
            _operator_and_1 = false;
          } else {
            Literal _value_1 = pve.getValue();
            boolean _isValue = ((BoolLiteral) _value_1).isValue();
            _operator_and_1 = BooleanExtensions.operator_and((_value instanceof org.yakindu.sct.model.stext.stext.BoolLiteral), _isValue);
          }
          return _operator_and_1;
        }
      }
      return false;
    }
  }
  
  public Sequence defineCycle(final RegularState state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      Sequence _createReactionSequence = this.createReactionSequence(execState, null);
      final Sequence stateReaction = _createReactionSequence;
      List<RegularState> _parentStates = this.sgraph.parentStates(state);
      final List<RegularState> parents = _parentStates;
      final Function2<Sequence,RegularState,Sequence> _function = new Function2<Sequence,RegularState,Sequence>() {
          public Sequence apply(final Sequence r , final RegularState s) {
            ExecutionState _create_1 = ModelSequencer.this.mapping.create(s);
            Sequence _createReactionSequence_1 = ModelSequencer.this.createReactionSequence(_create_1, r);
            return _createReactionSequence_1;
          }
        };
      Sequence _fold = IterableExtensions.<RegularState, Sequence>fold(parents, null, _function);
      execState.setReactSequence(_fold);
      Sequence _reactSequence = execState.getReactSequence();
      _reactSequence.setName("react");
      Sequence _reactSequence_1 = execState.getReactSequence();
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("The reactions of state ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".");
      _reactSequence_1.setComment(_operator_plus_1);
      Sequence _reactSequence_2 = execState.getReactSequence();
      return _reactSequence_2;
    }
  }
  
  public Sequence createReactionSequence(final ExecutionNode state, final Step localStep) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence cycle = _createSequence;
      EList<Reaction> _reactions = state.getReactions();
      final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r) {
            boolean _isTransition = r.isTransition();
            boolean _operator_not = BooleanExtensions.operator_not(_isTransition);
            return ((Boolean)_operator_not);
          }
        };
      Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
      List<Reaction> _list = IterableExtensions.<Reaction>toList(_filter);
      final List<Reaction> localReactions = _list;
      SexecFactory _factory_1 = this.sexec.factory();
      Sequence _createSequence_1 = _factory_1.createSequence();
      Sequence localSteps = _createSequence_1;
      EList<Step> _steps = localSteps.getSteps();
      final Function1<Reaction,If> _function_1 = new Function1<Reaction,If>() {
          public If apply(final Reaction lr) {
            If _xblockexpression = null;
            {
              SexecFactory _factory_2 = ModelSequencer.this.sexec.factory();
              If _createIf = _factory_2.createIf();
              If ifStep = _createIf;
              Check _check = lr.getCheck();
              CheckRef _newRef = ModelSequencer.this.mapping.newRef(_check);
              ifStep.setCheck(_newRef);
              Step _effect = lr.getEffect();
              Call _newCall = ModelSequencer.this.mapping.newCall(_effect);
              ifStep.setThenStep(_newCall);
              _xblockexpression = (ifStep);
            }
            return _xblockexpression;
          }
        };
      List<If> _map = ListExtensions.<Reaction, If>map(localReactions, _function_1);
      _steps.addAll(_map);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(localStep, null);
      if (_operator_notEquals) {
        EList<Step> _steps_1 = localSteps.getSteps();
        CollectionExtensions.<Step>operator_add(_steps_1, localStep);
      }
      EList<Step> _steps_2 = localSteps.getSteps();
      boolean _isEmpty = _steps_2.isEmpty();
      if (_isEmpty) {
        localSteps = null;
      }
      EList<Reaction> _reactions_1 = state.getReactions();
      final Function1<Reaction,Boolean> _function_2 = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r_1) {
            boolean _isTransition_1 = r_1.isTransition();
            return ((Boolean)_isTransition_1);
          }
        };
      Iterable<Reaction> _filter_1 = IterableExtensions.<Reaction>filter(_reactions_1, _function_2);
      List<Reaction> _list_1 = IterableExtensions.<Reaction>toList(_filter_1);
      final List<Reaction> transitionReactions = _list_1;
      Iterable<Reaction> _reverseView = ListExtensions.<Reaction>reverseView(transitionReactions);
      final Function2<Step,Reaction,Step> _function_3 = new Function2<Step,Reaction,Step>() {
          public Step apply(final Step s , final Reaction reaction) {
            Step _xblockexpression_1 = null;
            {
              SexecFactory _factory_3 = ModelSequencer.this.sexec.factory();
              If _createIf_1 = _factory_3.createIf();
              If ifStep_1 = _createIf_1;
              Check _check_1 = reaction.getCheck();
              CheckRef _newRef_1 = ModelSequencer.this.mapping.newRef(_check_1);
              ifStep_1.setCheck(_newRef_1);
              Step _effect_1 = reaction.getEffect();
              Call _newCall_1 = ModelSequencer.this.mapping.newCall(_effect_1);
              ifStep_1.setThenStep(_newCall_1);
              ifStep_1.setElseStep(s);
              _xblockexpression_1 = (((Step) ifStep_1));
            }
            return _xblockexpression_1;
          }
        };
      Step _fold = IterableExtensions.<Reaction, Step>fold(_reverseView, ((Step) localSteps), _function_3);
      final Step transitionStep = _fold;
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(transitionStep, null);
      if (_operator_notEquals_1) {
        EList<Step> _steps_3 = cycle.getSteps();
        _steps_3.add(transitionStep);
      } else {
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(localSteps, null);
        if (_operator_notEquals_2) {
          EList<Step> _steps_4 = cycle.getSteps();
          _steps_4.add(localSteps);
        }
      }
      return cycle;
    }
  }
  
  protected Check _mapToCheck(final Trigger tr) {
    return null;
  }
  
  protected Check _mapToCheck(final ReactionTrigger tr) {
    {
      Check _createCheck = this.mapping.createCheck(tr);
      final Check check = _createCheck;
      Statement _buildCondition = this.buildCondition(tr);
      check.setCondition(_buildCondition);
      return check;
    }
  }
  
  protected Statement _buildCondition(final Trigger t) {
    return null;
  }
  
  protected Statement _buildCondition(final ReactionTrigger t) {
    Expression _xblockexpression = null;
    {
      Expression _xifexpression = null;
      EList<EventSpec> _triggers = t.getTriggers();
      boolean _isEmpty = _triggers.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        EList<EventSpec> _triggers_1 = t.getTriggers();
        Iterable<EventSpec> _reverseView = ListExtensions.<EventSpec>reverseView(_triggers_1);
        final Function2<Expression,EventSpec,Expression> _function = new Function2<Expression,EventSpec,Expression>() {
            public Expression apply(final Expression s , final EventSpec e) {
              Expression _xblockexpression_1 = null;
              {
                Expression _raised = ModelSequencer.this.raised(e);
                final Expression raised = _raised;
                Expression _xifexpression_1 = null;
                boolean _operator_equals = ObjectExtensions.operator_equals(raised, null);
                if (_operator_equals) {
                  _xifexpression_1 = s;
                } else {
                  Expression _xifexpression_2 = null;
                  boolean _operator_equals_1 = ObjectExtensions.operator_equals(s, null);
                  if (_operator_equals_1) {
                    _xifexpression_2 = raised;
                  } else {
                    Expression _or = ModelSequencer.this.or(raised, s);
                    _xifexpression_2 = _or;
                  }
                  _xifexpression_1 = _xifexpression_2;
                }
                _xblockexpression_1 = (_xifexpression_1);
              }
              return _xblockexpression_1;
            }
          };
        Expression _fold = IterableExtensions.<EventSpec, Expression>fold(_reverseView, ((Expression) null), _function);
        _xifexpression = _fold;
      } else {
        _xifexpression = null;
      }
      final Expression triggerCheck = _xifexpression;
      Expression _xifexpression_3 = null;
      Expression _guardExpression = t.getGuardExpression();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_guardExpression, null);
      if (_operator_notEquals) {
        Expression _guardExpression_1 = t.getGuardExpression();
        Expression _copy = EcoreUtil.<Expression>copy(_guardExpression_1);
        _xifexpression_3 = _copy;
      } else {
        _xifexpression_3 = null;
      }
      final Expression guard = _xifexpression_3;
      Expression _xifexpression_4 = null;
      boolean _operator_and = false;
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(triggerCheck, null);
      if (!_operator_notEquals_1) {
        _operator_and = false;
      } else {
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(guard, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals_1, _operator_notEquals_2);
      }
      if (_operator_and) {
        Expression _and = this.and(triggerCheck, guard);
        _xifexpression_4 = _and;
      } else {
        Expression _xifexpression_5 = null;
        boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(triggerCheck, null);
        if (_operator_notEquals_3) {
          _xifexpression_5 = triggerCheck;
        } else {
          _xifexpression_5 = guard;
        }
        _xifexpression_4 = _xifexpression_5;
      }
      _xblockexpression = (_xifexpression_4);
    }
    return _xblockexpression;
  }
  
  public Expression or(final Expression left, final Expression right) {
    LogicalOrExpression _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      LogicalOrExpression _createLogicalOrExpression = _factory.createLogicalOrExpression();
      final LogicalOrExpression or = _createLogicalOrExpression;
      or.setLeftOperand(left);
      or.setRightOperand(right);
      _xblockexpression = (or);
    }
    return _xblockexpression;
  }
  
  public Expression and(final Expression left, final Expression right) {
    LogicalAndExpression _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      LogicalAndExpression _createLogicalAndExpression = _factory.createLogicalAndExpression();
      final LogicalAndExpression or = _createLogicalAndExpression;
      or.setLeftOperand(left);
      or.setRightOperand(right);
      _xblockexpression = (or);
    }
    return _xblockexpression;
  }
  
  protected Expression _raised(final EventSpec e) {
    return null;
  }
  
  protected Expression _raised(final RegularEventSpec e) {
    {
      StextFactory _factory = this.stext.factory();
      ElementReferenceExpression _createElementReferenceExpression = _factory.createElementReferenceExpression();
      final ElementReferenceExpression r = _createElementReferenceExpression;
      Event _event = e.getEvent();
      EventDefinition _create = this.mapping.create(((EventDefinition) _event));
      r.setValue(_create);
      return r;
    }
  }
  
  protected Expression _raised(final TimeEventSpec e) {
    {
      StextFactory _factory = this.stext.factory();
      ElementReferenceExpression _createElementReferenceExpression = _factory.createElementReferenceExpression();
      final ElementReferenceExpression r = _createElementReferenceExpression;
      TimeEvent _createDerivedEvent = this.mapping.createDerivedEvent(e);
      r.setValue(_createDerivedEvent);
      return r;
    }
  }
  
  protected Expression _raised(final OnCycleEvent e) {
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      BoolLiteral _createBoolLiteral = _factory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  protected Expression _raised(final AlwaysEvent e) {
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      BoolLiteral _createBoolLiteral = _factory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  protected Expression _raised(final DefaultEvent e) {
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      BoolLiteral _createBoolLiteral = _factory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  public void retargetDeclRefs(final ExecutionFlow flow) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(flow);
      final List<EObject> allContent = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            boolean _operator_or = false;
            if ((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition)) {
              _operator_or = true;
            } else {
              _operator_or = BooleanExtensions.operator_or((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition), (e instanceof org.yakindu.sct.model.stext.stext.VariableDefinition));
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(allContent, _function);
      List<EObject> _list = IterableExtensions.<EObject>toList(_filter);
      final List<EObject> declared = _list;
      final Function1<EObject,Boolean> _function_1 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e_1) {
            return (e_1 instanceof org.yakindu.sct.model.stext.stext.ElementReferenceExpression);
          }
        };
      Iterable<EObject> _filter_1 = IterableExtensions.<EObject>filter(allContent, _function_1);
      final Function1<EObject,ElementReferenceExpression> _function_2 = new Function1<EObject,ElementReferenceExpression>() {
          public ElementReferenceExpression apply(final EObject s) {
            return ((ElementReferenceExpression) s);
          }
        };
      Iterable<ElementReferenceExpression> _map = IterableExtensions.<EObject, ElementReferenceExpression>map(_filter_1, _function_2);
      final Function1<ElementReferenceExpression,Object> _function_3 = new Function1<ElementReferenceExpression,Object>() {
          public Object apply(final ElementReferenceExpression ere) {
            Object _retarget = ModelSequencer.this.retarget(ere, declared);
            return _retarget;
          }
        };
      IterableExtensions.<ElementReferenceExpression>forEach(_map, _function_3);
      final Function1<EObject,Boolean> _function_4 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e_2) {
            return (e_2 instanceof org.yakindu.sct.model.stext.stext.Assignment);
          }
        };
      Iterable<EObject> _filter_2 = IterableExtensions.<EObject>filter(allContent, _function_4);
      final Function1<EObject,Assignment> _function_5 = new Function1<EObject,Assignment>() {
          public Assignment apply(final EObject s_1) {
            return ((Assignment) s_1);
          }
        };
      Iterable<Assignment> _map_1 = IterableExtensions.<EObject, Assignment>map(_filter_2, _function_5);
      final Function1<Assignment,Object> _function_6 = new Function1<Assignment,Object>() {
          public Object apply(final Assignment ere_1) {
            Object _retarget_1 = ModelSequencer.this.retarget(ere_1, declared);
            return _retarget_1;
          }
        };
      IterableExtensions.<Assignment>forEach(_map_1, _function_6);
    }
  }
  
  public Object retarget(final ElementReferenceExpression ere, final List<EObject> declared) {
    Object _xifexpression = null;
    Declaration _value = ere.getValue();
    boolean _contains = declared.contains(_value);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Declaration _value_1 = ere.getValue();
      Declaration _replaced = this.replaced(_value_1);
      ere.setValue(_replaced);
    }
    return _xifexpression;
  }
  
  public Object retarget(final Assignment assign, final List<EObject> declared) {
    Object _xifexpression = null;
    Variable _varRef = assign.getVarRef();
    boolean _contains = declared.contains(_varRef);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Variable _varRef_1 = assign.getVarRef();
      Declaration _replaced = this.replaced(((VariableDefinition) _varRef_1));
      assign.setVarRef(((Variable) _replaced));
    }
    return _xifexpression;
  }
  
  protected Declaration _replaced(final VariableDefinition vd) {
    VariableDefinition _create = this.mapping.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final EventDefinition ed) {
    EventDefinition _create = this.mapping.create(ed);
    return _create;
  }
  
  protected Declaration _replaced(final TimeEvent ed) {
    return ed;
  }
  
  public StateVector stateVector(final Vertex choice) {
    if ((choice instanceof Choice)) {
      return _stateVector((Choice)choice);
    } else if ((choice instanceof RegularState)) {
      return _stateVector((RegularState)choice);
    } else if ((choice instanceof Vertex)) {
      return _stateVector((Vertex)choice);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(choice).toString());
    }
  }
  
  public Check mapToCheck(final Trigger tr) {
    if ((tr instanceof ReactionTrigger)) {
      return _mapToCheck((ReactionTrigger)tr);
    } else if ((tr instanceof Trigger)) {
      return _mapToCheck((Trigger)tr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(tr).toString());
    }
  }
  
  public Statement buildCondition(final Trigger t) {
    if ((t instanceof ReactionTrigger)) {
      return _buildCondition((ReactionTrigger)t);
    } else if ((t instanceof Trigger)) {
      return _buildCondition((Trigger)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(t).toString());
    }
  }
  
  public Expression raised(final EventSpec e) {
    if ((e instanceof AlwaysEvent)) {
      return _raised((AlwaysEvent)e);
    } else if ((e instanceof DefaultEvent)) {
      return _raised((DefaultEvent)e);
    } else if ((e instanceof OnCycleEvent)) {
      return _raised((OnCycleEvent)e);
    } else if ((e instanceof RegularEventSpec)) {
      return _raised((RegularEventSpec)e);
    } else if ((e instanceof TimeEventSpec)) {
      return _raised((TimeEventSpec)e);
    } else if ((e instanceof EventSpec)) {
      return _raised((EventSpec)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(e).toString());
    }
  }
  
  public Declaration replaced(final Declaration ed) {
    if ((ed instanceof TimeEvent)) {
      return _replaced((TimeEvent)ed);
    } else if ((ed instanceof EventDefinition)) {
      return _replaced((EventDefinition)ed);
    } else if ((ed instanceof VariableDefinition)) {
      return _replaced((VariableDefinition)ed);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(ed).toString());
    }
  }
}