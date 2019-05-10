/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.types.generator.java

import com.google.common.collect.Maps
import com.google.inject.Singleton
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.AbstractTargetPlatform

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
