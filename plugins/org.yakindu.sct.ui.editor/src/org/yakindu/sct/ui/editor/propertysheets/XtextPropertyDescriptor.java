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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

import de.itemis.gmf.runtime.commons.properties.descriptors.AbstractPropertyDescriptor;
import de.itemis.xtext.utils.jface.viewers.XtextCellEditor;

/**
 * 
 * @author andreas muelder
 * 
 */
public class XtextPropertyDescriptor extends AbstractPropertyDescriptor {

	private final Injector injector;

	public XtextPropertyDescriptor(EAttribute feature, String labelName,
			Injector injector) {
		super(feature, labelName);
		this.injector = injector;
	}

	public StyledText createControl(Composite parent) {
		XtextCellEditor editor = new XtextCellEditor(SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL) {
			@Override
			protected void focusLost() {
				// Default implementation disposes control on focus lost
			}
		};
		getInjector().injectMembers(editor);
		editor.create(parent);
		editor.activate();
		editor.getControl().setVisible(true);
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(editor.getControl());
		return (StyledText) editor.getControl();
	}

	public Object getControlValue() {
		StyledText styledText = getControl();
		return (styledText.getText() != null && styledText.getText().trim()
				.length() != 0) ? styledText.getText().trim() : null;
	}

	public void setControlValue(Object value) {
		if (value != null) {
			Assert.isTrue(value instanceof String, "Illegal value " + value);
			getControl().setText((String) value);
		}
	}

	public Injector getInjector() {
		return injector;
	}

	@Override
	public StyledText getControl() {
		return (StyledText) super.getControl();
	}

}
