package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.HashMap
import java.util.Map
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.naming.INamingService

class StateConfVectorIndexCalculator {
	@Inject extension INamingService
	protected Map<ExecutionState, Integer> indexMap
	protected Map<ExecutionState, String> defineMap
	
	def Integer getIndex(ExecutionState it) {
		if(indexMap == null) {
			indexMap = new HashMap()
		}
		var ret = indexMap.get(it)
		if(ret == null) {
			ret = calculateIndexForState
			indexMap.put(it, ret)
		}
		return ret
	}
	
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
	
	def protected Integer calculateIndexForState(ExecutionState it) {
		return stateVector.offset
	}
	
}