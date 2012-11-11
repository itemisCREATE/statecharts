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

import org.eclipse.core.runtime.Assert;
import org.yakindu.sct.simulation.core.runtime.ExecutionException;
import org.yakindu.sct.simulation.core.runtime.ISlot;
import org.yakindu.sct.simulation.core.runtime.ISlotContext;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - refactoring
 * 
 */
public abstract class AbstractSlot implements ISlot {

	protected ISlotContext context;
	protected String name;
	protected String scopeSegment;
	protected String simpleName;
	protected Class<?> type;
	protected Object value;

	public AbstractSlot(String name, Class<?> type, Object value) {
		super();
		Assert.isNotNull(name);
		this.name = name;
		String[] split = name.split("\\.");
		if (split.length == 2) {
			scopeSegment = split[0];
			simpleName = split[1];
		} else {
			simpleName = name;
		}
		this.type = type;
		if (value != null)
			setValue(value);
	}

	public String getScopeSegment() {
		return scopeSegment;
	}

	public String getSimpleName() {
		return simpleName;
	}

	
	public String getName() {
		return name;
	}

	public Class<?> getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		assertValue(value);
		this.value = value;
		
		notifyValueChanged();
	}

	protected void assertValue(Object value) {
		Assert.isNotNull(value, "Value must not be null ");
		//TODO refactor
		if (type == Float.class && value != null && !value.getClass().isAssignableFrom(type)) {
			try {
				value = Float.parseFloat(value.toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		if (!value.getClass().isAssignableFrom(type)) {
			throw new ExecutionException("Error assigning value to \' " + name
					+ "\' Can not assign value " + value + " of type"
					+ value.getClass() + " to type " + type);
		}
	}

	public void setContext(ISlotContext ctx) {
		context = ctx;
	}

	public ISlotContext getContext() {
		return context;
	}
	
	protected void notifyValueChanged() {
		if ( context != null ) {
			context.slotChanged(this, SLOT_VALUE_CHANGED);
		}
	}

}