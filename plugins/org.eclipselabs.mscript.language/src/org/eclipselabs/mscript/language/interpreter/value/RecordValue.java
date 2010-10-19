/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.interpreter.value;

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Record;

/**
 * @author Andreas Unger
 *
 */
public class RecordValue extends AbstractExplicitDataTypeValue {

	private List<Slot> slots = new ArrayList<Slot>();
	
	/**
	 * @param dataType
	 */
	public RecordValue(Record record) {
		super(record);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		return this;
	}
	
	public void addSlot(Slot slot) {
		this.slots.add(slot);
	}

	/**
	 * @return the slots
	 */
	public List<Slot> getSlots() {
		return slots;
	}
	
	public Slot getSlot(String name) {
		for (Slot slot : slots) {
			if (name.equals(slot.name)) {
				return slot;
			}
		}
		return null;
	}

	public void setSlotValue(String name, IValue value) {
		Slot field = getSlot(name);
		if (field != null) {
			field.setValue(value);
		}
	}
	
	public IValue getSlotValue(String name) {
		Slot slot = getSlot(name);
		return slot != null ? slot.getValue() : null;
	}
	
	public static class Slot {
		
		private String name;
		private IValue value;
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the value
		 */
		public IValue getValue() {
			return value;
		}
		
		/**
		 * @param value the value to set
		 */
		public void setValue(IValue value) {
			this.value = value;
		}
		
	}

}
