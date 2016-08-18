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
package org.yakindu.sct.test.models;

import java.util.List;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.sct.domain.generic.generator.GenericGeneratorModule;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TestModelInjectorProvider implements IInjectorProvider {

	private List<Module> module;

	public TestModelInjectorProvider(Module... module) {
		this.module = Lists.newArrayList(module);
	}
	public TestModelInjectorProvider() {
	}

	public Injector getInjector() {
		List<Module> modules = Lists.newArrayList();
		modules.add(new GenericGeneratorModule());
		if(this.module !=null && !this.module.isEmpty())
		modules.addAll(this.module);
		return Guice.createInjector(modules);
	}

}
