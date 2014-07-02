/**
 * Copyright (c) 2011 committers of YAKINDU and others. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: committers of YAKINDU - initial API and
 * implementation
 * 
 */
package org.yakindu.sct.model.stext.resource.factory;

import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Injector;

/**
 * {@link IExecutableExtensionFactory} to use with classes from this bundle.
 * 
 * @author andreas muelder
 * 
 */
public class ExpressionsExecutableExtensionFactory extends
		AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.yakindu.sct.model.stext.resource.Activator.getDefault()
				.getBundle();
	}

	@Override
	protected Injector getInjector() {
		return STextActivator.getInstance().getInjector(
				STextActivator.ORG_YAKINDU_SCT_MODEL_STEXT_STEXT); //$//$NON-NLS-N$
	}

}
