/** 
 * Copyright (c) 2018 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.domain.generic;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class GenericDomainActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		GenericDomainActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		GenericDomainActivator.context = null;
	}

}
