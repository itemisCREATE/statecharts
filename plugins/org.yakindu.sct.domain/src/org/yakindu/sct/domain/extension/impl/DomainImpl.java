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
package org.yakindu.sct.domain.extension.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.domain.extension.IDomain;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainImpl implements IDomain {

	private String domainID;
	private String name;
	private String description;
	private URL imagePath;
	private Iterable<ModuleContribution> modules;

	public DomainImpl(String domainID, String name, String description, URL imagePath,
			Iterable<ModuleContribution> modules) {
		this.domainID = domainID;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		this.modules = modules;
	}

	@Override
	public String getDomainID() {
		return domainID;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public URL getImagePath() {
		return imagePath;
	}

	@Override
	public Injector getInjector(String feature, String... options) {
		return getInjector(feature, null, options);
	}

	@Override
	public Injector getInjector(String feature, Module overrides, String... options) {
		List<Module> modules = new ArrayList<>();
		for (ModuleContribution module : this.modules) {
			if (feature.equals(module.getFeature())) {
				modules.add(module.getModuleProvider().getModule(options));
			}
		}
		Module result = Modules.combine(modules);
		if (overrides != null)
			result = Modules.override(result).with(overrides);
		return Guice.createInjector(result);
	}

}
