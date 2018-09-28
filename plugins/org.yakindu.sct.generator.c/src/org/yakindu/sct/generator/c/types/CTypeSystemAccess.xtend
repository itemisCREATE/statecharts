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
package org.yakindu.sct.generator.c.types

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.PrimitiveType
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

import static org.yakindu.base.types.typesystem.ITypeSystem.*

/**
 * @author andreas muelder
 */
class CTypeSystemAccess implements ICodegenTypeSystemAccess {

	@Inject protected extension ITypeSystem
	
	protected static val String ARRAY = "array"
	protected static val String POINTER = "pointer"
	
	override getTargetLanguageName(Type type) {
		val originalType = type?.originType
		switch (originalType) {
			case originalType === null || isSame(originalType, getType(VOID)) : 'void'
			case isSame(originalType, getType(INTEGER)): 'sc_integer'
			case isSame(originalType, getType(REAL)): 'sc_real'
			case isSame(originalType, getType(BOOLEAN)): 'sc_boolean'
			case isSame(originalType, getType(STRING)): 'sc_string'
			default: type.name
		}
	}
	
	override getTargetLanguageName(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}
	
	def protected String buildName(Type type) {
		val names = new ArrayList<String>()
		getParentPackages(type, names)
		var name = ""
		for(var i = 1; i < names.size; i++) {
			name += names.get(i) + "::"
		}
		return name + type.name
	}

	protected def printVoidType() {
		'void'
	}

	protected def printBuiltInType(TypeSpecifier typeSpecifier) {
		if (typeSpecifier.type.name == POINTER) {
			return '''«getTargetLanguageName(typeSpecifier.typeArguments.head)» *'''
		} else if (typeSpecifier.type.name == ARRAY) {
			// TODO Array brackets after variable name
			return '''«typeSpecifier.typeArguments.head.type.name»'''
		}
	}

	protected def printType(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}
	
	protected def void getParentPackages(EObject eo, List<String> names) {
		if(eo instanceof Package) {
			names.add(0, eo.name)
		}
		if(eo.eContainer === null) {
			return
		}
		getParentPackages(eo.eContainer, names)
	}
	
	protected def String printQualifiedTypeName(EObject type) {
		if(type instanceof PrimitiveType) {
			type.name
		}
		if(type.eContainer === null) {
			return ""
		}
		if(type instanceof Package) {
			return printQualifiedTypeName(type.eContainer) + type.name + "::"
		}
		if(type instanceof Type) {
			return printQualifiedTypeName(type.eContainer) + type.name
		}
		return printQualifiedTypeName(type.eContainer)
	}

}
