/** 
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel

import com.google.inject.Binder
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer
import org.yakindu.base.expressions.linking.LinkingDiagnosticMessageProvider
import org.yakindu.base.expressions.parser.SyntaxErrorMessageProvider
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.genmodel.formatting.SGenFormatter
import org.yakindu.sct.generator.genmodel.naming.GenModelQualifiedNameProvider
import org.yakindu.sct.generator.genmodel.scoping.SGenGlobalScopeProvider
import org.yakindu.sct.generator.genmodel.serializer.SGenCrossReferenceSerializer
import org.yakindu.sct.generator.genmodel.typesystem.SGenTypeInferrer
import org.yakindu.sct.generator.genmodel.valueconverter.SGenValueConverter

class SGenRuntimeModule extends AbstractSGenRuntimeModule {

	def Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		LinkingDiagnosticMessageProvider
	}

	def configureITypeSystem(Binder binder) {
		binder.bind(ITypeSystem).toInstance(GenericTypeSystem.getInstance())
	}

	def Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		SyntaxErrorMessageProvider
	}

	def Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return SGenTypeInferrer
	}

	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return GenModelQualifiedNameProvider
	}

	def Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return SGenCrossReferenceSerializer
	}

	override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return SGenGlobalScopeProvider
	}
	
	override bindIValueConverterService() {
		SGenValueConverter
	}
	
	override bindIFormatter() {
		SGenFormatter
	}
	
}
