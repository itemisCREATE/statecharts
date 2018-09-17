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
package org.yakindu.sct.model.sexec.interpreter.test.util;

import org.yakindu.sct.domain.generic.simulation.GenericSimulationModule;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationInjectorProvider extends STextInjectorProvider {

	@Override
	protected Module getModule() {
		return Modules.override(super.getModule()).with(new GenericSimulationModule());
	}

}
