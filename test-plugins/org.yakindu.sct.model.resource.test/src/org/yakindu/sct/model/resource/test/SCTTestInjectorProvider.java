/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.resource.test;

import static com.google.inject.Guice.createInjector;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.StextActivator;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
/**
 * @author Johannes Dicks - Initial contribution and API
 */
public class SCTTestInjectorProvider implements IInjectorProvider {


	public Injector getInjector() {


		Module with2 = Modules.override(new STextRuntimeModule()).with(new SharedStateModule());

		Module with3 = Modules.override(with2).with((Module) new STextUiModule(StextActivator.getInstance()));

		return createInjector(with3);
	}

}