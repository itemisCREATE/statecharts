package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.FactoryExtension;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.DefaultEvent;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class ModelSequencer {
  
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  @Inject
  private FactoryExtension factory;
  
  @Inject
  private StatechartExtensions sct;
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public ExecutionFlow transform(final Statechart sc) {
    {
      ExecutionFlow _create = this.factory.create(sc);
      final ExecutionFlow ef = _create;
      this.mapScopes(sc, ef);
      this.mapRegularStates(sc, ef);
      this.mapRegions(sc, ef);
      this.mapPseudoStates(sc, ef);
      this.mapTimeEvents(sc, ef);
      this.defineStateVector(ef, sc);
      this.defineStateEnterSequences(ef, sc);
      this.defineStateExitSequences(ef, sc);
      this.defineEnterSequence(ef, sc);
      this.mapTransitions(sc, ef);
      this.mapLocalReactions(sc, ef);
      this.mapChoiceTransitions(sc, ef);
      this.defineRegularStateReactions(ef, sc);
      this.definePseudoStateReactions(ef, sc);
      this.retargetDeclRefs(ef);
      return ef;
    }
  }
  
  public ExecutionFlow mapScopes(final Statechart sc, final ExecutionFlow flow) {
    ExecutionFlow _xblockexpression = null;
    {
      EList<Scope> _scopes = flow.getScopes();
      EList<Scope> _scopes_1 = sc.getScopes();
      final Function1<Scope,Scope> _function = new Function1<Scope,Scope>() {
          public Scope apply(final Scope scope) {
            Scope _map = ModelSequencer.this.map(scope);
            return _map;
          }
        };
      List<Scope> _map_1 = ListExtensions.<Scope, Scope>map(_scopes_1, _function);
      _scopes.addAll(_map_1);
      _xblockexpression = (flow);
    }
    return _xblockexpression;
  }
  
  public Scope map(final Scope scope) {
    {
      Scope _create = this.factory.create(scope);
      final Scope _scope = _create;
      EList<Declaration> _declarations = _scope.getDeclarations();
      EList<Declaration> _declarations_1 = scope.getDeclarations();
      final Function1<Declaration,Declaration> _function = new Function1<Declaration,Declaration>() {
          public Declaration apply(final Declaration decl) {
            Declaration _map = ModelSequencer.this.map(decl);
            return _map;
          }
        };
      List<Declaration> _map_1 = ListExtensions.<Declaration, Declaration>map(_declarations_1, _function);
      final Function1<Declaration,Boolean> _function_1 = new Function1<Declaration,Boolean>() {
          public Boolean apply(final Declaration e) {
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(e, null);
            return ((Boolean)_operator_notEquals);
          }
        };
      Iterable<Declaration> _filter = IterableExtensions.<Declaration>filter(_map_1, _function_1);
      CollectionExtensions.<Declaration>addAll(_declarations, _filter);
      return _scope;
    }
  }
  
  protected Declaration _map(final Declaration decl) {
    return null;
  }
  
  protected Declaration _map(final EventDefinition e) {
    {
      EventDefinition _create = this.factory.create(e);
      final EventDefinition _e = _create;
      return _e;
    }
  }
  
  protected Declaration _map(final VariableDefinition v) {
    {
      VariableDefinition _create = this.factory.create(v);
      final VariableDefinition _v = _create;
      return _v;
    }
  }
  
  public ExecutionFlow mapRegularStates(final Statechart statechart, final ExecutionFlow r) {
    {
      List<RegularState> _allRegularStates = this.sct.allRegularStates(statechart);
      final List<RegularState> allStates = _allRegularStates;
      EList<ExecutionState> _states = r.getStates();
      final Function1<RegularState,ExecutionState> _function = new Function1<RegularState,ExecutionState>() {
          public ExecutionState apply(final RegularState s) {
            ExecutionState _mapState = ModelSequencer.this.mapState(s);
            return _mapState;
          }
        };
      List<ExecutionState> _map = ListExtensions.<RegularState, ExecutionState>map(allStates, _function);
      _states.addAll(_map);
      return r;
    }
  }
  
  public ExecutionFlow mapRegions(final Statechart statechart, final ExecutionFlow flow) {
    {
      List<Region> _allRegions = this.sct.allRegions(statechart);
      final List<Region> allRegions = _allRegions;
      EList<ExecutionRegion> _regions = flow.getRegions();
      final Function1<Region,ExecutionRegion> _function = new Function1<Region,ExecutionRegion>() {
          public ExecutionRegion apply(final Region r) {
            ExecutionRegion _mapRegion = ModelSequencer.this.mapRegion(r);
            return _mapRegion;
          }
        };
      List<ExecutionRegion> _map = ListExtensions.<Region, ExecutionRegion>map(allRegions, _function);
      _regions.addAll(_map);
      return flow;
    }
  }
  
  public ExecutionRegion mapRegion(final Region region) {
    {
      ExecutionRegion _create = this.factory.create(region);
      final ExecutionRegion _region = _create;
      CompositeElement _composite = region.getComposite();
      if ((_composite instanceof org.yakindu.sct.model.sgraph.Statechart)) {
        CompositeElement _composite_1 = region.getComposite();
        ExecutionFlow _create_1 = this.factory.create(((Statechart) _composite_1));
        _region.setSuperScope(_create_1);
      } else {
        CompositeElement _composite_2 = region.getComposite();
        ExecutionState _create_2 = this.factory.create(((State) _composite_2));
        _region.setSuperScope(_create_2);
      }
      EList<ExecutionScope> _subScopes = _region.getSubScopes();
      EList<Vertex> _vertices = region.getVertices();
      Iterable<RegularState> _filter = IterableExtensions.<RegularState>filter(_vertices, org.yakindu.sct.model.sgraph.RegularState.class);
      final Function1<RegularState,ExecutionScope> _function = new Function1<RegularState,ExecutionScope>() {
          public ExecutionScope apply(final RegularState v) {
            ExecutionState _create_3 = ModelSequencer.this.factory.create(v);
            return ((ExecutionScope) _create_3);
          }
        };
      Iterable<ExecutionScope> _map = IterableExtensions.<RegularState, ExecutionScope>map(_filter, _function);
      CollectionExtensions.<ExecutionScope>addAll(_subScopes, _map);
      return _region;
    }
  }
  
  public ExecutionFlow mapPseudoStates(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      List<Choice> _allChoices = this.sct.allChoices(statechart);
      final List<Choice> allChoices = _allChoices;
      EList<ExecutionNode> _nodes = r.getNodes();
      final Function1<Choice,ExecutionChoice> _function = new Function1<Choice,ExecutionChoice>() {
          public ExecutionChoice apply(final Choice choice) {
            ExecutionChoice _create = ModelSequencer.this.factory.create(choice);
            return _create;
          }
        };
      List<ExecutionChoice> _map = ListExtensions.<Choice, ExecutionChoice>map(allChoices, _function);
      _nodes.addAll(_map);
      return r;
    }
  }
  
  protected ExecutionState _mapState(final FinalState state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState _state = _create;
      _state.setLeaf(true);
      _state.setEntryAction(null);
      _state.setExitAction(null);
      return _state;
    }
  }
  
  protected ExecutionState _mapState(final State state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState _state = _create;
      boolean _isSimple = state.isSimple();
      _state.setLeaf(_isSimple);
      Step _mapEntryAction = this.mapEntryAction(state);
      _state.setEntryAction(_mapEntryAction);
      Step _mapExitAction = this.mapExitAction(state);
      _state.setExitAction(_mapExitAction);
      return _state;
    }
  }
  
  protected ExecutionState _mapState(final RegularState state) {
    return null;
  }
  
  public ExecutionFlow mapTimeEvents(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      Iterable<State> _filter = IterableExtensions.<State>filter(content, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,ArrayList<TimeEvent>> _function = new Function1<State,ArrayList<TimeEvent>>() {
          public ArrayList<TimeEvent> apply(final State s) {
            ArrayList<TimeEvent> _mapTimeEventSpecs = ModelSequencer.this.mapTimeEventSpecs(s);
            return _mapTimeEventSpecs;
          }
        };
      IterableExtensions.<State>forEach(allStates, _function);
      return r;
    }
  }
  
  public ArrayList<TimeEvent> mapTimeEventSpecs(final State state) {
    ArrayList<TimeEvent> _xblockexpression = null;
    {
      List<TimeEventSpec> _timeEventSpecs = this.sct.timeEventSpecs(state);
      final List<TimeEventSpec> timeEventSpecs = _timeEventSpecs;
      ArrayList<TimeEvent> _arrayList = new ArrayList<TimeEvent>();
      final ArrayList<TimeEvent> result = _arrayList;
      for (final TimeEventSpec tes : timeEventSpecs) {
        {
          TimeEvent _createDerivedEvent = this.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          String _name = state.getName();
          String _operator_plus = StringExtensions.operator_plus(_name, "_time_event_");
          int _indexOf = timeEventSpecs.indexOf(tes);
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ((Integer)_indexOf));
          timeEvent.setName(_operator_plus_1);
          Statechart _statechart = this.sct.statechart(state);
          ExecutionFlow _create = this.factory.create(_statechart);
          Scope _timeEventScope = this.timeEventScope(_create);
          EList<Declaration> _declarations = _timeEventScope.getDeclarations();
          _declarations.add(timeEvent);
          result.add(timeEvent);
        }
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public ExecutionFlow mapChoiceTransitions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<Choice> _allChoices = this.sct.allChoices(statechart);
      final Function1<Choice,ExecutionChoice> _function = new Function1<Choice,ExecutionChoice>() {
          public ExecutionChoice apply(final Choice choice) {
            ExecutionChoice _mapChoiceTransition = ModelSequencer.this.mapChoiceTransition(choice);
            return _mapChoiceTransition;
          }
        };
      IterableExtensions.<Choice>forEach(_allChoices, _function);
      return r;
    }
  }
  
  public ExecutionChoice mapChoiceTransition(final Choice choice) {
    {
      ExecutionChoice _create = this.factory.create(choice);
      final ExecutionChoice _choice = _create;
      EList<Reaction> _reactions = _choice.getReactions();
      EList<Transition> _outgoingTransitions = choice.getOutgoingTransitions();
      final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
          public Reaction apply(final Transition t) {
            Reaction _mapTransition = ModelSequencer.this.mapTransition(t);
            return _mapTransition;
          }
        };
      List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
      _reactions.addAll(_map);
      return _choice;
    }
  }
  
  public ExecutionFlow mapTransitions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            return ((Boolean)(e instanceof org.yakindu.sct.model.sgraph.State));
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(content, _function);
      final Iterable<EObject> allStates = _filter;
      final Function1<EObject,ExecutionState> _function_1 = new Function1<EObject,ExecutionState>() {
          public ExecutionState apply(final EObject s) {
            ExecutionState _mapStateTransition = ModelSequencer.this.mapStateTransition(((State) s));
            return _mapStateTransition;
          }
        };
      IterableExtensions.<EObject>forEach(allStates, _function_1);
      return r;
    }
  }
  
  public ExecutionState mapStateTransition(final State state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState _state = _create;
      EList<Reaction> _reactions = _state.getReactions();
      EList<Transition> _outgoingTransitions = state.getOutgoingTransitions();
      final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
          public Reaction apply(final Transition t) {
            Reaction _mapTransition = ModelSequencer.this.mapTransition(t);
            return _mapTransition;
          }
        };
      List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
      _reactions.addAll(_map);
      return _state;
    }
  }
  
  public Reaction mapTransition(final Transition t) {
    {
      Reaction _create = this.factory.create(t);
      final Reaction r = _create;
      Trigger _trigger = t.getTrigger();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
      if (_operator_notEquals) {
        Trigger _trigger_1 = t.getTrigger();
        Check _mapToCheck = this.mapToCheck(_trigger_1);
        r.setCheck(_mapToCheck);
      }
      Sequence _mapToEffect = this.mapToEffect(t, r);
      r.setEffect(_mapToEffect);
      return r;
    }
  }
  
  public ExecutionFlow mapLocalReactions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            return ((Boolean)(e instanceof org.yakindu.sct.model.sgraph.State));
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(content, _function);
      final Iterable<EObject> allStates = _filter;
      final Function1<EObject,ExecutionState> _function_1 = new Function1<EObject,ExecutionState>() {
          public ExecutionState apply(final EObject s) {
            ExecutionState _mapStateLocalReactions = ModelSequencer.this.mapStateLocalReactions(((State) s));
            return _mapStateLocalReactions;
          }
        };
      IterableExtensions.<EObject>forEach(allStates, _function_1);
      return r;
    }
  }
  
  public ExecutionState mapStateLocalReactions(final State state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState _state = _create;
      EList<Reaction> _reactions = _state.getReactions();
      EList<org.yakindu.sct.model.sgraph.Reaction> _localReactions = state.getLocalReactions();
      Iterable<LocalReaction> _filter = IterableExtensions.<LocalReaction>filter(_localReactions, org.yakindu.sct.model.stext.stext.LocalReaction.class);
      final Function1<LocalReaction,Boolean> _function = new Function1<LocalReaction,Boolean>() {
          public Boolean apply(final LocalReaction lr) {
            boolean _operator_or = false;
            Trigger _trigger = lr.getTrigger();
            EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
            boolean _isEmpty = _triggers.isEmpty();
            if (_isEmpty) {
              _operator_or = true;
            } else {
              Trigger _trigger_1 = lr.getTrigger();
              EList<EventSpec> _triggers_1 = ((ReactionTrigger) _trigger_1).getTriggers();
              final Function1<EventSpec,Boolean> _function_1 = new Function1<EventSpec,Boolean>() {
                  public Boolean apply(final EventSpec t) {
                    boolean _operator_or_1 = false;
                    boolean _operator_or_2 = false;
                    boolean _operator_or_3 = false;
                    if ((t instanceof org.yakindu.sct.model.stext.stext.RegularEventSpec)) {
                      _operator_or_3 = true;
                    } else {
                      _operator_or_3 = BooleanExtensions.operator_or((t instanceof org.yakindu.sct.model.stext.stext.RegularEventSpec), (t instanceof org.yakindu.sct.model.stext.stext.TimeEventSpec));
                    }
                    if (_operator_or_3) {
                      _operator_or_2 = true;
                    } else {
                      _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, (t instanceof org.yakindu.sct.model.stext.stext.OnCycleEvent));
                    }
                    if (_operator_or_2) {
                      _operator_or_1 = true;
                    } else {
                      _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, (t instanceof org.yakindu.sct.model.stext.stext.AlwaysEvent));
                    }
                    return ((Boolean)_operator_or_1);
                  }
                };
              Iterable<EventSpec> _filter_1 = IterableExtensions.<EventSpec>filter(_triggers_1, _function_1);
              List<EventSpec> _list = IterableExtensions.<EventSpec>toList(_filter_1);
              boolean _isEmpty_1 = _list.isEmpty();
              boolean _operator_not = BooleanExtensions.operator_not(_isEmpty_1);
              _operator_or = BooleanExtensions.operator_or(_isEmpty, _operator_not);
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<LocalReaction> _filter_2 = IterableExtensions.<LocalReaction>filter(_filter, _function);
      final Function1<LocalReaction,Reaction> _function_2 = new Function1<LocalReaction,Reaction>() {
          public Reaction apply(final LocalReaction t_1) {
            Reaction _mapReaction = ModelSequencer.this.mapReaction(t_1);
            return _mapReaction;
          }
        };
      Iterable<Reaction> _map = IterableExtensions.<LocalReaction, Reaction>map(_filter_2, _function_2);
      CollectionExtensions.<Reaction>addAll(_reactions, _map);
      return _state;
    }
  }
  
  public Reaction mapReaction(final LocalReaction lr) {
    {
      Reaction _create = this.factory.create(lr);
      final Reaction r = _create;
      Trigger _trigger = lr.getTrigger();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
      if (_operator_notEquals) {
        Trigger _trigger_1 = lr.getTrigger();
        Check _mapToCheck = this.mapToCheck(_trigger_1);
        r.setCheck(_mapToCheck);
      }
      Sequence _mapToEffect = this.mapToEffect(lr);
      r.setEffect(_mapToEffect);
      return r;
    }
  }
  
  protected StateVector _stateVector(final Vertex v) {
    return null;
  }
  
  protected StateVector _stateVector(final RegularState s) {
    ExecutionState _create = this.factory.create(s);
    StateVector _stateVector = _create.getStateVector();
    return _stateVector;
  }
  
  protected StateVector _stateVector(final Choice choice) {
    Region _parentRegion = choice.getParentRegion();
    ExecutionRegion _create = this.factory.create(_parentRegion);
    StateVector _stateVector = _create.getStateVector();
    return _stateVector;
  }
  
  public int last(final StateVector sv) {
    int _offset = sv.getOffset();
    int _size = sv.getSize();
    int _operator_plus = IntegerExtensions.operator_plus(((Integer)_offset), ((Integer)_size));
    int _operator_minus = IntegerExtensions.operator_minus(((Integer)_operator_plus), ((Integer)1));
    return _operator_minus;
  }
  
  public int first(final StateVector sv) {
    int _offset = sv.getOffset();
    return _offset;
  }
  
  public Sequence mapToEffect(final Transition t, final Reaction r) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence sequence = _createSequence;
      List<State> _exitStates = this.exitStates(t);
      State _last = IterableExtensions.<State>last(_exitStates);
      final State topExitState = _last;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(topExitState, null);
      if (_operator_notEquals) {
        {
          ArrayList<RegularState> _arrayList = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates = this.collectLeafStates(topExitState, _arrayList);
          final List<RegularState> leafStates = _collectLeafStates;
          StateVector _stateVector = this.stateVector(topExitState);
          final StateVector topVector = _stateVector;
          Vertex _source = t.getSource();
          StateVector _stateVector_1 = this.stateVector(_source);
          final StateVector sourceVector = _stateVector_1;
          int _offset = topVector.getOffset();
          int _offset_1 = sourceVector.getOffset();
          Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)_offset), ((Integer)_offset_1));
          int _offset_2 = sourceVector.getOffset();
          int _offset_3 = topVector.getOffset();
          int _operator_minus = IntegerExtensions.operator_minus(((Integer)_offset_2), ((Integer)_offset_3));
          Iterable<Integer> _take = IterableExtensions.<Integer>take(_operator_upTo, _operator_minus);
          final Iterable<Integer> prepositions = _take;
          for (final Integer i : prepositions) {
            {
              StateSwitch _defineExitSwitch = this.defineExitSwitch(topExitState, leafStates, i);
              StateSwitch sSwitch = _defineExitSwitch;
              EList<Step> _steps = sequence.getSteps();
              _steps.add(sSwitch);
            }
          }
        }
      }
      boolean _operator_and = false;
      Vertex _source_1 = t.getSource();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_source_1, null);
      if (!_operator_notEquals_1) {
        _operator_and = false;
      } else {
        Vertex _source_2 = t.getSource();
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals_1, (_source_2 instanceof org.yakindu.sct.model.sgraph.RegularState));
      }
      if (_operator_and) {
        EList<Step> _steps_1 = sequence.getSteps();
        Vertex _source_3 = t.getSource();
        ExecutionState _create = this.factory.create(((RegularState) _source_3));
        Sequence _exitSequence = _create.getExitSequence();
        Call _newCall = this.factory.newCall(_exitSequence);
        _steps_1.add(_newCall);
      }
      List<State> _exitStates_1 = this.exitStates(t);
      final Function2<Sequence,State,Sequence> _function = new Function2<Sequence,State,Sequence>() {
          public Sequence apply(final Sequence seq , final State state) {
            Sequence _xblockexpression = null;
            {
              boolean _operator_and_1 = false;
              Vertex _source_4 = t.getSource();
              boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(state, _source_4);
              if (!_operator_notEquals_2) {
                _operator_and_1 = false;
              } else {
                boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(state, topExitState);
                _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals_2, _operator_notEquals_3);
              }
              if (_operator_and_1) {
                Vertex _source_5 = t.getSource();
                StateVector _stateVector_2 = ModelSequencer.this.stateVector(_source_5);
                int _last_1 = ModelSequencer.this.last(_stateVector_2);
                ExecutionState _create_1 = ModelSequencer.this.factory.create(state);
                StateVector _stateVector_3 = _create_1.getStateVector();
                int _last_2 = ModelSequencer.this.last(_stateVector_3);
                boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_last_1), ((Integer)_last_2));
                if (_operator_equals) {
                  {
                    ExecutionState _create_2 = ModelSequencer.this.factory.create(state);
                    Step _exitAction = _create_2.getExitAction();
                    boolean _operator_notEquals_4 = ObjectExtensions.operator_notEquals(_exitAction, null);
                    if (_operator_notEquals_4) {
                      EList<Step> _steps_2 = seq.getSteps();
                      ExecutionState _create_3 = ModelSequencer.this.factory.create(state);
                      Step _exitAction_1 = _create_3.getExitAction();
                      Call _newCall_1 = ModelSequencer.this.factory.newCall(_exitAction_1);
                      _steps_2.add(_newCall_1);
                    }
                    if (ModelSequencer.this._addTraceSteps) {
                      EList<Step> _steps_3 = seq.getSteps();
                      ExecutionState _create_4 = ModelSequencer.this.factory.create(state);
                      TraceStateExited _newTraceStateExited = ModelSequencer.this.newTraceStateExited(_create_4);
                      CollectionExtensions.<Step>operator_add(_steps_3, _newTraceStateExited);
                    }
                  }
                }
              }
              _xblockexpression = (seq);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<State, Sequence>fold(_exitStates_1, sequence, _function);
      boolean _operator_notEquals_5 = ObjectExtensions.operator_notEquals(topExitState, null);
      if (_operator_notEquals_5) {
        {
          ArrayList<RegularState> _arrayList_1 = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates_1 = this.collectLeafStates(topExitState, _arrayList_1);
          final List<RegularState> leafStates_1 = _collectLeafStates_1;
          StateVector _stateVector_4 = this.stateVector(topExitState);
          final StateVector topVector_1 = _stateVector_4;
          Vertex _source_6 = t.getSource();
          StateVector _stateVector_5 = this.stateVector(_source_6);
          final StateVector sourceVector_1 = _stateVector_5;
          int _last_3 = this.last(sourceVector_1);
          int _last_4 = this.last(topVector_1);
          Iterable<Integer> _operator_upTo_1 = IntegerExtensions.operator_upTo(((Integer)_last_3), ((Integer)_last_4));
          Iterable<Integer> _drop = IterableExtensions.<Integer>drop(_operator_upTo_1, 1);
          final Iterable<Integer> postpositions = _drop;
          for (final Integer i_1 : postpositions) {
            {
              StateSwitch _defineExitSwitch_1 = this.defineExitSwitch(topExitState, leafStates_1, i_1);
              StateSwitch sSwitch_1 = _defineExitSwitch_1;
              EList<Step> _steps_4 = sequence.getSteps();
              _steps_4.add(sSwitch_1);
            }
          }
        }
      }
      Vertex _source_7 = t.getSource();
      boolean _operator_notEquals_6 = ObjectExtensions.operator_notEquals(topExitState, _source_7);
      if (_operator_notEquals_6) {
        {
          ExecutionState _create_5 = this.factory.create(topExitState);
          Step _exitAction_2 = _create_5.getExitAction();
          boolean _operator_notEquals_7 = ObjectExtensions.operator_notEquals(_exitAction_2, null);
          if (_operator_notEquals_7) {
            EList<Step> _steps_5 = sequence.getSteps();
            ExecutionState _create_6 = this.factory.create(topExitState);
            Step _exitAction_3 = _create_6.getExitAction();
            Call _newCall_2 = this.factory.newCall(_exitAction_3);
            _steps_5.add(_newCall_2);
          }
          if (this._addTraceSteps) {
            EList<Step> _steps_6 = sequence.getSteps();
            ExecutionState _create_7 = this.factory.create(topExitState);
            TraceStateExited _newTraceStateExited_1 = this.newTraceStateExited(_create_7);
            CollectionExtensions.<Step>operator_add(_steps_6, _newTraceStateExited_1);
          }
        }
      }
      Effect _effect = t.getEffect();
      boolean _operator_notEquals_8 = ObjectExtensions.operator_notEquals(_effect, null);
      if (_operator_notEquals_8) {
        EList<Step> _steps_7 = sequence.getSteps();
        Effect _effect_1 = t.getEffect();
        Sequence _mapEffect = this.mapEffect(_effect_1);
        _steps_7.add(_mapEffect);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_8 = sequence.getSteps();
        ReactionFired _newTraceReactionFired = this.newTraceReactionFired(r);
        CollectionExtensions.<Step>operator_add(_steps_8, _newTraceReactionFired);
      }
      List<ExecutionScope> _entryScopes = this.entryScopes(t);
      Iterable<ExecutionScope> _drop_1 = IterableExtensions.<ExecutionScope>drop(_entryScopes, 1);
      List<ExecutionScope> _list = IterableExtensions.<ExecutionScope>toList(_drop_1);
      List<ExecutionScope> _reverse = ListExtensions.<ExecutionScope>reverse(_list);
      final Function2<Sequence,ExecutionScope,Sequence> _function_1 = new Function2<Sequence,ExecutionScope,Sequence>() {
          public Sequence apply(final Sequence seq_1 , final ExecutionScope scope) {
            Sequence _xblockexpression_1 = null;
            {
              if ((scope instanceof org.yakindu.sct.model.sexec.ExecutionRegion)) {
                {
                  ExecutionScope _superScope = scope.getSuperScope();
                  EList<ExecutionScope> _subScopes = _superScope.getSubScopes();
                  final EList<ExecutionScope> siblingRegions = _subScopes;
                  int _indexOf = siblingRegions.indexOf(scope);
                  Iterable<ExecutionScope> _take_1 = IterableExtensions.<ExecutionScope>take(siblingRegions, _indexOf);
                  for (final ExecutionScope region : _take_1) {
                    ModelSequencer.this.addEnterRegion(seq_1, region);
                  }
                }
              }
              if ((scope instanceof org.yakindu.sct.model.sexec.ExecutionState)) {
                {
                  Step _entryAction = ((ExecutionState) scope).getEntryAction();
                  boolean _operator_notEquals_9 = ObjectExtensions.operator_notEquals(_entryAction, null);
                  if (_operator_notEquals_9) {
                    EList<Step> _steps_9 = seq_1.getSteps();
                    Step _entryAction_1 = ((ExecutionState) scope).getEntryAction();
                    Call _newCall_3 = ModelSequencer.this.factory.newCall(_entryAction_1);
                    _steps_9.add(_newCall_3);
                  }
                  if (ModelSequencer.this._addTraceSteps) {
                    EList<Step> _steps_10 = seq_1.getSteps();
                    TraceStateEntered _newTraceStateEntered = ModelSequencer.this.newTraceStateEntered(((ExecutionState) scope));
                    CollectionExtensions.<Step>operator_add(_steps_10, _newTraceStateEntered);
                  }
                }
              }
              _xblockexpression_1 = (seq_1);
            }
            return _xblockexpression_1;
          }
        };
      IterableExtensions.<ExecutionScope, Sequence>fold(_reverse, sequence, _function_1);
      Vertex _target = t.getTarget();
      boolean _operator_notEquals_10 = ObjectExtensions.operator_notEquals(_target, null);
      if (_operator_notEquals_10) {
        {
          Vertex _target_1 = t.getTarget();
          Region _parentRegion = _target_1.getParentRegion();
          CompositeElement _composite = _parentRegion.getComposite();
          EList<Region> _regions = _composite.getRegions();
          final EList<Region> siblingRegions_1 = _regions;
          Vertex _target_2 = t.getTarget();
          if ((_target_2 instanceof org.yakindu.sct.model.sgraph.RegularState)) {
            EList<Step> _steps_11 = sequence.getSteps();
            Vertex _target_3 = t.getTarget();
            ExecutionState _create_8 = this.factory.create(((RegularState) _target_3));
            Sequence _enterSequence = _create_8.getEnterSequence();
            Call _newCall_4 = this.factory.newCall(_enterSequence);
            _steps_11.add(_newCall_4);
          } else {
            Vertex _target_4 = t.getTarget();
            if ((_target_4 instanceof org.yakindu.sct.model.sgraph.Choice)) {
              EList<Step> _steps_12 = sequence.getSteps();
              Vertex _target_5 = t.getTarget();
              ExecutionChoice _create_9 = this.factory.create(((Choice) _target_5));
              Sequence _reactSequence = _create_9.getReactSequence();
              Call _newCall_5 = this.factory.newCall(_reactSequence);
              _steps_12.add(_newCall_5);
            }
          }
        }
      }
      List<ExecutionScope> _entryScopes_1 = this.entryScopes(t);
      Iterable<ExecutionScope> _drop_2 = IterableExtensions.<ExecutionScope>drop(_entryScopes_1, 1);
      final Function2<Sequence,ExecutionScope,Sequence> _function_2 = new Function2<Sequence,ExecutionScope,Sequence>() {
          public Sequence apply(final Sequence seq_2 , final ExecutionScope scope_1) {
            Sequence _xblockexpression_2 = null;
            {
              if ((scope_1 instanceof org.yakindu.sct.model.sexec.ExecutionRegion)) {
                {
                  ExecutionScope _superScope_1 = scope_1.getSuperScope();
                  EList<ExecutionScope> _subScopes_1 = _superScope_1.getSubScopes();
                  final EList<ExecutionScope> siblingRegions_2 = _subScopes_1;
                  int _indexOf_1 = siblingRegions_2.indexOf(scope_1);
                  int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf_1), ((Integer)1));
                  Iterable<ExecutionScope> _drop_3 = IterableExtensions.<ExecutionScope>drop(siblingRegions_2, _operator_plus);
                  for (final ExecutionScope region_1 : _drop_3) {
                    ModelSequencer.this.addEnterRegion(seq_2, region_1);
                  }
                }
              }
              _xblockexpression_2 = (seq_2);
            }
            return _xblockexpression_2;
          }
        };
      IterableExtensions.<ExecutionScope, Sequence>fold(_drop_2, sequence, _function_2);
      return sequence;
    }
  }
  
  protected Boolean _addEnterRegion(final Sequence seq, final Region r) {
    Boolean _xblockexpression = null;
    {
      Entry _entry = this.entry(r);
      State _target = this==null?(State)null:this.target(_entry);
      ExecutionState _create = this.factory==null?(ExecutionState)null:this.factory.create(_target);
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
        Call _newCall = this.factory.newCall(_enterSequence_1);
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
      Entry _entry = this.entry(((Region) _sourceElement));
      State _target = this==null?(State)null:this.target(_entry);
      ExecutionState _create = this.factory==null?(ExecutionState)null:this.factory.create(_target);
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
        Call _newCall = this.factory.newCall(_enterSequence_1);
        boolean _add = _steps.add(_newCall);
        _xifexpression = _add;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public ReactionFired newTraceReactionFired(final Reaction r) {
    ReactionFired _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      ReactionFired _createReactionFired = _sexecFactory.createReactionFired();
      final ReactionFired rf = _createReactionFired;
      rf.setReaction(r);
      _xblockexpression = (rf);
    }
    return _xblockexpression;
  }
  
  public TraceNodeExecuted newTraceNodeExecuted(final ExecutionNode node) {
    TraceNodeExecuted _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      TraceNodeExecuted _createTraceNodeExecuted = _sexecFactory.createTraceNodeExecuted();
      final TraceNodeExecuted t = _createTraceNodeExecuted;
      t.setNode(node);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceStateEntered newTraceStateEntered(final ExecutionState state) {
    TraceStateEntered _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      TraceStateEntered _createTraceStateEntered = _sexecFactory.createTraceStateEntered();
      final TraceStateEntered t = _createTraceStateEntered;
      t.setState(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public TraceStateExited newTraceStateExited(final ExecutionState state) {
    TraceStateExited _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      TraceStateExited _createTraceStateExited = _sexecFactory.createTraceStateExited();
      final TraceStateExited t = _createTraceStateExited;
      t.setState(state);
      _xblockexpression = (t);
    }
    return _xblockexpression;
  }
  
  public List<State> exitStates(final Transition t) {
    List<State> _xblockexpression = null;
    {
      Vertex _source = t.getSource();
      List<EObject> _containers = this.containers(_source);
      final List<EObject> l = _containers;
      Vertex _target = t.getTarget();
      List<EObject> _containers_1 = this.containers(_target);
      l.removeAll(_containers_1);
      Iterable<State> _filter = IterableExtensions.<State>filter(l, org.yakindu.sct.model.sgraph.State.class);
      List<State> _list = IterableExtensions.<State>toList(_filter);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public List<State> entryStates(final Transition t) {
    List<State> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      List<EObject> _containers = this.containers(_target);
      final List<EObject> l = _containers;
      Vertex _source = t.getSource();
      List<EObject> _containers_1 = this.containers(_source);
      l.removeAll(_containers_1);
      Iterable<State> _filter = IterableExtensions.<State>filter(l, org.yakindu.sct.model.sgraph.State.class);
      List<State> _list = IterableExtensions.<State>toList(_filter);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public List<ExecutionScope> exitScopes(final Transition t) {
    return null;
  }
  
  public List<ExecutionScope> entryScopes(final Transition t) {
    List<ExecutionScope> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      List<EObject> _containers = this.containers(_target);
      final List<EObject> l = _containers;
      Vertex _source = t.getSource();
      List<EObject> _containers_1 = this.containers(_source);
      l.removeAll(_containers_1);
      final Function1<EObject,ExecutionScope> _function = new Function1<EObject,ExecutionScope>() {
          public ExecutionScope apply(final EObject c) {
            ExecutionScope _xifexpression = null;
            if ((c instanceof org.yakindu.sct.model.sgraph.RegularState)) {
              ExecutionState _create = ModelSequencer.this.factory.create(((RegularState) c));
              _xifexpression = ((ExecutionScope) _create);
            } else {
              ExecutionScope _xifexpression_1 = null;
              if ((c instanceof org.yakindu.sct.model.sgraph.Region)) {
                ExecutionRegion _create_1 = ModelSequencer.this.factory.create(((Region) c));
                _xifexpression_1 = ((ExecutionScope) _create_1);
              } else {
                ExecutionScope _xifexpression_2 = null;
                if ((c instanceof org.yakindu.sct.model.sgraph.Statechart)) {
                  ExecutionFlow _create_2 = ModelSequencer.this.factory.create(((Statechart) c));
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
  
  public List<RegularState> parentStates(final RegularState s) {
    List<EObject> _containers = this.containers(s);
    Iterable<RegularState> _filter = IterableExtensions.<RegularState>filter(_containers, org.yakindu.sct.model.sgraph.RegularState.class);
    List<RegularState> _list = IterableExtensions.<RegularState>toList(_filter);
    return _list;
  }
  
  public List<EObject> containers(final EObject obj) {
    {
      ArrayList<EObject> _arrayList = new ArrayList<EObject>();
      final ArrayList<EObject> containerList = _arrayList;
      this.collectContainers(obj, containerList);
      return containerList;
    }
  }
  
  public void collectContainers(final EObject obj, final List<EObject> containerList) {
    {
      CollectionExtensions.<EObject>operator_add(containerList, obj);
      EObject _eContainer = obj==null?(EObject)null:obj.eContainer();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_eContainer, null);
      if (_operator_notEquals) {
        EObject _eContainer_1 = obj.eContainer();
        this.collectContainers(_eContainer_1, containerList);
      }
    }
  }
  
  public Sequence mapToEffect(final LocalReaction lr) {
    Sequence _xifexpression = null;
    Effect _effect = lr.getEffect();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
    if (_operator_notEquals) {
      Effect _effect_1 = lr.getEffect();
      Sequence _mapEffect = this.mapEffect(_effect_1);
      _xifexpression = _mapEffect;
    }
    return _xifexpression;
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
        SexecFactory _sexecFactory = this.sexecFactory();
        Sequence _createSequence = _sexecFactory.createSequence();
        final Sequence sequence = _createSequence;
        sequence.setName("reaction_action");
        EList<Step> _steps = sequence.getSteps();
        EList<Statement> _actions_1 = effect.getActions();
        final Function1<Statement,Execution> _function = new Function1<Statement,Execution>() {
            public Execution apply(final Statement stmnt) {
              Execution _mapToExecution = ModelSequencer.this.mapToExecution(stmnt);
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
      SexecFactory _sexecFactory = this.sexecFactory();
      Execution _createExecution = _sexecFactory.createExecution();
      final Execution exec = _createExecution;
      Statement _copy = EcoreUtil.<Statement>copy(stmnt);
      exec.setStatement(_copy);
      _xblockexpression = (exec);
    }
    return _xblockexpression;
  }
  
  public Step mapEntryAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("entryAction");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Entry action for state \'", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\'.");
      seq.setComment(_operator_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sct.timeEventSpecs(state);
      for (final TimeEventSpec tes : _timeEventSpecs) {
        {
          TimeEvent _createDerivedEvent = this.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          Statement _buildValueExpression = this.buildValueExpression(tes);
          ScheduleTimeEvent _newScheduleTimeEvent = this.factory.newScheduleTimeEvent(timeEvent, _buildValueExpression);
          final ScheduleTimeEvent scheduleStep = _newScheduleTimeEvent;
          EList<Step> _steps = seq.getSteps();
          _steps.add(scheduleStep);
        }
      }
      List<LocalReaction> _entryReactions = this.sct.entryReactions(state);
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
            if (_operator_notEquals) {
              Effect _effect_1 = lr.getEffect();
              Sequence _mapEffect = ModelSequencer.this.mapEffect(((ReactionEffect) _effect_1));
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
  
  public Statement buildValueExpression(final TimeEventSpec tes) {
    Statement _xblockexpression = null;
    {
      StextFactory _stextFactory = this.stextFactory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _stextFactory.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _stextFactory_1 = this.stextFactory();
      IntLiteral _createIntLiteral = _stextFactory_1.createIntLiteral();
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
          Statement _divide = this.divide(pve, 1000);
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
      StextFactory _stextFactory = this.stextFactory();
      NumericalMultiplyDivideExpression _createNumericalMultiplyDivideExpression = _stextFactory.createNumericalMultiplyDivideExpression();
      final NumericalMultiplyDivideExpression div = _createNumericalMultiplyDivideExpression;
      StextFactory _stextFactory_1 = this.stextFactory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _stextFactory_1.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _stextFactory_2 = this.stextFactory();
      IntLiteral _createIntLiteral = _stextFactory_2.createIntLiteral();
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
      StextFactory _stextFactory = this.stextFactory();
      NumericalMultiplyDivideExpression _createNumericalMultiplyDivideExpression = _stextFactory.createNumericalMultiplyDivideExpression();
      final NumericalMultiplyDivideExpression div = _createNumericalMultiplyDivideExpression;
      StextFactory _stextFactory_1 = this.stextFactory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _stextFactory_1.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _stextFactory_2 = this.stextFactory();
      IntLiteral _createIntLiteral = _stextFactory_2.createIntLiteral();
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
  
  public Step mapExitAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitAction");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Exit action for state \'", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\'.");
      seq.setComment(_operator_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sct.timeEventSpecs(state);
      for (final TimeEventSpec tes : _timeEventSpecs) {
        {
          TimeEvent _createDerivedEvent = this.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          UnscheduleTimeEvent _newUnscheduleTimeEvent = this.factory.newUnscheduleTimeEvent(timeEvent);
          final UnscheduleTimeEvent unscheduleStep = _newUnscheduleTimeEvent;
          EList<Step> _steps = seq.getSteps();
          _steps.add(unscheduleStep);
        }
      }
      List<LocalReaction> _exitReactions = this.sct.exitReactions(state);
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
            if (_operator_notEquals) {
              Effect _effect_1 = lr.getEffect();
              Sequence _mapEffect = ModelSequencer.this.mapEffect(((ReactionEffect) _effect_1));
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
  
  public ExecutionFlow defineRegularStateReactions(final ExecutionFlow flow, final Statechart sc) {
    {
      List<RegularState> _allRegularStates = this.sct.allRegularStates(sc);
      final List<RegularState> states = _allRegularStates;
      Iterable<State> _filter = IterableExtensions.<State>filter(states, org.yakindu.sct.model.sgraph.State.class);
      final Function1<State,Boolean> _function = new Function1<State,Boolean>() {
          public Boolean apply(final State s) {
            boolean _isSimple = s.isSimple();
            return ((Boolean)_isSimple);
          }
        };
      Iterable<State> _filter_1 = IterableExtensions.<State>filter(_filter, _function);
      final Function1<State,Sequence> _function_1 = new Function1<State,Sequence>() {
          public Sequence apply(final State s_1) {
            Sequence _defineCycle = ModelSequencer.this.defineCycle(s_1);
            return _defineCycle;
          }
        };
      IterableExtensions.<State>forEach(_filter_1, _function_1);
      Iterable<FinalState> _filter_2 = IterableExtensions.<FinalState>filter(states, org.yakindu.sct.model.sgraph.FinalState.class);
      final Function1<FinalState,Sequence> _function_2 = new Function1<FinalState,Sequence>() {
          public Sequence apply(final FinalState s_2) {
            Sequence _defineCycle_1 = ModelSequencer.this.defineCycle(s_2);
            return _defineCycle_1;
          }
        };
      IterableExtensions.<FinalState>forEach(_filter_2, _function_2);
      return flow;
    }
  }
  
  public void definePseudoStateReactions(final ExecutionFlow flow, final Statechart sc) {
    List<Choice> _allChoices = this.sct.allChoices(sc);
    final Function1<Choice,Sequence> _function = new Function1<Choice,Sequence>() {
        public Sequence apply(final Choice choice) {
          Sequence _defineReaction = ModelSequencer.this.defineReaction(choice);
          return _defineReaction;
        }
      };
    IterableExtensions.<Choice>forEach(_allChoices, _function);
  }
  
  public Sequence defineReaction(final Choice choice) {
    {
      ExecutionChoice _create = this.factory.create(choice);
      final ExecutionChoice execChoice = _create;
      EList<Reaction> _reactions = execChoice.getReactions();
      final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r) {
            Check _check = r.getCheck();
            boolean _alwaysTrue = ModelSequencer.this.alwaysTrue(_check);
            return ((Boolean)_alwaysTrue);
          }
        };
      Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
      List<Reaction> _list = IterableExtensions.<Reaction>toList(_filter);
      Reaction _head = IterableExtensions.<Reaction>head(_list);
      final Reaction _default_ = _head;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_default_, null);
      if (_operator_notEquals) {
        EList<Reaction> _reactions_1 = execChoice.getReactions();
        EList<Reaction> _reactions_2 = execChoice.getReactions();
        int _size = _reactions_2.size();
        int _operator_minus = IntegerExtensions.operator_minus(((Integer)_size), ((Integer)1));
        _reactions_1.move(_operator_minus, _default_);
      }
      Sequence _createReactionSequence = this.createReactionSequence(execChoice, null);
      final Sequence stateReaction = _createReactionSequence;
      Sequence _reactSequence = execChoice.getReactSequence();
      EList<Step> _steps = _reactSequence.getSteps();
      EList<Step> _steps_1 = stateReaction.getSteps();
      _steps.addAll(_steps_1);
      Sequence _reactSequence_1 = execChoice.getReactSequence();
      _reactSequence_1.setName("react");
      Sequence _reactSequence_2 = execChoice.getReactSequence();
      String _name = choice.getName();
      String _operator_plus = StringExtensions.operator_plus("The reactions of state ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".");
      _reactSequence_2.setComment(_operator_plus_1);
      if (this._addTraceSteps) {
        Sequence _reactSequence_3 = execChoice.getReactSequence();
        EList<Step> _steps_2 = _reactSequence_3.getSteps();
        ExecutionChoice _create_1 = this.factory.create(choice);
        TraceNodeExecuted _newTraceNodeExecuted = this.newTraceNodeExecuted(_create_1);
        _steps_2.add(0, _newTraceNodeExecuted);
      }
      Sequence _reactSequence_4 = execChoice.getReactSequence();
      return _reactSequence_4;
    }
  }
  
  public boolean alwaysTrue(final Check check) {
    {
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(check, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Statement _condition = check.getCondition();
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, (_condition instanceof org.yakindu.sct.model.stext.stext.PrimitiveValueExpression));
      }
      if (_operator_and) {
        {
          Statement _condition_1 = check.getCondition();
          final PrimitiveValueExpression pve = ((PrimitiveValueExpression) _condition_1);
          boolean _operator_and_1 = false;
          Literal _value = pve.getValue();
          if (!(_value instanceof org.yakindu.sct.model.stext.stext.BoolLiteral)) {
            _operator_and_1 = false;
          } else {
            Literal _value_1 = pve.getValue();
            boolean _isValue = ((BoolLiteral) _value_1).isValue();
            _operator_and_1 = BooleanExtensions.operator_and((_value instanceof org.yakindu.sct.model.stext.stext.BoolLiteral), _isValue);
          }
          return _operator_and_1;
        }
      }
      return false;
    }
  }
  
  public Sequence defineCycle(final RegularState state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState execState = _create;
      Sequence _createReactionSequence = this.createReactionSequence(execState, null);
      final Sequence stateReaction = _createReactionSequence;
      List<RegularState> _parentStates = this.parentStates(state);
      final List<RegularState> parents = _parentStates;
      final Function2<Sequence,RegularState,Sequence> _function = new Function2<Sequence,RegularState,Sequence>() {
          public Sequence apply(final Sequence r , final RegularState s) {
            ExecutionState _create_1 = ModelSequencer.this.factory.create(s);
            Sequence _createReactionSequence_1 = ModelSequencer.this.createReactionSequence(_create_1, r);
            return _createReactionSequence_1;
          }
        };
      Sequence _fold = IterableExtensions.<RegularState, Sequence>fold(parents, null, _function);
      execState.setReactSequence(_fold);
      Sequence _reactSequence = execState.getReactSequence();
      _reactSequence.setName("react");
      Sequence _reactSequence_1 = execState.getReactSequence();
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("The reactions of state ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".");
      _reactSequence_1.setComment(_operator_plus_1);
      Sequence _reactSequence_2 = execState.getReactSequence();
      return _reactSequence_2;
    }
  }
  
  public Sequence createReactionSequence(final ExecutionNode state, final Step localStep) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence cycle = _createSequence;
      EList<Reaction> _reactions = state.getReactions();
      final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r) {
            boolean _isTransition = r.isTransition();
            boolean _operator_not = BooleanExtensions.operator_not(_isTransition);
            return ((Boolean)_operator_not);
          }
        };
      Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_reactions, _function);
      List<Reaction> _list = IterableExtensions.<Reaction>toList(_filter);
      final List<Reaction> localReactions = _list;
      SexecFactory _sexecFactory_1 = this.sexecFactory();
      Sequence _createSequence_1 = _sexecFactory_1.createSequence();
      Sequence localSteps = _createSequence_1;
      EList<Step> _steps = localSteps.getSteps();
      final Function1<Reaction,If> _function_1 = new Function1<Reaction,If>() {
          public If apply(final Reaction lr) {
            If _xblockexpression = null;
            {
              SexecFactory _sexecFactory_2 = ModelSequencer.this.sexecFactory();
              If _createIf = _sexecFactory_2.createIf();
              If ifStep = _createIf;
              Check _check = lr.getCheck();
              CheckRef _newRef = ModelSequencer.this.factory.newRef(_check);
              ifStep.setCheck(_newRef);
              Step _effect = lr.getEffect();
              Call _newCall = ModelSequencer.this.factory.newCall(_effect);
              ifStep.setThenStep(_newCall);
              _xblockexpression = (ifStep);
            }
            return _xblockexpression;
          }
        };
      List<If> _map = ListExtensions.<Reaction, If>map(localReactions, _function_1);
      _steps.addAll(_map);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(localStep, null);
      if (_operator_notEquals) {
        EList<Step> _steps_1 = localSteps.getSteps();
        CollectionExtensions.<Step>operator_add(_steps_1, localStep);
      }
      EList<Step> _steps_2 = localSteps.getSteps();
      boolean _isEmpty = _steps_2.isEmpty();
      if (_isEmpty) {
        localSteps = null;
      }
      EList<Reaction> _reactions_1 = state.getReactions();
      final Function1<Reaction,Boolean> _function_2 = new Function1<Reaction,Boolean>() {
          public Boolean apply(final Reaction r_1) {
            boolean _isTransition_1 = r_1.isTransition();
            return ((Boolean)_isTransition_1);
          }
        };
      Iterable<Reaction> _filter_1 = IterableExtensions.<Reaction>filter(_reactions_1, _function_2);
      List<Reaction> _list_1 = IterableExtensions.<Reaction>toList(_filter_1);
      final List<Reaction> transitionReactions = _list_1;
      Iterable<Reaction> _reverseView = ListExtensions.<Reaction>reverseView(transitionReactions);
      final Function2<Step,Reaction,Step> _function_3 = new Function2<Step,Reaction,Step>() {
          public Step apply(final Step s , final Reaction reaction) {
            Step _xblockexpression_1 = null;
            {
              SexecFactory _sexecFactory_3 = ModelSequencer.this.sexecFactory();
              If _createIf_1 = _sexecFactory_3.createIf();
              If ifStep_1 = _createIf_1;
              Check _check_1 = reaction.getCheck();
              CheckRef _newRef_1 = ModelSequencer.this.factory.newRef(_check_1);
              ifStep_1.setCheck(_newRef_1);
              Step _effect_1 = reaction.getEffect();
              Call _newCall_1 = ModelSequencer.this.factory.newCall(_effect_1);
              ifStep_1.setThenStep(_newCall_1);
              ifStep_1.setElseStep(s);
              _xblockexpression_1 = (((Step) ifStep_1));
            }
            return _xblockexpression_1;
          }
        };
      Step _fold = IterableExtensions.<Reaction, Step>fold(_reverseView, ((Step) localSteps), _function_3);
      final Step transitionStep = _fold;
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(transitionStep, null);
      if (_operator_notEquals_1) {
        EList<Step> _steps_3 = cycle.getSteps();
        _steps_3.add(transitionStep);
      } else {
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(localSteps, null);
        if (_operator_notEquals_2) {
          EList<Step> _steps_4 = cycle.getSteps();
          _steps_4.add(localSteps);
        }
      }
      return cycle;
    }
  }
  
  protected Check _mapToCheck(final Trigger tr) {
    return null;
  }
  
  protected Check _mapToCheck(final ReactionTrigger tr) {
    {
      Check _createCheck = this.factory.createCheck(tr);
      final Check check = _createCheck;
      Statement _buildCondition = this.buildCondition(tr);
      check.setCondition(_buildCondition);
      return check;
    }
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
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        EList<EventSpec> _triggers_1 = t.getTriggers();
        Iterable<EventSpec> _reverseView = ListExtensions.<EventSpec>reverseView(_triggers_1);
        final Function2<Expression,EventSpec,Expression> _function = new Function2<Expression,EventSpec,Expression>() {
            public Expression apply(final Expression s , final EventSpec e) {
              Expression _xblockexpression_1 = null;
              {
                Expression _raised = ModelSequencer.this.raised(e);
                final Expression raised = _raised;
                Expression _xifexpression_1 = null;
                boolean _operator_equals = ObjectExtensions.operator_equals(raised, null);
                if (_operator_equals) {
                  _xifexpression_1 = s;
                } else {
                  Expression _xifexpression_2 = null;
                  boolean _operator_equals_1 = ObjectExtensions.operator_equals(s, null);
                  if (_operator_equals_1) {
                    _xifexpression_2 = raised;
                  } else {
                    Expression _or = ModelSequencer.this.or(raised, s);
                    _xifexpression_2 = _or;
                  }
                  _xifexpression_1 = _xifexpression_2;
                }
                _xblockexpression_1 = (_xifexpression_1);
              }
              return _xblockexpression_1;
            }
          };
        Expression _fold = IterableExtensions.<EventSpec, Expression>fold(_reverseView, ((Expression) null), _function);
        _xifexpression = _fold;
      } else {
        _xifexpression = null;
      }
      final Expression triggerCheck = _xifexpression;
      Expression _xifexpression_3 = null;
      Expression _guardExpression = t.getGuardExpression();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_guardExpression, null);
      if (_operator_notEquals) {
        Expression _guardExpression_1 = t.getGuardExpression();
        Expression _copy = EcoreUtil.<Expression>copy(_guardExpression_1);
        _xifexpression_3 = _copy;
      } else {
        _xifexpression_3 = null;
      }
      final Expression guard = _xifexpression_3;
      Expression _xifexpression_4 = null;
      boolean _operator_and = false;
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(triggerCheck, null);
      if (!_operator_notEquals_1) {
        _operator_and = false;
      } else {
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(guard, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals_1, _operator_notEquals_2);
      }
      if (_operator_and) {
        Expression _and = this.and(triggerCheck, guard);
        _xifexpression_4 = _and;
      } else {
        Expression _xifexpression_5 = null;
        boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(triggerCheck, null);
        if (_operator_notEquals_3) {
          _xifexpression_5 = triggerCheck;
        } else {
          _xifexpression_5 = guard;
        }
        _xifexpression_4 = _xifexpression_5;
      }
      _xblockexpression = (_xifexpression_4);
    }
    return _xblockexpression;
  }
  
  public Expression or(final Expression left, final Expression right) {
    LogicalOrExpression _xblockexpression = null;
    {
      StextFactory _stextFactory = this.stextFactory();
      LogicalOrExpression _createLogicalOrExpression = _stextFactory.createLogicalOrExpression();
      final LogicalOrExpression or = _createLogicalOrExpression;
      or.setLeftOperand(left);
      or.setRightOperand(right);
      _xblockexpression = (or);
    }
    return _xblockexpression;
  }
  
  public Expression and(final Expression left, final Expression right) {
    LogicalAndExpression _xblockexpression = null;
    {
      StextFactory _stextFactory = this.stextFactory();
      LogicalAndExpression _createLogicalAndExpression = _stextFactory.createLogicalAndExpression();
      final LogicalAndExpression or = _createLogicalAndExpression;
      or.setLeftOperand(left);
      or.setRightOperand(right);
      _xblockexpression = (or);
    }
    return _xblockexpression;
  }
  
  protected Expression _raised(final EventSpec e) {
    return null;
  }
  
  protected Expression _raised(final RegularEventSpec e) {
    {
      StextFactory _stextFactory = this.stextFactory();
      ElementReferenceExpression _createElementReferenceExpression = _stextFactory.createElementReferenceExpression();
      final ElementReferenceExpression r = _createElementReferenceExpression;
      Event _event = e.getEvent();
      EventDefinition _create = this.factory.create(((EventDefinition) _event));
      r.setValue(_create);
      return r;
    }
  }
  
  protected Expression _raised(final TimeEventSpec e) {
    {
      StextFactory _stextFactory = this.stextFactory();
      ElementReferenceExpression _createElementReferenceExpression = _stextFactory.createElementReferenceExpression();
      final ElementReferenceExpression r = _createElementReferenceExpression;
      TimeEvent _createDerivedEvent = this.createDerivedEvent(e);
      r.setValue(_createDerivedEvent);
      return r;
    }
  }
  
  protected Expression _raised(final OnCycleEvent e) {
    {
      StextFactory _stextFactory = this.stextFactory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _stextFactory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _stextFactory_1 = this.stextFactory();
      BoolLiteral _createBoolLiteral = _stextFactory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  protected Expression _raised(final AlwaysEvent e) {
    {
      StextFactory _stextFactory = this.stextFactory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _stextFactory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _stextFactory_1 = this.stextFactory();
      BoolLiteral _createBoolLiteral = _stextFactory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
  }
  
  protected Expression _raised(final DefaultEvent e) {
    {
      StextFactory _stextFactory = this.stextFactory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _stextFactory.createPrimitiveValueExpression();
      final PrimitiveValueExpression r = _createPrimitiveValueExpression;
      StextFactory _stextFactory_1 = this.stextFactory();
      BoolLiteral _createBoolLiteral = _stextFactory_1.createBoolLiteral();
      final BoolLiteral boolLit = _createBoolLiteral;
      boolLit.setValue(true);
      r.setValue(boolLit);
      return r;
    }
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
  
  private final HashMap<ArrayList<?>,Scope> _createCache_timeEventScope = new HashMap<ArrayList<?>,Scope>();
  
  public Scope timeEventScope(final ExecutionFlow flow) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(flow);
    final Scope r;
    synchronized (_createCache_timeEventScope) {
      if (_createCache_timeEventScope.containsKey(_cacheKey)) {
        return _createCache_timeEventScope.get(_cacheKey);
      }
      SGraphFactory _sgraphFactory = this.sgraphFactory();
      Scope _createScope = _sgraphFactory.createScope();
      r = _createScope;
      _createCache_timeEventScope.put(_cacheKey, r);
    }
    EList<Scope> _scopes = flow.getScopes();
    _scopes.add(r);
    return r;
  }
  
  public void defineStateVector(final ExecutionFlow flow, final Statechart sc) {
    {
      int offset = 0;
      EList<Region> _regions = sc.getRegions();
      for (final Region r : _regions) {
        int _defineStateVectors = this.defineStateVectors(r, offset);
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)_defineStateVectors));
        offset = _operator_plus;
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      StateVector _createStateVector = _sexecFactory.createStateVector();
      flow.setStateVector(_createStateVector);
      StateVector _stateVector = flow.getStateVector();
      _stateVector.setOffset(0);
      StateVector _stateVector_1 = flow.getStateVector();
      _stateVector_1.setSize(offset);
    }
  }
  
  public int defineStateVectors(final Statechart sc, final int offset) {
    EList<Region> _regions = sc.getRegions();
    final Function2<Integer,Region,Integer> _function = new Function2<Integer,Region,Integer>() {
        public Integer apply(final Integer o , final Region r) {
          int _maxOrthogonality = ModelSequencer.this.sct.maxOrthogonality(r);
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)_maxOrthogonality), o);
          return ((Integer)_operator_plus);
        }
      };
    Integer _fold = IterableExtensions.<Region, Integer>fold(_regions, ((Integer)0), _function);
    return _fold;
  }
  
  public int defineStateVectors(final Region r, final int offset) {
    {
      EList<Vertex> _vertices = r.getVertices();
      final Function2<Integer,Vertex,Integer> _function = new Function2<Integer,Vertex,Integer>() {
          public Integer apply(final Integer s , final Vertex v) {
            int _xblockexpression = (int) 0;
            {
              int _defineStateVectors = ModelSequencer.this.defineStateVectors(v, ((Integer)offset));
              final int mo = _defineStateVectors;
              int _xifexpression = (int) 0;
              boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)mo), s);
              if (_operator_greaterThan) {
                _xifexpression = mo;
              } else {
                _xifexpression = s;
              }
              _xblockexpression = (_xifexpression);
            }
            return ((Integer)_xblockexpression);
          }
        };
      Integer _fold = IterableExtensions.<Vertex, Integer>fold(_vertices, ((Integer)0), _function);
      final Integer maxOrthogonality = _fold;
      ExecutionRegion _create = this.factory.create(r);
      final ExecutionRegion er = _create;
      SexecFactory _sexecFactory = this.sexecFactory();
      StateVector _createStateVector = _sexecFactory.createStateVector();
      er.setStateVector(_createStateVector);
      StateVector _stateVector = er.getStateVector();
      _stateVector.setOffset(offset);
      StateVector _stateVector_1 = er.getStateVector();
      _stateVector_1.setSize(maxOrthogonality);
      return maxOrthogonality;
    }
  }
  
  protected int _defineStateVectors(final Vertex v, final int offset) {
    return 0;
  }
  
  protected int _defineStateVectors(final State s, final int offset) {
    {
      int maxOrthogonality = 0;
      EList<Region> _regions = s.getRegions();
      int _size = _regions.size();
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
      if (_operator_greaterThan) {
        EList<Region> _regions_1 = s.getRegions();
        for (final Region r : _regions_1) {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)maxOrthogonality));
          int _defineStateVectors = this.defineStateVectors(r, _operator_plus);
          int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)maxOrthogonality), ((Integer)_defineStateVectors));
          maxOrthogonality = _operator_plus_1;
        }
      } else {
        maxOrthogonality = 1;
      }
      ExecutionState _create = this.factory.create(s);
      final ExecutionState es = _create;
      SexecFactory _sexecFactory = this.sexecFactory();
      StateVector _createStateVector = _sexecFactory.createStateVector();
      es.setStateVector(_createStateVector);
      StateVector _stateVector = es.getStateVector();
      _stateVector.setOffset(offset);
      StateVector _stateVector_1 = es.getStateVector();
      _stateVector_1.setSize(maxOrthogonality);
      return maxOrthogonality;
    }
  }
  
  protected int _defineStateVectors(final FinalState s, final int offset) {
    {
      ExecutionState _create = this.factory.create(s);
      final ExecutionState es = _create;
      SexecFactory _sexecFactory = this.sexecFactory();
      StateVector _createStateVector = _sexecFactory.createStateVector();
      es.setStateVector(_createStateVector);
      StateVector _stateVector = es.getStateVector();
      _stateVector.setOffset(offset);
      StateVector _stateVector_1 = es.getStateVector();
      _stateVector_1.setSize(1);
      return 1;
    }
  }
  
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
      ExecutionState _create = this.factory.create(state);
      final ExecutionState execState = _create;
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
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
        Call _newCall = this.factory.newCall(_entryAction_1);
        _steps.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateEntered _newTraceStateEntered = this.newTraceStateEntered(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateEntered);
      }
      EList<Step> _steps_2 = seq.getSteps();
      EnterState _newEnterStateStep = this.newEnterStateStep(state);
      CollectionExtensions.<Step>operator_add(_steps_2, _newEnterStateStep);
      execState.setEnterSequence(seq);
    }
  }
  
  protected void _defineStateEnterSequence(final State state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState execState = _create;
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
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
        Call _newCall = this.factory.newCall(_entryAction_1);
        _steps.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateEntered _newTraceStateEntered = this.newTraceStateEntered(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateEntered);
      }
      boolean _isLeaf = execState.isLeaf();
      if (_isLeaf) {
        EList<Step> _steps_2 = seq.getSteps();
        EnterState _newEnterStateStep = this.newEnterStateStep(state);
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
      ExecutionState _create = this.factory.create(s);
      final ExecutionState execState = _create;
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitSequence");
      seq.setComment("Default exit sequence for final state.");
      EList<Step> _steps = seq.getSteps();
      ExitState _newExitStateStep = this.newExitStateStep(s);
      CollectionExtensions.<Step>operator_add(_steps, _newExitStateStep);
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateExited _newTraceStateExited = this.newTraceStateExited(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateExited);
      }
      execState.setExitSequence(seq);
    }
  }
  
  protected void _defineStateExitSequence(final State state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState execState = _create;
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitSequence");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Default exit sequence for state ", _name);
      seq.setComment(_operator_plus);
      boolean _isLeaf = execState.isLeaf();
      if (_isLeaf) {
        EList<Step> _steps = seq.getSteps();
        ExitState _newExitStateStep = this.newExitStateStep(state);
        CollectionExtensions.<Step>operator_add(_steps, _newExitStateStep);
      } else {
        {
          EList<Region> _regions = state.getRegions();
          final Function1<Region,Object> _function = new Function1<Region,Object>() {
              public Object apply(final Region r) {
                Object _xblockexpression = null;
                {
                  ModelSequencer.this.defineStateExitSequence(r);
                  _xblockexpression = (null);
                }
                return _xblockexpression;
              }
            };
          IterableExtensions.<Region>forEach(_regions, _function);
          ArrayList<RegularState> _arrayList = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates = this.collectLeafStates(state, _arrayList);
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
        Call _newCall = this.factory.newCall(_exitAction_1);
        _steps_2.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_3 = seq.getSteps();
        TraceStateExited _newTraceStateExited = this.newTraceStateExited(execState);
        CollectionExtensions.<Step>operator_add(_steps_3, _newTraceStateExited);
      }
      execState.setExitSequence(seq);
    }
  }
  
  public StateSwitch defineExitSwitch(final State state, final List<RegularState> states, final int pos) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      StateSwitch _createStateSwitch = _sexecFactory.createStateSwitch();
      StateSwitch sSwitch = _createStateSwitch;
      sSwitch.setStateConfigurationIdx(pos);
      int _stateConfigurationIdx = sSwitch.getStateConfigurationIdx();
      String _operator_plus = StringExtensions.operator_plus("Handle exit of all possible states on position ", ((Integer)_stateConfigurationIdx));
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "...");
      sSwitch.setComment(_operator_plus_1);
      final Function1<RegularState,Boolean> _function = new Function1<RegularState,Boolean>() {
          public Boolean apply(final RegularState rs) {
            boolean _operator_and = false;
            ExecutionState _create = ModelSequencer.this.factory.create(rs);
            StateVector _stateVector = _create.getStateVector();
            int _size = _stateVector.getSize();
            boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)1));
            if (!_operator_equals) {
              _operator_and = false;
            } else {
              ExecutionState _create_1 = ModelSequencer.this.factory.create(rs);
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
          SexecFactory _sexecFactory_1 = this.sexecFactory();
          Sequence _createSequence = _sexecFactory_1.createSequence();
          final Sequence caseSeq = _createSequence;
          EList<Step> _steps = caseSeq.getSteps();
          ExecutionState _create_2 = this.factory.create(s);
          Sequence _exitSequence = _create_2.getExitSequence();
          Call _newCall = this.factory.newCall(_exitSequence);
          CollectionExtensions.<Step>operator_add(_steps, _newCall);
          ExecutionState _create_3 = this.factory.create(s);
          final ExecutionState es = _create_3;
          List<RegularState> _parentStates = this.parentStates(s);
          final List<RegularState> exitStates = _parentStates;
          List<RegularState> _parentStates_1 = this.parentStates(state);
          exitStates.removeAll(_parentStates_1);
          exitStates.remove(s);
          final Function2<Sequence,RegularState,Sequence> _function_1 = new Function2<Sequence,RegularState,Sequence>() {
              public Sequence apply(final Sequence cs , final RegularState exitState) {
                Sequence _xblockexpression = null;
                {
                  StateVector _stateVector_2 = es.getStateVector();
                  int _last = ModelSequencer.this.last(_stateVector_2);
                  ExecutionState _create_4 = ModelSequencer.this.factory.create(exitState);
                  StateVector _stateVector_3 = _create_4.getStateVector();
                  int _last_1 = ModelSequencer.this.last(_stateVector_3);
                  boolean _operator_equals_2 = ObjectExtensions.operator_equals(((Integer)_last), ((Integer)_last_1));
                  if (_operator_equals_2) {
                    {
                      ExecutionState _create_5 = ModelSequencer.this.factory.create(exitState);
                      Step _exitAction = _create_5.getExitAction();
                      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_exitAction, null);
                      if (_operator_notEquals) {
                        EList<Step> _steps_1 = cs.getSteps();
                        ExecutionState _create_6 = ModelSequencer.this.factory.create(exitState);
                        Step _exitAction_1 = _create_6.getExitAction();
                        Call _newCall_1 = ModelSequencer.this.factory.newCall(_exitAction_1);
                        _steps_1.add(_newCall_1);
                      }
                      if (ModelSequencer.this._addTraceSteps) {
                        EList<Step> _steps_2 = cs.getSteps();
                        ExecutionState _create_7 = ModelSequencer.this.factory.create(exitState);
                        TraceStateExited _newTraceStateExited = ModelSequencer.this.newTraceStateExited(_create_7);
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
          ExecutionState _create_8 = this.factory.create(s);
          Sequence _exitSequence_1 = _create_8.getExitSequence();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_exitSequence_1, null);
          if (_operator_notEquals_1) {
            EList<StateCase> _cases = sSwitch.getCases();
            ExecutionState _create_9 = this.factory.create(s);
            StateCase _newCase = this.newCase(_create_9, caseSeq);
            _cases.add(_newCase);
          }
        }
      }
      return sSwitch;
    }
  }
  
  public List<RegularState> collectLeafStates(final RegularState state, final List<RegularState> leafStates) {
    {
      boolean _isLeaf = this.isLeaf(state);
      if (_isLeaf) {
        CollectionExtensions.<RegularState>operator_add(leafStates, state);
      } else {
        if ((state instanceof org.yakindu.sct.model.sgraph.State)) {
          {
            final State s = ((State) state);
            EList<Region> _regions = s.getRegions();
            for (final Region r : _regions) {
              EList<Vertex> _vertices = r.getVertices();
              for (final Vertex v : _vertices) {
                if ((v instanceof org.yakindu.sct.model.sgraph.RegularState)) {
                  this.collectLeafStates(((RegularState) v), leafStates);
                }
              }
            }
          }
        }
      }
      return leafStates;
    }
  }
  
  public List<RegularState> collectLeafStates(final Region region, final List<RegularState> leafStates) {
    {
      EList<Vertex> _vertices = region.getVertices();
      for (final Vertex v : _vertices) {
        if ((v instanceof org.yakindu.sct.model.sgraph.RegularState)) {
          this.collectLeafStates(((RegularState) v), leafStates);
        }
      }
      return leafStates;
    }
  }
  
  protected boolean _isLeaf(final RegularState s) {
    return false;
  }
  
  protected boolean _isLeaf(final FinalState s) {
    return true;
  }
  
  protected boolean _isLeaf(final State s) {
    boolean _isSimple = s.isSimple();
    return _isSimple;
  }
  
  public StateCase newCase(final ExecutionState it, final Step step) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      StateCase _createStateCase = _sexecFactory.createStateCase();
      final StateCase sCase = _createStateCase;
      sCase.setState(it);
      sCase.setStep(step);
      return sCase;
    }
  }
  
  public Iterable<State> states(final Region it) {
    EList<Vertex> _vertices = it.getVertices();
    Iterable<State> _filter = IterableExtensions.<State>filter(_vertices, org.yakindu.sct.model.sgraph.State.class);
    return _filter;
  }
  
  public Sequence defineEnterSequence(final ExecutionFlow flow, final Statechart sc) {
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Sequence _createSequence = _sexecFactory.createSequence();
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
  
  public EnterState newEnterStateStep(final RegularState s) {
    {
      EnterState ess = ((EnterState) null);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(s, null);
      if (_operator_notEquals) {
        {
          SexecFactory _sexecFactory = this.sexecFactory();
          EnterState _createEnterState = _sexecFactory.createEnterState();
          ess = _createEnterState;
          ExecutionState _create = this.factory.create(s);
          ess.setState(_create);
        }
      }
      return ess;
    }
  }
  
  public ExitState newExitStateStep(final RegularState s) {
    {
      ExitState ess = ((ExitState) null);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(s, null);
      if (_operator_notEquals) {
        {
          SexecFactory _sexecFactory = this.sexecFactory();
          ExitState _createExitState = _sexecFactory.createExitState();
          ess = _createExitState;
          ExecutionState _create = this.factory.create(s);
          ess.setState(_create);
        }
      }
      return ess;
    }
  }
  
  public void retargetDeclRefs(final ExecutionFlow flow) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(flow);
      final List<EObject> allContent = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            boolean _operator_or = false;
            if ((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition)) {
              _operator_or = true;
            } else {
              _operator_or = BooleanExtensions.operator_or((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition), (e instanceof org.yakindu.sct.model.stext.stext.VariableDefinition));
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(allContent, _function);
      List<EObject> _list = IterableExtensions.<EObject>toList(_filter);
      final List<EObject> declared = _list;
      final Function1<EObject,Boolean> _function_1 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e_1) {
            return ((Boolean)(e_1 instanceof org.yakindu.sct.model.stext.stext.ElementReferenceExpression));
          }
        };
      Iterable<EObject> _filter_1 = IterableExtensions.<EObject>filter(allContent, _function_1);
      final Function1<EObject,ElementReferenceExpression> _function_2 = new Function1<EObject,ElementReferenceExpression>() {
          public ElementReferenceExpression apply(final EObject s) {
            return ((ElementReferenceExpression) s);
          }
        };
      Iterable<ElementReferenceExpression> _map = IterableExtensions.<EObject, ElementReferenceExpression>map(_filter_1, _function_2);
      final Function1<ElementReferenceExpression,Object> _function_3 = new Function1<ElementReferenceExpression,Object>() {
          public Object apply(final ElementReferenceExpression ere) {
            Object _retarget = ModelSequencer.this.retarget(ere, declared);
            return _retarget;
          }
        };
      IterableExtensions.<ElementReferenceExpression>forEach(_map, _function_3);
      final Function1<EObject,Boolean> _function_4 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e_2) {
            return ((Boolean)(e_2 instanceof org.yakindu.sct.model.stext.stext.Assignment));
          }
        };
      Iterable<EObject> _filter_2 = IterableExtensions.<EObject>filter(allContent, _function_4);
      final Function1<EObject,Assignment> _function_5 = new Function1<EObject,Assignment>() {
          public Assignment apply(final EObject s_1) {
            return ((Assignment) s_1);
          }
        };
      Iterable<Assignment> _map_1 = IterableExtensions.<EObject, Assignment>map(_filter_2, _function_5);
      final Function1<Assignment,Object> _function_6 = new Function1<Assignment,Object>() {
          public Object apply(final Assignment ere_1) {
            Object _retarget_1 = ModelSequencer.this.retarget(ere_1, declared);
            return _retarget_1;
          }
        };
      IterableExtensions.<Assignment>forEach(_map_1, _function_6);
    }
  }
  
  public Object retarget(final ElementReferenceExpression ere, final List<EObject> declared) {
    Object _xifexpression = null;
    Declaration _value = ere.getValue();
    boolean _contains = declared.contains(_value);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Declaration _value_1 = ere.getValue();
      Declaration _replaced = this.replaced(_value_1);
      ere.setValue(_replaced);
    }
    return _xifexpression;
  }
  
  public Object retarget(final Assignment assign, final List<EObject> declared) {
    Object _xifexpression = null;
    Variable _varRef = assign.getVarRef();
    boolean _contains = declared.contains(_varRef);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Variable _varRef_1 = assign.getVarRef();
      Declaration _replaced = this.replaced(((VariableDefinition) _varRef_1));
      assign.setVarRef(((Variable) _replaced));
    }
    return _xifexpression;
  }
  
  protected Declaration _replaced(final VariableDefinition vd) {
    VariableDefinition _create = this.factory.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final EventDefinition ed) {
    EventDefinition _create = this.factory.create(ed);
    return _create;
  }
  
  protected Declaration _replaced(final TimeEvent ed) {
    return ed;
  }
  
  public SexecFactory sexecFactory() {
    return SexecFactory.eINSTANCE;
  }
  
  public SGraphFactory sgraphFactory() {
    return SGraphFactory.eINSTANCE;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public Entry entry(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    final Function1<Vertex,Boolean> _function = new Function1<Vertex,Boolean>() {
        public Boolean apply(final Vertex v) {
          boolean _operator_and = false;
          if (!(v instanceof org.yakindu.sct.model.sgraph.Entry)) {
            _operator_and = false;
          } else {
            boolean _operator_or = false;
            boolean _operator_or_1 = false;
            String _name = v.getName();
            boolean _operator_equals = ObjectExtensions.operator_equals(_name, null);
            if (_operator_equals) {
              _operator_or_1 = true;
            } else {
              String _name_1 = v.getName();
              boolean _equals = "".equals(_name_1);
              _operator_or_1 = BooleanExtensions.operator_or(_operator_equals, _equals);
            }
            if (_operator_or_1) {
              _operator_or = true;
            } else {
              String _name_2 = v.getName();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_2, "default");
              _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_equals_1);
            }
            _operator_and = BooleanExtensions.operator_and((v instanceof org.yakindu.sct.model.sgraph.Entry), _operator_or);
          }
          return ((Boolean)_operator_and);
        }
      };
    Vertex _findFirst = IterableExtensions.<Vertex>findFirst(_vertices, _function);
    return ((Entry) _findFirst);
  }
  
  public State target(final Entry entry) {
    State _xifexpression = null;
    EList<Transition> _outgoingTransitions = entry==null?(EList<Transition>)null:entry.getOutgoingTransitions();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_outgoingTransitions, null);
    if (_operator_notEquals) {
      State _xifexpression_1 = null;
      EList<Transition> _outgoingTransitions_1 = entry.getOutgoingTransitions();
      int _size = _outgoingTransitions_1.size();
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
      if (_operator_greaterThan) {
        State _xblockexpression = null;
        {
          EList<Transition> _outgoingTransitions_2 = entry.getOutgoingTransitions();
          Transition _get = _outgoingTransitions_2.get(0);
          Vertex _target = _get.getTarget();
          final Vertex target = _target;
          State _xifexpression_2 = null;
          if ((target instanceof org.yakindu.sct.model.sgraph.State)) {
            _xifexpression_2 = ((State) target);
          }
          _xblockexpression = (_xifexpression_2);
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Declaration map(final Declaration e) {
    if ((e instanceof EventDefinition)) {
      return _map((EventDefinition)e);
    } else if ((e instanceof VariableDefinition)) {
      return _map((VariableDefinition)e);
    } else if ((e instanceof Declaration)) {
      return _map((Declaration)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(e).toString());
    }
  }
  
  public ExecutionState mapState(final RegularState state) {
    if ((state instanceof FinalState)) {
      return _mapState((FinalState)state);
    } else if ((state instanceof State)) {
      return _mapState((State)state);
    } else if ((state instanceof RegularState)) {
      return _mapState((RegularState)state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(state).toString());
    }
  }
  
  public StateVector stateVector(final Vertex choice) {
    if ((choice instanceof Choice)) {
      return _stateVector((Choice)choice);
    } else if ((choice instanceof RegularState)) {
      return _stateVector((RegularState)choice);
    } else if ((choice instanceof Vertex)) {
      return _stateVector((Vertex)choice);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(choice).toString());
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
  
  public Check mapToCheck(final Trigger tr) {
    if ((tr instanceof ReactionTrigger)) {
      return _mapToCheck((ReactionTrigger)tr);
    } else if ((tr instanceof Trigger)) {
      return _mapToCheck((Trigger)tr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(tr).toString());
    }
  }
  
  public Statement buildCondition(final Trigger t) {
    if ((t instanceof ReactionTrigger)) {
      return _buildCondition((ReactionTrigger)t);
    } else if ((t instanceof Trigger)) {
      return _buildCondition((Trigger)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(t).toString());
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
  
  public int defineStateVectors(final Vertex s, final Integer offset) {
    if ((s instanceof FinalState)
         && (offset instanceof Integer)) {
      return _defineStateVectors((FinalState)s, (Integer)offset);
    } else if ((s instanceof State)
         && (offset instanceof Integer)) {
      return _defineStateVectors((State)s, (Integer)offset);
    } else if ((s instanceof Vertex)
         && (offset instanceof Integer)) {
      return _defineStateVectors((Vertex)s, (Integer)offset);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(s, offset).toString());
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
  
  public boolean isLeaf(final RegularState s) {
    if ((s instanceof FinalState)) {
      return _isLeaf((FinalState)s);
    } else if ((s instanceof State)) {
      return _isLeaf((State)s);
    } else if ((s instanceof RegularState)) {
      return _isLeaf((RegularState)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(s).toString());
    }
  }
  
  public Declaration replaced(final Declaration ed) {
    if ((ed instanceof TimeEvent)) {
      return _replaced((TimeEvent)ed);
    } else if ((ed instanceof EventDefinition)) {
      return _replaced((EventDefinition)ed);
    } else if ((ed instanceof VariableDefinition)) {
      return _replaced((VariableDefinition)ed);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(ed).toString());
    }
  }
}