package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;

@SuppressWarnings("all")
public class StateVectorBuilder {
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private StatechartExtensions sc;
  
  public void defineStateVector(final ExecutionFlow flow, final Statechart sc) {
    {
      int offset = 0;
      EList<Region> _regions = sc.getRegions();
      for (Region r : _regions) {
        int _defineStateVectors = this.defineStateVectors(r, offset);
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)_defineStateVectors));
        offset = _operator_plus;
      }
      SexecFactory _factory = this.sexec.factory();
      StateVector _createStateVector = _factory.createStateVector();
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
          int _maxOrthogonality = StateVectorBuilder.this.sc.maxOrthogonality(r);
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
              int _defineStateVectors = StateVectorBuilder.this.defineStateVectors(v, ((Integer)offset));
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
      ExecutionRegion _create = this.mapping.create(r);
      final ExecutionRegion er = _create;
      SexecFactory _factory = this.sexec.factory();
      StateVector _createStateVector = _factory.createStateVector();
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
        for (Region r : _regions_1) {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)maxOrthogonality));
          int _defineStateVectors = this.defineStateVectors(r, _operator_plus);
          int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)maxOrthogonality), ((Integer)_defineStateVectors));
          maxOrthogonality = _operator_plus_1;
        }
      } else {
        maxOrthogonality = 1;
      }
      ExecutionState _create = this.mapping.create(s);
      final ExecutionState es = _create;
      SexecFactory _factory = this.sexec.factory();
      StateVector _createStateVector = _factory.createStateVector();
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
      ExecutionState _create = this.mapping.create(s);
      final ExecutionState es = _create;
      SexecFactory _factory = this.sexec.factory();
      StateVector _createStateVector = _factory.createStateVector();
      es.setStateVector(_createStateVector);
      StateVector _stateVector = es.getStateVector();
      _stateVector.setOffset(offset);
      StateVector _stateVector_1 = es.getStateVector();
      _stateVector_1.setSize(1);
      return 1;
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
}