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
package org.yakindu.sct.types.generator.statechart;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.types.generator.Expressions;
import org.yakindu.sct.types.generator.ITargetPlatform;
import org.yakindu.sct.types.generator.ITypesGenerator;
import org.yakindu.sct.types.generator.artifacts.IGeneratorArtifactConfigurator;
import org.yakindu.sct.types.generator.module.TypesGeneratorModule;
import org.yakindu.sct.types.generator.naming.IEventNaming;
import org.yakindu.sct.types.generator.statechart.naming.IPropertyAccessNaming;
import org.yakindu.sct.types.modification.IModification;
import org.yakindu.sct.types.modification.ModificationExecutor;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

public abstract class SCTGeneratorModule implements IGeneratorModule {
	protected TypesGeneratorModule coreModule;

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		try {
			coreModule = getCoreGeneratorModule().getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		configureSlangClasses(binder);
		bindModifications(binder);
		binder.bind(GeneratorEntry.class).toInstance(entry);
	}

	private void configureSlangClasses(Binder binder) {
		binder.bind(ITypesGenerator.class).to(coreModule.bindITypesGenerator());
		binder.bind(Expressions.class).to(coreModule.bindExpressions());
		binder.bind(ITargetPlatform.class).to(coreModule.bindTargetPlatform());
		binder.bind(IEventNaming.class).to(coreModule.bindEventNaming());

		binder.bind(IGeneratorArtifactConfigurator.class).to(bindOutputConfigurator());
		binder.bind(IPropertyAccessNaming.class).to(bindPropertyAccessNaming());
		binder.bind(INamingService.class).to(bindNamingService());
	}

	private void bindModifications(Binder binder) {
		Multibinder<IModification> modificationBinder = Multibinder.newSetBinder(binder, IModification.class);
		getModifications().forEach(modification -> modificationBinder.addBinding().to(modification));
		coreModule.getModifications().forEach(modification -> modificationBinder.addBinding().to(modification));
	}

	/**
	 * Returns the list of modifications that shall be applied on the model to be
	 * generated, in the order in which they shall be applied.
	 * 
	 * See {@link IModification}
	 * 
	 * @param entry
	 *                  GeneratorEntry can be used to derive information from to set
	 *                  up the modification chain
	 * @return List of classes that extend IModification. A Guice
	 *         {@link com.google.inject.multibindings.Multibinder} will receive this
	 *         list of classes and create instances of it when injection is
	 *         requested (used in {@link ModificationExecutor}).
	 */
	public abstract List<Class<? extends IModification>> getModifications();

	public abstract Class<? extends IPropertyAccessNaming> bindPropertyAccessNaming();

	public abstract Class<? extends IGeneratorArtifactConfigurator> bindOutputConfigurator();

	public abstract Class<? extends INamingService> bindNamingService();

	public abstract Class<? extends TypesGeneratorModule> getCoreGeneratorModule();
}
