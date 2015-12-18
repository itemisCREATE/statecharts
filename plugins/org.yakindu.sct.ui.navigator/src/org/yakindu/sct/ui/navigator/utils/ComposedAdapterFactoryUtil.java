/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.navigator.utils;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

public class ComposedAdapterFactoryUtil {

	public static final ComposedAdapterFactory FACTORY;
	static {
		FACTORY = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		// FACTORY.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		// FACTORY.addAdapterFactory(new
		// ReflectiveItemProviderAdapterFactory());

		// FACTORY.addAdapterFactory(new SGraphItemProviderAdapterFactory());

	}

}
