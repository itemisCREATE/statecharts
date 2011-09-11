package org.yakindu.sct.model.sexec.transformation

/**
 * This extension class defines all factory (create) functions that are required 
 * for creating a flow element based on a statechrt source element. Thus most create functions are parametrized 
 * by elements from the source statechart. 
 * 
 * @author axel terfloth
 */

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider

import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Scope
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class FactoryExtension {
	
	
	@Inject extension IQualifiedNameProvider qfnProvider


	def dispatch Scope create r : stextFactory.createInterfaceScope  create(InterfaceScope scope) {
		r.name = scope.name
	}
	
	def dispatch Scope create r : stextFactory.createInternalScope  create(InternalScope scope) {}
	
	
	def EventDefinition create r : EcoreUtil::copy(event) create(EventDefinition event) {}
	
	def VariableDefinition create r : EcoreUtil::copy(v) create(VariableDefinition v) {}
	
	
	def ExecutionState create r : sexecFactory.createExecutionState create(State state){
		r.simpleName = state.name
		r.name = state.fullyQualifiedName.toString.replaceAll(" ", "")
	}
	
	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
	
}