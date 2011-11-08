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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import de.itemis.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

/**
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * 
 */
public class XtextPropertyDescriptor extends AbstractPropertyDescriptor {

	private final Injector injector;
	private final IXtextFakeContextResourcesProvider contextFakeResourceProvider;
	private StyledTextXtextAdapter xtextAdapter;

	public XtextPropertyDescriptor(EStructuralFeature feature,
			String labelName, Injector injector,
			IXtextFakeContextResourcesProvider contextFakeResourceProvider) {
		super(feature, labelName);
		this.injector = injector;
		this.contextFakeResourceProvider = contextFakeResourceProvider;
	}

	public XtextPropertyDescriptor(EStructuralFeature feature,
			String labelName, Injector injector) {
		this(feature, labelName, injector,
				IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER);
	}

	public XtextPropertyDescriptor(EAttribute feature, String labelName,
			String helpContextId, Injector injector,
			IXtextFakeContextResourcesProvider contextResourcesProvider) {
		this(feature, labelName, injector, contextResourcesProvider);
		this.helpContextId = helpContextId;
	}

	public XtextPropertyDescriptor(EAttribute feature, String labelName,
			String helpContextId, Injector injector) {
		this(feature, labelName, helpContextId, injector,
				IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER);
	}

	protected int getStyle() {
		return SWT.MULTI | SWT.BORDER | SWT.V_SCROLL;
	}

	protected StyledText createControl(Composite parent) {
		StyledText styledText = new StyledText(parent, getStyle());
		xtextAdapter = new StyledTextXtextAdapter(getInjector(),
				contextFakeResourceProvider);
		xtextAdapter.adapt(styledText);
		return styledText;
	}

	@Override
	protected void applyLayout(Control control) {
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
	}

	@Override
	public void dispose() {
		xtextAdapter.dispose();
		super.dispose();
	}

	public Injector getInjector() {
		return injector;
	}

	@Override
	public StyledText getControl() {
		return (StyledText) super.getControl();
	}

	@Override
	protected IObservableValue getWidgetValue() {
		return WidgetProperties.text(SWT.FocusOut).observe(getControl());
	}

}
