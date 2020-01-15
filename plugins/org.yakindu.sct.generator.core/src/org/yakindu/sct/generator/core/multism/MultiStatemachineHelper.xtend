package org.yakindu.sct.generator.core.multism

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.sct.model.sexec.transformation.IModelSequencer
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.util.StatechartUtil

class MultiStatemachineHelper {
	@Inject IModelSequencer sequencer;
	
	@Inject extension StatechartUtil

	def executionFlow(ComplexType type) {
		type.getOriginStatechart.executionFlow
	}
	
	def create sequencer.transform(sct) executionFlow(Statechart sct) {}

}
