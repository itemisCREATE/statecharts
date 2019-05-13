package org.yakindu.sct.types.generator.c.annotation

import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.types.generator.annotation.CoreGeneratorAnnotationLibrary

class CoreCGeneratorAnnotationLibrary extends CoreGeneratorAnnotationLibrary implements CoreCGeneratorAnnotationConstants {
	def defineAnnotation() {
		annotation(DEFINE)
	}
	
	def isDefine(AnnotatableElement it) {
		isAnnotatedWith(DEFINE)
	}
}
