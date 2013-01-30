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

import static org.yakindu.sct.ui.editor.breadcrumb.BreadcrumbViewerUtil.openEditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbViewer;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.IBreadcrumbDropDownSite;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.TreeViewerDropDown;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
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

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SCTBreadcrumbViewer extends BreadcrumbViewer implements ISelectionChangedListener {

	public SCTBreadcrumbViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected Control createDropDown(Composite parent, IBreadcrumbDropDownSite site, TreePath path) {
		return createDropDownControl(parent, site, path);
	}

	public Control createDropDownControl(Composite parent, final IBreadcrumbDropDownSite site, final TreePath paramPath) {
		TreeViewerDropDown dropDownTreeViewer = new TreeViewerDropDown() {
			protected TreeViewer createTreeViewer(Composite composite, int style, final TreePath path) {
				return createDropDownTreeViewer(composite, paramPath, site);
			}
		};
		return dropDownTreeViewer.createDropDown(parent, site, paramPath);
	}

	protected TreeViewer createDropDownTreeViewer(Composite composite, TreePath paramPath,
			final IBreadcrumbDropDownSite site) {
		TreeViewer viewer = new TreeViewer(composite);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(new SGraphItemProviderAdapterFactory()));
		viewer.setContentProvider(new AdapterFactoryContentProvider(new BreadcrumbItemProviderAdapterFactory()));
		Diagram diagram = (Diagram) paramPath.getParentPath().getLastSegment();
		if (diagram != null) {
			EObject element = diagram.getElement();
			viewer.setInput(element);
			viewer.addSelectionChangedListener(this);
			return viewer;
		}
		viewer.getControl().pack();
		composite.layout(true);
		return null;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		EObject object = (EObject) ((IStructuredSelection) event.getSelection()).getFirstElement();
		if (object instanceof State || object instanceof Statechart) {
			Diagram diagram = BreadcrumbViewerUtil.getSubDiagram(object);
			openEditor(diagram);
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
					if (vertex instanceof State && BreadcrumbViewerUtil.getSubDiagram(vertex) != null) {
						result.add(vertex);
					}
				}
			}
			return result;
		}
	}

}