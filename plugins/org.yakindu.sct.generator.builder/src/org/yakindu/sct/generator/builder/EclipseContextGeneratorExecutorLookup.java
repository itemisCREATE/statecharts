/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.generator.core.execution.GeneratorExecutorLookup;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EclipseContextGeneratorExecutorLookup extends GeneratorExecutorLookup {

	@Override
	protected Module getContextModule() {
		return Modules.combine(new EclipseContextModule(), new SharedStateModule());
	}

	public ICoreRunnable getGeneratorRunnable(IFile file) {
		final GeneratorModel model = GenModelLoader.load(file);
		ICoreRunnable runnable = new ICoreRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				try {
					execute(model);
				} catch (Exception ex) {
					Status st = new Status(IStatus.ERROR, BuilderActivator.PLUGIN_ID,
							"An error occurred during code generation.", ex);
					throw new CoreException(st);
				}
			}
		};
		return runnable;
	}

	public void executeGenerator(IFile file) {
		ICoreRunnable generatorRunnable = getGeneratorRunnable(file);
		Job generatorJob = Job.create("Execute SCT Genmodel " + file.getName(), generatorRunnable);
		generatorJob.setRule(file.getProject().getWorkspace().getRoot());
		generatorJob.schedule();
	}
}
