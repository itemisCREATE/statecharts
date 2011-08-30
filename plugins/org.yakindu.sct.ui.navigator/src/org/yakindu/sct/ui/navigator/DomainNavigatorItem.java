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

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
/**
 * 
 * @author m.muehlbrandt
 *
 */
@SuppressWarnings("rawtypes")
public class DomainNavigatorItem extends PlatformObject {

	static {
		final Class[] supportedTypes = new Class[] { EObject.class,
				IPropertySource.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof DomainNavigatorItem) {
					DomainNavigatorItem domainNavigatorItem = (DomainNavigatorItem) adaptableObject;
					EObject eObject = domainNavigatorItem.getEObject();
					if (adapterType == EObject.class) {
						return eObject;
					}
					if (adapterType == IPropertySource.class) {
						return domainNavigatorItem.getPropertySourceProvider()
								.getPropertySource(eObject);
					}
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, DomainNavigatorItem.class);
	}

	private Object myParent;

	private EObject myEObject;

	private IPropertySourceProvider myPropertySourceProvider;

	private View view = null;

	public DomainNavigatorItem(EObject eObject, Object parent,
			IPropertySourceProvider propertySourceProvider) {
		myParent = parent;
		myEObject = eObject;
		myPropertySourceProvider = propertySourceProvider;
	}

	public Object getParent() {
		return myParent;
	}

	public EObject getEObject() {
		return myEObject;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public IPropertySourceProvider getPropertySourceProvider() {
		return myPropertySourceProvider;
	}

	public boolean equals(Object obj) {
		if (obj instanceof DomainNavigatorItem) {
			return EcoreUtil.getURI(getEObject()).equals(
					EcoreUtil.getURI(((DomainNavigatorItem) obj).getEObject()));
		}
		return super.equals(obj);
	}

	public int hashCode() {
		return EcoreUtil.getURI(getEObject()).hashCode();
	}
}