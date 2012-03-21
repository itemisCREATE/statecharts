/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.runtime.impl;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;

/**
 * Abstract implementation of {@link IExecutionContext}. Adds some convenience
 * for handling the {@link IExecutionContextListener}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExecutionContext implements IExecutionContext {

	private List<IExecutionContextListener> _listeners;

	public AbstractExecutionContext() {
		_listeners = new ArrayList<IExecutionContextListener>();
	}
	
	public void addExecutionContextListener(IExecutionContextListener listener) {
		synchronized (_listeners) {
			_listeners.add(listener);
		}
	}

	public void removeExecutionContextListener(
			IExecutionContextListener listener) {
		synchronized (_listeners) {
			_listeners.remove(listener);
		}
	}

	public void notifyEventRaised(ExecutionEvent event) {
		synchronized (_listeners) {
			for (IExecutionContextListener listener : _listeners) {
				listener.eventRaised(event);
			}
		}
	}

	public void notifyVariableValueChanged(ExecutionVariable variable) {
		synchronized (_listeners) {
			for (IExecutionContextListener listener : _listeners) {
				listener.variableValueChanged(variable);
			}
		}
	}
	
	public void notifyTimeScaleFactorChanged(double oldFactor, double newFactor) {
		synchronized (_listeners) {
			for (IExecutionContextListener listener : _listeners) {
				listener.timeScaleFactorChanged(oldFactor, newFactor);
			}
		}
	}

	public ExecutionEvent getDeclaredEvent(String eventName) {
		return null;
	}

}
