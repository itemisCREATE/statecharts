package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.StatechartScope

class InterfaceFunctions {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension CppExpressionsGenerator
	@Inject protected extension StateVectorExtensions
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	
	@Inject protected GeneratorEntry entry
	
	def interfaceFunctions(ExecutionFlow it) '''
		«FOR scope : statechartScopes»
			«IF scope instanceof InterfaceScope»
			«module»::«scope.interfaceName»* «module»::get«scope.interfaceName»()
			{
				return &«scope.instance»;
			}
			«ENDIF»
			«generateEvents(scope)»
			«generateVariables(scope)»
			«IF scope.hasOperations && !entry.useStaticOPC»
				«scope.OCB_InterfaceSetterDeclaration(true)»
				{
					«scope.OCB_Instance» = operationCallback;
				}
			«ENDIF»
		«ENDFOR»
		«IF entry.tracingUsed»
		
		void «module»::set«traceObserverModule»(«YSCNamespace»::«traceObserverModule»<«statesEnumType»>* tracingcallback) {
			«tracingInstance» = tracingcallback;
		}
		
		«YSCNamespace»::«traceObserverModule»<«module»::«statesEnumType»>* «module»::get«traceObserverModule»() {
			return «tracingInstance»;
		}
		«ENDIF»
	'''
	
	def generateVariables(ExecutionFlow it, StatechartScope scope)
		'''
			«FOR variable : scope.variableDefinitions»
				«IF variable.isConstString»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «module»::«scope.interfaceName»::«variable.asGetter»() const
				{
					return «variable.localAccess»;
				}
				
				«IF scope.defaultInterface»
					«IF variable.isConstString»const «ENDIF»«variable.typeSpecifier.targetLanguageName» «module»::«variable.asGetter»() const
					{
						return «variable.access»;
					}
					
				«ENDIF»
				«IF !variable.readonly && !variable.const»
					void «module»::«scope.interfaceName»::«variable.asSetter»(«variable.typeSpecifier.targetLanguageName» value)
					{
						«variable.localAccess» = value;
					}
					
					«IF scope.defaultInterface»
						void «module»::«variable.asSetter»(«variable.typeSpecifier.targetLanguageName» value)
						{
							«variable.access» = value;
						}
						
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
}