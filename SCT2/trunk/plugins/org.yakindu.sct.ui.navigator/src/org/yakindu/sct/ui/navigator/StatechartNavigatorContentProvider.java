package org.yakindu.sct.ui.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.yakindu.sct.ui.navigator.utils.ComposedAdapterFactoryUtil;

/**
 * 
 * @author markus.muehlbrandt
 * 
 */
public class StatechartNavigatorContentProvider implements
		ICommonContentProvider {

	private AdapterFactoryContentProvider myAdapterFctoryContentProvier;

	private static final Object[] EMPTY_ARRAY = new Object[0];

	private Viewer myViewer;

	private AdapterFactoryEditingDomain myEditingDomain;

	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	private Runnable myViewerRefreshRunnable;

	private ECrossReferenceAdapter myCrossReferenceAdapter;

	private ViewerFilter viewerFilter;

	public StatechartNavigatorContentProvider() {
		myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(
				ComposedAdapterFactoryUtil.FACTORY);

		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain
				.setResourceToReadOnlyMap(new HashMap<Resource, Boolean>() {
					/**
			 * 
			 */
					private static final long serialVersionUID = -7623655803631543084L;

					public Boolean get(Object key) {
						if (!containsKey(key)) {
							put((Resource) key, Boolean.TRUE);
						}
						return super.get(key);
					}
				});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null && !myViewer.getControl().isDisposed()) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						for (Iterator<Resource> it = myEditingDomain
								.getResourceSet().getResources().iterator(); it
								.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay()
									.asyncExec(myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						for (Iterator<Resource> it = myEditingDomain
								.getResourceSet().getResources().iterator(); it
								.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay()
									.asyncExec(myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						for (Iterator<Resource> it = myEditingDomain
								.getResourceSet().getResources().iterator(); it
								.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay()
									.asyncExec(myViewerRefreshRunnable);
						}
						return true;
					}
				});

		myCrossReferenceAdapter = new ECrossReferenceAdapter();
		myEditingDomain.getResourceSet().eAdapters()
				.add(myCrossReferenceAdapter);
	}

	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator<Resource> it = myEditingDomain.getResourceSet()
				.getResources().iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		myEditingDomain.getResourceSet().eAdapters()
				.remove(myCrossReferenceAdapter);
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			return wrapEObjects(
					myAdapterFctoryContentProvier.getChildren(resource),
					parentElement);
		}

		if (parentElement instanceof DomainNavigatorItem) {
			return wrapEObjects(
					myAdapterFctoryContentProvier.getChildren(((DomainNavigatorItem) parentElement)
							.getEObject()), parentElement);
		}
		return EMPTY_ARRAY;
	}

	private Object[] wrapEObjects(Object[] objects, Object parentElement) {
		Collection<DomainNavigatorItem> result = new ArrayList<DomainNavigatorItem>();
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof EObject) {
				DomainNavigatorItem navigatorItem = new DomainNavigatorItem(
						(EObject) objects[i], parentElement,
						myAdapterFctoryContentProvier);
				// Check if object has a corresponding View
				if (!(objects[i] instanceof View)) {
					EObject eObject = (EObject) objects[i];
					navigatorItem.setView(getReferencigView(eObject));
				}
				result.add(navigatorItem);
			}
		}
		return result.toArray();
	}

	private View getReferencigView(EObject eObject) {

		Collection<Setting> inverseReferences = myCrossReferenceAdapter
				.getInverseReferences(eObject, true);

		for (Setting setting : inverseReferences) {
			if (setting.getEObject() instanceof View
					&& setting.getEStructuralFeature() == NotationPackage.eINSTANCE
							.getView_Element()) {
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