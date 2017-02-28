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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.validation.CompositeEValidator;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.resource.SCTLinker;
import org.yakindu.sct.model.stext.conversion.StextValueConverterService;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.resource.SCTResourceDescriptionStrategy;
import org.yakindu.sct.model.stext.resource.StextResource;
import org.yakindu.sct.model.stext.scoping.STextGlobalScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 * 
 * @author andreas muelder
 * @author axel terfloth
 */
public class STextRuntimeModule extends org.yakindu.sct.model.stext.AbstractSTextRuntimeModule {

	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IDefaultResourceDescriptionStrategy.class).to(SCTResourceDescriptionStrategy.class);
		//https://github.com/Yakindu/statecharts/issues/1199
		binder.bind(IReferableElementsUnloader.class).to(IReferableElementsUnloader.NullUnloader.class);
	}
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return STextGlobalScopeProvider.class;
	}

	@Override
	public Class<? extends ILinker> bindILinker() {
		return SCTLinker.class;
	}

	public Class<? extends Resource> bindResource() {
		return StextResource.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return StextValueConverterService.class;
	}


	public void configureFileExtensions(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("stext,sct");
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(com.google.inject.name.Names
						.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(org.yakindu.sct.model.stext.scoping.StextImportAwareScopeProvider.class);
		binder.bind(ITypeSystem.class).toInstance(getTypeSystem());
		binder.bind(boolean.class).annotatedWith(
				Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false);
	}
	
	protected ITypeSystem getTypeSystem() {
		return GenericTypeSystem.getInstance();
	}
	
	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer.class;
	}

}
