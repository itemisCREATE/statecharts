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
package org.yakindu.sct.simulation.core.runtime;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.model.sexec.Trace;

/**
 * Adds convenience for {@link IExecutionTraceListener} handling.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExecutionFacade implements IExecutionFacade {

	private List<IExecutionTraceListener> _listeners;

	private List<Object> _callbacks;

	public AbstractExecutionFacade() {
		_listeners = new ArrayList<IExecutionTraceListener>();
		_callbacks = new ArrayList<Object>();
	}

	public void addTraceListener(IExecutionTraceListener listener) {
		synchronized (_listeners) {
			if (!_listeners.contains(listener)) {
				_listeners.add(listener);
			}
		}
	}

	public void removeTraceListener(IExecutionTraceListener listener) {
		synchronized (_listeners) {
			_listeners.remove(listener);
		}
	}

	protected void notifyTraceStepEntered(Trace trace) {
		synchronized (_listeners) {
			for (IExecutionTraceListener listener : _listeners) {
				listener.traceStepExecuted(trace);
			}
		}
	}

	public void addCallbackObject(Object object) {
		synchronized (_callbacks) {
			_callbacks.add(object);
		}
	}

	public void removeCallbackObject(Object object) {
		synchronized (_callbacks) {
			_callbacks.remove(object);
		}
	}

	public List<Object> getCallbacks() {
		return _callbacks;
	}
	
	
}
