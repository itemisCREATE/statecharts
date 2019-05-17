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
package org.yakindu.sct.types.generator.java.modifications

import java.util.Collection
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.types.modification.IModification

class SCTUnitModification implements IModification {
	
	val ANNOTATION_SCTUNIT_TEST = "com.yakindu.sctunit.Test"
	
	val junitAnnotation = TypesFactory.eINSTANCE.createAnnotationType => [
			name = "org.junit.Test"
		]
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.addJunitImport()
		p.createTestAnnotations()
		p.replaceMethodCalls()
		p
	}
	
	def void replaceMethodCalls(Package p){
		val operationCalls = p.eAllContents.filter(ElementReferenceExpression).filter[reference instanceof Operation]
		operationCalls.forEach[]
	}
	
	protected def void createTestAnnotations(Package p) {
		val operations = p.eAllContents.filter(Operation).filter[it.getAnnotationOfType(ANNOTATION_SCTUNIT_TEST) !== null]
		operations.forEach[
			val annotation = it.getAnnotationOfType(ANNOTATION_SCTUNIT_TEST)
			annotation.type = junitAnnotation
		]
	}
	
	def void addJunitImport(Package p){
		if(p.imports.contains("com.yakindu.sctunit")){
			p.imports.remove("com.yakindu.sctunit")
			p.imports.add("org.junit.*");
		}
	}
	
}
