package org.yakindu.sct.types.common.library

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.types.common.library.CoreAnnotationConstants

@Singleton
class CoreAnnotationLibrary implements CoreAnnotationConstants {
	TypesFactory typesFactory = TypesFactory.eINSTANCE
	@Inject TypeBuilder typeBuilder
	
	protected def isAnnotatedWith(AnnotatableElement it, String annotationName) {
		getAnnotationOfType(annotationName) !== null
	}
	
	protected def annotation(String name) {
		typesFactory.createAnnotationType => [
			it.name = name
		]
	}
	
	def annotateWith(AnnotatableElement it, AnnotationType annotationType) {
		typeBuilder._annotateWith(it, annotationType)
	}
	
	def annotateWith(AnnotatableElement it, String annotationName) {
		typeBuilder._annotateWith(it, annotation(annotationName))
	}
	
}
