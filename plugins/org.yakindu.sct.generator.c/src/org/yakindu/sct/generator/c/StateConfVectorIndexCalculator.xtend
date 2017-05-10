package org.yakindu.sct.generator.c

import java.util.HashMap
import java.util.Map
import org.yakindu.sct.model.sexec.ExecutionState

class StateConfVectorIndexCalculator {
	protected Map<ExecutionState, Integer> indexMap
	
	def Integer getIndex(ExecutionState it) {
		if(indexMap == null) {
			indexMap = new HashMap()
		}
		var ret = indexMap.get(it)
		if(ret == null) {
			ret = calculateIndexForState()
			indexMap.put(it, ret)
		}
		return ret
	}
	
	def protected Integer calculateIndexForState(ExecutionState it) {
		return stateVector.offset
	}
	
}