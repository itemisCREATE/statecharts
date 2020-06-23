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
package org.yakindu.sct.model.sexec.concepts

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.Event
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory

/**
 * This class defines the general concept of buffer events. Such events are used in event buffers. 
 * 
 * @author aterfloth
 */
@Singleton
class BufferEvent {
	
	public static String BUFFER_EVENT_ANNOTATION = "__buffer_event__"
	
	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	@Inject extension TypeBuilder

		
	def create tFactory.createEvent createBufferEvent(Event bufferedEvent) {

		name = bufferedEvent.name
		direction = bufferedEvent.direction
		typeSpecifier = EcoreUtil.copy(bufferedEvent.typeSpecifier)
		if ( type !== null && type != _void ) _meta(_variable("value", type))
		_annotate(BUFFER_EVENT_ANNOTATION)
	}
	
	
	def isBufferEvent(Event it){
		annotations.exists[ a | a.type.name == BUFFER_EVENT_ANNOTATION]		
	}
	
}