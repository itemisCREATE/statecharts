/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.types.generator.statechart.core;

import java.util.List;

import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.types.generator.artifacts.IGeneratorArtifactConfigurator;
import org.yakindu.sct.types.generator.statechart.core.naming.IEventNaming;
import org.yakindu.sct.types.generator.statechart.core.naming.IPropertyAccessNaming;
import org.yakindu.sct.types.modification.IModification;
import org.yakindu.sct.types.modification.ModificationExecutor;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

public abstract class SCTGeneratorModule {
	public void configure(Binder binder) {
		configureSlangClasses(binder);
		bindModifications(binder);
	}

	private void configureSlangClasses(Binder binder) {
		binder.bind(IGeneratorArtifactConfigurator.class).to(bindOutputConfigurator());
	}

	private void bindModifications(Binder binder) {
		Multibinder<IModification> modificationBinder = Multibinder.newSetBinder(binder, IModification.class);
		getModifications().forEach(modification -> modificationBinder.addBinding().to(modification));
	}

	/**
	 * Returns the list of modifications that shall be applied on the model to
	 * be generated, in the order in which they shall be applied.
	 * 
	 * See {@link IModification}
	 * 
	 * @param entry
	 *            GeneratorEntry can be used to derive information from to set
	 *            up the modification chain
	 * @return List of classes that extend IModification. A Guice
	 *         {@link com.google.inject.multibindings.Multibinder} will receive
	 *         this list of classes and create instances of it when injection is
	 *         requested (used in {@link ModificationExecutor}).
	 */
	public abstract List<Class<? extends IModification>> getModifications();

	public abstract Class<? extends IEventNaming> bindEventNaming();

	public abstract Class<? extends IPropertyAccessNaming> bindPropertyAccessNaming();

	public abstract Class<? extends IGeneratorArtifactConfigurator> bindOutputConfigurator();

	public abstract Class<? extends INamingService> bindNamingService();
}
