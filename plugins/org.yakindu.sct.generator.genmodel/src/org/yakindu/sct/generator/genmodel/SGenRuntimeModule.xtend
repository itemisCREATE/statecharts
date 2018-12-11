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
import org.yakindu.base.expressions.linking.LinkingDiagnosticMessageProvider
import org.yakindu.base.expressions.parser.SyntaxErrorMessageProvider
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.genmodel.naming.GenModelQualifiedNameProvider
import org.yakindu.sct.generator.genmodel.scoping.SGenGlobalScopeProvider
import org.yakindu.sct.generator.genmodel.serializer.SGenCrossReferenceSerializer
import org.yakindu.sct.generator.genmodel.typesystem.SGenTypeInferrer

class SGenRuntimeModule extends AbstractSGenRuntimeModule {

	def bindILinkingDiagnosticMessageProvider() {
		LinkingDiagnosticMessageProvider
	}

	def configureITypeSystem(Binder binder) {
		binder.bind(ITypeSystem).toInstance(GenericTypeSystem.getInstance())
	}

	def bindISyntaxErrorMessageProvider() {
		SyntaxErrorMessageProvider
	}

	def bindITypeSystemInferrer() {
		SGenTypeInferrer
	}

	override bindIQualifiedNameProvider() {
		GenModelQualifiedNameProvider
	}

	def bindICrossReferenceSerializer() {
		SGenCrossReferenceSerializer
	}

	override bindIGlobalScopeProvider() {
		SGenGlobalScopeProvider
	}
}
