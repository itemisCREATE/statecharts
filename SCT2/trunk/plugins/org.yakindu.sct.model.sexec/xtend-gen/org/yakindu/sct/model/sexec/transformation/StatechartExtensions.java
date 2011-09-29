package org.yakindu.sct.model.sexec.transformation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Vertex;

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
    EList<Region> _subRegions = s.getSubRegions();
    int _size = _subRegions.size();
    boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
    if (_operator_greaterThan) {
      EList<Region> _subRegions_1 = s.getSubRegions();
      final Function2<Integer,Region,Integer> _function = new Function2<Integer,Region,Integer>() {
          public Integer apply(final Integer o , final Region r) {
            int _maxOrthogonality = StatechartExtensions.this.maxOrthogonality(r);
            int _operator_plus = IntegerExtensions.operator_plus(((Integer)_maxOrthogonality), o);
            return ((Integer)_operator_plus);
          }
        };
      Integer _fold = IterableExtensions.<Region, Integer>fold(_subRegions_1, ((Integer)0), _function);
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
  
  public String id(final Object t) {
    if ((t instanceof Transition)) {
      return _id((Transition)t);
    } else if ((t instanceof Object)) {
      return _id((Object)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(t).toString());
    }
  }
}