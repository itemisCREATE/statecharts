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
package de.itemis.gmf.runtime.commons.decorators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract base class for all GMF {@link IDecoratorProvider} that provide
 * decoration based on {@link IMarker}s. Code initially copied form GMF tooling
 * generated validation provider.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractMarkerBasedDecorationProvider extends AbstractDecoratorProvider implements
		IDecoratorProvider {

	private static MarkerObserver fileObserver;

	private static Map<String, List<IDecorator>> allDecorators = new HashMap<String, List<IDecorator>>();

	protected abstract boolean shouldInstall(IEditorPart part);

	protected abstract String getDecoratorKey();

	protected abstract StatusDecorator createStatusDecorator(IDecoratorTarget decoratorTarget);

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart || editPart instanceof AbstractConnectionEditPart) {
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (shouldInstall(((DiagramEditDomain) ed).getEditorPart())) {
				decoratorTarget.installDecorator(getDecoratorKey(), createStatusDecorator(decoratorTarget));
			}
		}
	}

	protected static void refreshDecorators(String viewId, Diagram diagram) {
		final List<IDecorator> decorators = viewId != null ? (List<IDecorator>) allDecorators.get(viewId) : null;
		if (decorators == null || decorators.isEmpty() || diagram == null) {
			return;
		}
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				for (Iterator<IDecorator> it = decorators.iterator(); it.hasNext();) {
					IDecorator decorator = it.next();
					decorator.refresh();
				}
			}
		});
	}

	public abstract static class StatusDecorator extends AbstractDecorator {

		private String viewId;

		protected abstract String getMarkerType();

		protected abstract void createDecorators(View view, List<IMarker> markers);

		public StatusDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			try {
				final View view = (View) getDecoratorTarget().getAdapter(View.class);
				TransactionUtil.getEditingDomain(view).runExclusive(new Runnable() {
					public void run() {
						StatusDecorator.this.viewId = view != null ? ViewUtil.getIdStr(view) : null;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void refresh() {
			removeDecoration();
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if (editPart == null || editPart.getViewer() == null) {
				return;
			}

			IResource resource = WorkspaceSynchronizer.getFile(view.eResource());
			if (resource == null || !resource.exists()) {
				return;
			}
			List<IMarker> markers = new ArrayList<IMarker>();
			try {
				markers.addAll(Arrays.asList(resource.findMarkers(getMarkerType(), true, IResource.DEPTH_INFINITE)));
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if (markers == null || markers.size() == 0) {
				return;
			}
			createDecorators(view, markers);
		}

		public void activate() {
			if (viewId == null) {
				return;
			}

			// add self to global decorators registry
			List<IDecorator> list = allDecorators.get(viewId);
			if (list == null) {
				list = new ArrayList<IDecorator>(2);
				list.add(this);
				allDecorators.put(viewId, list);
			} else if (!list.contains(this)) {
				list.add(this);
			}

			// start listening to changes in resources
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null) {
				return;
			}
			Diagram diagramView = view.getDiagram();
			if (diagramView == null) {
				return;
			}
			if (fileObserver == null) {
				FileChangeManager.getInstance().addFileObserver(fileObserver = new MarkerObserver(diagramView));
			}
		}

		public void deactivate() {
			if (viewId == null) {
				return;
			}

			// remove self from global decorators registry
			List<IDecorator> list = allDecorators.get(viewId);
			if (list != null) {
				list.remove(this);
				if (list.isEmpty()) {
					allDecorators.remove(viewId);
				}
			}

			// stop listening to changes in resources if there are no more
			// decorators
			if (fileObserver != null && allDecorators.isEmpty()) {
				FileChangeManager.getInstance().removeFileObserver(fileObserver);
				fileObserver = null;
			}
			super.deactivate();
		}
	}

	protected static class MarkerObserver implements IFileObserver {

		private final Diagram diagram;

		private MarkerObserver(Diagram diagram) {
			this.diagram = diagram;
		}

		public void handleFileRenamed(IFile oldFile, IFile file) {
		}

		public void handleFileMoved(IFile oldFile, IFile file) {
		}

		public void handleFileDeleted(IFile file) {
		}

		public void handleFileChanged(IFile file) {
		}

		public void handleMarkerAdded(IMarker marker) {
			if (marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, null) != null) {
				handleMarkerChanged(marker);
			}
		}

		public void handleMarkerDeleted(IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {
			if (attributes == null)
				return;
			String viewId = (String) attributes.get(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID);
			if (viewId == null)
				return;
			refreshDecorators(viewId, diagram);
		}

		public void handleMarkerChanged(IMarker marker) {
			String viewId = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, "");
			refreshDecorators(viewId, diagram);
		}
	}

}
