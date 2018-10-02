/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.navigator;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.navigator.utils.ComposedAdapterFactoryUtil;

/**
 * 
 * @author markus.muehlbrandt
 * 
 */
public class StatechartNavigatorContentProvider implements ICommonContentProvider {

	private AdapterFactoryContentProvider myAdapterFactoryContentProvier;

	private static final Object[] EMPTY_ARRAY = new Object[0];

	private Viewer myViewer;

	private TransactionalEditingDomain editingDomain;

	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	private Runnable myViewerRefreshRunnable;

	private ViewerFilter viewerFilter;

	public StatechartNavigatorContentProvider() {
		myAdapterFactoryContentProvier = new AdapterFactoryContentProvider(ComposedAdapterFactoryUtil.FACTORY);
		editingDomain = DiagramPartitioningUtil.getSharedDomain();

		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null && !myViewer.getControl().isDisposed()) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

	public void init(ICommonContentExtensionSite aConfig) {
	}

	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = editingDomain.getResourceSet().getResource(fileURI, true);
			return wrapEObjects(myAdapterFactoryContentProvier.getChildren(resource), parentElement);
		}

		if (parentElement instanceof DomainNavigatorItem) {
			return wrapEObjects(
					myAdapterFactoryContentProvier.getChildren(((DomainNavigatorItem) parentElement).getEObject()),
					parentElement);
		}
		return EMPTY_ARRAY;
	}

	private Object[] wrapEObjects(Object[] objects, Object parentElement) {
		Collection<DomainNavigatorItem> result = new ArrayList<DomainNavigatorItem>();
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof EObject) {
				DomainNavigatorItem navigatorItem = new DomainNavigatorItem((EObject) objects[i], parentElement,
						myAdapterFactoryContentProvier);
				// Check if object has a corresponding View
				if (!(objects[i] instanceof View)) {
					EObject eObject = (EObject) objects[i];
					navigatorItem.setView(getReferenceView(eObject));
				}
				result.add(navigatorItem);
			}
		}
		return result.toArray();
	}

	private View getReferenceView(EObject eObject) {
		
		CrossReferenceAdapter refAdapter = (CrossReferenceAdapter) CrossReferenceAdapter
				.getExistingCrossReferenceAdapter(eObject.eResource());
		if(refAdapter == null)
			return null;
		@SuppressWarnings("unchecked")
		Collection<Setting> inverseReferences = refAdapter.getInverseReferences(eObject, true);

		for (Setting setting : inverseReferences) {
			if (setting.getEObject() instanceof View
					&& setting.getEStructuralFeature() == NotationPackage.eINSTANCE.getView_Element()) {
				return (View) setting.getEObject();
			}
		}
		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof IFile) {
			IFile file = (IFile) element;
			return file.getParent();
		}
		if (element instanceof DomainNavigatorItem) {
			DomainNavigatorItem domainNavigatorItem = (DomainNavigatorItem) element;
			return domainNavigatorItem.getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return element instanceof IFile || hasVisibleChildren(element);
	}

	protected boolean hasVisibleChildren(Object parent) {
		Object[] children = getChildren(parent);
		for (Object obj : children) {
			if (getViewerFilter().select(null, parent, obj)) {
				return true;
			}
		}
		return false;
	}

	protected ViewerFilter getViewerFilter() {
		if (viewerFilter == null) {
			viewerFilter = new StatechartObjectViewerFilter();
		}
		return viewerFilter;
	}
}