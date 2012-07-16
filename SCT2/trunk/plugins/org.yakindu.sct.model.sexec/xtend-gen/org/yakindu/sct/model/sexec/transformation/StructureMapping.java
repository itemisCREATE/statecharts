package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExecutionSynchronization;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class StructureMapping {
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private StatechartExtensions sct;
  
  /**
   * maps all required scope defined in the statechart to the execution flow.
   * This includes creating the scopes and adding all relevant declarations. Empty scopes wont be mapped.
   */
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
      List<Scope> _map = ListExtensions.<Scope, Scope>map(_scopes_1, _function);
      _scopes.addAll(_map);
      _xblockexpression = (flow);
    }
    return _xblockexpression;
  }
  
  public Scope map(final Scope scope) {
    final Scope _scope = this.mapping.create(scope);
    EList<Declaration> _declarations = _scope.getDeclarations();
    EList<Declaration> _declarations_1 = scope.getDeclarations();
    final Function1<Declaration,Declaration> _function = new Function1<Declaration,Declaration>() {
        public Declaration apply(final Declaration decl) {
          Declaration _map = StructureMapping.this.map(decl);
          return _map;
        }
      };
    List<Declaration> _map = ListExtensions.<Declaration, Declaration>map(_declarations_1, _function);
    final Function1<Declaration,Boolean> _function_1 = new Function1<Declaration,Boolean>() {
        public Boolean apply(final Declaration e) {
          boolean _notEquals = (!Objects.equal(e, null));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<Declaration> _filter = IterableExtensions.<Declaration>filter(_map, _function_1);
    Iterables.<Declaration>addAll(_declarations, _filter);
    return _scope;
  }
  
  protected Declaration _map(final Declaration decl) {
    return null;
  }
  
  protected Declaration _map(final EventDefinition e) {
    final EventDefinition _e = this.mapping.create(e);
    return _e;
  }
  
  protected Declaration _map(final VariableDefinition v) {
    final VariableDefinition _v = this.mapping.create(v);
    return _v;
  }
  
  protected Declaration _map(final OperationDefinition v) {
    final OperationDefinition _v = this.mapping.create(v);
    return _v;
  }
  
  public ExecutionFlow mapRegularStates(final Statechart statechart, final ExecutionFlow r) {
    final List<RegularState> allStates = this.sct.allRegularStates(statechart);
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
  
  protected ExecutionState _mapState(final FinalState state) {
    final ExecutionState _state = this.mapping.create(state);
    _state.setLeaf(true);
    _state.setEntryAction(null);
    _state.setExitAction(null);
    return _state;
  }
  
  protected ExecutionState _mapState(final State state) {
    final ExecutionState _state = this.mapping.create(state);
    boolean _isSimple = state.isSimple();
    _state.setLeaf(_isSimple);
    return _state;
  }
  
  protected ExecutionState _mapState(final RegularState state) {
    return null;
  }
  
  public ExecutionFlow mapRegions(final Statechart statechart, final ExecutionFlow flow) {
    final List<Region> allRegions = this.sct.allRegions(statechart);
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
  
  public ExecutionRegion mapRegion(final Region region) {
    final ExecutionRegion _region = this.mapping.create(region);
    CompositeElement _composite = region.getComposite();
    if ((_composite instanceof Statechart)) {
      CompositeElement _composite_1 = region.getComposite();
      ExecutionFlow _create = this.mapping.create(((Statechart) _composite_1));
      _region.setSuperScope(_create);
    } else {
      CompositeElement _composite_2 = region.getComposite();
      ExecutionState _create_1 = this.mapping.create(((State) _composite_2));
      _region.setSuperScope(_create_1);
    }
    EList<ExecutionScope> _subScopes = _region.getSubScopes();
    EList<Vertex> _vertices = region.getVertices();
    Iterable<RegularState> _filter = Iterables.<RegularState>filter(_vertices, RegularState.class);
    final Function1<RegularState,ExecutionScope> _function = new Function1<RegularState,ExecutionScope>() {
        public ExecutionScope apply(final RegularState v) {
          ExecutionState _create = StructureMapping.this.mapping.create(v);
          return ((ExecutionScope) _create);
        }
      };
    Iterable<ExecutionScope> _map = IterableExtensions.<RegularState, ExecutionScope>map(_filter, _function);
    Iterables.<ExecutionScope>addAll(_subScopes, _map);
    EList<ExecutionNode> _nodes = _region.getNodes();
    EList<Vertex> _vertices_1 = region.getVertices();
    Iterable<Vertex> _filter_1 = Iterables.<Vertex>filter(_vertices_1, Vertex.class);
    final Function1<Vertex,ExecutionNode> _function_1 = new Function1<Vertex,ExecutionNode>() {
        public ExecutionNode apply(final Vertex v) {
          ExecutionNode _mapped = StructureMapping.this.mapping.mapped(v);
          return _mapped;
        }
      };
    Iterable<ExecutionNode> _map_1 = IterableExtensions.<Vertex, ExecutionNode>map(_filter_1, _function_1);
    Iterables.<ExecutionNode>addAll(_nodes, _map_1);
    return _region;
  }
  
  public ExecutionFlow mapPseudoStates(final Statechart statechart, final ExecutionFlow r) {
    EList<ExecutionNode> _nodes = r.getNodes();
    Iterable<Choice> _allChoices = this.sct.allChoices(statechart);
    final Function1<Choice,ExecutionChoice> _function = new Function1<Choice,ExecutionChoice>() {
        public ExecutionChoice apply(final Choice choice) {
          ExecutionChoice _create = StructureMapping.this.mapping.create(choice);
          return _create;
        }
      };
    Iterable<ExecutionChoice> _map = IterableExtensions.<Choice, ExecutionChoice>map(_allChoices, _function);
    Iterables.<ExecutionNode>addAll(_nodes, _map);
    EList<ExecutionNode> _nodes_1 = r.getNodes();
    Iterable<Entry> _allEntries = this.sct.allEntries(statechart);
    final Function1<Entry,ExecutionEntry> _function_1 = new Function1<Entry,ExecutionEntry>() {
        public ExecutionEntry apply(final Entry entry) {
          ExecutionEntry _create = StructureMapping.this.mapping.create(entry);
          return _create;
        }
      };
    Iterable<ExecutionEntry> _map_1 = IterableExtensions.<Entry, ExecutionEntry>map(_allEntries, _function_1);
    Iterables.<ExecutionNode>addAll(_nodes_1, _map_1);
    EList<ExecutionNode> _nodes_2 = r.getNodes();
    Iterable<Synchronization> _allSynchronizations = this.sct.allSynchronizations(statechart);
    final Function1<Synchronization,ExecutionSynchronization> _function_2 = new Function1<Synchronization,ExecutionSynchronization>() {
        public ExecutionSynchronization apply(final Synchronization sync) {
          ExecutionSynchronization _create = StructureMapping.this.mapping.create(sync);
          return _create;
        }
      };
    Iterable<ExecutionSynchronization> _map_2 = IterableExtensions.<Synchronization, ExecutionSynchronization>map(_allSynchronizations, _function_2);
    Iterables.<ExecutionNode>addAll(_nodes_2, _map_2);
    return r;
  }
  
  /**
   * Time trigger will be mapped to execution model time events for each real state.
   */
  public ExecutionFlow mapTimeEvents(final Statechart statechart, final ExecutionFlow r) {
    List<EObject> content = EcoreUtil2.eAllContentsAsList(statechart);
    final Iterable<State> allStates = Iterables.<State>filter(content, State.class);
    final Procedure1<State> _function = new Procedure1<State>() {
        public void apply(final State s) {
          StructureMapping.this.mapTimeEventSpecs(s);
        }
      };
    IterableExtensions.<State>forEach(allStates, _function);
    this.mapTimeEventSpecs(statechart);
    return r;
  }
  
  public ArrayList<TimeEvent> mapTimeEventSpecs(final State state) {
    ArrayList<TimeEvent> _xblockexpression = null;
    {
      final List<TimeEventSpec> timeEventSpecs = this.sct.timeEventSpecs(state);
      ArrayList<TimeEvent> _arrayList = new ArrayList<TimeEvent>();
      final ArrayList<TimeEvent> result = _arrayList;
      for (final TimeEventSpec tes : timeEventSpecs) {
        {
          final TimeEvent timeEvent = this.mapping.createDerivedEvent(tes);
          String _name = state.getName();
          String _plus = (_name + "_time_event_");
          int _indexOf = timeEventSpecs.indexOf(tes);
          String _plus_1 = (_plus + Integer.valueOf(_indexOf));
          timeEvent.setName(_plus_1);
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
  
  public ArrayList<TimeEvent> mapTimeEventSpecs(final Statechart statechart) {
    ArrayList<TimeEvent> _xblockexpression = null;
    {
      final List<TimeEventSpec> timeEventSpecs = this.sct.timeEventSpecs(statechart);
      ArrayList<TimeEvent> _arrayList = new ArrayList<TimeEvent>();
      final ArrayList<TimeEvent> result = _arrayList;
      for (final TimeEventSpec tes : timeEventSpecs) {
        {
          final TimeEvent timeEvent = this.mapping.createDerivedEvent(tes);
          String _name = statechart.getName();
          String _plus = (_name + "_time_event_");
          int _indexOf = timeEventSpecs.indexOf(tes);
          String _plus_1 = (_plus + Integer.valueOf(_indexOf));
          timeEvent.setName(_plus_1);
          ExecutionFlow _create = this.mapping.create(statechart);
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
    if (e instanceof EventDefinition) {
      return _map((EventDefinition)e);
    } else if (e instanceof OperationDefinition) {
      return _map((OperationDefinition)e);
    } else if (e instanceof VariableDefinition) {
      return _map((VariableDefinition)e);
    } else if (e != null) {
      return _map(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public ExecutionState mapState(final RegularState state) {
    if (state instanceof FinalState) {
      return _mapState((FinalState)state);
    } else if (state instanceof State) {
      return _mapState((State)state);
    } else if (state != null) {
      return _mapState(state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(state).toString());
    }
  }
}
