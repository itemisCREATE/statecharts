/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c

import com.google.common.collect.Maps
import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.AbstractTargetPlatform
import org.yakindu.sct.types.generator.ITargetPlatform
import org.yakindu.sct.types.generator.c.files.CTypes

@Singleton
class CTargetPlatform extends AbstractTargetPlatform implements ITargetPlatform {
	@Inject protected extension CTypes

	override protected createTypes() {
		replacementTypes = Maps.newHashMap
		replacementTypes.put(delegatingTs.getType(ITypeSystem.INTEGER), createScInteger)
		replacementTypes.put(delegatingTs.getType(ITypeSystem.BOOLEAN), createScBoolean)
		replacementTypes.put(delegatingTs.getType(ITypeSystem.REAL), createScReal)
		replacementTypes.put(delegatingTs.getType(ITypeSystem.STRING), createScString)
	}
	
	public static final String SOURCE_FILE_ENDING = ".c"
	public static final String HEADER_FILE_ENDING = ".h"

	def protected createScBoolean() {
		factory.createPrimitiveType => [
			name = "sc_boolean"
		]
	}

	def protected createScInteger() {
		factory.createPrimitiveType => [
			name = "sc_integer"
		]
	}

	def protected createScReal() {
		factory.createPrimitiveType => [
			name = "sc_real"
		]
	}

	def protected createScString() {
		factory.createPrimitiveType => [
			name = "sc_string"
		]
	}

	override getLanguageKeywords() {
		return CKeywords.C_KEYWORDS.toSet
	}
}
