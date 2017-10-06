/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.util;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.ITypeValueProvider;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sruntime.EventDirection;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.sruntime.ExecutionEvent;

@SuppressWarnings("all")
public class ExecutionContextExtensions {
  @Inject
  @Extension
  private ITypeValueProvider _iTypeValueProvider;
  
  public void clearLocalAndInEvents(final ExecutionContext executionContext) {
    final Function1<ExecutionEvent, Boolean> _function = (ExecutionEvent it) -> {
      return Boolean.valueOf((Objects.equal(it.getDirection(), EventDirection.IN) || Objects.equal(it.getDirection(), EventDirection.LOCAL)));
    };
    final Consumer<ExecutionEvent> _function_1 = (ExecutionEvent it) -> {
      boolean _isRaised = it.isRaised();
      if (_isRaised) {
        it.setRaised(false);
        Object _xifexpression = null;
        Type _type = it.getType();
        boolean _tripleNotEquals = (_type != null);
        if (_tripleNotEquals) {
          _xifexpression = this._iTypeValueProvider.defaultValue(it.getType());
        } else {
          _xifexpression = null;
        }
        it.setValue(_xifexpression);
      }
    };
    IterableExtensions.<ExecutionEvent>filter(executionContext.getAllEvents(), _function).forEach(_function_1);
  }
  
  public void clearOutEvents(final ExecutionContext executionContext) {
    final Function1<ExecutionEvent, Boolean> _function = (ExecutionEvent it) -> {
      EventDirection _direction = it.getDirection();
      return Boolean.valueOf(Objects.equal(_direction, EventDirection.OUT));
    };
    final Consumer<ExecutionEvent> _function_1 = (ExecutionEvent it) -> {
      boolean _isRaised = it.isRaised();
      if (_isRaised) {
        it.setRaised(false);
      }
    };
    IterableExtensions.<ExecutionEvent>filter(executionContext.getAllEvents(), _function).forEach(_function_1);
  }
  
  public List<RegularState> getAllActiveStates(final ExecutionContext context) {
    final Function1<RegularState, ArrayList<RegularState>> _function = (RegularState it) -> {
      return this.getStateHierachy(it);
    };
    return IterableExtensions.<RegularState>toList(Iterables.<RegularState>concat(IterableExtensions.<RegularState, ArrayList<RegularState>>map(Iterables.<RegularState>filter(context.getActiveStates(), RegularState.class), _function)));
  }
  
  protected ArrayList<RegularState> getStateHierachy(final RegularState state) {
    ArrayList<RegularState> result = new ArrayList<RegularState>();
    result.add(state);
    EObject container = state.eContainer();
    while ((container != null)) {
      {
        if ((container instanceof RegularState)) {
          result.add(((RegularState)container));
        }
        container = container.eContainer();
      }
    }
    return result;
  }
}
