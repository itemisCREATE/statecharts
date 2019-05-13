package org.yakindu.sct.types.generator.annotation

import com.google.inject.Singleton
import org.yakindu.base.types.AnnotatableElement
import org.yakindu.base.types.TypesFactory

@Singleton
class CoreGeneratorAnnotationLibrary implements CoreGeneratorAnnotationConstants {
	TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	protected def isAnnotatedWith(AnnotatableElement it, String annotationName) {
		getAnnotationOfType(annotationName) !== null
	}
	
	protected def annotation(String name) {
		typesFactory.createAnnotationType => [
			it.name = name
		]
	}
	
}