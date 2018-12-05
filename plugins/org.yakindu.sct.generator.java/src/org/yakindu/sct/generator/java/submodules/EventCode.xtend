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
import org.yakindu.base.types.typesystem.GenericTypeSystem
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
		private boolean «event.identifier»;

		«IF event.type !== null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			private «event.typeSpecifier.targetLanguageName» «event.valueIdentifier»;

		«ENDIF»
		«IF event.direction == Direction::IN»
			«event.generateInEventDefinition»
		«ENDIF»
		«IF event.direction == Direction::OUT»
			«event.generateOutEventDefinition(entry, scope)»
		«ENDIF»
	'''
			
	def generateOutEventDefinition(EventDefinition event, GeneratorEntry entry, InterfaceScope scope) '''
		public boolean isRaised«event.name.asName»() {
			return «event.identifier»;
		}
		
		«IF event.type !== null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			protected void raise«event.name.asName»(«event.typeSpecifier.targetLanguageName» value) {
				«event.identifier» = true;
				«event.valueIdentifier» = value;
				«IF entry.createInterfaceObserver»
				for («scope.interfaceListenerName» listener : listeners) {
					listener.on«event.name.asEscapedName»Raised(value);
				}
				«ENDIF»
			}
			
			public «event.typeSpecifier.targetLanguageName» get«event.name.asName»Value() {
				«event.getIllegalAccessValidation()»
				return «event.valueIdentifier»;
			}

		«ELSE»
			protected void raise«event.name.asName»() {
				«event.identifier» = true;
				«IF entry.createInterfaceObserver»
					for («scope.interfaceListenerName» listener : listeners) {
						listener.on«event.name.asEscapedName»Raised();
					}
				«ENDIF»
			}

		«ENDIF»
	'''

	def generateInEventDefinition(EventDefinition event) '''
		«IF event.type !== null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			public void raise«event.name.asName»(«event.typeSpecifier.targetLanguageName» value) {
				«event.identifier» = true;
				«event.valueIdentifier» = value;
			}
			
			protected «event.typeSpecifier.targetLanguageName» get«event.name.asName»Value() {
				«event.getIllegalAccessValidation()»
				return «event.valueIdentifier»;
			}
		«ELSE»
			public void raise«event.name.asName»() {
				«event.identifier» = true;
			}
		«ENDIF»

	'''
	
	def getIllegalAccessValidation(EventDefinition it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value access. Event «name.asEscapedName» is not raised!");
	'''
}