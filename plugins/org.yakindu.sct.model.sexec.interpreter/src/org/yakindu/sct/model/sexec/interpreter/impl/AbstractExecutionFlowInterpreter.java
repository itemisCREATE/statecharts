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
package org.yakindu.sct.model.sexec.interpreter.impl;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeListener;

/**
 * Adds convenience for {@link IExecutionFacadeListener} handling.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExecutionFlowInterpreter implements
		IExecutionFlowInterpreter {

	private List<IExecutionFacadeListener> _listeners;

	public AbstractExecutionFlowInterpreter() {
		_listeners = new ArrayList<IExecutionFacadeListener>();
	}

	public void addExecutionListener(IExecutionFacadeListener listener) {
		synchronized (_listeners) {
			_listeners.add(listener);
		}
	}

	public void removeExecutionListener(IExecutionFacadeListener listener) {
		synchronized (_listeners) {
			_listeners.remove(listener);
		}
	}

	protected void notifyStateEntered(ExecutionState executionState) {
		synchronized (_listeners) {
			for (IExecutionFacadeListener listener : _listeners) {
				listener.stateEntered((Vertex) executionState
						.getSourceElement());
			}
		}
	}

	protected void notifyStateExited(ExecutionState executionState) {
		synchronized (_listeners) {
			for (IExecutionFacadeListener listener : _listeners) {
				listener.stateLeft((Vertex) executionState.getSourceElement());
			}
		}
	}

	protected void notifyTransitionFired(ReactionFired reactionfired) {
		synchronized (_listeners) {
			for (IExecutionFacadeListener listener : _listeners) {
				listener.transitionFired((Transition) reactionfired
						.getReaction().getSourceElement());
			}
		}
	}

	protected void notifyEventRaised(Object object) {
		synchronized (_listeners) {
			for (IExecutionFacadeListener listener : _listeners) {
				listener.transitionFired((Transition) object);
			}
		}
	}
}
