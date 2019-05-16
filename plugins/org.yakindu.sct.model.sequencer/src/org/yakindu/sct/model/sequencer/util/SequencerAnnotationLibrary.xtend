package org.yakindu.sct.model.sequencer.util

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.model.sequencer.ModelSequencerNaming
import org.yakindu.sct.types.common.library.CoreAnnotationLibrary

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.CYCLE_BASED_ANNOTATION

@Singleton
class SequencerAnnotationLibrary extends CoreAnnotationLibrary {
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
	
	def eventDrivenAnnotation(AnnotatableElement it) {
		annotation(EVENT_DRIVEN_ANNOTATION)
	}

	def isEventDriven(AnnotatableElement it) {
		getAnnotationOfType(EVENT_DRIVEN_ANNOTATION) !== null
	}

	def cycleBasedAnnotation(AnnotatableElement it) {
		annotation(CYCLE_BASED_ANNOTATION)
	}

	def isCycleBased(AnnotatableElement it) {
		getAnnotationOfType(CYCLE_BASED_ANNOTATION) !== null
	}

}