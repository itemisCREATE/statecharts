/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.runner;

import org.yakindu.sct.generator.core.GeneratorModule;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class RunnerModule implements GeneratorModule {

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		// bindings may be specified in the runtime workspace...
	}

}
