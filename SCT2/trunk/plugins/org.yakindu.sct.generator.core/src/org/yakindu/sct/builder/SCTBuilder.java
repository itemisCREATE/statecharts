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
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.generator.core.GeneratorActivator;
import org.yakindu.sct.generator.core.GeneratorExecutor;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTBuilder extends IncrementalProjectBuilder {

	// TODO Remove dependency to fileextension and read referenced elements from
	// genmodels instead.
	private static final String SCT_FILE_EXTENSION = "sct";
	private static final String SGEN_FILE_EXTENSION = "sgen";
	public static final String BUILDER_ID = "org.yakindu.sct.builder.SCTBuilder";

	private final class ElementRefGenerator implements
			Predicate<GeneratorEntry> {

		private final URI uri;

		private ElementRefGenerator(EObject eobject) {
			if (EcoreUtil.getURI(eobject) != null) {
				uri = EcoreUtil.getURI(eobject);
			} else {
				uri = null;
			}
		}

		public boolean apply(GeneratorEntry input) {
			return uri != null && input.getElementRef() != null
					&& !input.getElementRef().eIsProxy()
					&& uri.equals(EcoreUtil.getURI(input.getElementRef()));
		}
	}

	class DeltaVisitor implements IResourceDeltaVisitor {
		private Set<IResource> buildSgens = Sets.newHashSet();

		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				doIt(resource, buildSgens);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				doIt(resource, buildSgens);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	class SimpleResourceVisitor implements IResourceVisitor {
		private Set<IResource> buildSgens = Sets.newHashSet();

		public boolean visit(IResource resource) {
			doIt(resource, buildSgens);
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

	/**
	 * Build the Statecharts inside this sgen-file or find all sgen-files for
	 * the statechart in the resource and build them.
	 * 
	 * @param changedResource
	 *            Resource to check, if it can be build.
	 * @param buildSgens
	 *            Contains a set of already build sgen files. Accepted
	 *            sgen-files are added inside this method.
	 */
	public void doIt(final IResource changedResource,
			final Set<IResource> buildSgens) {
		if (changedResource.getType() != IResource.FILE) {
			return;
		}
		if (SGEN_FILE_EXTENSION.equals(changedResource.getFileExtension())
				&& !buildSgens.contains(changedResource)) {
			if (hasError(changedResource)) {
				logGenmodelError(changedResource.getFullPath().toString());
			} else {
				buildSgens.add(changedResource);
				executeGenmodelGenerator(changedResource);
			}
		} else if (SCT_FILE_EXTENSION
				.equals(changedResource.getFileExtension())) {
			// TODO rely on indexed genmodel and referenced objects uri
			final Statechart statechart = loadFromResource(changedResource);
			try {
				changedResource.getProject().accept(new IResourceVisitor() {

					public boolean visit(IResource resource)
							throws CoreException {
						if (IResource.FILE == resource.getType()
								&& SGEN_FILE_EXTENSION.equals(resource
										.getFileExtension())
								&& !buildSgens.contains(resource)
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
									buildSgens.add(resource);
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
						new ElementRefGenerator(statechart));
	}

	@SuppressWarnings("unchecked")
	private <TYPE extends EObject> TYPE loadFromResource(IResource res) {
		URI uri = URI.createPlatformResourceURI(res.getFullPath().toString(),
				true);
		ResourceSet set = new ResourceSetImpl();
		Resource emfResource = null;
		try {
			emfResource = set.getResource(uri, true);
		} catch (WrappedException e) {
			Platform.getLog(GeneratorActivator.getDefault().getBundle())
				.log(new Status(IStatus.WARNING, GeneratorActivator.PLUGIN_ID, 
						"Resource "+uri+" can not be loaded by builder",e));
			return null;
		}
		if (emfResource.getErrors().size() > 0
				|| emfResource.getContents().size() == 0)
			return null;
		return (TYPE) emfResource.getContents().get(0);
	}

}
