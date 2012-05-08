package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.DefaultEvent;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
@Singleton
public class SexecElementMapping {
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  @Inject
  private StatechartExtensions sce;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  public ExecutionFlow create(final Statechart statechart) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(statechart);
    final ExecutionFlow _result;
    synchronized (_createCache_create) {
      if (_createCache_create.containsKey(_cacheKey)) {
        return _createCache_create.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionFlow _createExecutionFlow = _sexecFactory.createExecutionFlow();
      _result = _createExecutionFlow;
      _createCache_create.put(_cacheKey, _result);
    }
    _init_create(_result, statechart);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,ExecutionFlow> _createCache_create = CollectionLiterals.newHashMap();
  
  private void _init_create(final ExecutionFlow r, final Statechart statechart) {
    String _name = statechart.getName();
    r.setName(_name);
    r.setSourceElement(statechart);
  }
  
  protected Scope _create(final InterfaceScope scope) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(scope);
    final InterfaceScope _result;
    synchronized (_createCache_create_1) {
      if (_createCache_create_1.containsKey(_cacheKey)) {
        return _createCache_create_1.get(_cacheKey);
      }
      StextFactory _stextFactory = this.stextFactory();
      InterfaceScope _createInterfaceScope = _stextFactory.createInterfaceScope();
      _result = _createInterfaceScope;
      _createCache_create_1.put(_cacheKey, _result);
    }
    _init_create_1(_result, scope);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,Scope> _createCache_create_1 = CollectionLiterals.newHashMap();
  
  private void _init_create_1(final InterfaceScope r, final InterfaceScope scope) {
    String _name = scope.getName();
    r.setName(_name);
  }
  
  protected Scope _create(final Scope scope) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(scope);
    final InternalScope _result;
    synchronized (_createCache_create_2) {
      if (_createCache_create_2.containsKey(_cacheKey)) {
        return _createCache_create_2.get(_cacheKey);
      }
      StextFactory _stextFactory = this.stextFactory();
      InternalScope _createInternalScope = _stextFactory.createInternalScope();
      _result = _createInternalScope;
      _createCache_create_2.put(_cacheKey, _result);
    }
    _init_create_2(_result, scope);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,Scope> _createCache_create_2 = CollectionLiterals.newHashMap();
  
  private void _init_create_2(final InternalScope r, final Scope scope) {
  }
  
  public Scope timeEventScope(final ExecutionFlow flow) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(flow);
    final Scope _result;
    synchronized (_createCache_timeEventScope) {
      if (_createCache_timeEventScope.containsKey(_cacheKey)) {
        return _createCache_timeEventScope.get(_cacheKey);
      }
      SGraphFactory _factory = this.sgraph.factory();
      Scope _createScope = _factory.createScope();
      _result = _createScope;
      _createCache_timeEventScope.put(_cacheKey, _result);
    }
    _init_timeEventScope(_result, flow);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,Scope> _createCache_timeEventScope = CollectionLiterals.newHashMap();
  
  private void _init_timeEventScope(final Scope r, final ExecutionFlow flow) {
    EList<Scope> _scopes = flow.getScopes();
    _scopes.add(r);
  }
  
  public EventDefinition create(final EventDefinition event) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(event);
    final EventDefinition _result;
    synchronized (_createCache_create_3) {
      if (_createCache_create_3.containsKey(_cacheKey)) {
        return _createCache_create_3.get(_cacheKey);
      }
      EventDefinition _copy = EcoreUtil.<EventDefinition>copy(event);
      _result = _copy;
      _createCache_create_3.put(_cacheKey, _result);
    }
    _init_create_3(_result, event);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,EventDefinition> _createCache_create_3 = CollectionLiterals.newHashMap();
  
  private void _init_create_3(final EventDefinition r, final EventDefinition event) {
  }
  
  public VariableDefinition create(final VariableDefinition v) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(v);
    final VariableDefinition _result;
    synchronized (_createCache_create_4) {
      if (_createCache_create_4.containsKey(_cacheKey)) {
        return _createCache_create_4.get(_cacheKey);
      }
      VariableDefinition _copy = EcoreUtil.<VariableDefinition>copy(v);
      _result = _copy;
      _createCache_create_4.put(_cacheKey, _result);
    }
    _init_create_4(_result, v);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,VariableDefinition> _createCache_create_4 = CollectionLiterals.newHashMap();
  
  private void _init_create_4(final VariableDefinition r, final VariableDefinition v) {
  }
  
  public OperationDefinition create(final OperationDefinition v) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(v);
    final OperationDefinition _result;
    synchronized (_createCache_create_5) {
      if (_createCache_create_5.containsKey(_cacheKey)) {
        return _createCache_create_5.get(_cacheKey);
      }
      OperationDefinition _copy = EcoreUtil.<OperationDefinition>copy(v);
      _result = _copy;
      _createCache_create_5.put(_cacheKey, _result);
    }
    _init_create_5(_result, v);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,OperationDefinition> _createCache_create_5 = CollectionLiterals.newHashMap();
  
  private void _init_create_5(final OperationDefinition r, final OperationDefinition v) {
  }
  
  public ExecutionState create(final RegularState state) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(state);
    final ExecutionState _result;
    synchronized (_createCache_create_6) {
      if (_createCache_create_6.containsKey(_cacheKey)) {
        return _createCache_create_6.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionState _createExecutionState = _sexecFactory.createExecutionState();
      _result = _createExecutionState;
      _createCache_create_6.put(_cacheKey, _result);
    }
    _init_create_6(_result, state);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,ExecutionState> _createCache_create_6 = CollectionLiterals.newHashMap();
  
  private void _init_create_6(final ExecutionState r, final RegularState state) {
    boolean _notEquals = (!Objects.equal(state, null));
    if (_notEquals) {
      Region _parentRegion = state.getParentRegion();
      EList<Vertex> _vertices = _parentRegion.getVertices();
      Iterable<FinalState> _filter = Iterables.<FinalState>filter(_vertices, FinalState.class);
      List<FinalState> _list = IterableExtensions.<FinalState>toList(_filter);
      final int n = _list.indexOf(state);
      String _xifexpression = null;
      if ((state instanceof FinalState)) {
        String _plus = ("_final_" + Integer.valueOf(n));
        _xifexpression = _plus;
      } else {
        String _name = state.getName();
        _xifexpression = _name;
      }
      r.setSimpleName(_xifexpression);
      QualifiedName _fullyQualifiedName = this.qfnProvider.getFullyQualifiedName(state);
      String _string = _fullyQualifiedName.toString();
      String _replaceAll = _string.replaceAll(" ", "");
      r.setName(_replaceAll);
      r.setSourceElement(state);
    }
  }
  
  public ExecutionChoice create(final Choice choice) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(choice);
    final ExecutionChoice _result;
    synchronized (_createCache_create_7) {
      if (_createCache_create_7.containsKey(_cacheKey)) {
        return _createCache_create_7.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionChoice _createExecutionChoice = _sexecFactory.createExecutionChoice();
      _result = _createExecutionChoice;
      _createCache_create_7.put(_cacheKey, _result);
    }
    _init_create_7(_result, choice);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,ExecutionChoice> _createCache_create_7 = CollectionLiterals.newHashMap();
  
  private void _init_create_7(final ExecutionChoice r, final Choice choice) {
    boolean _notEquals = (!Objects.equal(choice, null));
    if (_notEquals) {
      Region _parentRegion = choice.getParentRegion();
      EList<Vertex> _vertices = _parentRegion.getVertices();
      Iterable<Choice> _filter = Iterables.<Choice>filter(_vertices, Choice.class);
      List<Choice> _list = IterableExtensions.<Choice>toList(_filter);
      final int n = _list.indexOf(choice);
      String _plus = ("_choice" + Integer.valueOf(n));
      String _plus_1 = (_plus + "_");
      r.setSimpleName(_plus_1);
      QualifiedName _fullyQualifiedName = this.qfnProvider.getFullyQualifiedName(choice);
      String _string = _fullyQualifiedName.toString();
      String _replaceAll = _string.replaceAll(" ", "");
      r.setName(_replaceAll);
      r.setSourceElement(choice);
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      r.setReactSequence(_createSequence);
    }
  }
  
  public ExecutionEntry create(final Entry entry) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(entry);
    final ExecutionEntry _result;
    synchronized (_createCache_create_8) {
      if (_createCache_create_8.containsKey(_cacheKey)) {
        return _createCache_create_8.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionEntry _createExecutionEntry = _sexecFactory.createExecutionEntry();
      _result = _createExecutionEntry;
      _createCache_create_8.put(_cacheKey, _result);
    }
    _init_create_8(_result, entry);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,ExecutionEntry> _createCache_create_8 = CollectionLiterals.newHashMap();
  
  private void _init_create_8(final ExecutionEntry r, final Entry entry) {
    boolean _notEquals = (!Objects.equal(entry, null));
    if (_notEquals) {
      EObject _eContainer = entry.eContainer();
      final Region region = ((Region) _eContainer);
      String _name = region.getName();
      final String regionName = StringExtensions.toFirstUpper(_name);
      String _xifexpression = null;
      EObject _eContainer_1 = region.eContainer();
      if ((_eContainer_1 instanceof State)) {
        EObject _eContainer_2 = region.eContainer();
        String _name_1 = ((State) _eContainer_2).getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_1);
        _xifexpression = _firstUpper;
      }
      final String stateName = _xifexpression;
      String _xifexpression_1 = null;
      String _name_2 = entry.getName();
      boolean _isEmpty = _name_2==null?false:_name_2.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _name_3 = entry.getName();
        _xifexpression_1 = _name_3;
      } else {
        _xifexpression_1 = "_entry_Default";
      }
      final String entryName = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _notEquals_1 = (!Objects.equal(regionName, null));
      if (_notEquals_1) {
        _xifexpression_2 = regionName;
      } else {
        _xifexpression_2 = "";
      }
      String _plus = (new Function0<String>() {
        public String apply() {
          String _xifexpression = null;
          boolean _notEquals = (!Objects.equal(regionName, null));
          if (_notEquals) {
            _xifexpression = regionName;
          } else {
            _xifexpression = "";
          }
          return _xifexpression;
        }
      }.apply() + "_");
      String _xifexpression_3 = null;
      boolean _notEquals_2 = (!Objects.equal(stateName, null));
      if (_notEquals_2) {
        _xifexpression_3 = stateName;
      } else {
        _xifexpression_3 = "";
      }
      String _plus_1 = (_plus + new Function0<Object>() {
        public Object apply() {
          String _xifexpression = null;
          boolean _notEquals = (!Objects.equal(stateName, null));
          if (_notEquals) {
            _xifexpression = stateName;
          } else {
            _xifexpression = "";
          }
          return _xifexpression;
        }
      }.apply());
      String _plus_2 = (_plus_1 + "_");
      String _plus_3 = (_plus_2 + entryName);
      r.setSimpleName(_plus_3);
      QualifiedName _fullyQualifiedName = this.qfnProvider.getFullyQualifiedName(entry);
      String _string = _fullyQualifiedName.toString();
      String _replaceAll = _string.replaceAll(" ", "");
      r.setName(_replaceAll);
      r.setSourceElement(entry);
      SexecFactory _factory = this.sexec.factory();
      final Sequence seq = _factory.createSequence();
      seq.setName("react");
      String _switchResult = null;
      EntryKind _kind = entry.getKind();
      final EntryKind _switchValue = _kind;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,EntryKind.INITIAL)) {
          _matched=true;
          _switchResult = "initial ";
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,EntryKind.DEEP_HISTORY)) {
          _matched=true;
          _switchResult = "deep history ";
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,EntryKind.SHALLOW_HISTORY)) {
          _matched=true;
          _switchResult = "shallow history ";
        }
      }
      if (!_matched) {
        _switchResult = "";
      }
      String _plus_4 = ("Default react sequence for " + _switchResult);
      String _plus_5 = (_plus_4 + "entry ");
      String _name_4 = entry.getName();
      String _plus_6 = (_plus_5 + _name_4);
      seq.setComment(_plus_6);
      r.setReactSequence(seq);
    }
  }
  
  public ExecutionRegion create(final Region region) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(region);
    final ExecutionRegion _result;
    synchronized (_createCache_create_9) {
      if (_createCache_create_9.containsKey(_cacheKey)) {
        return _createCache_create_9.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionRegion _createExecutionRegion = _sexecFactory.createExecutionRegion();
      _result = _createExecutionRegion;
      _createCache_create_9.put(_cacheKey, _result);
    }
    _init_create_9(_result, region);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,ExecutionRegion> _createCache_create_9 = CollectionLiterals.newHashMap();
  
  private void _init_create_9(final ExecutionRegion r, final Region region) {
    boolean _notEquals = (!Objects.equal(region, null));
    if (_notEquals) {
      String _name = region.getName();
      boolean _isEmpty = Strings.isEmpty(_name);
      if (_isEmpty) {
        EObject _eContainer = region.eContainer();
        final CompositeElement container = ((CompositeElement) _eContainer);
        EList<Region> _regions = container.getRegions();
        final int index = _regions.indexOf(region);
        String _plus = ("region" + Integer.valueOf(index));
        r.setName(_plus);
      } else {
        String _name_1 = region.getName();
        r.setName(_name_1);
      }
      r.setSourceElement(region);
    }
  }
  
  public Check createCheck(final ReactionTrigger tr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tr);
    final Check _result;
    synchronized (_createCache_createCheck) {
      if (_createCache_createCheck.containsKey(_cacheKey)) {
        return _createCache_createCheck.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      Check _createCheck = _sexecFactory.createCheck();
      _result = _createCheck;
      _createCache_createCheck.put(_cacheKey, _result);
    }
    _init_createCheck(_result, tr);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,Check> _createCache_createCheck = CollectionLiterals.newHashMap();
  
  private void _init_createCheck(final Check r, final ReactionTrigger tr) {
    Reaction _reaction = this.sce.reaction(tr);
    String _id = this.sce.id(_reaction);
    r.setName(_id);
  }
  
  public org.yakindu.sct.model.sexec.Reaction create(final Transition tr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tr);
    final org.yakindu.sct.model.sexec.Reaction _result;
    synchronized (_createCache_create_10) {
      if (_createCache_create_10.containsKey(_cacheKey)) {
        return _createCache_create_10.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      org.yakindu.sct.model.sexec.Reaction _createReaction = _sexecFactory.createReaction();
      _result = _createReaction;
      _createCache_create_10.put(_cacheKey, _result);
    }
    _init_create_10(_result, tr);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction> _createCache_create_10 = CollectionLiterals.newHashMap();
  
  private void _init_create_10(final org.yakindu.sct.model.sexec.Reaction r, final Transition tr) {
    String _id = this.sce.id(tr);
    r.setName(_id);
    r.setTransition(true);
    r.setSourceElement(tr);
  }
  
  public org.yakindu.sct.model.sexec.Reaction create(final LocalReaction lr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(lr);
    final org.yakindu.sct.model.sexec.Reaction _result;
    synchronized (_createCache_create_11) {
      if (_createCache_create_11.containsKey(_cacheKey)) {
        return _createCache_create_11.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      org.yakindu.sct.model.sexec.Reaction _createReaction = _sexecFactory.createReaction();
      _result = _createReaction;
      _createCache_create_11.put(_cacheKey, _result);
    }
    _init_create_11(_result, lr);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction> _createCache_create_11 = CollectionLiterals.newHashMap();
  
  private void _init_create_11(final org.yakindu.sct.model.sexec.Reaction r, final LocalReaction lr) {
    String _id = this.sce.id(lr);
    r.setName(_id);
    r.setTransition(false);
  }
  
  public CheckRef newRef(final Check check) {
    CheckRef _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final CheckRef r = _sexecFactory.createCheckRef();
      r.setCheck(check);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public Call newCall(final Step step) {
    Call _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final Call r = _sexecFactory.createCall();
      r.setStep(step);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public ScheduleTimeEvent newScheduleTimeEvent(final TimeEvent te, final Statement timeValue) {
    ScheduleTimeEvent _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final ScheduleTimeEvent r = _sexecFactory.createScheduleTimeEvent();
      r.setTimeEvent(te);
      r.setTimeValue(timeValue);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public UnscheduleTimeEvent newUnscheduleTimeEvent(final TimeEvent te) {
    UnscheduleTimeEvent _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      final UnscheduleTimeEvent r = _sexecFactory.createUnscheduleTimeEvent();
      r.setTimeEvent(te);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public TimeEvent createDerivedEvent(final TimeEventSpec tes) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tes);
    final TimeEvent _result;
    synchronized (_createCache_createDerivedEvent) {
      if (_createCache_createDerivedEvent.containsKey(_cacheKey)) {
        return _createCache_createDerivedEvent.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      TimeEvent _createTimeEvent = _sexecFactory.createTimeEvent();
      _result = _createTimeEvent;
      _createCache_createDerivedEvent.put(_cacheKey, _result);
    }
    _init_createDerivedEvent(_result, tes);
    return _result;
  }
  
  private final HashMap<ArrayList<?>,TimeEvent> _createCache_createDerivedEvent = CollectionLiterals.newHashMap();
  
  private void _init_createDerivedEvent(final TimeEvent r, final TimeEventSpec tes) {
    TimeEventType _type = tes.getType();
    boolean _equals = Objects.equal(_type, TimeEventType.EVERY);
    r.setPeriodic(_equals);
  }
  
  protected Expression _raised(final EventSpec e) {
    return null;
  }
  
  protected Expression _raised(final RegularEventSpec e) {
    StextFactory _factory = this.stext.factory();
    final ElementReferenceExpression r = _factory.createElementReferenceExpression();
    EObject _eContainer = e.eContainer();
    NamedElement _resolveRegularEventSpec = this.resolveRegularEventSpec(e, _eContainer);
    r.setReference(_resolveRegularEventSpec);
    return r;
  }
  
  protected NamedElement _resolveRegularEventSpec(final Object o, final Object context) {
    return null;
  }
  
  protected NamedElement _resolveRegularEventSpec(final RegularEventSpec re, final Object context) {
    NamedElement _xifexpression = null;
    Expression _event = re.getEvent();
    boolean _notEquals = (!Objects.equal(_event, null));
    if (_notEquals) {
      Expression _event_1 = re.getEvent();
      NamedElement _resolveRegularEventSpec = this.resolveRegularEventSpec(_event_1, re);
      _xifexpression = _resolveRegularEventSpec;
    }
    return _xifexpression;
  }
  
  protected NamedElement _resolveRegularEventSpec(final FeatureCall fc, final Object context) {
    NamedElement _xifexpression = null;
    EObject _feature = fc.getFeature();
    boolean _notEquals = (!Objects.equal(_feature, null));
    if (_notEquals) {
      EObject _feature_1 = fc.getFeature();
      NamedElement _resolveRegularEventSpec = this.resolveRegularEventSpec(_feature_1, fc);
      _xifexpression = _resolveRegularEventSpec;
    }
    return _xifexpression;
  }
  
  protected NamedElement _resolveRegularEventSpec(final ElementReferenceExpression ter, final Object context) {
    NamedElement _xifexpression = null;
    EObject _reference = ter.getReference();
    boolean _notEquals = (!Objects.equal(_reference, null));
    if (_notEquals) {
      EObject _reference_1 = ter.getReference();
      NamedElement _resolveRegularEventSpec = this.resolveRegularEventSpec(_reference_1, ter);
      _xifexpression = _resolveRegularEventSpec;
    }
    return _xifexpression;
  }
  
  protected NamedElement _resolveRegularEventSpec(final EventDefinition ed, final Object context) {
    EventDefinition _create = this.create(ed);
    return _create;
  }
  
  protected Expression _raised(final TimeEventSpec e) {
    StextFactory _factory = this.stext.factory();
    final ElementReferenceExpression r = _factory.createElementReferenceExpression();
    TimeEvent _createDerivedEvent = this.createDerivedEvent(e);
    r.setReference(_createDerivedEvent);
    return r;
  }
  
  protected Expression _raised(final OnCycleEvent e) {
    StextFactory _factory = this.stext.factory();
    final PrimitiveValueExpression r = _factory.createPrimitiveValueExpression();
    StextFactory _factory_1 = this.stext.factory();
    final BoolLiteral boolLit = _factory_1.createBoolLiteral();
    boolLit.setValue(true);
    r.setValue(boolLit);
    return r;
  }
  
  protected Expression _raised(final AlwaysEvent e) {
    StextFactory _factory = this.stext.factory();
    final PrimitiveValueExpression r = _factory.createPrimitiveValueExpression();
    StextFactory _factory_1 = this.stext.factory();
    final BoolLiteral boolLit = _factory_1.createBoolLiteral();
    boolLit.setValue(true);
    r.setValue(boolLit);
    return r;
  }
  
  protected Expression _raised(final DefaultEvent e) {
    StextFactory _factory = this.stext.factory();
    final PrimitiveValueExpression r = _factory.createPrimitiveValueExpression();
    StextFactory _factory_1 = this.stext.factory();
    final BoolLiteral boolLit = _factory_1.createBoolLiteral();
    boolLit.setValue(true);
    r.setValue(boolLit);
    return r;
  }
  
  public SexecFactory sexecFactory() {
    return SexecFactory.eINSTANCE;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public Scope create(final Scope scope) {
    if (scope instanceof InterfaceScope) {
      return _create((InterfaceScope)scope);
    } else if (scope != null) {
      return _create(scope);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(scope).toString());
    }
  }
  
  public Expression raised(final EventSpec e) {
    if (e instanceof AlwaysEvent) {
      return _raised((AlwaysEvent)e);
    } else if (e instanceof DefaultEvent) {
      return _raised((DefaultEvent)e);
    } else if (e instanceof OnCycleEvent) {
      return _raised((OnCycleEvent)e);
    } else if (e instanceof RegularEventSpec) {
      return _raised((RegularEventSpec)e);
    } else if (e instanceof TimeEventSpec) {
      return _raised((TimeEventSpec)e);
    } else if (e != null) {
      return _raised(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public NamedElement resolveRegularEventSpec(final Object ed, final Object context) {
    if (ed instanceof EventDefinition) {
      return _resolveRegularEventSpec((EventDefinition)ed, context);
    } else if (ed instanceof ElementReferenceExpression) {
      return _resolveRegularEventSpec((ElementReferenceExpression)ed, context);
    } else if (ed instanceof FeatureCall) {
      return _resolveRegularEventSpec((FeatureCall)ed, context);
    } else if (ed instanceof RegularEventSpec) {
      return _resolveRegularEventSpec((RegularEventSpec)ed, context);
    } else if (ed != null) {
      return _resolveRegularEventSpec(ed, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ed, context).toString());
    }
  }
}
