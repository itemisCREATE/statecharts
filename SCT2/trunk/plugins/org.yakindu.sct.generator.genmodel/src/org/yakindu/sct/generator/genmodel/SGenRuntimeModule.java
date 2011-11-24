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
package org.yakindu.sct.generator.genmodel;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.SimpleNameProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.yakindu.sct.generator.genmodel.resource.XBaseInterpreterResource;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class SGenRuntimeModule extends
		org.yakindu.sct.generator.genmodel.AbstractSGenRuntimeModule {

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SimpleNameProvider.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return XBaseInterpreterResource.class;
	}

}
