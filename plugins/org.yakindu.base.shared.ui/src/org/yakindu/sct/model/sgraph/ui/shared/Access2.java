/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.ui.shared;

import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.containers.StrictJavaProjectsState;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.ui.shared.internal.Activator;

import com.google.inject.Binding;
import com.google.inject.ConfigurationException;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.name.Names;

/**
 * This class is a hook for products without jdt to remove the dependency and
 * replace the container state binding in the overriding guice module with named
 * binding of IAllContainerState.
 * 
 * Example: public void configureJavaProjectsState(Binder binder) {
 * binder.bind(IAllContainersState.class)
 * .annotatedWith(Names.named(Access2.JAVA_PROJECTS_STATE))
 * .to(WorkspaceProjectsState.class); }
 * 
 * @author Benjamin Schwertfeger - Initial contribution and API
 * 
 */
public class Access2 extends Access {
	public static final String JAVA_PROJECTS_STATE = "JavaProjectsState";
	public static final String STRICT_JAVA_PROJECTS_STATE = "StrictJavaProjectsState";

	static class InternalProvider2<T> implements Provider<T> {

		private Class<? extends T> clazz;
		private String name;
		private Class<? extends T> fallbackClazz;

		public InternalProvider2(Class<? extends T> clazz, String name,
				Class<? extends T> fallbackClazz) {
			super();
			this.clazz = clazz;
			this.name = name;
			this.fallbackClazz = fallbackClazz;
		}

		public T get() {
			if (Activator.getDefault() == null) {
				throw new IllegalStateException(
						"The bundle has not been started!");
			}
			Injector injector = org.eclipse.xtext.ui.shared.internal.Activator
					.getDefault().getInjector();
			Key<? extends T> key = null;
			if (name != null) {
				key = Key.get(clazz, Names.named(name));
			} else {
				key = Key.get(clazz);
			}
			try {
				Binding<? extends T> binding = injector.getBinding(key);
				T instance = injector.getInstance(key);
				return instance;
			} catch (ConfigurationException e) {
				System.out.println("Binding not found");
			}
			return org.eclipse.xtext.ui.shared.internal.Activator.getDefault()
					.getInjector().getInstance(fallbackClazz);
		}
	}

	public static <T> Provider<T> provider(Class<? extends T> clazz,
			String name, Class<? extends T> fallbackClazz) {
		return new InternalProvider2<T>(clazz, name, fallbackClazz);
	}

	public static Provider<IAllContainersState> getJavaProjectsState() {
		return Access2.<IAllContainersState> provider(
				IAllContainersState.class, JAVA_PROJECTS_STATE,
				JavaProjectsState.class);
	}

	public static Provider<IAllContainersState> getStrictJavaProjectsState() {
		return Access2.<IAllContainersState> provider(
				IAllContainersState.class, STRICT_JAVA_PROJECTS_STATE,
				StrictJavaProjectsState.class);
	}
}
