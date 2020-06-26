/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import org.yakindu.base.types.Event
import org.yakindu.base.types.Property
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.OutEventObservables
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.model.sexec.concepts.EventBuffer
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope

/**
 * @author BeckmaR
 * @author Thomas Kutz - added out event observers
 */
class VariableCode {
	
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension SExecExtensions
	@Inject protected extension Synchronized
	@Inject protected extension StatechartUtil
	@Inject protected extension ITypeSystem
	@Inject protected extension StatechartAnnotations
	@Inject protected extension GeneratorPredicate
	@Inject protected extension ShadowEventExtensions
	@Inject protected extension StatechartExtensions
	@Inject protected extension OutEventObservables
	@Inject protected extension EventBuffer
	
	def code(Property it) '''
		«IF !const»
			«fieldDeclaration»
			
		«ENDIF»
		«IF needsShadowEventMapping»
			«submachineOutEventObservers»
			
		«ENDIF»
		«IF needsGetter»
		«getterCode»
		«ENDIF»
		«IF needsSetter»
		
		«setterCode»
		«ENDIF»
		«IF needsAssignMethod»
		
		«assignCode»
		«ENDIF»
	'''
	
	def fieldDeclaration(Property it) '''
		private «typeSpecifier.targetLanguageName» «identifier»«IF needsInitialization» = new «typeSpecifier.targetLanguageName»()«ENDIF»;
	'''
	
	def getterCode(Property it) '''
		«getterVisibility» «typeSpecifier.targetLanguageName» «getter» {
			«sync(flow.statemachineClassName + ".this", '''return «identifier»;''')»
		}
	'''
	
	def setterCode(Property it) '''
		«setterVisibility» void «setter»(«typeSpecifier.targetLanguageName» value) {
			«sync(flow.statemachineClassName + ".this", setterContent)»
		}
	'''
	
	def assignCode(Property it) '''
		protected «sync»«typeSpecifier.targetLanguageName» «assign»(«typeSpecifier.targetLanguageName» value) {
			«sync(flow.statemachineClassName + ".this", '''return this.«identifier» = value;''')»
		}
	'''

	protected def setterContent(Property it) {
		'''
			«IF needsShadowEventMapping»
				if (this.«identifier» != null) {
					«FOR submachineScope : shadowEventsByScope.keySet»
						«FOR shadowEvent : shadowEventsByScope.get(submachineScope)»
							this.«identifier».get«submachineScope.interfaceName»().«shadowEvent.outEvent.observableGetterName»().unsubscribe(«shadowEvent.observerName»);
						«ENDFOR»
					«ENDFOR»
				}
				
			«ENDIF»
			this.«identifier» = value;
			«IF needsShadowEventMapping»
				
				if (this.«identifier» != null) {
					«FOR submachineScope : shadowEventsByScope.keySet»
						«FOR shadowEvent : shadowEventsByScope.get(submachineScope)»
							this.«identifier».get«submachineScope.interfaceName»().«shadowEvent.outEvent.observableGetterName»().subscribe(«shadowEvent.observerName»);
						«ENDFOR»
					«ENDFOR»
				}
			«ENDIF»
		'''
	}
	
	protected def submachineOutEventObservers(Property member) {
		member.shadowEvents.map[submachineOutEventObserver].join
	}
	
	protected def submachineOutEventObserver(Event shadowEvent) '''
		private «shadowEvent.outEvent.observerType» «shadowEvent.observerName» = new «shadowEvent.outEvent.observerType»() {
			@Override
			public void next(«shadowEvent.outEvent.eventType» value) {
				raise«shadowEvent.name.asName»(«IF shadowEvent.hasValue»value«ENDIF»);
			}
		};
		
	'''

	protected def needsPublicGetter(Property it) {
		switch(eContainer) {
			InternalScope: false
			InterfaceScope: true
			default: false
		}
	}
	
	protected def getterVisibility(Property it) {
		if(needsPublicGetter) '''public «sync»'''.toString.trim else "protected"
	}
	
	protected def needsPublicSetter(Property it) {
		switch(eContainer) {
			InternalScope: false
			InterfaceScope case !readonly: true
			InterfaceScope case readonly: false
			default: false
		}
	}
	
	protected def needsSetter(Property it) {
		!const && !type.isEventBuffer
	}
	
	protected def needsGetter(Property it) {
		!type.isEventBuffer
	}
	
	protected def needsInitialization(Property it) {
		type.isEventBuffer
	}
	
	protected def setterVisibility(Property it) {
		if(needsPublicSetter) '''public''' else "protected"
	}
}