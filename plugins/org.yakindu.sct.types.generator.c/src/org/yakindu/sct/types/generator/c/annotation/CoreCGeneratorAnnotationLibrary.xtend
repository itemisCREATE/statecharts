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
package org.yakindu.sct.types.generator.c.annotation

import com.google.inject.Inject
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.IntLiteral

class CoreCGeneratorAnnotationLibrary extends CoreGeneratorAnnotationLibrary implements CoreCGeneratorAnnotationConstants {
	@Inject protected ITypeSystem ts
	
	def defineAnnotation() {
		annotation(DEFINE)
	}

	def isDefine(AnnotatableElement it) {
		isAnnotatedWith(DEFINE)
	}
	
	def AnnotationType rootTypeAnnotation() {
		annotation(ROOT_TYPE)
	}
	
	def isRootType(AnnotatableElement it) {
		isAnnotatedWith(ROOT_TYPE)
	}
	
	def AnnotationType immutableTypeAnnotation() {
		annotation(IMMUTABLE)
	}
	
	def isImmutable(AnnotatableElement it) {
		isAnnotatedWith(IMMUTABLE)
	}
	
	def setRootType(AnnotatableElement it, Type rootType) {
		if(rootType === null) {
			return
		}
		if(!isRootType) {
			it._annotateWith(rootTypeAnnotation)
		}
		val _annotation = getAnnotationOfType(ROOT_TYPE)
		_annotation.arguments += _variable("root", rootType)
	}
	
	def getRootType(AnnotatableElement it) {
		val _annotation = getAnnotationOfType(ROOT_TYPE)
		val prop = _annotation?.arguments?.head
		if(prop instanceof Property) {
			return prop.type
		}
		return null
	}
	
	def arraySizeAnnotation() {
		annotation(ARRAY_SIZE)
	}
	
	def isArraySize(AnnotatableElement it) {
		isAnnotatedWith(ARRAY_SIZE)
	}
	
	def setArraySize(AnnotatableElement it, int size) {
		if(!isArraySize) {
			_annotateWith(arraySizeAnnotation)
		}
		
		val _annotation = getAnnotationOfType(ARRAY_SIZE)
		_annotation.arguments += primitiveLiteral(size)
	}
	
	def getArraySize(AnnotatableElement it) {
		val _annotation = getAnnotationOfType(ARRAY_SIZE)
		val prop = _annotation?.arguments?.head
		if(prop instanceof PrimitiveValueExpression) {
			return (prop.value as IntLiteral).value
		}
		null
	}
	
	
	
}
