package org.yakindu.sct.types.generator.statechart.annotation

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary

@Singleton
class SCTGeneratorAnnotationLibrary extends CoreGeneratorAnnotationLibrary implements SCTGeneratorAnnotationConstants {

	def interfaceGroupAnnotation() {
		annotation(INTERFACE_GROUP)
	}

	def isInterfaceGroup(AnnotatableElement it) {
		isAnnotatedWith(INTERFACE_GROUP)
	}

	def APIAnnotation() {
		annotation(INTERFACE_GROUP)
	}

	def isAPI(AnnotatableElement it) {
		isAnnotatedWith(INTERFACE_GROUP)
	}
}
