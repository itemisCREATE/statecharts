package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.stext.stext.Direction

class Statemachine {
	
	@Inject extension Naming cNaming
	@Inject extension Navigation
	@Inject extension Base
	
	def generateStatemachineH(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa) {
		 fsa.generateFile(flow.module.h, flow.statemachineHContent )
	}
	
	
	
	def statemachineHContent(ExecutionFlow it) '''
			#ifndef «module.define»_H_
			#define «module.define»_H_

			#include "«typesModule.h»"
			
			#ifdef __cplusplus
			extern "C" { 
			#endif 

			/*! \file Header of the state machine '«name»'.
			*/
			
			«statesEnumDecl»
			
			«FOR s : it.scopes»«s.scopeTypeDecl»«ENDFOR»
			
			«statemachineTypeDecl»

			/*! Initializes the «type» state machine data structures. Must be called before first usage.*/
			extern void «type.toFirstLower»_init(«type»* handle);
			
			/*! Activates the state machine */
			extern void «type.toFirstLower»_enter(«type»* handle);
			
			/*! Deactivates the state machine */
			extern void «type.toFirstLower»_exit(«type»* handle);
			
			/*! Performs a 'run to completion' step. */
			extern void «type.toFirstLower»_runCycle(«type»* handle);

			«IF timed»
				/*! Raises a time event. */
				extern void «type.toFirstLower»_raiseTimeEvent(«type»* handle, sc_eventid evid);
			«ENDIF»
			
			«FOR s : it.scopes.filter( typeof(InterfaceScope) )»
				«s.scopeFunctionPrototypes»
				
			«ENDFOR»
			
			#ifdef __cplusplus
			}
			#endif 
			
			#endif /* «module.define»_H_ */
	'''

	def statesEnumDecl(ExecutionFlow it) '''
		//! enumeration of all states 
		typedef enum {
			«FOR state : states »
			«state.name.asIdentifier» ,
			«ENDFOR»
			last_state
		} «statesEnumType»;
	'''


	def dispatch structDeclaration(EventDefinition it) '''
		sc_boolean «name.asIdentifier»_raised;
		«IF type != null && type.name != 'void'»«type.cPrimitive»  «name.asIdentifier»_value;«ENDIF»
	'''

	def dispatch structDeclaration(TimeEvent it) '''
		sc_boolean «name.asIdentifier»_raised;
	'''

	def dispatch structDeclaration(VariableDefinition it) '''
		«IF type.name != 'void'»«type.cPrimitive»  «name.asIdentifier»;«ENDIF»
	'''
	
	def dispatch structDeclaration(Declaration it) ''''''
	
	
	def dispatch scopeTypeDecl(Scope it) '''
		//! Type definition of the data structure for the «it.type» interface scope.
		typedef struct {
			«FOR d : declarations »
			«d.structDeclaration »
			«ENDFOR»
		} «it.type»;

	'''	

//	def dispatch scopeTypeDecl(Scope it) ''''''	

	def statemachineTypeDecl(ExecutionFlow it) '''
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		#define «type.toUpperCase»_MAX_ORTHOGONAL_STATES «stateVector.size»
		«IF ! historyVector.empty»
		//! dimension of the state configuration vector for history states
		#define «type.toUpperCase»_MAX_HISTORY_STATES «historyVector.size»«ENDIF»
		
		/*! Type definition of the data structure for the «type» state machine.
		This data structure has to be allocated by the client code. */
		typedef struct {
			«statesEnumType» stateConfVector[«type.toUpperCase»_MAX_ORTHOGONAL_STATES];
			«IF ! historyVector.empty»«statesEnumType» historyVector[«type.toUpperCase»_MAX_HISTORY_STATES];«ENDIF»
			sc_ushort stateConfVectorPosition; 
			
			«FOR iScope : scopes »
			«iScope.type» «iScope.instance»;
			«ENDFOR»			
		} «type»;
	'''


	def dispatch scopeFunctionPrototypes(StatechartScope it) '''
		«FOR d : declarations »
		«d.functionPrototypes »
		«ENDFOR»
	'''	

	def dispatch scopeFunctionPrototypes(Object it) ''''''	
	

	def dispatch functionPrototypes(Declaration it) ''''''

	def dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::IN»
		/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */ 
		extern «type.cPrimitive» «asRaiser»(«it.flow.type»* handle«valueParams»);
		
		«ELSE»
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */ 
			extern sc_boolean «asRaised»(«it.flow.type»* handle);
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */ 
				extern «type.cPrimitive» «asGetter»(«it.flow.type»* handle);
				
			«ENDIF»
		«ENDIF»
	'''

	def dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
		extern «type.cPrimitive» «it.asGetter»(«it.flow.type»* handle);
		«IF ! readonly »
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
			extern void «asSetter»(«it.flow.type»* handle, «type.cPrimitive» value);
		«ENDIF»
	'''

	def valueParams(EventDefinition it) {
		if (hasValue) ', ' + type.cPrimitive + ' value' 
		else ''
	}
}