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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.DomainStatus;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.domain.extension.IDomainDocumentationProvider;
import org.yakindu.sct.domain.extension.IDomainStatusProvider;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author andreas muelder - Initial contribution and API
 *
 */
public class DomainImpl implements IDomain {

	private String domainID;
	private String name;
	private String description;
	private URL imagePath;
	private IDomainStatusProvider statusProvider;
	private IDomainDocumentationProvider documentationProvider;
	private Iterable<ModuleContribution> modules;
	private LoadingCache<CacheKey, Injector> injectorCache;

	protected static class CacheKey {
		private String feature;
		private String[] options;

		public CacheKey(String feature, String[] options) {
			this.feature = feature;
			this.options = options;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((feature == null) ? 0 : feature.hashCode());
			result = prime * result + Arrays.hashCode(options);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CacheKey other = (CacheKey) obj;
			if (feature == null) {
				if (other.feature != null)
					return false;
			} else if (!feature.equals(other.feature))
				return false;
			if (!Arrays.equals(options, other.options))
				return false;
			return true;
		}

		public String getFeature() {
			return feature;
		}

		public String[] getOptions() {
			return options;
		}

	}

	public DomainImpl(String domainID, String name, String description, URL imagePath,
			Iterable<ModuleContribution> modules) {
		this(domainID, name, description, imagePath, modules, new IDomainStatusProvider.DefaultDomainStatusProvider(),
				new IDomainDocumentationProvider.NullImpl());
	}

	public DomainImpl(String domainID, String name, String description, URL imagePath,
			Iterable<ModuleContribution> modules, IDomainStatusProvider provider,
			IDomainDocumentationProvider docuProvider) {
		this.domainID = domainID;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		this.modules = modules;
		this.statusProvider = provider;
		this.documentationProvider = docuProvider;
		initializeCache();
	}

	protected void initializeCache() {
		injectorCache = CacheBuilder.newBuilder().build(new CacheLoader<CacheKey, Injector>() {
			@Override
			public Injector load(CacheKey key) throws Exception {
				return createInjector(key.getFeature(), key.getOptions());
			}
		});
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
	public Injector getInjector(String feature, boolean useCache, String... options) {
		if (useCache) {
			try {
				return injectorCache.get(new CacheKey(feature, options));
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return createInjector(feature, options);
	}

	@Override
	public Injector getInjector(String feature, String... options) {
		return getInjector(feature, true, options);
	}

	public Injector createInjector(String feature, String... options) {
		return Guice.createInjector(getModule(feature, options));
	}

	@Override
	public Module getModule(String feature, String... options) {
		List<Module> modules = new ArrayList<>();
		for (ModuleContribution module : this.modules) {
			if (feature.equals(module.getFeature()) || "all".equals(module.getFeature())) {
				modules.add(module.getModuleProvider().getModule(options));
			}
		}

		if (modules.size() == 0) {
			// If no overriding modules are contributed for this feature use the defaults
			return DomainRegistry.getDomain(BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral())
					.getModule(feature, options);
		}

		Module result = new LazyCombiningModule(modules);
		return result;

	}

	@Override
	public DomainStatus getAvailabilityStatus() {
		return statusProvider.getDomainStatus();
	}

	@Override
	public IDomainDocumentationProvider getDocumentationProvider() {
		return documentationProvider;
	}

}
