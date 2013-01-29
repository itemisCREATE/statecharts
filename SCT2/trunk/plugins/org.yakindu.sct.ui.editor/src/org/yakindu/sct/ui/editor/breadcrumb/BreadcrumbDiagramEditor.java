/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.breadcrumb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbViewer;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.IBreadcrumbDropDownSite;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.provider.SGraphItemProviderAdapterFactory;
import org.yakindu.sct.ui.editor.StatechartImages;

@SuppressWarnings("restriction")
public abstract class BreadcrumbDiagramEditor extends DiagramDocumentEditor {

	public BreadcrumbDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(createGridLayout());
		createBreadcrumbViewer(parent);
		super.createPartControl(parent);
	}

	@Override
	public void setInput(IEditorInput input) {
		super.setInput(input);
		if (input instanceof IDiagramEditorInput) {
			initializeTitle((IDiagramEditorInput) input);
		}
	}

	protected void initializeTitle(IDiagramEditorInput input) {
		Diagram diagram = input.getDiagram();
		EObject element = diagram.getElement();
		AdapterFactoryLabelProvider factory = new AdapterFactoryLabelProvider(
				new SGraphItemProviderAdapterFactory());
		setTitleImage(factory.getImage(element));
		setPartName("Subdiagram - " + factory.getText(element));

	}

	private org.eclipse.swt.layout.GridLayout createGridLayout() {
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
		layout.makeColumnsEqualWidth = true;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginBottom = 0;
		layout.marginHeight = 0;
		layout.marginLeft = 0;
		layout.marginRight = 0;
		return layout;
	}

	public IFileEditorInput getEditorInput() {
		return (IFileEditorInput) super.getEditorInput();
	}

	private List<Diagram> getViewerInput() {
		List<Diagram> result = new ArrayList<Diagram>();
		Diagram diagram = getDiagram();
		result.add(getDiagram());
		while (diagram.getElement() instanceof State) {
			diagram = findDiagramForState((State) diagram.getElement());
			result.add(diagram);
		}
		Collections.reverse(result);
		return result;
	}

	private Diagram findDiagramForState(State element) {
		// TODO: Performance
		Resource eResource = element.eResource();
		Collection<Diagram> objects = EcoreUtil.getObjectsByType(
				eResource.getContents(), NotationPackage.Literals.DIAGRAM);
		for (Diagram diagram : objects) {
			TreeIterator<EObject> eAllContents = diagram.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof View) {
					if (EcoreUtil.equals(((View) next).getElement(), element)) {
						return ((View) next).getDiagram();
					}
				}
			}
		}
		return null;
	}

	private void createBreadcrumbViewer(Composite parent) {
		SCTBreadcrumbViewer viewer = new SCTBreadcrumbViewer(parent, SWT.NONE);
		viewer.setContentProvider(new ITreePathContentProvider() {

			private List<IFile> input;

			@SuppressWarnings("unchecked")
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				if (newInput != null && newInput instanceof List) {
					input = (List<IFile>) newInput;
				}
			}

			public void dispose() {
				// Nothing to do
			}

			public boolean hasChildren(TreePath path) {
				return false;
			}

			public TreePath[] getParents(Object element) {
				return null;
			}

			@SuppressWarnings("rawtypes")
			public Object[] getElements(Object inputElement) {
				if (inputElement != null && inputElement instanceof Collection) {
					return ((Collection) inputElement).toArray();
				}
				return null;
			}

			public Object[] getChildren(TreePath parentPath) {
				return input
						.subList(parentPath.getSegmentCount(), input.size())
						.toArray();
			}
		});
		viewer.setLabelProvider(new MyLabelProvider());
		viewer.setInput(getViewerInput());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {

			}
		});

	}

	@Override
	protected void createGraphicalViewer(Composite parent) {
		super.createGraphicalViewer(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
	}

	public class MyLabelProvider extends BaseLabelProvider implements
			ITreePathLabelProvider {

		public void updateLabel(ViewerLabel label, TreePath elementPath) {
			Diagram lastSegment = (Diagram) elementPath.getLastSegment();
			NamedElement element = (NamedElement) lastSegment.getElement();
			AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(
					new SGraphItemProviderAdapterFactory());
			label.setText(provider.getText(element));
			// TODO: change Edit provider
			if (element instanceof Statechart)
				label.setImage(StatechartImages.LOGO.image());
			else
				label.setImage(provider.getImage(element));

		}
	}

	public class SCTBreadcrumbViewer extends BreadcrumbViewer {

		public SCTBreadcrumbViewer(Composite parent, int style) {
			super(parent, style);
		}

		@Override
		protected Control createDropDown(Composite parent,
				IBreadcrumbDropDownSite site, TreePath path) {
			return new Composite(parent, SWT.NONE);

		}

	}
}
