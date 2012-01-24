package org.yakindu.sct.model.sexec.transformation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;

@SuppressWarnings("all")
public class SexecExtensions {
  
  public SexecFactory factory() {
    return SexecFactory.eINSTANCE;
  }
  
  public EnterState newEnterStateStep(final ExecutionState s) {
    {
      EnterState ess = null;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(s, null);
      if (_operator_notEquals) {
        {
          SexecFactory _factory = this.factory();
          EnterState _createEnterState = _factory.createEnterState();
          ess = _createEnterState;
          ess.setState(s);
        }
      }
      return ess;
    }
  }
  
  public ExitState newExitStateStep(final ExecutionState s) {
    {
      ExitState ess = null;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(s, null);
      if (_operator_notEquals) {
        {
          SexecFactory _factory = this.factory();
          ExitState _createExitState = _factory.createExitState();
          ess = _createExitState;
          ess.setState(s);
        }
      }
      return ess;
    }
  }
  
  public StateCase newCase(final ExecutionState it, final Step step) {
    {
      SexecFactory _factory = this.factory();
      StateCase _createStateCase = _factory.createStateCase();
      final StateCase sCase = _createStateCase;
      sCase.setState(it);
      sCase.setStep(step);
      return sCase;
    }
  }
  
  public SaveHistory newSaveHistory(final ExecutionRegion r) {
    {
      SexecFactory _factory = this.factory();
      SaveHistory _createSaveHistory = _factory.createSaveHistory();
      final SaveHistory save = _createSaveHistory;
      save.setRegion(r);
      return save;
    }
  }
  
  protected List<ExecutionState> _collectLeafStates(final ExecutionState state, final List<ExecutionState> leafStates) {
    {
      boolean _isLeaf = state.isLeaf();
      if (_isLeaf) {
        CollectionExtensions.<ExecutionState>operator_add(leafStates, state);
      } else {
        EList<ExecutionScope> _subScopes = state.getSubScopes();
        for (final ExecutionScope r : _subScopes) {
          this.collectLeafStates(r, leafStates);
        }
      }
      return leafStates;
    }
  }
  
  protected List<ExecutionState> _collectLeafStates(final ExecutionRegion region, final List<ExecutionState> leafStates) {
    {
      EList<ExecutionScope> _subScopes = region.getSubScopes();
      for (final ExecutionScope r : _subScopes) {
        this.collectLeafStates(r, leafStates);
      }
      return leafStates;
    }
  }
  
  public int last(final StateVector sv) {
    int _offset = sv.getOffset();
    int _size = sv.getSize();
    int _operator_plus = IntegerExtensions.operator_plus(((Integer)_offset), ((Integer)_size));
    int _operator_minus = IntegerExtensions.operator_minus(((Integer)_operator_plus), ((Integer)1));
    return _operator_minus;
  }
  
  public int first(final StateVector sv) {
    int _offset = sv.getOffset();
    return _offset;
  }
  
  public ArrayList<ExecutionScope> parentScopes(final ExecutionScope scope) {
    {
      ArrayList<ExecutionScope> _newArrayList = CollectionLiterals.<ExecutionScope>newArrayList();
      final ArrayList<ExecutionScope> parents = _newArrayList;
      ExecutionScope s = scope;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(s, null);
      Boolean _xwhileexpression = _operator_notEquals;
      while (_xwhileexpression) {
        {
          parents.add(s);
          ExecutionScope _superScope = s.getSuperScope();
          s = _superScope;
        }
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(s, null);
        _xwhileexpression = _operator_notEquals_1;
      }
      return parents;
    }
  }
  
  public List<ExecutionState> collectLeafScopes(final ExecutionScope scope, final List<ExecutionState> leafs) {
    {
      EList<ExecutionScope> _subScopes = scope.getSubScopes();
      boolean _isEmpty = _subScopes.isEmpty();
      if (_isEmpty) {
        if ((scope instanceof org.yakindu.sct.model.sexec.ExecutionState)) {
          leafs.add(((ExecutionState) scope));
        }
      } else {
        EList<ExecutionScope> _subScopes_1 = scope.getSubScopes();
        for (final ExecutionScope s : _subScopes_1) {
          this.collectLeafScopes(s, leafs);
        }
      }
      return leafs;
    }
  }
  
  public List<ExecutionState> collectLeafStates(final ExecutionScope region, final List<ExecutionState> leafStates) {
    if ((region instanceof ExecutionRegion)
         && (leafStates instanceof List)) {
      return _collectLeafStates((ExecutionRegion)region, (List<ExecutionState>)leafStates);
    } else if ((region instanceof ExecutionState)
         && (leafStates instanceof List)) {
      return _collectLeafStates((ExecutionState)region, (List<ExecutionState>)leafStates);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(region, leafStates).toString());
    }
  }
}