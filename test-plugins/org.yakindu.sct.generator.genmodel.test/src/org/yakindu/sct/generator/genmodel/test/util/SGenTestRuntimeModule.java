/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.test.util;

import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.yakindu.sct.generator.genmodel.SGenRuntimeModule;
import org.yakindu.sct.generator.genmodel.ui.help.SGenUserHelpDocumentationProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenTestRuntimeModule extends SGenRuntimeModule {

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return SGenTestScopeProvider.class;
	}
	
	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return SGenUserHelpDocumentationProvider.class;
	}
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return Linker.class;
	}
}
