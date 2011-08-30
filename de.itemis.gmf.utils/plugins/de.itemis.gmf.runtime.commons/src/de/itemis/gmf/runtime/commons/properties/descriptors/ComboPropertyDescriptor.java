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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.IViewerValueProperty;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Combo viewer for EMF based type safe enumerations
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ComboPropertyDescriptor extends AbstractPropertyDescriptor {

	private final Enumerator[] items;
	private ComboViewer comboViewer;

	public ComboPropertyDescriptor(EStructuralFeature feature, String labelName,
			Enumerator[] items) {
		super(feature, labelName);
		this.items = items;
	}

	public ComboPropertyDescriptor(EStructuralFeature feature, String labelName,
			Enumerator[] items, String helpContextId) {
		this(feature, labelName, items);
		this.helpContextId = helpContextId;
	}


	@Override
	protected Control createControl(Composite parent) {
		comboViewer = new ComboViewer(parent, SWT.READ_ONLY | SWT.SINGLE);
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new LabelProvider());
		comboViewer.setInput(items);
		applyLayout(comboViewer.getControl());
		return comboViewer.getControl();
	}

	@Override
	public Combo getControl() {
		return (Combo) super.getControl();
	}
	
	@Override
	protected IObservableValue getWidgetValue() {
		IViewerValueProperty singleSelection = ViewerProperties.singleSelection();
		return singleSelection.observe(comboViewer);
	}

}
