/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.test.util;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.simulation.core.sexec.SimulationModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SExecInjectionProvider implements IInjectorProvider {

	public Injector getInjector() {
		return Guice.createInjector(Modules.override(new SequencerModule()).with(new SimulationModule()));
	}

}
