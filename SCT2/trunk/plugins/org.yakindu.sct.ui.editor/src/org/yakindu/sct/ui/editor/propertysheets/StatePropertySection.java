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
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.xtext.naming.QualifiedName;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.dialogs.SelectSubmachineDialog;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.propertysheets.OrderElementControl.ISourceObjectCallback;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatePropertySection extends
		AbstractTwoColumnEditorPropertySection implements ISourceObjectCallback {

	private Label lblSubmachine;
	private Control txtSpecification;
	private Control txtName;

	private UpdateLabelAdapter updateLabelAdapter = new UpdateLabelAdapter();
	private OrderElementControl orderElementControl;

	@Override
	protected Layout createLeftColumnLayout() {
		return new GridLayout(2, false);
	}

	@Override
	protected void createLeftColumnControls(Composite leftColumn) {
		createSpecificationControl(leftColumn);
	}

	@Override
	protected void createRightColumnControls(Composite rightColumn) {
		createNameControl(rightColumn);
		createSubmachineControl(rightColumn);
		createTransitionsControl(rightColumn);
	}

	private void createNameControl(final Composite parent) {
		Label lblName = getToolkit().createLabel(parent, "State Name: ");
		txtName = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().applyTo(lblName);
		GridDataFactory.fillDefaults().applyTo(txtName);
	}

	private void createSpecificationControl(final Composite parent) {
		Injector injector = getInjector(SemanticTarget.StateSpecification);
		if (injector != null) {
			txtSpecification = new StyledText(parent, SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL);
			enableXtext(txtSpecification, injector);
			createHelpWidget(parent, txtSpecification,
					HelpContextIds.SC_PROPERTIES_TRANSITION_EXPRESSION);
		} else {
			txtSpecification = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(txtSpecification);
	}

	private void createSubmachineControl(final Composite parent) {
		Label label = getToolkit().createLabel(parent, "State Submachine:");
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
		Label label = getToolkit().createLabel(parent, "Transition Priority:");
		GridDataFactory.fillDefaults().applyTo(label);
		orderElementControl = new OrderElementControl(parent,
				SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS, this);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(orderElementControl);
	}

	protected State getState() {
		return (State) eObject;
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		bindNameControl(context);
		bindSpecificationControl(context);
		orderElementControl.refreshInput();
		updateLabel();
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
				BasePackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue nameTextProperty = WidgetProperties.text(
				new int[] { SWT.FocusOut, SWT.DefaultSelection }).observe(
				txtName);
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
	protected void setEObject(EObject object) {
		if (getEObject() != null)
			getEObject().eAdapters().remove(updateLabelAdapter);
		super.setEObject(object);
		getEObject().eAdapters().add(updateLabelAdapter);
	}

	@Override
	public void dispose() {
		if (getEObject() != null) {
			getEObject().eAdapters().remove(updateLabelAdapter);
		}
		super.dispose();
	}

	@Override
	public EObject getEObject() {
		return super.getEObject();
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
									selectedSubmachine != null ? selectedSubmachine
											.toString() : null));
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
