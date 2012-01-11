package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;

@SuppressWarnings("all")
public class SequenceBuilder {
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private TraceExtensions trace;
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public void defineStateEnterSequences(final ExecutionFlow flow, final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      this.defineStateEnterSequence(r);
    }
  }
  
  protected void _defineStateEnterSequence(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    for (final Vertex s : _vertices) {
      this.defineStateEnterSequence(s);
    }
  }
  
  protected void _defineStateEnterSequence(final Vertex v) {
  }
  
  protected void _defineStateEnterSequence(final FinalState state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("enterSequence");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Default enter sequence for state ", _name);
      seq.setComment(_operator_plus);
      Step _entryAction = execState.getEntryAction();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_entryAction, null);
      if (_operator_notEquals) {
        EList<Step> _steps = seq.getSteps();
        Step _entryAction_1 = execState.getEntryAction();
        Call _newCall = this.mapping.newCall(_entryAction_1);
        _steps.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateEntered);
      }
      EList<Step> _steps_2 = seq.getSteps();
      EnterState _newEnterStateStep = this.sexec.newEnterStateStep(execState);
      CollectionExtensions.<Step>operator_add(_steps_2, _newEnterStateStep);
      execState.setEnterSequence(seq);
    }
  }
  
  protected void _defineStateEnterSequence(final State state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("enterSequence");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Default enter sequence for state ", _name);
      seq.setComment(_operator_plus);
      Step _entryAction = execState.getEntryAction();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_entryAction, null);
      if (_operator_notEquals) {
        EList<Step> _steps = seq.getSteps();
        Step _entryAction_1 = execState.getEntryAction();
        Call _newCall = this.mapping.newCall(_entryAction_1);
        _steps.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateEntered);
      }
      boolean _isLeaf = execState.isLeaf();
      if (_isLeaf) {
        EList<Step> _steps_2 = seq.getSteps();
        EnterState _newEnterStateStep = this.sexec.newEnterStateStep(execState);
        CollectionExtensions.<Step>operator_add(_steps_2, _newEnterStateStep);
      } else {
        EList<Region> _regions = state.getRegions();
        for (final Region r : _regions) {
          {
            this.defineStateEnterSequence(r);
            this.addEnterRegion(seq, r);
          }
        }
      }
      execState.setEnterSequence(seq);
    }
  }
  
  protected Boolean _addEnterRegion(final Sequence seq, final Region r) {
    Boolean _xblockexpression = null;
    {
      Entry _entry = this.sgraph.entry(r);
      State _target = this.sgraph==null?(State)null:this.sgraph.target(_entry);
      ExecutionState _create = this.mapping==null?(ExecutionState)null:this.mapping.create(_target);
      final ExecutionState entryState = _create;
      Boolean _xifexpression = null;
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(entryState, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Sequence _enterSequence = entryState.getEnterSequence();
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_enterSequence, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
      }
      if (_operator_and) {
        EList<Step> _steps = seq.getSteps();
        Sequence _enterSequence_1 = entryState.getEnterSequence();
        Call _newCall = this.mapping.newCall(_enterSequence_1);
        boolean _add = _steps.add(_newCall);
        _xifexpression = _add;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected Boolean _addEnterRegion(final Sequence seq, final ExecutionRegion r) {
    Boolean _xblockexpression = null;
    {
      EObject _sourceElement = r.getSourceElement();
      Entry _entry = this.sgraph.entry(((Region) _sourceElement));
      State _target = this.sgraph==null?(State)null:this.sgraph.target(_entry);
      ExecutionState _create = this.mapping==null?(ExecutionState)null:this.mapping.create(_target);
      final ExecutionState entryState = _create;
      Boolean _xifexpression = null;
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(entryState, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Sequence _enterSequence = entryState.getEnterSequence();
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_enterSequence, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
      }
      if (_operator_and) {
        EList<Step> _steps = seq.getSteps();
        Sequence _enterSequence_1 = entryState.getEnterSequence();
        Call _newCall = this.mapping.newCall(_enterSequence_1);
        boolean _add = _steps.add(_newCall);
        _xifexpression = _add;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public void defineStateExitSequences(final ExecutionFlow flow, final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      this.defineStateExitSequence(r);
    }
  }
  
  protected void _defineStateExitSequence(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    for (final Vertex s : _vertices) {
      this.defineStateExitSequence(s);
    }
  }
  
  protected void _defineStateExitSequence(final Vertex v) {
  }
  
  protected void _defineStateExitSequence(final FinalState s) {
    {
      ExecutionState _create = this.mapping.create(s);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitSequence");
      seq.setComment("Default exit sequence for final state.");
      EList<Step> _steps = seq.getSteps();
      ExitState _newExitStateStep = this.sexec.newExitStateStep(execState);
      CollectionExtensions.<Step>operator_add(_steps, _newExitStateStep);
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateExited _newTraceStateExited = this.trace.newTraceStateExited(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateExited);
      }
      execState.setExitSequence(seq);
    }
  }
  
  protected void _defineStateExitSequence(final State state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitSequence");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Default exit sequence for state ", _name);
      seq.setComment(_operator_plus);
      boolean _isLeaf = execState.isLeaf();
      if (_isLeaf) {
        EList<Step> _steps = seq.getSteps();
        ExitState _newExitStateStep = this.sexec.newExitStateStep(execState);
        CollectionExtensions.<Step>operator_add(_steps, _newExitStateStep);
      } else {
        {
          EList<Region> _regions = state.getRegions();
          final Function1<Region,Object> _function = new Function1<Region,Object>() {
              public Object apply(final Region r) {
                Object _xblockexpression = null;
                {
                  SequenceBuilder.this.defineStateExitSequence(r);
                  _xblockexpression = (null);
                }
                return _xblockexpression;
              }
            };
          IterableExtensions.<Region>forEach(_regions, _function);
          ArrayList<RegularState> _arrayList = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates = this.sgraph.collectLeafStates(state, _arrayList);
          final List<RegularState> leafStates = _collectLeafStates;
          StateVector _stateVector = execState.getStateVector();
          final StateVector sVector = _stateVector;
          int _offset = sVector.getOffset();
          int _offset_1 = sVector.getOffset();
          int _size = sVector.getSize();
          int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_offset_1), ((Integer)_size));
          int _operator_minus = IntegerExtensions.operator_minus(((Integer)_operator_plus_1), ((Integer)1));
          Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)_offset), ((Integer)_operator_minus));
          for (final Integer i : _operator_upTo) {
            {
              StateSwitch _defineExitSwitch = this.defineExitSwitch(state, leafStates, i);
              StateSwitch sSwitch = _defineExitSwitch;
              EList<Step> _steps_1 = seq.getSteps();
              _steps_1.add(sSwitch);
            }
          }
        }
      }
      Step _exitAction = execState.getExitAction();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_exitAction, null);
      if (_operator_notEquals) {
        EList<Step> _steps_2 = seq.getSteps();
        Step _exitAction_1 = execState.getExitAction();
        Call _newCall = this.mapping.newCall(_exitAction_1);
        _steps_2.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_3 = seq.getSteps();
        TraceStateExited _newTraceStateExited = this.trace.newTraceStateExited(execState);
        CollectionExtensions.<Step>operator_add(_steps_3, _newTraceStateExited);
      }
      execState.setExitSequence(seq);
    }
  }
  
  public StateSwitch defineExitSwitch(final State state, final List<RegularState> states, final int pos) {
    {
      SexecFactory _factory = this.sexec.factory();
      StateSwitch _createStateSwitch = _factory.createStateSwitch();
      StateSwitch sSwitch = _createStateSwitch;
      sSwitch.setStateConfigurationIdx(pos);
      int _stateConfigurationIdx = sSwitch.getStateConfigurationIdx();
      String _operator_plus = StringExtensions.operator_plus("Handle exit of all possible states on position ", ((Integer)_stateConfigurationIdx));
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "...");
      sSwitch.setComment(_operator_plus_1);
      final Function1<RegularState,Boolean> _function = new Function1<RegularState,Boolean>() {
          public Boolean apply(final RegularState rs) {
            boolean _operator_and = false;
            ExecutionState _create = SequenceBuilder.this.mapping.create(rs);
            StateVector _stateVector = _create.getStateVector();
            int _size = _stateVector.getSize();
            boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)1));
            if (!_operator_equals) {
              _operator_and = false;
            } else {
              ExecutionState _create_1 = SequenceBuilder.this.mapping.create(rs);
              StateVector _stateVector_1 = _create_1.getStateVector();
              int _offset = _stateVector_1.getOffset();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_offset), ((Integer)pos));
              _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_equals_1);
            }
            return ((Boolean)_operator_and);
          }
        };
      Iterable<RegularState> _filter = IterableExtensions.<RegularState>filter(states, _function);
      List<RegularState> _list = IterableExtensions.<RegularState>toList(_filter);
      final List<RegularState> posStates = _list;
      for (final RegularState s : posStates) {
        {
          SexecFactory _factory_1 = this.sexec.factory();
          Sequence _createSequence = _factory_1.createSequence();
          final Sequence caseSeq = _createSequence;
          EList<Step> _steps = caseSeq.getSteps();
          ExecutionState _create_2 = this.mapping.create(s);
          Sequence _exitSequence = _create_2.getExitSequence();
          Call _newCall = this.mapping.newCall(_exitSequence);
          CollectionExtensions.<Step>operator_add(_steps, _newCall);
          ExecutionState _create_3 = this.mapping.create(s);
          final ExecutionState es = _create_3;
          List<RegularState> _parentStates = this.sgraph.parentStates(s);
          final List<RegularState> exitStates = _parentStates;
          List<RegularState> _parentStates_1 = this.sgraph.parentStates(state);
          exitStates.removeAll(_parentStates_1);
          exitStates.remove(s);
          final Function2<Sequence,RegularState,Sequence> _function_1 = new Function2<Sequence,RegularState,Sequence>() {
              public Sequence apply(final Sequence cs , final RegularState exitState) {
                Sequence _xblockexpression = null;
                {
                  StateVector _stateVector_2 = es.getStateVector();
                  int _last = SequenceBuilder.this.sexec.last(_stateVector_2);
                  ExecutionState _create_4 = SequenceBuilder.this.mapping.create(exitState);
                  StateVector _stateVector_3 = _create_4.getStateVector();
                  int _last_1 = SequenceBuilder.this.sexec.last(_stateVector_3);
                  boolean _operator_equals_2 = ObjectExtensions.operator_equals(((Integer)_last), ((Integer)_last_1));
                  if (_operator_equals_2) {
                    {
                      ExecutionState _create_5 = SequenceBuilder.this.mapping.create(exitState);
                      Step _exitAction = _create_5.getExitAction();
                      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_exitAction, null);
                      if (_operator_notEquals) {
                        EList<Step> _steps_1 = cs.getSteps();
                        ExecutionState _create_6 = SequenceBuilder.this.mapping.create(exitState);
                        Step _exitAction_1 = _create_6.getExitAction();
                        Call _newCall_1 = SequenceBuilder.this.mapping.newCall(_exitAction_1);
                        _steps_1.add(_newCall_1);
                      }
                      if (SequenceBuilder.this._addTraceSteps) {
                        EList<Step> _steps_2 = cs.getSteps();
                        ExecutionState _create_7 = SequenceBuilder.this.mapping.create(exitState);
                        TraceStateExited _newTraceStateExited = SequenceBuilder.this.trace.newTraceStateExited(_create_7);
                        _steps_2.add(_newTraceStateExited);
                      }
                    }
                  }
                  _xblockexpression = (cs);
                }
                return _xblockexpression;
              }
            };
          IterableExtensions.<RegularState, Sequence>fold(exitStates, caseSeq, _function_1);
          ExecutionState _create_8 = this.mapping.create(s);
          Sequence _exitSequence_1 = _create_8.getExitSequence();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_exitSequence_1, null);
          if (_operator_notEquals_1) {
            EList<StateCase> _cases = sSwitch.getCases();
            ExecutionState _create_9 = this.mapping.create(s);
            StateCase _newCase = this.sexec.newCase(_create_9, caseSeq);
            _cases.add(_newCase);
          }
        }
      }
      return sSwitch;
    }
  }
  
  public Sequence defineStatechartEnterSequence(final ExecutionFlow flow, final Statechart sc) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence enterSequence = _createSequence;
      enterSequence.setName("enter");
      String _name = sc.getName();
      String _operator_plus = StringExtensions.operator_plus("Default enter sequence for statechart ", _name);
      enterSequence.setComment(_operator_plus);
      EList<Region> _regions = sc.getRegions();
      for (final Region r : _regions) {
        this.addEnterRegion(enterSequence, r);
      }
      flow.setEnterSequence(enterSequence);
      return enterSequence;
    }
  }
  
  public void defineStateEnterSequence(final NamedElement state) {
    if ((state instanceof FinalState)) {
      _defineStateEnterSequence((FinalState)state);
    } else if ((state instanceof State)) {
      _defineStateEnterSequence((State)state);
    } else if ((state instanceof Region)) {
      _defineStateEnterSequence((Region)state);
    } else if ((state instanceof Vertex)) {
      _defineStateEnterSequence((Vertex)state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(state).toString());
    }
  }
  
  public Boolean addEnterRegion(final Sequence seq, final EObject r) {
    if ((seq instanceof Sequence)
         && (r instanceof ExecutionRegion)) {
      return _addEnterRegion((Sequence)seq, (ExecutionRegion)r);
    } else if ((seq instanceof Sequence)
         && (r instanceof Region)) {
      return _addEnterRegion((Sequence)seq, (Region)r);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(seq, r).toString());
    }
  }
  
  public void defineStateExitSequence(final NamedElement s) {
    if ((s instanceof FinalState)) {
      _defineStateExitSequence((FinalState)s);
    } else if ((s instanceof State)) {
      _defineStateExitSequence((State)s);
    } else if ((s instanceof Region)) {
      _defineStateExitSequence((Region)s);
    } else if ((s instanceof Vertex)) {
      _defineStateExitSequence((Vertex)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(s).toString());
    }
  }
}