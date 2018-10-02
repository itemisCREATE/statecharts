/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c;

import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.generator.core.extensions.AnnotationExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;
/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class CCodeGeneratorModule implements IGeneratorModule {

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		binder.install(getModule(entry));
	}

	protected Module getModule(GeneratorEntry entry) {
		Module module = moduleAdapter(new CCodeGeneratorStandardModule(), entry);
		if (isEventDriven(entry)) {
			module = Modules.override(module).with(moduleAdapter(new CCodeGeneratorEventDrivenModule(), entry));
		}
		return module;
	}

	protected boolean isEventDriven(GeneratorEntry entry) {
		return (new AnnotationExtensions()).isEventDriven(entry);
	}

	protected Module moduleAdapter(IGeneratorModule module, GeneratorEntry entry) {
		return new GeneratorExtensions.GeneratorModuleAdapter(module, entry);
	}
}
