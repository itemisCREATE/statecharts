/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.scoping;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Singleton;

/**
 * Introduced because it is currently impossible to pass the resource set instance created
 * for headless execution to the {@link URI2ResourceDescriptionCache} by
 * current injection structure. Another resource set instance leads into impossibility to load
 * {@link CHeaderResource}s representing a system include (headers outside the
 * physical workspace location).
 * 
 * @author Johannes Dicks
 *
 */
@Singleton
public class HeadlessURI2ResourceDescriptionCache extends URI2ResourceDescriptionCache {

	// FIXME get rid of this...
	public static ResourceSet theOneAndOnlyResourceSet;

	@Override
	protected ResourceSet getResourceSet() {
		return theOneAndOnlyResourceSet;
	}
}
