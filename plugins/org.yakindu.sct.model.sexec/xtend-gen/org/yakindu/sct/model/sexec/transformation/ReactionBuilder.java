package org.yakindu.sct.model.sexec.transformation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;

@SuppressWarnings("all")
public class ReactionBuilder {
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StatechartExtensions sct;
  
  @Inject
  private TraceExtensions trace;
  
  public ExecutionFlow defineStatechartReaction(final ExecutionFlow flow, final Statechart sc) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence sequence = _createSequence;
      sequence.setName("react");
      String _name = sc.getName();
      String _operator_plus = StringExtensions.operator_plus("The reactions of statechart ", _name);
      sequence.setComment(_operator_plus);
      List<RegularState> _allRegularStates = this.sct.allRegularStates(sc);
      final Function1<RegularState,Boolean> _function = new Function1<RegularState,Boolean>() {
          public Boolean apply(final RegularState s) {
            boolean _isLeaf = ReactionBuilder.this.sgraph.isLeaf(s);
            return ((Boolean)_isLeaf);
          }
        };
      Iterable<RegularState> _filter = IterableExtensions.<RegularState>filter(_allRegularStates, _function);
      final Iterable<RegularState> leafStates = _filter;
      SexecFactory _factory_1 = this.sexec.factory();
      StateSwitch _createStateSwitch = _factory_1.createStateSwitch();
      final StateSwitch sSwitch = _createStateSwitch;
      EList<Step> _steps = sequence.getSteps();
      CollectionExtensions.<Step>operator_add(_steps, sSwitch);
      final Function1<RegularState,ExecutionState> _function_1 = new Function1<RegularState,ExecutionState>() {
          public ExecutionState apply(final RegularState s_1) {
            ExecutionState _create = ReactionBuilder.this.mapping.create(s_1);
            return _create;
          }
        };
      Iterable<ExecutionState> _map = IterableExtensions.<RegularState, ExecutionState>map(leafStates, _function_1);
      for (final ExecutionState leaf : _map) {
        {
          SexecFactory _factory_2 = this.sexec.factory();
          StateCase _createStateCase = _factory_2.createStateCase();
          final StateCase sCase = _createStateCase;
          sCase.setState(leaf);
          Sequence _reactSequence = leaf.getReactSequence();
          Call _newCall = this.mapping.newCall(_reactSequence);
          sCase.setStep(_newCall);
          EList<StateCase> _cases = sSwitch.getCases();
          CollectionExtensions.<StateCase>operator_add(_cases, sCase);
        }
      }
      flow.setReactSequence(sequence);
      return flow;
    }
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
            Sequence _defineCycle = ReactionBuilder.this.defineCycle(s_1);
            return _defineCycle;
          }
        };
      IterableExtensions.<State>forEach(_filter_1, _function_1);
      Iterable<FinalState> _filter_2 = IterableExtensions.<FinalState>filter(states, org.yakindu.sct.model.sgraph.FinalState.class);
      final Function1<FinalState,Sequence> _function_2 = new Function1<FinalState,Sequence>() {
          public Sequence apply(final FinalState s_2) {
            Sequence _defineCycle_1 = ReactionBuilder.this.defineCycle(s_2);
            return _defineCycle_1;
          }
        };
      IterableExtensions.<FinalState>forEach(_filter_2, _function_2);
      return flow;
    }
  }
  
  public void definePseudoStateReactions(final ExecutionFlow flow, final Statechart sc) {
    Iterable<Choice> _allChoices = this.sct.allChoices(sc);
    final Function1<Choice,Sequence> _function = new Function1<Choice,Sequence>() {
        public Sequence apply(final Choice choice) {
          Sequence _defineReaction = ReactionBuilder.this.defineReaction(choice);
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
            boolean _alwaysTrue = ReactionBuilder.this.alwaysTrue(_check);
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
      boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
      if (_isAddTraceSteps) {
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
      List<RegularState> _parentStates = this.sgraph.parentStates(state);
      final Function1<RegularState,ExecutionState> _function = new Function1<RegularState,ExecutionState>() {
          public ExecutionState apply(final RegularState p) {
            ExecutionState _create_1 = ReactionBuilder.this.mapping.create(p);
            return ((ExecutionState) _create_1);
          }
        };
      List<ExecutionState> _map = ListExtensions.<RegularState, ExecutionState>map(_parentStates, _function);
      final Function1<ExecutionState,Boolean> _function_1 = new Function1<ExecutionState,Boolean>() {
          public Boolean apply(final ExecutionState p_1) {
            StateVector _stateVector = p_1.getStateVector();
            int _offset = _stateVector.getOffset();
            StateVector _stateVector_1 = execState.getStateVector();
            int _offset_1 = _stateVector_1.getOffset();
            boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_offset), ((Integer)_offset_1));
            return ((Boolean)_operator_equals);
          }
        };
      Iterable<ExecutionState> _filter = IterableExtensions.<ExecutionState>filter(_map, _function_1);
      final Iterable<ExecutionState> parents = _filter;
      Iterable<ExecutionNode> _xifexpression = null;
      EObject _rootContainer = EcoreUtil.getRootContainer(execState);
      StateVector _stateVector_2 = ((ExecutionFlow) _rootContainer).getStateVector();
      int _offset_2 = _stateVector_2.getOffset();
      StateVector _stateVector_3 = execState.getStateVector();
      int _offset_3 = _stateVector_3.getOffset();
      boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_offset_2), ((Integer)_offset_3));
      if (_operator_equals_1) {
        final Function1<ExecutionState,ExecutionNode> _function_2 = new Function1<ExecutionState,ExecutionNode>() {
            public ExecutionNode apply(final ExecutionState p_2) {
              return ((ExecutionNode) p_2);
            }
          };
        Iterable<ExecutionNode> _map_1 = IterableExtensions.<ExecutionState, ExecutionNode>map(parents, _function_2);
        EObject _rootContainer_1 = EcoreUtil.getRootContainer(execState);
        HashSet<ExecutionNode> _newHashSet = CollectionLiterals.<ExecutionNode>newHashSet(((ExecutionNode) _rootContainer_1));
        Iterable<ExecutionNode> _concat = Iterables.<ExecutionNode>concat(_map_1, _newHashSet);
        _xifexpression = _concat;
      } else {
        final Function1<ExecutionState,ExecutionNode> _function_3 = new Function1<ExecutionState,ExecutionNode>() {
            public ExecutionNode apply(final ExecutionState p_3) {
              return ((ExecutionNode) p_3);
            }
          };
        Iterable<ExecutionNode> _map_2 = IterableExtensions.<ExecutionState, ExecutionNode>map(parents, _function_3);
        _xifexpression = _map_2;
      }
      final Iterable<ExecutionNode> parentNodes = _xifexpression;
      final Function2<Sequence,ExecutionNode,Sequence> _function_4 = new Function2<Sequence,ExecutionNode,Sequence>() {
          public Sequence apply(final Sequence r , final ExecutionNode s) {
            Sequence _createReactionSequence = ReactionBuilder.this.createReactionSequence(s, r);
            return _createReactionSequence;
          }
        };
      Sequence _fold = IterableExtensions.<ExecutionNode, Sequence>fold(parentNodes, null, _function_4);
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
      cycle.setName("react");
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
              SexecFactory _factory_2 = ReactionBuilder.this.sexec.factory();
              If _createIf = _factory_2.createIf();
              If ifStep = _createIf;
              Check _check = lr.getCheck();
              CheckRef _newRef = ReactionBuilder.this.mapping.newRef(_check);
              ifStep.setCheck(_newRef);
              Step _effect = lr.getEffect();
              Call _newCall = ReactionBuilder.this.mapping.newCall(_effect);
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
              SexecFactory _factory_3 = ReactionBuilder.this.sexec.factory();
              If _createIf_1 = _factory_3.createIf();
              If ifStep_1 = _createIf_1;
              Check _check_1 = reaction.getCheck();
              CheckRef _newRef_1 = ReactionBuilder.this.mapping.newRef(_check_1);
              ifStep_1.setCheck(_newRef_1);
              Step _effect_1 = reaction.getEffect();
              Call _newCall_1 = ReactionBuilder.this.mapping.newCall(_effect_1);
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
  
  public ExecutionFlow defineEntryReactions(final Statechart statechart, final ExecutionFlow r) {
    {
      Iterable<Entry> _allEntries = this.sct.allEntries(statechart);
      final Function1<Entry,Boolean> _function = new Function1<Entry,Boolean>() {
          public Boolean apply(final Entry e) {
            Boolean _defineReaction = ReactionBuilder.this.defineReaction(e);
            return _defineReaction;
          }
        };
      IterableExtensions.<Entry>forEach(_allEntries, _function);
      return r;
    }
  }
  
  public Boolean defineReaction(final Entry e) {
    Boolean _xblockexpression = null;
    {
      ExecutionEntry _create = this.mapping.create(e);
      final ExecutionEntry execEntry = _create;
      Sequence _reactSequence = execEntry.getReactSequence();
      final Sequence seq = _reactSequence;
      State _target = this.sgraph.target(e);
      ExecutionState _create_1 = this.mapping.create(_target);
      final ExecutionState target = _create_1;
      boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
      if (_isAddTraceSteps) {
        EList<Step> _steps = seq.getSteps();
        TraceNodeExecuted _newTraceNodeExecuted = this.trace.newTraceNodeExecuted(execEntry);
        _steps.add(0, _newTraceNodeExecuted);
      }
      Boolean _xifexpression = null;
      EntryKind _kind = e.getKind();
      boolean _operator_equals = ObjectExtensions.operator_equals(_kind, EntryKind.INITIAL);
      if (_operator_equals) {
        Boolean _xifexpression_1 = null;
        boolean _operator_and = false;
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(target, null);
        if (!_operator_notEquals) {
          _operator_and = false;
        } else {
          Sequence _enterSequence = target.getEnterSequence();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_enterSequence, null);
          _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
        }
        if (_operator_and) {
          boolean _xblockexpression_1 = false;
          {
            boolean _isAddTraceSteps_1 = this.trace.isAddTraceSteps();
            if (_isAddTraceSteps_1) {
              EList<Step> _steps_1 = seq.getSteps();
              EList<Transition> _outgoingTransitions = e.getOutgoingTransitions();
              Transition _get = _outgoingTransitions.get(0);
              Reaction _create_2 = this.mapping.create(_get);
              ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(_create_2);
              CollectionExtensions.<Step>operator_add(_steps_1, _newTraceReactionFired);
            }
            EList<Step> _steps_2 = seq.getSteps();
            Sequence _enterSequence_1 = target.getEnterSequence();
            Call _newCall = this.mapping.newCall(_enterSequence_1);
            boolean _operator_add = CollectionExtensions.<Step>operator_add(_steps_2, _newCall);
            _xblockexpression_1 = (_operator_add);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      } else {
        boolean _xifexpression_2 = false;
        EntryKind _kind_1 = e.getKind();
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(_kind_1, EntryKind.SHALLOW_HISTORY);
        if (_operator_equals_1) {
          boolean _xblockexpression_2 = false;
          {
            SexecFactory _factory = this.sexec.factory();
            HistoryEntry _createHistoryEntry = _factory.createHistoryEntry();
            final HistoryEntry entryStep = _createHistoryEntry;
            entryStep.setName("HistoryEntry");
            entryStep.setComment("Enter the region with shallow history");
            entryStep.setDeep(false);
            EObject _eContainer = e.eContainer();
            ExecutionRegion _create_3 = this.mapping.create(((Region) _eContainer));
            entryStep.setRegion(_create_3);
            boolean _operator_and_1 = false;
            boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(target, null);
            if (!_operator_notEquals_2) {
              _operator_and_1 = false;
            } else {
              Sequence _enterSequence_2 = target.getEnterSequence();
              boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_enterSequence_2, null);
              _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals_2, _operator_notEquals_3);
            }
            if (_operator_and_1) {
              {
                boolean _isAddTraceSteps_2 = this.trace.isAddTraceSteps();
                if (_isAddTraceSteps_2) {
                  EList<Step> _steps_3 = seq.getSteps();
                  EList<Transition> _outgoingTransitions_1 = e.getOutgoingTransitions();
                  Transition _get_1 = _outgoingTransitions_1.get(0);
                  Reaction _create_4 = this.mapping.create(_get_1);
                  ReactionFired _newTraceReactionFired_1 = this.trace.newTraceReactionFired(_create_4);
                  CollectionExtensions.<Step>operator_add(_steps_3, _newTraceReactionFired_1);
                }
                Sequence _enterSequence_3 = target.getEnterSequence();
                Call _newCall_1 = this.mapping.newCall(_enterSequence_3);
                entryStep.setInitialStep(_newCall_1);
              }
            }
            EObject _eContainer_1 = e.eContainer();
            ExecutionRegion _create_5 = this.mapping.create(((Region) _eContainer_1));
            Sequence _shallowEnterSequence = _create_5.getShallowEnterSequence();
            Call _newCall_2 = this.mapping.newCall(_shallowEnterSequence);
            entryStep.setHistoryStep(_newCall_2);
            EList<Step> _steps_4 = seq.getSteps();
            boolean _operator_add_1 = CollectionExtensions.<Step>operator_add(_steps_4, entryStep);
            _xblockexpression_2 = (_operator_add_1);
          }
          _xifexpression_2 = _xblockexpression_2;
        } else {
          Boolean _xifexpression_3 = null;
          EntryKind _kind_2 = e.getKind();
          boolean _operator_equals_2 = ObjectExtensions.operator_equals(_kind_2, EntryKind.DEEP_HISTORY);
          if (_operator_equals_2) {
            boolean _xblockexpression_3 = false;
            {
              SexecFactory _factory_1 = this.sexec.factory();
              HistoryEntry _createHistoryEntry_1 = _factory_1.createHistoryEntry();
              final HistoryEntry entryStep_1 = _createHistoryEntry_1;
              entryStep_1.setName("HistoryEntry");
              entryStep_1.setComment("Enter the region with deep history");
              EObject _eContainer_2 = e.eContainer();
              ExecutionRegion _create_6 = this.mapping.create(((Region) _eContainer_2));
              entryStep_1.setRegion(_create_6);
              entryStep_1.setDeep(true);
              boolean _operator_and_2 = false;
              boolean _operator_notEquals_4 = ObjectExtensions.operator_notEquals(target, null);
              if (!_operator_notEquals_4) {
                _operator_and_2 = false;
              } else {
                Sequence _enterSequence_4 = target.getEnterSequence();
                boolean _operator_notEquals_5 = ObjectExtensions.operator_notEquals(_enterSequence_4, null);
                _operator_and_2 = BooleanExtensions.operator_and(_operator_notEquals_4, _operator_notEquals_5);
              }
              if (_operator_and_2) {
                {
                  boolean _isAddTraceSteps_3 = this.trace.isAddTraceSteps();
                  if (_isAddTraceSteps_3) {
                    EList<Step> _steps_5 = seq.getSteps();
                    EList<Transition> _outgoingTransitions_2 = e.getOutgoingTransitions();
                    Transition _get_2 = _outgoingTransitions_2.get(0);
                    Reaction _create_7 = this.mapping.create(_get_2);
                    ReactionFired _newTraceReactionFired_2 = this.trace.newTraceReactionFired(_create_7);
                    CollectionExtensions.<Step>operator_add(_steps_5, _newTraceReactionFired_2);
                  }
                  Sequence _enterSequence_5 = target.getEnterSequence();
                  Call _newCall_3 = this.mapping.newCall(_enterSequence_5);
                  entryStep_1.setInitialStep(_newCall_3);
                }
              }
              EObject _eContainer_3 = e.eContainer();
              ExecutionRegion _create_8 = this.mapping.create(((Region) _eContainer_3));
              Sequence _deepEnterSequence = _create_8.getDeepEnterSequence();
              Call _newCall_4 = this.mapping.newCall(_deepEnterSequence);
              entryStep_1.setHistoryStep(_newCall_4);
              EList<Step> _steps_6 = seq.getSteps();
              boolean _operator_add_2 = CollectionExtensions.<Step>operator_add(_steps_6, entryStep_1);
              _xblockexpression_3 = (_operator_add_2);
            }
            _xifexpression_3 = _xblockexpression_3;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression = _xifexpression_2;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}