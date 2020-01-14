package org.yakindu.sct.generator.core.multism

import com.google.inject.Inject
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl
import org.yakindu.base.types.ComplexType
import org.yakindu.sct.model.sexec.transformation.IModelSequencer
import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.emf.ecore.resource.Resource
import org.yakindu.base.types.adapter.OriginTracing

class MultiStatemachineHelper {
	@Inject IModelSequencer sequencer;
	
	@Inject extension OriginTracing

	def executionFlow(ComplexType type) {
		type.statechart.executionFlow
	}
	
	def create sequencer.transform(sct) executionFlow(Statechart sct) {}
	
	def isStatechartType(ComplexType type) {
		return type.statechart !== null
	}
	
	def getStatechart(ComplexType type) {
		type.originTraces.filter(Statechart).head
	}
	
	def getStatechart(Resource res) {
		val dynamic = res.contents.filter(DynamicEObjectImpl).head
		if (dynamic === null)
			return null
		return dynamic.eCrossReferences.filter(Statechart).head
	}

}
