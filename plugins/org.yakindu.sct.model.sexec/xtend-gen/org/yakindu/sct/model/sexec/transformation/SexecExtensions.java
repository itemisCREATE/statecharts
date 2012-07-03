package org.yakindu.sct.model.sexec.transformation;

import java.util.ArrayList;
import java.util.Arrays;
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
    EnterState ess = null;
    boolean _notEquals = ObjectExtensions.operator_notEquals(s, null);
    if (_notEquals) {
      SexecFactory _factory = this.factory();
      EnterState _createEnterState = _factory.createEnterState();
      ess = _createEnterState;
      ess.setState(s);
    }
    return ess;
  }
  
  public ExitState newExitStateStep(final ExecutionState s) {
    ExitState ess = null;
    boolean _notEquals = ObjectExtensions.operator_notEquals(s, null);
    if (_notEquals) {
      SexecFactory _factory = this.factory();
      ExitState _createExitState = _factory.createExitState();
      ess = _createExitState;
      ess.setState(s);
    }
    return ess;
  }
  
  public StateCase newCase(final ExecutionState it, final Step step) {
    SexecFactory _factory = this.factory();
    final StateCase sCase = _factory.createStateCase();
    sCase.setState(it);
    sCase.setStep(step);
    return sCase;
  }
  
  public SaveHistory newSaveHistory(final ExecutionRegion r) {
    SexecFactory _factory = this.factory();
    final SaveHistory save = _factory.createSaveHistory();
    save.setRegion(r);
    return save;
  }
  
  protected List<ExecutionState> _collectLeafStates(final ExecutionState state, final List<ExecutionState> leafStates) {
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
  
  protected List<ExecutionState> _collectLeafStates(final ExecutionRegion region, final List<ExecutionState> leafStates) {
    EList<ExecutionScope> _subScopes = region.getSubScopes();
    for (final ExecutionScope r : _subScopes) {
      this.collectLeafStates(r, leafStates);
    }
    return leafStates;
  }
  
  public int last(final StateVector sv) {
    int _offset = sv.getOffset();
    int _size = sv.getSize();
    int _plus = IntegerExtensions.operator_plus(_offset, _size);
    int _minus = IntegerExtensions.operator_minus(_plus, 1);
    return _minus;
  }
  
  public int first(final StateVector sv) {
    int _offset = sv.getOffset();
    return _offset;
  }
  
  public ArrayList<ExecutionScope> parentScopes(final ExecutionScope scope) {
    final ArrayList<ExecutionScope> parents = CollectionLiterals.<ExecutionScope>newArrayList();
    ExecutionScope s = scope;
    boolean _notEquals = ObjectExtensions.operator_notEquals(s, null);
    boolean _while = _notEquals;
    while (_while) {
      {
        parents.add(s);
        ExecutionScope _superScope = s.getSuperScope();
        s = _superScope;
      }
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(s, null);
      _while = _notEquals_1;
    }
    return parents;
  }
  
  /**
   * Collect all scopes beneath this scope which does not contain subscopes and are instances of ExecutionState.
   */
  public List<ExecutionState> collectLeafScopes(final ExecutionScope scope, final List<ExecutionState> leafs) {
    EList<ExecutionScope> _subScopes = scope.getSubScopes();
    boolean _isEmpty = _subScopes.isEmpty();
    if (_isEmpty) {
      if ((scope instanceof ExecutionState)) {
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
  
  public List<ExecutionState> collectLeafStates(final ExecutionScope region, final List<ExecutionState> leafStates) {
    if (region instanceof ExecutionRegion) {
      return _collectLeafStates((ExecutionRegion)region, leafStates);
    } else if (region instanceof ExecutionState) {
      return _collectLeafStates((ExecutionState)region, leafStates);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(region, leafStates).toString());
    }
  }
}
