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
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
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
import org.yakindu.sct.model.stext.formatting.STextFormatter
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider

/** 
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 * @author andreas muelder
 * @author axel terfloth
 */
class STextRuntimeModule extends AbstractSTextRuntimeModule {

	@SuppressWarnings("restriction")
	def Class<? extends ITransientValueService> bindITransientValueServiceSerializer() {
		STextTransientValueService
	}

	def Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		SCTResourceDescriptionStrategy
	}

	def configureEObjectValidator(Binder binder) {
		binder.bind(boolean).annotatedWith(Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false)
	}

	def configureITypeSystem(Binder binder) {
		binder.bind(ITypeSystem).toInstance(GenericTypeSystem.getInstance())
	}

	def Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		SyntaxErrorMessageProvider
	}

	def Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		LinkingDiagnosticMessageProvider
	}

	// https://github.com/Yakindu/statecharts/issues/1199
	def Class<? extends IReferableElementsUnloader> bindIReferableElementsUnloader() {
		IReferableElementsUnloader.NullUnloader
	}

	def Class<? extends INamesAreUniqueValidationHelper> bindNamesAreUniqueValidationHelper() {
		STextNamesAreUniqueValidationHelper
	}

	override bindIGlobalScopeProvider() {
		STextGlobalScopeProvider
	}

	override bindILinker() {
		SCTLinker
	}

	def Class<? extends Resource> bindResource() {
		StextResource
	}

	override bindIQualifiedNameProvider() {
		StextNameProvider
	}

	override bindIValueConverterService() {
		STextValueConverterService
	}

	override configureFileExtensions(Binder binder) {
		binder.bind(String).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("stext,sct")
	}

	override configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(
			StextImportAwareScopeProvider)
	}

	def Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		STextTypeInferrer
	}

	override bindILinkingService() {
		OperationOverloadingLinkingService
	}

	override bindISerializer() {
		SCTSerializer
	}
	
	override bindIFormatter() {
		STextFormatter
	}
	
}
