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

@Singleton
class StatemachineFunctionsGenerator {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension ITypeSystem
	@Inject protected extension GenmodelEntries
	@Inject protected extension Synchronized
	
	def createConstructor(ExecutionFlow flow) '''
		public «flow.statemachineClassName»() {
			«FOR scope : flow.interfaceScopes»
			«scope.interfaceName.asEscapedIdentifier» = new «scope.getInterfaceImplName()»();
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
							«scope.interfaceName.asEscapedIdentifier».raise«event.name.asName»(value);
						}
					«ELSE»
						public «sync»void raise«event.name.asName»() {
							«scope.interfaceName.asEscapedIdentifier».raise«event.name.asName»();
						}
					«ENDIF»

				«ENDIF»
				«IF event.direction ==  Direction::OUT»
					public «sync»boolean isRaised«event.name.asName»() {
						return «scope.interfaceName.asEscapedIdentifier».isRaised«event.name.asName»();
					}

					«IF event.hasValue»
						public «sync»«event.typeSpecifier.targetLanguageName» get«event.name.asName»Value() {
							return «scope.interfaceName.asEscapedIdentifier».get«event.name.asName»Value();
						}

					«ENDIF»
				«ENDIF»
			«ENDFOR»
			«FOR variable : scope.variableDefinitions»
				public «sync»«variable.typeSpecifier.targetLanguageName» «variable.getter()» {
					return «scope.interfaceName.asEscapedIdentifier».«variable.getter()»;
				}
				
				«IF !variable.const && !variable.readonly»
					public «sync»void «variable.setter»(«variable.typeSpecifier.targetLanguageName» value) {
						«scope.interfaceName.asEscapedIdentifier».«variable.setter»(value);
					}

				«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
	
	def interfaceAccessors(ExecutionFlow flow, GeneratorEntry entry) '''
		«FOR scope : flow.interfaceScopes»
			public «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.toFirstLower()»;
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