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

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionPropertySection extends AbstractTwoColumnEditorPropertySection {

	private Control textControl;
	private Text txtDoc;

	protected Layout createLeftColumnLayout() {
		return new GridLayout(2, false);
	}

	@Override
	protected void createLeftColumnControls(Composite parent) {
		Label lblExpression = getToolkit().createLabel(parent, "Expression: ");
		GridDataFactory.fillDefaults().span(2, 1).applyTo(lblExpression);

		Injector injector = getInjector(Transition.class.getName());
		if (injector != null) {
			textControl = new StyledText(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
			((StyledText) textControl).setAlwaysShowScrollBars(false);
			enableXtext(textControl, injector);
			createHelpWidget(parent, textControl, HelpContextIds.SC_PROPERTIES_TRANSITION_EXPRESSION);
		} else {
			textControl = getToolkit().createText(parent, "", SWT.MULTI);
		}
		GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize()).applyTo(textControl);
	}

	@Override
	protected void createRightColumnControls(Composite parent) {
		Label lblDocumentation = getToolkit().createLabel(parent, "Documentation: ");
		txtDoc = getToolkit().createText(parent, "", SWT.MULTI);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(lblDocumentation);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(txtDoc);
	}

	@Override
	public void bindModel(EMFDataBindingContext context) {
		IEMFValueProperty modelProperty = EMFEditProperties.value(TransactionUtil.getEditingDomain(eObject),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue uiProperty = WidgetProperties.text(SWT.FocusOut).observe(textControl);
		context.bindValue(uiProperty, modelProperty.observe(eObject), null, new UpdateValueStrategy() {
			@Override
			protected IStatus doSet(IObservableValue observableValue, Object value) {
				if (getCompletionProposalAdapter() != null && !getCompletionProposalAdapter().isProposalPopupOpen())
					return super.doSet(observableValue, value);
				return Status.OK_STATUS;
			}
		});

		IEMFValueProperty property = EMFEditProperties.value(TransactionUtil.getEditingDomain(eObject),
				BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION);
		ISWTObservableValue observe = WidgetProperties.text(new int[] { SWT.FocusOut, SWT.DefaultSelection }).observe(
				txtDoc);
		context.bindValue(observe, property.observe(eObject));

	}
}
