/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.test.util;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.sct.generator.genmodel.ui.SGenUiModule;
import org.yakindu.sct.generator.genmodel.ui.internal.SGenActivator;

import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenInjectorProvider implements IInjectorProvider {

	public Injector getInjector() {
		return createInjector(override(
				override(new SGenTestRuntimeModule()).with(
						getSharedStateModule())).with(
				new SGenUiModule(SGenActivator.getInstance())));
	}

	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}

}
