package org.yakindu.sct.generator.c.submodules

import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.FlowCode
import java.util.List
import org.yakindu.base.types.annotations.VisibilityAnnotations

class MethodGenerator {

	@Inject protected extension VisibilityAnnotations
	@Inject protected extension INamingService
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension Naming
	
	@Inject protected extension FlowCode


	 def implementation(List<Method> methods) '''
	 	«FOR m : methods»
	 		«m.implementation»
	 	«ENDFOR»
	 '''
	
	def implementation(Method it) '''
		«implementationModifier»«typeSpecifier.targetLanguageName» «shortName»(«scHandleDecl»«FOR p : parameters BEFORE ', ' SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR») {
			«body.code»
			«IF !body.requiresHandles»
				«unusedParam(scHandle)»
			«ENDIF»
		}
	 '''
	
	def implementationModifier(Method it) {
		if (it.isPublic)
			''''''
		else 
			'''static '''
	}
}