package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class SequenceBuilder {
  @Inject
  private StatechartExtensions sc;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private TraceExtensions trace;
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public void defineDeepEnterSequences(final ExecutionFlow flow, final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      this.defineDeepEnterSequence(r);
    }
  }
  
  public void defineDeepEnterSequence(final State s) {
    EList<Region> _regions = s.getRegions();
    for (final Region r : _regions) {
      this.defineDeepEnterSequence(r);
    }
  }
  
  public void defineDeepEnterSequence(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    Iterable<State> _filter = Iterables.<State>filter(_vertices, State.class);
    for (final State s : _filter) {
      this.defineDeepEnterSequence(s);
    }
    boolean _requireDeepHistory = this.sgraph.requireDeepHistory(r);
    boolean _not = (!_requireDeepHistory);
    if (_not) {
      return;
    }
    final ExecutionRegion execRegion = this.mapping.create(r);
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("deepEnterSequence");
    String _name = r.getName();
    String _plus = ("deep enterSequence with history in child " + _name);
    seq.setComment(_plus);
    EList<Step> _steps = seq.getSteps();
    StateSwitch _defineDeepHistorySwitch = this.defineDeepHistorySwitch(r);
    _steps.add(_defineDeepHistorySwitch);
    execRegion.setDeepEnterSequence(seq);
  }
  
  public StateSwitch defineDeepHistorySwitch(final Region r) {
    final ExecutionRegion execRegion = this.mapping.create(r);
    SexecFactory _factory = this.sexec.factory();
    final StateSwitch sSwitch = _factory.createStateSwitch();
    StateVector _stateVector = execRegion.getStateVector();
    int _offset = _stateVector.getOffset();
    sSwitch.setStateConfigurationIdx(_offset);
    String _name = r.getName();
    String _plus = ("Handle deep history entry of " + _name);
    sSwitch.setComment(_plus);
    sSwitch.setHistoryRegion(execRegion);
    EList<Vertex> _vertices = r.getVertices();
    Iterable<State> _filter = Iterables.<State>filter(_vertices, State.class);
    for (final State child : _filter) {
      ArrayList<RegularState> _newArrayList = CollectionLiterals.<RegularState>newArrayList();
      List<RegularState> _collectLeafStates = this.sgraph.collectLeafStates(child, _newArrayList);
      final Function1<RegularState,Boolean> _function = new Function1<RegularState,Boolean>() {
          public Boolean apply(final RegularState c) {
            ExecutionState _create = SequenceBuilder.this.mapping.create(c);
            StateVector _stateVector = _create.getStateVector();
            int _offset = _stateVector.getOffset();
            int _stateConfigurationIdx = sSwitch.getStateConfigurationIdx();
            boolean _equals = (_offset == _stateConfigurationIdx);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<RegularState> _filter_1 = IterableExtensions.<RegularState>filter(_collectLeafStates, _function);
      for (final RegularState childLeaf : _filter_1) {
        {
          final ExecutionState execChild = this.mapping.create(child);
          SexecFactory _factory_1 = this.sexec.factory();
          final Sequence seq = _factory_1.createSequence();
          seq.setName("enterSequence");
          String _name_1 = child.getName();
          String _plus_1 = ("enterSequence with history in child " + _name_1);
          String _plus_2 = (_plus_1 + " for leaf ");
          String _name_2 = childLeaf.getName();
          String _plus_3 = (_plus_2 + _name_2);
          seq.setComment(_plus_3);
          boolean _isLeaf = execChild.isLeaf();
          if (_isLeaf) {
            EList<Step> _steps = seq.getSteps();
            Sequence _enterSequence = execChild.getEnterSequence();
            Call _newCall = this.mapping.newCall(_enterSequence);
            _steps.add(_newCall);
          } else {
            Step _entryAction = execChild.getEntryAction();
            boolean _notEquals = (!Objects.equal(_entryAction, null));
            if (_notEquals) {
              EList<Step> _steps_1 = seq.getSteps();
              Step _entryAction_1 = execChild.getEntryAction();
              Call _newCall_1 = this.mapping.newCall(_entryAction_1);
              _steps_1.add(_newCall_1);
            }
            boolean _isAddTraceSteps = this.trace.isAddTraceSteps();
            if (_isAddTraceSteps) {
              EList<Step> _steps_2 = seq.getSteps();
              TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(execChild);
              _steps_2.add(_newTraceStateEntered);
            }
            EList<Region> _regions = child.getRegions();
            for (final Region childRegion : _regions) {
              EList<Step> _steps_3 = seq.getSteps();
              ExecutionRegion _create = this.mapping.create(childRegion);
              Sequence _deepEnterSequence = _create.getDeepEnterSequence();
              Call _newCall_2 = this.mapping.newCall(_deepEnterSequence);
              _steps_3.add(_newCall_2);
            }
          }
          EList<StateCase> _cases = sSwitch.getCases();
          ExecutionState _create_1 = this.mapping.create(childLeaf);
          StateCase _newCase = this.sexec.newCase(_create_1, seq);
          _cases.add(_newCase);
        }
      }
    }
    return sSwitch;
  }
  
  public void defineShallowEnterSequences(final ExecutionFlow flow, final Statechart sc) {
    final TreeIterator<EObject> contents = sc.eAllContents();
    Iterator<Region> _filter = Iterators.<Region>filter(contents, Region.class);
    Iterable<Region> _iterable = IteratorExtensions.<Region>toIterable(_filter);
    for (final Region r : _iterable) {
      boolean _requireShallowHistory = this.sgraph.requireShallowHistory(r);
      if (_requireShallowHistory) {
        final ExecutionRegion execRegion = this.mapping.create(r);
        SexecFactory _factory = this.sexec.factory();
        final Sequence seq = _factory.createSequence();
        seq.setName("shallowEnterSequence");
        String _name = r.getName();
        String _plus = ("shallow enterSequence with history in child " + _name);
        seq.setComment(_plus);
        EList<Step> _steps = seq.getSteps();
        StateSwitch _defineShallowHistorySwitch = this.defineShallowHistorySwitch(r);
        _steps.add(_defineShallowHistorySwitch);
        execRegion.setShallowEnterSequence(seq);
      }
    }
  }
  
  public StateSwitch defineShallowHistorySwitch(final Region r) {
    final ExecutionRegion execRegion = this.mapping.create(r);
    SexecFactory _factory = this.sexec.factory();
    final StateSwitch sSwitch = _factory.createStateSwitch();
    StateVector _stateVector = execRegion.getStateVector();
    int _offset = _stateVector.getOffset();
    sSwitch.setStateConfigurationIdx(_offset);
    String _name = r.getName();
    String _plus = ("Handle shallow history entry of " + _name);
    sSwitch.setComment(_plus);
    ExecutionRegion _create = this.mapping.create(r);
    sSwitch.setHistoryRegion(_create);
    EList<Vertex> _vertices = r.getVertices();
    Iterable<State> _filter = Iterables.<State>filter(_vertices, State.class);
    for (final State child : _filter) {
      {
        final ExecutionState execChild = this.mapping.create(child);
        ArrayList<RegularState> _newArrayList = CollectionLiterals.<RegularState>newArrayList();
        List<RegularState> _collectLeafStates = this.sgraph.collectLeafStates(child, _newArrayList);
        final Function1<RegularState,Boolean> _function = new Function1<RegularState,Boolean>() {
            public Boolean apply(final RegularState c) {
              ExecutionState _create = SequenceBuilder.this.mapping.create(c);
              StateVector _stateVector = _create.getStateVector();
              int _offset = _stateVector.getOffset();
              int _stateConfigurationIdx = sSwitch.getStateConfigurationIdx();
              boolean _equals = (_offset == _stateConfigurationIdx);
              return Boolean.valueOf(_equals);
            }
          };
        Iterable<RegularState> _filter_1 = IterableExtensions.<RegularState>filter(_collectLeafStates, _function);
        for (final RegularState childLeaf : _filter_1) {
          EList<StateCase> _cases = sSwitch.getCases();
          ExecutionState _create_1 = this.mapping.create(childLeaf);
          Sequence _enterSequence = execChild.getEnterSequence();
          Call _newCall = this.mapping.newCall(_enterSequence);
          StateCase _newCase = this.sexec.newCase(_create_1, _newCall);
          _cases.add(_newCase);
        }
      }
    }
    return sSwitch;
  }
  
  /**
   * Defines the enter sequences of all states
   */
  public void defineStateEnterSequences(final ExecutionFlow flow, final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      this.defineStateEnterSequence(r);
    }
  }
  
  protected void _defineStateEnterSequence(final Region r) {
    final ExecutionRegion execState = this.mapping.create(r);
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("enterSequence");
    String _name = r.getName();
    String _plus = ("Default enter sequence for region " + _name);
    seq.setComment(_plus);
    EList<Vertex> _vertices = r.getVertices();
    for (final Vertex s : _vertices) {
      this.defineStateEnterSequence(s);
    }
    Entry _entry = this.sgraph.entry(r);
    final ExecutionEntry entryNode = _entry==null?(ExecutionEntry)null:this.mapping.create(_entry);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(entryNode, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Sequence _reactSequence = entryNode.getReactSequence();
      boolean _notEquals_1 = (!Objects.equal(_reactSequence, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      EList<Step> _steps = seq.getSteps();
      Sequence _reactSequence_1 = entryNode.getReactSequence();
      Call _newCall = this.mapping.newCall(_reactSequence_1);
      _steps.add(_newCall);
    }
    execState.setEnterSequence(seq);
  }
  
  protected void _defineStateEnterSequence(final Vertex v) {
  }
  
  protected void _defineStateEnterSequence(final FinalState state) {
    final ExecutionState execState = this.mapping.create(state);
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("enterSequence");
    String _name = state.getName();
    String _plus = ("Default enter sequence for state " + _name);
    seq.setComment(_plus);
    Step _entryAction = execState.getEntryAction();
    boolean _notEquals = (!Objects.equal(_entryAction, null));
    if (_notEquals) {
      EList<Step> _steps = seq.getSteps();
      Step _entryAction_1 = execState.getEntryAction();
      Call _newCall = this.mapping.newCall(_entryAction_1);
      _steps.add(_newCall);
    }
    if (this._addTraceSteps) {
      EList<Step> _steps_1 = seq.getSteps();
      TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(execState);
      _steps_1.add(_newTraceStateEntered);
    }
    EList<Step> _steps_2 = seq.getSteps();
    EnterState _newEnterStateStep = this.sexec.newEnterStateStep(execState);
    _steps_2.add(_newEnterStateStep);
    execState.setEnterSequence(seq);
  }
  
  protected void _defineStateEnterSequence(final State state) {
    final ExecutionState execState = this.mapping.create(state);
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("enterSequence");
    String _name = state.getName();
    String _plus = ("Default enter sequence for state " + _name);
    seq.setComment(_plus);
    Step _entryAction = execState.getEntryAction();
    boolean _notEquals = (!Objects.equal(_entryAction, null));
    if (_notEquals) {
      EList<Step> _steps = seq.getSteps();
      Step _entryAction_1 = execState.getEntryAction();
      Call _newCall = this.mapping.newCall(_entryAction_1);
      _steps.add(_newCall);
    }
    if (this._addTraceSteps) {
      EList<Step> _steps_1 = seq.getSteps();
      TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(execState);
      _steps_1.add(_newTraceStateEntered);
    }
    boolean _isLeaf = execState.isLeaf();
    if (_isLeaf) {
      EList<Step> _steps_2 = seq.getSteps();
      EnterState _newEnterStateStep = this.sexec.newEnterStateStep(execState);
      _steps_2.add(_newEnterStateStep);
    } else {
      EList<Region> _regions = state.getRegions();
      for (final Region r : _regions) {
        {
          this.defineStateEnterSequence(r);
          final ExecutionRegion execRegion = this.mapping.create(r);
          Sequence _enterSequence = execRegion.getEnterSequence();
          boolean _notEquals_1 = (!Objects.equal(_enterSequence, null));
          if (_notEquals_1) {
            EList<Step> _steps_3 = seq.getSteps();
            Sequence _enterSequence_1 = execRegion.getEnterSequence();
            Call _newCall_1 = this.mapping.newCall(_enterSequence_1);
            _steps_3.add(_newCall_1);
          }
        }
      }
    }
    execState.setEnterSequence(seq);
  }
  
  /**
   * Defines the exit sequences of all states
   */
  public void defineStateExitSequences(final ExecutionFlow flow, final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      this.defineStateExitSequence(r);
    }
  }
  
  protected void _defineStateExitSequence(final Region r) {
    final ExecutionRegion execRegion = this.mapping.create(r);
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("exitSequence");
    String _name = r.getName();
    String _plus = ("Default exit sequence for region " + _name);
    seq.setComment(_plus);
    EList<Vertex> _vertices = r.getVertices();
    for (final Vertex s : _vertices) {
      this.defineStateExitSequence(s);
    }
    StateVector _historyVector = execRegion.getHistoryVector();
    boolean _notEquals = (!Objects.equal(_historyVector, null));
    if (_notEquals) {
      EList<Step> _steps = seq.getSteps();
      SaveHistory _newSaveHistory = this.sexec.newSaveHistory(execRegion);
      _steps.add(_newSaveHistory);
    }
    ArrayList<RegularState> _arrayList = new ArrayList<RegularState>();
    List<RegularState> _collectLeafStates = this.sgraph.collectLeafStates(r, _arrayList);
    final Function1<RegularState,ExecutionState> _function = new Function1<RegularState,ExecutionState>() {
        public ExecutionState apply(final RegularState rs) {
          ExecutionState _create = SequenceBuilder.this.mapping.create(rs);
          return _create;
        }
      };
    final Iterable<ExecutionState> leafStates = ListExtensions.<RegularState, ExecutionState>map(_collectLeafStates, _function);
    final StateVector sVector = execRegion.getStateVector();
    int _offset = sVector.getOffset();
    int _offset_1 = sVector.getOffset();
    int _size = sVector.getSize();
    int _plus_1 = (_offset_1 + _size);
    int _minus = (_plus_1 - 1);
    Iterable<Integer> _upTo = IntegerExtensions.upTo(_offset, _minus);
    for (final Integer i : _upTo) {
      {
        final StateSwitch sSwitch = this.defineExitSwitch(execRegion, leafStates, (i).intValue());
        EList<Step> _steps_1 = seq.getSteps();
        _steps_1.add(sSwitch);
      }
    }
    execRegion.setExitSequence(seq);
  }
  
  protected void _defineStateExitSequence(final Vertex v) {
  }
  
  protected void _defineStateExitSequence(final FinalState s) {
    final ExecutionState execState = this.mapping.create(s);
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("exitSequence");
    seq.setComment("Default exit sequence for final state.");
    EList<Step> _steps = seq.getSteps();
    ExitState _newExitStateStep = this.sexec.newExitStateStep(execState);
    _steps.add(_newExitStateStep);
    if (this._addTraceSteps) {
      EList<Step> _steps_1 = seq.getSteps();
      TraceStateExited _newTraceStateExited = this.trace.newTraceStateExited(execState);
      _steps_1.add(_newTraceStateExited);
    }
    execState.setExitSequence(seq);
  }
  
  protected void _defineStateExitSequence(final State state) {
    final ExecutionState execState = this.mapping.create(state);
    SexecFactory _factory = this.sexec.factory();
    final Sequence seq = _factory.createSequence();
    seq.setName("exitSequence");
    String _name = state.getName();
    String _plus = ("Default exit sequence for state " + _name);
    seq.setComment(_plus);
    boolean _isLeaf = execState.isLeaf();
    if (_isLeaf) {
      EList<Step> _steps = seq.getSteps();
      ExitState _newExitStateStep = this.sexec.newExitStateStep(execState);
      _steps.add(_newExitStateStep);
    } else {
      EList<Region> _regions = state.getRegions();
      for (final Region r : _regions) {
        {
          this.defineStateExitSequence(r);
          final ExecutionRegion execRegion = this.mapping.create(r);
          Sequence _exitSequence = execRegion.getExitSequence();
          boolean _notEquals = (!Objects.equal(_exitSequence, null));
          if (_notEquals) {
            EList<Step> _steps_1 = seq.getSteps();
            Sequence _exitSequence_1 = execRegion.getExitSequence();
            Call _newCall = this.mapping.newCall(_exitSequence_1);
            _steps_1.add(_newCall);
          }
        }
      }
    }
    Step _exitAction = execState.getExitAction();
    boolean _notEquals = (!Objects.equal(_exitAction, null));
    if (_notEquals) {
      EList<Step> _steps_1 = seq.getSteps();
      Step _exitAction_1 = execState.getExitAction();
      Call _newCall = this.mapping.newCall(_exitAction_1);
      _steps_1.add(_newCall);
    }
    if (this._addTraceSteps) {
      EList<Step> _steps_2 = seq.getSteps();
      TraceStateExited _newTraceStateExited = this.trace.newTraceStateExited(execState);
      _steps_2.add(_newTraceStateExited);
    }
    execState.setExitSequence(seq);
  }
  
  public StateSwitch defineExitSwitch(final ExecutionRegion region, final Iterable<ExecutionState> leafStates, final int pos) {
    SexecFactory _factory = this.sexec.factory();
    StateSwitch sSwitch = _factory.createStateSwitch();
    sSwitch.setStateConfigurationIdx(pos);
    String _name = region.getName();
    String _plus = ("Handle exit of all possible states (of " + _name);
    String _plus_1 = (_plus + ") at position ");
    int _stateConfigurationIdx = sSwitch.getStateConfigurationIdx();
    String _plus_2 = (_plus_1 + Integer.valueOf(_stateConfigurationIdx));
    String _plus_3 = (_plus_2 + "...");
    sSwitch.setComment(_plus_3);
    final Function1<ExecutionState,Boolean> _function = new Function1<ExecutionState,Boolean>() {
        public Boolean apply(final ExecutionState rs) {
          boolean _and = false;
          StateVector _stateVector = rs.getStateVector();
          int _size = _stateVector.getSize();
          boolean _equals = (_size == 1);
          if (!_equals) {
            _and = false;
          } else {
            StateVector _stateVector_1 = rs.getStateVector();
            int _offset = _stateVector_1.getOffset();
            boolean _equals_1 = (_offset == pos);
            _and = (_equals && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<ExecutionState> posStates = IterableExtensions.<ExecutionState>filter(leafStates, _function);
    for (final ExecutionState s : posStates) {
      {
        SexecFactory _factory_1 = this.sexec.factory();
        final Sequence caseSeq = _factory_1.createSequence();
        final ArrayList<ExecutionScope> exitScopes = this.sexec.parentScopes(s);
        ArrayList<ExecutionScope> _parentScopes = this.sexec.parentScopes(region);
        exitScopes.removeAll(_parentScopes);
        exitScopes.remove(s);
        final Function2<Sequence,ExecutionScope,Sequence> _function_1 = new Function2<Sequence,ExecutionScope,Sequence>() {
            public Sequence apply(final Sequence cs, final ExecutionScope exitScope) {
              Sequence _xblockexpression = null;
              {
                boolean _and = false;
                if (!(exitScope instanceof ExecutionRegion)) {
                  _and = false;
                } else {
                  StateVector _historyVector = ((ExecutionRegion) exitScope).getHistoryVector();
                  boolean _notEquals = (!Objects.equal(_historyVector, null));
                  _and = ((exitScope instanceof ExecutionRegion) && _notEquals);
                }
                if (_and) {
                  final ExecutionRegion execRegion = ((ExecutionRegion) exitScope);
                  EList<Step> _steps = cs.getSteps();
                  SaveHistory _newSaveHistory = SequenceBuilder.this.sexec.newSaveHistory(execRegion);
                  _steps.add(_newSaveHistory);
                }
                _xblockexpression = (cs);
              }
              return _xblockexpression;
            }
          };
        IterableExtensions.<ExecutionScope, Sequence>fold(exitScopes, caseSeq, _function_1);
        Sequence _exitSequence = s.getExitSequence();
        boolean _notEquals = (!Objects.equal(_exitSequence, null));
        if (_notEquals) {
          EList<Step> _steps = caseSeq.getSteps();
          Sequence _exitSequence_1 = s.getExitSequence();
          Call _newCall = this.mapping.newCall(_exitSequence_1);
          _steps.add(_newCall);
        }
        final Function2<Sequence,ExecutionScope,Sequence> _function_2 = new Function2<Sequence,ExecutionScope,Sequence>() {
            public Sequence apply(final Sequence cs, final ExecutionScope exitScope) {
              Sequence _xblockexpression = null;
              {
                boolean _and = false;
                if (!(exitScope instanceof ExecutionState)) {
                  _and = false;
                } else {
                  StateVector _stateVector = s.getStateVector();
                  int _last = SequenceBuilder.this.sexec.last(_stateVector);
                  StateVector _stateVector_1 = exitScope.getStateVector();
                  int _last_1 = SequenceBuilder.this.sexec.last(_stateVector_1);
                  boolean _equals = (_last == _last_1);
                  _and = ((exitScope instanceof ExecutionState) && _equals);
                }
                if (_and) {
                  final ExecutionState execState = ((ExecutionState) exitScope);
                  Step _exitAction = execState.getExitAction();
                  boolean _notEquals = (!Objects.equal(_exitAction, null));
                  if (_notEquals) {
                    EList<Step> _steps = cs.getSteps();
                    Step _exitAction_1 = execState.getExitAction();
                    Call _newCall = SequenceBuilder.this.mapping.newCall(_exitAction_1);
                    _steps.add(_newCall);
                  }
                  if (SequenceBuilder.this._addTraceSteps) {
                    EList<Step> _steps_1 = cs.getSteps();
                    TraceStateExited _newTraceStateExited = SequenceBuilder.this.trace.newTraceStateExited(execState);
                    _steps_1.add(_newTraceStateExited);
                  }
                }
                _xblockexpression = (cs);
              }
              return _xblockexpression;
            }
          };
        IterableExtensions.<ExecutionScope, Sequence>fold(exitScopes, caseSeq, _function_2);
        EList<Step> _steps_1 = caseSeq.getSteps();
        boolean _isEmpty = _steps_1.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          EList<StateCase> _cases = sSwitch.getCases();
          StateCase _newCase = this.sexec.newCase(s, caseSeq);
          _cases.add(_newCase);
        }
      }
    }
    return sSwitch;
  }
  
  public Sequence defineStatechartExitSequence(final ExecutionFlow flow, final Statechart sc) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence exitSequence = _factory.createSequence();
    exitSequence.setName("exit");
    String _name = sc.getName();
    String _plus = ("Default exit sequence for statechart " + _name);
    exitSequence.setComment(_plus);
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      {
        final ExecutionRegion execRegion = this.mapping.create(r);
        Sequence _exitSequence = execRegion.getExitSequence();
        boolean _notEquals = (!Objects.equal(_exitSequence, null));
        if (_notEquals) {
          EList<Step> _steps = exitSequence.getSteps();
          Sequence _exitSequence_1 = execRegion.getExitSequence();
          Call _newCall = this.mapping.newCall(_exitSequence_1);
          _steps.add(_newCall);
        }
      }
    }
    Step _exitAction = flow.getExitAction();
    boolean _notEquals = (!Objects.equal(_exitAction, null));
    if (_notEquals) {
      EList<Step> _steps = exitSequence.getSteps();
      Step _exitAction_1 = flow.getExitAction();
      Call _newCall = this.mapping.newCall(_exitAction_1);
      _steps.add(_newCall);
    }
    flow.setExitSequence(exitSequence);
    return exitSequence;
  }
  
  public Sequence defineStatechartEnterSequence(final ExecutionFlow flow, final Statechart sc) {
    SexecFactory _factory = this.sexec.factory();
    final Sequence enterSequence = _factory.createSequence();
    enterSequence.setName("enter");
    String _name = sc.getName();
    String _plus = ("Default enter sequence for statechart " + _name);
    enterSequence.setComment(_plus);
    EList<Scope> _scopes = sc.getScopes();
    final Function1<Scope,EList<Variable>> _function = new Function1<Scope,EList<Variable>>() {
        public EList<Variable> apply(final Scope s) {
          EList<Variable> _variables = s.getVariables();
          return _variables;
        }
      };
    List<EList<Variable>> _map = ListExtensions.<Scope, EList<Variable>>map(_scopes, _function);
    Iterable<Variable> _flatten = Iterables.<Variable>concat(_map);
    Iterable<VariableDefinition> _filter = Iterables.<VariableDefinition>filter(_flatten, VariableDefinition.class);
    for (final VariableDefinition vd : _filter) {
      Expression _initialValue = vd.getInitialValue();
      boolean _notEquals = (!Objects.equal(_initialValue, null));
      if (_notEquals) {
        EList<Step> _steps = enterSequence.getSteps();
        Execution _createInitialization = this.createInitialization(vd);
        _steps.add(_createInitialization);
      }
    }
    List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(sc);
    for (final TimeEventSpec tes : _timeEventSpecs) {
      {
        final TimeEvent timeEvent = this.mapping.createDerivedEvent(tes);
        Statement _buildValueExpression = this.buildValueExpression(tes);
        final ScheduleTimeEvent scheduleStep = this.mapping.newScheduleTimeEvent(timeEvent, _buildValueExpression);
        EList<Step> _steps_1 = enterSequence.getSteps();
        _steps_1.add(scheduleStep);
      }
    }
    Step _entryAction = flow.getEntryAction();
    boolean _notEquals_1 = (!Objects.equal(_entryAction, null));
    if (_notEquals_1) {
      EList<Step> _steps_1 = enterSequence.getSteps();
      Step _entryAction_1 = flow.getEntryAction();
      Call _newCall = this.mapping.newCall(_entryAction_1);
      _steps_1.add(_newCall);
    }
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      {
        final ExecutionRegion execRegion = this.mapping.create(r);
        Sequence _enterSequence = execRegion.getEnterSequence();
        boolean _notEquals_2 = (!Objects.equal(_enterSequence, null));
        if (_notEquals_2) {
          EList<Step> _steps_2 = enterSequence.getSteps();
          Sequence _enterSequence_1 = execRegion.getEnterSequence();
          Call _newCall_1 = this.mapping.newCall(_enterSequence_1);
          _steps_2.add(_newCall_1);
        }
      }
    }
    flow.setEnterSequence(enterSequence);
    return enterSequence;
  }
  
  public Execution createInitialization(final VariableDefinition vd) {
    SexecFactory _factory = this.sexec.factory();
    final Execution execution = _factory.createExecution();
    StextFactory _factory_1 = this.stext.factory();
    final AssignmentExpression assignment = _factory_1.createAssignmentExpression();
    StextFactory _factory_2 = this.stext.factory();
    final ElementReferenceExpression reference = _factory_2.createElementReferenceExpression();
    reference.setReference(vd);
    assignment.setVarRef(reference);
    assignment.setOperator(AssignmentOperator.ASSIGN);
    Expression _initialValue = vd.getInitialValue();
    Expression _copy = EcoreUtil.<Expression>copy(_initialValue);
    assignment.setExpression(_copy);
    execution.setStatement(assignment);
    return execution;
  }
  
  public Statement buildValueExpression(final TimeEventSpec tes) {
    Statement _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      final PrimitiveValueExpression pve = _factory.createPrimitiveValueExpression();
      StextFactory _factory_1 = this.stext.factory();
      final IntLiteral intLit = _factory_1.createIntLiteral();
      int _value = tes.getValue();
      intLit.setValue(_value);
      pve.setValue(intLit);
      Statement _switchResult = null;
      TimeUnit _unit = tes.getUnit();
      final TimeUnit _switchValue = _unit;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,TimeUnit.MILLISECOND)) {
          _matched=true;
          _switchResult = pve;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,TimeUnit.MICROSECOND)) {
          _matched=true;
          Statement _divide = this.divide(pve, 1000);
          _switchResult = _divide;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,TimeUnit.NANOSECOND)) {
          _matched=true;
          Statement _divide_1 = this.divide(pve, 1000000);
          _switchResult = _divide_1;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,TimeUnit.SECOND)) {
          _matched=true;
          Statement _multiply = this.multiply(pve, 1000);
          _switchResult = _multiply;
        }
      }
      if (!_matched) {
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
      final NumericalMultiplyDivideExpression div = _factory.createNumericalMultiplyDivideExpression();
      StextFactory _factory_1 = this.stext.factory();
      final PrimitiveValueExpression pve = _factory_1.createPrimitiveValueExpression();
      StextFactory _factory_2 = this.stext.factory();
      final IntLiteral intLit = _factory_2.createIntLiteral();
      int _intValue = Long.valueOf(divisor).intValue();
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
      final NumericalMultiplyDivideExpression div = _factory.createNumericalMultiplyDivideExpression();
      StextFactory _factory_1 = this.stext.factory();
      final PrimitiveValueExpression pve = _factory_1.createPrimitiveValueExpression();
      StextFactory _factory_2 = this.stext.factory();
      final IntLiteral intLit = _factory_2.createIntLiteral();
      int _intValue = Long.valueOf(factor).intValue();
      intLit.setValue(_intValue);
      pve.setValue(intLit);
      div.setOperator(MultiplicativeOperator.MUL);
      div.setLeftOperand(stmnt);
      div.setRightOperand(pve);
      _xblockexpression = (div);
    }
    return _xblockexpression;
  }
  
  public void defineStateEnterSequence(final NamedElement state) {
    if (state instanceof FinalState) {
      _defineStateEnterSequence((FinalState)state);
      return;
    } else if (state instanceof State) {
      _defineStateEnterSequence((State)state);
      return;
    } else if (state instanceof Region) {
      _defineStateEnterSequence((Region)state);
      return;
    } else if (state instanceof Vertex) {
      _defineStateEnterSequence((Vertex)state);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(state).toString());
    }
  }
  
  public void defineStateExitSequence(final NamedElement s) {
    if (s instanceof FinalState) {
      _defineStateExitSequence((FinalState)s);
      return;
    } else if (s instanceof State) {
      _defineStateExitSequence((State)s);
      return;
    } else if (s instanceof Region) {
      _defineStateExitSequence((Region)s);
      return;
    } else if (s instanceof Vertex) {
      _defineStateExitSequence((Vertex)s);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
}
