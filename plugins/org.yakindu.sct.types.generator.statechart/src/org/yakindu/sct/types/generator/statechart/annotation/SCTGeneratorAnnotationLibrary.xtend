package org.yakindu.sct.types.generator.statechart.annotation

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary

@Singleton
class SCTGeneratorAnnotationLibrary extends CoreGeneratorAnnotationLibrary implements SCTGeneratorAnnotationConstants {
	
	def interfaceGroupAnnotation() {
		createAnnotationType => [
			name = INTERFACE_GROUP
		]
	}
	
	def isInterfaceGroup(AnnotatableElement it) {
		isAnnotatedWith(INTERFACE_GROUP)
	}
}