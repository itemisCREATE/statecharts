package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

@SuppressWarnings("all")
public class SgraphExtensions {
  public SGraphFactory factory() {
    return SGraphFactory.eINSTANCE;
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
  
  public List<RegularState> parentStates(final RegularState s) {
    List<EObject> _containers = this.containers(s);
    Iterable<RegularState> _filter = Iterables.<RegularState>filter(_containers, RegularState.class);
    List<RegularState> _list = IterableExtensions.<RegularState>toList(_filter);
    return _list;
  }
  
  public List<RegularState> parentStates(final Region s) {
    List<EObject> _containers = this.containers(s);
    Iterable<RegularState> _filter = Iterables.<RegularState>filter(_containers, RegularState.class);
    List<RegularState> _list = IterableExtensions.<RegularState>toList(_filter);
    return _list;
  }
  
  public List<EObject> containers(final EObject obj) {
    ArrayList<EObject> _arrayList = new ArrayList<EObject>();
    final ArrayList<EObject> containerList = _arrayList;
    this.collectContainers(obj, containerList);
    return containerList;
  }
  
  public void collectContainers(final EObject obj, final List<EObject> containerList) {
    containerList.add(obj);
    EObject _eContainer = obj==null?(EObject)null:obj.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, null));
    if (_notEquals) {
      EObject _eContainer_1 = obj.eContainer();
      this.collectContainers(_eContainer_1, containerList);
    }
  }
  
  public Iterable<Entry> collectEntries(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    Iterable<Entry> _filter = Iterables.<Entry>filter(_vertices, Entry.class);
    return _filter;
  }
  
  public Entry entry(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    final Function1<Vertex,Boolean> _function = new Function1<Vertex,Boolean>() {
        public Boolean apply(final Vertex v) {
          boolean _and = false;
          if (!(v instanceof Entry)) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _or_1 = false;
            String _name = v.getName();
            boolean _equals = Objects.equal(_name, null);
            if (_equals) {
              _or_1 = true;
            } else {
              String _name_1 = v.getName();
              boolean _equals_1 = "".equals(_name_1);
              _or_1 = (_equals || _equals_1);
            }
            if (_or_1) {
              _or = true;
            } else {
              String _name_2 = v.getName();
              boolean _equals_2 = Objects.equal(_name_2, "default");
              _or = (_or_1 || _equals_2);
            }
            _and = ((v instanceof Entry) && _or);
          }
          return Boolean.valueOf(_and);
        }
      };
    Vertex _findFirst = IterableExtensions.<Vertex>findFirst(_vertices, _function);
    return ((Entry) _findFirst);
  }
  
  /**
   * Retrieves the target from an entry.
   * TODO: validation of preconditions for entry targets e.g every region needs an entry with appropriate target
   */
  public State target(final Entry entry) {
    State _xifexpression = null;
    EList<Transition> _outgoingTransitions = entry==null?(EList<Transition>)null:entry.getOutgoingTransitions();
    boolean _notEquals = (!Objects.equal(_outgoingTransitions, null));
    if (_notEquals) {
      State _xifexpression_1 = null;
      EList<Transition> _outgoingTransitions_1 = entry.getOutgoingTransitions();
      int _size = _outgoingTransitions_1.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        State _xblockexpression = null;
        {
          EList<Transition> _outgoingTransitions_2 = entry.getOutgoingTransitions();
          Transition _get = _outgoingTransitions_2.get(0);
          final Vertex target = _get.getTarget();
          State _xifexpression_2 = null;
          if ((target instanceof State)) {
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
  
  public List<RegularState> collectLeafStates(final RegularState state, final List<RegularState> leafStates) {
    boolean _isLeaf = this.isLeaf(state);
    if (_isLeaf) {
      leafStates.add(state);
    } else {
      if ((state instanceof State)) {
        final State s = ((State) state);
        EList<Region> _regions = s.getRegions();
        for (final Region r : _regions) {
          EList<Vertex> _vertices = r.getVertices();
          for (final Vertex v : _vertices) {
            if ((v instanceof RegularState)) {
              this.collectLeafStates(((RegularState) v), leafStates);
            }
          }
        }
      }
    }
    return leafStates;
  }
  
  public List<RegularState> collectLeafStates(final Region region, final List<RegularState> leafStates) {
    EList<Vertex> _vertices = region.getVertices();
    for (final Vertex v : _vertices) {
      if ((v instanceof RegularState)) {
        this.collectLeafStates(((RegularState) v), leafStates);
      }
    }
    return leafStates;
  }
  
  public boolean requireDeepHistory(final Region r) {
    List<EObject> _containers = this.containers(r);
    Iterable<Region> _filter = Iterables.<Region>filter(_containers, Region.class);
    final Function1<Region,Boolean> _function = new Function1<Region,Boolean>() {
        public Boolean apply(final Region p) {
          EList<Vertex> _vertices = p.getVertices();
          Iterable<Entry> _filter = Iterables.<Entry>filter(_vertices, Entry.class);
          final Function1<Entry,Boolean> _function = new Function1<Entry,Boolean>() {
              public Boolean apply(final Entry v) {
                EntryKind _kind = v.getKind();
                boolean _equals = Objects.equal(_kind, EntryKind.DEEP_HISTORY);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<Entry>exists(_filter, _function);
          return Boolean.valueOf(_exists);
        }
      };
    boolean _exists = IterableExtensions.<Region>exists(_filter, _function);
    return _exists;
  }
  
  public boolean requireShallowHistory(final Region r) {
    EList<Vertex> _vertices = r.getVertices();
    Iterable<Entry> _filter = Iterables.<Entry>filter(_vertices, Entry.class);
    final Function1<Entry,Boolean> _function = new Function1<Entry,Boolean>() {
        public Boolean apply(final Entry v) {
          EntryKind _kind = v.getKind();
          boolean _equals = Objects.equal(_kind, EntryKind.SHALLOW_HISTORY);
          return Boolean.valueOf(_equals);
        }
      };
    boolean _exists = IterableExtensions.<Entry>exists(_filter, _function);
    return _exists;
  }
  
  public boolean requireHistory(final Region r) {
    boolean _or = false;
    boolean _requireDeepHistory = this.requireDeepHistory(r);
    if (_requireDeepHistory) {
      _or = true;
    } else {
      boolean _requireShallowHistory = this.requireShallowHistory(r);
      _or = (_requireDeepHistory || _requireShallowHistory);
    }
    return _or;
  }
  
  public boolean isLeaf(final RegularState s) {
    if (s instanceof FinalState) {
      return _isLeaf((FinalState)s);
    } else if (s instanceof State) {
      return _isLeaf((State)s);
    } else if (s != null) {
      return _isLeaf(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
}
