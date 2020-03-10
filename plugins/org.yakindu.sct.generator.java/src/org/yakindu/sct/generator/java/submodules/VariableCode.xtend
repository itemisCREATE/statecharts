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
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import java.util.List
import com.google.common.collect.Lists
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions

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
	@Inject protected extension OriginTracing
	@Inject protected extension StatechartExtensions
	
	def fieldDeclaration(VariableDefinition variable) '''
		private «variable.typeSpecifier.targetLanguageName» «variable.identifier»;
		'''
	
	protected def generateVariableDefinition(VariableDefinition it) '''
		«IF !const»
			«fieldDeclaration»
			
		«ENDIF»
		«IF type.isOriginStatechart»
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
	
	protected def setterContent(VariableDefinition it) {
		'''
			«IF type.isOriginStatechart && !type.getOriginStatechart.scopesWithOutEvents.isEmpty»
				if (this.«identifier» != null) {
					«FOR submachineScope : type.getOriginStatechart.scopesWithOutEvents»
						this.«identifier».get«submachineScope.interfaceName»().getListeners().remove(«identifier»_«submachineScope.getInterfaceListenerName»);
					«ENDFOR»
				}
				
			«ENDIF»
			this.«identifier» = value;
			«IF type.isOriginStatechart && !type.getOriginStatechart.scopesWithOutEvents.isEmpty»
				
				if (this.«identifier» != null) {
					«FOR submachineScope : type.getOriginStatechart.scopesWithOutEvents»
						this.«identifier».get«submachineScope.interfaceName»().getListeners().add(«identifier»_«submachineScope.getInterfaceListenerName»);
					«ENDFOR»
				}
			«ENDIF»
		'''
	}
	
	protected def scopesWithOutEvents(Statechart submachine) {
		submachine.scopes.filter(InterfaceScope).filter[eventDefinitions.exists[direction == Direction.OUT]]
	}
	
	protected def submachineInterfaceListeners(VariableDefinition it) {
		var subchart = type.getOriginStatechart
		val List<CharSequence> listeners = Lists.newArrayList 
		subchart.allScopesWithOutEvents.forEach[scope, outEvents |
			listeners += submachineInterfaceListener(it, scope, outEvents);
		]
		return listeners.join
	}
	
	protected def submachineInterfaceListener(VariableDefinition it, InterfaceScope scope, Iterable<Event> outEvents) {
		var subchart = type.getOriginStatechart
		'''
		private «subchart.statemachineInterfaceName».«scope.interfaceListenerName» «identifier»_«scope.interfaceListenerName» = new «subchart.statemachineInterfaceName».«scope.interfaceListenerName»() {
			«FOR outEvent : outEvents»
			«submachineOutEventHandler(outEvent, flow)»
			«ENDFOR»
		};
		'''
	}
	
	protected def submachineOutEventHandler(Event outEvent, ExecutionFlow flow) {
		'''
		@Override
		«IF outEvent.type !== null && !isVoid(outEvent.type)»
			public void on«outEvent.name.toFirstUpper()»Raised(«outEvent.typeSpecifier.targetLanguageName» value) {
				raise«outEvent.shadowEvent(flow).name.asName»(value);
			}
		«ELSE»
			public void on«outEvent.name.toFirstUpper()»Raised() {
				raise«outEvent.shadowEvent(flow).name.asName»();
			}
		«ENDIF»	
		'''
	}
	
	protected def shadowEvent(Event originalEvent, ExecutionFlow flow) {
		flow.scopes.filter(InternalScope).map[declarations].flatten.filter(Event).findFirst[originTraces.contains(originalEvent)]
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