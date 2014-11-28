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
package org.yakindu.sct.model.stext.test.util;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.DefaultTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextRuntimeTestModule extends STextRuntimeModule {

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return STextTestScopeProvider.class;
	}
	
	@Override
	public Class<? extends ITypeSystem> bindITypeSystem() {
		return DefaultTypeSystem.class;
	}
	
	@Override
	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer.class;
	}
	
}
