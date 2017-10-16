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
import org.yakindu.sct.generator.cpp.classes.StatechartClass
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author rbeckmann
 *
 */
class EventDrivenStatechartClass extends StatechartClass {
	@Inject extension EventNaming eventNaming
	
	protected IType sctEventType
	
	new() {
		super()
		sctEventType = "SctEvent".pointer
	}
	
	override build(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		super.build(flow, entry, artifactConfigs)
		
		addMember(dispatchEventFunction, innerClassVisibility)
	}
	
	def dispatchEventFunction() {
		val it = flow
		function("dispatch_event", '''
		if(event == 0) {
			return;
		}
		switch(event->name)
		{
			«FOR s : scopes.filter(StatechartScope)»
				«FOR e : s.declarations.filter(EventDefinition).filter[direction == Direction::LOCAL]»
					case «e.eventEnumMemberName»:
				«ENDFOR»
				{
						«s.instance».dispatch_event(event);
						break;
				}
			«ENDFOR»
			default:
				break;
		}
		''', #[new Parameter(sctEventType, "event")])
	}
	
}