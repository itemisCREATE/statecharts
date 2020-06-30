/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import org.yakindu.base.types.annotations.VisibilityAnnotations
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.FlowCode
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.generator.java.features.Synchronized

/**
 * 
 * @author Thomas Kutz
 */
class MethodGenerator {

	@Inject extension VisibilityAnnotations
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension INamingService
	@Inject extension FlowCode
	@Inject extension Synchronized
	

	def toImplementation(Iterable<Method> methods) '''
		«FOR m : methods»
			«m.toImplementation»
			
		«ENDFOR»
	'''
	
	def toImplementation(Method it) '''
		«methodModifier»«typeSpecifier.targetLanguageName» «shortName»(«FOR p : parameters SEPARATOR ', '»«IF p.varArgs»...«ELSE»«p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR») {
			«body.code»
		}
	'''
	
	protected def methodModifier(Method it) {
		if (isPublic)
			'''public «sync»'''
		else 
			'''private '''
	}
}
