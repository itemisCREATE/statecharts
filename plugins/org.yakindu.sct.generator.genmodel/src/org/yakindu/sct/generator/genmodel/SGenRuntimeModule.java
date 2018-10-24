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

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.yakindu.base.expressions.linking.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.generator.genmodel.naming.GenModelQualifiedNameProvider;
import org.yakindu.sct.generator.genmodel.scoping.SGenGlobalScopeProvider;
import org.yakindu.sct.generator.genmodel.serializer.SGenCrossReferenceSerializer;
import org.yakindu.sct.generator.genmodel.typesystem.SGenTypeInferrer;

import com.google.inject.Binder;

@SuppressWarnings("restriction")
public class SGenRuntimeModule extends org.yakindu.sct.generator.genmodel.AbstractSGenRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(ILinkingDiagnosticMessageProvider.class).to(LinkingDiagnosticMessageProvider.class);
		binder.bind(ITypeSystem.class).toInstance(getTypeSystem());
	}

	protected ITypeSystem getTypeSystem() {
		return GenericTypeSystem.getInstance();
	}

	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return SGenTypeInferrer.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return GenModelQualifiedNameProvider.class;
	}

	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return SGenCrossReferenceSerializer.class;
	}
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return SGenGlobalScopeProvider.class;
	};
}
