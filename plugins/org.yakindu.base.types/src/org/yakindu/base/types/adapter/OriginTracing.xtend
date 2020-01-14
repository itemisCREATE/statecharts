/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	Axel Terfloth - itemis AG
*
*/
package org.yakindu.base.types.adapter

import org.eclipse.emf.ecore.EObject

/**
 * This extension provides access to all information required for tracing from a statechart type to the original statechart. 
 * 
 * This extension is stateless. It encapsulates the storage of traces information. This is currently based on 'eAdapters'. 
 * 
 * @author terfloth
 */
class OriginTracing {
	
	/** 
	 * Adds a structural trace to an element. 'origin' is the original element in the statechart. These kind of traces 
	 * can be used for navigation purpose.
	 */
	def <T extends EObject> T traceOrigin(T it, Object origin) {
		it.eAdapters.add(new OriginTraceAdapter(origin))	
		return it
	}
	
	/** 
	 * Returns all origins that are traces for a given slang model element. 
	 * The result also includes execution trace origins.
	 */
	def getOriginTraces(EObject it) {
		it.eAdapters.filter(OriginTraceAdapter).map[getOrigin()].toList
	}
	
}
