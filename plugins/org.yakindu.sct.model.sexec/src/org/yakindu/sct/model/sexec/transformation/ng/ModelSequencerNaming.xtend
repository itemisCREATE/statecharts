package org.yakindu.sct.model.sexec.transformation.ng

import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.stext.naming.StextNameProvider
import com.google.inject.Inject
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.sgraph.Statechart

class ModelSequencerNaming {

	@Inject protected extension StextNameProvider

	def statemachinePackageName(Statechart sc) {
		if (sc.namespace.nullOrEmpty) "default" else sc.namespace
	}

	def statesEnumerationName(Statechart sc) {
		sc.name + "States"
	}

	def enumeratorName(RegularState state) {
		state.fullyQualifiedName.skipFirst(1).toString
	}

	def noStateName() {
		"__NoState__"
	}

	def interfaceTypeName(InterfaceScope iface) {
		if(iface.name.nullOrEmpty) defaultInterfaceTypeName else iface.name
	}
	
	def defaultInterfaceTypeName() {
		"SCInterface"
	}
	
	def internalTypeName() {
		"SCInternal"
	}
	
	def interfaceTypeAnnotationName() {
		"InterfaceGroup"
	}
	
	def stateTypeName(RegularState state) {
		state.fullyQualifiedName.lastSegment
	}
}
