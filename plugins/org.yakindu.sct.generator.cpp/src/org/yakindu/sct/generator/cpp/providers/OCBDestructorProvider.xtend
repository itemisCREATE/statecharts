package org.yakindu.sct.generator.cpp.providers

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.StatechartScope

class OCBDestructorProvider implements IDeclarationProvider {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension INamingService
	@Inject protected extension StatechartExtensions
	@Inject protected extension ExpressionsChecker
	
	@Inject protected GeneratorEntry entry
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«IF !entry.useStaticOPC»
			«scopes.filter(StatechartScope).map[createInlineOCBDestructor].filter[!nullOrEmpty].join("\n")»
		«ENDIF»
		'''
	}
	
	def String createInlineOCBDestructor(StatechartScope it) {
		if (hasOperations) {
			return '''inline «flow.module»::«interfaceOCBName»::~«interfaceOCBName»() {}'''
		}
		return ""
	}
	
}