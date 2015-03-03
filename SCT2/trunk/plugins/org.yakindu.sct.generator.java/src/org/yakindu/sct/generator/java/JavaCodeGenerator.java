/**
  Copyright (c) 2012-2015 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java;

import static org.yakindu.sct.generator.core.util.GeneratorUtils.isDumpSexec;

import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.java.types.JavaTypeSystemAccess;
import org.yakindu.sct.generator.java.types.OldJavaTypeSystemAccess;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.google.inject.util.Modules;

public class JavaCodeGenerator extends AbstractJavaCodeGenerator {

	@Override
	public void generate(Statechart statechart, GeneratorEntry entry) {
		JavaGenerator delegate = getInjector(entry).getInstance(
				JavaGenerator.class);

		ExecutionFlow flow = createExecutionFlow(statechart, entry);

		if (isDumpSexec(entry)) {
			dumpSexec(entry, flow);
		}

		delegate.generate(flow, entry, getFileSystemAccess(entry));
	}

	@Override
	protected Module getChildInjectorModule(final GeneratorEntry entry) {
		Module module = super.getChildInjectorModule(entry);
		final GenmodelEntries entries = new GenmodelEntries();
		return Modules.override(module).with(new Module() {
			public void configure(Binder binder) {
				if (entries.useJavaInt(entry)) {
					binder.bind(ICodegenTypeSystemAccess.class).to(
							OldJavaTypeSystemAccess.class);
				} else {
					binder.bind(ICodegenTypeSystemAccess.class).to(
							JavaTypeSystemAccess.class);
				}
				binder.bind(INamingService.class).to(JavaNamingService.class)
						.in(Scopes.SINGLETON);
			}
		});

	}

}
