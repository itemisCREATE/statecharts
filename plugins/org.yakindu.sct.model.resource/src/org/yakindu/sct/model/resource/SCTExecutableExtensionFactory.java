/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.resource;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.Bundle;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected Injector getInjector() {
		// TODO: Provide a sharedDomainModule via DomainRegistry to allow
		// overriding of generic bindings
		return Guice.createInjector(new SharedStateModule(), new SCTXtextIntegrationModule());
	}

}