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
package org.yakindu.sct.model.stext;

import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.impl.BaseTypeSystemAccessImpl;
import org.yakindu.sct.model.sgraph.resource.SCTLinker;
import org.yakindu.sct.model.stext.conversion.StextValueConverterService;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.scoping.STextGlobalScopeProvider;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;
import org.yakindu.sct.model.stext.validation.TypeInferrer;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 * 
 * @author andreas muelder
 * @author axel terfloth
 */
public class STextRuntimeModule extends
		org.yakindu.sct.model.stext.AbstractSTextRuntimeModule {

	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return STextGlobalScopeProvider.class;
	}

	@Override
	public Class<? extends ILinker> bindILinker() {
		return SCTLinker.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return StextValueConverterService.class;
	}

	public Class<? extends ITypeSystemAccess> bindITypeSystemAccess() {
		return BaseTypeSystemAccessImpl.class;
	}

	public Class<? extends ITypeInferrer> bindITypeInferrer() {
		return TypeInferrer.class;
	}

}
