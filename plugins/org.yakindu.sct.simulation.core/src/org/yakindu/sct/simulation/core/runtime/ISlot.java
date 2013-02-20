/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.runtime;

import org.yakindu.base.types.ITypeSystem.InferredType;

/**
 * Defines the interface of a slot that holds a value within an execution
 * context.
 * 
 * The name and type of a slot can be accessed read only. The value can be read
 * and set.
 * 
 * @author axel terfloth
 * 
 */
public interface ISlot {

	public static class SlotValueChanged implements ISlotChangedEvent {
	}

	public static final SlotValueChanged SLOT_VALUE_CHANGED = new SlotValueChanged();

	void setContext(ISlotContext ctx);

	ISlotContext getContext();

	public String getName();

	public InferredType getType();

	public void setValue(Object value);

	public Object getValue();

}
