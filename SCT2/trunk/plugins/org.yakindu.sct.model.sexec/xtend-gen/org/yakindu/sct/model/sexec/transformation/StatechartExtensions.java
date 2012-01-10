package org.yakindu.sct.model.sexec.transformation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactiveElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;

@SuppressWarnings("all")
public class StatechartExtensions {
  
  public int maxOrthogonality(final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    final Function2<Integer,Region,Integer> _function = new Function2<Integer,Region,Integer>() {
        public Integer apply(final Integer o , final Region r) {
          int _maxOrthogonality = StatechartExtensions.this.maxOrthogonality(r);
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)_maxOrthogonality), o);
          return ((Integer)_operator_plus);
        }
      };
    Integer _fold = IterableExtensions.<Region, Integer>fold(_regions, ((Integer)0), _function);
    return _fold;
  }
  
  public int maxOrthogonality(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    final Function2<Integer,Vertex,Integer> _function = new Function2<Integer,Vertex,Integer>() {
        public Integer apply(final Integer s , final Vertex v) {
          int _xblockexpression = (int) 0;
          {
            int _maxOrthogonality = StatechartExtensions.this.maxOrthogonality(v);
            final int mo = _maxOrthogonality;
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
    return _fold;
  }
  
  protected int _maxOrthogonality(final Vertex v) {
    return 0;
  }
  
  protected int _maxOrthogonality(final State s) {
    Integer _xifexpression = null;
    EList<Region> _regions = s.getRegions();
    int _size = _regions.size();
    boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
    if (_operator_greaterThan) {
      EList<Region> _regions_1 = s.getRegions();
      final Function2<Integer,Region,Integer> _function = new Function2<Integer,Region,Integer>() {
          public Integer apply(final Integer o , final Region r) {
            int _maxOrthogonality = StatechartExtensions.this.maxOrthogonality(r);
            int _operator_plus = IntegerExtensions.operator_plus(((Integer)_maxOrthogonality), o);
            return ((Integer)_operator_plus);
          }
        };
      Integer _fold = IterableExtensions.<Region, Integer>fold(_regions_1, ((Integer)0), _function);
      _xifexpression = _fold;
    } else {
      _xifexpression = 1;
    }
    return _xifexpression;
  }
  
  public Reaction reaction(final Trigger tr) {
    EObject _eContainer = tr.eContainer();
    return ((Reaction) _eContainer);
  }
  
  public Statechart statechart(final State state) {
    Region _parentRegion = state.getParentRegion();
    Statechart _statechart = this.statechart(_parentRegion);
    return _statechart;
  }
  
  public Statechart statechart(final Region region) {
    Statechart _xifexpression = null;
    EObject _eContainer = region.eContainer();
    if ((_eContainer instanceof org.yakindu.sct.model.sgraph.Statechart)) {
      EObject _eContainer_1 = region.eContainer();
      _xifexpression = ((Statechart) _eContainer_1);
    } else {
      EObject _eContainer_2 = region.eContainer();
      Statechart _statechart = this.statechart(((State) _eContainer_2));
      _xifexpression = _statechart;
    }
    return _xifexpression;
  }
  
  public List<TimeEventSpec> timeEventSpecs(final State state) {
    {
      ArrayList<TimeEventSpec> _arrayList = new ArrayList<TimeEventSpec>();
      ArrayList<TimeEventSpec> tesList = _arrayList;
      EList<Transition> _outgoingTransitions = state.getOutgoingTransitions();
      final Function2<ArrayList<TimeEventSpec>,Transition,ArrayList<TimeEventSpec>> _function = new Function2<ArrayList<TimeEventSpec>,Transition,ArrayList<TimeEventSpec>>() {
          public ArrayList<TimeEventSpec> apply(final ArrayList<TimeEventSpec> s , final Transition r) {
            ArrayList<TimeEventSpec> _xblockexpression = null;
            {
              List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(r);
              Iterable<TimeEventSpec> _filter = IterableExtensions.<TimeEventSpec>filter(_eAllContentsAsList, org.yakindu.sct.model.stext.stext.TimeEventSpec.class);
              final Function1<TimeEventSpec,Boolean> _function_1 = new Function1<TimeEventSpec,Boolean>() {
                  public Boolean apply(final TimeEventSpec tes) {
                    boolean _add = s.add(tes);
                    return ((Boolean)_add);
                  }
                };
              IterableExtensions.<TimeEventSpec>forEach(_filter, _function_1);
              _xblockexpression = (s);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<Transition, ArrayList<TimeEventSpec>>fold(_outgoingTransitions, tesList, _function);
      EList<Reaction> _localReactions = state.getLocalReactions();
      final Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>> _function_2 = new Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>>() {
          public ArrayList<TimeEventSpec> apply(final ArrayList<TimeEventSpec> s_1 , final Reaction r_1) {
            ArrayList<TimeEventSpec> _xblockexpression_1 = null;
            {
              List<EObject> _eAllContentsAsList_1 = EcoreUtil2.eAllContentsAsList(r_1);
              Iterable<TimeEventSpec> _filter_1 = IterableExtensions.<TimeEventSpec>filter(_eAllContentsAsList_1, org.yakindu.sct.model.stext.stext.TimeEventSpec.class);
              final Function1<TimeEventSpec,Boolean> _function_3 = new Function1<TimeEventSpec,Boolean>() {
                  public Boolean apply(final TimeEventSpec tes_1) {
                    boolean _add_1 = s_1.add(tes_1);
                    return ((Boolean)_add_1);
                  }
                };
              IterableExtensions.<TimeEventSpec>forEach(_filter_1, _function_3);
              _xblockexpression_1 = (s_1);
            }
            return _xblockexpression_1;
          }
        };
      IterableExtensions.<Reaction, ArrayList<TimeEventSpec>>fold(_localReactions, tesList, _function_2);
      return tesList;
    }
  }
  
  protected ReactiveElement _reactiveElement(final Reaction r) {
    Scope _scope = this.scope(r);
    ReactiveElement _reactiveElement = this.reactiveElement(_scope);
    return _reactiveElement;
  }
  
  protected ReactiveElement _reactiveElement(final Transition tr) {
    State _xifexpression = null;
    Vertex _source = tr.getSource();
    if ((_source instanceof org.yakindu.sct.model.sgraph.State)) {
      _xifexpression = ((State) tr);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public Scope scope(final Reaction r) {
    Scope _xifexpression = null;
    EObject _eContainer = r.eContainer();
    if ((_eContainer instanceof org.yakindu.sct.model.sgraph.Scope)) {
      EObject _eContainer_1 = r.eContainer();
      _xifexpression = ((Scope) _eContainer_1);
    }
    return _xifexpression;
  }
  
  public ReactiveElement reactiveElement(final Scope s) {
    ReactiveElement _xifexpression = null;
    EObject _eContainer = s.eContainer();
    if ((_eContainer instanceof org.yakindu.sct.model.sgraph.ReactiveElement)) {
      EObject _eContainer_1 = s.eContainer();
      _xifexpression = ((ReactiveElement) _eContainer_1);
    }
    return _xifexpression;
  }
  
  public List<RegularState> allRegularStates(final Statechart sc) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(sc);
      List<EObject> content = _eAllContentsAsList;
      Iterable<RegularState> _filter = IterableExtensions.<RegularState>filter(content, org.yakindu.sct.model.sgraph.RegularState.class);
      final Iterable<RegularState> allStates = _filter;
      List<RegularState> _list = IterableExtensions.<RegularState>toList(allStates);
      return _list;
    }
  }
  
  public List<Region> allRegions(final Statechart sc) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(sc);
      List<EObject> content = _eAllContentsAsList;
      Iterable<Region> _filter = IterableExtensions.<Region>filter(content, org.yakindu.sct.model.sgraph.Region.class);
      final Iterable<Region> allRegions = _filter;
      List<Region> _list = IterableExtensions.<Region>toList(allRegions);
      return _list;
    }
  }
  
  public List<Choice> allChoices(final Statechart sc) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(sc);
      List<EObject> content = _eAllContentsAsList;
      Iterable<Choice> _filter = IterableExtensions.<Choice>filter(content, org.yakindu.sct.model.sgraph.Choice.class);
      final Iterable<Choice> allChoices = _filter;
      List<Choice> _list = IterableExtensions.<Choice>toList(allChoices);
      return _list;
    }
  }
  
  public List<LocalReaction> entryReactions(final State state) {
    EList<Reaction> _localReactions = state.getLocalReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          Trigger _trigger = ((LocalReaction) r).getTrigger();
          EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
          final Function1<EventSpec,Boolean> _function_1 = new Function1<EventSpec,Boolean>() {
              public Boolean apply(final EventSpec t) {
                return (t instanceof org.yakindu.sct.model.stext.stext.EntryEvent);
              }
            };
          boolean _exists = IterableExtensions.<EventSpec>exists(_triggers, _function_1);
          return ((Boolean)_exists);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_localReactions, _function);
    final Function1<Reaction,LocalReaction> _function_2 = new Function1<Reaction,LocalReaction>() {
        public LocalReaction apply(final Reaction lr) {
          return ((LocalReaction) lr);
        }
      };
    Iterable<LocalReaction> _map = IterableExtensions.<Reaction, LocalReaction>map(_filter, _function_2);
    List<LocalReaction> _list = IterableExtensions.<LocalReaction>toList(_map);
    return _list;
  }
  
  public List<LocalReaction> exitReactions(final State state) {
    EList<Reaction> _localReactions = state.getLocalReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          Trigger _trigger = ((LocalReaction) r).getTrigger();
          EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
          final Function1<EventSpec,Boolean> _function_1 = new Function1<EventSpec,Boolean>() {
              public Boolean apply(final EventSpec t) {
                return (t instanceof org.yakindu.sct.model.stext.stext.ExitEvent);
              }
            };
          boolean _exists = IterableExtensions.<EventSpec>exists(_triggers, _function_1);
          return ((Boolean)_exists);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_localReactions, _function);
    final Function1<Reaction,LocalReaction> _function_2 = new Function1<Reaction,LocalReaction>() {
        public LocalReaction apply(final Reaction lr) {
          return ((LocalReaction) lr);
        }
      };
    Iterable<LocalReaction> _map = IterableExtensions.<Reaction, LocalReaction>map(_filter, _function_2);
    List<LocalReaction> _list = IterableExtensions.<LocalReaction>toList(_map);
    return _list;
  }
  
  protected String _id(final Object obj) {
    return null;
  }
  
  protected String _id(final Transition t) {
    Comparable<? extends Object> _xifexpression = null;
    Vertex _source = t.getSource();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_source, null);
    if (_operator_notEquals) {
      Vertex _source_1 = t.getSource();
      EList<Transition> _outgoingTransitions = _source_1.getOutgoingTransitions();
      int _indexOf = _outgoingTransitions.indexOf(t);
      _xifexpression = _indexOf;
    } else {
      _xifexpression = "";
    }
    String _operator_plus = StringExtensions.operator_plus("tr", _xifexpression);
    return _operator_plus;
  }
  
  protected String _id(final LocalReaction t) {
    Comparable<? extends Object> _xifexpression = null;
    ReactiveElement _reactiveElement = this.reactiveElement(t);
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_reactiveElement, null);
    if (_operator_notEquals) {
      ReactiveElement _reactiveElement_1 = this.reactiveElement(t);
      EList<Reaction> _localReactions = _reactiveElement_1.getLocalReactions();
      int _indexOf = _localReactions.indexOf(t);
      _xifexpression = _indexOf;
    } else {
      _xifexpression = "";
    }
    String _operator_plus = StringExtensions.operator_plus("lr", _xifexpression);
    return _operator_plus;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public int maxOrthogonality(final Vertex s) {
    if ((s instanceof State)) {
      return _maxOrthogonality((State)s);
    } else if ((s instanceof Vertex)) {
      return _maxOrthogonality((Vertex)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(s).toString());
    }
  }
  
  public ReactiveElement reactiveElement(final Reaction tr) {
    if ((tr instanceof Transition)) {
      return _reactiveElement((Transition)tr);
    } else if ((tr instanceof Reaction)) {
      return _reactiveElement((Reaction)tr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(tr).toString());
    }
  }
  
  public String id(final Object t) {
    if ((t instanceof LocalReaction)) {
      return _id((LocalReaction)t);
    } else if ((t instanceof Transition)) {
      return _id((Transition)t);
    } else if ((t instanceof Object)) {
      return _id((Object)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(t).toString());
    }
  }
}