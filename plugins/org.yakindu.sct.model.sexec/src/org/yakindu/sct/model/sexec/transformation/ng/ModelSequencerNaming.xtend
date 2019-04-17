package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.sgraph.Synchronization

class ModelSequencerNaming {

	@Inject extension StextNameProvider

	def statemachinePackageName(Statechart sc) {
		if (sc.namespace.nullOrEmpty) "default" else sc.namespace
	}

	def statesEnumerationName(Statechart sc) {
		"State"
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
	
	def dispatch typeName(RegularState state) {
		state.fullyQualifiedName.lastSegment
	}
	
	def dispatch typeName(Choice choice) {
		"choice" + choice.parentRegion.vertices.filter(Choice).toList.indexOf(choice)
	}
	
	def dispatch typeName(Synchronization sync) {
		"sync" + sync.parentRegion.vertices.filter(Synchronization).toList.indexOf(sync)
	}
}
