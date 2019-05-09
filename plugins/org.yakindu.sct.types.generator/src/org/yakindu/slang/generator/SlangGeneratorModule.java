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
package org.yakindu.slang.generator;

import java.util.List;

import org.yakindu.slang.generator.artifacts.IGeneratorArtifactConfigurator;
import org.yakindu.slang.modification.IModification;
import org.yakindu.slang.modification.ModificationExecutor;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

public abstract class SlangGeneratorModule {
	public void configure(Binder binder) {
		configureSlangClasses(binder);
		bindModifications(binder);
	}

	private void configureSlangClasses(Binder binder) {
		binder.bind(ISlangGenerator.class).to(bindISlangGenerator());
		binder.bind(Expressions.class).to(bindExpressions());
		binder.bind(ITargetPlatform.class).to(bindTargetPlatform());
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

	public abstract Class<? extends ISlangGenerator> bindISlangGenerator();

	public abstract Class<? extends Expressions> bindExpressions();

	public abstract Class<? extends ITargetPlatform> bindTargetPlatform();

	public abstract Class<? extends IGeneratorArtifactConfigurator> bindOutputConfigurator();
}
