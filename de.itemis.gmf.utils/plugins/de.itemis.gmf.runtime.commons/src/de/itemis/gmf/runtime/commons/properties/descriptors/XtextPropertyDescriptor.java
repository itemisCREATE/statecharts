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
package de.itemis.gmf.runtime.commons.properties.descriptors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.viewers.XtextStyledText;

/**
 * 
 * @author andreas muelder
 * 
 */
public class XtextPropertyDescriptor extends AbstractPropertyDescriptor {

	private final Injector injector;
	private final Resource context;
	
	protected XtextStyledText xtextWidget;

	public XtextPropertyDescriptor(EAttribute feature, String labelName,
			Injector injector) {
		this(feature, labelName, injector, (Resource)null);
	}

	public XtextPropertyDescriptor(EAttribute feature, String labelName,
			Injector injector, Resource context) {
		super(feature, labelName);
		this.injector = injector;
		this.context = context;
	}
	
	public XtextPropertyDescriptor(EAttribute feature, String labelName,
			Injector injector, String helpContextId) {
		this(feature, labelName, injector);
		this.helpContextId = helpContextId;
	}
	
	public XtextPropertyDescriptor(EAttribute feature, String labelName,
			Injector injector, Resource context, String helpContextId) {
		this(feature, labelName, injector, context);
		this.helpContextId = helpContextId;
	}

	protected int getStyle() {
		return SWT.MULTI | SWT.BORDER;
	}

	public StyledText createControl(Composite parent) {
		xtextWidget = createXtextWidget(parent, getStyle(), getInjector(), context);
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(xtextWidget.getStyledText());
		return (StyledText) xtextWidget.getStyledText();
	}
	
	protected XtextStyledText createXtextWidget(Composite parent, int style, Injector injector, Resource context) {
		return new XtextStyledText(parent, style,
					getInjector(), context);
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
	
	public XtextStyledText getXtextWidget(){
		return xtextWidget;
	}

	@Override
	public StyledText getControl() {
		return (StyledText) super.getControl();
	}

}
