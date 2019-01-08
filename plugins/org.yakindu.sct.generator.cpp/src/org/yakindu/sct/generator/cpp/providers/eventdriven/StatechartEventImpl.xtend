package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.providers.ISourceProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class StatechartEventImpl implements ISourceProvider {
	@Inject protected extension EventDrivenPredicate
	
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
	@Inject extension EventNaming eventNaming
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«IF needsNextEventFunction»
		«nextEventFunction»
		
		«ENDIF»
		«IF needsDispatchEventFunction»
		«generateInternalDispatchEventFunction»
		
		«generateInterfaceDispatchFunctions»
		«ENDIF»
		'''
	}
	
	def getNextEventFunction(ExecutionFlow it) {
		val nE = "nextEvent"
		'''
		«SCT_EVENT»* «module»::«nextEventFctID»()
		{
			«SCT_EVENT»* «nE» = 0;
			
			if(!«internalQueue».empty()) {
				«nE» = «internalQueue».front();
				«internalQueue».pop_front();
			}
			
			return «nE»;
		}
		'''
	}	
	
	def generateInterfaceDispatchFunctions(ExecutionFlow it) {
		'''
		«FOR s : statechartScopes»
		«generateInterfaceDispatchFunction(s)»
		«ENDFOR»
		'''
	}

	def dispatch generateInterfaceDispatchFunction(ExecutionFlow it, ImportScope s) {}

	def dispatch generateInterfaceDispatchFunction(ExecutionFlow it, Scope s) {
		val ev = "event"
		'''
			void «module»::«s.interfaceName»::«dispatchEventFctID»(«SCT_EVENT» * «ev»)
			{
				switch(«ev»->name)
				{
					«FOR e : s.localEvents»
						case «e.eventEnumMemberName»:
						{
							«IF e.hasValue»
								«e.eventClassName» * e = static_cast<«e.eventClassName»*>(«ev»);
								if(e != 0) {
									internal_«e.asRaiser»(e->value);
								}
							«ELSE»
								internal_«e.asRaiser»();
							«ENDIF»
							break;
						}
					«ENDFOR»
					default:
						break;
				}
			}
			'''
	}

	def generateInternalDispatchEventFunction(ExecutionFlow it) {
		val ev = "event"
		'''	
			void «module»::«dispatchEventFctID»(«SCT_EVENT» * «ev»)
			{
				if(«ev» == 0) {
					return;
				}
				switch(«ev»->name)
				{
					«FOR s : scopes.filter(StatechartScope)»
						«IF !(s instanceof ImportScope)»
							«val localEvents = s.declarations.filter(EventDefinition).filter[direction == Direction.LOCAL]»
							«IF localEvents.size > 0»
								«FOR e : localEvents»
									case «e.eventEnumMemberName»:
								«ENDFOR»
								{
									«s.instance».«dispatchEventFctID»(«ev»);
									break;
								}
							«ENDIF»
						«ENDIF»
					«ENDFOR»
					default:
						break;
				}
			}
		'''
	}
	
}