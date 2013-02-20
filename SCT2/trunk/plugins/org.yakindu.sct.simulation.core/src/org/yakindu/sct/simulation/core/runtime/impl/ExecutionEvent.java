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

import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.sct.simulation.core.runtime.IEventSlot;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;

/**
 * Read only access to ScopeEvents. Value can only be changed via
 * {@link IExecutionContext}#setVariableValue
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - refactoring
 * 
 * 
 */
public class ExecutionEvent extends AbstractSlot implements IEventSlot {

	protected boolean raised = false;

	public ExecutionEvent(String name) {
		this(name, null, null);
	}

	public ExecutionEvent(String name, InferredType type) {
		super(name, type, null);
	}

	public ExecutionEvent(String name, InferredType type, Object value) {
		super(name, type, value);
	}

	public ExecutionEvent getCopy() {
		return new ExecutionEvent(getName(), getType(), getValue());
	}

	public void raise(Object value) {
		if (!raised) {
			raised = true;
			if (value != null) {
				assertValue(value);
				this.value = value;
			}

			notifyRaised();
		}
	}

	public void unraise() {
		if (raised) {
			raised = false;
			notifyUnraised();
		}
	}

	public boolean isRaised() {
		return raised;
	}

	protected void notifyRaised() {
		if (context != null) {
			context.slotChanged(this, SLOT_EVENT_RAISED);
		}
	}

	protected void notifyUnraised() {
		if (context != null) {
			context.slotChanged(this, SLOT_EVENT_UNRAISED);
		}
	}

}