package org.yakindu.sct.types.generator.statechart.annotation

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary

@Singleton
class SCTGeneratorAnnotationLibrary extends CoreGeneratorAnnotationLibrary implements SCTGeneratorAnnotationConstants {
	def APIAnnotation() {
		annotation(API_GROUP)
	}

	def isAPI(AnnotatableElement it) {
		isAnnotatedWith(API_GROUP)
	}
}
