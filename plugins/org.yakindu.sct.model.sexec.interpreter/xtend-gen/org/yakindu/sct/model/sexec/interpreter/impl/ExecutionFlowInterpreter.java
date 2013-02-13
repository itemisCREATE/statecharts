package org.yakindu.sct.model.sexec.interpreter.impl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.types.ITypeSystem.InferenceResult;
import org.yakindu.base.types.ITypeSystem.InferredType;
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
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;
import org.yakindu.sct.simulation.core.runtime.AbstractExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.IEventSlot;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.ISlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

/**
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class ExecutionFlowInterpreter extends AbstractExecutionFacade implements IExecutionFlowInterpreter {
  @Inject
  private IStatementInterpreter interpreter;
  
  @Inject
  private IExecutionContext executionContext;
  
  @Inject
  private StextNameProvider provider;
  
  @Inject
  private ITimingService timingService;
  
  @Inject
  private ISTextTypeSystem _iSTextTypeSystem;
  
  @Inject
  private ISTextTypeInferrer _iSTextTypeInferrer;
  
  @Inject
  @Named(value = "InterpreterName")
  private String interpreterName;
  
  private ExecutionFlow flow;
  
  private List<EventDefinition> inEvents;
  
  private List<EventDefinition> outEvents;
  
  private List<EventDefinition> localEvents;
  
  private List<TimeEvent> timeEvents;
  
  private Map<Declaration,ISlot> slotMap;
  
  private int nextSVIdx;
  
  private TraceBeginRunCycle brc;
  
  private TraceEndRunCycle erc;
  
  public void initialize(final ExecutionFlow flow) {
    this.flow = flow;
    HashMap<Declaration,ISlot> _hashMap = new HashMap<Declaration,ISlot>();
    this.slotMap = _hashMap;
    EList<Scope> _scopes = flow.getScopes();
    for (final Scope scope : _scopes) {
      this.declareContents(scope);
    }
    StateVector _stateVector = flow.getStateVector();
    int _size = _stateVector.getSize();
    this.executionContext.initStateConfigurationVector(_size);
    List<Object> _callbacks = super.getCallbacks();
    this.interpreter.setOperationCallbacks(_callbacks);
    TraceBeginRunCycle _createTraceBeginRunCycle = SexecFactory.eINSTANCE.createTraceBeginRunCycle();
    this.brc = _createTraceBeginRunCycle;
    TraceEndRunCycle _createTraceEndRunCycle = SexecFactory.eINSTANCE.createTraceEndRunCycle();
    this.erc = _createTraceEndRunCycle;
    EList<Scope> _scopes_1 = flow.getScopes();
    final Function1<Scope,Iterable<EventDefinition>> _function = new Function1<Scope,Iterable<EventDefinition>>() {
        public Iterable<EventDefinition> apply(final Scope s) {
          EList<Declaration> _declarations = s.getDeclarations();
          Iterable<EventDefinition> _filter = Iterables.<EventDefinition>filter(_declarations, EventDefinition.class);
          final Function1<EventDefinition,Boolean> _function = new Function1<EventDefinition,Boolean>() {
              public Boolean apply(final EventDefinition e) {
                Direction _direction = e.getDirection();
                boolean _equals = Objects.equal(_direction, Direction.IN);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<EventDefinition> _filter_1 = IterableExtensions.<EventDefinition>filter(_filter, _function);
          return _filter_1;
        }
      };
    List<Iterable<EventDefinition>> _map = ListExtensions.<Scope, Iterable<EventDefinition>>map(_scopes_1, _function);
    Iterable<EventDefinition> _flatten = Iterables.<EventDefinition>concat(_map);
    List<EventDefinition> _list = IterableExtensions.<EventDefinition>toList(_flatten);
    this.inEvents = _list;
    EList<Scope> _scopes_2 = flow.getScopes();
    final Function1<Scope,Iterable<EventDefinition>> _function_1 = new Function1<Scope,Iterable<EventDefinition>>() {
        public Iterable<EventDefinition> apply(final Scope s) {
          EList<Declaration> _declarations = s.getDeclarations();
          Iterable<EventDefinition> _filter = Iterables.<EventDefinition>filter(_declarations, EventDefinition.class);
          final Function1<EventDefinition,Boolean> _function = new Function1<EventDefinition,Boolean>() {
              public Boolean apply(final EventDefinition e) {
                Direction _direction = e.getDirection();
                boolean _equals = Objects.equal(_direction, Direction.OUT);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<EventDefinition> _filter_1 = IterableExtensions.<EventDefinition>filter(_filter, _function);
          return _filter_1;
        }
      };
    List<Iterable<EventDefinition>> _map_1 = ListExtensions.<Scope, Iterable<EventDefinition>>map(_scopes_2, _function_1);
    Iterable<EventDefinition> _flatten_1 = Iterables.<EventDefinition>concat(_map_1);
    List<EventDefinition> _list_1 = IterableExtensions.<EventDefinition>toList(_flatten_1);
    this.outEvents = _list_1;
    EList<Scope> _scopes_3 = flow.getScopes();
    final Function1<Scope,Iterable<EventDefinition>> _function_2 = new Function1<Scope,Iterable<EventDefinition>>() {
        public Iterable<EventDefinition> apply(final Scope s) {
          EList<Declaration> _declarations = s.getDeclarations();
          Iterable<EventDefinition> _filter = Iterables.<EventDefinition>filter(_declarations, EventDefinition.class);
          final Function1<EventDefinition,Boolean> _function = new Function1<EventDefinition,Boolean>() {
              public Boolean apply(final EventDefinition e) {
                Direction _direction = e.getDirection();
                boolean _equals = Objects.equal(_direction, Direction.LOCAL);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<EventDefinition> _filter_1 = IterableExtensions.<EventDefinition>filter(_filter, _function);
          return _filter_1;
        }
      };
    List<Iterable<EventDefinition>> _map_2 = ListExtensions.<Scope, Iterable<EventDefinition>>map(_scopes_3, _function_2);
    Iterable<EventDefinition> _flatten_2 = Iterables.<EventDefinition>concat(_map_2);
    List<EventDefinition> _list_2 = IterableExtensions.<EventDefinition>toList(_flatten_2);
    this.localEvents = _list_2;
    EList<Scope> _scopes_4 = flow.getScopes();
    final Function1<Scope,Iterable<TimeEvent>> _function_3 = new Function1<Scope,Iterable<TimeEvent>>() {
        public Iterable<TimeEvent> apply(final Scope s) {
          EList<Declaration> _declarations = s.getDeclarations();
          Iterable<TimeEvent> _filter = Iterables.<TimeEvent>filter(_declarations, TimeEvent.class);
          return _filter;
        }
      };
    List<Iterable<TimeEvent>> _map_3 = ListExtensions.<Scope, Iterable<TimeEvent>>map(_scopes_4, _function_3);
    Iterable<TimeEvent> _flatten_3 = Iterables.<TimeEvent>concat(_map_3);
    List<TimeEvent> _list_3 = IterableExtensions.<TimeEvent>toList(_flatten_3);
    this.timeEvents = _list_3;
    Sequence _initSequence = flow.getInitSequence();
    this.execute(_initSequence);
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
    this.clearOutEvents();
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
    this.clearEvents();
    this.execute(this.erc);
  }
  
  public void clearOutEvents() {
    final Procedure1<EventDefinition> _function = new Procedure1<EventDefinition>() {
        public void apply(final EventDefinition e) {
          ExecutionFlowInterpreter.this.unraise(e);
        }
      };
    IterableExtensions.<EventDefinition>forEach(this.outEvents, _function);
  }
  
  public void clearEvents() {
    final Procedure1<EventDefinition> _function = new Procedure1<EventDefinition>() {
        public void apply(final EventDefinition e) {
          ExecutionFlowInterpreter.this.unraise(e);
        }
      };
    IterableExtensions.<EventDefinition>forEach(this.inEvents, _function);
    final Procedure1<EventDefinition> _function_1 = new Procedure1<EventDefinition>() {
        public void apply(final EventDefinition e) {
          ExecutionFlowInterpreter.this.unraise(e);
        }
      };
    IterableExtensions.<EventDefinition>forEach(this.localEvents, _function_1);
    final Procedure1<TimeEvent> _function_2 = new Procedure1<TimeEvent>() {
        public void apply(final TimeEvent e) {
          ExecutionFlowInterpreter.this.unraise(e);
        }
      };
    IterableExtensions.<TimeEvent>forEach(this.timeEvents, _function_2);
  }
  
  public void unraise(final Event it) {
    ISlot _get = this.slotMap.get(it);
    ((IEventSlot) _get).unraise();
  }
  
  protected void _addToScope(final VariableDefinition variable) {
    QualifiedName _qualifiedName = this.provider.qualifiedName(variable);
    String fqName = _qualifiedName.toString();
    ExecutionVariable varSlot = null;
    InferenceResult _inferType = this._iSTextTypeInferrer.inferType(variable);
    InferredType _type = _inferType.getType();
    boolean _isBooleanType = this._iSTextTypeSystem.isBooleanType(_type);
    if (_isBooleanType) {
      ExecutionVariable _executionVariable = new ExecutionVariable(fqName, Boolean.class, Boolean.valueOf(false));
      varSlot = _executionVariable;
    } else {
      InferenceResult _inferType_1 = this._iSTextTypeInferrer.inferType(variable);
      InferredType _type_1 = _inferType_1.getType();
      boolean _isIntegerType = this._iSTextTypeSystem.isIntegerType(_type_1);
      if (_isIntegerType) {
        ExecutionVariable _executionVariable_1 = new ExecutionVariable(fqName, Integer.class, Integer.valueOf(0));
        varSlot = _executionVariable_1;
      } else {
        InferenceResult _inferType_2 = this._iSTextTypeInferrer.inferType(variable);
        InferredType _type_2 = _inferType_2.getType();
        boolean _isRealType = this._iSTextTypeSystem.isRealType(_type_2);
        if (_isRealType) {
          ExecutionVariable _executionVariable_2 = new ExecutionVariable(fqName, Float.class, Float.valueOf(0.0f));
          varSlot = _executionVariable_2;
        } else {
          InferenceResult _inferType_3 = this._iSTextTypeInferrer.inferType(variable);
          InferredType _type_3 = _inferType_3.getType();
          boolean _isStringType = this._iSTextTypeSystem.isStringType(_type_3);
          if (_isStringType) {
            ExecutionVariable _executionVariable_3 = new ExecutionVariable(fqName, String.class, "");
            varSlot = _executionVariable_3;
          }
        }
      }
    }
    this.executionContext.declareVariable(varSlot);
    this.slotMap.put(variable, varSlot);
  }
  
  protected void _addToScope(final EventDefinition event) {
    QualifiedName _qualifiedName = this.provider.qualifiedName(event);
    String fqName = _qualifiedName.toString();
    ExecutionEvent eventSlot = null;
    InferenceResult _inferType = this._iSTextTypeInferrer.inferType(event);
    InferredType _type = _inferType.getType();
    boolean _isBooleanType = this._iSTextTypeSystem.isBooleanType(_type);
    if (_isBooleanType) {
      ExecutionEvent _executionEvent = new ExecutionEvent(fqName, Boolean.class, Boolean.valueOf(false));
      eventSlot = _executionEvent;
    } else {
      InferenceResult _inferType_1 = this._iSTextTypeInferrer.inferType(event);
      InferredType _type_1 = _inferType_1.getType();
      boolean _isIntegerType = this._iSTextTypeSystem.isIntegerType(_type_1);
      if (_isIntegerType) {
        ExecutionEvent _executionEvent_1 = new ExecutionEvent(fqName, Integer.class, Integer.valueOf(0));
        eventSlot = _executionEvent_1;
      } else {
        InferenceResult _inferType_2 = this._iSTextTypeInferrer.inferType(event);
        InferredType _type_2 = _inferType_2.getType();
        boolean _isRealType = this._iSTextTypeSystem.isRealType(_type_2);
        if (_isRealType) {
          ExecutionEvent _executionEvent_2 = new ExecutionEvent(fqName, Float.class, Float.valueOf(0.0f));
          eventSlot = _executionEvent_2;
        } else {
          InferenceResult _inferType_3 = this._iSTextTypeInferrer.inferType(event);
          InferredType _type_3 = _inferType_3.getType();
          boolean _isVoidType = this._iSTextTypeSystem.isVoidType(_type_3);
          if (_isVoidType) {
            ExecutionEvent _executionEvent_3 = new ExecutionEvent(fqName, Void.class);
            eventSlot = _executionEvent_3;
          } else {
            InferenceResult _inferType_4 = this._iSTextTypeInferrer.inferType(event);
            InferredType _type_4 = _inferType_4.getType();
            boolean _isStringType = this._iSTextTypeSystem.isStringType(_type_4);
            if (_isStringType) {
              ExecutionEvent _executionEvent_4 = new ExecutionEvent(fqName, String.class, "");
              eventSlot = _executionEvent_4;
            }
          }
        }
      }
    }
    this.executionContext.declareEvent(eventSlot);
    this.slotMap.put(event, eventSlot);
  }
  
  protected void _addToScope(final OperationDefinition op) {
    QualifiedName _qualifiedName = this.provider.qualifiedName(op);
    String fqName = _qualifiedName.toString();
    Type _type = op.getType();
    Class<? extends Object> type = this.mappedType(_type);
    Object _defaultValue = this.defaultValue(type);
    ExecutionVariable _executionVariable = new ExecutionVariable(fqName, type, _defaultValue);
    final ExecutionVariable opSlot = _executionVariable;
    this.executionContext.declareVariable(opSlot);
    this.slotMap.put(op, opSlot);
  }
  
  public Class<? extends Object> mappedType(final Type it) {
    Class<? extends Object> _xifexpression = null;
    boolean _isBooleanType = this._iSTextTypeSystem.isBooleanType(it);
    if (_isBooleanType) {
      _xifexpression = Boolean.class;
    } else {
      Class<? extends Object> _xifexpression_1 = null;
      boolean _isIntegerType = this._iSTextTypeSystem.isIntegerType(it);
      if (_isIntegerType) {
        _xifexpression_1 = Integer.class;
      } else {
        Class<? extends Object> _xifexpression_2 = null;
        boolean _isRealType = this._iSTextTypeSystem.isRealType(it);
        if (_isRealType) {
          _xifexpression_2 = Float.class;
        } else {
          Class<? extends Object> _xifexpression_3 = null;
          boolean _isVoidType = this._iSTextTypeSystem.isVoidType(it);
          if (_isVoidType) {
            _xifexpression_3 = Void.class;
          } else {
            Class<String> _xifexpression_4 = null;
            boolean _isStringType = this._iSTextTypeSystem.isStringType(it);
            if (_isStringType) {
              _xifexpression_4 = String.class;
            } else {
              _xifexpression_4 = null;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Object defaultValue(final Class<? extends Object> type) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type,Boolean.class)) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(type,Integer.class)) {
        _matched=true;
        _switchResult = 0;
      }
    }
    if (!_matched) {
      if (Objects.equal(type,Float.class)) {
        _matched=true;
        _switchResult = 0.0;
      }
    }
    if (!_matched) {
      if (Objects.equal(type,Void.class)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(type,String.class)) {
        _matched=true;
        _switchResult = "";
      }
    }
    return ((Comparable<Object>)_switchResult);
  }
  
  protected void _addToScope(final TimeEvent event) {
    String _name = event.getName();
    ExecutionEvent _executionEvent = new ExecutionEvent(_name, Long.class);
    final ExecutionEvent eventSlot = _executionEvent;
    this.executionContext.declareEvent(eventSlot);
    this.slotMap.put(event, eventSlot);
  }
  
  public void enter() {
    Sequence _enterSequence = this.flow.getEnterSequence();
    EList<Step> _steps = _enterSequence.getSteps();
    for (final Step step : _steps) {
      this.execute(step);
    }
  }
  
  public void exit() {
    Sequence _exitSequence = this.flow.getExitSequence();
    EList<Step> _steps = _exitSequence.getSteps();
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
  
  public void addToScope(final Declaration event) {
    if (event instanceof TimeEvent) {
      _addToScope((TimeEvent)event);
      return;
    } else if (event instanceof EventDefinition) {
      _addToScope((EventDefinition)event);
      return;
    } else if (event instanceof OperationDefinition) {
      _addToScope((OperationDefinition)event);
      return;
    } else if (event instanceof VariableDefinition) {
      _addToScope((VariableDefinition)event);
      return;
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
