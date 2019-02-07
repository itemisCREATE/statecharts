/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer
import org.yakindu.base.expressions.linking.LinkingDiagnosticMessageProvider
import org.yakindu.base.expressions.linking.OperationOverloadingLinkingService
import org.yakindu.base.expressions.parser.SyntaxErrorMessageProvider
import org.yakindu.base.expressions.scoping.ExpressionsImportAwareScopeProvider
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem

class ExpressionsRuntimeModule extends AbstractExpressionsRuntimeModule {

	def configureITypeSystem(Binder binder) {
		binder.bind(ITypeSystem).toInstance(GenericTypeSystem.getInstance())
	}

	def Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		LinkingDiagnosticMessageProvider
	}

	def Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		SyntaxErrorMessageProvider
	}

	def Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return ExpressionsTypeInferrer
	}

	override configureIScopeProviderDelegate(Binder binder) {
		binder.<IScopeProvider>bind(IScopeProvider).annotatedWith(
			Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(ExpressionsImportAwareScopeProvider);
	}
	
	override bindILinkingService() {
		OperationOverloadingLinkingService
	}

}
