package org.yakindu.sct.types.generator.annotation

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.sct.types.common.library.CoreAnnotationLibrary

@Singleton
class CoreGeneratorAnnotationLibrary extends CoreAnnotationLibrary implements CoreGeneratorAnnotationConstants {
 
 	def APIAnnotation() {
		annotation(API_GROUP)
	}

	def isAPI(AnnotatableElement it) {
		isAnnotatedWith(API_GROUP)
	}
	
}