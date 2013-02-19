/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.breadcrumb;

import static org.yakindu.sct.ui.editor.breadcrumb.DiagramPartitioningUtil.openEditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbViewer;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.IBreadcrumbDropDownSite;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.TreeViewerDropDown;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.provider.SGraphItemProviderAdapterFactory;
import org.yakindu.sct.model.sgraph.provider.StateItemProvider;
import org.yakindu.sct.model.sgraph.provider.StatechartItemProvider;
import org.yakindu.sct.ui.editor.StatechartImages;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class DiagramPartitioningBreadcrumbViewer extends BreadcrumbViewer implements ISelectionChangedListener {

	public DiagramPartitioningBreadcrumbViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected Control createDropDown(Composite parent, IBreadcrumbDropDownSite site, TreePath path) {
		Control result = createDropDownControl(parent, site, path);
		return result;
	}

	public Control createDropDownControl(Composite parent, final IBreadcrumbDropDownSite site, final TreePath paramPath) {
		TreeViewerDropDown dropDownTreeViewer = new TreeViewerDropDown() {
			protected TreeViewer createTreeViewer(Composite composite, int style, final TreePath path) {
				return createDropDownTreeViewer(composite, paramPath, site);
			}
		};
		return dropDownTreeViewer.createDropDown(parent, site, paramPath);
	}

	protected TreeViewer createDropDownTreeViewer(final Composite composite, TreePath paramPath,
			final IBreadcrumbDropDownSite site) {
		Diagram diagram = (Diagram) paramPath.getParentPath().getLastSegment();
		TreeViewer viewer = null;
		if (diagram != null)
			viewer = createDiagramViewer(composite, diagram);
		else
			viewer = createProjectStatechartViewer(composite, (Diagram) paramPath.getLastSegment());
		viewer.getControl().addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				getDropDownShell().pack(true);
			}
		});
		return viewer;
	}

	protected TreeViewer createProjectStatechartViewer(Composite composite, Diagram diagram) {
		TreeViewer viewer = new TreeViewer(composite);
		viewer.setLabelProvider(new StatechartLabelProvider());
		viewer.setContentProvider(new StatechartContentProvider());
		viewer.setInput(getProjectStatechartInput(diagram));
		viewer.addSelectionChangedListener(this);
		return viewer;
	}

	protected Set<IFile> getProjectStatechartInput(Diagram diagram) {
		final IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
		final IProject project = file.getProject();
		final Set<IFile> result = new HashSet<IFile>();
		try {
			project.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					// TODO check for package explorer filters here
					if (resource.isHidden()) {
						return false;
					}
					if (resource instanceof IFile) {
						if (file.getFileExtension().equals(resource.getFileExtension()))
							result.add((IFile) resource);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return result;
	}

	protected TreeViewer createDiagramViewer(final Composite composite, Diagram diagram) {
		TreeViewer viewer = new TreeViewer(composite);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(new SGraphItemProviderAdapterFactory()));
		viewer.setContentProvider(new AdapterFactoryContentProvider(new BreadcrumbItemProviderAdapterFactory()));
		EObject element = diagram.getElement();
		viewer.setInput(element);
		viewer.addSelectionChangedListener(this);
		return viewer;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
		if (selection instanceof State || selection instanceof Statechart) {
			Diagram diagram = DiagramPartitioningUtil.getSubDiagram((EObject) selection);
			openEditor(diagram);
		} else if (selection instanceof IFile) {
			openEditor((IFile) selection);
		}
	}

	public static final class StatechartContentProvider implements ITreeContentProvider {

		private Set<IFile> newInput;

		public void dispose() {
		}

		@SuppressWarnings("unchecked")
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			this.newInput = (Set<IFile>) newInput;

		}

		public Object[] getElements(Object inputElement) {
			return newInput.toArray(new Object[] {});
		}

		public Object[] getChildren(Object parentElement) {
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return false;
		}

	}

	public static final class StatechartLabelProvider extends BaseLabelProvider implements ILabelProvider {

		public Image getImage(Object element) {
			return StatechartImages.LOGO.image();
		}

		public String getText(Object element) {
			return ((IFile) element).getFullPath().toString();
		}

	}

	public static final class BreadcrumbItemProviderAdapterFactory extends SGraphItemProviderAdapterFactory {

		@Override
		public Adapter createStatechartAdapter() {
			if (statechartItemProvider == null) {
				statechartItemProvider = new StatechartItemProvider(this) {
					@Override
					public Collection<?> getChildren(Object object) {
						return collectSubdiagrams((CompositeElement) object);
					}
				};
			}
			return statechartItemProvider;
		}

		@Override
		public Adapter createStateAdapter() {
			if (stateItemProvider == null) {
				stateItemProvider = new StateItemProvider(this) {
					@Override
					public Collection<?> getChildren(Object object) {
						return collectSubdiagrams((CompositeElement) object);
					}
				};
			}
			return stateItemProvider;
		}

		private Collection<?> collectSubdiagrams(CompositeElement state) {
			List<Vertex> result = new ArrayList<Vertex>();
			EList<Region> regions = state.getRegions();
			for (Region region : regions) {
				EList<Vertex> vertices = region.getVertices();
				for (Vertex vertex : vertices) {
					if (vertex instanceof State && DiagramPartitioningUtil.getSubDiagram(vertex) != null) {
						result.add(vertex);
					}
				}
			}
			return result;
		}
	}

}