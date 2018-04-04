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
package org.yakindu.sct.generator.core.execution;

import org.yakindu.sct.domain.extension.IModuleConfigurator;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Module;

/**
 * @author rbeckmann
 *
 */
public class GeneratorEntryModuleConfigurator implements IModuleConfigurator {
	protected GeneratorEntry entry;

	public GeneratorEntryModuleConfigurator(GeneratorEntry entry) {
		this.entry = entry;
	}

	@Override
	public void configureModule(Module module) {
		if (module instanceof IGeneratorEntryModuleExtension) {
			((IGeneratorEntryModuleExtension) module).setGeneratorEntry(entry);
		}
	}

}
