package org.yakindu.sct.types.generator.statechart.modification.library.event

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.EventValueReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property

/**
 * Transforms <code>valueof(e)</code> into access to value property <code>eValue</code>
 */
class ValueOfEventModification {
	
	@Inject extension ExpressionExtensions
	
	def modifyValueOfEvent(Property valueProp, Event e) {
		var valueOfExpressions = EcoreUtil2.getRootContainer(e).eAllContents.filter(EventValueReferenceExpression).filter[value.featureOrReference.equals(e)].toList
		for (valueOf : valueOfExpressions) {
			EcoreUtil.replace(valueOf, valueOf.value.toReference(valueProp))
		}
	}
	
	protected def dispatch toReference(FeatureCall fc, Property prop) {
		fc.feature = prop
		fc
	}
	
	protected def dispatch toReference(ElementReferenceExpression ere, Property prop) {
		ere.reference = prop
		ere
	}
	
	protected def dispatch toReference(Expression ere, Property prop) {}
}
