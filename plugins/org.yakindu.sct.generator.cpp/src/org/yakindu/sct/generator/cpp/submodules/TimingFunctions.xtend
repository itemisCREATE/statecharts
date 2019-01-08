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

import static org.eclipse.xtext.util.Strings.*
import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class TimingFunctions {
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
	
	def timedStatemachineFunctions(ExecutionFlow it) '''
		«IF timed»
			
			void «module»::«SET_TIMER»(«timerInterface»* timerInterface)
			{
				this->«timerInstance» = timerInterface;
			}
			
			«timerInterface»* «module»::«GET_TIMER»()
			{
				return «timerInstance»;
			}
			
			«INT_TYPE» «module»::«numTimeEventsFctID»() {
				return «timeEventsCountparallelConst»;
			}
			
			«raiseTimeEventFunction»
		«ENDIF»
	'''
	
	def raiseTimeEventFunction(ExecutionFlow it) '''
		void «module»::«raiseTimeEventFctID»(«EVENT_TYPE» evid)
		{
			if ((evid >= («EVENT_TYPE»)«timeEventsInstance») && (evid < («EVENT_TYPE»)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(«BOOL_TYPE»*)evid = true;
			}				
		}
	'''
	
	def timedStatemachineFunctionPrototypes(ExecutionFlow it) '''
		/*
		 * Functions inherited from TimedStatemachineInterface
		 */
		virtual void «SET_TIMER»(«timerInterface»* timerInterface);
		
		virtual «timerInterface»* getTimer();
		
		virtual void «raiseTimeEventFctID»(«EVENT_TYPE» event);
		
		virtual «INT_TYPE» «numTimeEventsFctID»();
	'''
}