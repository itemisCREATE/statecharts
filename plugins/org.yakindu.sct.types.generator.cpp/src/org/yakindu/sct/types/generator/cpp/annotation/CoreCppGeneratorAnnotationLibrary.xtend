package org.yakindu.sct.types.generator.cpp.annotation

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary

@Singleton
class CoreCppGeneratorAnnotationLibrary extends CoreGeneratorAnnotationLibrary implements CoreCppGeneratorAnnotationConstants {
	
	def virtualAnnotation() {
		createAnnotationType => [
			name = VIRTUAL
		]
	}
	
	def isVirtual(AnnotatableElement it) {
		isAnnotatedWith(VIRTUAL)
	}
}