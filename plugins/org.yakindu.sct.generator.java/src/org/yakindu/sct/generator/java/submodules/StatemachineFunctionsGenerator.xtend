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
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.generator.java.features.OutEventObservables

@Singleton
class StatemachineFunctionsGenerator {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension ITypeSystem
	@Inject protected extension GenmodelEntries
	@Inject protected extension Synchronized
	@Inject protected extension GeneratorPredicate
	@Inject protected extension OutEventObservables
	
	def createConstructor(ExecutionFlow flow) '''
		public «flow.statemachineClassName»() {
			«FOR scope : flow.interfaceScopes»
			«scope.interfaceVariableName» = new «scope.getInterfaceImplName()»();
			«ENDFOR»
		}

	'''
	
	def defaultInterfaceFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF flow.defaultScope !== null»
			«var InterfaceScope scope = flow.defaultScope»
			«FOR event : scope.eventDefinitions»
				«IF event.direction == Direction::IN»
					«IF event.hasValue»
						public «sync»void raise«event.name.asName»(«event.typeSpecifier.targetLanguageName» value) {
							«scope.interfaceVariableName».raise«event.name.asName»(value);
						}
					«ELSE»
						public «sync»void raise«event.name.asName»() {
							«scope.interfaceVariableName».raise«event.name.asName»();
						}
					«ENDIF»

				«ENDIF»
				«IF event.direction ==  Direction::OUT»
					«IF useOutEventGetters»
						public «sync»boolean isRaised«event.name.asName»() {
							return «scope.interfaceVariableName».isRaised«event.name.asName»();
						}
						
						«IF event.hasValue»
							public «sync»«event.typeSpecifier.targetLanguageName» get«event.name.asName»Value() {
								return «scope.interfaceVariableName».get«event.name.asName»Value();
							}
							
						«ENDIF»
					«ELSEIF useOutEventObservables»
						public «sync»Observable<«event.eventType»> «event.observableGetterName»() {
							return «scope.interfaceVariableName».«event.observableGetterName»();
						}
						
					«ENDIF»
				«ENDIF»
			«ENDFOR»
			«FOR variable : scope.variableDefinitions»
				public «sync»«variable.typeSpecifier.targetLanguageName» «variable.getter()» {
					return «scope.interfaceVariableName».«variable.getter()»;
				}
				
				«IF !variable.const && !variable.readonly»
					public «sync»void «variable.setter»(«variable.typeSpecifier.targetLanguageName» value) {
						«scope.interfaceVariableName».«variable.setter»(value);
					}

				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
	
	def interfaceAccessors(ExecutionFlow flow, GeneratorEntry entry) '''
		«FOR scope : flow.interfaceScopes»
			public «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceVariableName»;
			}

		«ENDFOR»
		«IF tracingUsed(entry)»
			«generateTraceAccessors(entry)»
		«ENDIF»
	'''
	
	def protected generateTraceAccessors(GeneratorEntry entry) '''
		public «sync»void add«traceAccessorFunctionID.toFirstUpper»(«traceInterface»<State> «traceSingleInstance») {
			if(!(this.«traceInstances».contains(«traceSingleInstance»))) {
				this.«traceInstances».add(«traceSingleInstance»);
			}
		}
		
		public «sync»void remove«traceAccessorFunctionID.toFirstUpper»(«traceInterface»<State> «traceSingleInstance») {
			if(this.«traceInstances».contains(«traceSingleInstance»)) {
				this.«traceInstances».remove(«traceSingleInstance»);
			}
		}
	'''
}