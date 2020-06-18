package org.yakindu.base.types.annotations

import org.yakindu.base.types.AnnotatableElement

class VisibilityAnnotations {

	public static String PUBLIC_ANNOTATION = "__public__"


	def isPublic(AnnotatableElement it){
		annotations.exists[ a | a.type.name == PUBLIC_ANNOTATION]		
	}
	
}