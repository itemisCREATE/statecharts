/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.util

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Type
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Scope

class StatechartUtil {
	
	@Inject extension OriginTracing
	
	def dispatch isOriginStatechart(Type type) {
		type?.originTraces.exists[it instanceof Statechart]
	}
	
	def dispatch isOriginStatechart(EObject it) {
		false
	}
	
	def isMultiSM(EObject it) {
		isOriginStatechart || isOriginScope
	}
	
	def dispatch isOriginScope(Type type) {
		type.originTraces.exists[it instanceof Scope]
	}
	
	def dispatch isOriginScope(EObject it) {
		false
	}
	
	def isOriginStateEnum(EObject it) {
		// state enums are enumeration types with an origin trace back to the statechart
		(it instanceof EnumerationType) && originTraces.exists[it instanceof Statechart]
	}
	
	def getOriginStatechart(EObject it) {
		originTraces.filter(Statechart).head
	}
	
	def getOriginState(EObject it) {
		originTraces.filter(State).head
	}
	
	def getOriginScope(EObject it) {
		originTraces.filter(Scope).head
	}
	
}
