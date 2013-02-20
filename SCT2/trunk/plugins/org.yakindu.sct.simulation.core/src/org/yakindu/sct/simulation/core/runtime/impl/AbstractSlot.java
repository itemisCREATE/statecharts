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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.ITypeSystem.InferredType;
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
	protected InferredType type;
	protected Object value;

	public AbstractSlot(String name, InferredType type, Object value) {
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

	public InferredType getType() {
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
		if(getType().getType() instanceof EnumerationType){
			Assert.isTrue(value instanceof Enumerator);
			boolean validLiteral = false;
			for(Enumerator e : ((EnumerationType)getType().getType()).getEnumerator()){
				if(EcoreUtil.equals(e, (Enumerator)value)){
					validLiteral = true;
					break;
				}
			}
			if(!validLiteral){
				throw new ExecutionException("Enumerator " + ((Enumerator)value).getName() + " is not assignable to enumeration type "+  getType().getType().getName());
			}
		}
		// TODO check primitive value types -> need type system to decide
		
		// TODO refactor (use type system)
		// Class<? extends Object> clazz = value instanceof EObject ?
		// ((EObject)value).eClass().getInstanceClass() : value.getClass();
		// if (type == Float.class && value != null &&
		// !clazz.isAssignableFrom(type)) {
		// try {
		// value = Float.parseFloat(value.toString());
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// }
		// }
		//
		// if (!clazz.isAssignableFrom(type)) {
		// throw new ExecutionException("Error assigning value to \' " + name
		// + "\' Can not assign value " + value + " of type"
		// + clazz + " to type " + type);
		// }
	}

	public void setContext(ISlotContext ctx) {
		context = ctx;
	}

	public ISlotContext getContext() {
		return context;
	}

	protected void notifyValueChanged() {
		if (context != null) {
			context.slotChanged(this, SLOT_VALUE_CHANGED);
		}
	}

}