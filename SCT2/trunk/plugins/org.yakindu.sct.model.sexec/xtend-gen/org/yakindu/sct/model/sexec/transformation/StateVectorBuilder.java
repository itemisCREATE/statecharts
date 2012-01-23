package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.EObjectExtensions;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
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
  
  public void defineStateVector(final ExecutionFlow flow, final Statechart sc) {
    {
      int offset = 0;
      EList<Region> _regions = sc.getRegions();
      for (final Region r : _regions) {
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
  
  public void defineHistoryStateVector(final ExecutionFlow flow, final Statechart sc) {
    Iterable<EObject> _allContentsIterable = EObjectExtensions.allContentsIterable(sc);
    Iterable<Region> _filter = IterableExtensions.<Region>filter(_allContentsIterable, org.yakindu.sct.model.sgraph.Region.class);
    for (final Region r : _filter) {
      {
        ExecutionRegion _create = this.mapping.create(r);
        final ExecutionRegion execRegion = _create;
        EList<Vertex> _vertices = r.getVertices();
        Iterable<Entry> _filter_1 = IterableExtensions.<Entry>filter(_vertices, org.yakindu.sct.model.sgraph.Entry.class);
        final Function1<Entry,Boolean> _function = new Function1<Entry,Boolean>() {
            public Boolean apply(final Entry v) {
              EntryKind _kind = v.getKind();
              boolean _operator_equals = ObjectExtensions.operator_equals(_kind, EntryKind.DEEP_HISTORY);
              return ((Boolean)_operator_equals);
            }
          };
        boolean _exists = IterableExtensions.<Entry>exists(_filter_1, _function);
        if (_exists) {
          {
            SexecFactory _factory = this.sexec.factory();
            StateVector _createStateVector = _factory.createStateVector();
            execRegion.setHistoryStateVector(_createStateVector);
            StateVector _historyStateVector = execRegion.getHistoryStateVector();
            StateVector _stateVector = execRegion.getStateVector();
            int _offset = _stateVector.getOffset();
            _historyStateVector.setOffset(_offset);
            StateVector _historyStateVector_1 = execRegion.getHistoryStateVector();
            StateVector _stateVector_1 = execRegion.getStateVector();
            int _size = _stateVector_1.getSize();
            _historyStateVector_1.setSize(_size);
          }
        } else {
          EList<Vertex> _vertices_1 = r.getVertices();
          Iterable<Entry> _filter_2 = IterableExtensions.<Entry>filter(_vertices_1, org.yakindu.sct.model.sgraph.Entry.class);
          final Function1<Entry,Boolean> _function_1 = new Function1<Entry,Boolean>() {
              public Boolean apply(final Entry v_1) {
                EntryKind _kind_1 = v_1.getKind();
                boolean _operator_equals_1 = ObjectExtensions.operator_equals(_kind_1, EntryKind.SHALLOW_HISTORY);
                return ((Boolean)_operator_equals_1);
              }
            };
          boolean _exists_1 = IterableExtensions.<Entry>exists(_filter_2, _function_1);
          if (_exists_1) {
            {
              SexecFactory _factory_1 = this.sexec.factory();
              StateVector _createStateVector_1 = _factory_1.createStateVector();
              execRegion.setHistoryStateVector(_createStateVector_1);
              StateVector _historyStateVector_2 = execRegion.getHistoryStateVector();
              StateVector _stateVector_2 = execRegion.getStateVector();
              int _offset_1 = _stateVector_2.getOffset();
              _historyStateVector_2.setOffset(_offset_1);
              StateVector _historyStateVector_3 = execRegion.getHistoryStateVector();
              _historyStateVector_3.setSize(1);
            }
          }
        }
      }
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
        for (final Region r : _regions_1) {
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
}