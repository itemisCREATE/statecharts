package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExecutionSynchronization;
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
import org.yakindu.sct.model.sgraph.Synchronization;
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
    SexecFactory _factory = this.sexec.factory();
    final Sequence sequence = _factory.createSequence();
    sequence.setName("react");
    String _name = sc.getName();
    String _plus = ("The reactions of statechart " + _name);
    sequence.setComment(_plus);
    List<RegularState> _allRegularStates = this.sct.allRegularStates(sc);
    final Function1<RegularState,Boolean> _function = new Function1<RegularState,Boolean>() {
        public Boolean apply(final RegularState s) {
          boolean _isLeaf = ReactionBuilder.this.sgraph.isLeaf(s);
          return Boolean.valueOf(_isLeaf);
        }
      };
    final Iterable<RegularState> leafStates = IterableExtensions.<RegularState>filter(_allRegularStates, _function);
    SexecFactory _factory_1 = this.sexec.factory();
    final StateSwitch sSwitch = _factory_1.createStateSwitch();
    EList<Step> _steps = sequence.getSteps();
    _steps.add(sSwitch);
    final Function1<RegularState,ExecutionState> _function_1 = new Function1<RegularState,ExecutionState>() {
        public ExecutionState apply(final RegularState s) {
          ExecutionState _create = ReactionBuilder.this.mapping.create(s);
          return _create;
        }
      };
    Iterable<ExecutionState> _map = IterableExtensions.<RegularState, ExecutionState>map(leafStates, _function_1);
    for (final ExecutionState leaf : _map) {
      {
        SexecFactory _factory_2 = this.sexec.factory();
        final StateCase sCase = _factory_2.createStateCase();
        sCase.setState(leaf);
        Sequence _reactSequence = leaf.getReactSequence();
        Call _newCall = this.mapping.newCall(_reactSequence);
        sCase.setStep(_newCall);
        EList<StateCase> _cases = sSwitch.getCases();
        _cases.add(sCase);
      }
    }
    flow.setReactSequence(sequence);
    return flow;
  }
  
  public ExecutionFlow defineRegularStateReactions(final ExecutionFlow flow, final Statechart sc) {
    final List<RegularState> states = this.sct.allRegularStates(sc);
    Iterable<State> _filter = Iterables.<State>filter(states, State.class);
    final Function1<State,Boolean> _function = new Function1<State,Boolean>() {
        public Boolean apply(final State s) {
          boolean _isSimple = s.isSimple();
          return Boolean.valueOf(_isSimple);
        }
      };
    Iterable<State> _filter_1 = IterableExtensions.<State>filter(_filter, _function);
    final Procedure1<State> _function_1 = new Procedure1<State>() {
        public void apply(final State s) {
          ReactionBuilder.this.defineCycle(s);
        }
      };
    IterableExtensions.<State>forEach(_filter_1, _function_1);
    Iterable<FinalState> _filter_2 = Iterables.<FinalState>filter(states, FinalState.class);
    final Procedure1<FinalState> _function_2 = new Procedure1<FinalState>() {
        public void apply(final FinalState s) {
          ReactionBuilder.this.defineCycle(s);
        }
      };
    IterableExtensions.<FinalState>forEach(_filter_2, _function_2);
    return flow;
  }
  
  public void definePseudoStateReactions(final ExecutionFlow flow, final Statechart sc) {
    Iterable<Choice> _allChoices = this.sct.allChoices(sc);
    final Procedure1<Choice> _function = new Procedure1<Choice>() {
        public void apply(final Choice choice) {
          ReactionBuilder.this.defineReaction(choice);
        }
      };
    IterableExtensions.<Choice>forEach(_allChoices, _function);
    Iterable<Synchronization> _allSynchronizations = this.sct.allSynchronizations(sc);
    final Procedure1<Synchronization> _function_1 = new Procedure1<Synchronization>() {
        public void apply(final Synchronization sync) {
          ReactionBuilder.this.defineReaction(sync);
        }
      };
    IterableExtensions.<Synchronization>forEach(_allSynchronizations, _function_1);
  }
  
  public Sequence defineReaction(final Choice choice) {
    final ExecutionChoice execChoice = this.mapping.create(choice);
    EList<Reaction> _reactions = execChoice.getReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          Check _check = r.getCheck();
          boolean _alwaysTrue = ReactionBuilder.this.alwaysTrue(_check);
          return Boolean.valueOf(_alwaysTrue);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
    List<Reaction> _list = IterableExtensions.<Reaction>toList(_filter);
    final Reaction _default_ = IterableExtensions.<Reaction>head(_list);
    boolean _notEquals = (!Objects.equal(_default_, null));
    if (_notEquals) {
      EList<Reaction> _reactions_1 = execChoice.getReactions();
      EList<Reaction> _reactions_2 = execChoice.getReactions();
      int _size = _reactions_2.size();
      int _minus = (_size - 1);
      _reactions_1.move(_minus, _default_);
    }
    final Sequence stateReaction = this.createReactionSequence(execChoice, null);
    Sequence _reactSequence = execChoice.getReactSequence();
    EList<Step> _steps = _reactSequence.getSteps();
    EList<Step> _steps_1 = stateReaction.getSteps();
    _steps.addAll(_steps_1);
    Sequence _reactSequence_1 = execChoice.getReactSequence();
    _reactSequence_1.setName("react");
    Sequence _reactSequence_2 = execChoice.getReactSequence();
    String _name = choice.getName();
    String _plus = ("The reactions of state " + _name);
    String _plus_1 = (_plus + ".");
    _reactSequence_2.setComment(_plus_1);
    boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
    if (_isAddTraceSteps) {
      Sequence _reactSequence_3 = execChoice.getReactSequence();
      EList<Step> _steps_2 = _reactSequence_3.getSteps();
      ExecutionChoice _create = this.mapping.create(choice);
      TraceNodeExecuted _newTraceNodeExecuted = this.trace.newTraceNodeExecuted(_create);
      _steps_2.add(0, _newTraceNodeExecuted);
    }
    return execChoice.getReactSequence();
  }
  
  /**
   * TODO : support fork...
   */
  public Sequence defineReaction(final Synchronization sync) {
    final ExecutionSynchronization execSync = this.mapping.create(sync);
    EList<Reaction> _reactions = execSync.getReactions();
    final Reaction _default_ = IterableExtensions.<Reaction>head(_reactions);
    Sequence _reactSequence = execSync.getReactSequence();
    EList<Step> _steps = _reactSequence.getSteps();
    Step _effect = _default_.getEffect();
    CollectionExtensions.<Step>addAll(_steps, _effect);
    Sequence _reactSequence_1 = execSync.getReactSequence();
    _reactSequence_1.setName("react");
    Sequence _reactSequence_2 = execSync.getReactSequence();
    String _name = sync.getName();
    String _plus = ("The reactions of state " + _name);
    String _plus_1 = (_plus + ".");
    _reactSequence_2.setComment(_plus_1);
    boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
    if (_isAddTraceSteps) {
      Sequence _reactSequence_3 = execSync.getReactSequence();
      EList<Step> _steps_1 = _reactSequence_3.getSteps();
      ExecutionSynchronization _create = this.mapping.create(sync);
      TraceNodeExecuted _newTraceNodeExecuted = this.trace.newTraceNodeExecuted(_create);
      _steps_1.add(0, _newTraceNodeExecuted);
    }
    return execSync.getReactSequence();
  }
  
  public boolean alwaysTrue(final Check check) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(check, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Statement _condition = check.getCondition();
      _and = (_notEquals && (_condition instanceof PrimitiveValueExpression));
    }
    if (_and) {
      Statement _condition_1 = check.getCondition();
      final PrimitiveValueExpression pve = ((PrimitiveValueExpression) _condition_1);
      boolean _and_1 = false;
      Literal _value = pve.getValue();
      if (!(_value instanceof BoolLiteral)) {
        _and_1 = false;
      } else {
        Literal _value_1 = pve.getValue();
        boolean _isValue = ((BoolLiteral) _value_1).isValue();
        _and_1 = ((_value instanceof BoolLiteral) && _isValue);
      }
      return _and_1;
    }
    return false;
  }
  
  public Sequence defineCycle(final RegularState state) {
    final ExecutionState execState = this.mapping.create(state);
    List<RegularState> _parentStates = this.sgraph.parentStates(state);
    final Function1<RegularState,ExecutionState> _function = new Function1<RegularState,ExecutionState>() {
        public ExecutionState apply(final RegularState p) {
          ExecutionState _create = ReactionBuilder.this.mapping.create(p);
          return ((ExecutionState) _create);
        }
      };
    List<ExecutionState> _map = ListExtensions.<RegularState, ExecutionState>map(_parentStates, _function);
    final Function1<ExecutionState,Boolean> _function_1 = new Function1<ExecutionState,Boolean>() {
        public Boolean apply(final ExecutionState p) {
          StateVector _stateVector = p.getStateVector();
          int _offset = _stateVector.getOffset();
          StateVector _stateVector_1 = execState.getStateVector();
          int _offset_1 = _stateVector_1.getOffset();
          boolean _equals = (_offset == _offset_1);
          return Boolean.valueOf(_equals);
        }
      };
    final Iterable<ExecutionState> parents = IterableExtensions.<ExecutionState>filter(_map, _function_1);
    Iterable<ExecutionNode> _xifexpression = null;
    EObject _rootContainer = EcoreUtil2.getRootContainer(execState);
    StateVector _stateVector = ((ExecutionFlow) _rootContainer).getStateVector();
    int _offset = _stateVector.getOffset();
    StateVector _stateVector_1 = execState.getStateVector();
    int _offset_1 = _stateVector_1.getOffset();
    boolean _equals = (_offset == _offset_1);
    if (_equals) {
      final Function1<ExecutionState,ExecutionNode> _function_2 = new Function1<ExecutionState,ExecutionNode>() {
          public ExecutionNode apply(final ExecutionState p) {
            return ((ExecutionNode) p);
          }
        };
      Iterable<ExecutionNode> _map_1 = IterableExtensions.<ExecutionState, ExecutionNode>map(parents, _function_2);
      EObject _rootContainer_1 = EcoreUtil2.getRootContainer(execState);
      HashSet<ExecutionNode> _newHashSet = CollectionLiterals.<ExecutionNode>newHashSet(((ExecutionNode) _rootContainer_1));
      Iterable<ExecutionNode> _concat = Iterables.<ExecutionNode>concat(_map_1, _newHashSet);
      _xifexpression = _concat;
    } else {
      final Function1<ExecutionState,ExecutionNode> _function_3 = new Function1<ExecutionState,ExecutionNode>() {
          public ExecutionNode apply(final ExecutionState p) {
            return ((ExecutionNode) p);
          }
        };
      Iterable<ExecutionNode> _map_2 = IterableExtensions.<ExecutionState, ExecutionNode>map(parents, _function_3);
      _xifexpression = _map_2;
    }
    final Iterable<ExecutionNode> parentNodes = _xifexpression;
    final Function2<Sequence,ExecutionNode,Sequence> _function_4 = new Function2<Sequence,ExecutionNode,Sequence>() {
        public Sequence apply(final Sequence r, final ExecutionNode s) {
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
    String _plus = ("The reactions of state " + _name);
    String _plus_1 = (_plus + ".");
    _reactSequence_1.setComment(_plus_1);
    return execState.getReactSequence();
  }
  
  public Sequence createReactionSequence(final ExecutionNode state, final Step localStep) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence cycle = _factory.createSequence();
    cycle.setName("react");
    EList<Reaction> _reactions = state.getReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          boolean _isTransition = r.isTransition();
          boolean _not = (!_isTransition);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
    final List<Reaction> localReactions = IterableExtensions.<Reaction>toList(_filter);
    SexecFactory _factory_1 = this.sexec.factory();
    Sequence localSteps = _factory_1.createSequence();
    EList<Step> _steps = localSteps.getSteps();
    final Function1<Reaction,If> _function_1 = new Function1<Reaction,If>() {
        public If apply(final Reaction lr) {
          If _xblockexpression = null;
          {
            SexecFactory _factory = ReactionBuilder.this.sexec.factory();
            If ifStep = _factory.createIf();
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
    boolean _notEquals = (!Objects.equal(localStep, null));
    if (_notEquals) {
      EList<Step> _steps_1 = localSteps.getSteps();
      _steps_1.add(localStep);
    }
    EList<Step> _steps_2 = localSteps.getSteps();
    boolean _isEmpty = _steps_2.isEmpty();
    if (_isEmpty) {
      localSteps = null;
    }
    EList<Reaction> _reactions_1 = state.getReactions();
    final Function1<Reaction,Boolean> _function_2 = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          boolean _isTransition = r.isTransition();
          return Boolean.valueOf(_isTransition);
        }
      };
    Iterable<Reaction> _filter_1 = IterableExtensions.<Reaction>filter(_reactions_1, _function_2);
    final List<Reaction> transitionReactions = IterableExtensions.<Reaction>toList(_filter_1);
    List<Reaction> _reverseView = ListExtensions.<Reaction>reverseView(transitionReactions);
    final Function2<Step,Reaction,Step> _function_3 = new Function2<Step,Reaction,Step>() {
        public Step apply(final Step s, final Reaction reaction) {
          Step _xblockexpression = null;
          {
            SexecFactory _factory = ReactionBuilder.this.sexec.factory();
            If ifStep = _factory.createIf();
            Check _check = reaction.getCheck();
            CheckRef _newRef = ReactionBuilder.this.mapping.newRef(_check);
            ifStep.setCheck(_newRef);
            Step _effect = reaction.getEffect();
            Call _newCall = ReactionBuilder.this.mapping.newCall(_effect);
            ifStep.setThenStep(_newCall);
            ifStep.setElseStep(s);
            _xblockexpression = (((Step) ifStep));
          }
          return _xblockexpression;
        }
      };
    final Step transitionStep = IterableExtensions.<Reaction, Step>fold(_reverseView, ((Step) localSteps), _function_3);
    boolean _notEquals_1 = (!Objects.equal(transitionStep, null));
    if (_notEquals_1) {
      EList<Step> _steps_3 = cycle.getSteps();
      _steps_3.add(transitionStep);
    } else {
      boolean _notEquals_2 = (!Objects.equal(localSteps, null));
      if (_notEquals_2) {
        EList<Step> _steps_4 = cycle.getSteps();
        _steps_4.add(localSteps);
      }
    }
    return cycle;
  }
  
  public ExecutionFlow defineEntryReactions(final Statechart statechart, final ExecutionFlow r) {
    Iterable<Entry> _allEntries = this.sct.allEntries(statechart);
    final Procedure1<Entry> _function = new Procedure1<Entry>() {
        public void apply(final Entry e) {
          ReactionBuilder.this.defineReaction(e);
        }
      };
    IterableExtensions.<Entry>forEach(_allEntries, _function);
    return r;
  }
  
  public boolean defineReaction(final Entry e) {
    boolean _xblockexpression = false;
    {
      final ExecutionEntry execEntry = this.mapping.create(e);
      final Sequence seq = execEntry.getReactSequence();
      State _target = this.sgraph.target(e);
      final ExecutionState target = this.mapping.create(_target);
      boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
      if (_isAddTraceSteps) {
        EList<Step> _steps = seq.getSteps();
        TraceNodeExecuted _newTraceNodeExecuted = this.trace.newTraceNodeExecuted(execEntry);
        _steps.add(0, _newTraceNodeExecuted);
      }
      boolean _xifexpression = false;
      EntryKind _kind = e.getKind();
      boolean _equals = Objects.equal(_kind, EntryKind.INITIAL);
      if (_equals) {
        boolean _xifexpression_1 = false;
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(target, null));
        if (!_notEquals) {
          _and = false;
        } else {
          Sequence _enterSequence = target.getEnterSequence();
          boolean _notEquals_1 = (!Objects.equal(_enterSequence, null));
          _and = (_notEquals && _notEquals_1);
        }
        if (_and) {
          boolean _xblockexpression_1 = false;
          {
            boolean _isAddTraceSteps_1 = this.trace.isAddTraceSteps();
            if (_isAddTraceSteps_1) {
              EList<Step> _steps_1 = seq.getSteps();
              EList<Transition> _outgoingTransitions = e.getOutgoingTransitions();
              Transition _get = _outgoingTransitions.get(0);
              Reaction _create = this.mapping.create(_get);
              ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(_create);
              _steps_1.add(_newTraceReactionFired);
            }
            EList<Step> _steps_2 = seq.getSteps();
            Sequence _enterSequence_1 = target.getEnterSequence();
            Call _newCall = this.mapping.newCall(_enterSequence_1);
            boolean _add = _steps_2.add(_newCall);
            _xblockexpression_1 = (_add);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      } else {
        boolean _xifexpression_2 = false;
        EntryKind _kind_1 = e.getKind();
        boolean _equals_1 = Objects.equal(_kind_1, EntryKind.SHALLOW_HISTORY);
        if (_equals_1) {
          boolean _xblockexpression_2 = false;
          {
            SexecFactory _factory = this.sexec.factory();
            final HistoryEntry entryStep = _factory.createHistoryEntry();
            entryStep.setName("HistoryEntry");
            entryStep.setComment("Enter the region with shallow history");
            entryStep.setDeep(false);
            EObject _eContainer = e.eContainer();
            ExecutionRegion _create = this.mapping.create(((Region) _eContainer));
            entryStep.setRegion(_create);
            boolean _and_1 = false;
            boolean _notEquals_2 = (!Objects.equal(target, null));
            if (!_notEquals_2) {
              _and_1 = false;
            } else {
              Sequence _enterSequence_1 = target.getEnterSequence();
              boolean _notEquals_3 = (!Objects.equal(_enterSequence_1, null));
              _and_1 = (_notEquals_2 && _notEquals_3);
            }
            if (_and_1) {
              boolean _isAddTraceSteps_1 = this.trace.isAddTraceSteps();
              if (_isAddTraceSteps_1) {
                EList<Step> _steps_1 = seq.getSteps();
                EList<Transition> _outgoingTransitions = e.getOutgoingTransitions();
                Transition _get = _outgoingTransitions.get(0);
                Reaction _create_1 = this.mapping.create(_get);
                ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(_create_1);
                _steps_1.add(_newTraceReactionFired);
              }
              Sequence _enterSequence_2 = target.getEnterSequence();
              Call _newCall = this.mapping.newCall(_enterSequence_2);
              entryStep.setInitialStep(_newCall);
            }
            EObject _eContainer_1 = e.eContainer();
            ExecutionRegion _create_2 = this.mapping.create(((Region) _eContainer_1));
            Sequence _shallowEnterSequence = _create_2.getShallowEnterSequence();
            Call _newCall_1 = this.mapping.newCall(_shallowEnterSequence);
            entryStep.setHistoryStep(_newCall_1);
            EList<Step> _steps_2 = seq.getSteps();
            boolean _add = _steps_2.add(entryStep);
            _xblockexpression_2 = (_add);
          }
          _xifexpression_2 = _xblockexpression_2;
        } else {
          boolean _xifexpression_3 = false;
          EntryKind _kind_2 = e.getKind();
          boolean _equals_2 = Objects.equal(_kind_2, EntryKind.DEEP_HISTORY);
          if (_equals_2) {
            boolean _xblockexpression_3 = false;
            {
              SexecFactory _factory = this.sexec.factory();
              final HistoryEntry entryStep = _factory.createHistoryEntry();
              entryStep.setName("HistoryEntry");
              entryStep.setComment("Enter the region with deep history");
              EObject _eContainer = e.eContainer();
              ExecutionRegion _create = this.mapping.create(((Region) _eContainer));
              entryStep.setRegion(_create);
              entryStep.setDeep(true);
              boolean _and_1 = false;
              boolean _notEquals_2 = (!Objects.equal(target, null));
              if (!_notEquals_2) {
                _and_1 = false;
              } else {
                Sequence _enterSequence_1 = target.getEnterSequence();
                boolean _notEquals_3 = (!Objects.equal(_enterSequence_1, null));
                _and_1 = (_notEquals_2 && _notEquals_3);
              }
              if (_and_1) {
                boolean _isAddTraceSteps_1 = this.trace.isAddTraceSteps();
                if (_isAddTraceSteps_1) {
                  EList<Step> _steps_1 = seq.getSteps();
                  EList<Transition> _outgoingTransitions = e.getOutgoingTransitions();
                  Transition _get = _outgoingTransitions.get(0);
                  Reaction _create_1 = this.mapping.create(_get);
                  ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(_create_1);
                  _steps_1.add(_newTraceReactionFired);
                }
                Sequence _enterSequence_2 = target.getEnterSequence();
                Call _newCall = this.mapping.newCall(_enterSequence_2);
                entryStep.setInitialStep(_newCall);
              }
              EObject _eContainer_1 = e.eContainer();
              ExecutionRegion _create_2 = this.mapping.create(((Region) _eContainer_1));
              Sequence _deepEnterSequence = _create_2.getDeepEnterSequence();
              Call _newCall_1 = this.mapping.newCall(_deepEnterSequence);
              entryStep.setHistoryStep(_newCall_1);
              EList<Step> _steps_2 = seq.getSteps();
              boolean _add = _steps_2.add(entryStep);
              _xblockexpression_3 = (_add);
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
