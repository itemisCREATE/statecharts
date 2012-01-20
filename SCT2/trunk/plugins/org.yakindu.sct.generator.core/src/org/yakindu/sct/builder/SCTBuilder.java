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
package org.yakindu.sct.builder;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.generator.core.GeneratorActivator;
import org.yakindu.sct.generator.core.GeneratorExecutor;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTBuilder extends IncrementalProjectBuilder {

	private static final String SCT_FILE_EXTENSION = "sct";
	private static final String SGEN_FILE_EXTENSION = "sgen";
	public static final String BUILDER_ID = "org.yakindu.sct.builder.SCTBuilder";

	private final class GeneratorForStatechart implements
			Predicate<GeneratorEntry> {
		private final Statechart statechart;

		private GeneratorForStatechart(Statechart statechart) {
			this.statechart = statechart;
		}

		public boolean apply(GeneratorEntry input) {
			// return input.getStatechart().equals(statechart);
			return statechart != null
					&& input.getStatechart() != null
					&& !input.getStatechart().eIsProxy()
					&& input.getStatechart().getName()
							.equals(statechart.getName());
		}
	}

	class DeltaVisitor implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				doIt(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				doIt(resource);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	class SimpleResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			doIt(resource);
			// return true to continue visiting children.
			return true;
		}
	}

	@Override
	protected IProject[] build(int kind,
			@SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new SimpleResourceVisitor());
		} catch (CoreException e) {
		}
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		delta.accept(new DeltaVisitor());
	}

	public void doIt(final IResource changedResource) {
		if (changedResource.getType() != IResource.FILE) {
			return;
		}
		if (SGEN_FILE_EXTENSION.equals(changedResource.getFileExtension())) {
			if (hasError(changedResource)) {
				logGenmodelError(changedResource.getFullPath().toString());
			} else {
				executeGenmodelGenerator(changedResource);
			}
		} else if (SCT_FILE_EXTENSION
				.equals(changedResource.getFileExtension())) {
			final Statechart statechart = loadFromResource(changedResource);
			try {
				changedResource.getProject().accept(new IResourceVisitor() {

					public boolean visit(IResource resource)
							throws CoreException {
						if (IResource.FILE == resource.getType()
								&& SGEN_FILE_EXTENSION.equals(resource
										.getFileExtension())
								&& isGenmodelForStatechart(resource, statechart)) {
							// TODO: would be good to filter the config for the
							// statechart so only the sct that changed is
							// build
							if (hasError(changedResource)) {
								logStatechartError(changedResource
										.getFullPath().toString());
							} else {
								if (hasError(resource)) {
									logGenmodelError(resource.getFullPath()
											.toString());
								} else {
									executeGenmodelGenerator(resource);
								}
							}
						}
						return true;
					}
				});
			} catch (CoreException e) {
				e.printStackTrace();
			}

		}
	}

	private boolean hasError(IResource resource) {
		IMarker[] findMarkers = null;
		try {
			findMarkers = resource.findMarkers(IMarker.PROBLEM, true,
					IResource.DEPTH_INFINITE);
			for (IMarker iMarker : findMarkers) {
				Integer attribute = (Integer) iMarker
						.getAttribute(IMarker.SEVERITY);
				if (attribute.intValue() == IMarker.SEVERITY_ERROR) {
					return true;
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return false;
	}

	protected void executeGenmodelGenerator(IResource resource) {
		new GeneratorExecutor().executeGenerator(resource.getProject().getFile(
				resource.getProjectRelativePath()));
	}

	protected void logGenmodelError(String resource) {
		Status status = new Status(Status.ERROR, BUILDER_ID, String.format(
				"Cannot execute Genmodel %s. The file contains errors.",
				resource));
		Platform.getLog(GeneratorActivator.getDefault().getBundle())
				.log(status);
	}

	protected void logStatechartError(final String resource) {
		Status status = new Status(
				Status.ERROR,
				BUILDER_ID,
				String.format(
						"Cannot generate Code for Statechart %s. The file contains errors.",
						resource));
		Platform.getLog(GeneratorActivator.getDefault().getBundle())
				.log(status);
	}

	private boolean isGenmodelForStatechart(IResource genmodelResource,
			final Statechart statechart) {
		GeneratorModel genModel = loadFromResource(genmodelResource);
		return genModel != null
				&& !genModel.getEntries().isEmpty()
				&& Iterables.any(genModel.getEntries(),
						new GeneratorForStatechart(statechart));
	}

	@SuppressWarnings("unchecked")
	private <TYPE extends EObject> TYPE loadFromResource(IResource res) {
		URI uri = URI.createPlatformResourceURI(res.getFullPath().toString(),
				true);
		ResourceSet set = new ResourceSetImpl();
		Resource emfResource = set.getResource(uri, true);
		return (TYPE) emfResource.getContents().get(0);
	}

}
