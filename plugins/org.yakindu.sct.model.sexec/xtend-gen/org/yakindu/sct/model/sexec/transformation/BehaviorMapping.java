package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExecutionSynchronization;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
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
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
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
    String _plus = ObjectExtensions.operator_plus("Entry action for statechart \'", _name);
    String _plus_1 = ObjectExtensions.operator_plus(_plus, "\'.");
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
          boolean _notEquals = ObjectExtensions.operator_notEquals(_effect, null);
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
          boolean _notEquals = ObjectExtensions.operator_notEquals(e, null);
          if (_notEquals) {
            EList<Step> _steps = seq.getSteps();
            _steps.add(e);
          }
        }
      };
    IterableExtensions.<Sequence>forEach(_map, _function_1);
    r.setEntryAction(seq);
    List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
    final Iterable<State> allStates = IterableExtensions.<State>filter(_allRegularStates, State.class);
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
      String _plus = ObjectExtensions.operator_plus("Entry action for state \'", _name);
      String _plus_1 = ObjectExtensions.operator_plus(_plus, "\'.");
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
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _notEquals = ObjectExtensions.operator_notEquals(_effect, null);
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
            boolean _notEquals = ObjectExtensions.operator_notEquals(e, null);
            if (_notEquals) {
              EList<Step> _steps = seq.getSteps();
              _steps.add(e);
            }
          }
        };
      IterableExtensions.<Sequence>forEach(_map, _function_1);
      Sequence _xifexpression = null;
      EList<Step> _steps = seq.getSteps();
      int _size = _steps.size();
      boolean _greaterThan = IntegerExtensions.operator_greaterThan(_size, 0);
      if (_greaterThan) {
        _xifexpression = seq;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
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
    EList<Reaction> _reactions = _sync.getReactions();
    EList<Transition> _outgoingTransitions = sync.getOutgoingTransitions();
    final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
        public Reaction apply(final Transition t) {
          Reaction _mapTransition = BehaviorMapping.this.mapTransition(t);
          return _mapTransition;
        }
      };
    List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
    _reactions.addAll(_map);
    return _sync;
  }
  
  public ExecutionFlow mapExitActions(final Statechart statechart, final ExecutionFlow r) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("exitAction");
    String _name = statechart.getName();
    String _plus = ObjectExtensions.operator_plus("Exit action for state \'", _name);
    String _plus_1 = ObjectExtensions.operator_plus(_plus, "\'.");
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
          boolean _notEquals = ObjectExtensions.operator_notEquals(_effect, null);
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
          boolean _notEquals = ObjectExtensions.operator_notEquals(e, null);
          if (_notEquals) {
            EList<Step> _steps = seq.getSteps();
            _steps.add(e);
          }
        }
      };
    IterableExtensions.<Sequence>forEach(_map, _function_1);
    r.setExitAction(seq);
    List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
    final Iterable<State> allStates = IterableExtensions.<State>filter(_allRegularStates, State.class);
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
      String _plus = ObjectExtensions.operator_plus("Exit action for state \'", _name);
      String _plus_1 = ObjectExtensions.operator_plus(_plus, "\'.");
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
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _notEquals = ObjectExtensions.operator_notEquals(_effect, null);
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
            boolean _notEquals = ObjectExtensions.operator_notEquals(e, null);
            if (_notEquals) {
              EList<Step> _steps = seq.getSteps();
              _steps.add(e);
            }
          }
        };
      IterableExtensions.<Sequence>forEach(_map, _function_1);
      Sequence _xifexpression = null;
      EList<Step> _steps = seq.getSteps();
      int _size = _steps.size();
      boolean _greaterThan = IntegerExtensions.operator_greaterThan(_size, 0);
      if (_greaterThan) {
        _xifexpression = seq;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected Sequence _mapEffect(final Effect effect) {
    return null;
  }
  
  protected Sequence _mapEffect(final ReactionEffect effect) {
    EList<Expression> _actions = effect.getActions();
    boolean _isEmpty = _actions.isEmpty();
    boolean _not = BooleanExtensions.operator_not(_isEmpty);
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
    final Iterator<State> allStates = IteratorExtensions.<State>filter(content, State.class);
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
    boolean _notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
    if (_notEquals) {
      Trigger _trigger_1 = t.getTrigger();
      Check _mapToCheck = this.mapToCheck(_trigger_1);
      r.setCheck(_mapToCheck);
    }
    Sequence _mapToEffect = this.mapToEffect(t, r);
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
    boolean _notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
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
      String _plus = ObjectExtensions.operator_plus(_name, "join_check");
      _check.setName(_plus);
    }
    Check _check_1 = r.getCheck();
    Statement condition = _check_1.getCondition();
    EList<Transition> _incomingTransitions = target.getIncomingTransitions();
    final Function1<Transition,Boolean> _function = new Function1<Transition,Boolean>() {
        public Boolean apply(final Transition trans) {
          boolean _notEquals = ObjectExtensions.operator_notEquals(trans, t);
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<Transition> _filter = IterableExtensions.<Transition>filter(_incomingTransitions, _function);
    for (final Transition trans : _filter) {
      Vertex _source = trans.getSource();
      if ((_source instanceof State)) {
        Vertex _source_1 = trans.getSource();
        Expression _active = this.stext.active(((State) _source_1));
        Statement _conjunct = this.conjunct(condition, _active);
        condition = _conjunct;
        Trigger _trigger_2 = trans.getTrigger();
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_trigger_2, null);
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
    Sequence _mapToEffect = this.mapToEffect(t, r);
    r.setEffect(_mapToEffect);
    return r;
  }
  
  public Statement conjunct(final Statement c1, final Statement c2) {
    Statement _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = ObjectExtensions.operator_notEquals(c1, null);
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(c2, null);
      _and = BooleanExtensions.operator_and(_notEquals, _notEquals_1);
    }
    if (_and) {
      Expression _and_1 = this.stext.and(((Expression) c1), ((Expression) c2));
      _xifexpression = _and_1;
    } else {
      Statement _xifexpression_1 = null;
      boolean _notEquals_2 = ObjectExtensions.operator_notEquals(c1, null);
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
    Iterable<LocalReaction> _filter = IterableExtensions.<LocalReaction>filter(_localReactions, LocalReaction.class);
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
                  boolean _or_2 = false;
                  if ((t instanceof RegularEventSpec)) {
                    _or_2 = true;
                  } else {
                    _or_2 = BooleanExtensions.operator_or(
                      (t instanceof RegularEventSpec), (t instanceof TimeEventSpec));
                  }
                  if (_or_2) {
                    _or_1 = true;
                  } else {
                    _or_1 = BooleanExtensions.operator_or(_or_2, (t instanceof OnCycleEvent));
                  }
                  if (_or_1) {
                    _or = true;
                  } else {
                    _or = BooleanExtensions.operator_or(_or_1, (t instanceof AlwaysEvent));
                  }
                  return Boolean.valueOf(_or);
                }
              };
            Iterable<EventSpec> _filter = IterableExtensions.<EventSpec>filter(_triggers_1, _function);
            boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter);
            boolean _not = BooleanExtensions.operator_not(_isEmpty_1);
            _or = BooleanExtensions.operator_or(_isEmpty, _not);
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
    CollectionExtensions.<Reaction>addAll(_reactions, _map);
    TreeIterator<EObject> content = statechart.eAllContents();
    final Iterator<State> allStates = IteratorExtensions.<State>filter(content, State.class);
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
    Iterable<LocalReaction> _filter = IterableExtensions.<LocalReaction>filter(_localReactions, LocalReaction.class);
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
                  boolean _or_2 = false;
                  if ((t instanceof RegularEventSpec)) {
                    _or_2 = true;
                  } else {
                    _or_2 = BooleanExtensions.operator_or(
                      (t instanceof RegularEventSpec), (t instanceof TimeEventSpec));
                  }
                  if (_or_2) {
                    _or_1 = true;
                  } else {
                    _or_1 = BooleanExtensions.operator_or(_or_2, (t instanceof OnCycleEvent));
                  }
                  if (_or_1) {
                    _or = true;
                  } else {
                    _or = BooleanExtensions.operator_or(_or_1, (t instanceof AlwaysEvent));
                  }
                  return Boolean.valueOf(_or);
                }
              };
            Iterable<EventSpec> _filter = IterableExtensions.<EventSpec>filter(_triggers_1, _function);
            List<EventSpec> _list = IterableExtensions.<EventSpec>toList(_filter);
            boolean _isEmpty_1 = _list.isEmpty();
            boolean _not = BooleanExtensions.operator_not(_isEmpty_1);
            _or = BooleanExtensions.operator_or(_isEmpty, _not);
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
    CollectionExtensions.<Reaction>addAll(_reactions, _map);
    return _state;
  }
  
  public Reaction mapReaction(final LocalReaction lr) {
    final Reaction r = this.factory.create(lr);
    Trigger _trigger = lr.getTrigger();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
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
    boolean _notEquals = ObjectExtensions.operator_notEquals(_effect, null);
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
    boolean _notEquals = ObjectExtensions.operator_notEquals(topExitState, null);
    if (_notEquals) {
      ExecutionState _create = this.factory.create(topExitState);
      final Sequence exitSequence = _create.getExitSequence();
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(exitSequence, null);
      if (_notEquals_1) {
        EList<Step> _steps = sequence.getSteps();
        Call _newCall = this.factory.newCall(exitSequence);
        _steps.add(_newCall);
      }
    }
    Effect _effect = t.getEffect();
    boolean _notEquals_2 = ObjectExtensions.operator_notEquals(_effect, null);
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
      CollectionExtensions.<ReactionFired>operator_add(_steps_2, _newTraceReactionFired);
    }
    List<ExecutionScope> _entryScopes = this.entryScopes(t);
    Iterable<ExecutionScope> _drop = IterableExtensions.<ExecutionScope>drop(_entryScopes, 1);
    List<ExecutionScope> _list = IterableExtensions.<ExecutionScope>toList(_drop);
    List<ExecutionScope> _reverse = ListExtensions.<ExecutionScope>reverse(_list);
    final Function2<Sequence,ExecutionScope,Sequence> _function = new Function2<Sequence,ExecutionScope,Sequence>() {
        public Sequence apply(final Sequence seq, final ExecutionScope scope) {
          Sequence _xblockexpression = null;
          {
            if ((scope instanceof ExecutionRegion)) {
              ExecutionScope _superScope = scope.getSuperScope();
              final EList<ExecutionScope> siblingRegions = _superScope.getSubScopes();
              int _indexOf = siblingRegions.indexOf(scope);
              Iterable<ExecutionScope> _take = IterableExtensions.<ExecutionScope>take(siblingRegions, _indexOf);
              for (final ExecutionScope region : _take) {
                Sequence _enterSequence = region.getEnterSequence();
                boolean _notEquals = ObjectExtensions.operator_notEquals(_enterSequence, null);
                if (_notEquals) {
                  EList<Step> _steps = seq.getSteps();
                  Sequence _enterSequence_1 = region.getEnterSequence();
                  Call _newCall = BehaviorMapping.this.factory.newCall(_enterSequence_1);
                  _steps.add(_newCall);
                }
              }
            }
            if ((scope instanceof ExecutionState)) {
              Step _entryAction = ((ExecutionState) scope).getEntryAction();
              boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_entryAction, null);
              if (_notEquals_1) {
                EList<Step> _steps_1 = seq.getSteps();
                Step _entryAction_1 = ((ExecutionState) scope).getEntryAction();
                Call _newCall_1 = BehaviorMapping.this.factory.newCall(_entryAction_1);
                _steps_1.add(_newCall_1);
              }
              boolean _isAddTraceSteps = BehaviorMapping.this.trace.isAddTraceSteps();
              if (_isAddTraceSteps) {
                EList<Step> _steps_2 = seq.getSteps();
                TraceStateEntered _newTraceStateEntered = BehaviorMapping.this.trace.newTraceStateEntered(((ExecutionState) scope));
                _steps_2.add(_newTraceStateEntered);
              }
            }
            _xblockexpression = (seq);
          }
          return _xblockexpression;
        }
      };
    IterableExtensions.<ExecutionScope, Sequence>fold(_reverse, sequence, _function);
    Vertex _target = t.getTarget();
    boolean _notEquals_3 = ObjectExtensions.operator_notEquals(_target, null);
    if (_notEquals_3) {
      Vertex _target_1 = t.getTarget();
      if ((_target_1 instanceof RegularState)) {
        EList<Step> _steps_3 = sequence.getSteps();
        Vertex _target_2 = t.getTarget();
        ExecutionState _create_1 = this.factory.create(((RegularState) _target_2));
        Sequence _enterSequence = _create_1.getEnterSequence();
        Call _newCall_1 = this.factory.newCall(_enterSequence);
        _steps_3.add(_newCall_1);
      } else {
        Vertex _target_3 = t.getTarget();
        if ((_target_3 instanceof Choice)) {
          EList<Step> _steps_4 = sequence.getSteps();
          Vertex _target_4 = t.getTarget();
          ExecutionChoice _create_2 = this.factory.create(((Choice) _target_4));
          Sequence _reactSequence = _create_2.getReactSequence();
          Call _newCall_2 = this.factory.newCall(_reactSequence);
          _steps_4.add(_newCall_2);
        } else {
          Vertex _target_5 = t.getTarget();
          if ((_target_5 instanceof Entry)) {
            EList<Step> _steps_5 = sequence.getSteps();
            Vertex _target_6 = t.getTarget();
            ExecutionEntry _create_3 = this.factory.create(((Entry) _target_6));
            Sequence _reactSequence_1 = _create_3.getReactSequence();
            Call _newCall_3 = this.factory.newCall(_reactSequence_1);
            _steps_5.add(_newCall_3);
          } else {
            Vertex _target_7 = t.getTarget();
            if ((_target_7 instanceof Synchronization)) {
              EList<Step> _steps_6 = sequence.getSteps();
              Vertex _target_8 = t.getTarget();
              ExecutionSynchronization _create_4 = this.factory.create(((Synchronization) _target_8));
              Sequence _reactSequence_2 = _create_4.getReactSequence();
              Call _newCall_4 = this.factory.newCall(_reactSequence_2);
              _steps_6.add(_newCall_4);
            }
          }
        }
      }
    }
    List<ExecutionScope> _entryScopes_1 = this.entryScopes(t);
    Iterable<ExecutionScope> _drop_1 = IterableExtensions.<ExecutionScope>drop(_entryScopes_1, 1);
    final Function2<Sequence,ExecutionScope,Sequence> _function_1 = new Function2<Sequence,ExecutionScope,Sequence>() {
        public Sequence apply(final Sequence seq, final ExecutionScope scope) {
          Sequence _xblockexpression = null;
          {
            if ((scope instanceof ExecutionRegion)) {
              ExecutionScope _superScope = scope.getSuperScope();
              final EList<ExecutionScope> siblingRegions = _superScope.getSubScopes();
              int _indexOf = siblingRegions.indexOf(scope);
              int _plus = IntegerExtensions.operator_plus(_indexOf, 1);
              Iterable<ExecutionScope> _drop = IterableExtensions.<ExecutionScope>drop(siblingRegions, _plus);
              for (final ExecutionScope region : _drop) {
                Sequence _enterSequence = region.getEnterSequence();
                boolean _notEquals = ObjectExtensions.operator_notEquals(_enterSequence, null);
                if (_notEquals) {
                  EList<Step> _steps = seq.getSteps();
                  Sequence _enterSequence_1 = region.getEnterSequence();
                  Call _newCall = BehaviorMapping.this.factory.newCall(_enterSequence_1);
                  _steps.add(_newCall);
                }
              }
            }
            _xblockexpression = (seq);
          }
          return _xblockexpression;
        }
      };
    IterableExtensions.<ExecutionScope, Sequence>fold(_drop_1, sequence, _function_1);
    return sequence;
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
      Iterable<State> _filter = IterableExtensions.<State>filter(l, State.class);
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
      Iterable<State> _filter = IterableExtensions.<State>filter(l, State.class);
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
  
  protected Statement _buildCondition(final ReactionTrigger t) {
    Expression _xblockexpression = null;
    {
      Expression _xifexpression = null;
      EList<EventSpec> _triggers = t.getTriggers();
      boolean _isEmpty = _triggers.isEmpty();
      boolean _not = BooleanExtensions.operator_not(_isEmpty);
      if (_not) {
        EList<EventSpec> _triggers_1 = t.getTriggers();
        List<EventSpec> _reverseView = ListExtensions.<EventSpec>reverseView(_triggers_1);
        final Function2<Expression,EventSpec,Expression> _function = new Function2<Expression,EventSpec,Expression>() {
            public Expression apply(final Expression s, final EventSpec e) {
              Expression _xblockexpression = null;
              {
                final Expression raised = BehaviorMapping.this.factory.raised(e);
                Expression _xifexpression = null;
                boolean _equals = ObjectExtensions.operator_equals(raised, null);
                if (_equals) {
                  _xifexpression = s;
                } else {
                  Expression _xifexpression_1 = null;
                  boolean _equals_1 = ObjectExtensions.operator_equals(s, null);
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
      Expression _xifexpression_1 = null;
      Expression _guardExpression = t.getGuardExpression();
      boolean _notEquals = ObjectExtensions.operator_notEquals(_guardExpression, null);
      if (_notEquals) {
        Expression _guardExpression_1 = t.getGuardExpression();
        Expression _copy = EcoreUtil.<Expression>copy(_guardExpression_1);
        _xifexpression_1 = _copy;
      } else {
        _xifexpression_1 = null;
      }
      final Expression guard = _xifexpression_1;
      Expression _xifexpression_2 = null;
      boolean _and = false;
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(triggerCheck, null);
      if (!_notEquals_1) {
        _and = false;
      } else {
        boolean _notEquals_2 = ObjectExtensions.operator_notEquals(guard, null);
        _and = BooleanExtensions.operator_and(_notEquals_1, _notEquals_2);
      }
      if (_and) {
        Expression _and_1 = this.stext.and(triggerCheck, guard);
        _xifexpression_2 = _and_1;
      } else {
        Expression _xifexpression_3 = null;
        boolean _notEquals_3 = ObjectExtensions.operator_notEquals(triggerCheck, null);
        if (_notEquals_3) {
          _xifexpression_3 = triggerCheck;
        } else {
          _xifexpression_3 = guard;
        }
        _xifexpression_2 = _xifexpression_3;
      }
      _xblockexpression = (_xifexpression_2);
    }
    return _xblockexpression;
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
  
  public Statement buildCondition(final Trigger t) {
    if (t instanceof ReactionTrigger) {
      return _buildCondition((ReactionTrigger)t);
    } else if (t != null) {
      return _buildCondition(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
}
