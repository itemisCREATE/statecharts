/**
  Copyright (c) 2018 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.Property
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.eclipse.xtext.util.Strings.*
import org.yakindu.sct.model.stext.lib.StatechartAnnotations

@Singleton
class FieldDeclarationGenerator {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntries
	@Inject protected extension VariableCode
	@Inject protected extension EventCode
	@Inject protected extension StatechartAnnotations
	
	def internalEventFields(ExecutionFlow flow) '''
		«FOR event : flow.internalScopeEvents»
		«event.fieldDeclaration»
		«ENDFOR»
	'''
	
	def createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		«FOR scope : flow.interfaceScopes»
			protected «scope.interfaceImplName» «scope.interfaceName.asEscapedIdentifier»;
			
		«ENDFOR»
		private boolean initialized = false;

		«statesEnum(flow)»

		«stateVectors(flow)»
		
		private int nextStateIndex;
		
		«IF entry.tracingUsed»
		«entry.tracingFields»
		
		«ENDIF»
		«IF flow.timed»
		«flow.timingFields»
		
		«ENDIF»
		«flow.internalEventFields»
		«FOR v : flow.internalScopeVariables SEPARATOR newLine AFTER newLine»
			«v.code»
			
		«ENDFOR»
		«FOR internal : flow.internalScopes»
			«IF internal.hasOperations()»
				private «internal.getInternalOperationCallbackName()» operationCallback;
			«ENDIF»
		«ENDFOR»
		«FOR v : flow.features.filter(Property)»
			«v.code»
		«ENDFOR»
	'''
	
	protected def statesEnum(ExecutionFlow it) '''
		public enum State {
			«FOR state : states»
				«state.stateName.asEscapedIdentifier»,
			«ENDFOR»
			«getNullStateName()»
		};
	'''
	
	protected def stateVectors(ExecutionFlow it) '''
		«IF hasHistory»
			private State[] historyVector = new State[«historyVector.size»];
		«ENDIF»
		private final State[] stateVector = new State[«stateVector.size»];
	'''
	
	protected def timingFields(ExecutionFlow it) '''
		private ITimer timer;
		
		private final boolean[] timeEvents = new boolean[«flow.timeEvents.size»];
	'''
	
	protected def tracingFields(GeneratorEntry it) '''
		private List <«traceInterface»<State>> «traceInstances» = new LinkedList <«traceInterface»<State>>();
	'''
}