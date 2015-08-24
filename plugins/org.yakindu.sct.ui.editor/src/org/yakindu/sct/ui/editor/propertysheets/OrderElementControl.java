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
package org.yakindu.sct.ui.editor.propertysheets;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.commands.RepositionEObjectCommand;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.yakindu.base.gmf.runtime.util.EditPartUtils;
import org.yakindu.base.xtext.utils.jface.viewers.util.ActiveEditorTracker;
import org.yakindu.sct.model.sgraph.provider.SGraphItemProviderAdapterFactory;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class OrderElementControl extends Composite {

	private FormToolkit toolkit;
	private Button btnUp;
	private Button btnDown;
	private TableViewer viewer;

	private ButtonSelectionListener upButtonListener;
	private ButtonSelectionListener downButtonListener;
	private EditPartSelectionListener editPartSelectionListener;
	private EnableButtonListener enableButtonListener;
	private EStructuralFeature toManyFeature;

	public interface ISourceObjectCallback {
		public EObject getEObject();
	}

	private ISourceObjectCallback callback;

	public OrderElementControl(Composite parent,
			EStructuralFeature toManyFeature, ISourceObjectCallback callback) {
		super(parent, SWT.NONE);
		this.toManyFeature = toManyFeature;
		this.callback = callback;
		toolkit = new FormToolkit(parent.getDisplay());
		upButtonListener = new ButtonSelectionListener(-1);
		downButtonListener = new ButtonSelectionListener(1);
		editPartSelectionListener = new EditPartSelectionListener();
		enableButtonListener = new EnableButtonListener();
		setBackground(ColorConstants.white);
		init();
	}

	private void init() {
		this.setLayout(new GridLayout(2, false));
		viewer = new TableViewer(this, SWT.SINGLE | SWT.BORDER);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new SGraphItemProviderAdapterFactory()));
		Composite buttonComposite = getToolkit().createComposite(this);
		buttonComposite.setLayout(new FillLayout(SWT.VERTICAL));
		btnUp = getToolkit().createButton(buttonComposite, "up", SWT.PUSH);
		btnDown = getToolkit().createButton(buttonComposite, "down", SWT.PUSH);
		viewer.addSelectionChangedListener(enableButtonListener);
		viewer.addSelectionChangedListener(editPartSelectionListener);
		btnUp.addSelectionListener(upButtonListener);
		btnDown.addSelectionListener(downButtonListener);
		GridDataFactory.fillDefaults().applyTo(viewer.getControl());
		GridDataFactory.fillDefaults().applyTo(buttonComposite);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(viewer.getControl());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(this);
	}

	public TableViewer getListViewer() {
		return viewer;
	}

	public FormToolkit getToolkit() {
		return toolkit;
	}

	protected EObject getSelectedObject() {
		return (EObject) ((StructuredSelection) viewer.getSelection())
				.getFirstElement();
	}

	@SuppressWarnings("unchecked")
	private EList<EObject> getListInput() {
		return (EList<EObject>) callback.getEObject().eGet(toManyFeature);
	}

	public void refreshInput() {
		ISelection selection = viewer.getSelection();
		viewer.setInput(getListInput());
		viewer.setSelection(selection);
	}

	private final class ButtonSelectionListener extends SelectionAdapter {

		private final int displacement;

		public ButtonSelectionListener(int displacement) {
			this.displacement = displacement;
		}

		public void widgetSelected(SelectionEvent e) {
			RepositionEObjectCommand command = new RepositionEObjectCommand(
					TransactionUtil.getEditingDomain(callback.getEObject()),
					"Reorder Elements", getListInput(), getSelectedObject(),
					displacement);
			try {
				OperationHistoryFactory.getOperationHistory().execute(command,
						new NullProgressMonitor(), null);
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
			refreshInput();
		}
	}

	private final class EnableButtonListener implements
			ISelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			EList<EObject> listInput = getListInput();
			int indexOf = listInput.indexOf(getSelectedObject());
			if (indexOf == -1 || listInput.size() <= 1) {
				btnUp.setEnabled(false);
				btnDown.setEnabled(false);
			} else if (indexOf == 0) {
				btnUp.setEnabled(false);
				btnDown.setEnabled(true);
			} else if (indexOf == listInput.size() - 1) {
				btnUp.setEnabled(true);
				btnDown.setEnabled(false);
			} else {
				btnUp.setEnabled(true);
				btnDown.setEnabled(true);
			}
		}
	}

	private final class EditPartSelectionListener implements
			ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			IEditorPart lastActiveEditor = ActiveEditorTracker
					.getLastActiveEditor();
			EObject selectedObject = getSelectedObject();
			if (lastActiveEditor instanceof DiagramDocumentEditor
					&& selectedObject != null) {
				IGraphicalEditPart editPart = EditPartUtils
						.findEditPartForSemanticElement(
								((DiagramDocumentEditor) lastActiveEditor)
										.getDiagramGraphicalViewer()
										.getRootEditPart(), selectedObject);
				if (editPart != null) {
					((DiagramDocumentEditor) lastActiveEditor)
							.getDiagramGraphicalViewer().select(editPart);
					((DiagramDocumentEditor) lastActiveEditor)
							.getDiagramGraphicalViewer().reveal(editPart);
				}
			}
		}
	}

	@Override
	public void dispose() {
		viewer.removeSelectionChangedListener(editPartSelectionListener);
		viewer.removeSelectionChangedListener(enableButtonListener);
		if (!btnUp.isDisposed()) {
			btnUp.removeSelectionListener(upButtonListener);
			btnUp.dispose();
		}
		if (!btnDown.isDisposed()) {
			btnDown.removeSelectionListener(downButtonListener);
			btnDown.dispose();
		}
		super.dispose();
	}

}
