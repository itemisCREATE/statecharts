/** 
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.Constants
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.linking.ILinker
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider
import org.eclipse.xtext.linking.ILinkingService
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.serializer.sequencer.ITransientValueService
import org.eclipse.xtext.validation.CompositeEValidator
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper
import org.yakindu.base.expressions.linking.LinkingDiagnosticMessageProvider
import org.yakindu.base.expressions.linking.OperationOverloadingLinkingService
import org.yakindu.base.expressions.parser.SyntaxErrorMessageProvider
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.resource.SCTLinker
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.resource.SCTResourceDescriptionStrategy
import org.yakindu.sct.model.stext.resource.StextResource
import org.yakindu.sct.model.stext.scoping.STextGlobalScopeProvider
import org.yakindu.sct.model.stext.scoping.StextImportAwareScopeProvider
import org.yakindu.sct.model.stext.serialization.STextTransientValueService
import org.yakindu.sct.model.stext.serializer.SCTSerializer
import org.yakindu.sct.model.stext.terminals.STextValueConverterService
import org.yakindu.sct.model.stext.validation.STextNamesAreUniqueValidationHelper

/** 
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 * @author andreas muelder
 * @author axel terfloth
 */
@SuppressWarnings("restriction") class STextRuntimeModule extends AbstractSTextRuntimeModule {
	override void configure(Binder binder) {
		super.configure(binder)
		binder.bind(IDefaultResourceDescriptionStrategy).to(SCTResourceDescriptionStrategy)
		// https://github.com/Yakindu/statecharts/issues/1199
		binder.bind(IReferableElementsUnloader).to(IReferableElementsUnloader.NullUnloader)
		binder.bind(ITransientValueService).to(STextTransientValueService)
		binder.bind(ILinkingDiagnosticMessageProvider).to(LinkingDiagnosticMessageProvider)
		binder.bind(ISyntaxErrorMessageProvider).to(SyntaxErrorMessageProvider)
	}

	def Class<? extends INamesAreUniqueValidationHelper> bindNamesAreUniqueValidationHelper() {
		return STextNamesAreUniqueValidationHelper
	}

	override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return STextGlobalScopeProvider
	}

	override Class<? extends ILinker> bindILinker() {
		return SCTLinker
	}

	def Class<? extends Resource> bindResource() {
		return StextResource
	}

	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider
	}

	override Class<? extends IValueConverterService> bindIValueConverterService() {
		return STextValueConverterService
	}

	override void configureFileExtensions(Binder binder) {
		binder.bind(String).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("stext,sct")
	}

	override void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider).annotatedWith(
			Names.named(
				AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(
			StextImportAwareScopeProvider)
		binder.bind(ITypeSystem).toInstance(getTypeSystem())
		binder.bind(boolean).annotatedWith(Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false)
	}

	def protected ITypeSystem getTypeSystem() {
		return GenericTypeSystem.getInstance()
	}

	def Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer
	}

	override Class<? extends ILinkingService> bindILinkingService() {
		return OperationOverloadingLinkingService
	}

	override Class<? extends ISerializer> bindISerializer() {
		return SCTSerializer
	}
}
