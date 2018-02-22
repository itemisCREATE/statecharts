/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.simulation.core.sexec.container;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * Used to store an initial value on a property.
 * 
 * @author Thomas Kutz - Initial contribution and API
 *
 */
public class PropertyInitialValueAdapter extends AdapterImpl {

	private final Object initialValue;

	public PropertyInitialValueAdapter(Object initialValue) {
		this.initialValue = initialValue;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == PropertyInitialValueAdapter.class;
	}

	public Object getInitialValue() {
		return initialValue;
	}

	public static class LazyInitialValue {

		private String expression;

		protected LazyInitialValue(String expression) {
			this.expression = expression;
		}

		public String getExpression() {
			return expression;
		}

		public static LazyInitialValue of(String expression) {
			return new LazyInitialValue(expression);
		}
	}
}
