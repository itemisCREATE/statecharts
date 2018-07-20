/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */
package org.yakindu.sct.domain.extension.impl;

import org.yakindu.sct.domain.extension.IModuleConfigurator;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * @author rbeckmann
 *
 */
public class LazyCombiningModule implements Module {
	protected Iterable<Module> modules;

	public LazyCombiningModule(Iterable<Module> modules) {
		this.modules = modules;
	}

	public void applyConfigurator(IModuleConfigurator configurator) {
		for (Module module : modules) {
			configurator.configureModule(module);
		}
	}

	@Override
	public void configure(Binder binder) {
		Modules.combine(modules).configure(binder);
	}

}
