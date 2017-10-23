/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.language.Parameter
import org.yakindu.sct.generator.c.language.Variable
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.cpp.classes.StatechartInterfaceClass
import org.yakindu.sct.generator.cpp.language.Constructor
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.generator.core.language.IModule

/**
 * @author rbeckmann
 *
 */
class EventDrivenStatechartInterfaceClass extends StatechartInterfaceClass {
	@Inject protected extension EventNaming eventNaming
	
	protected IType sctEventType
	
	new() {
		super()
		(flow.eventNamespaceName + "::SctEvent").pointer
	}
	
	override build(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent, StatechartScope scope) {
		super.build(flow, entry, artifactConfigs, parent, scope)
		
		addMember(eventDispatchFunction, innerClassVisibility)
		
		addMember(new Variable(
			flow.module.pointer,
			"parent"
		), innerClassVisibility)
	}
	
	def createConstructor() {
		val constructor = new Constructor()
		constructor.name = this.name
		constructor.parameters += new Parameter(
			flow.module.pointer,
			"parent"
		)
		constructor.initializerList += initializerList
	}
	
	def getInitializerList() {
		val toInit = newArrayList
		for(e : scope.declarations.filter(EventDefinition)) {
			toInit += ('''«e.name.asIdentifier.raised»(false)''')
			if (e.hasValue) {
				toInit += ('''«e.name.asIdentifier.value»()''')
			}
		}
		toInit += "parent(parent)"
		toInit
	}
	
	def eventDispatchFunction() {
		function("dispatch_event", '''
		switch(event->name)
		{
			«FOR e: scope.declarations.filter(EventDefinition).filter[direction == Direction::LOCAL]»
				case «e.eventEnumMemberName»:
				{
					«IF e.hasValue»
					«e.eventClassName» * e = dynamic_cast<«e.eventClassName»*>(event);
					if(e != 0) {
						internal_«e.asRaiser»(e->value);
					}
					«ELSE»
					internal_«e.asRaiser»();
					«ENDIF»
					break;
				}
			«ENDFOR»
			default:
				break;
		}
		''', #[new Parameter(sctEventType, "event")])
	}
	
	override createLocalEventFunctions(StatechartScope scope, EventDefinition declaration) {
		val funcs = super.createLocalEventFunctions(scope, declaration)
		funcs += createInternalInterfaceEventRaiser(scope, declaration)
		funcs		
	}
	
	def createInternalInterfaceEventRaiser(StatechartScope scope, EventDefinition event) {
		val function = function('''internal_«event.asRaiser»''')
		if(event.hasValue) {
			function.content = '''
			«event.localValueAccess» = value;
			«event.localAccess» = true;
			'''
			function.parameters += new Parameter(
				event.typeSpecifier.targetLanguageName,
				"value"
			)
		} else {
			function.content = '''
			«event.localAccess» = true;
			'''
		}
		function
	}
}