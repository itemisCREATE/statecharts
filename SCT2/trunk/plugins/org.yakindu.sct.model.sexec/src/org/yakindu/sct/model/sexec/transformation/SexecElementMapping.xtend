package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.Strings
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.ExecutionChoice
import org.yakindu.sct.model.sexec.ExecutionEntry
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.CompositeElement
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.EntryKind
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.DefaultEvent
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.OnCycleEvent
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.TimeEventType
import org.yakindu.sct.model.stext.stext.VariableDefinition
 

@Singleton class SexecElementMapping {
	
	  
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension StatechartExtensions sce
	@Inject extension SgraphExtensions sgraph
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	

	def ExecutionFlow create r : sexecFactory.createExecutionFlow create(Statechart statechart){
		r.name = statechart.name
		r.sourceElement = statechart
	}

	def dispatch Scope create r : stextFactory.createInterfaceScope  create(InterfaceScope scope) {
		r.name = scope.name
	}
	
	def dispatch Scope create r : stextFactory.createInternalScope  create(Scope scope) {}
	
	
	
	def Scope create r : sgraph.factory.createScope timeEventScope(ExecutionFlow flow) {
		flow.scopes.add(r);
	}
	
	
	def EventDefinition create r : EcoreUtil::copy(event) create(EventDefinition event) {}
	
	def VariableDefinition create r : EcoreUtil::copy(v) create(VariableDefinition v) {}
	
	def OperationDefinition create r : EcoreUtil::copy(v) create(OperationDefinition v) {}
	
	
	def ExecutionState create r : sexecFactory.createExecutionState create(RegularState state){
		if (state != null) {
			val n = state.parentRegion.vertices.filter(typeof (FinalState)).toList.indexOf(state)
			r.simpleName = if (state instanceof FinalState) "_final_"+n else state.name
			r.name = state.fullyQualifiedName.toString.replaceAll(" ", "")	
			r.sourceElement = state	
		}
	}
	
	def ExecutionChoice create r : sexecFactory.createExecutionChoice create(Choice choice){
		if (choice != null) {
			val n = choice.parentRegion.vertices.filter( typeof ( Choice) ).toList.indexOf(choice)
			r.simpleName =   "_choice" + n + "_"
			r.name = choice.fullyQualifiedName.toString.replaceAll(" ", "")	
			r.sourceElement = choice	
			r.reactSequence = sexecFactory.createSequence
		}
	}


	def ExecutionEntry create r : sexecFactory.createExecutionEntry create(Entry entry){
		if (entry != null) {
			val region = entry.eContainer as Region
			val regionName = region.name.toFirstUpper
			val stateName = if(region.eContainer instanceof State) {(region.eContainer as State).name.toFirstUpper}
			val entryName = {if (!entry.name?.empty) entry.name else "_entry_Default"}
			r.simpleName = {if (regionName!= null)regionName else ""}+"_"+{if (stateName!= null)stateName else ""}+"_"+entryName
			r.name = entry.fullyQualifiedName.toString.replaceAll(" ", "")	
			r.sourceElement = entry	
			val seq = sexec.factory.createSequence
			seq.name = "react"
			seq.comment = "Default react sequence for "+switch (entry.kind) {
					case EntryKind::INITIAL: "initial "
					case EntryKind::DEEP_HISTORY: "deep history "
					case EntryKind::SHALLOW_HISTORY: "shallow history "
					default: ""
				}+"entry " + entry.name

			r.reactSequence = seq
		}
	}
	
	
	def ExecutionRegion create r : sexecFactory.createExecutionRegion create(Region region){
		if (region != null) {
			if (Strings::isEmpty(region.name)) {
				val container = region.eContainer as CompositeElement
				val index = container.regions.indexOf(region)
				r.name = "region"+index
			} else {
				r.name =  region.name
			}
			r.sourceElement = region
		}
	}
	
	
	def Check create r : sexecFactory.createCheck createCheck(ReactionTrigger tr){
		r.name = tr.reaction.id
	}
	
	def Reaction create r : sexecFactory.createReaction create(Transition tr){
		r.name = tr.id
		r.transition = true
		r.sourceElement = tr
	}
	
	def Reaction create r : sexecFactory.createReaction create(LocalReaction lr){
		r.name = lr.id
		r.transition = false
	}
	
	def CheckRef newRef(Check check) {
		val r = sexecFactory.createCheckRef
		r.check = check
		r
	} 

	def Call newCall(Step step) {
		val r = sexecFactory.createCall
		r.step = step
		r
	} 
	
	def ScheduleTimeEvent newScheduleTimeEvent(TimeEvent te, Statement timeValue) {
		val r = sexecFactory.createScheduleTimeEvent
		r.timeEvent = te
		r.timeValue = timeValue
		r
	}
	 
	
	def UnscheduleTimeEvent newUnscheduleTimeEvent(TimeEvent te) {
		val r = sexecFactory.createUnscheduleTimeEvent
		r.timeEvent = te
		r
	}
 

	def TimeEvent create r : sexecFactory.createTimeEvent createDerivedEvent(TimeEventSpec tes) {
		r.periodic = (tes.type == TimeEventType::EVERY)
	}
	
	def dispatch Expression raised(EventSpec e) {
	}

	def dispatch Expression raised(RegularEventSpec e) {
		val r = stext.factory.createElementReferenceExpression
		r.reference = e.resolveRegularEventSpec(e.eContainer)
		return r
	} 	 
	
	def dispatch NamedElement resolveRegularEventSpec(Object o, Object context) { null }
	def dispatch NamedElement resolveRegularEventSpec(RegularEventSpec re, Object context) { if ( re.event != null ) re.event.resolveRegularEventSpec(re) }
	def dispatch NamedElement resolveRegularEventSpec(FeatureCall fc, Object context) { if (fc.feature != null) fc.feature.resolveRegularEventSpec(fc) }
	def dispatch NamedElement resolveRegularEventSpec(ElementReferenceExpression ter, Object context) { if (ter.reference != null) ter.reference.resolveRegularEventSpec(ter) }
	def dispatch NamedElement resolveRegularEventSpec(EventDefinition ed, Object context) { ed.create }
	
	
	def dispatch Expression raised(TimeEventSpec e) {
		val r = stext.factory.createElementReferenceExpression
		r.reference = e.createDerivedEvent
		return r
	}

	def dispatch Expression raised(OnCycleEvent e) {
		val r = stext.factory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stext.factory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}
	
	def dispatch Expression raised(AlwaysEvent e) {
		val r = stext.factory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stext.factory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}

	def dispatch Expression raised(DefaultEvent e) {
		val r = stext.factory.createPrimitiveValueExpression
		val BoolLiteral boolLit = stext.factory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}

	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
	
}