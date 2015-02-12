/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.resource;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Injector;

public class SCTExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return STextActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		// TODO: Remove dependency to SText here, provide resourceProvider
		// extension somewhere else....
		return STextActivator.getInstance().getInjector(STextActivator.ORG_YAKINDU_SCT_MODEL_STEXT_STEXT);
	}

}
