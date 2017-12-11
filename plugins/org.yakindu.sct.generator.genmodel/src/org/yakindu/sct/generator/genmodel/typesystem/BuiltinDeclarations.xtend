/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.typesystem

import com.google.inject.Inject
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.typesystem.AbstractTypeSystem

/**
 * @author rbeckmann
 * 
 */
class BuiltinDeclarations implements BuiltinDeclarationNames {

	extension TypesFactory factory = TypesFactory.eINSTANCE
	@Inject ITypeSystem typesystem

	def getDeclarations() {
		val declarations = #[
			SCT_VERSION_VAR,
			TIMESTAMP_VAR
		].map [ decl |
			createProperty => [
				name = decl
				typeSpecifier = createTypeSpecifier => [
					type = typesystem.getType(ITypeSystem.STRING)
				]
			]
		]
		declarations.forEach[(typesystem as AbstractTypeSystem).resource.contents += it]
		declarations
	}

}
