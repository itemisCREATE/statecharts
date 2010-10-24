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

package org.eclipselabs.mscript.language.interpreter;

import java.util.ArrayList;

import org.eclipselabs.mscript.language.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class Variable implements IVariable {

	private String name;
	
	private RingBuffer<IValue> values = new RingBuffer<IValue>();
		
	/**
	 * 
	 */
	public Variable(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void ensureValueIndex(int step) {
		values.ensureLocationIndex(step);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#getValue()
	 */
	public IValue getValue(int step) {
		return values.get(step);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#setValue(org.eclipselabs.mscript.execution.value.IValue)
	 */
	public void setValue(int step, IValue value) {
		values.set(step, value);
	}
	
	public void incrementStep() {
		values.incrementLocation();
	}
	
	private static class RingBuffer<E> extends ArrayList<E> {
		
		private int locationIndex;
		private int beginIndex;
		private int endIndex;

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * 
		 */
		public RingBuffer() {
			add(null);
		}
		
		public E get(int index) {
			ensureLocationIndex(index);
			return super.get(computeActualIndex(index));
		}
		
		public E set(int index, E element) {
			ensureLocationIndex(index);
			return super.set(computeActualIndex(index), element);
		}

		public void ensureLocationIndex(int index) {
			if (index < 0) {
				if (index < this.beginIndex) {
					beginIndex = index;
					resize(endIndex - beginIndex + 1);
				}
			} else if (index > 0) {
				if (index > this.endIndex) {
					endIndex = index;
					resize(endIndex - beginIndex + 1);
				}
			}
		}
		
		public void resize(int newSize) {
			int diff = newSize - size();
			if (diff == 0) {
				return;
			}
			if (diff < 0) {
				removeRange(newSize, size());
			} else {
				for (; diff > 0; --diff) {
					add(null);
				}
			}
		}
		
		public void incrementLocation() {
			++locationIndex;
			if (locationIndex >= size()) {
				locationIndex = 0;
			}
		}
		
		private int computeActualIndex(int index) {
			index = this.locationIndex + index;
			if (index < 0) {
				index = size() + index;
			} else if (index >= size()) {
				index -= size();
			} 
			return index;
		}

	}

}
