package org.yakindu.sct.model.sexec.transformation;

import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
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
}