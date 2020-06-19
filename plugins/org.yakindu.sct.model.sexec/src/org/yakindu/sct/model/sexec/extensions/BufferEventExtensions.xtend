package org.yakindu.sct.model.sexec.extensions

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.Event
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

class BufferEventExtensions {
	
	public static String BUFFER_EVENT_ANNOTATION = "__buffer_event__"
	
	extension TypesFactory tFactory = TypesFactory.eINSTANCE
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder

		
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