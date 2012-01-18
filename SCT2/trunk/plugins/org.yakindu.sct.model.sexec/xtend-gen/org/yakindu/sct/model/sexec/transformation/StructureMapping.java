package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.Operation;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class StructureMapping {
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private StatechartExtensions sct;
  
  public ExecutionFlow mapScopes(final Statechart sc, final ExecutionFlow flow) {
    ExecutionFlow _xblockexpression = null;
    {
      EList<Scope> _scopes = flow.getScopes();
      EList<Scope> _scopes_1 = sc.getScopes();
      final Function1<Scope,Scope> _function = new Function1<Scope,Scope>() {
          public Scope apply(final Scope scope) {
            Scope _map = StructureMapping.this.map(scope);
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
      Scope _create = this.mapping.create(scope);
      final Scope _scope = _create;
      EList<Declaration> _declarations = _scope.getDeclarations();
      EList<Declaration> _declarations_1 = scope.getDeclarations();
      final Function1<Declaration,Declaration> _function = new Function1<Declaration,Declaration>() {
          public Declaration apply(final Declaration decl) {
            Declaration _map = StructureMapping.this.map(decl);
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
      EventDefinition _create = this.mapping.create(e);
      final EventDefinition _e = _create;
      return _e;
    }
  }
  
  protected Declaration _map(final VariableDefinition v) {
    {
      VariableDefinition _create = this.mapping.create(v);
      final VariableDefinition _v = _create;
      return _v;
    }
  }
  
  protected Declaration _map(final Operation v) {
    {
      Operation _create = this.mapping.create(v);
      final Operation _v = _create;
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
            ExecutionState _mapState = StructureMapping.this.mapState(s);
            return _mapState;
          }
        };
      List<ExecutionState> _map = ListExtensions.<RegularState, ExecutionState>map(allStates, _function);
      _states.addAll(_map);
      return r;
    }
  }
  
  protected ExecutionState _mapState(final FinalState state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState _state = _create;
      _state.setLeaf(true);
      _state.setEntryAction(null);
      _state.setExitAction(null);
      return _state;
    }
  }
  
  protected ExecutionState _mapState(final State state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState _state = _create;
      boolean _isSimple = state.isSimple();
      _state.setLeaf(_isSimple);
      return _state;
    }
  }
  
  protected ExecutionState _mapState(final RegularState state) {
    return null;
  }
  
  public ExecutionFlow mapRegions(final Statechart statechart, final ExecutionFlow flow) {
    {
      List<Region> _allRegions = this.sct.allRegions(statechart);
      final List<Region> allRegions = _allRegions;
      EList<ExecutionRegion> _regions = flow.getRegions();
      final Function1<Region,ExecutionRegion> _function = new Function1<Region,ExecutionRegion>() {
          public ExecutionRegion apply(final Region r) {
            ExecutionRegion _mapRegion = StructureMapping.this.mapRegion(r);
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
      ExecutionRegion _create = this.mapping.create(region);
      final ExecutionRegion _region = _create;
      CompositeElement _composite = region.getComposite();
      if ((_composite instanceof org.yakindu.sct.model.sgraph.Statechart)) {
        CompositeElement _composite_1 = region.getComposite();
        ExecutionFlow _create_1 = this.mapping.create(((Statechart) _composite_1));
        _region.setSuperScope(_create_1);
      } else {
        CompositeElement _composite_2 = region.getComposite();
        ExecutionState _create_2 = this.mapping.create(((State) _composite_2));
        _region.setSuperScope(_create_2);
      }
      EList<ExecutionScope> _subScopes = _region.getSubScopes();
      EList<Vertex> _vertices = region.getVertices();
      Iterable<RegularState> _filter = IterableExtensions.<RegularState>filter(_vertices, org.yakindu.sct.model.sgraph.RegularState.class);
      final Function1<RegularState,ExecutionScope> _function = new Function1<RegularState,ExecutionScope>() {
          public ExecutionScope apply(final RegularState v) {
            ExecutionState _create_3 = StructureMapping.this.mapping.create(v);
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
            ExecutionChoice _create = StructureMapping.this.mapping.create(choice);
            return _create;
          }
        };
      List<ExecutionChoice> _map = ListExtensions.<Choice, ExecutionChoice>map(allChoices, _function);
      _nodes.addAll(_map);
      return r;
    }
  }
  
  public ExecutionFlow mapTimeEvents(final Statechart statechart, final ExecutionFlow r) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(statechart);
      List<EObject> content = _eAllContentsAsList;
      Iterable<State> _filter = IterableExtensions.<State>filter(content, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,ArrayList<TimeEvent>> _function = new Function1<State,ArrayList<TimeEvent>>() {
          public ArrayList<TimeEvent> apply(final State s) {
            ArrayList<TimeEvent> _mapTimeEventSpecs = StructureMapping.this.mapTimeEventSpecs(s);
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
          TimeEvent _createDerivedEvent = this.mapping.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          String _name = state.getName();
          String _operator_plus = StringExtensions.operator_plus(_name, "_time_event_");
          int _indexOf = timeEventSpecs.indexOf(tes);
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ((Integer)_indexOf));
          timeEvent.setName(_operator_plus_1);
          Statechart _statechart = this.sct.statechart(state);
          ExecutionFlow _create = this.mapping.create(_statechart);
          Scope _timeEventScope = this.mapping.timeEventScope(_create);
          EList<Declaration> _declarations = _timeEventScope.getDeclarations();
          _declarations.add(timeEvent);
          result.add(timeEvent);
        }
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public Declaration map(final Declaration e) {
    if ((e instanceof EventDefinition)) {
      return _map((EventDefinition)e);
    } else if ((e instanceof VariableDefinition)) {
      return _map((VariableDefinition)e);
    } else if ((e instanceof Operation)) {
      return _map((Operation)e);
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
}