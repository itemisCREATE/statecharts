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
import java.util.Set
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaIncludeProvider
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope

@Singleton
class EventCode {
	@Inject protected Set<JavaIncludeProvider> includeProviders
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension GenmodelEntries
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension ITypeSystem
	
	@Inject protected extension FieldDeclarationGenerator
	
	def generateEventDefinition(EventDefinition event, GeneratorEntry entry, InterfaceScope scope) '''
		«event.fieldDeclaration»
		«IF event.direction == Direction::IN»
		
		«event.generateInEventDefinition»
		«ENDIF»
		«IF event.direction == Direction::OUT»
		
		«event.generateOutEventDefinition(entry, scope)»
		«ENDIF»
	'''
	
	def fieldDeclaration(EventDefinition event) {
		'''
		private boolean «event.identifier»;
		
		«IF event.hasValue»
			private «event.typeSpecifier.targetLanguageName» «event.valueIdentifier»;	
		«ENDIF»
		'''
	}
			
	def generateOutEventDefinition(EventDefinition event, GeneratorEntry entry, InterfaceScope scope) '''
		public boolean isRaised«event.name.asName»() {
			return «event.identifier»;
		}
		
		«outEventRaiser(event, entry, scope)»
		«IF event.hasValue»
		
		«eventValueGetter(event)»
		«ENDIF»
	'''

	def generateInEventDefinition(EventDefinition event) '''
		«inEventRaiser(event)»
		«IF event.hasValue»
			«eventValueGetter(event)»
		«ENDIF»

	'''
	
	def eventValueGetter(EventDefinition it) {
		'''
		«eventValueGetterVisibility» «typeSpecifier.targetLanguageName» get«name.asName»Value() {
			«getIllegalAccessValidation»
			return «valueIdentifier»;
		}
		'''
	}
	
	def protected eventValueGetterVisibility(EventDefinition it) {
		switch(event.direction) {
			case IN: {
				"protected"
			}
			case LOCAL: {
				"private"
			}
			case OUT: {
				"public"
			}
			
		}
	}
	
	def internalEventRaiser(EventDefinition it) {
		eventRaiser("private", null)
	}
	
	def inEventRaiser(EventDefinition it) {
		eventRaiser("public", null)
	}
	
	def outEventRaiser(EventDefinition it, GeneratorEntry entry, InterfaceScope scope) {
		if(entry.createInterfaceObserver) {
			eventRaiser("protected", scope.interfaceListenerName)
		} else {
			eventRaiser("protected", null)
		}
	}
	
	def protected eventRaiser(EventDefinition it, String visibility, String interfaceListenerName) {
		'''
			«IF hasValue»
			«visibility» void raise«name.asName»(«typeSpecifier.targetLanguageName» value) {
				«valueIdentifier» = value;
			«ELSE»
				«visibility» void raise«name.asName»() {
			«ENDIF»
				«identifier» = true;
				«IF !interfaceListenerName.nullOrEmpty»
					for («interfaceListenerName» listener : listeners) {
						listener.on«event.name.asEscapedName»Raised(«IF hasValue»value«ENDIF»);
					}
				«ENDIF»
			}
		'''	
	}
	
	def getIllegalAccessValidation(EventDefinition it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value access. Event «name.asEscapedName» is not raised!");
	'''
}