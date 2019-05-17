package org.yakindu.sct.types.common.library

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.TypesFactory

@Singleton
class CoreAnnotationLibrary implements CoreAnnotationConstants {
	TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	protected def isAnnotatedWith(AnnotatableElement it, String annotationName) {
		getAnnotationOfType(annotationName) !== null
	}
	
	protected def AnnotationType create typesFactory.createAnnotationType annotation(String name) {
		it.name = name
	}	
}
