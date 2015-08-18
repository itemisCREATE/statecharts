package org.yakindu.base.xtext.utils.gmf.experimental;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.shared.Access;

import com.google.common.collect.Maps;

public abstract class DirtyStateAwareDiagramDocumentEditor extends
		DiagramDocumentEditor {

	private IDirtyStateManager dirtyStateManager;

	private Map<URI, IDirtyResource> uri2dirtyResource;

	public DirtyStateAwareDiagramDocumentEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
		dirtyStateManager = Access.getIDirtyStateManager().get();
		uri2dirtyResource = Maps.newHashMap();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		createDirtyResources();
	}

	private void createDirtyResources() {
		List<Resource> resources = getResources();
		for (Resource resource : resources) {
			if (!(resource instanceof XtextResource))
				createDirtyResource(resource);
		}
	}

	private void createDirtyResource(Resource resource) {
		IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(resource.getURI());
		if (resourceServiceProvider == null) {
			return;
		}
		final DirtyResourceAdapter dirtyResource = new DirtyResourceAdapter(
				resource, resourceServiceProvider);
		dirtyStateManager.manageDirtyState(dirtyResource);
		uri2dirtyResource.put(resource.getURI(), dirtyResource);
		if (EcoreUtil.getExistingAdapter(resource, DirtyResourceUpdater.class) == null)
			resource.eAdapters().add(new DirtyResourceUpdater(dirtyResource));
	}

	@Override
	public void dispose() {
		removeDirtyResources();
		super.dispose();

	};

	private void removeDirtyResources() {
		List<Resource> resources = getResources();
		for (Resource resource : resources) {
			if (!(resource instanceof XtextResource))
				removeDirtyResource(resource);
		}
	}

	private void removeDirtyResource(Resource resource) {
		IDirtyResource dirtyResource = uri2dirtyResource.get(resource.getURI());
		dirtyStateManager.discardDirtyState(dirtyResource);
		uri2dirtyResource.remove(resource.getURI());
		//TODO: remove adapter EcoreUtil.getExistingAdapter(resource, DirtyResourceUpdater.class) == null
		
	}

	private List<Resource> getResources() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		EList<Resource> resources = editingDomain.getResourceSet()
				.getResources();
		return resources;
	}

	private final class DirtyResourceUpdater extends EContentAdapter {
		private final DirtyResourceAdapter dirtyResource;

		private DirtyResourceUpdater(DirtyResourceAdapter dirtyResource) {
			this.dirtyResource = dirtyResource;
		}

		public void notifyChanged(Notification notification) {
			dirtyStateManager.announceDirtyStateChanged(dirtyResource);
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == DirtyResourceUpdater.class;
		}
	}

	private static final class DirtyResourceAdapter implements IDirtyResource {

		private final Resource resource;
		private final IResourceServiceProvider serviceProvider;

		protected DirtyResourceAdapter(Resource resource,
				IResourceServiceProvider provider) {
			this.resource = resource;
			serviceProvider = provider;
		}

		public String getContents() {
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try {
				resource.save(outputStream, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new String(outputStream.toByteArray());
		}

		public String getActualContents() {
			return getContents();
		}

		public IResourceDescription getDescription() {
			return serviceProvider.getResourceDescriptionManager()
					.getResourceDescription(resource);
		}

		public URI getURI() {
			return resource.getURI();
		}

	}

}
