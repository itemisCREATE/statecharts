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

class TracingFunctions {
	@Inject protected extension CppNaming
	
	def tracedStatemachineFunctions(ExecutionFlow it)
		'''
		void set«traceObserverModule»(«YSCNamespace»::«traceObserverModule»<«statesEnumType»>* tracingcallback);
		
		«YSCNamespace»::«traceObserverModule»<«statesEnumType»>* get«traceObserverModule»();
	'''
}