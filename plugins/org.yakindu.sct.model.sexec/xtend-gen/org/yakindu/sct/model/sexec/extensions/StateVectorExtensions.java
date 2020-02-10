/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.extensions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sgraph.FinalState;

/**
 * @author Axel Terfloth
 */
@SuppressWarnings("all")
public class StateVectorExtensions {
  /**
   * This function calculates the final state impact vector.
   * This vector is an array of the size of the state machines state vector.
   * Each array slot holds a List of ExecutionState instances that map to FinalState elements
   * in the orginal model. The assignment of a final state to a slot means that if this state is
   * active it has impact on the vector slot. Here two cases have to be distinguished:
   * 
   * 1. The final state is directly assigned to the slot (the states vector offset). If the state is active
   *    then the slot will contain a reference to this state
   * 2. If the parent region contains orthogonal states then all other vector positions covered by the region
   *    are empty (refer to no state) if the state is active so there is an indirect impact on the vector.
   */
  public List<ExecutionState>[] finalStateImpactVector(final ExecutionFlow flow) {
    final List<ExecutionState>[] vector = new List[flow.getStateVector().getSize()];
    final Function1<ExecutionState, Boolean> _function = (ExecutionState s) -> {
      EObject _sourceElement = s.getSourceElement();
      return Boolean.valueOf((_sourceElement instanceof FinalState));
    };
    final Consumer<ExecutionState> _function_1 = (ExecutionState fs) -> {
      StateVector regionVector = fs.getSuperScope().getStateVector();
      int _offset = regionVector.getOffset();
      int _offset_1 = regionVector.getOffset();
      int _size = regionVector.getSize();
      int _plus = (_offset_1 + _size);
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(_offset, _plus, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          List<ExecutionState> _get = vector[(i).intValue()];
          boolean _tripleEquals = (_get == null);
          if (_tripleEquals) {
            ArrayList<ExecutionState> _arrayList = new ArrayList<ExecutionState>();
            vector[(i).intValue()] = _arrayList;
          }
          vector[(i).intValue()].add(fs);
        }
      }
    };
    IterableExtensions.<ExecutionState>filter(flow.getStates(), _function).forEach(_function_1);
    return vector;
  }
  
  /**
   * Checks if all state vector positions are covered by states.
   */
  public boolean isCompletelyCovered(final List<ExecutionState>[] finalStateImpactVector) {
    final Function1<List<ExecutionState>, Boolean> _function = (List<ExecutionState> l) -> {
      return Boolean.valueOf(((l != null) && (!l.isEmpty())));
    };
    return IterableExtensions.<List<ExecutionState>>forall(((Iterable<List<ExecutionState>>)Conversions.doWrapArray(finalStateImpactVector)), _function);
  }
}
