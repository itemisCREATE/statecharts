/**
  Copyright (c) 2012-2015 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.csharp;

import static org.yakindu.sct.generator.core.util.GeneratorUtils.isDumpSexec;

import org.yakindu.sct.generator.csharp.CSharpNamingService;
import org.yakindu.sct.generator.csharp.CSharpGenerator;
import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.csharp.types.CSharpTypeSystemAccess;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class CSharpCodeGenerator extends GenericJavaBasedGenerator {

	@Override
	public void runGenerator(Statechart statechart, GeneratorEntry entry) {
		CSharpGenerator delegate = getInjector(entry).getInstance(
				CSharpGenerator.class);
		ExecutionFlow flow = createExecutionFlow(statechart, entry);
		if (isDumpSexec(entry)) {
			dumpSexec(entry, flow);
		}
		delegate.generate(flow, entry, getFileSystemAccess(entry));
	}

	@Override
	protected Module getChildInjectorModule(final GeneratorEntry entry) {
		Module module = super.getChildInjectorModule(entry);
		return Modules.override(module).with(new Module() {
			public void configure(Binder binder) {
				binder.bind(ICodegenTypeSystemAccess.class)
				.to(CSharpTypeSystemAccess.class);
				binder.bind(INamingService.class).to(CSharpNamingService.class);
				binder.bind(GeneratorEntry.class).toInstance(entry);
			}
		});
	}
}