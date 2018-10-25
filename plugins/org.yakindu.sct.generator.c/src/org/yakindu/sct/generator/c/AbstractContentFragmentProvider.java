/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c;

import org.yakindu.sct.generator.core.extensions.AnnotationExtensions;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public abstract class AbstractContentFragmentProvider<T> implements Provider<T> {
	@Inject
	protected Injector injector;
	@Inject
	protected AnnotationExtensions annotationExtensions;

	protected boolean isEventDriven() {
		GeneratorEntry entry = injector.getInstance(GeneratorEntry.class);
		return annotationExtensions.isEventDriven(entry);
	}
}
