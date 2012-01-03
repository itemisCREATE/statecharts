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
package org.yakindu.sct.ui.editor.propertysheets;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.commands.core.commands.RepositionEObjectCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.naming.QualifiedName;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.provider.SGraphItemProviderAdapterFactory;
import org.yakindu.sct.ui.editor.dialogs.SelectSubmachineDialog;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;

import com.google.inject.Injector;

import de.itemis.gmf.runtime.commons.util.EditPartUtils;
import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import de.itemis.xtext.utils.jface.viewers.context.CloningBasedFakeContextResourcesProvider;
import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorTracker;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatePropertySection extends AbstractEditorPropertySection {

	private Label lblSubmachine;
	private Control txtSpecification;
	private Control txtName;
	private ListViewer listViewer;
	private Button btnUp;
	private Button btnDown;
	private EditPartSelectionListener editPartSelectionListener;
	private EnableButtonListener enableButtonListener;
	private ButtonSelectionListener upButtonListener;
	private ButtonSelectionListener downButtonListener;
	private UpdateLabelAdapter updateLabelAdapter;

	public StatePropertySection() {
		editPartSelectionListener = new EditPartSelectionListener();
		enableButtonListener = new EnableButtonListener();
		upButtonListener = new ButtonSelectionListener(-1);
		downButtonListener = new ButtonSelectionListener(1);
	}

	@Override
	public void createControls(final Composite parent) {
		parent.setLayout(new FillLayout());
		Composite leftColumn = getToolkit().createComposite(parent);
		leftColumn.setLayout(createBodyLayout());
		Composite rightColumn = getToolkit().createComposite(parent);
		rightColumn.setLayout(createBodyLayout());
		createNameControl(rightColumn);
		createSpecificationControl(leftColumn);
		createSubmachineControl(rightColumn);
		createTransitionsControl(rightColumn);
	}

	private void createNameControl(final Composite parent) {
		Label lblName = getToolkit().createLabel(parent, "Name: ");
		txtName = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().applyTo(lblName);
		GridDataFactory.fillDefaults().applyTo(txtName);
	}

	private void createSpecificationControl(final Composite parent) {
		Label nameLabel = getToolkit().createLabel(parent, "Specification: ");
		Injector injector = getInjector(SemanticTarget.StateSpecification);
		if (injector != null) {
			txtSpecification = new StyledText(parent, SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL);
			StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(
					injector, new CloningBasedFakeContextResourcesProvider(
							Collections
									.singletonList(getActiveEditorResource())));
			xtextAdapter.adapt((StyledText) txtSpecification);
		} else {
			txtSpecification = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().applyTo(nameLabel);
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(txtSpecification);
	}

	private void createSubmachineControl(final Composite parent) {
		Label label = getToolkit().createLabel(parent, "Submachine:");
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setBackground(ColorConstants.white);
		GridLayout layout = new GridLayout(2, false);
		layout.marginLeft = 0;
		layout.marginRight = 0;
		composite.setLayout(layout);
		lblSubmachine = new Label(composite, SWT.BORDER);
		Button openDialog = new Button(composite, SWT.FLAT);
		openDialog.setText("...");
		openDialog.addListener(SWT.Selection, new OpenDialogHandler(parent));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(lblSubmachine);
		GridDataFactory.fillDefaults().applyTo(label);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 10)
				.applyTo(openDialog);
	}

	private void createTransitionsControl(Composite parent) {
		Label label = getToolkit().createLabel(parent, "Transition order:");
		Composite composite = getToolkit().createComposite(parent);
		composite.setLayout(new GridLayout(2, false));
		listViewer = new ListViewer(composite, SWT.SINGLE | SWT.BORDER);
		listViewer.setContentProvider(new ArrayContentProvider());
		listViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new SGraphItemProviderAdapterFactory()));
		Composite buttonComposite = getToolkit().createComposite(composite);
		buttonComposite.setLayout(new FillLayout(SWT.VERTICAL));
		buttonComposite.setBackground(ColorConstants.white);
		btnUp = getToolkit().createButton(buttonComposite, "up", SWT.PUSH);
		btnDown = getToolkit().createButton(buttonComposite, "down", SWT.PUSH);
		listViewer.addSelectionChangedListener(enableButtonListener);
		listViewer.addSelectionChangedListener(editPartSelectionListener);
		btnUp.addSelectionListener(upButtonListener);
		btnDown.addSelectionListener(downButtonListener);
		GridDataFactory.fillDefaults().applyTo(listViewer.getControl());
		GridDataFactory.fillDefaults().applyTo(buttonComposite);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(listViewer.getControl());
		GridDataFactory.fillDefaults().applyTo(composite);
		GridDataFactory.fillDefaults().applyTo(label);
	}

	protected State getState() {
		return (State) eObject;
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		bindNameControl(context);
		bindSpecificationControl(context);
		if (updateLabelAdapter == null) {
			updateLabelAdapter = new UpdateLabelAdapter();
			eObject.eAdapters().add(updateLabelAdapter);
		}
		refreshTransitionViewerInput();
		updateLabel();
	}

	private void refreshTransitionViewerInput() {
		ISelection selection = listViewer.getSelection();
		listViewer.setInput(getState().getOutgoingTransitions());
		listViewer.setSelection(selection);
	}

	private void bindSpecificationControl(EMFDataBindingContext context) {
		IEMFValueProperty specificationProperty = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue specificationTextProperty = WidgetProperties.text(
				SWT.FocusOut).observe(txtSpecification);
		context.bindValue(specificationTextProperty,
				specificationProperty.observe(eObject));
	}

	private void bindNameControl(EMFDataBindingContext context) {
		IEMFValueProperty nameProperty = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue nameTextProperty = WidgetProperties.text(
				SWT.FocusOut).observe(txtName);
		context.bindValue(nameTextProperty, nameProperty.observe(eObject));
	}

	private void updateLabel() {
		String substatechartId = getState().getSubstatechartId();
		if (substatechartId != null) {
			lblSubmachine.setText(substatechartId);
		} else {
			lblSubmachine.setText("");
		}
	}

	@Override
	public void dispose() {
		listViewer.removeSelectionChangedListener(editPartSelectionListener);
		listViewer.removeSelectionChangedListener(enableButtonListener);
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

	protected Transition getSelectedTransition() {
		return (Transition) ((StructuredSelection) listViewer.getSelection())
				.getFirstElement();
	}

	private final class ButtonSelectionListener extends SelectionAdapter {

		private final int displacement;

		public ButtonSelectionListener(int displacement) {
			this.displacement = displacement;
		}

		public void widgetSelected(SelectionEvent e) {
			RepositionEObjectCommand command = new RepositionEObjectCommand(
					TransactionUtil.getEditingDomain(eObject), "Reposition",
					getState().getOutgoingTransitions(),
					getSelectedTransition(), displacement);
			try {
				OperationHistoryFactory.getOperationHistory().execute(command,
						new NullProgressMonitor(), null);
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
			refreshTransitionViewerInput();
		}
	}

	private final class EnableButtonListener implements
			ISelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			EList<Transition> outgoingTransitions = getState()
					.getOutgoingTransitions();
			int indexOf = outgoingTransitions.indexOf(getSelectedTransition());
			if (indexOf == -1 || outgoingTransitions.size() <= 1) {
				btnUp.setEnabled(false);
				btnDown.setEnabled(false);
			} else if (indexOf == 0) {
				btnUp.setEnabled(false);
				btnDown.setEnabled(true);
			} else if (indexOf == outgoingTransitions.size() - 1) {
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
			if (lastActiveEditor instanceof DiagramDocumentEditor) {
				IGraphicalEditPart editPart = EditPartUtils
						.findEditPartForSemanticElement(
								((DiagramDocumentEditor) lastActiveEditor)
										.getDiagramGraphicalViewer()
										.getRootEditPart(),
								getSelectedTransition());
				if (editPart != null) {
					((DiagramDocumentEditor) lastActiveEditor)
							.getDiagramGraphicalViewer().select(editPart);
					((DiagramDocumentEditor) lastActiveEditor)
							.getDiagramGraphicalViewer().reveal(editPart);
				}
			}
		}
	}

	private final class OpenDialogHandler implements Listener {
		private final Composite parent;

		private OpenDialogHandler(Composite parent) {
			this.parent = parent;
		}

		public void handleEvent(Event event) {
			SelectSubmachineDialog dialog = new SelectSubmachineDialog(
					parent.getShell(), eObject.eResource());
			dialog.setElements(new Object[] { eObject });
			if (org.eclipse.jface.dialogs.Dialog.OK == dialog.open()) {
				QualifiedName selectedSubmachine = dialog
						.getSelectedSubmachine();
				if (selectedSubmachine != null || dialog.isClearSelected()) {
					SetValueCommand command = new SetValueCommand(
							new SetRequest(
									eObject,
									SGraphPackage.Literals.STATE__SUBSTATECHART_ID,
									selectedSubmachine.toString()));
					try {
						OperationHistoryFactory.getOperationHistory().execute(
								command, new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private final class UpdateLabelAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == SGraphPackage.Literals.STATE__SUBSTATECHART_ID) {
				updateLabel();
			}
		}
	}
}
