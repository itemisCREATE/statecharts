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
package org.yakindu.sct.ui.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 * @author oliver bohl - Initial contribution and API
 * 
 */
public class WorkspaceTreeContentProvider implements ITreeContentProvider {

	protected String fileExtension;

	public WorkspaceTreeContentProvider() {
	}

	public WorkspaceTreeContentProvider(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	@SuppressWarnings("rawtypes")
	public Object[] getElements(Object inputElement) {
		try {
			if (inputElement instanceof IContainer) {
				return filterForContent(((IContainer) inputElement).members());
			}
			if (inputElement instanceof Object[]) {
				return filterForContent((Object[]) inputElement);
			}
			if (inputElement instanceof Collection) {
				return filterForContent(((Collection) inputElement).toArray());
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return new Object[0];
	}

	public boolean hasChildren(Object element) {
		return element instanceof IContainer;
	}

	public Object[] getChildren(Object parentElement) {
		return getElements(parentElement);
	}

	public Object[] filterForContent(Object[] inputElements) {
		List<Object> list = Arrays.asList(inputElements);
		List<Object> result = list.stream().filter((m) -> isRelevant(m)).collect(Collectors.toList());
		return result.toArray(new IResource[result.size()]);
	}

	public boolean containsFile(IContainer folder) {
		try {
			List<IResource> list = Arrays.asList(folder.members());
			return list.stream().anyMatch((m) -> isRelevant(m));
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean isRelevant(Object member) {
		if (member instanceof IFile && hasFileExtension((IFile) member)) {
			return true;
		} else if (member instanceof IContainer) {
			if (containsFile((IContainer) member)) {
				return true;
			}
		}
		return false;
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
		return fileExtension.equals(res.getFileExtension());
	}
}
