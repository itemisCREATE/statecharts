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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.dialogs.IDialogLabelKeys;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract base class for all implementers of {@link IFormPropertyDescriptor}.
 * 
 * @author andreas muelder
 * 
 */
public abstract class AbstractPropertyDescriptor implements IFormPropertyDescriptor {

	private final EAttribute feature;
	private final String labelName;

	private Control control;

	public final static String HELP_CONTEXT_NONE = "help_context_none";
	
	protected String helpContextId = HELP_CONTEXT_NONE;

	public String getHelpContextId() {
		return helpContextId;
	}

	// necessary?!
	public void setHelpContextId(String helpContextId) {
		this.helpContextId = helpContextId;
	}

	protected abstract Control createControl(Composite parent);

	public void initControl(Composite parent) {
		control = createControl(parent);
		applyHelpContext(control);
	}

	public AbstractPropertyDescriptor(EAttribute feature, String labelName) {
		this.feature = feature;
		this.labelName = labelName;
	}

	public AbstractPropertyDescriptor(EAttribute feature, String labelName, String helpContextId) {
		this(feature, labelName);
		this.helpContextId = helpContextId;
	}

	public EAttribute getEAttribute() {
		return feature;
	}

	public Label createLabel(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Label label = toolkit.createLabel(parent, labelName);
		applyLayout(label);
		return label;
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

	public void addHelp(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		final Button helpButton = toolkit.createButton(parent, "", SWT.PUSH);
		helpButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_LCL_LINKTO_HELP));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(helpButton);
		if (hasHelpContext()) {
			helpButton.setToolTipText(JFaceResources.getString(IDialogLabelKeys.HELP_LABEL_KEY));
			helpButton.addMouseListener(new MouseAdapter() {
				public void mouseDown(MouseEvent e) {
					getControl().setFocus();
					PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
				}
			});
		} else {
			helpButton.setEnabled(false);
			//helpButton.setVisible(false);
		}
	}

	public boolean hasHelpContext() {
		return !(HELP_CONTEXT_NONE.equals(getHelpContextId()));
	}
	
	// necessary?
	protected void applyHelpContext(Control control) {
		if (hasHelpContext()) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(control, getHelpContextId());
		}
	}
}
