package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

@Singleton
class JavaCommons {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension ICodegenTypeSystemAccess
	
	def getIllegalAccessValidation(EventDefinition it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value access. Event «name.asEscapedName» is not raised!");
	'''
	
	def fieldDeclaration(VariableDefinition variable) {
		'''private «variable.typeSpecifier.targetLanguageName» «variable.identifier»;

		'''
	}
}