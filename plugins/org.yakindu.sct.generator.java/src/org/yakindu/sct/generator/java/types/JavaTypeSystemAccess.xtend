/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.types

import com.google.inject.Inject
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

import static org.yakindu.base.types.typesystem.ITypeSystem.*
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.core.multism.MultiStatemachineHelper
import org.yakindu.base.types.ComplexType

/**
 * @author andreas muelder
 */
class JavaTypeSystemAccess implements ICodegenTypeSystemAccess {

	@Inject
	protected extension ITypeSystem ts
	
	@Inject
	protected extension Naming
	
	@Inject
	protected extension MultiStatemachineHelper

	override String getTargetLanguageName(Type type) {
		val originalType = type?.originType

		// multi SM
		if (originalType instanceof ComplexType) {
			if (originalType.isStatechartType) {
				return originalType.executionFlow.statemachineClassName
			}
		}

		switch (originalType) {
			case originalType === null || ts.isSame(originalType, getType(VOID)) : 'void'
			case ts.isReal(originalType): "double"
			case ts.isInteger(originalType): "long"
			case ts.isBoolean(originalType): "boolean"
			case ts.isString(originalType): "String"
			
			
			default: "//" + this
		};
	}
	
	override getTargetLanguageName(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}
}
