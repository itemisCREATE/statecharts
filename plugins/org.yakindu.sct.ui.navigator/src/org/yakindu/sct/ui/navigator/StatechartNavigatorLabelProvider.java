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
package org.yakindu.sct.ui.navigator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.yakindu.sct.ui.navigator.utils.ComposedAdapterFactoryUtil;

/**
 * 
 * @author m.muehlbrandt
 *
 */
public class StatechartNavigatorLabelProvider implements ICommonLabelProvider {

	private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			ComposedAdapterFactoryUtil.FACTORY);

	public void init(ICommonContentExtensionSite aConfig) {
	}

	public Image getImage(Object element) {
		if (element instanceof DomainNavigatorItem) {
			return myAdapterFactoryLabelProvider
					.getImage(((DomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	public String getText(Object element) {
		if (element instanceof DomainNavigatorItem) {
			return myAdapterFactoryLabelProvider
					.getText(((DomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.addListener(listener);
	}

	public void dispose() {
		myAdapterFactoryLabelProvider.dispose();
	}

	public boolean isLabelProperty(Object element, String property) {
		return myAdapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	public void removeListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.removeListener(listener);
	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

	public String getDescription(Object anElement) {
		return null;
	}
}