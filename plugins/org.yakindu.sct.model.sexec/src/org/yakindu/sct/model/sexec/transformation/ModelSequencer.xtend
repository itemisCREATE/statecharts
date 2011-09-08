package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.SexecFactory
import org.eclipse.xtext.xtend2.lib.EObjectExtensions
import org.eclipse.xtext.xbase.lib.CollectionExtensions
import org.eclipse.emf.common.util.TreeIterator
import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.sct.model.sexec.Cycle

class ModelSequencer {
	
	@Inject extension IQualifiedNameProvider qfnProvider

	def ExecutionFlow create r : SexecFactory::eINSTANCE.createExecutionFlow transform(Statechart statechart){
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val leafStates = content.filter(e | e instanceof State && (e as State).simple)
		r.states.addAll(leafStates.map( s | (s as State).transform));
	}
	
	
	def ExecutionState create r : SexecFactory::eINSTANCE.createExecutionState transform(State state){
		r.simpleName = state.name
		r.name = state.fullyQualifiedName.toString.replaceAll(" ", "")
	}
	
	
}