package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
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
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;

@SuppressWarnings("all")
public class StatechartExtensions {
  /**
   * calculates the maximum orthogonality (maximum number of possible active leaf states) of the statechart
   */
  public int maxOrthogonality(final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    final Function2<Integer,Region,Integer> _function = new Function2<Integer,Region,Integer>() {
        public Integer apply(final Integer o, final Region r) {
          int _maxOrthogonality = StatechartExtensions.this.maxOrthogonality(r);
          int _plus = (_maxOrthogonality + (o).intValue());
          return Integer.valueOf(_plus);
        }
      };
    Integer _fold = IterableExtensions.<Region, Integer>fold(_regions, Integer.valueOf(0), _function);
    return (_fold).intValue();
  }
  
  /**
   * calculates the maximum orthogonality (maximum number of possible active leaf states) of a region
   */
  public int maxOrthogonality(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    final Function2<Integer,Vertex,Integer> _function = new Function2<Integer,Vertex,Integer>() {
        public Integer apply(final Integer s, final Vertex v) {
          int _xblockexpression = (int) 0;
          {
            final int mo = StatechartExtensions.this.maxOrthogonality(v);
            int _xifexpression = (int) 0;
            boolean _greaterThan = (mo > (s).intValue());
            if (_greaterThan) {
              _xifexpression = mo;
            } else {
              _xifexpression = s;
            }
            _xblockexpression = (_xifexpression);
          }
          return Integer.valueOf(_xblockexpression);
        }
      };
    Integer _fold = IterableExtensions.<Vertex, Integer>fold(_vertices, Integer.valueOf(0), _function);
    return (_fold).intValue();
  }
  
  /**
   * the maximum orthogonality of all  pseudo states is 0
   */
  protected int _maxOrthogonality(final Vertex v) {
    return 0;
  }
  
