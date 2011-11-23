/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * Copied from
 * org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory
 * because it is needed without ui dependency.
 * 
 * {@link https://bugs.eclipse.org/bugs/show_bug.cgi?id=364323}
 * 
 * @author Benjamin Schwertfeger
 * 
 */
public class SGraphExecutableExtensionFactory extends
		AbstractGuiceAwareExecutableExtensionFactory {

	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected Injector getInjector() {
		return Activator.getDefault().getInjector();
	}
}
