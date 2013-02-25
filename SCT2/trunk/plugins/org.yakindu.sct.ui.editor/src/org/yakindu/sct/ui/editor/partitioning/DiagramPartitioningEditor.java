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
package org.yakindu.sct.ui.editor.partitioning;

import static org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil.openEditor;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.util.Arrays;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.provider.SGraphItemProviderAdapterFactory;
import org.yakindu.sct.ui.editor.StatechartImages;

/**
 * Editor that uses a {@link DiagramPartitioningDocumentProvider} and adds a
 * {@link DiagramPartitioningBreadcrumbViewer} to the top.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class DiagramPartitioningEditor extends DiagramDocumentEditor implements ISelectionChangedListener,
		IEditingDomainProvider {

	private static final String SUBDIAGRAM = "Subdiagram - ";

	private DiagramPartitioningBreadcrumbViewer viewer;

	private DiagramPartitioningDocumentProvider documentProvider;

	public DiagramPartitioningEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
		documentProvider = new DiagramPartitioningDocumentProvider();
	}

	@Override
	public TransactionalEditingDomain getEditingDomain() {
		return DiagramPartitioningUtil.getSharedDomain();
	}

	@Override
	public IDocumentProvider getDocumentProvider() {
		return documentProvider;
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(parent);
		createBreadcrumbViewer(parent);
		super.createPartControl(parent);
	}

	@Override
	protected void sanityCheckState(IEditorInput input) {
		super.sanityCheckState(input);
		// Refresh viewer input since the context may have changed
		viewer.setInput(DiagramPartitioningUtil.getDiagramContainerHierachy(getDiagram()));

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
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new SGraphItemProviderAdapterFactory());
		setTitleImage(labelProvider.getImage(element));
		setPartName(SUBDIAGRAM + labelProvider.getText(element));

	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer graphicalViewer = getGraphicalViewer();
		ContextMenuProvider provider = new DiagramContextMenuProvider(this, graphicalViewer) {
			protected boolean allowItem(IContributionItem itemToAdd) {
				String[] exclude = new String[] { "addNoteLinkAction", "properties",
						"org.eclipse.mylyn.context.ui.commands.attachment.retrieveContext",
						"org.eclipse.mylyn.resources.ui.ui.interest.remove.element", "formatMenu", "filtersMenu","addGroup","navigateGroup" };
				if (Arrays.contains(exclude, itemToAdd.getId())) {
					itemToAdd.setVisible(false);
				}
				return super.allowItem(itemToAdd);
			}
		};
		graphicalViewer.setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, viewer);
	}

	private void createBreadcrumbViewer(Composite parent) {
		viewer = new DiagramPartitioningBreadcrumbViewer(parent, SWT.READ_ONLY);
		viewer.addSelectionChangedListener(this);
		viewer.setContentProvider(new BreadcrumbViewerContentProvider());
		viewer.setLabelProvider(new BreadcrumbViewerLabelProvider());
		viewer.setInput(DiagramPartitioningUtil.getDiagramContainerHierachy(getDiagram()));
		parent.pack(true);
	}

	@Override
	protected void createGraphicalViewer(Composite parent) {
		super.createGraphicalViewer(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		Diagram diagramToOpen = (Diagram) ((IStructuredSelection) event.getSelection()).getFirstElement();
		openEditor(diagramToOpen);
	}

	public static final class BreadcrumbViewerLabelProvider extends BaseLabelProvider implements ITreePathLabelProvider {

		public void updateLabel(ViewerLabel label, TreePath elementPath) {
			Diagram lastSegment = (Diagram) elementPath.getLastSegment();
			NamedElement element = (NamedElement) lastSegment.getElement();
			AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(
					new SGraphItemProviderAdapterFactory());
			label.setText(provider.getText(element));
			if (element instanceof Statechart)
				label.setImage(StatechartImages.LOGO.image());
			else
				label.setImage(provider.getImage(element));

		}
	}

	@SuppressWarnings("unchecked")
	public static final class BreadcrumbViewerContentProvider implements ITreePathContentProvider {

		private List<IFile> input;

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput != null && newInput instanceof List) {
				input = (List<IFile>) newInput;
			}
		}

		@SuppressWarnings("rawtypes")
		public Object[] getElements(Object inputElement) {
			if (inputElement != null && inputElement instanceof Collection) {
				return ((Collection) inputElement).toArray();
			}
			return null;
		}

		public Object[] getChildren(TreePath parentPath) {
			return input.subList(parentPath.getSegmentCount(), input.size()).toArray();
		}

		public void dispose() {
			input = null;
		}

		public boolean hasChildren(TreePath path) {
			return false;
		}

		public TreePath[] getParents(Object element) {
			return null;
		}

	}

}
