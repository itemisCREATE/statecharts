/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.statechart.cpp.naming

import org.yakindu.sct.types.generator.statechart.c.naming.CInterfaceNaming

class CppInterfaceNaming extends CInterfaceNaming {
	def getInterfaceName() {
		"StatemachineInterface"
	}
	
	def getCycleBasedInterfaceName() {
		"CycleBasedStatemachineInterface"
	}

	def getDefaultSCI() {
		"DefaultSCI"
	}

	def getInternalSCI() {
		"InternalSCI"
	}

	def getSCIPrefix() {
		"SCI_"
	}

	def getSCIInterfaceVariable() {
		"sCInterface"
	}

	def getSCIInternalVariable() {
		"sCInternal"
	}

	def getIfaceVariable() {
		"iface"
	}
}
