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
