package org.yakindu.sct.generator.core.multism

import com.google.inject.Inject
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl
import org.yakindu.base.types.ComplexType
import org.yakindu.sct.model.sexec.transformation.IModelSequencer
import org.yakindu.sct.model.sgraph.Statechart

class MultiStatemachineHelper {
	@Inject IModelSequencer sequencer;

	def create type.createExecutionFlow refFlow(ComplexType type) {
	}

	def createExecutionFlow(ComplexType type) {
		val res = type.eResource
		if (res === null)
			throw (new IllegalStateException('''Resource of ComplexType '«type»' should not be null!'''))
		val dynamic = res.contents.filter(DynamicEObjectImpl).head
		if (dynamic === null)
			throw (new IllegalStateException('''DynamicEObjectImpl of ComplexType '«type»' should not be null!'''))
		val sct = dynamic.eCrossReferences.filter(Statechart).head
		return sequencer.transform(sct);
	}
}
