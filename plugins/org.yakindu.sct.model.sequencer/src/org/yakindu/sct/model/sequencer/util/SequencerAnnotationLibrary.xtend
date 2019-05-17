package org.yakindu.sct.model.sequencer.util

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.model.sequencer.ModelSequencerNaming
import org.yakindu.sct.types.common.library.CoreAnnotationLibrary

@Singleton
class SequencerAnnotationLibrary extends CoreAnnotationLibrary implements SequencerAnnotationConstants {
	@Inject protected extension ModelSequencerNaming

	def interfaceGroupAnnotation() {
		annotation(interfaceTypeAnnotationName)
	}

	def isInterfaceGroup(AnnotatableElement it) {
		isAnnotatedWith(interfaceTypeAnnotationName)
	}

	def internalScopeAnnotation() {
		annotation(internalScopeTypeAnnotationName)
	}

	def isInternalScope(AnnotatableElement it) {
		isAnnotatedWith(internalScopeTypeAnnotationName)
	}

	def eventDrivenAnnotation() {
		annotation(EVENT_DRIVEN)
	}

	def isEventDriven(AnnotatableElement it) {
		isAnnotatedWith(EVENT_DRIVEN)
	}

	def cycleBasedAnnotation() {
		annotation(CYCLE_BASED)
	}

	def isCycleBased(AnnotatableElement it) {
		isAnnotatedWith(CYCLE_BASED)
	}

	def triggerAnnotation() {
		annotation(TRIGGER)
	}

	def isTrigger(AnnotatableElement it) {
		isAnnotatedWith(TRIGGER)
	}
	
	def queuedAnnotation() {
		annotation(QUEUED)
	}

	def isQueued(AnnotatableElement it) {
		isAnnotatedWith(QUEUED)
	}
	
	def statemachineTypeAnnotation() {
		annotation(STATEMACHINE_TYPE)
	}

	def isStatemachineType(AnnotatableElement it) {
		isAnnotatedWith(STATEMACHINE_TYPE)
	}
}
