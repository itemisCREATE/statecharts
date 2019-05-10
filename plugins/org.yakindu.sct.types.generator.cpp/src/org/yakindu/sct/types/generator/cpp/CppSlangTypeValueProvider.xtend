/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp

import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Type
import org.yakindu.sct.types.generator.c.typesystem.CTypeValueProvider

class CppSlangTypeValueProvider extends CTypeValueProvider {

	override defaultValue(Type type) {
		if (type instanceof ComplexType) {
			return null
		}
		super.defaultValue(type)
	}

}
