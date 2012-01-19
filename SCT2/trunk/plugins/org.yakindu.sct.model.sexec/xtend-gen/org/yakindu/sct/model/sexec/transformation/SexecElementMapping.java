package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
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
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Event;
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
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.Operation;
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
  
  private final HashMap<ArrayList<?>,ExecutionFlow> _createCache_create = new HashMap<ArrayList<?>,ExecutionFlow>();
  
  public ExecutionFlow create(final Statechart statechart) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(statechart);
    final ExecutionFlow r;
    synchronized (_createCache_create) {
      if (_createCache_create.containsKey(_cacheKey)) {
        return _createCache_create.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionFlow _createExecutionFlow = _sexecFactory.createExecutionFlow();
      r = _createExecutionFlow;
      _createCache_create.put(_cacheKey, r);
    }
    String _name = statechart.getName();
    r.setName(_name);
    return r;
  }
  
  private final HashMap<ArrayList<?>,InterfaceScope> _createCache_create_1 = new HashMap<ArrayList<?>,InterfaceScope>();
  
  protected Scope _create(final InterfaceScope scope) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(scope);
    final InterfaceScope r;
    synchronized (_createCache_create_1) {
      if (_createCache_create_1.containsKey(_cacheKey)) {
        return _createCache_create_1.get(_cacheKey);
      }
      StextFactory _stextFactory = this.stextFactory();
      InterfaceScope _createInterfaceScope = _stextFactory.createInterfaceScope();
      r = _createInterfaceScope;
      _createCache_create_1.put(_cacheKey, r);
    }
    String _name = scope.getName();
    r.setName(_name);
    return r;
  }
  
  private final HashMap<ArrayList<?>,InternalScope> _createCache_create_2 = new HashMap<ArrayList<?>,InternalScope>();
  
  protected Scope _create(final InternalScope scope) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(scope);
    final InternalScope r;
    synchronized (_createCache_create_2) {
      if (_createCache_create_2.containsKey(_cacheKey)) {
        return _createCache_create_2.get(_cacheKey);
      }
      StextFactory _stextFactory = this.stextFactory();
      InternalScope _createInternalScope = _stextFactory.createInternalScope();
      r = _createInternalScope;
      _createCache_create_2.put(_cacheKey, r);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,Scope> _createCache_timeEventScope = new HashMap<ArrayList<?>,Scope>();
  
  public Scope timeEventScope(final ExecutionFlow flow) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(flow);
    final Scope r;
    synchronized (_createCache_timeEventScope) {
      if (_createCache_timeEventScope.containsKey(_cacheKey)) {
        return _createCache_timeEventScope.get(_cacheKey);
      }
      SGraphFactory _factory = this.sgraph.factory();
      Scope _createScope = _factory.createScope();
      r = _createScope;
      _createCache_timeEventScope.put(_cacheKey, r);
    }
    EList<Scope> _scopes = flow.getScopes();
    _scopes.add(r);
    return r;
  }
  
  private final HashMap<ArrayList<?>,EventDefinition> _createCache_create_3 = new HashMap<ArrayList<?>,EventDefinition>();
  
  public EventDefinition create(final EventDefinition event) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(event);
    final EventDefinition r;
    synchronized (_createCache_create_3) {
      if (_createCache_create_3.containsKey(_cacheKey)) {
        return _createCache_create_3.get(_cacheKey);
      }
      EventDefinition _copy = EcoreUtil.<EventDefinition>copy(event);
      r = _copy;
      _createCache_create_3.put(_cacheKey, r);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,VariableDefinition> _createCache_create_4 = new HashMap<ArrayList<?>,VariableDefinition>();
  
  public VariableDefinition create(final VariableDefinition v) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(v);
    final VariableDefinition r;
    synchronized (_createCache_create_4) {
      if (_createCache_create_4.containsKey(_cacheKey)) {
        return _createCache_create_4.get(_cacheKey);
      }
      VariableDefinition _copy = EcoreUtil.<VariableDefinition>copy(v);
      r = _copy;
      _createCache_create_4.put(_cacheKey, r);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,Operation> _createCache_create_5 = new HashMap<ArrayList<?>,Operation>();
  
  public Operation create(final Operation v) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(v);
    final Operation r;
    synchronized (_createCache_create_5) {
      if (_createCache_create_5.containsKey(_cacheKey)) {
        return _createCache_create_5.get(_cacheKey);
      }
      Operation _copy = EcoreUtil.<Operation>copy(v);
      r = _copy;
      _createCache_create_5.put(_cacheKey, r);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,ExecutionState> _createCache_create_6 = new HashMap<ArrayList<?>,ExecutionState>();
  
  public ExecutionState create(final RegularState state) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(state);
    final ExecutionState r;
    synchronized (_createCache_create_6) {
      if (_createCache_create_6.containsKey(_cacheKey)) {
        return _createCache_create_6.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionState _createExecutionState = _sexecFactory.createExecutionState();
      r = _createExecutionState;
      _createCache_create_6.put(_cacheKey, r);
    }
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(state, null);
    if (_operator_notEquals) {
      {
        String _xifexpression = null;
        if ((state instanceof org.yakindu.sct.model.sgraph.FinalState)) {
          _xifexpression = "_final_";
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
    return r;
  }
  
  private final HashMap<ArrayList<?>,ExecutionChoice> _createCache_create_7 = new HashMap<ArrayList<?>,ExecutionChoice>();
  
  public ExecutionChoice create(final Choice choice) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(choice);
    final ExecutionChoice r;
    synchronized (_createCache_create_7) {
      if (_createCache_create_7.containsKey(_cacheKey)) {
        return _createCache_create_7.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionChoice _createExecutionChoice = _sexecFactory.createExecutionChoice();
      r = _createExecutionChoice;
      _createCache_create_7.put(_cacheKey, r);
    }
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(choice, null);
    if (_operator_notEquals) {
      {
        Region _parentRegion = choice.getParentRegion();
        EList<Vertex> _vertices = _parentRegion.getVertices();
        Iterable<Choice> _filter = IterableExtensions.<Choice>filter(_vertices, org.yakindu.sct.model.sgraph.Choice.class);
        List<Choice> _list = IterableExtensions.<Choice>toList(_filter);
        int _indexOf = _list.indexOf(choice);
        final int n = _indexOf;
        String _operator_plus = StringExtensions.operator_plus("_choice", ((Integer)n));
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "_");
        r.setSimpleName(_operator_plus_1);
        QualifiedName _fullyQualifiedName = this.qfnProvider.getFullyQualifiedName(choice);
        String _string = _fullyQualifiedName.toString();
        String _replaceAll = _string.replaceAll(" ", "");
        r.setName(_replaceAll);
        r.setSourceElement(choice);
        SexecFactory _sexecFactory_1 = this.sexecFactory();
        Sequence _createSequence = _sexecFactory_1.createSequence();
        r.setReactSequence(_createSequence);
      }
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,ExecutionEntry> _createCache_create_8 = new HashMap<ArrayList<?>,ExecutionEntry>();
  
  public ExecutionEntry create(final Entry entry) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(entry);
    final ExecutionEntry r;
    synchronized (_createCache_create_8) {
      if (_createCache_create_8.containsKey(_cacheKey)) {
        return _createCache_create_8.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionEntry _createExecutionEntry = _sexecFactory.createExecutionEntry();
      r = _createExecutionEntry;
      _createCache_create_8.put(_cacheKey, r);
    }
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(entry, null);
    if (_operator_notEquals) {
      {
        EObject _eContainer = entry.eContainer();
        final Region region = ((Region) _eContainer);
        String _name = region.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        final String regionName = _firstUpper;
        String _xifexpression = null;
        EObject _eContainer_1 = region.eContainer();
        if ((_eContainer_1 instanceof org.yakindu.sct.model.sgraph.State)) {
          EObject _eContainer_2 = region.eContainer();
          String _name_1 = ((State) _eContainer_2).getName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
          _xifexpression = _firstUpper_1;
        }
        final String stateName = _xifexpression;
        String _xifexpression_1 = null;
        String _name_2 = entry.getName();
        boolean _isEmpty = _name_2==null?false:_name_2.isEmpty();
        boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
        if (_operator_not) {
          String _name_3 = entry.getName();
          _xifexpression_1 = _name_3;
        } else {
          _xifexpression_1 = "Default";
        }
        final String entryName = _xifexpression_1;
        String _xifexpression_2 = null;
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(regionName, null);
        if (_operator_notEquals_1) {
          _xifexpression_2 = regionName;
        } else {
          _xifexpression_2 = "";
        }
        String _operator_plus = StringExtensions.operator_plus(_xifexpression_2, "_");
        String _xifexpression_3 = null;
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(stateName, null);
        if (_operator_notEquals_2) {
          _xifexpression_3 = stateName;
        } else {
          _xifexpression_3 = "";
        }
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _xifexpression_3);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "_");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, entryName);
        r.setSimpleName(_operator_plus_3);
        QualifiedName _fullyQualifiedName = this.qfnProvider.getFullyQualifiedName(entry);
        String _string = _fullyQualifiedName.toString();
        String _replaceAll = _string.replaceAll(" ", "");
        r.setName(_replaceAll);
        r.setSourceElement(entry);
        SexecFactory _sexecFactory_1 = this.sexecFactory();
        Sequence _createSequence = _sexecFactory_1.createSequence();
        r.setReactSequence(_createSequence);
      }
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,ExecutionRegion> _createCache_create_9 = new HashMap<ArrayList<?>,ExecutionRegion>();
  
  public ExecutionRegion create(final Region region) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(region);
    final ExecutionRegion r;
    synchronized (_createCache_create_9) {
      if (_createCache_create_9.containsKey(_cacheKey)) {
        return _createCache_create_9.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionRegion _createExecutionRegion = _sexecFactory.createExecutionRegion();
      r = _createExecutionRegion;
      _createCache_create_9.put(_cacheKey, r);
    }
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(region, null);
    if (_operator_notEquals) {
      {
        String _name = region.getName();
        r.setName(_name);
        r.setSourceElement(region);
      }
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,Check> _createCache_createCheck = new HashMap<ArrayList<?>,Check>();
  
  public Check createCheck(final ReactionTrigger tr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tr);
    final Check r;
    synchronized (_createCache_createCheck) {
      if (_createCache_createCheck.containsKey(_cacheKey)) {
        return _createCache_createCheck.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      Check _createCheck = _sexecFactory.createCheck();
      r = _createCheck;
      _createCache_createCheck.put(_cacheKey, r);
    }
    Reaction _reaction = this.sce.reaction(tr);
    String _id = this.sce.id(_reaction);
    r.setName(_id);
    return r;
  }
  
  private final HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction> _createCache_create_10 = new HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction>();
  
  public org.yakindu.sct.model.sexec.Reaction create(final Transition tr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tr);
    final org.yakindu.sct.model.sexec.Reaction r;
    synchronized (_createCache_create_10) {
      if (_createCache_create_10.containsKey(_cacheKey)) {
        return _createCache_create_10.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      org.yakindu.sct.model.sexec.Reaction _createReaction = _sexecFactory.createReaction();
      r = _createReaction;
      _createCache_create_10.put(_cacheKey, r);
    }
    {
      String _id = this.sce.id(tr);
      r.setName(_id);
      r.setTransition(true);
      r.setSourceElement(tr);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction> _createCache_create_11 = new HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction>();
  
  public org.yakindu.sct.model.sexec.Reaction create(final LocalReaction lr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(lr);
    final org.yakindu.sct.model.sexec.Reaction r;
    synchronized (_createCache_create_11) {
      if (_createCache_create_11.containsKey(_cacheKey)) {
        return _createCache_create_11.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      org.yakindu.sct.model.sexec.Reaction _createReaction = _sexecFactory.createReaction();
      r = _createReaction;
      _createCache_create_11.put(_cacheKey, r);
    }
    {
      String _id = this.sce.id(lr);
      r.setName(_id);
      r.setTransition(false);
    }
    return r;
  }
  
  public CheckRef newRef(final Check check) {
    CheckRef _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      CheckRef _createCheckRef = _sexecFactory.createCheckRef();
      final CheckRef r = _createCheckRef;
      r.setCheck(check);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public Call newCall(final Step step) {
    Call _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Call _createCall = _sexecFactory.createCall();
      final Call r = _createCall;
      r.setStep(step);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public ScheduleTimeEvent newScheduleTimeEvent(final TimeEvent te, final Statement timeValue) {
    ScheduleTimeEvent _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      ScheduleTimeEvent _createScheduleTimeEvent = _sexecFactory.createScheduleTimeEvent();
      final ScheduleTimeEvent r = _createScheduleTimeEvent;
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
      UnscheduleTimeEvent _createUnscheduleTimeEvent = _sexecFactory.createUnscheduleTimeEvent();
      final UnscheduleTimeEvent r = _createUnscheduleTimeEvent;
      r.setTimeEvent(te);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  private final HashMap<ArrayList<?>,TimeEvent> _createCache_createDerivedEvent = new HashMap<ArrayList<?>,TimeEvent>();
  
  public TimeEvent createDerivedEvent(final TimeEventSpec tes) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tes);
    final TimeEvent r;
    synchronized (_createCache_createDerivedEvent) {
      if (_createCache_createDerivedEvent.containsKey(_cacheKey)) {
        return _createCache_createDerivedEvent.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      TimeEvent _createTimeEvent = _sexecFactory.createTimeEvent();
      r = _createTimeEvent;
      _createCache_createDerivedEvent.put(_cacheKey, r);
    }
    TimeEventType _type = tes.getType();
    boolean _operator_equals = ObjectExtensions.operator_equals(_type, TimeEventType.EVERY);
    r.setPeriodic(_operator_equals);
    return r;
  }
  
  protected Expression _raised(final EventSpec e) {
    return null;
  }
  
  protected Expression _raised(final RegularEventSpec e) {
    {
      StextFactory _factory = this.stext.factory();
      ElementReferenceExpression _createElementReferenceExpression = _factory.createElementReferenceExpression();
      final ElementReferenceExpression r = _createElementReferenceExpression;
      Event _event = e.getEvent();
      EventDefinition _create = this.create(((EventDefinition) _event));
      r.setValue(_create);
      return r;
    }
  }
  
  protected Expression _raised(final TimeEventSpec e) {
    {
      StextFactory _factory = this.stext.factory();
      ElementReferenceExpression _createElementReferenceExpression = _factory.createElementReferenceExpression();
      final ElementReferenceExpression r = _createElementReferenceExpression;
      TimeEvent _createDerivedEvent = this.createDerivedEvent(e);
      r.setValue(_createDerivedEvent);
      return r;
    }
  }
  
  protected Expression _raised(final OnCycleEvent e) {
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      BoolLiteral _createBoolLiteral = _factory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  protected Expression _raised(final AlwaysEvent e) {
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      BoolLiteral _createBoolLiteral = _factory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  protected Expression _raised(final DefaultEvent e) {
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      BoolLiteral _createBoolLiteral = _factory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  public SexecFactory sexecFactory() {
    return SexecFactory.eINSTANCE;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public Scope create(final Scope scope) {
    if ((scope instanceof InterfaceScope)) {
      return _create((InterfaceScope)scope);
    } else if ((scope instanceof InternalScope)) {
      return _create((InternalScope)scope);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(scope).toString());
    }
  }
  
  public Expression raised(final EventSpec e) {
    if ((e instanceof AlwaysEvent)) {
      return _raised((AlwaysEvent)e);
    } else if ((e instanceof DefaultEvent)) {
      return _raised((DefaultEvent)e);
    } else if ((e instanceof OnCycleEvent)) {
      return _raised((OnCycleEvent)e);
    } else if ((e instanceof RegularEventSpec)) {
      return _raised((RegularEventSpec)e);
    } else if ((e instanceof TimeEventSpec)) {
      return _raised((TimeEventSpec)e);
    } else if ((e instanceof EventSpec)) {
      return _raised((EventSpec)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(e).toString());
    }
  }
}