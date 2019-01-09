/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class TimingFunctions {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	
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