  /**
   * calculates the maximum orthogonality (maximum number of possible active leaf states) of a state
   */
  protected int _maxOrthogonality(final State s) {
    Integer _xifexpression = null;
    EList<Region> _regions = s.getRegions();
    int _size = _regions.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      EList<Region> _regions_1 = s.getRegions();
      final Function2<Integer,Region,Integer> _function = new Function2<Integer,Region,Integer>() {
          public Integer apply(final Integer o, final Region r) {
            int _maxOrthogonality = StatechartExtensions.this.maxOrthogonality(r);
            int _plus = (_maxOrthogonality + (o).intValue());
            return Integer.valueOf(_plus);
          }
        };
      Integer _fold = IterableExtensions.<Region, Integer>fold(_regions_1, Integer.valueOf(0), _function);
      _xifexpression = _fold;
    } else {
      _xifexpression = 1;
    }
    return (_xifexpression).intValue();
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
    if ((_eContainer instanceof Statechart)) {
      EObject _eContainer_1 = region.eContainer();
      _xifexpression = ((Statechart) _eContainer_1);
    } else {
      EObject _eContainer_2 = region.eContainer();
      Statechart _statechart = this.statechart(((State) _eContainer_2));
      _xifexpression = _statechart;
    }
    return _xifexpression;
  }
  
  /**
   * Provides a list of all TimeEventSpecs that are defined in the context of 'statechart'.
   */
  public List<TimeEventSpec> timeEventSpecs(final Statechart state) {
    ArrayList<TimeEventSpec> _arrayList = new ArrayList<TimeEventSpec>();
    ArrayList<TimeEventSpec> tesList = _arrayList;
    EList<Reaction> _localReactions = state.getLocalReactions();
    final Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>> _function = new Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>>() {
        public ArrayList<TimeEventSpec> apply(final ArrayList<TimeEventSpec> s, final Reaction r) {
          ArrayList<TimeEventSpec> _xblockexpression = null;
          {
            List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(r);
            Iterable<TimeEventSpec> _filter = Iterables.<TimeEventSpec>filter(_eAllContentsAsList, TimeEventSpec.class);
            final Procedure1<TimeEventSpec> _function = new Procedure1<TimeEventSpec>() {
                public void apply(final TimeEventSpec tes) {
                  s.add(tes);
                }
              };
            IterableExtensions.<TimeEventSpec>forEach(_filter, _function);
            _xblockexpression = (s);
          }
          return _xblockexpression;
        }
      };
    IterableExtensions.<Reaction, ArrayList<TimeEventSpec>>fold(_localReactions, tesList, _function);
    return tesList;
  }
  
  /**
   * Provides a list of all TimeEventSpecs that are defined in the context of 'state'.
   */
  protected List<TimeEventSpec> _timeEventSpecs(final State state) {
    ArrayList<TimeEventSpec> _arrayList = new ArrayList<TimeEventSpec>();
    ArrayList<TimeEventSpec> tesList = _arrayList;
    EList<Transition> _outgoingTransitions = state.getOutgoingTransitions();
    final Function2<ArrayList<TimeEventSpec>,Transition,ArrayList<TimeEventSpec>> _function = new Function2<ArrayList<TimeEventSpec>,Transition,ArrayList<TimeEventSpec>>() {
        public ArrayList<TimeEventSpec> apply(final ArrayList<TimeEventSpec> s, final Transition r) {
          ArrayList<TimeEventSpec> _xblockexpression = null;
          {
            List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(r);
            Iterable<TimeEventSpec> _filter = Iterables.<TimeEventSpec>filter(_eAllContentsAsList, TimeEventSpec.class);
            final Procedure1<TimeEventSpec> _function = new Procedure1<TimeEventSpec>() {
                public void apply(final TimeEventSpec tes) {
                  s.add(tes);
                }
              };
            IterableExtensions.<TimeEventSpec>forEach(_filter, _function);
            _xblockexpression = (s);
          }
          return _xblockexpression;
        }
      };
    IterableExtensions.<Transition, ArrayList<TimeEventSpec>>fold(_outgoingTransitions, tesList, _function);
    EList<Reaction> _localReactions = state.getLocalReactions();
    final Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>> _function_1 = new Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>>() {
        public ArrayList<TimeEventSpec> apply(final ArrayList<TimeEventSpec> s, final Reaction r) {
          ArrayList<TimeEventSpec> _xblockexpression = null;
          {
            List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(r);
            Iterable<TimeEventSpec> _filter = Iterables.<TimeEventSpec>filter(_eAllContentsAsList, TimeEventSpec.class);
            final Procedure1<TimeEventSpec> _function = new Procedure1<TimeEventSpec>() {
                public void apply(final TimeEventSpec tes) {
                  s.add(tes);
                }
              };
            IterableExtensions.<TimeEventSpec>forEach(_filter, _function);
            _xblockexpression = (s);
          }
          return _xblockexpression;
        }
      };
    IterableExtensions.<Reaction, ArrayList<TimeEventSpec>>fold(_localReactions, tesList, _function_1);
    return tesList;
  }
  
  /**
   * Provides a list of all TimeEventSpecs that are defined in the context of 'state'.
   */
  protected List<TimeEventSpec> _timeEventSpecs(final Statechart state) {
    ArrayList<TimeEventSpec> _arrayList = new ArrayList<TimeEventSpec>();
    ArrayList<TimeEventSpec> tesList = _arrayList;
    EList<Reaction> _localReactions = state.getLocalReactions();
    final Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>> _function = new Function2<ArrayList<TimeEventSpec>,Reaction,ArrayList<TimeEventSpec>>() {
        public ArrayList<TimeEventSpec> apply(final ArrayList<TimeEventSpec> s, final Reaction r) {
          ArrayList<TimeEventSpec> _xblockexpression = null;
          {
            List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(r);
            Iterable<TimeEventSpec> _filter = Iterables.<TimeEventSpec>filter(_eAllContentsAsList, TimeEventSpec.class);
            final Procedure1<TimeEventSpec> _function = new Procedure1<TimeEventSpec>() {
                public void apply(final TimeEventSpec tes) {
                  s.add(tes);
                }
              };
            IterableExtensions.<TimeEventSpec>forEach(_filter, _function);
            _xblockexpression = (s);
          }
          return _xblockexpression;
        }
      };
    IterableExtensions.<Reaction, ArrayList<TimeEventSpec>>fold(_localReactions, tesList, _function);
    return tesList;
  }
  
  protected ReactiveElement _reactiveElement(final Reaction r) {
    Scope _scope = this.scope(r);
    ReactiveElement _reactiveElement = this.reactiveElement(_scope);
    return _reactiveElement;
  }
  
  protected ReactiveElement _reactiveElement(final Transition tr) {
    State _xifexpression = null;
    Vertex _source = tr.getSource();
    if ((_source instanceof State)) {
      _xifexpression = ((State) tr);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public Scope scope(final Reaction r) {
    Scope _xifexpression = null;
    EObject _eContainer = r.eContainer();
    if ((_eContainer instanceof Scope)) {
      EObject _eContainer_1 = r.eContainer();
      _xifexpression = ((Scope) _eContainer_1);
    }
    return _xifexpression;
  }
  
  public ReactiveElement reactiveElement(final Scope s) {
    ReactiveElement _xifexpression = null;
    EObject _eContainer = s.eContainer();
    if ((_eContainer instanceof ReactiveElement)) {
      EObject _eContainer_1 = s.eContainer();
      _xifexpression = ((ReactiveElement) _eContainer_1);
    }
    return _xifexpression;
  }
  
  public List<RegularState> allRegularStates(final Statechart sc) {
    List<EObject> content = EcoreUtil2.eAllContentsAsList(sc);
    final Iterable<RegularState> allStates = Iterables.<RegularState>filter(content, RegularState.class);
    return IterableExtensions.<RegularState>toList(allStates);
  }
  
  public List<Region> allRegions(final Statechart sc) {
    List<EObject> content = EcoreUtil2.eAllContentsAsList(sc);
    final Iterable<Region> allRegions = Iterables.<Region>filter(content, Region.class);
    return IterableExtensions.<Region>toList(allRegions);
  }
  
  public Iterable<Choice> allChoices(final Statechart sc) {
    List<EObject> content = EcoreUtil2.eAllContentsAsList(sc);
    final Iterable<Choice> allChoices = Iterables.<Choice>filter(content, Choice.class);
    return allChoices;
  }
  
  public Iterable<Entry> allEntries(final Statechart sc) {
    TreeIterator<EObject> _eAllContents = sc.eAllContents();
    Iterator<Entry> _filter = Iterators.<Entry>filter(_eAllContents, Entry.class);
    return IteratorExtensions.<Entry>toIterable(_filter);
  }
  
  public List<LocalReaction> entryReactions(final ReactiveElement state) {
    EList<Reaction> _localReactions = state.getLocalReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          Trigger _trigger = ((LocalReaction) r).getTrigger();
          EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
          final Function1<EventSpec,Boolean> _function = new Function1<EventSpec,Boolean>() {
              public Boolean apply(final EventSpec t) {
                return Boolean.valueOf((t instanceof EntryEvent));
              }
            };
          boolean _exists = IterableExtensions.<EventSpec>exists(_triggers, _function);
          return Boolean.valueOf(_exists);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_localReactions, _function);
    final Function1<Reaction,LocalReaction> _function_1 = new Function1<Reaction,LocalReaction>() {
        public LocalReaction apply(final Reaction lr) {
          return ((LocalReaction) lr);
        }
      };
    Iterable<LocalReaction> _map = IterableExtensions.<Reaction, LocalReaction>map(_filter, _function_1);
    List<LocalReaction> _list = IterableExtensions.<LocalReaction>toList(_map);
    return _list;
  }
  
  public List<LocalReaction> exitReactions(final ReactiveElement state) {
    EList<Reaction> _localReactions = state.getLocalReactions();
    final Function1<Reaction,Boolean> _function = new Function1<Reaction,Boolean>() {
        public Boolean apply(final Reaction r) {
          Trigger _trigger = ((LocalReaction) r).getTrigger();
          EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
          final Function1<EventSpec,Boolean> _function = new Function1<EventSpec,Boolean>() {
              public Boolean apply(final EventSpec t) {
                return Boolean.valueOf((t instanceof ExitEvent));
              }
            };
          boolean _exists = IterableExtensions.<EventSpec>exists(_triggers, _function);
          return Boolean.valueOf(_exists);
        }
      };
    Iterable<Reaction> _filter = IterableExtensions.<Reaction>filter(_localReactions, _function);
    final Function1<Reaction,LocalReaction> _function_1 = new Function1<Reaction,LocalReaction>() {
        public LocalReaction apply(final Reaction lr) {
          return ((LocalReaction) lr);
        }
      };
    Iterable<LocalReaction> _map = IterableExtensions.<Reaction, LocalReaction>map(_filter, _function_1);
    List<LocalReaction> _list = IterableExtensions.<LocalReaction>toList(_map);
    return _list;
  }
  
  protected String _id(final Object obj) {
    return null;
  }
  
  /**
   * The id of a transition is unique within the context of its source vertex.
   */
  protected String _id(final Transition t) {
    Object _xifexpression = null;
    Vertex _source = t.getSource();
    boolean _notEquals = (!Objects.equal(_source, null));
    if (_notEquals) {
      Vertex _source_1 = t.getSource();
      EList<Transition> _outgoingTransitions = _source_1.getOutgoingTransitions();
      int _indexOf = _outgoingTransitions.indexOf(t);
      _xifexpression = _indexOf;
    } else {
      _xifexpression = "";
    }
    String _plus = ("tr" + ((Comparable<Object>)_xifexpression));
    return _plus;
  }
  
  /**
   * The id of a local reaction is unique within the context of its source vertex.
   */
  protected String _id(final LocalReaction t) {
    Object _xifexpression = null;
    ReactiveElement _reactiveElement = this.reactiveElement(t);
    boolean _notEquals = (!Objects.equal(_reactiveElement, null));
    if (_notEquals) {
      ReactiveElement _reactiveElement_1 = this.reactiveElement(t);
      EList<Reaction> _localReactions = _reactiveElement_1.getLocalReactions();
      int _indexOf = _localReactions.indexOf(t);
      _xifexpression = _indexOf;
    } else {
      _xifexpression = "";
    }
    String _plus = ("lr" + ((Comparable<Object>)_xifexpression));
    return _plus;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public int maxOrthogonality(final Vertex s) {
    if (s instanceof State) {
      return _maxOrthogonality((State)s);
    } else if (s != null) {
      return _maxOrthogonality(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public List<TimeEventSpec> timeEventSpecs(final EObject state) {
    if (state instanceof State) {
      return _timeEventSpecs((State)state);
    } else if (state instanceof Statechart) {
      return _timeEventSpecs((Statechart)state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(state).toString());
    }
  }
  
  public ReactiveElement reactiveElement(final Reaction tr) {
    if (tr instanceof Transition) {
      return _reactiveElement((Transition)tr);
    } else if (tr != null) {
      return _reactiveElement(tr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tr).toString());
    }
  }
  
  public String id(final Object t) {
    if (t instanceof LocalReaction) {
      return _id((LocalReaction)t);
    } else if (t instanceof Transition) {
      return _id((Transition)t);
    } else if (t != null) {
      return _id(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
}
