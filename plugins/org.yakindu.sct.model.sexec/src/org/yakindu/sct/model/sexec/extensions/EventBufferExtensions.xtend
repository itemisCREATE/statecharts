package org.yakindu.sct.model.sexec.extensions

import org.yakindu.base.types.Type

class EventBufferExtensions {

	public static String EVENT_BUFFER_ANNOTATION = "__event_buffer__"


	def isEventBuffer(Type it){
		annotations.exists[ a | a.type.name == EVENT_BUFFER_ANNOTATION]		
	}
	
}