package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeUnit;

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
  
  public ExecutionFlow mapEntryActions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
      Iterable<State> _filter = IterableExtensions.<State>filter(_allRegularStates, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,Object> _function = new Function1<State,Object>() {
          public Object apply(final State s) {
            Object _xblockexpression = null;
            {
              ExecutionState _create = BehaviorMapping.this.factory.create(s);
              Step _mapEntryAction = BehaviorMapping.this.mapEntryAction(s);
              _create.setEntryAction(_mapEntryAction);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<State>forEach(allStates, _function);
      return r;
    }
  }
  
  public Step mapEntryAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("entryAction");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Entry action for state \'", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\'.");
      seq.setComment(_operator_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(state);
      for (TimeEventSpec tes : _timeEventSpecs) {
        {
          TimeEvent _createDerivedEvent = this.factory.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          Statement _buildValueExpression = this.buildValueExpression(tes);
          ScheduleTimeEvent _newScheduleTimeEvent = this.factory.newScheduleTimeEvent(timeEvent, _buildValueExpression);
          final ScheduleTimeEvent scheduleStep = _newScheduleTimeEvent;
          EList<Step> _steps = seq.getSteps();
          _steps.add(scheduleStep);
        }
      }
      List<LocalReaction> _entryReactions = this.sc.entryReactions(state);
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
            if (_operator_notEquals) {
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
      final Function1<Sequence,Boolean> _function_1 = new Function1<Sequence,Boolean>() {
          public Boolean apply(final Sequence e) {
            Boolean _xifexpression_1 = null;
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(e, null);
            if (_operator_notEquals_1) {
              EList<Step> _steps_1 = seq.getSteps();
              boolean _add = _steps_1.add(e);
              _xifexpression_1 = _add;
            }
            return _xifexpression_1;
          }
        };
      IterableExtensions.<Sequence>forEach(_map, _function_1);
      Sequence _xifexpression_2 = null;
      EList<Step> _steps_2 = seq.getSteps();
      int _size = _steps_2.size();
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
      if (_operator_greaterThan) {
        _xifexpression_2 = seq;
      } else {
        _xifexpression_2 = null;
      }
      _xblockexpression = (_xifexpression_2);
    }
    return _xblockexpression;
  }
  
  public ExecutionFlow mapExitActions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
      Iterable<State> _filter = IterableExtensions.<State>filter(_allRegularStates, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,Object> _function = new Function1<State,Object>() {
          public Object apply(final State s) {
            Object _xblockexpression = null;
            {
              ExecutionState _create = BehaviorMapping.this.factory.create(s);
              Step _mapExitAction = BehaviorMapping.this.mapExitAction(s);
              _create.setExitAction(_mapExitAction);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<State>forEach(allStates, _function);
      return r;
    }
  }
  
  public Step mapExitAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitAction");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Exit action for state \'", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\'.");
      seq.setComment(_operator_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(state);
      for (TimeEventSpec tes : _timeEventSpecs) {
        {
          TimeEvent _createDerivedEvent = this.factory.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          UnscheduleTimeEvent _newUnscheduleTimeEvent = this.factory.newUnscheduleTimeEvent(timeEvent);
          final UnscheduleTimeEvent unscheduleStep = _newUnscheduleTimeEvent;
          EList<Step> _steps = seq.getSteps();
          _steps.add(unscheduleStep);
        }
      }
      List<LocalReaction> _exitReactions = this.sc.exitReactions(state);
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
            if (_operator_notEquals) {
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
      final Function1<Sequence,Boolean> _function_1 = new Function1<Sequence,Boolean>() {
          public Boolean apply(final Sequence e) {
            Boolean _xifexpression_1 = null;
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(e, null);
            if (_operator_notEquals_1) {
              EList<Step> _steps_1 = seq.getSteps();
              boolean _add = _steps_1.add(e);
              _xifexpression_1 = _add;
            }
            return _xifexpression_1;
          }
        };
      IterableExtensions.<Sequence>forEach(_map, _function_1);
      Sequence _xifexpression_2 = null;
      EList<Step> _steps_2 = seq.getSteps();
      int _size = _steps_2.size();
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
      if (_operator_greaterThan) {
        _xifexpression_2 = seq;
      } else {
        _xifexpression_2 = null;
      }
      _xblockexpression = (_xifexpression_2);
    }
    return _xblockexpression;
  }
  
  public Statement buildValueExpression(final TimeEventSpec tes) {
    Statement _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      IntLiteral _createIntLiteral = _factory_1.createIntLiteral();
      final IntLiteral intLit = _createIntLiteral;
      int _value = tes.getValue();
      intLit.setValue(_value);
      pve.setValue(intLit);
      Statement _switchResult = null;
      TimeUnit _unit = tes.getUnit();
      final TimeUnit __valOfSwitchOver = _unit;
      boolean matched = false;
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,TimeUnit.MILLISECOND)) {
          matched=true;
          _switchResult = pve;
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,TimeUnit.NANOSECOND)) {
          matched=true;
          Statement _divide = this.divide(pve, 1000000);
          _switchResult = _divide;
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,TimeUnit.SECOND)) {
          matched=true;
          Statement _multiply = this.multiply(pve, 1000);
          _switchResult = _multiply;
        }
      }
      if (!matched) {
        _switchResult = pve;
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public Statement divide(final Expression stmnt, final long divisor) {
    NumericalMultiplyDivideExpression _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      NumericalMultiplyDivideExpression _createNumericalMultiplyDivideExpression = _factory.createNumericalMultiplyDivideExpression();
      final NumericalMultiplyDivideExpression div = _createNumericalMultiplyDivideExpression;
      StextFactory _factory_1 = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory_1.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _factory_2 = this.stext.factory();
      IntLiteral _createIntLiteral = _factory_2.createIntLiteral();
      final IntLiteral intLit = _createIntLiteral;
      int _intValue = ((Long)divisor).intValue();
      intLit.setValue(_intValue);
      pve.setValue(intLit);
      div.setOperator(MultiplicativeOperator.DIV);
      div.setLeftOperand(stmnt);
      div.setRightOperand(pve);
      _xblockexpression = (div);
    }
    return _xblockexpression;
  }
  
  public Statement multiply(final Expression stmnt, final long factor) {
    NumericalMultiplyDivideExpression _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      NumericalMultiplyDivideExpression _createNumericalMultiplyDivideExpression = _factory.createNumericalMultiplyDivideExpression();
      final NumericalMultiplyDivideExpression div = _createNumericalMultiplyDivideExpression;
      StextFactory _factory_1 = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory_1.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _factory_2 = this.stext.factory();
      IntLiteral _createIntLiteral = _factory_2.createIntLiteral();
      final IntLiteral intLit = _createIntLiteral;
      int _intValue = ((Long)factor).intValue();
      intLit.setValue(_intValue);
      pve.setValue(intLit);
      div.setOperator(MultiplicativeOperator.MUL);
      div.setLeftOperand(stmnt);
      div.setRightOperand(pve);
      _xblockexpression = (div);
    }
    return _xblockexpression;
  }
  
  protected Sequence _mapEffect(final Effect effect) {
    return null;
  }
  
  protected Sequence _mapEffect(final ReactionEffect effect) {
    Sequence _xifexpression = null;
    EList<Statement> _actions = effect.getActions();
    boolean _isEmpty = _actions.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    if (_operator_not) {
      {
        SexecFactory _factory = this.sexec.factory();
        Sequence _createSequence = _factory.createSequence();
        final Sequence sequence = _createSequence;
        sequence.setName("reaction_action");
        EList<Step> _steps = sequence.getSteps();
        EList<Statement> _actions_1 = effect.getActions();
        final Function1<Statement,Execution> _function = new Function1<Statement,Execution>() {
            public Execution apply(final Statement stmnt) {
              Execution _mapToExecution = BehaviorMapping.this.mapToExecution(stmnt);
              return _mapToExecution;
            }
          };
        List<Execution> _map = ListExtensions.<Statement, Execution>map(_actions_1, _function);
        _steps.addAll(_map);
        return sequence;
      }
    }
    return _xifexpression;
  }
  
  public Execution mapToExecution(final Statement stmnt) {
    Execution _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      Execution _createExecution = _factory.createExecution();
      final Execution exec = _createExecution;
      Statement _copy = EcoreUtil.<Statement>copy(stmnt);
      exec.setStatement(_copy);
      _xblockexpression = (exec);
    }
    return _xblockexpression;
  }
  
  public Sequence mapEffect(final Effect effect) {
    if ((effect instanceof ReactionEffect)) {
      return _mapEffect((ReactionEffect)effect);
    } else if ((effect instanceof Effect)) {
      return _mapEffect((Effect)effect);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(effect).toString());
    }
  }
}