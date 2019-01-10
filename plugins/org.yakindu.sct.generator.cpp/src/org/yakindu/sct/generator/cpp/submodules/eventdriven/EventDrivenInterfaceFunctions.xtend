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
package org.yakindu.sct.generator.cpp.submodules.eventdriven

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.generator.cpp.templates.ClassDeclaration
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class EventDrivenInterfaceFunctions extends InterfaceFunctions {
	@Inject protected extension INamingService
	@Inject protected extension EventDrivenPredicate
	@Inject protected extension EventNaming
	
	override CharSequence protectedInnerClassMembers(StatechartScope it) {
		'''
		«super.protectedInnerClassMembers(it)»
		«execution_flow.module()» * parent;
		«IF needsDispatchEventFunction(flow)»
		void «it.flow.dispatchEventFctID»(«it.flow.eventNamespaceName»::«SCT_EVENT» * event);
		«ENDIF»
		'''
	}
	
	override createInterface(StatechartScope it, ClassDeclaration scopeDecl) {
		val List<String> toInit = newArrayList
		for( e : declarations.filter(EventDefinition)) {
			toInit.add('''«e.name.asIdentifier.raised»(false)''')
			if (e.hasValue) {
				toInit.add('''«e.name.asIdentifier.value»()''')
			}
		}
		toInit.add("parent(parent)")
		scopeDecl.publicMember(
			'''
			«interfaceName»(«execution_flow.module()» * parent):
				«FOR init : toInit SEPARATOR ","»
					«init»
				«ENDFOR»
			{}
			'''
		)
		super.createInterface(it, scopeDecl)
	}
	
	override dispatch privateFunctionPrototypes(EventDefinition it) {
		'''
		«IF direction == Direction::LOCAL»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void internal_«asRaiser»(«valueParams»);
		«ENDIF»
		'''
	}
}