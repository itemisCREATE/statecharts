/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java;

import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.generator.core.extensions.AnnotationExtensions;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.java.eventdriven.JavaEventDrivenIncludeProvider;
import org.yakindu.sct.generator.java.submodules.APIGenerator;
import org.yakindu.sct.generator.java.submodules.EventCode;
import org.yakindu.sct.generator.java.submodules.InterfaceFunctionsGenerator;
import org.yakindu.sct.generator.java.submodules.InternalFunctionsGenerator;
import org.yakindu.sct.generator.java.submodules.eventdriven.EventDrivenAPIGenerator;
import org.yakindu.sct.generator.java.submodules.eventdriven.EventDrivenEventCode;
import org.yakindu.sct.generator.java.submodules.eventdriven.EventDrivenInterfaceFunctionsGenerator;
import org.yakindu.sct.generator.java.submodules.eventdriven.EventDrivenInternalFunctionsGenerator;
import org.yakindu.sct.generator.java.types.JavaTypeSystemAccess;
import org.yakindu.sct.generator.java.types.OldJavaTypeSystemAccess;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.ng.ModelSequencer;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;

/**
 *
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - extensions for event driven execution
 *
 */
public class JavaGeneratorModule implements IGeneratorModule {
	
	protected Multibinder<JavaIncludeProvider> includeProviderBinder;

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		includeProviderBinder = Multibinder.newSetBinder(binder, JavaIncludeProvider.class);
		configureGeneratorRoot(entry, binder);
		configureForExecutionStyle(entry, binder);
		configureServices(entry, binder);
	}
	
	
	public void configureGeneratorRoot(GeneratorEntry entry, Binder binder) {
		binder.bind(IModelSequencer.class).to(ModelSequencer.class);
		binder.bind(BehaviorMapping.class).to(org.yakindu.sct.model.sexec.transformation.ng.BehaviorMapping.class);
		binder.bind(IExecutionFlowGenerator.class).to(JavaGenerator.class);
	}
	
	public void configureForExecutionStyle(GeneratorEntry entry, Binder binder) {
		if ((new AnnotationExtensions()).isEventDriven(entry)) {
			includeProviderBinder.addBinding().to(JavaEventDrivenIncludeProvider.class);
			binder.bind(APIGenerator.class).to(EventDrivenAPIGenerator.class);
			binder.bind(EventCode.class).to(EventDrivenEventCode.class);
			binder.bind(InterfaceFunctionsGenerator.class).to(EventDrivenInterfaceFunctionsGenerator.class);
			binder.bind(InternalFunctionsGenerator.class).to(EventDrivenInternalFunctionsGenerator.class);
			
		}
	}
	
	public void configureServices(GeneratorEntry entry, Binder binder) {
		
		final GenmodelEntries entries = new GenmodelEntries();
		if (entries.useJavaInt(entry)) {
			binder.bind(ICodegenTypeSystemAccess.class).to(OldJavaTypeSystemAccess.class);
		} else {
			binder.bind(ICodegenTypeSystemAccess.class).to(JavaTypeSystemAccess.class);
		}
		binder.bind(INamingService.class).to(JavaNamingService.class).in(Scopes.SINGLETON);
	}
	
}
