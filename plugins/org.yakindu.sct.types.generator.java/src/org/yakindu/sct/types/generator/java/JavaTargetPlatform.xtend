/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package com.yakindu.sct.types.slang.generator.java

import com.google.common.collect.Maps
import com.google.inject.Singleton
import com.yakindu.sct.types.slang.generator.core.AbstractTargetPlatform
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.java.Keywords

@Singleton
class JavaTargetPlatform extends AbstractTargetPlatform {
	public static final String FILE_ENDING = ".java"

	override protected createTypes() {
		replacementTypes = Maps.newHashMap
		replacementTypes.put(getSlangType(ITypeSystem.INTEGER), createIntType)
		replacementTypes.put(getSlangType(ITypeSystem.BOOLEAN), createBooleanType)
		replacementTypes.put(getSlangType(ITypeSystem.REAL), createDoubleType)
		replacementTypes.put(getSlangType(ITypeSystem.STRING), createStringType)
	}

	def protected createLongType() {
		factory.createPrimitiveType => [
			name = "long"
		]
	}

	def protected createIntType() {
		factory.createPrimitiveType => [
			name = "int"
		]
	}

	def protected createBooleanType() {
		factory.createPrimitiveType => [
			name = "boolean"
		]
	}

	def protected createDoubleType() {
		factory.createPrimitiveType => [
			name = "double"
		]
	}

	def protected createStringType() {
		factory.createPrimitiveType => [
			name = "String"
		]
	}

	override getLanguageKeywords() {
		return Keywords.JAVA_KEYWORD_SET;
	}

}
