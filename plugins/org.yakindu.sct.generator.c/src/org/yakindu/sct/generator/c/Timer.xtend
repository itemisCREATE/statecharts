package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart

class Timer {
	
	@Inject extension Naming
	
	def generateTimerH(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa) {
		 fsa.generateFile(flow.timerModule.h, flow.timerHContent)
	}
	
	def generateTimerC(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa) {
		 fsa.generateFile(flow.timerModule.c, flow.timerCContent)
	}
	
	
	def timerHContent(ExecutionFlow it)  '''
		#ifndef «timerModule.define»_H_
		#define «timerModule.define»_H_
		
		#include "«typesModule.h»"
		
		#ifdef __cplusplus
		extern "C" {
		#endif 
		
		typedef void(*setTimerFPtr)(uint32_t evid, const uint32_t time_ms, sc_boolean periodic);
		typedef void(*unsetTimerFPtr)(const uint32_t evid);
		
		typedef struct {
		
			/* callback functions */
			setTimerFPtr   setTimer;
			unsetTimerFPtr unsetTimer;
		
		}  «timerType»;
		
		extern void sc_timer_setFPtr(«timerType»* handle, setTimerFPtr stfptr, unsetTimerFPtr utfptr);
		extern void sc_timer_exit(«timerType»* handle);
		
		#ifdef __cplusplus
		}
		#endif 
		 
		#endif /* «timerModule.define»_H_ */
	'''
		
	def timerCContent(ExecutionFlow it) '''
		#include "«timerModule.h»"
		
		void sc_timer_setFPtr(«timerType»* handle, setTimerFPtr stfptr, unsetTimerFPtr utfptr)
		{
		
			handle->setTimer = stfptr;
			handle->unsetTimer = utfptr;
		
		}
		
		void sc_timer_exit(«timerType»* handle)
		{
		}
	'''
}