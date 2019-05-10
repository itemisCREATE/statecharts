/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp

import com.google.common.collect.Maps
import com.google.inject.Singleton
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.AbstractTargetPlatform
import org.yakindu.sct.types.generator.ITargetPlatform
import org.yakindu.sct.types.generator.c.CKeywords

@Singleton
class CppTargetPlatform extends AbstractTargetPlatform implements ITargetPlatform {
	override protected createTypes() {
		replacementTypes = Maps.newHashMap
		replacementTypes.put(delegatingTs.getType(ITypeSystem.INTEGER), createScInteger)
		replacementTypes.put(delegatingTs.getType(ITypeSystem.BOOLEAN), createScBoolean)
		replacementTypes.put(delegatingTs.getType(ITypeSystem.REAL), createScReal)
		replacementTypes.put(delegatingTs.getType(ITypeSystem.STRING), createScString)
	}

	public static final String SOURCE_FILE_ENDING = ".cpp"
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
