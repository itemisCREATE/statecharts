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
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.swt.widgets.Text;
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
	private Text txtDoc;

	private UpdateLabelAdapter updateLabelAdapter = new UpdateLabelAdapter();
	private OrderElementControl orderElementControl;

	@Override
	protected Layout createLeftColumnLayout() {
		return new GridLayout(2, false);
	}

	@Override
	protected void createLeftColumnControls(Composite leftColumn) {
		createNameControl(leftColumn);
		createSpecificationControl(leftColumn);
	}

	@Override
	protected void createRightColumnControls(Composite rightColumn) {
		createDocumentationControl(rightColumn);
		createTransitionsControl(rightColumn);
		createSubmachineControl(rightColumn);
	}

	protected void createNameControl(final Composite parent) {
		Label lblName = getToolkit().createLabel(parent, "State Name: ");
		txtName = getToolkit().createText(parent, "");
		GridDataFactory.fillDefaults().span(2, 1).applyTo(lblName);
		new Label(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtName);
	}

	protected void createDocumentationControl(Composite rightColumn) {
		Label lblDocumentation = getToolkit().createLabel(rightColumn,
				"Documentation: ");
		txtDoc = getToolkit().createText(rightColumn, "", SWT.MULTI);
		GridDataFactory.fillDefaults().applyTo(lblDocumentation);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(txtDoc);
	}

	protected void createSpecificationControl(final Composite parent) {
		Injector injector = getInjector(SemanticTarget.StateSpecification);
		if (injector != null) {
			txtSpecification = new StyledText(parent, SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL | SWT.WRAP);
			((StyledText) txtSpecification).setAlwaysShowScrollBars(false);
			enableXtext(txtSpecification, injector);
			createHelpWidget(parent, txtSpecification,
					HelpContextIds.SC_PROPERTIES_STATE_EXPRESSION);
		} else {
			txtSpecification = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize())
				.applyTo(txtSpecification);
	}

	protected void createSubmachineControl(final Composite parent) {
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

	protected void createTransitionsControl(Composite parent) {
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
		bindDocumentationControl(context);
		orderElementControl.refreshInput();
		updateLabel();
	}

	private void bindDocumentationControl(EMFDataBindingContext context) {
		IEMFValueProperty property = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION);
		ISWTObservableValue observe = WidgetProperties.text(
				new int[] { SWT.FocusOut, SWT.DefaultSelection }).observe(
				txtDoc);
		context.bindValue(observe, property.observe(eObject));
	}

	protected void bindSpecificationControl(EMFDataBindingContext context) {
		IEMFValueProperty specificationProperty = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue specificationTextProperty = WidgetProperties.text(
				SWT.FocusOut).observe(txtSpecification);
		context.bindValue(specificationTextProperty,
				specificationProperty.observe(eObject), null,
				new UpdateValueStrategy() {
					@Override
					protected IStatus doSet(IObservableValue observableValue,
							Object value) {
						if (!getCompletionProposalAdapter()
								.isProposalPopupOpen())
							return super.doSet(observableValue, value);
						return Status.OK_STATUS;
					}
				});
	}

	protected void bindNameControl(EMFDataBindingContext context) {
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

	protected final class OpenDialogHandler implements Listener {
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

	protected final class UpdateLabelAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == SGraphPackage.Literals.STATE__SUBSTATECHART_ID) {
				updateLabel();
			}
		}
	}
}
