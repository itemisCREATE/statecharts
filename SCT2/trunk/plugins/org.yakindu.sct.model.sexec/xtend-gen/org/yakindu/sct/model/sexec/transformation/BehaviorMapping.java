package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExecutionSynchronization;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.SequenceBuilder;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Pseudostate;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.DefaultTrigger;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;

@SuppressWarnings("all")
public class BehaviorMapping {
  @Inject
  private StatechartExtensions sc;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SexecElementMapping factory;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private TraceExtensions trace;
  
  @Inject
  private SequenceBuilder sb;
  
  public ExecutionFlow mapEntryActions(final Statechart statechart, final ExecutionFlow r) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("entryAction");
    String _name = statechart.getName();
    String _plus = ("Entry action for statechart \'" + _name);
    String _plus_1 = (_plus + "\'.");
    seq.setComment(_plus_1);
    List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(statechart);
    for (final TimeEventSpec tes : _timeEventSpecs) {
      {
        final TimeEvent timeEvent = this.factory.createDerivedEvent(tes);
        Statement _buildValueExpression = this.sb.buildValueExpression(tes);
        final ScheduleTimeEvent scheduleStep = this.factory.newScheduleTimeEvent(timeEvent, _buildValueExpression);
        EList<Step> _steps = seq.getSteps();
        _steps.add(scheduleStep);
      }
    }
    List<LocalReaction> _entryReactions = this.sc.entryReactions(statechart);
    final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
        public Sequence apply(final LocalReaction lr) {
          Sequence _xifexpression = null;
          Effect _effect = lr.getEffect();
          boolean _notEquals = (!Objects.equal(_effect, null));
          if (_notEquals) {
            Effect _effect_1 = lr.getEffect();
            Sequence _mapEffect = BehaviorMapping.this.mapEffect(((ReactionEffect) _effect_1));
            _xifexpression = _mapEffect;
          } else {
            _xifexpression = null;
          }
          return _xifexpression;
        }
      };
    List<Sequence> _map = ListExtensions.<LocalReaction, Sequence>map(_entryReactions, _function);
    final Procedure1<Sequence> _function_1 = new Procedure1<Sequence>() {
        public void apply(final Sequence e) {
          boolean _notEquals = (!Objects.equal(e, null));
          if (_notEquals) {
            EList<Step> _steps = seq.getSteps();
            _steps.add(e);
          }
        }
      };
    IterableExtensions.<Sequence>forEach(_map, _function_1);
    r.setEntryAction(seq);
    List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
    final Iterable<State> allStates = Iterables.<State>filter(_allRegularStates, State.class);
    final Procedure1<State> _function_2 = new Procedure1<State>() {
        public void apply(final State s) {
          ExecutionState _create = BehaviorMapping.this.factory.create(s);
          Step _mapEntryAction = BehaviorMapping.this.mapEntryAction(s);
          _create.setEntryAction(_mapEntryAction);
        }
      };
    IterableExtensions.<State>forEach(allStates, _function_2);
    return r;
  }
  
  /**
   * The entry action sequence of a state consist all action that are specified with the 'entry' pseudo trigger within local reactions
   * and all scheduling actions for time triggers.
   */
  public Step mapEntryAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      final Sequence seq = _factory.createSequence();
      seq.setName("entryAction");
      String _name = state.getName();
      String _plus = ("Entry action for state \'" + _name);
      String _plus_1 = (_plus + "\'.");
      seq.setComment(_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(state);
      for (final TimeEventSpec tes : _timeEventSpecs) {
        {
          final TimeEvent timeEvent = this.factory.createDerivedEvent(tes);
          Statement _buildValueExpression = this.sb.buildValueExpression(tes);
          final ScheduleTimeEvent scheduleStep = this.factory.newScheduleTimeEvent(timeEvent, _buildValueExpression);
          EList<Step> _steps = seq.getSteps();
          _steps.add(scheduleStep);
        }
      }
      List<LocalReaction> _entryReactions = this.sc.entryReactions(state);
      final Function1<LocalReaction,Step> _function = new Function1<LocalReaction,Step>() {
          public Step apply(final LocalReaction lr) {
            Step _mapEntryAction = BehaviorMapping.this.mapEntryAction(lr);
            return _mapEntryAction;
          }
        };
      List<Step> _map = ListExtensions.<LocalReaction, Step>map(_entryReactions, _function);
      final Procedure1<Step> _function_1 = new Procedure1<Step>() {
          public void apply(final Step e) {
            boolean _notEquals = (!Objects.equal(e, null));
            if (_notEquals) {
              EList<Step> _steps = seq.getSteps();
              _steps.add(e);
            }
          }
        };
      IterableExtensions.<Step>forEach(_map, _function_1);
      Sequence _xifexpression = null;
      EList<Step> _steps = seq.getSteps();
      int _size = _steps.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _xifexpression = seq;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Step mapEntryAction(final LocalReaction it) {
    Step _xifexpression = null;
    Effect _effect = it.getEffect();
    boolean _notEquals = (!Objects.equal(_effect, null));
    if (_notEquals) {
      Step _xblockexpression = null;
      {
        Effect _effect_1 = it.getEffect();
        Sequence effectSeq = this.mapEffect(((ReactionEffect) _effect_1));
        Trigger _trigger = it.getTrigger();
        Expression guard = this.buildGuard(_trigger);
        Step _xifexpression_1 = null;
        boolean _notEquals_1 = (!Objects.equal(guard, null));
        if (_notEquals_1) {
          Step _xblockexpression_1 = null;
          {
            SexecFactory _factory = this.sexec.factory();
            If ifStep = _factory.createIf();
            SexecFactory _factory_1 = this.sexec.factory();
            Check _createCheck = _factory_1.createCheck();
            ifStep.setCheck(_createCheck);
            Check _check = ifStep.getCheck();
            _check.setCondition(guard);
            ifStep.setThenStep(effectSeq);
            _xblockexpression_1 = (((Step) ifStep));
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          _xifexpression_1 = effectSeq;
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public ExecutionFlow mapChoiceTransitions(final Statechart statechart, final ExecutionFlow r) {
    Iterable<Choice> _allChoices = this.sc.allChoices(statechart);
    final Procedure1<Choice> _function = new Procedure1<Choice>() {
        public void apply(final Choice choice) {
          BehaviorMapping.this.mapChoiceTransition(choice);
        }
      };
    IterableExtensions.<Choice>forEach(_allChoices, _function);
    return r;
  }
  
  public ExecutionChoice mapChoiceTransition(final Choice choice) {
    final ExecutionChoice _choice = this.factory.create(choice);
    EList<Reaction> _reactions = _choice.getReactions();
    EList<Transition> _outgoingTransitions = choice.getOutgoingTransitions();
    final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
        public Reaction apply(final Transition t) {
          Reaction _mapTransition = BehaviorMapping.this.mapTransition(t);
          return _mapTransition;
        }
      };
    List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
    _reactions.addAll(_map);
    return _choice;
  }
  
  public ExecutionFlow mapSyncTransitions(final Statechart statechart, final ExecutionFlow r) {
    Iterable<Synchronization> _allSynchronizations = this.sc.allSynchronizations(statechart);
    final Procedure1<Synchronization> _function = new Procedure1<Synchronization>() {
        public void apply(final Synchronization sync) {
          BehaviorMapping.this.mapSyncTransition(sync);
        }
      };
    IterableExtensions.<Synchronization>forEach(_allSynchronizations, _function);
    return r;
  }
  
  public ExecutionSynchronization mapSyncTransition(final Synchronization sync) {
    final ExecutionSynchronization _sync = this.factory.create(sync);
    final EList<Transition> transitions = sync.getOutgoingTransitions();
    Transition _head = IterableExtensions.<Transition>head(transitions);
    final Reaction r = this.factory.create(_head);
    EList<Reaction> _reactions = _sync.getReactions();
    _reactions.add(r);
    Sequence _mapToEffect = this.mapToEffect(transitions, r);
    r.setEffect(_mapToEffect);
    return _sync;
  }
  
  public ExecutionFlow mapExitActions(final Statechart statechart, final ExecutionFlow r) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("exitAction");
    String _name = statechart.getName();
    String _plus = ("Exit action for state \'" + _name);
    String _plus_1 = (_plus + "\'.");
    seq.setComment(_plus_1);
    List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(statechart);
    for (final TimeEventSpec tes : _timeEventSpecs) {
      {
        final TimeEvent timeEvent = this.factory.createDerivedEvent(tes);
        final UnscheduleTimeEvent unscheduleStep = this.factory.newUnscheduleTimeEvent(timeEvent);
        EList<Step> _steps = seq.getSteps();
        _steps.add(unscheduleStep);
      }
    }
    List<LocalReaction> _exitReactions = this.sc.exitReactions(statechart);
    final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
        public Sequence apply(final LocalReaction lr) {
          Sequence _xifexpression = null;
          Effect _effect = lr.getEffect();
          boolean _notEquals = (!Objects.equal(_effect, null));
          if (_notEquals) {
            Effect _effect_1 = lr.getEffect();
            Sequence _mapEffect = BehaviorMapping.this.mapEffect(((ReactionEffect) _effect_1));
            _xifexpression = _mapEffect;
          } else {
            _xifexpression = null;
          }
          return _xifexpression;
        }
      };
    List<Sequence> _map = ListExtensions.<LocalReaction, Sequence>map(_exitReactions, _function);
    final Procedure1<Sequence> _function_1 = new Procedure1<Sequence>() {
        public void apply(final Sequence e) {
          boolean _notEquals = (!Objects.equal(e, null));
          if (_notEquals) {
            EList<Step> _steps = seq.getSteps();
            _steps.add(e);
          }
        }
      };
    IterableExtensions.<Sequence>forEach(_map, _function_1);
    r.setExitAction(seq);
    List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
    final Iterable<State> allStates = Iterables.<State>filter(_allRegularStates, State.class);
    final Procedure1<State> _function_2 = new Procedure1<State>() {
        public void apply(final State s) {
          ExecutionState _create = BehaviorMapping.this.factory.create(s);
          Step _mapExitAction = BehaviorMapping.this.mapExitAction(s);
          _create.setExitAction(_mapExitAction);
        }
      };
    IterableExtensions.<State>forEach(allStates, _function_2);
    return r;
  }
  
  /**
   * The exit action sequence of a state consist all action that are specified with the 'exit' pseudo trigger within local reactions
   * and all unscheduling actions for time triggers.
   */
  public Step mapExitAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      final Sequence seq = _factory.createSequence();
      seq.setName("exitAction");
      String _name = state.getName();
      String _plus = ("Exit action for state \'" + _name);
      String _plus_1 = (_plus + "\'.");
      seq.setComment(_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(state);
      for (final TimeEventSpec tes : _timeEventSpecs) {
        {
          final TimeEvent timeEvent = this.factory.createDerivedEvent(tes);
          final UnscheduleTimeEvent unscheduleStep = this.factory.newUnscheduleTimeEvent(timeEvent);
          EList<Step> _steps = seq.getSteps();
          _steps.add(unscheduleStep);
        }
      }
      List<LocalReaction> _exitReactions = this.sc.exitReactions(state);
      final Function1<LocalReaction,Step> _function = new Function1<LocalReaction,Step>() {
          public Step apply(final LocalReaction lr) {
            Step _mapExitAction = BehaviorMapping.this.mapExitAction(lr);
            return _mapExitAction;
          }
        };
      List<Step> _map = ListExtensions.<LocalReaction, Step>map(_exitReactions, _function);
      final Procedure1<Step> _function_1 = new Procedure1<Step>() {
          public void apply(final Step e) {
            boolean _notEquals = (!Objects.equal(e, null));
            if (_notEquals) {
              EList<Step> _steps = seq.getSteps();
              _steps.add(e);
            }
          }
        };
      IterableExtensions.<Step>forEach(_map, _function_1);
      Sequence _xifexpression = null;
      EList<Step> _steps = seq.getSteps();
      int _size = _steps.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _xifexpression = seq;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Step mapExitAction(final LocalReaction it) {
    Step _xifexpression = null;
    Effect _effect = it.getEffect();
    boolean _notEquals = (!Objects.equal(_effect, null));
    if (_notEquals) {
      Step _xblockexpression = null;
      {
        Effect _effect_1 = it.getEffect();
        Sequence effectSeq = this.mapEffect(((ReactionEffect) _effect_1));
        Trigger _trigger = it.getTrigger();
        Expression guard = this.buildGuard(_trigger);
        Step _xifexpression_1 = null;
        boolean _notEquals_1 = (!Objects.equal(guard, null));
        if (_notEquals_1) {
          Step _xblockexpression_1 = null;
          {
            SexecFactory _factory = this.sexec.factory();
            If ifStep = _factory.createIf();
            SexecFactory _factory_1 = this.sexec.factory();
            Check _createCheck = _factory_1.createCheck();
            ifStep.setCheck(_createCheck);
            Check _check = ifStep.getCheck();
            _check.setCondition(guard);
            ifStep.setThenStep(effectSeq);
            _xblockexpression_1 = (((Step) ifStep));
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          _xifexpression_1 = effectSeq;
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected Sequence _mapEffect(final Effect effect) {
    return null;
  }
  
  protected Sequence _mapEffect(final ReactionEffect effect) {
    EList<Expression> _actions = effect.getActions();
    boolean _isEmpty = _actions.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      SexecFactory _factory = this.sexec.factory();
      final Sequence sequence = _factory.createSequence();
      sequence.setName("reaction_action");
      EList<Step> _steps = sequence.getSteps();
      EList<Expression> _actions_1 = effect.getActions();
      final Function1<Expression,Execution> _function = new Function1<Expression,Execution>() {
          public Execution apply(final Expression stmnt) {
            Execution _mapToExecution = BehaviorMapping.this.mapToExecution(stmnt);
            return _mapToExecution;
          }
        };
      List<Execution> _map = ListExtensions.<Expression, Execution>map(_actions_1, _function);
      _steps.addAll(_map);
      return sequence;
    }
    return null;
  }
  
  public Execution mapToExecution(final Statement stmnt) {
    Execution _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      final Execution exec = _factory.createExecution();
      Statement _copy = EcoreUtil.<Statement>copy(stmnt);
      exec.setStatement(_copy);
      _xblockexpression = (exec);
    }
    return _xblockexpression;
  }
  
  public ExecutionFlow mapTransitions(final Statechart statechart, final ExecutionFlow r) {
    TreeIterator<EObject> content = statechart.eAllContents();
    final Iterator<State> allStates = Iterators.<State>filter(content, State.class);
    final Procedure1<State> _function = new Procedure1<State>() {
        public void apply(final State s) {
          BehaviorMapping.this.mapStateTransition(s);
        }
      };
    IteratorExtensions.<State>forEach(allStates, _function);
    return r;
  }
  
  public ExecutionState mapStateTransition(final State state) {
    final ExecutionState _state = this.factory.create(state);
    EList<Reaction> _reactions = _state.getReactions();
    EList<Transition> _outgoingTransitions = state.getOutgoingTransitions();
    final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
        public Reaction apply(final Transition t) {
          Reaction _mapTransition = BehaviorMapping.this.mapTransition(t);
          return _mapTransition;
        }
      };
    List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
    _reactions.addAll(_map);
    return _state;
  }
  
  public Reaction mapTransition(final Transition t) {
    Vertex _source = t.getSource();
    Vertex _target = t.getTarget();
    return this.mapTransition(t, _source, _target);
  }
  
  protected Reaction _mapTransition(final Transition t, final Vertex source, final Vertex target) {
    final Reaction r = this.factory.create(t);
    Trigger _trigger = t.getTrigger();
    boolean _notEquals = (!Objects.equal(_trigger, null));
    if (_notEquals) {
      Trigger _trigger_1 = t.getTrigger();
      Check _mapToCheck = this.mapToCheck(_trigger_1);
      r.setCheck(_mapToCheck);
    }
    ArrayList<Transition> _newArrayList = CollectionLiterals.<Transition>newArrayList(t);
    Sequence _mapToEffect = this.mapToEffect(_newArrayList, r);
    r.setEffect(_mapToEffect);
    return r;
  }
  
  /**
   * Ignore transitions from pseudostates to synchronization nodes.
   * 
   * TODO: introduce validation
   */
  protected Reaction _mapTransition(final Transition t, final Pseudostate source, final Synchronization target) {
    return null;
  }
  
  /**
   * Transitions to synchronization points are part of joins and must be handled specifically.
   */
  protected Reaction _mapTransition(final Transition t, final State source, final Synchronization target) {
    final Reaction r = this.factory.create(t);
    Trigger _trigger = t.getTrigger();
    boolean _notEquals = (!Objects.equal(_trigger, null));
    if (_notEquals) {
      Trigger _trigger_1 = t.getTrigger();
      Check _mapToCheck = this.mapToCheck(_trigger_1);
      r.setCheck(_mapToCheck);
    } else {
      SexecFactory _sexecFactory = this.factory.sexecFactory();
      Check _createCheck = _sexecFactory.createCheck();
      r.setCheck(_createCheck);
      Check _check = r.getCheck();
      ExecutionSynchronization _create = this.factory.create(target);
      String _name = _create.getName();
      String _plus = (_name + "join_check");
      _check.setName(_plus);
    }
    Check _check_1 = r.getCheck();
    Statement condition = _check_1.getCondition();
    EList<Transition> _incomingTransitions = target.getIncomingTransitions();
    final Function1<Transition,Boolean> _function = new Function1<Transition,Boolean>() {
        public Boolean apply(final Transition jt) {
          Vertex _source = jt.getSource();
          return Boolean.valueOf((_source instanceof State));
        }
      };
    Iterable<Transition> _filter = IterableExtensions.<Transition>filter(_incomingTransitions, _function);
    final Function1<Transition,Integer> _function_1 = new Function1<Transition,Integer>() {
        public Integer apply(final Transition jt) {
          Vertex _source = jt.getSource();
          ExecutionState _create = BehaviorMapping.this.factory.create(((State) _source));
          StateVector _stateVector = _create.getStateVector();
          int _offset = _stateVector.getOffset();
          return Integer.valueOf(_offset);
        }
      };
    final List<Transition> joinTransitions = IterableExtensions.<Transition, Integer>sortBy(_filter, _function_1);
    final Function1<Transition,Boolean> _function_2 = new Function1<Transition,Boolean>() {
        public Boolean apply(final Transition trans) {
          boolean _notEquals = (!Objects.equal(trans, t));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<Transition> _filter_1 = IterableExtensions.<Transition>filter(joinTransitions, _function_2);
    for (final Transition trans : _filter_1) {
      Vertex _source = trans.getSource();
      if ((_source instanceof State)) {
        Vertex _source_1 = trans.getSource();
        Expression _active = this.stext.active(((State) _source_1));
        Statement _conjunct = this.conjunct(condition, _active);
        condition = _conjunct;
        Trigger _trigger_2 = trans.getTrigger();
        boolean _notEquals_1 = (!Objects.equal(_trigger_2, null));
        if (_notEquals_1) {
          Trigger _trigger_3 = trans.getTrigger();
          Statement _buildCondition = this.buildCondition(_trigger_3);
          Statement _conjunct_1 = this.conjunct(condition, _buildCondition);
          condition = _conjunct_1;
        }
      }
    }
    Check _check_2 = r.getCheck();
    _check_2.setCondition(condition);
    Sequence _mapToEffect = this.mapToEffect(joinTransitions, r);
    r.setEffect(_mapToEffect);
    return r;
  }
  
  public ExecutionFlow mapEntries(final Statechart statechart, final ExecutionFlow r) {
    ExecutionFlow _xblockexpression = null;
    {
      EList<ExecutionNode> _nodes = r.getNodes();
      TreeIterator<EObject> _eAllContents = statechart.eAllContents();
      Iterator<Entry> _filter = Iterators.<Entry>filter(_eAllContents, Entry.class);
      final Function1<Entry,ExecutionEntry> _function = new Function1<Entry,ExecutionEntry>() {
          public ExecutionEntry apply(final Entry e) {
            ExecutionEntry _create = BehaviorMapping.this.factory.create(e);
            return _create;
          }
        };
      Iterator<ExecutionEntry> _map = IteratorExtensions.<Entry, ExecutionEntry>map(_filter, _function);
      List<ExecutionEntry> _list = IteratorExtensions.<ExecutionEntry>toList(_map);
      _nodes.addAll(_list);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public Statement conjunct(final Statement c1, final Statement c2) {
    Statement _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(c1, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(c2, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      Expression _and_1 = this.stext.and(((Expression) c1), ((Expression) c2));
      _xifexpression = _and_1;
    } else {
      Statement _xifexpression_1 = null;
      boolean _notEquals_2 = (!Objects.equal(c1, null));
      if (_notEquals_2) {
        _xifexpression_1 = c1;
      } else {
        _xifexpression_1 = c2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected Check _mapToCheck(final Trigger tr) {
    return null;
  }
  
  protected Check _mapToCheck(final ReactionTrigger tr) {
    final Check check = this.factory.createCheck(tr);
    Statement _buildCondition = this.buildCondition(tr);
    check.setCondition(_buildCondition);
    return check;
  }
  
  public ExecutionFlow mapLocalReactions(final Statechart statechart, final ExecutionFlow r) {
    EList<Reaction> _reactions = r.getReactions();
    EList<org.yakindu.sct.model.sgraph.Reaction> _localReactions = statechart.getLocalReactions();
    Iterable<LocalReaction> _filter = Iterables.<LocalReaction>filter(_localReactions, LocalReaction.class);
    final Function1<LocalReaction,Boolean> _function = new Function1<LocalReaction,Boolean>() {
        public Boolean apply(final LocalReaction lr) {
          boolean _or = false;
          Trigger _trigger = lr.getTrigger();
          EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
          boolean _isEmpty = _triggers.isEmpty();
          if (_isEmpty) {
            _or = true;
          } else {
            Trigger _trigger_1 = lr.getTrigger();
            EList<EventSpec> _triggers_1 = ((ReactionTrigger) _trigger_1).getTriggers();
            final Function1<EventSpec,Boolean> _function = new Function1<EventSpec,Boolean>() {
                public Boolean apply(final EventSpec t) {
                  boolean _or = false;
                  boolean _or_1 = false;
                  if ((t instanceof RegularEventSpec)) {
                    _or_1 = true;
                  } else {
                    _or_1 = ((t instanceof RegularEventSpec) || (t instanceof TimeEventSpec));
                  }
                  if (_or_1) {
                    _or = true;
                  } else {
                    _or = (_or_1 || (t instanceof AlwaysEvent));
                  }
                  return Boolean.valueOf(_or);
                }
              };
            Iterable<EventSpec> _filter = IterableExtensions.<EventSpec>filter(_triggers_1, _function);
            boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter);
            boolean _not = (!_isEmpty_1);
            _or = (_isEmpty || _not);
          }
          return Boolean.valueOf(_or);
        }
      };
    Iterable<LocalReaction> _filter_1 = IterableExtensions.<LocalReaction>filter(_filter, _function);
    final Function1<LocalReaction,Reaction> _function_1 = new Function1<LocalReaction,Reaction>() {
        public Reaction apply(final LocalReaction t) {
          Reaction _mapReaction = BehaviorMapping.this.mapReaction(t);
          return _mapReaction;
        }
      };
    Iterable<Reaction> _map = IterableExtensions.<LocalReaction, Reaction>map(_filter_1, _function_1);
    Iterables.<Reaction>addAll(_reactions, _map);
    TreeIterator<EObject> content = statechart.eAllContents();
    final Iterator<State> allStates = Iterators.<State>filter(content, State.class);
    final Procedure1<State> _function_2 = new Procedure1<State>() {
        public void apply(final State s) {
          BehaviorMapping.this.mapStateLocalReactions(((State) s));
        }
      };
    IteratorExtensions.<State>forEach(allStates, _function_2);
    return r;
  }
  
  public ExecutionState mapStateLocalReactions(final State state) {
    final ExecutionState _state = this.factory.create(state);
    EList<Reaction> _reactions = _state.getReactions();
    EList<org.yakindu.sct.model.sgraph.Reaction> _localReactions = state.getLocalReactions();
    Iterable<LocalReaction> _filter = Iterables.<LocalReaction>filter(_localReactions, LocalReaction.class);
    final Function1<LocalReaction,Boolean> _function = new Function1<LocalReaction,Boolean>() {
        public Boolean apply(final LocalReaction lr) {
          boolean _or = false;
          Trigger _trigger = lr.getTrigger();
          EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
          boolean _isEmpty = _triggers.isEmpty();
          if (_isEmpty) {
            _or = true;
          } else {
            Trigger _trigger_1 = lr.getTrigger();
            EList<EventSpec> _triggers_1 = ((ReactionTrigger) _trigger_1).getTriggers();
            final Function1<EventSpec,Boolean> _function = new Function1<EventSpec,Boolean>() {
                public Boolean apply(final EventSpec t) {
                  boolean _or = false;
                  boolean _or_1 = false;
                  if ((t instanceof RegularEventSpec)) {
                    _or_1 = true;
                  } else {
                    _or_1 = ((t instanceof RegularEventSpec) || (t instanceof TimeEventSpec));
                  }
                  if (_or_1) {
                    _or = true;
                  } else {
                    _or = (_or_1 || (t instanceof AlwaysEvent));
                  }
                  return Boolean.valueOf(_or);
                }
              };
            Iterable<EventSpec> _filter = IterableExtensions.<EventSpec>filter(_triggers_1, _function);
            List<EventSpec> _list = IterableExtensions.<EventSpec>toList(_filter);
            boolean _isEmpty_1 = _list.isEmpty();
            boolean _not = (!_isEmpty_1);
            _or = (_isEmpty || _not);
          }
          return Boolean.valueOf(_or);
        }
      };
    Iterable<LocalReaction> _filter_1 = IterableExtensions.<LocalReaction>filter(_filter, _function);
    final Function1<LocalReaction,Reaction> _function_1 = new Function1<LocalReaction,Reaction>() {
        public Reaction apply(final LocalReaction t) {
          Reaction _mapReaction = BehaviorMapping.this.mapReaction(t);
          return _mapReaction;
        }
      };
    Iterable<Reaction> _map = IterableExtensions.<LocalReaction, Reaction>map(_filter_1, _function_1);
    Iterables.<Reaction>addAll(_reactions, _map);
    return _state;
  }
  
  public Reaction mapReaction(final LocalReaction lr) {
    final Reaction r = this.factory.create(lr);
    Trigger _trigger = lr.getTrigger();
    boolean _notEquals = (!Objects.equal(_trigger, null));
    if (_notEquals) {
      Trigger _trigger_1 = lr.getTrigger();
      Check _mapToCheck = this.mapToCheck(_trigger_1);
      r.setCheck(_mapToCheck);
    }
    Sequence _mapToEffect = this.mapToEffect(lr);
    r.setEffect(_mapToEffect);
    return r;
  }
  
  public Sequence mapToEffect(final LocalReaction lr) {
    Sequence _xifexpression = null;
    Effect _effect = lr.getEffect();
    boolean _notEquals = (!Objects.equal(_effect, null));
    if (_notEquals) {
      Effect _effect_1 = lr.getEffect();
      Sequence _mapEffect = this.mapEffect(_effect_1);
      _xifexpression = _mapEffect;
    }
    return _xifexpression;
  }
  
  public Sequence mapToEffect(final Transition t, final Reaction r) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence sequence = _factory.createSequence();
    Iterable<State> _exitStates = this.exitStates(t);
    final State topExitState = IterableExtensions.<State>last(_exitStates);
    boolean _notEquals = (!Objects.equal(topExitState, null));
    if (_notEquals) {
      ExecutionState _create = this.factory.create(topExitState);
      final Sequence exitSequence = _create.getExitSequence();
      boolean _notEquals_1 = (!Objects.equal(exitSequence, null));
      if (_notEquals_1) {
        EList<Step> _steps = sequence.getSteps();
        Call _newCall = this.factory.newCall(exitSequence);
        _steps.add(_newCall);
      }
    }
    Effect _effect = t.getEffect();
    boolean _notEquals_2 = (!Objects.equal(_effect, null));
    if (_notEquals_2) {
      EList<Step> _steps_1 = sequence.getSteps();
      Effect _effect_1 = t.getEffect();
      Sequence _mapEffect = this.mapEffect(_effect_1);
      _steps_1.add(_mapEffect);
    }
    boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
    if (_isAddTraceSteps) {
      EList<Step> _steps_2 = sequence.getSteps();
      ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(r);
      _steps_2.add(_newTraceReactionFired);
    }
    EList<Step> _steps_3 = sequence.getSteps();
    ArrayList<Transition> _newArrayList = CollectionLiterals.<Transition>newArrayList(t);
    Sequence _mapToStateConfigurationEnterSequence = this.mapToStateConfigurationEnterSequence(_newArrayList);
    EList<Step> _steps_4 = _mapToStateConfigurationEnterSequence.getSteps();
    _steps_3.addAll(_steps_4);
    return sequence;
  }
  
  /**
   * Creates a compound effect that can consist of multiple transitions.
   */
  public Sequence mapToEffect(final List<Transition> transitions, final Reaction r) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence sequence = _factory.createSequence();
    Transition _get = transitions.get(0);
    Iterable<State> _exitStates = this.exitStates(_get);
    final List<State> exitStates = IterableExtensions.<State>toList(_exitStates);
    for (final Transition t : transitions) {
      Iterable<State> _exitStates_1 = this.exitStates(t);
      List<State> _list = IterableExtensions.<State>toList(_exitStates_1);
      exitStates.retainAll(_list);
    }
    final State topExitState = IterableExtensions.<State>last(exitStates);
    boolean _notEquals = (!Objects.equal(topExitState, null));
    if (_notEquals) {
      ExecutionState _create = this.factory.create(topExitState);
      final Sequence exitSequence = _create.getExitSequence();
      boolean _notEquals_1 = (!Objects.equal(exitSequence, null));
      if (_notEquals_1) {
        EList<Step> _steps = sequence.getSteps();
        Call _newCall = this.factory.newCall(exitSequence);
        _steps.add(_newCall);
      }
    }
    for (final Transition t_1 : transitions) {
      {
        Effect _effect = t_1.getEffect();
        boolean _notEquals_2 = (!Objects.equal(_effect, null));
        if (_notEquals_2) {
          EList<Step> _steps_1 = sequence.getSteps();
          Effect _effect_1 = t_1.getEffect();
          Sequence _mapEffect = this.mapEffect(_effect_1);
          _steps_1.add(_mapEffect);
        }
        boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
        if (_isAddTraceSteps) {
          EList<Step> _steps_2 = sequence.getSteps();
          Reaction _create_1 = this.factory.create(t_1);
          ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(_create_1);
          _steps_2.add(_newTraceReactionFired);
        }
      }
    }
    EList<Step> _steps_1 = sequence.getSteps();
    Sequence _mapToStateConfigurationEnterSequence = this.mapToStateConfigurationEnterSequence(transitions);
    EList<Step> _steps_2 = _mapToStateConfigurationEnterSequence.getSteps();
    _steps_1.addAll(_steps_2);
    return sequence;
  }
  
  /**
   * Calcuates a sequence to enter one or more states. Entering multiple states is required for fork, where parts of a state
   * configuration is specified.
   */
  public Sequence mapToStateConfigurationEnterSequence(final List<Transition> transitions) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence sequence = _factory.createSequence();
    Transition _get = transitions.get(0);
    List<ExecutionScope> _entryScopes = this.entryScopes(_get);
    Iterable<ExecutionScope> _drop = IterableExtensions.<ExecutionScope>drop(_entryScopes, 1);
    List<ExecutionScope> _list = IterableExtensions.<ExecutionScope>toList(_drop);
    final List<ExecutionScope> entryScopes = ListExtensions.<ExecutionScope>reverse(_list);
    for (final Transition t : transitions) {
      List<ExecutionScope> _entryScopes_1 = this.entryScopes(t);
      entryScopes.retainAll(_entryScopes_1);
    }
    final ExecutionScope entryScope = IterableExtensions.<ExecutionScope>head(entryScopes);
    final Function1<Transition,ExecutionNode> _function = new Function1<Transition,ExecutionNode>() {
        public ExecutionNode apply(final Transition t) {
          Vertex _target = t.getTarget();
          ExecutionNode _mapped = BehaviorMapping.this.factory.mapped(_target);
          return _mapped;
        }
      };
    final List<ExecutionNode> targets = ListExtensions.<Transition, ExecutionNode>map(transitions, _function);
    boolean _notEquals = (!Objects.equal(entryScope, null));
    if (_notEquals) {
      this.addEnterStepsForTargetsToSequence(entryScope, targets, sequence);
    } else {
      for (final ExecutionNode t_1 : targets) {
        this.addEnterStepsForTargetsToSequence(t_1, targets, sequence);
      }
    }
    return sequence;
  }
  
  protected void _addEnterStepsForTargetsToSequence(final ExecutionState it, final List<ExecutionNode> targets, final Sequence seq) {
    boolean _contains = targets.contains(it);
    if (_contains) {
      EList<Step> _steps = seq.getSteps();
      Sequence _enterSequence = it.getEnterSequence();
      Call _newCall = this.factory.newCall(_enterSequence);
      _steps.add(_newCall);
    } else {
      Step _entryAction = it.getEntryAction();
      boolean _notEquals = (!Objects.equal(_entryAction, null));
      if (_notEquals) {
        EList<Step> _steps_1 = seq.getSteps();
        Step _entryAction_1 = it.getEntryAction();
        Call _newCall_1 = this.factory.newCall(_entryAction_1);
        _steps_1.add(_newCall_1);
      }
      boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
      if (_isAddTraceSteps) {
        EList<Step> _steps_2 = seq.getSteps();
        TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(it);
        _steps_2.add(_newTraceStateEntered);
      }
      EList<ExecutionScope> _subScopes = it.getSubScopes();
      for (final ExecutionScope subScope : _subScopes) {
        this.addEnterStepsForTargetsToSequence(subScope, targets, seq);
      }
    }
  }
  
  protected void _addEnterStepsForTargetsToSequence(final ExecutionRegion it, final List<ExecutionNode> targets, final Sequence seq) {
    final Function1<ExecutionNode,Boolean> _function = new Function1<ExecutionNode,Boolean>() {
        public Boolean apply(final ExecutionNode t) {
          EList<ExecutionNode> _nodes = it.getNodes();
          boolean _contains = _nodes.contains(t);
          return Boolean.valueOf(_contains);
        }
      };
    Iterable<ExecutionNode> _filter = IterableExtensions.<ExecutionNode>filter(targets, _function);
    final ExecutionNode target = IterableExtensions.<ExecutionNode>head(_filter);
    boolean _notEquals = (!Objects.equal(target, null));
    if (_notEquals) {
      this.addEnterStepsForTargetsToSequence(target, targets, seq);
      return;
    }
    Set<ExecutionNode> _allNodes = this.allNodes(it);
    final Function1<ExecutionNode,Boolean> _function_1 = new Function1<ExecutionNode,Boolean>() {
        public Boolean apply(final ExecutionNode n) {
          boolean _contains = targets.contains(n);
          return Boolean.valueOf(_contains);
        }
      };
    boolean _exists = IterableExtensions.<ExecutionNode>exists(_allNodes, _function_1);
    if (_exists) {
      EList<ExecutionScope> _subScopes = it.getSubScopes();
      for (final ExecutionScope s : _subScopes) {
        Set<ExecutionNode> _allNodes_1 = this.allNodes(s);
        final Function1<ExecutionNode,Boolean> _function_2 = new Function1<ExecutionNode,Boolean>() {
            public Boolean apply(final ExecutionNode n) {
              boolean _contains = targets.contains(n);
              return Boolean.valueOf(_contains);
            }
          };
        boolean _exists_1 = IterableExtensions.<ExecutionNode>exists(_allNodes_1, _function_2);
        if (_exists_1) {
          this.addEnterStepsForTargetsToSequence(s, targets, seq);
        }
      }
    } else {
      EList<Step> _steps = seq.getSteps();
      Sequence _enterSequence = it.getEnterSequence();
      Call _newCall = this.factory.newCall(_enterSequence);
      _steps.add(_newCall);
    }
  }
  
  protected Set<ExecutionNode> _allNodes(final ExecutionRegion it) {
    HashSet<ExecutionNode> _xblockexpression = null;
    {
      HashSet<ExecutionNode> _hashSet = new HashSet<ExecutionNode>();
      final HashSet<ExecutionNode> allNodes = _hashSet;
      EList<ExecutionNode> _nodes = it.getNodes();
      Iterables.<ExecutionNode>addAll(allNodes, _nodes);
      EList<ExecutionScope> _subScopes = it.getSubScopes();
      for (final ExecutionScope s : _subScopes) {
        Set<ExecutionNode> _allNodes = this.allNodes(s);
        Iterables.<ExecutionNode>addAll(allNodes, _allNodes);
      }
      _xblockexpression = (allNodes);
    }
    return _xblockexpression;
  }
  
  protected Set<ExecutionNode> _allNodes(final ExecutionState it) {
    HashSet<ExecutionNode> _xblockexpression = null;
    {
      HashSet<ExecutionNode> _hashSet = new HashSet<ExecutionNode>();
      final HashSet<ExecutionNode> allNodes = _hashSet;
      allNodes.add(it);
      EList<ExecutionScope> _subScopes = it.getSubScopes();
      for (final ExecutionScope s : _subScopes) {
        Set<ExecutionNode> _allNodes = this.allNodes(s);
        Iterables.<ExecutionNode>addAll(allNodes, _allNodes);
      }
      _xblockexpression = (allNodes);
    }
    return _xblockexpression;
  }
  
  protected void _addEnterStepsForTargetsToSequence(final ExecutionChoice it, final List<ExecutionNode> targets, final Sequence seq) {
    EList<Step> _steps = seq.getSteps();
    Sequence _reactSequence = it.getReactSequence();
    Call _newCall = this.factory.newCall(_reactSequence);
    _steps.add(_newCall);
  }
  
  protected void _addEnterStepsForTargetsToSequence(final ExecutionEntry it, final List<ExecutionNode> targets, final Sequence seq) {
    EList<Step> _steps = seq.getSteps();
    Sequence _reactSequence = it.getReactSequence();
    Call _newCall = this.factory.newCall(_reactSequence);
    _steps.add(_newCall);
  }
  
  protected void _addEnterStepsForTargetsToSequence(final ExecutionSynchronization it, final List<ExecutionNode> targets, final Sequence seq) {
    EList<Step> _steps = seq.getSteps();
    Sequence _reactSequence = it.getReactSequence();
    Call _newCall = this.factory.newCall(_reactSequence);
    _steps.add(_newCall);
  }
  
  public List<ExecutionScope> entryScopes(final Transition t) {
    List<ExecutionScope> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      final List<EObject> l = this.sgraph.containers(_target);
      Vertex _source = t.getSource();
      List<EObject> _containers = this.sgraph.containers(_source);
      l.removeAll(_containers);
      final Function1<EObject,ExecutionScope> _function = new Function1<EObject,ExecutionScope>() {
          public ExecutionScope apply(final EObject c) {
            ExecutionScope _xifexpression = null;
            if ((c instanceof RegularState)) {
              ExecutionState _create = BehaviorMapping.this.factory.create(((RegularState) c));
              _xifexpression = ((ExecutionScope) _create);
            } else {
              ExecutionScope _xifexpression_1 = null;
              if ((c instanceof Region)) {
                ExecutionRegion _create_1 = BehaviorMapping.this.factory.create(((Region) c));
                _xifexpression_1 = ((ExecutionScope) _create_1);
              } else {
                ExecutionScope _xifexpression_2 = null;
                if ((c instanceof Statechart)) {
                  ExecutionFlow _create_2 = BehaviorMapping.this.factory.create(((Statechart) c));
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
  
  public Iterable<State> exitStates(final Transition t) {
    Iterable<State> _xblockexpression = null;
    {
      Vertex _source = t.getSource();
      final List<EObject> l = this.sgraph.containers(_source);
      Vertex _target = t.getTarget();
      List<EObject> _containers = this.sgraph.containers(_target);
      l.removeAll(_containers);
      Vertex _source_1 = t.getSource();
      Vertex _target_1 = t.getTarget();
      boolean _equals = Objects.equal(_source_1, _target_1);
      if (_equals) {
        Vertex _source_2 = t.getSource();
        l.add(0, _source_2);
      }
      Iterable<State> _filter = Iterables.<State>filter(l, State.class);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  public Iterable<State> entryStates(final Transition t) {
    Iterable<State> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      final List<EObject> l = this.sgraph.containers(_target);
      Vertex _source = t.getSource();
      List<EObject> _containers = this.sgraph.containers(_source);
      l.removeAll(_containers);
      Iterable<State> _filter = Iterables.<State>filter(l, State.class);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  public Iterable<ExecutionScope> exitScopes(final Transition t) {
    Iterable<ExecutionScope> _xblockexpression = null;
    {
      final Vertex source = t.getSource();
      ExecutionState _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (source instanceof RegularState) {
          final RegularState _regularState = (RegularState)source;
          _matched=true;
          ExecutionState _create = this.factory.create(_regularState);
          _switchResult = _create;
        }
      }
      ExecutionState executionSource = _switchResult;
      ExecutionState _switchResult_1 = null;
      boolean _matched_1 = false;
      if (!_matched_1) {
        if (source instanceof RegularState) {
          final RegularState _regularState = (RegularState)source;
          _matched_1=true;
          ExecutionState _create = this.factory.create(_regularState);
          _switchResult_1 = _create;
        }
      }
      ExecutionState executionTarget = _switchResult_1;
      final List<EObject> l = this.sgraph.containers(executionSource);
      List<EObject> _containers = this.sgraph.containers(executionTarget);
      l.removeAll(_containers);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Statement _buildCondition(final Trigger t) {
    return null;
  }
  
  protected Statement _buildCondition(final DefaultTrigger t) {
    StextFactory _factory = this.stext.factory();
    final PrimitiveValueExpression r = _factory.createPrimitiveValueExpression();
    StextFactory _factory_1 = this.stext.factory();
    final BoolLiteral boolLit = _factory_1.createBoolLiteral();
    boolLit.setValue(true);
    r.setValue(boolLit);
    return r;
  }
  
  protected Statement _buildCondition(final ReactionTrigger t) {
    Expression _xblockexpression = null;
    {
      Expression _xifexpression = null;
      EList<EventSpec> _triggers = t.getTriggers();
      boolean _isEmpty = _triggers.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<EventSpec> _triggers_1 = t.getTriggers();
        List<EventSpec> _reverseView = ListExtensions.<EventSpec>reverseView(_triggers_1);
        final Function2<Expression,EventSpec,Expression> _function = new Function2<Expression,EventSpec,Expression>() {
            public Expression apply(final Expression s, final EventSpec e) {
              Expression _xblockexpression = null;
              {
                final Expression raised = BehaviorMapping.this.factory.raised(e);
                Expression _xifexpression = null;
                boolean _equals = Objects.equal(raised, null);
                if (_equals) {
                  _xifexpression = s;
                } else {
                  Expression _xifexpression_1 = null;
                  boolean _equals_1 = Objects.equal(s, null);
                  if (_equals_1) {
                    _xifexpression_1 = raised;
                  } else {
                    Expression _or = BehaviorMapping.this.stext.or(raised, s);
                    _xifexpression_1 = _or;
                  }
                  _xifexpression = _xifexpression_1;
                }
                _xblockexpression = (_xifexpression);
              }
              return _xblockexpression;
            }
          };
        Expression _fold = IterableExtensions.<EventSpec, Expression>fold(_reverseView, ((Expression) null), _function);
        _xifexpression = _fold;
      } else {
        _xifexpression = null;
      }
      final Expression triggerCheck = _xifexpression;
      final Expression guard = this.buildGuard(t);
      Expression _xifexpression_1 = null;
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(triggerCheck, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(guard, null));
        _and = (_notEquals && _notEquals_1);
      }
      if (_and) {
        Expression _and_1 = this.stext.and(triggerCheck, guard);
        _xifexpression_1 = _and_1;
      } else {
        Expression _xifexpression_2 = null;
        boolean _notEquals_2 = (!Objects.equal(triggerCheck, null));
        if (_notEquals_2) {
          _xifexpression_2 = triggerCheck;
        } else {
          _xifexpression_2 = guard;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
  
  protected Expression _buildGuard(final Trigger t) {
    return null;
  }
  
  protected Expression _buildGuard(final ReactionTrigger t) {
    Expression _xifexpression = null;
    Expression _guardExpression = t.getGuardExpression();
    boolean _notEquals = (!Objects.equal(_guardExpression, null));
    if (_notEquals) {
      Expression _guardExpression_1 = t.getGuardExpression();
      Expression _copy = EcoreUtil.<Expression>copy(_guardExpression_1);
      _xifexpression = _copy;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public Sequence mapEffect(final Effect effect) {
    if (effect instanceof ReactionEffect) {
      return _mapEffect((ReactionEffect)effect);
    } else if (effect != null) {
      return _mapEffect(effect);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(effect).toString());
    }
  }
  
  public Reaction mapTransition(final Transition t, final Vertex source, final Vertex target) {
    if (source instanceof State
         && target instanceof Synchronization) {
      return _mapTransition(t, (State)source, (Synchronization)target);
    } else if (source instanceof Pseudostate
         && target instanceof Synchronization) {
      return _mapTransition(t, (Pseudostate)source, (Synchronization)target);
    } else if (source != null
         && target != null) {
      return _mapTransition(t, source, target);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, source, target).toString());
    }
  }
  
  public Check mapToCheck(final Trigger tr) {
    if (tr instanceof ReactionTrigger) {
      return _mapToCheck((ReactionTrigger)tr);
    } else if (tr != null) {
      return _mapToCheck(tr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tr).toString());
    }
  }
  
  public void addEnterStepsForTargetsToSequence(final EObject it, final List<ExecutionNode> targets, final Sequence seq) {
    if (it instanceof ExecutionChoice) {
      _addEnterStepsForTargetsToSequence((ExecutionChoice)it, targets, seq);
      return;
    } else if (it instanceof ExecutionEntry) {
      _addEnterStepsForTargetsToSequence((ExecutionEntry)it, targets, seq);
      return;
    } else if (it instanceof ExecutionRegion) {
      _addEnterStepsForTargetsToSequence((ExecutionRegion)it, targets, seq);
      return;
    } else if (it instanceof ExecutionState) {
      _addEnterStepsForTargetsToSequence((ExecutionState)it, targets, seq);
      return;
    } else if (it instanceof ExecutionSynchronization) {
      _addEnterStepsForTargetsToSequence((ExecutionSynchronization)it, targets, seq);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, targets, seq).toString());
    }
  }
  
  public Set<ExecutionNode> allNodes(final ExecutionScope it) {
    if (it instanceof ExecutionRegion) {
      return _allNodes((ExecutionRegion)it);
    } else if (it instanceof ExecutionState) {
      return _allNodes((ExecutionState)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public Statement buildCondition(final Trigger t) {
    if (t instanceof DefaultTrigger) {
      return _buildCondition((DefaultTrigger)t);
    } else if (t instanceof ReactionTrigger) {
      return _buildCondition((ReactionTrigger)t);
    } else if (t != null) {
      return _buildCondition(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public Expression buildGuard(final Trigger t) {
    if (t instanceof ReactionTrigger) {
      return _buildGuard((ReactionTrigger)t);
    } else if (t != null) {
      return _buildGuard(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
}
