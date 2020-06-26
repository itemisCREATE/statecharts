/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.annotations

import org.yakindu.base.types.AnnotatableElement

/**
 * Used for defining the visibility of elements using annotations.
 * 
 * Currently public (annotated) and default (not annotated) visibility is supported.
 * Public elements should be exposed in the types public interface.
 * 
 * @author axel terfloth
 */
class VisibilityAnnotations {

	public static String PUBLIC_ANNOTATION = "__public__"


	def isPublic(AnnotatableElement it){
		annotations.exists[ a | a.type.name == PUBLIC_ANNOTATION]		
	}
	
}