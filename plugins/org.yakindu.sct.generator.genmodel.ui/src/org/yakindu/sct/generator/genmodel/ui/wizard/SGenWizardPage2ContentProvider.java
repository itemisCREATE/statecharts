/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 * @author oliver bohl - Initial contribution and API
 * 
 */
public class SGenWizardPage2ContentProvider implements ITreeContentProvider {

	protected String fileExtension;

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof IContainer) {
			IContainer container = (IContainer) inputElement;
			try {
				return filterForContent(container.members());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return new Object[] {};
	}

	public boolean hasChildren(Object element) {
		return element instanceof IContainer;
	}

	public Object[] getChildren(Object parentElement) {
		Object[] result = getElements(parentElement);
		try {
			return filterForContent(result);
		} catch (CoreException e) {
			e.printStackTrace();
			return new Object[0];
		}
	}

	public boolean containsFile(IFolder folder) throws CoreException {
		if (folder.members() != null) {
			for (Object member : folder.members()) {

				// No file extension check
				if (member instanceof IFile && hasFileExtension((IFile) member)) {
					return false;
				}
				// check if file extension is proper
				else if (member instanceof IFile
						&& ((IFile) member).getFileExtension().equals(
								fileExtension)) {
					return true;
				} else if (member instanceof IFolder) {
					return containsFile((IFolder) member);

				}
			}
		}
		return false;
	}

	public Object[] filterForContent(Object[] inputElements)
			throws CoreException {
		final Set<Object> result = new HashSet<Object>();
		for (final Object obj : inputElements) {
			((IResource) obj).accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					// no file extension check
					if (resource instanceof IFile
							&& hasFileExtension((IFile) resource)) {
						return false;
					}
					// check if file extension is proper
					else if (resource instanceof IFile
							&& resource.getFileExtension()
									.equals(fileExtension)) {
						if (!containsErrors(resource))
							result.add(obj);
						return true;
					} else if (resource instanceof IFolder
							&& containsFile((IFolder) resource)) {
						result.add(obj);
						return true;
					}
					return false;
				}
			});
		}
		return result.toArray(new IResource[0]);
	}

	public boolean containsErrors(IResource resource) {
		int maxSeverity;
		try {
			maxSeverity = resource.findMaxProblemSeverity(IMarker.PROBLEM,
					true, IResource.DEPTH_INFINITE);
			return maxSeverity == IMarker.SEVERITY_ERROR;
		} catch (CoreException e) {
			return true;
		}
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// not handled
	}

	public void dispose() {
		// not handled
	}

	public Object getParent(Object element) {
		return null;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public boolean hasFileExtension(IFile res) {
		return (res.getFileExtension() == null);
	}
}
