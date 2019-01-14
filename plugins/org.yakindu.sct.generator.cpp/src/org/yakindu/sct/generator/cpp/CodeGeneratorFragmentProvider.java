/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleWiring;
import org.yakindu.sct.generator.c.IGenArtifactConfigurations;
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution;
import org.yakindu.sct.generator.cpp.providers.ISourceFragment;
import org.yakindu.sct.model.sexec.ExecutionFlow;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 * @author rbeckmann
 */
public class CodeGeneratorFragmentProvider {
	@Inject
	Injector injector;

	@Inject
	@Named(CppCodeGeneratorModule.NAMED_PACKAGES)
	protected Set<String> packageNames;

	/**
	 * Returns a set of objects produced of classes annotated with
	 * <code>GeneratorContribution</code> and the given <code>target</code>.
	 */
	public Set<ISourceFragment> get(String target, ExecutionFlow flow, IGenArtifactConfigurations config) {
		Map<String, Map<Class<? extends ISourceFragment>, ISourceFragment>> contributionObjects = getContributionObjects();
		Map<Class<? extends ISourceFragment>, ISourceFragment> result = contributionObjects.get(target);
		replaceAndFilterObjects(result, flow, config);
		TreeSet<ISourceFragment> set = new TreeSet<>(
				Comparator.comparingInt(it -> ((ISourceFragment) it).orderPriority(flow, config))
				.thenComparing(Comparator.comparingInt(it -> it.hashCode())));
		set.addAll(result.values());
		return set;
	}

	/**
	 * Produces a list of all classes in the given package that are annotated
	 * with <code>GeneratorContribution</code>, grouped and mapped by their
	 * target.
	 */
	public Map<String, List<Class<?>>> getGeneratorContributions(String packageName) {
		Collection<String> packageClasses = getPackageClasses(packageName);
		ClassLoader classLoader = CodeGeneratorFragmentProvider.class.getClassLoader();
		try {
			Map<String, List<Class<?>>> annotatedClasses = packageClasses.stream()
					.map(name -> loadClass(classLoader, name)).filter(Objects::nonNull)
					.filter(c -> c.isAnnotationPresent(GeneratorContribution.class))
					.collect(Collectors.groupingBy(c -> getContributionTarget(c)));
			return annotatedClasses;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyMap();
		}
	}
	
	protected void replaceAndFilterObjects(
			Map<Class<? extends ISourceFragment>, ISourceFragment> objects,
			ExecutionFlow flow, IGenArtifactConfigurations config) {
		
		Map<Class<? extends ISourceFragment>, Pair> pairs = objects.entrySet().stream()
				.map(e -> new Pair(e.getKey(), e.getValue()))
				.collect(Collectors.toMap((p -> p.key), (p -> p)));

		for(Pair p : pairs.values()) {
			Class<? extends ISourceFragment> replaces = p.replaces(flow, config);
			if (pairs.containsKey(replaces)) {
				pairs.get(replaces).isReplaced = true;
			}
		}

		for (Pair p : pairs.values()) {
			if (p.isReplaced || !p.object.isNeeded(flow, config)) {
				objects.remove(p.key);
			}
		}
	}

	protected Map<String, Map<Class<? extends ISourceFragment>, ISourceFragment>> getContributionObjects() {
		Map<String, List<Class<?>>> classes = new HashMap<>();
		for (String packageName : packageNames) {
			classes.putAll(getGeneratorContributions(packageName));
		}
		Map<String, Map<Class<? extends ISourceFragment>, ISourceFragment>> result = new HashMap<>();
		for (Entry<String, List<Class<?>>> category : classes.entrySet()) {
			Map<Class<? extends ISourceFragment>, ISourceFragment> objects = new HashMap<>();
			for (Class<?> cls : category.getValue()) {
				Object o = injector.getInstance(cls);
				if (o instanceof ISourceFragment) {
					ISourceFragment iSourceFragment = (ISourceFragment) o;
					@SuppressWarnings("unchecked")
					Class<? extends ISourceFragment> isfCls = (Class<? extends ISourceFragment>) cls;
					objects.put(isfCls, iSourceFragment);
				}
			}
			result.put(category.getKey(), objects);
		}
		
		return result;
	}

	protected Class<?> loadClass(ClassLoader loader, String name) {
		try {
			return loader.loadClass(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected String getContributionTarget(Class<?> cls) {
		GeneratorContribution contribution = cls.getAnnotation(GeneratorContribution.class);
		return contribution.value();
	}

	protected Collection<String> getPackageClasses(String packageName) {
		String path = "/" + packageName.replace(".", "/");
		
		Bundle bundle = Platform.getBundle(packageName);
		BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);

		Collection<String> listResources = bundleWiring.listResources(path, "*.class",
				BundleWiring.LISTRESOURCES_RECURSE);
		List<String> classNames = listResources.stream().map(s -> s.replace(".class", "").replace("/", "."))
				.collect(Collectors.toList());
		return classNames;
	}
	
	public static class Pair {
		protected Class<? extends ISourceFragment> key;
		protected ISourceFragment object;
		protected boolean isReplaced = false;
		
		public Pair(Class<? extends ISourceFragment> key, ISourceFragment object) {
			this.key = key;
			this.object = object;
		}

		public Class<? extends ISourceFragment> replaces(ExecutionFlow flow,
				IGenArtifactConfigurations config) {
			if (object.isNeeded(flow, config)) {
				return object.replaces(flow, config);
			} else {
				return null;
			}
		}
	}
}
