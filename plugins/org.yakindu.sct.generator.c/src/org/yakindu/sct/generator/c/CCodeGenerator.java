/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c;

import static org.yakindu.sct.generator.core.util.GeneratorUtils.isDumpSexec;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.yakindu.sct.generator.c.types.CTypeSystemAccess;
import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.naming.StextNameProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder
 * 
 */
public class CCodeGenerator extends GenericJavaBasedGenerator {

	@Override
	public void runGenerator(Statechart statechart, GeneratorEntry entry) {
		CSCTGenerator delegate = getInjector(entry).getInstance(
				CSCTGenerator.class);
		ExecutionFlow flow = createExecutionFlow(statechart, entry);
		if (isDumpSexec(entry)) {
			dumpSexec(entry, flow);
		}
		delegate.generate(flow, entry, getFileSystemAccess(entry));
	}

	@Override
	protected Module createModule(final GeneratorEntry entry) {
		Module module = super.createModule(entry);
		return Modules.override(module).with(new Module() {
			public void configure(Binder binder) {
				binder.bind(ICodegenTypeSystemAccess.class)
						.to(CTypeSystemAccess.class);
				binder.bind(INamingService.class).to(CNamingService.class);
				binder.bind(GeneratorEntry.class).toInstance(entry);
				binder.bind(IQualifiedNameProvider.class).to(StextNameProvider.class);
			}
		});
	}
}
