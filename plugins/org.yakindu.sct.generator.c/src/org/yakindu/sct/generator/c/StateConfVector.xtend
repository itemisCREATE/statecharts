/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.HashMap
import java.util.Map
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.naming.INamingService

/**
 * @author René Beckmann
 */
class StateConfVector {
	@Inject extension INamingService
	protected Map<ExecutionState, String> defineMap
	
	def String getDefine(ExecutionState it) {
		if(defineMap == null) {
			defineMap = new HashMap()
		}
		var ret = defineMap.get(it)
		if(ret == null) {
			ret = calculateDefine
			defineMap.put(it, ret)
		}
		return ret
	}
	
 	def protected String calculateDefine(ExecutionState it) {
 		'''SCVI_«shortName»'''.toString.toUpperCase
 	}	
}