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
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.cpp.classes.StatechartInterfaceClass
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author rbeckmann
 *
 */
class EventDrivenStatechartInterfaceClass extends StatechartInterfaceClass {
	@Inject protected extension EventNaming eventNaming
	
	protected IType sctEventType
	
	new() {
		super()
		sctEventType = "SctEvent".pointer
	}
	
	override build(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		super.build(flow, entry, artifactConfigs)
		
		addMember(eventDispatchFunction, innerClassVisibility)
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
	
}