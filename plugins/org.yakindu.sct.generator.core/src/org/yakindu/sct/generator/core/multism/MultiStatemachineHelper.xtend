package org.yakindu.sct.generator.core.multism

import com.google.inject.Inject
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl
import org.yakindu.base.types.ComplexType
import org.yakindu.sct.model.sexec.transformation.IModelSequencer
import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.emf.ecore.resource.Resource

class MultiStatemachineHelper {
	@Inject IModelSequencer sequencer;

	def executionFlow(ComplexType type) {
		type.statechart.executionFlow
	}
	
	def create sequencer.transform(sct) executionFlow(Statechart sct) {}
	
	def isStatechartType(ComplexType type) {
		return type.statechart !== null
	}
	
	def getStatechart(ComplexType type) {
		val res = type.eResource
		if (res === null)
			throw (new IllegalStateException('''Resource '«res»' of ComplexType '«type»' should not be null!'''))
		
		return res.statechart
	}
	
	def getStatechart(Resource res) {
		val dynamic = res.contents.filter(DynamicEObjectImpl).head
		if (dynamic === null)
			return null
		return dynamic.eCrossReferences.filter(Statechart).head
	}

}
