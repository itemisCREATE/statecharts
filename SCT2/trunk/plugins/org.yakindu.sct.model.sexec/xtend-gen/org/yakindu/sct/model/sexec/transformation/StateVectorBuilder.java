package org.yakindu.sct.model.sexec.transformation;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
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
  
  @Inject
  private SgraphExtensions sgraph;
  
  public void defineHistoryVector(final ExecutionFlow flow, final Statechart sc) {
    int offset = (-1);
    TreeIterator<EObject> _eAllContents = sc.eAllContents();
    Iterator<Region> _filter = Iterators.<Region>filter(_eAllContents, Region.class);
    Iterable<Region> _iterable = IteratorExtensions.<Region>toIterable(_filter);
    for (final Region r : _iterable) {
      boolean _requireHistory = this.sgraph.requireHistory(r);
      if (_requireHistory) {
        int _plus = (offset + 1);
        offset = _plus;
        final ExecutionRegion er = this.mapping.create(r);
        SexecFactory _factory = this.sexec.factory();
        StateVector _createStateVector = _factory.createStateVector();
        er.setHistoryVector(_createStateVector);
        StateVector _historyVector = er.getHistoryVector();
        _historyVector.setOffset(offset);
        StateVector _historyVector_1 = er.getHistoryVector();
        _historyVector_1.setSize(1);
      }
    }
    int _minus = (-1);
    boolean _notEquals = (offset != _minus);
    if (_notEquals) {
      SexecFactory _factory_1 = this.sexec.factory();
      StateVector _createStateVector_1 = _factory_1.createStateVector();
      flow.setHistoryVector(_createStateVector_1);
      StateVector _historyVector_2 = flow.getHistoryVector();
      _historyVector_2.setOffset(0);
      StateVector _historyVector_3 = flow.getHistoryVector();
      int _plus_1 = (offset + 1);
      _historyVector_3.setSize(_plus_1);
    }
  }
  
  public void defineStateVector(final ExecutionFlow flow, final Statechart sc) {
    int offset = 0;
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      int _defineStateVectors = this.defineStateVectors(r, offset);
      int _plus = (offset + _defineStateVectors);
      offset = _plus;
    }
    SexecFactory _factory = this.sexec.factory();
    StateVector _createStateVector = _factory.createStateVector();
    flow.setStateVector(_createStateVector);
    StateVector _stateVector = flow.getStateVector();
    _stateVector.setOffset(0);
    StateVector _stateVector_1 = flow.getStateVector();
    _stateVector_1.setSize(offset);
  }
  
  /**
   * calculates the maximum orthogonality (maximum number of possible active leaf states) of the statechart
   */
  public int defineStateVectors(final Statechart sc, final int offset) {
    EList<Region> _regions = sc.getRegions();
    final Function2<Integer,Region,Integer> _function = new Function2<Integer,Region,Integer>() {
        public Integer apply(final Integer o, final Region r) {
          int _maxOrthogonality = StateVectorBuilder.this.sc.maxOrthogonality(r);
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
  public int defineStateVectors(final Region r, final int offset) {
    EList<Vertex> _vertices = r.getVertices();
    final Function2<Integer,Vertex,Integer> _function = new Function2<Integer,Vertex,Integer>() {
        public Integer apply(final Integer s, final Vertex v) {
          int _xblockexpression = (int) 0;
          {
            final int mo = StateVectorBuilder.this.defineStateVectors(v, offset);
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
    final Integer maxOrthogonality = IterableExtensions.<Vertex, Integer>fold(_vertices, Integer.valueOf(0), _function);
    final ExecutionRegion er = this.mapping.create(r);
    SexecFactory _factory = this.sexec.factory();
    StateVector _createStateVector = _factory.createStateVector();
    er.setStateVector(_createStateVector);
    StateVector _stateVector = er.getStateVector();
    _stateVector.setOffset(offset);
    StateVector _stateVector_1 = er.getStateVector();
    _stateVector_1.setSize((maxOrthogonality).intValue());
    return (maxOrthogonality).intValue();
  }
  
  /**
   * the maximum orthogonality of all  pseudo states is 0
   */
  protected int _defineStateVectors(final Vertex v, final int offset) {
    return 0;
  }
  
  /**
   * calculates the maximum orthogonality (maximum number of possible active leaf states) of a state
   */
  protected int _defineStateVectors(final State s, final int offset) {
    int maxOrthogonality = 0;
    EList<Region> _regions = s.getRegions();
    boolean _containsStates = this.containsStates(_regions);
    if (_containsStates) {
      EList<Region> _regions_1 = s.getRegions();
      for (final Region r : _regions_1) {
        int _plus = (offset + maxOrthogonality);
        int _defineStateVectors = this.defineStateVectors(r, _plus);
        int _plus_1 = (maxOrthogonality + _defineStateVectors);
        maxOrthogonality = _plus_1;
      }
    } else {
      maxOrthogonality = 1;
    }
    final ExecutionState es = this.mapping.create(s);
    SexecFactory _factory = this.sexec.factory();
    StateVector _createStateVector = _factory.createStateVector();
    es.setStateVector(_createStateVector);
    StateVector _stateVector = es.getStateVector();
    _stateVector.setOffset(offset);
    StateVector _stateVector_1 = es.getStateVector();
    _stateVector_1.setSize(maxOrthogonality);
    return maxOrthogonality;
  }
  
  public boolean containsStates(final List<Region> regions) {
    final Function1<Region,Boolean> _function = new Function1<Region,Boolean>() {
        public Boolean apply(final Region r) {
          EList<Vertex> _vertices = r.getVertices();
          Iterable<RegularState> _filter = Iterables.<RegularState>filter(_vertices, RegularState.class);
          int _size = IterableExtensions.size(_filter);
          boolean _greaterThan = (_size > 0);
          return Boolean.valueOf(_greaterThan);
        }
      };
    Iterable<Region> _filter = IterableExtensions.<Region>filter(regions, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  /**
   * calculates the maximum orthogonality (maximum number of possible active leaf states) of a state
   */
  protected int _defineStateVectors(final FinalState s, final int offset) {
    final ExecutionState es = this.mapping.create(s);
    SexecFactory _factory = this.sexec.factory();
    StateVector _createStateVector = _factory.createStateVector();
    es.setStateVector(_createStateVector);
    StateVector _stateVector = es.getStateVector();
    _stateVector.setOffset(offset);
    StateVector _stateVector_1 = es.getStateVector();
    _stateVector_1.setSize(1);
    return 1;
  }
  
  protected StateVector _stateVector(final Vertex v) {
    return null;
  }
  
  protected StateVector _stateVector(final RegularState s) {
    ExecutionState _create = this.mapping.create(s);
    StateVector _stateVector = _create.getStateVector();
    return _stateVector;
  }
  
  protected StateVector _stateVector(final Choice choice) {
    Region _parentRegion = choice.getParentRegion();
    ExecutionRegion _create = this.mapping.create(_parentRegion);
    StateVector _stateVector = _create.getStateVector();
    return _stateVector;
  }
  
  public int defineStateVectors(final Vertex s, final int offset) {
    if (s instanceof FinalState) {
      return _defineStateVectors((FinalState)s, offset);
    } else if (s instanceof State) {
      return _defineStateVectors((State)s, offset);
    } else if (s != null) {
      return _defineStateVectors(s, offset);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, offset).toString());
    }
  }
  
  public StateVector stateVector(final Vertex choice) {
    if (choice instanceof Choice) {
      return _stateVector((Choice)choice);
    } else if (choice instanceof RegularState) {
      return _stateVector((RegularState)choice);
    } else if (choice != null) {
      return _stateVector(choice);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(choice).toString());
    }
  }
}
