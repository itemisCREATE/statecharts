package org.yakindu.sct.types.generator.modification.library

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Declaration

class ReferenceExtension {
	
	@Inject protected extension ExpressionBuilder
	
	def List<EObject> references(EObject target) {
		UsageCrossReferencer.find(target, EcoreUtil2.getRootContainer(target)).map[EObject].toList
	}
	
	def dispatch retargetTo(EObject e, Declaration target) {
		throw new IllegalStateException("Could not retarget reference from " + e + " to " + target)
	}
	
	def dispatch retargetTo(ElementReferenceExpression ere, Declaration target) {
		ere.reference = target
	}
	
	def dispatch retargetTo(FeatureCall fc, Declaration target) {
		fc.feature = target
	}
	
	def dispatch unqualify(EObject e) { }
	
	def dispatch unqualify(FeatureCall fc) { 
		val newRef = fc.feature._ref._with(fc.arguments.map[value])
		EcoreUtil.replace(fc, newRef)
	}
	
	def dispatch unqualify(ElementReferenceExpression ref) {
		if (ref.eContainer instanceof FeatureCall) {
			val fc = ref.eContainer as FeatureCall
			val newRef = fc.feature._ref._with(fc.arguments.map[value])
			EcoreUtil.replace(fc, newRef)
		}
	}
	
	def dispatch qualifyWith(EObject oldRef, Declaration owner) {
		throw new IllegalStateException("Could not qualify reference " + oldRef)
	}
	
	/**
	 * Transforms a reference expression b into a feature call owner.b
	 */
	def dispatch qualifyWith(ElementReferenceExpression oldRef, Declaration owner) {
		val newRef = owner._ref._fc(oldRef.reference as Declaration)._with(oldRef.arguments.map[it.value])
		EcoreUtil.replace(oldRef, newRef)
	}
	
	/**
	 * Transforms a feature call, A.b into A.owner.b
	 */
	def dispatch qualifyWith(FeatureCall oldFc, Declaration owner) {
		val newFc = oldFc.owner._fc(owner)._fc(oldFc.feature)._with(oldFc.arguments.map[it.value])
		EcoreUtil.replace(oldFc, newFc)
	}
	
}
