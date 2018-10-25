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
package org.yakindu.sct.model.sexec.interpreter.test.util;

import org.yakindu.base.expressions.interpreter.IOperationMockup;
import org.yakindu.sct.domain.generic.simulation.GenericSimulationModule;
import org.yakindu.sct.simulation.core.sexec.interpreter.DefaultOperationMockup;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

/**
 * 
 * @author jonathan thoene - Initial contribution and API
 * 
 */
public class InterpreterTestModule extends GenericSimulationModule {

	@Override
	protected void bindOperationMockups(Binder binder) {
		Multibinder<IOperationMockup> mockupBinder = Multibinder.newSetBinder(binder, IOperationMockup.class);
		mockupBinder.addBinding().to(DefaultOperationMockup.class);
	}
}
