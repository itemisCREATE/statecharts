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
package org.yakindu.sct.ui.integration.stext;

import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Base class for all {@link IExpressionLanguageProvider}s, provides caching of
 * the Injector.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExpressionsProvider implements
		IExpressionLanguageProvider {

	private Injector injector = null;

	protected abstract Module getRuntimeModule();

	protected abstract Module getUIModule();

	protected Injector createInjector() {
		return Guice.createInjector(Modules.override(
				Modules.override(getRuntimeModule()).with(getUIModule())).with(
				new SharedStateModule()));
	}

	public Injector getInjector() {
		if (injector == null)
			injector = createInjector();
		return injector;
	}
}
