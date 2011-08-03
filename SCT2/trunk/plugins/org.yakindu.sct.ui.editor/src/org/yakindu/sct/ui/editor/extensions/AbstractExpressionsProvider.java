/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.extensions;

import org.eclipse.emf.ecore.EClass;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExpressionsProvider implements
		IExpressionsProvider {

	private Injector injector = null;

	protected abstract Injector createInjector();

	protected abstract EClass getType();

	protected abstract String getResourceExtension();

	public Injector getInjector() {
		if (injector == null)
			injector = createInjector();
		return injector;
	}

	public boolean isProviderFor(EClass type, String resourceUri) {
		return type.equals(getType())
				&& resourceUri.toLowerCase().endsWith(getResourceExtension());
	}

}
