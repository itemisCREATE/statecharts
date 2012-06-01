package org.yakindu.sct.model.sexec.interpreter.impl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.Type;
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
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.TraceBeginRunCycle;
import org.yakindu.sct.model.sexec.TraceEndRunCycle;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.interpreter.IStatementInterpreter;
import org.yakindu.sct.model.sexec.interpreter.ITimingService;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.simulation.core.runtime.AbstractExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;
import org.yakindu.sct.simulation.core.runtime.timer.VirtualClock;

/**
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class ExecutionFlowInterpreter extends AbstractExecutionFacade implements IExecutionFlowInterpreter, IExecutionContextListener {
  @Inject
  private IStatementInterpreter interpreter;
  
  @Inject
  private IExecutionContext executionContext;
  
  @Inject
  private StextNameProvider provider;
  
  @Inject
  private ITimingService timingService;
  
  @Inject
  private ITypeSystemAccess ts;
  
  @Inject
  @Named(value = "InterpreterName")
  private String interpreterName;
  
  private ExecutionFlow flow;
  
  private int nextSVIdx;
  
  private TraceBeginRunCycle brc;
  
  private TraceEndRunCycle erc;
  
  public void initialize(final ExecutionFlow flow) {
    this.flow = flow;
    EList<Scope> _scopes = flow.getScopes();
    for (final Scope scope : _scopes) {
      this.declareContents(scope);
    }
    StateVector _stateVector = flow.getStateVector();
    int _size = _stateVector.getSize();
    this.executionContext.initStateConfigurationVector(_size);
    this.executionContext.addExecutionContextListener(this);
    VirtualClock _virtualClock = this.executionContext.getVirtualClock();
    this.timingService.init(_virtualClock);
    VirtualClock _virtualClock_1 = this.executionContext.getVirtualClock();
    _virtualClock_1.start();
    TraceBeginRunCycle _createTraceBeginRunCycle = SexecFactory.eINSTANCE.createTraceBeginRunCycle();
    this.brc = _createTraceBeginRunCycle;
    TraceEndRunCycle _createTraceEndRunCycle = SexecFactory.eINSTANCE.createTraceEndRunCycle();
    this.erc = _createTraceEndRunCycle;
  }
  
  public void tearDown() {
    this.timingService.stop();
  }
  
  public String getName() {
    return this.interpreterName;
  }
  
  protected void _declareContents(final InternalScope scope) {
    EList<Declaration> _declarations = scope.getDeclarations();
    for (final Declaration declaration : _declarations) {
      this.addToScope(declaration);
    }
  }
  
  protected void _declareContents(final Scope scope) {
    EList<Declaration> _declarations = scope.getDeclarations();
    for (final Declaration declaration : _declarations) {
      this.addToScope(declaration);
    }
  }
  
  protected void _declareContents(final InterfaceScope scope) {
    EList<Declaration> _declarations = scope.getDeclarations();
    for (final Declaration declaration : _declarations) {
      this.addToScope(declaration);
    }
  }
  
  public void runCycle() {
    this.executionContext.flush();
    this.nextSVIdx = 0;
    this.execute(this.brc);
    ExecutionState[] _stateConfiguration = this.executionContext.getStateConfiguration();
    int _size = ((List<ExecutionState>)Conversions.doWrapArray(_stateConfiguration)).size();
    boolean _lessThan = (this.nextSVIdx < _size);
    boolean _while = _lessThan;
    while (_while) {
      {
        ExecutionState[] _stateConfiguration_1 = this.executionContext.getStateConfiguration();
        ExecutionState state = ((List<ExecutionState>)Conversions.doWrapArray(_stateConfiguration_1)).get(this.nextSVIdx);
        boolean _notEquals = (!Objects.equal(state, null));
        if (_notEquals) {
          Sequence _reactSequence = state.getReactSequence();
          this.execute(_reactSequence);
        }
        int _plus = (this.nextSVIdx + 1);
        this.nextSVIdx = _plus;
      }
      ExecutionState[] _stateConfiguration_1 = this.executionContext.getStateConfiguration();
      int _size_1 = ((List<ExecutionState>)Conversions.doWrapArray(_stateConfiguration_1)).size();
      boolean _lessThan_1 = (this.nextSVIdx < _size_1);
      _while = _lessThan_1;
    }
    this.executionContext.resetRaisedEvents();
    this.execute(this.erc);
  }
  
  protected Object _addToScope(final VariableDefinition variable) {
    Object _xblockexpression = null;
    {
      QualifiedName _qualifiedName = this.provider.qualifiedName(variable);
      String fqName = _qualifiedName.toString();
      Type _type = variable.getType();
      boolean _isBoolean = this.ts.isBoolean(_type);
      if (_isBoolean) {
        ExecutionVariable _executionVariable = new ExecutionVariable(fqName, Boolean.class, Boolean.valueOf(false));
        this.executionContext.declareVariable(_executionVariable);
      } else {
        Type _type_1 = variable.getType();
        boolean _isInteger = this.ts.isInteger(_type_1);
        if (_isInteger) {
          ExecutionVariable _executionVariable_1 = new ExecutionVariable(fqName, Integer.class, Integer.valueOf(0));
          this.executionContext.declareVariable(_executionVariable_1);
        } else {
          Type _type_2 = variable.getType();
          boolean _isReal = this.ts.isReal(_type_2);
          if (_isReal) {
            float _parseFloat = Float.parseFloat("0.0");
            ExecutionVariable _executionVariable_2 = new ExecutionVariable(fqName, Float.class, Float.valueOf(_parseFloat));
            this.executionContext.declareVariable(_executionVariable_2);
          } else {
            Type _type_3 = variable.getType();
            boolean _isString = this.ts.isString(_type_3);
            if (_isString) {
              ExecutionVariable _executionVariable_3 = new ExecutionVariable(fqName, String.class, "");
              this.executionContext.declareVariable(_executionVariable_3);
            }
          }
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _addToScope(final EventDefinition event) {
    Object _xblockexpression = null;
    {
      QualifiedName _qualifiedName = this.provider.qualifiedName(event);
      String fqName = _qualifiedName.toString();
      Type _type = event.getType();
      boolean _isBoolean = this.ts.isBoolean(_type);
      if (_isBoolean) {
        ExecutionEvent _executionEvent = new ExecutionEvent(fqName, Boolean.class, null);
        this.executionContext.declareEvent(_executionEvent);
      } else {
        Type _type_1 = event.getType();
        boolean _isInteger = this.ts.isInteger(_type_1);
        if (_isInteger) {
          ExecutionEvent _executionEvent_1 = new ExecutionEvent(fqName, Integer.class, null);
          this.executionContext.declareEvent(_executionEvent_1);
        } else {
          Type _type_2 = event.getType();
          boolean _isReal = this.ts.isReal(_type_2);
          if (_isReal) {
            ExecutionEvent _executionEvent_2 = new ExecutionEvent(fqName, Float.class, null);
            this.executionContext.declareEvent(_executionEvent_2);
          } else {
            Type _type_3 = event.getType();
            boolean _isVoid = this.ts.isVoid(_type_3);
            if (_isVoid) {
              ExecutionEvent _executionEvent_3 = new ExecutionEvent(fqName, Void.class);
              this.executionContext.declareEvent(_executionEvent_3);
            } else {
              Type _type_4 = event.getType();
              boolean _isString = this.ts.isString(_type_4);
              if (_isString) {
                ExecutionEvent _executionEvent_4 = new ExecutionEvent(fqName, String.class, "");
                this.executionContext.declareEvent(_executionEvent_4);
              }
            }
          }
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _addToScope(final TimeEvent event) {
    Object _xblockexpression = null;
    {
      String _name = event.getName();
      ExecutionEvent _executionEvent = new ExecutionEvent(_name, Long.class);
      this.executionContext.declareEvent(_executionEvent);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  public void enter() {
    Sequence _enterSequence = this.flow.getEnterSequence();
    EList<Step> _steps = _enterSequence.getSteps();
    for (final Step step : _steps) {
      this.execute(step);
    }
  }
  
  protected Object _execute(final Step step) {
    String _plus = ("Missing dispatch function for " + step);
    String _println = InputOutput.<String>println(_plus);
    return _println;
  }
  
  protected Object _execute(final Call call) {
    Object _xblockexpression = null;
    {
      Step _step = call.getStep();
      this.execute(_step);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Trace trace) {
    Object _xblockexpression = null;
    {
      this.notifyTraceStepEntered(trace);
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
    Object interpreterResult = this.interpreter.evaluateStatement(_condition_1, this.executionContext);
    return interpreterResult;
  }
  
  protected Object _execute(final EnterState enterState) {
    Object _xblockexpression = null;
    {
      ExecutionState[] _stateConfiguration = this.executionContext.getStateConfiguration();
      ExecutionState _state = enterState.getState();
      StateVector _stateVector = _state.getStateVector();
      int _offset = _stateVector.getOffset();
      ExecutionState _state_1 = enterState.getState();
      ((List<ExecutionState>)Conversions.doWrapArray(_stateConfiguration)).set(_offset, _state_1);
      ExecutionState _state_2 = enterState.getState();
      StateVector _stateVector_1 = _state_2.getStateVector();
      int _offset_1 = _stateVector_1.getOffset();
      this.nextSVIdx = _offset_1;
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final HistoryEntry entry) {
    Object _xblockexpression = null;
    {
      ExecutionRegion _region = entry.getRegion();
      ExecutionState _historyStateConfiguration = this.executionContext.getHistoryStateConfiguration(_region);
      boolean _notEquals = (!Objects.equal(_historyStateConfiguration, null));
      if (_notEquals) {
        Step _historyStep = entry.getHistoryStep();
        this.execute(_historyStep);
      } else {
        Step _initialStep = entry.getInitialStep();
        boolean _equals = Objects.equal(_initialStep, null);
        if (_equals) {
          String _plus = ("Missing initial transition " + entry);
          InputOutput.<String>println(_plus);
        } else {
          Step _initialStep_1 = entry.getInitialStep();
          this.execute(_initialStep_1);
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final Execution execution) {
    Statement _statement = execution.getStatement();
    Object _evaluateStatement = this.interpreter.evaluateStatement(_statement, this.executionContext);
    return _evaluateStatement;
  }
  
  protected Object _execute(final ExitState exitState) {
    Object _xblockexpression = null;
    {
      ExecutionState[] _stateConfiguration = this.executionContext.getStateConfiguration();
      ExecutionState _state = exitState.getState();
      StateVector _stateVector = _state.getStateVector();
      int _offset = _stateVector.getOffset();
      ((List<ExecutionState>)Conversions.doWrapArray(_stateConfiguration)).set(_offset, null);
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
        this.execute(_thenStep);
      } else {
        Step _elseStep = ifStep.getElseStep();
        boolean _notEquals = (!Objects.equal(_elseStep, null));
        if (_notEquals) {
          Step _elseStep_1 = ifStep.getElseStep();
          this.execute(_elseStep_1);
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
      for (final Step step : _steps) {
        this.execute(step);
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Object _execute(final SaveHistory action) {
    Object _xblockexpression = null;
    {
      ExecutionRegion _region = action.getRegion();
      this.executionContext.saveHistoryStateConfiguration(_region);
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
        final ExecutionState historyState = this.executionContext.getHistoryStateConfiguration(historyRegion);
        EList<StateCase> _cases = stateSwitch.getCases();
        for (final StateCase stateCase : _cases) {
          ExecutionState _state = stateCase.getState();
          boolean _equals = Objects.equal(historyState, _state);
          if (_equals) {
            Step _step = stateCase.getStep();
            this.execute(_step);
          }
        }
      } else {
        EList<StateCase> _cases_1 = stateSwitch.getCases();
        for (final StateCase stateCase_1 : _cases_1) {
          ExecutionState[] _stateConfiguration = this.executionContext.getStateConfiguration();
          ExecutionState _state_1 = stateCase_1.getState();
          boolean _contains = ((List<ExecutionState>)Conversions.doWrapArray(_stateConfiguration)).contains(_state_1);
          if (_contains) {
            Step _step_1 = stateCase_1.getStep();
            this.execute(_step_1);
          }
        }
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
      Object duration = this.interpreter.evaluateStatement(_timeValue, this.executionContext);
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
  
  public void eventRaised(final ExecutionEvent event) {
  }
  
  public void variableValueChanged(final ExecutionVariable variable) {
  }
  
  public void timeScaleFactorChanged(final double oldFactor, final double newFactor) {
    this.timingService.setTimeScaleFactor(newFactor);
  }
  
  public IExecutionContext getExecutionContext() {
    return this.executionContext;
  }
  
  public void declareContents(final Scope scope) {
    if (scope instanceof InterfaceScope) {
      _declareContents((InterfaceScope)scope);
      return;
    } else if (scope instanceof InternalScope) {
      _declareContents((InternalScope)scope);
      return;
    } else if (scope != null) {
      _declareContents(scope);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(scope).toString());
    }
  }
  
  public Object addToScope(final Declaration event) {
    if (event instanceof TimeEvent) {
      return _addToScope((TimeEvent)event);
    } else if (event instanceof EventDefinition) {
      return _addToScope((EventDefinition)event);
    } else if (event instanceof VariableDefinition) {
      return _addToScope((VariableDefinition)event);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(event).toString());
    }
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
