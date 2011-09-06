/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package de.itemis.gmf.runtime.commons.properties.descriptors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogLabelKeys;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * 
 * Abstract base class for all implementers of {@link IFormPropertyDescriptor}.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractPropertyDescriptor implements
		IFormPropertyDescriptor {

	public final static String HELP_CONTEXT_NONE = "help_context_none";

	private final EStructuralFeature feature;

	private final String labelName;

	private Control control;

	private EMFDataBindingContext bindingContext;

	protected String helpContextId = HELP_CONTEXT_NONE;

	protected abstract Control createControl(Composite parent);

	protected abstract IObservableValue getWidgetValue();

	public AbstractPropertyDescriptor(EStructuralFeature feature,
			String labelName) {
		this.feature = feature;
		this.labelName = labelName;
	}

	public AbstractPropertyDescriptor(EStructuralFeature feature,
			String labelName, String helpContextId) {
		this(feature, labelName);
		this.helpContextId = helpContextId;
	}

	public void createControlColumn(Composite parent) {
		control = createControl(parent);
		applyHelpContext(control);
	}

	public void createLabelColumn(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Label label = toolkit.createLabel(parent, labelName);
		applyLayout(label);
		toolkit.dispose();
	}

	/**
	 * Hook method, clients may override if another layouting is needed
	 */
	protected void applyLayout(Control control) {
		GridDataFactory.fillDefaults().applyTo(control);
	}

	public Control getControl() {
		return control;
	}

	public void createHelpColumn(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		final ImageHyperlink helpWidget = toolkit.createImageHyperlink(parent,
				SWT.CENTER);
		Image defaultImage = PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_LCL_LINKTO_HELP);
		helpWidget.setImage(defaultImage);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP)
				.applyTo(helpWidget);
		if (hasHelpContext()) {
			helpWidget.setToolTipText(JFaceResources
					.getString(IDialogLabelKeys.HELP_LABEL_KEY));
			helpWidget.addMouseListener(new MouseAdapter() {
				public void mouseDown(MouseEvent e) {
					getControl().setFocus();
					PlatformUI.getWorkbench().getHelpSystem()
							.displayDynamicHelp();
				}
			});
			helpWidget.setEnabled(true);
		} else {
			helpWidget.setEnabled(false);
		}
		toolkit.dispose();
	}

	protected boolean hasHelpContext() {
		return !(HELP_CONTEXT_NONE.equals(getHelpContextId()));
	}

	protected void applyHelpContext(Control control) {
		if (hasHelpContext()) {
			PlatformUI.getWorkbench().getHelpSystem()
					.setHelp(control, getHelpContextId());
		}
	}

	public String getHelpContextId() {
		return helpContextId;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public void updateModelBinding(EObject eObject) {
		if (bindingContext != null)
			bindingContext.dispose();
		bindingContext = new EMFDataBindingContext();

		IObservableValue widgetValue = getWidgetValue();
		bindingContext.bindValue(widgetValue, getModelValue(eObject));
	}

	protected IObservableValue getModelValue(EObject eObject) {
		IEMFValueProperty property = EMFEditProperties.value(
				TransactionUtil.getEditingDomain(eObject), getFeature());
		IObservableValue value = property.observe(eObject);
		return value;
	}

	public void dispose() {
		if (getControl() != null && !getControl().isDisposed())
			getControl().dispose();
		if (bindingContext != null)
			bindingContext.dispose();
	}
}
