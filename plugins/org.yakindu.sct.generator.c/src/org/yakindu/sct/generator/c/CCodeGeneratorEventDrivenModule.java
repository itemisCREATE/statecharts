/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c;

import org.yakindu.sct.generator.c.submodules.APIGenerator;
import org.yakindu.sct.generator.c.submodules.EventCode;
import org.yakindu.sct.generator.c.submodules.StatechartTypes;
import org.yakindu.sct.generator.c.submodules.eventdriven.EventDrivenAPIGenerator;
import org.yakindu.sct.generator.c.submodules.eventdriven.EventDrivenEventCode;
import org.yakindu.sct.generator.c.submodules.eventdriven.EventDrivenStatechartTypes;
import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;

public class CCodeGeneratorEventDrivenModule implements IGeneratorModule {
	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		binder.bind(APIGenerator.class).to(EventDrivenAPIGenerator.class);
		binder.bind(EventCode.class).to(EventDrivenEventCode.class);
		binder.bind(StatechartTypes.class).to(EventDrivenStatechartTypes.class);
	}

}
