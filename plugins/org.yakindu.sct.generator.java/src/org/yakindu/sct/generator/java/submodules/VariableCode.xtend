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
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author BeckmaR
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
	
	def fieldDeclaration(VariableDefinition variable) '''
		private «variable.typeSpecifier.targetLanguageName» «variable.identifier»;
		'''
	
	protected def generateVariableDefinition(VariableDefinition it) '''
		«IF !const»
			«fieldDeclaration»
			
		«ENDIF»
		«IF needsShadowEventMapping»
			«submachineInterfaceListeners»
			
		«ENDIF»
		«getterVisibility» «typeSpecifier.targetLanguageName» «getter» {
			«sync(flow.statemachineClassName + ".this", '''return «identifier»;''')»
		}
		«IF needsSetter»
		
		«setterVisibility» void «setter»(«typeSpecifier.targetLanguageName» value) {
			«sync(flow.statemachineClassName + ".this", setterContent)»
		}
		«ENDIF»
		«IF needsAssignMethod»
		
		protected «sync»«typeSpecifier.targetLanguageName» «assign»(«typeSpecifier.targetLanguageName» value) {
			«sync(flow.statemachineClassName + ".this", '''return this.«identifier» = value;''')»
		}
		«ENDIF»
	'''
	
	protected def needsShadowEventMapping(VariableDefinition member) {
		member.type.isOriginStatechart && !member.shadowEvents.nullOrEmpty
	}

	protected def setterContent(VariableDefinition it) {
		'''
			«IF needsShadowEventMapping»
				if (this.«identifier» != null) {
					«FOR submachineScope : shadowEventsByScope.keySet»
						this.«identifier».get«submachineScope.interfaceName»().getListeners().remove(«identifier»_«submachineScope.getInterfaceListenerName»);
					«ENDFOR»
				}
				
			«ENDIF»
			this.«identifier» = value;
			«IF needsShadowEventMapping»
				
				if (this.«identifier» != null) {
					«FOR submachineScope : shadowEventsByScope.keySet»
						this.«identifier».get«submachineScope.interfaceName»().getListeners().add(«identifier»_«submachineScope.getInterfaceListenerName»);
					«ENDFOR»
				}
			«ENDIF»
		'''
	}

	protected def submachineInterfaceListeners(VariableDefinition member) {
		member.shadowEventsByScope.keySet.map[scope|submachineInterfaceListener(member, scope)].join
	}

	protected def submachineInterfaceListener(VariableDefinition it, InterfaceScope scope) {
		var subchart = type.getOriginStatechart
		'''
			private «subchart.statemachineInterfaceName».«scope.interfaceListenerName» «identifier»_«scope.interfaceListenerName» = new «subchart.statemachineInterfaceName».«scope.interfaceListenerName»() {
				«FOR outEvent : scope.outgoingEvents»
					«submachineOutEventHandler(outEvent)»
				«ENDFOR»
			};
		'''
	}
	
	protected def submachineOutEventHandler(VariableDefinition member, Event outEvent) {
		var shadowEvent = member.getShadowEvent(outEvent)
		'''
			@Override
			«IF outEvent.type !== null && !isVoid(outEvent.type)»
				public void on«outEvent.name.toFirstUpper()»Raised(«outEvent.typeSpecifier.targetLanguageName» value) {
					«IF shadowEvent !== null»
						raise«shadowEvent.name.asName»(value);
					«ELSE»
						// nothing to do
					«ENDIF»
				}
			«ELSE»
				public void on«outEvent.name.toFirstUpper()»Raised() {
					«IF shadowEvent !== null»
						raise«shadowEvent.name.asName»();
					«ELSE»
						// nothing to do
					«ENDIF»
				}
			«ENDIF»	
		'''
	}

	protected def needsPublicGetter(VariableDefinition it) {
		switch(eContainer) {
			InternalScope: false
			InterfaceScope: true
			default: false
		}
	}
	
	protected def getterVisibility(VariableDefinition it) {
		if(needsPublicGetter) '''public «sync»'''.toString.trim else "protected"
	}
	
	protected def needsPublicSetter(VariableDefinition it) {
		switch(eContainer) {
			InternalScope: false
			InterfaceScope case !readonly: true
			InterfaceScope case readonly: false
			default: false
		}
	}
	
	protected def needsSetter(VariableDefinition it) {
		!const
	}
	
	protected def setterVisibility(VariableDefinition it) {
		if(needsPublicSetter) '''public''' else "protected"
	}
}