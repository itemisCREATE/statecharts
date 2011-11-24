/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.ui.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GenerateModelAction implements IObjectActionDelegate {

	private ISelection selection;

	@Inject
	private XtextResourceSetProvider provider;

	public void run(IAction action) {
		IFile file = unwrap();
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		Resource resource = loadResource(uri);
		GeneratorModel model = (GeneratorModel) resource.getContents().get(0);

		String generatorId = model.getGeneratorId();
		GeneratorDescriptor description = GeneratorExtensions
				.getGeneratorDescriptorForId(generatorId);
		final ISCTGenerator generator = description.createGenerator();
		final EList<GeneratorEntry> entries = model.getEntries();
		Job generatorJob = new Job("Execute SCT Genmodel " + file.getName()) {
			protected IStatus run(IProgressMonitor monitor) {
				for (GeneratorEntry generatorEntry : entries) {
					if (monitor.isCanceled()) {
						break;
					}
					generator.generate(generatorEntry);
				}
				return Status.OK_STATUS;
			}
		};
		generatorJob.schedule();

	}

	protected Resource loadResource(URI uri) {
		ResourceSet resourceSet = provider.get(unwrap().getProject());
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}

	private IFile unwrap() {
		if (selection instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) selection)
					.getFirstElement();
			if (firstElement instanceof IFile) {
				return (IFile) firstElement;
			}
		}
		return null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
