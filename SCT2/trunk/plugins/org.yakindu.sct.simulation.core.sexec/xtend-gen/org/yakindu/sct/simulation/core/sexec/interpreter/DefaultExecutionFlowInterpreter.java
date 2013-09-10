/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.IStatementInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.ITimingService;
import org.yakindu.sct.simulation.core.sexec.interpreter.ITraceStepInterpreter;
import org.yakindu.sct.simulation.core.sruntime.EventDirection;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;

/**
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultExecutionFlowInterpreter implements IExecutionFlowInterpreter {
  @Inject
  private IStatementInterpreter statementInterpreter;
  
  @Inject
  private ITimingService timingService;
  
  @Inject
  @Extension
  private SexecExtensions _sexecExtensions;
  
  @Inject(optional = true)
  private ITraceStepInterpreter traceInterpreter;
  
  private ExecutionFlow flow;
  
  private ExecutionContext executionContext;
  
  private ExecutionState[] activeStateConfiguration;
  
  private Map<Integer,ExecutionState> historyStateConfiguration;
  
  private List<Step> executionStack;
  
  private int activeStateIndex;
  
  private boolean suspended = false;
  
  public void initialize(final ExecutionFlow flow, final ExecutionContext context) {
    this.flow = flow;
    this.executionContext = context;
    LinkedList<Step> _newLinkedList = CollectionLiterals.<Step>newLinkedList();
    this.executionStack = _newLinkedList;
    StateVector _stateVector = flow.getStateVector();
    int _size = _stateVector.getSize();
    ExecutionState[] _newArrayOfSize = new ExecutionState[_size];
    this.activeStateConfiguration = _newArrayOfSize;
    this.activeStateIndex = 0;
    HashMap<Integer,ExecutionState> _newHashMap = CollectionLiterals.<Integer, ExecutionState>newHashMap();
    this.historyStateConfiguration = _newHashMap;
    boolean _isSnapshot = this.executionContext.isSnapshot();
    boolean _not = (!_isSnapshot);
    if (_not) {
      Sequence _initSequence = flow.getInitSequence();
      this.scheduleAndRun(_initSequence);
    }
  }
  
  public void enter() {
    boolean _isSnapshot = this.executionContext.isSnapshot();
    boolean _not = (!_isSnapshot);
    if (_not) {
      Sequence _defaultSequence = null;
      EList<Sequence> _enterSequences = this.flow.getEnterSequences();
      if (_enterSequences!=null) {
        _defaultSequence=this._sexecExtensions.defaultSequence(_enterSequences);
      }
      if (_defaultSequence!=null) {
        this.scheduleAndRun(_defaultSequence);
      }
    } else {
      List<RegularState> _activeStates = this.executionContext.getActiveStates();
      final Procedure1<RegularState> _function = new Procedure1<RegularState>() {
          public void apply(final RegularState state) {
            ExecutionState _executionState = DefaultExecutionFlowInterpreter.this.toExecutionState(state);
            StateVector _stateVector = _executionState.getStateVector();
            int _offset = _stateVector.getOffset();
            ExecutionState _executionState_1 = DefaultExecutionFlowInterpreter.this.toExecutionState(state);
            DefaultExecutionFlowInterpreter.this.activeStateConfiguration[_offset] = _executionState_1;
          }
        };
      IterableExtensions.<RegularState>forEach(_activeStates, _function);
    }
  }
  
  public ExecutionState toExecutionState(final RegularState state) {
    TreeIterator<EObject> _eAllContents = this.flow.eAllContents();
    final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
        public Boolean apply(final EObject it) {
          boolean _and = false;
          if (!(it instanceof ExecutionState)) {
            _and = false;
          } else {
            EObject _sourceElement = ((ExecutionState) it).getSourceElement();
            boolean _equals = EcoreUtil.equals(_sourceElement, state);
            _and = ((it instanceof ExecutionState) && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterator<EObject> _filter = IteratorExtensions.<EObject>filter(_eAllContents, _function);
    EObject _head = IteratorExtensions.<EObject>head(_filter);
    return ((ExecutionState) _head);
  }
  
  public void runCycle() {
    List<ExecutionEvent> _events = this.executionContext.getEvents();
    final Function1<ExecutionEvent,Boolean> _function = new Function1<ExecutionEvent,Boolean>() {
        public Boolean apply(final ExecutionEvent it) {
          boolean _isScheduled = it.isScheduled();
          return Boolean.valueOf(_isScheduled);
        }
      };
    Iterable<ExecutionEvent> _filter = IterableExtensions.<ExecutionEvent>filter(_events, _function);
    final Procedure1<ExecutionEvent> _function_1 = new Procedure1<ExecutionEvent>() {
        public void apply(final ExecutionEvent it) {
          it.setRaised(true);
          it.setScheduled(false);
        }
      };
    IterableExtensions.<ExecutionEvent>forEach(_filter, _function_1);
    this.activeStateIndex = 0;
    List<EObject> _executedElements = this.executionContext.getExecutedElements();
    _executedElements.clear();
    List<ExecutionEvent> _events_1 = this.executionContext.getEvents();
    final Function1<ExecutionEvent,Boolean> _function_2 = new Function1<ExecutionEvent,Boolean>() {
        public Boolean apply(final ExecutionEvent it) {
          EventDirection _direction = it.getDirection();
          boolean _equals = Objects.equal(_direction, EventDirection.OUT);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<ExecutionEvent> _filter_1 = IterableExtensions.<ExecutionEvent>filter(_events_1, _function_2);
    final Procedure1<ExecutionEvent> _function_3 = new Procedure1<ExecutionEvent>() {
        public void apply(final ExecutionEvent it) {
          it.setRaised(false);
        }
      };
    IterableExtensions.<ExecutionEvent>forEach(_filter_1, _function_3);
    int _size = ((List<ExecutionState>)Conversions.doWrapArray(this.activeStateConfiguration)).size();
    boolean _lessThan = (this.activeStateIndex < _size);
    boolean _while = _lessThan;
    while (_while) {
      {
        ExecutionState state = this.activeStateConfiguration[this.activeStateIndex];
        Sequence _reactSequence = null;
        if (state!=null) {
          _reactSequence=state.getReactSequence();
        }
        if (_reactSequence!=null) {
          this.scheduleAndRun(_reactSequence);
        }
        int _plus = (this.activeStateIndex + 1);
        this.activeStateIndex = _plus;
      }
      int _size_1 = ((List<ExecutionState>)Conversions.doWrapArray(this.activeStateConfiguration)).size();
      boolean _lessThan_1 = (this.activeStateIndex < _size_1);
      _while = _lessThan_1;
    }
    List<ExecutionEvent> _events_2 = this.executionContext.getEvents();
    final Function1<ExecutionEvent,Boolean> _function_4 = new Function1<ExecutionEvent,Boolean>() {
        public Boolean apply(final ExecutionEvent it) {
          boolean _or = false;
          EventDirection _direction = it.getDirection();
          boolean _equals = Objects.equal(_direction, EventDirection.IN);
          if (_equals) {
            _or = true;
          } else {
            EventDirection _direction_1 = it.getDirection();
            boolean _equals_1 = Objects.equal(_direction_1, EventDirection.LOCAL);
            _or = (_equals || _equals_1);
          }
          return Boolean.valueOf(_or);
        }
      };
    Iterable<ExecutionEvent> _filter_2 = IterableExtensions.<ExecutionEvent>filter(_events_2, _function_4);
    final Procedure1<ExecutionEvent> _function_5 = new Procedure1<ExecutionEvent>() {
        public void apply(final ExecutionEvent it) {
          it.setRaised(false);
        }
      };
    IterableExtensions.<ExecutionEvent>forEach(_filter_2, _function_5);
  }
  
  public void resume() {
    List<EObject> _suspendedElements = this.executionContext.getSuspendedElements();
    _suspendedElements.clear();
    this.suspended = false;
    this.run();
  }
  
  public void suspend() {
    this.suspended = true;
  }
  
  public void exit() {
    Sequence _exitSequence = this.flow.getExitSequence();
    this.scheduleAndRun(_exitSequence);
  }
  
  public void tearDown() {
    this.timingService.stop();
  }
  
  public void scheduleAndRun(final Step step) {
    this.schedule(step);
    this.run();
  }
  
  public void run() {
    boolean _and = false;
    boolean _isEmpty = this.executionStack.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      boolean _not_1 = (!this.suspended);
      _and = (_not && _not_1);
    }
    boolean _while = _and;
    while (_while) {
      {
        Step head = IterableExtensions.<Step>head(this.executionStack);
        this.executionStack.remove(head);
        this.execute(head);
      }
      boolean _and_1 = false;
      boolean _isEmpty_1 = this.executionStack.isEmpty();
      boolean _not_2 = (!_isEmpty_1);
      if (!_not_2) {
        _and_1 = false;
      } else {
        boolean _not_3 = (!this.suspended);
        _and_1 = (_not_2 && _not_3);
      }
      _while = _and_1;
    }
  }
  
  public void schedule(final Step step) {
    this.executionStack.add(0, step);
  }
  
  protected Object _execute(final Call call) {
    Object _xblockexpression = null;
    {
      Step _step = call.getStep();
      this.schedule(_step);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Step step) {
    return null;
  }
  
  protected Object _execute(final Trace trace) {
    Object _xblockexpression = null;
    {
      if (this.traceInterpreter!=null) {
        this.traceInterpreter.evaluate(trace, this.executionContext);
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Check check) {
    Statement _condition = check.getCondition();
    boolean _equals = Objects.equal(_condition, null);
    if (_equals) {
      return Boolean.valueOf(true);
    }
    Statement _condition_1 = check.getCondition();
    return this.statementInterpreter.evaluateStatement(_condition_1, this.executionContext);
  }
  
  protected Object _execute(final EnterState enterState) {
    Object _xblockexpression = null;
    {
      ExecutionState _state = enterState.getState();
      StateVector _stateVector = _state.getStateVector();
      int _offset = _stateVector.getOffset();
      ExecutionState _state_1 = enterState.getState();
      this.activeStateConfiguration[_offset] = _state_1;
      List<RegularState> _activeStates = this.executionContext.getActiveStates();
      ExecutionState _state_2 = enterState.getState();
      EObject _sourceElement = _state_2.getSourceElement();
      _activeStates.add(((RegularState) _sourceElement));
      ExecutionState _state_3 = enterState.getState();
      StateVector _stateVector_1 = _state_3.getStateVector();
      int _offset_1 = _stateVector_1.getOffset();
      this.activeStateIndex = _offset_1;
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Execution execution) {
    Statement _statement = execution.getStatement();
    Object _evaluateStatement = this.statementInterpreter.evaluateStatement(_statement, this.executionContext);
    return _evaluateStatement;
  }
  
  protected Object _execute(final ExitState exitState) {
    Object _xblockexpression = null;
    {
      ExecutionState _state = exitState.getState();
      StateVector _stateVector = _state.getStateVector();
      int _offset = _stateVector.getOffset();
      this.activeStateConfiguration[_offset] = null;
      List<RegularState> _activeStates = this.executionContext.getActiveStates();
      final Function1<RegularState,Boolean> _function = new Function1<RegularState,Boolean>() {
          public Boolean apply(final RegularState it) {
            ExecutionState _state = exitState.getState();
            EObject _sourceElement = _state.getSourceElement();
            boolean _equals = EcoreUtil.equals(it, _sourceElement);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<RegularState> activeStates = IterableExtensions.<RegularState>filter(_activeStates, _function);
      List<RegularState> _activeStates_1 = this.executionContext.getActiveStates();
      CollectionExtensions.<RegularState>removeAll(_activeStates_1, activeStates);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final If ifStep) {
    Object _xblockexpression = null;
    {
      Check _check = ifStep.getCheck();
      Object check = this.execute(_check);
      if ((((Boolean) check)).booleanValue()) {
        Step _thenStep = ifStep.getThenStep();
        this.schedule(_thenStep);
      } else {
        Step _elseStep = ifStep.getElseStep();
        boolean _notEquals = (!Objects.equal(_elseStep, null));
        if (_notEquals) {
          Step _elseStep_1 = ifStep.getElseStep();
          this.schedule(_elseStep_1);
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Sequence sequence) {
    Object _xblockexpression = null;
    {
      EList<Step> _steps = sequence.getSteps();
      List<Step> _reverseView = ListExtensions.<Step>reverseView(_steps);
      final Procedure1<Step> _function = new Procedure1<Step>() {
          public void apply(final Step it) {
            DefaultExecutionFlowInterpreter.this.schedule(it);
          }
        };
      IterableExtensions.<Step>forEach(_reverseView, _function);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final SaveHistory action) {
    ExecutionState _xblockexpression = null;
    {
      ExecutionRegion region = action.getRegion();
      StateVector _historyVector = region.getHistoryVector();
      int _offset = _historyVector.getOffset();
      StateVector _stateVector = region.getStateVector();
      int _offset_1 = _stateVector.getOffset();
      ExecutionState _get = this.activeStateConfiguration[_offset_1];
      ExecutionState _put = this.historyStateConfiguration.put(Integer.valueOf(_offset), _get);
      _xblockexpression = (_put);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final HistoryEntry entry) {
    Object _xblockexpression = null;
    {
      ExecutionRegion _region = entry.getRegion();
      ExecutionState _get = this.historyStateConfiguration.get(_region);
      boolean _notEquals = (!Objects.equal(_get, null));
      if (_notEquals) {
        Step _historyStep = entry.getHistoryStep();
        if (_historyStep!=null) {
          this.execute(_historyStep);
        }
      } else {
        Step _initialStep = entry.getInitialStep();
        if (_initialStep!=null) {
          this.execute(_initialStep);
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final StateSwitch stateSwitch) {
    Object _xblockexpression = null;
    {
      final ExecutionRegion historyRegion = stateSwitch.getHistoryRegion();
      boolean _notEquals = (!Objects.equal(historyRegion, null));
      if (_notEquals) {
        final ExecutionState historyState = this.historyStateConfiguration.get(historyRegion);
        EList<StateCase> _cases = stateSwitch.getCases();
        final Function1<StateCase,Boolean> _function = new Function1<StateCase,Boolean>() {
            public Boolean apply(final StateCase it) {
              ExecutionState _state = it.getState();
              boolean _equals = Objects.equal(_state, historyState);
              return Boolean.valueOf(_equals);
            }
          };
        Iterable<StateCase> _filter = IterableExtensions.<StateCase>filter(_cases, _function);
        final Procedure1<StateCase> _function_1 = new Procedure1<StateCase>() {
            public void apply(final StateCase it) {
              Step _step = it.getStep();
              DefaultExecutionFlowInterpreter.this.schedule(_step);
            }
          };
        IterableExtensions.<StateCase>forEach(_filter, _function_1);
      } else {
        EList<StateCase> _cases_1 = stateSwitch.getCases();
        final Function1<StateCase,Boolean> _function_2 = new Function1<StateCase,Boolean>() {
            public Boolean apply(final StateCase it) {
              ExecutionState _state = it.getState();
              boolean _contains = ((List<ExecutionState>)Conversions.doWrapArray(DefaultExecutionFlowInterpreter.this.activeStateConfiguration)).contains(_state);
              return Boolean.valueOf(_contains);
            }
          };
        Iterable<StateCase> _filter_1 = IterableExtensions.<StateCase>filter(_cases_1, _function_2);
        final Procedure1<StateCase> _function_3 = new Procedure1<StateCase>() {
            public void apply(final StateCase it) {
              Step _step = it.getStep();
              DefaultExecutionFlowInterpreter.this.schedule(_step);
            }
          };
        IterableExtensions.<StateCase>forEach(_filter_1, _function_3);
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final ScheduleTimeEvent scheduleTimeEvent) {
    Object _xblockexpression = null;
    {
      TimeEvent timeEvent = scheduleTimeEvent.getTimeEvent();
      Statement _timeValue = scheduleTimeEvent.getTimeValue();
      Object duration = this.statementInterpreter.evaluateStatement(_timeValue, this.executionContext);
      String _name = timeEvent.getName();
      boolean _isPeriodic = timeEvent.isPeriodic();
      this.timingService.scheduleTimeEvent(this.executionContext, _name, _isPeriodic, (((Integer) duration)).intValue());
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final UnscheduleTimeEvent timeEvent) {
    Object _xblockexpression = null;
    {
      TimeEvent _timeEvent = timeEvent.getTimeEvent();
      String _name = _timeEvent.getName();
      this.timingService.unscheduleTimeEvent(_name);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  public Object execute(final Step call) {
    if (call instanceof Call) {
      return _execute((Call)call);
    } else if (call instanceof Check) {
      return _execute((Check)call);
    } else if (call instanceof EnterState) {
      return _execute((EnterState)call);
    } else if (call instanceof Execution) {
      return _execute((Execution)call);
    } else if (call instanceof ExitState) {
      return _execute((ExitState)call);
    } else if (call instanceof HistoryEntry) {
      return _execute((HistoryEntry)call);
    } else if (call instanceof If) {
      return _execute((If)call);
    } else if (call instanceof SaveHistory) {
      return _execute((SaveHistory)call);
    } else if (call instanceof ScheduleTimeEvent) {
      return _execute((ScheduleTimeEvent)call);
    } else if (call instanceof Sequence) {
      return _execute((Sequence)call);
    } else if (call instanceof StateSwitch) {
      return _execute((StateSwitch)call);
    } else if (call instanceof Trace) {
      return _execute((Trace)call);
    } else if (call instanceof UnscheduleTimeEvent) {
      return _execute((UnscheduleTimeEvent)call);
    } else if (call != null) {
      return _execute(call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
}
