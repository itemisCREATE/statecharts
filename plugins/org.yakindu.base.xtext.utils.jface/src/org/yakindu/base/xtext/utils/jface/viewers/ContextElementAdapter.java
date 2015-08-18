/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.xtext.utils.jface.viewers;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * The {@link ContextElementAdapter} is added to the FakeResource to get access
 * to the context element for scoping/validation.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */

public class ContextElementAdapter extends AdapterImpl {

	public interface IContextElementProvider {
		public EObject getContextObject();
	}

	private final IContextElementProvider provider;

	public ContextElementAdapter(IContextElementProvider provider) {
		this.provider = provider;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ContextElementAdapter.class;
	}

	public EObject getElement() {
		return provider.getContextObject();
	}
}
