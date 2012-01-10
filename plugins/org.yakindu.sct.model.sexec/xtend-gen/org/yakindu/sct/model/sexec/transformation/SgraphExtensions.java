package org.yakindu.sct.model.sexec.transformation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.yakindu.sct.model.sgraph.Entry;
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
            for (Region r : _regions) {
              EList<Vertex> _vertices = r.getVertices();
              for (Vertex v : _vertices) {
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
      for (Vertex v : _vertices) {
        if ((v instanceof org.yakindu.sct.model.sgraph.RegularState)) {
          this.collectLeafStates(((RegularState) v), leafStates);
        }
      }
      return leafStates;
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
}