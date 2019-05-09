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
package org.yakindu.sct.types.generator.c.extensions

import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypedElement
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystem

class PointerExtensions {
	protected CTypeSystem cts = CTypeSystem.instance
	
	def isPointer(TypedElement element) {
		element.type.isPointerType
	}
	
	def isPointerType(Type type) {
		cts.isSame(type, getPointerType)
	}
	
	def getPointerType() {
		cts.getType(CTypeSystem.POINTER)
	}
	
	def TypeSpecifier pointerTarget(TypedElement it) {
		if(!isPointer) {
			return null
		}
		typeSpecifier.typeArguments.head
	}
}
