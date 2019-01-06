/**
 * Copyright (c) 2019 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	itemis AG - initial API and implementation
 *
 */
package org.yakindu.sct.model.sexec.validation;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.impl.ExecutionFlowImpl;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.validation.STextValidator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class SExecRuntimeModule extends STextRuntimeModule {

	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(Boolean.class).annotatedWith(Names.named(IModelSequencer.ADD_TRACES)).toInstance(Boolean.TRUE);
		binder.bind(ITypeSystem.class).toInstance(getTypeSystem());
		binder.bind(IQualifiedNameProvider.class).to(StextNameProvider.class);
	}

	@Override
	@SingletonBinding(eager = true)
	public Class<? extends STextValidator> bindSTextValidator() {
		return SExecValidator.class;
	}

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider.class;
	}

	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer.class;
	}

	protected ITypeSystem getTypeSystem() {
		return GenericTypeSystem.getInstance();
	}

}
