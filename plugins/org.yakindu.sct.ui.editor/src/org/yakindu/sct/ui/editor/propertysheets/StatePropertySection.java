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
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
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

	private UpdateLabelAdapter updateLabelAdapter;
	private Label submachineLabel;
	private Control textControl;
	private Control nameText;
	private ListViewer transitionViewer;

	@Override
	public void createControls(final Composite parent) {
		createNameControl(parent);
		createSpecificationControl(parent);
		createSubmachineControl(parent);
		createTransitionsControl(parent);
	}

	private void createNameControl(final Composite parent) {
		getToolkit().createLabel(parent, "Name: ");
		nameText = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().applyTo(nameText);
	}

	private void createSpecificationControl(final Composite parent) {
		Label nameLabel = getToolkit().createLabel(parent, "Specification: ");
		GridDataFactory.fillDefaults().applyTo(nameLabel);
		Injector injector = getInjector(SemanticTarget.StateSpecification);
		if (injector != null) {
			textControl = new StyledText(parent, SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL);
			StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(
					injector, new CloningBasedFakeContextResourcesProvider(
							Collections
									.singletonList(getActiveEditorResource())));
			xtextAdapter.adapt((StyledText) textControl);
		} else {
			textControl = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true).applyTo(textControl);
	}

	private void createSubmachineControl(final Composite parent) {
		Label label = getToolkit().createLabel(parent, "Submachine:");
		GridDataFactory.fillDefaults().applyTo(label);

		Composite composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
		composite.setBackground(ColorConstants.white);
		GridLayout layout = new GridLayout(2, false);
		layout.marginLeft = 0;
		layout.marginRight = 0;
		composite.setLayout(layout);
		submachineLabel = new Label(composite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(submachineLabel);
		Button openDialog = new Button(composite, SWT.FLAT);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 10)
				.applyTo(openDialog);
		openDialog.setText("...");
		openDialog.addListener(SWT.Selection, new OpenDialogHandler(parent));
	}

	private void createTransitionsControl(Composite parent) {
		Label label = getToolkit().createLabel(parent, "Transition order:");
		GridDataFactory.fillDefaults().applyTo(label);
		Composite transitionOrderComposite = new Composite(parent, SWT.NONE);
		transitionOrderComposite.setBackground(ColorConstants.white);
		transitionOrderComposite.setLayout(new GridLayout(2, false));
		transitionViewer = new ListViewer(transitionOrderComposite, SWT.SINGLE
				| SWT.BORDER);
		transitionViewer.setContentProvider(new ArrayContentProvider());
		transitionViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new SGraphItemProviderAdapterFactory()));
		GridDataFactory.fillDefaults().applyTo(transitionViewer.getControl());
		Composite buttonComposite = new Composite(transitionOrderComposite,
				SWT.NONE);
		buttonComposite.setLayout(new FillLayout(SWT.VERTICAL));
		GridDataFactory.fillDefaults().applyTo(buttonComposite);
		buttonComposite.setBackground(ColorConstants.white);
		final Button up = new Button(buttonComposite, SWT.PUSH);
		up.setText("up");
		final Button down = new Button(buttonComposite, SWT.PUSH);
		down.setText("down");
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(transitionViewer.getControl());
		GridDataFactory.fillDefaults().applyTo(transitionOrderComposite);
		transitionViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						Object firstElement = ((StructuredSelection) event
								.getSelection()).getFirstElement();
						int indexOf = getState().getOutgoingTransitions()
								.indexOf(firstElement);
						if (indexOf == -1) {
							up.setEnabled(false);
							down.setEnabled(false);
						} else if (indexOf == 0) {
							up.setEnabled(false);
							down.setEnabled(true);
						} else if (indexOf == getState()
								.getOutgoingTransitions().size() - 1) {
							up.setEnabled(true);
							down.setEnabled(false);
						} else {
							up.setEnabled(true);
							down.setEnabled(true);
						}
					}
				});
		transitionViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						Object firstElement = ((StructuredSelection) event
								.getSelection()).getFirstElement();

						IEditorPart lastActiveEditor = ActiveEditorTracker
								.getLastActiveEditor();
						if (lastActiveEditor instanceof DiagramDocumentEditor) {
							IGraphicalEditPart editPart = EditPartUtils
									.findEditPartForSemanticElement(
											((DiagramDocumentEditor) lastActiveEditor)
													.getDiagramGraphicalViewer()
													.getRootEditPart(),
											(EObject) firstElement);
							if (editPart != null) {
								((DiagramDocumentEditor) lastActiveEditor)
										.getDiagramGraphicalViewer().select(
												editPart);
								((DiagramDocumentEditor) lastActiveEditor)
										.getDiagramGraphicalViewer().reveal(
												editPart);
							}
						}
					}
				});
		up.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Object selection = ((StructuredSelection) transitionViewer
						.getSelection()).getFirstElement();
				RepositionEObjectCommand command = new RepositionEObjectCommand(
						TransactionUtil.getEditingDomain(eObject),
						"Reposition", getState().getOutgoingTransitions(),
						(EObject) selection, -1);
				try {
					OperationHistoryFactory.getOperationHistory().execute(
							command, new NullProgressMonitor(), null);
				} catch (ExecutionException e1) {
					e1.printStackTrace();
				}
				refreshTransitionViewerInput();

			}
		});
		down.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Object selection = ((StructuredSelection) transitionViewer
						.getSelection()).getFirstElement();
				RepositionEObjectCommand command = new RepositionEObjectCommand(
						TransactionUtil.getEditingDomain(eObject),
						"Reposition", getState().getOutgoingTransitions(),
						(EObject) selection, 1);
				try {
					OperationHistoryFactory.getOperationHistory().execute(
							command, new NullProgressMonitor(), null);
				} catch (ExecutionException e1) {
					e1.printStackTrace();
				}
				refreshTransitionViewerInput();
			}
		});
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
		ISelection selection = transitionViewer.getSelection();
		transitionViewer.setInput(getState().getOutgoingTransitions());
		transitionViewer.setSelection(selection);
	}

	private void bindSpecificationControl(EMFDataBindingContext context) {
		IEMFValueProperty specificationProperty = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue specificationTextProperty = WidgetProperties.text(
				SWT.FocusOut).observe(textControl);
		context.bindValue(specificationTextProperty,
				specificationProperty.observe(eObject));
	}

	private void bindNameControl(EMFDataBindingContext context) {
		IEMFValueProperty nameProperty = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue nameTextProperty = WidgetProperties.text(
				SWT.FocusOut).observe(nameText);
		context.bindValue(nameTextProperty, nameProperty.observe(eObject));
	}

	private void updateLabel() {
		String substatechartId = getState().getSubstatechartId();
		if (substatechartId != null) {
			submachineLabel.setText(substatechartId);
		} else {
			submachineLabel.setText("");
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
