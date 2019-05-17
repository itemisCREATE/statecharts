package org.yakindu.sct.types.generator.statechart.java.naming

import org.yakindu.base.types.ComplexType

class JavaOCBNaming {
	
	def nameOperationCallback(ComplexType ct) {
		ct.name + "OperationCallback"
	}
	
	def nameInternalOperationCallback() {
		"InternalOperationCallback"
	}
	
	def nameOperationCallbackProperty(ComplexType ocb) {
		"operationCallback"
	}
	
	def nameOperationCallbackSetter(ComplexType ocb) {
		"set" + ocb.name
	}
	
}
