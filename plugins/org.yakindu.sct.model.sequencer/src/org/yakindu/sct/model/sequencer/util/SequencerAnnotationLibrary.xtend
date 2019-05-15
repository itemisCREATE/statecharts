package org.yakindu.sct.model.sequencer.util

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.model.sequencer.ModelSequencerNaming
import org.yakindu.sct.types.common.library.CoreAnnotationLibrary

@Singleton
class SequencerAnnotationLibrary extends CoreAnnotationLibrary {
	@Inject protected extension ModelSequencerNaming
	
	def interfaceGroupAnnotation() {
		annotation(interfaceTypeAnnotationName)
	}

	def isInterfaceGroup(AnnotatableElement it) {
		isAnnotatedWith(interfaceTypeAnnotationName)
	}

	def APIAnnotation() {
		annotation(interfaceTypeAnnotationName)
	}

	def isAPI(AnnotatableElement it) {
		isAnnotatedWith(interfaceTypeAnnotationName)
	}
	
	def internalScopeAnnotation() {
		annotation(internalScopeTypeAnnotationName)
	}
	
	def isInternalScope(AnnotatableElement it) {
		isAnnotatedWith(internalScopeTypeAnnotationName)
	}
}