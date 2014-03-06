package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.Strings
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.ExecutionChoice
import org.yakindu.sct.model.sexec.ExecutionEntry
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExecutionSynchronization
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
import org.yakindu.sct.model.sgraph.Exit
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.TimeEventType
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.sct.model.stext.stext.ImportScope

@Singleton class SexecElementMapping {
	
	  
	@Inject extension IQualifiedNameProvider qfnProvider
	@Inject extension StatechartExtensions sce
	@Inject extension SgraphExtensions sgraph
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	

	def  ExecutionFlow create r : sexecFactory.createExecutionFlow create(Statechart statechart){
		r.name = statechart.name
		r.sourceElement = statechart
	}

	def dispatch Scope create r : stextFactory.createInterfaceScope  createScope(InterfaceScope scope) {
		r.name = scope.name
	}
	
	def dispatch Scope create r : stextFactory.createImportScope  createScope(ImportScope scope) {}
	
	def dispatch Scope create r : stextFactory.createInternalScope  createScope(Scope scope) {}
	
	def Scope create r : sgraph.factory.createScope timeEventScope(ExecutionFlow flow) {
		flow.scopes.add(r);
	}
	
	def cleanup() {
		_createCache_create.clear
		_createCache_createCheck.clear
		_createCache_createDerivedEvent.clear
		_createCache_create_1.clear
		_createCache_create_10.clear
		_createCache_createScope.clear
		_createCache_createScope_1.clear
		_createCache_create_2.clear
		_createCache_create_3.clear
		_createCache_create_4.clear
		_createCache_create_5.clear
		_createCache_create_6.clear
		_createCache_create_7.clear
		_createCache_create_8.clear
		_createCache_create_9.clear
		_createCache_timeEventScope.clear
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
			entry.outgoingTransitions.forEach(t | r.reactions+=t.create)
		}
	}
	
	
	def ExecutionEntry create r : sexecFactory.createExecutionEntry create(Exit exit){
		if (exit != null) {
			val region = exit.eContainer as Region
			val regionName = region.name.toFirstUpper
			val stateName = if(region.eContainer instanceof State) {(region.eContainer as State).name.toFirstUpper}
			val exitName = {if (!exit.name?.empty) exit.name else "default"}
			r.simpleName = {if (regionName!= null)regionName else ""}+"_"+{if (stateName!= null)stateName else ""}+"_"+exitName
			r.name = exit.fullyQualifiedName.toString.replaceAll(" ", "")	
			r.sourceElement = exit	
			val seq = sexec.factory.createSequence
			seq.name = "react"
			seq.comment = "Default react sequence for exit " + exitName

			r.reactSequence = seq
			exit.outgoingTransitions.forEach(t | r.reactions+=t.create)
		}
	}
	
	
	def ExecutionSynchronization create r : sexecFactory.createExecutionSynchronization create(Synchronization sync){
		if (sync != null) {
			val n = sync.parentRegion.vertices.filter( typeof ( Synchronization) ).toList.indexOf(sync)
			r.simpleName =   "_sync" + n + "_"
			r.name = sync.fullyQualifiedName.toString.replaceAll(" ", "")	
			r.sourceElement = sync	
			r.reactSequence = sexecFactory.createSequence
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
	
	
	def Check create r : sexecFactory.createCheck createCheck(Trigger tr){
		r.name = tr.reaction.id
	}

//	def dispatch Check create r : sexecFactory.createCheck createCheck(DefaultTrigger tr){
//		r.name = tr.reaction.id
//	}
//
//	def dispatch Check createCheck(Trigger tr){
//	}
	
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
	
	def ScheduleTimeEvent newScheduleTimeEvent(TimeEvent te, Expression timeValue) {
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

	var factory = ExpressionsFactory.eINSTANCE
	def dispatch Expression raised(RegularEventSpec e) {
		val r = factory.createElementReferenceExpression
		r.reference = e.resolveRegularEventSpec(e.eContainer)
		return r
	} 	 
	
	def dispatch NamedElement resolveRegularEventSpec(Object o, Object context) { null }
	def dispatch NamedElement resolveRegularEventSpec(RegularEventSpec re, Object context) { if ( re.event != null ) re.event.resolveRegularEventSpec(re) }
	def dispatch NamedElement resolveRegularEventSpec(FeatureCall fc, Object context) { if (fc.feature != null) fc.feature.resolveRegularEventSpec(fc) }
	def dispatch NamedElement resolveRegularEventSpec(ElementReferenceExpression ter, Object context) { if (ter.reference != null) ter.reference.resolveRegularEventSpec(ter) }
	def dispatch NamedElement resolveRegularEventSpec(EventDefinition ed, Object context) { ed.create }
	
	
	def dispatch Expression raised(TimeEventSpec e) {
		val r = factory.createElementReferenceExpression
		r.reference = e.createDerivedEvent
		return r
	}

//	def dispatch Expression raised(OnCycleEvent e) {
//		val r = stext.factory.createPrimitiveValueExpression
//		val BoolLiteral boolLit = stext.factory.createBoolLiteral
//		boolLit.value = true		
//		r.value = boolLit
//		return r
//	}
	
	def dispatch Expression raised(AlwaysEvent e) {
		val r = factory.createPrimitiveValueExpression
		val BoolLiteral boolLit = factory.createBoolLiteral
		boolLit.value = true		
		r.value = boolLit
		return r
	}


	def dispatch ExecutionNode mapped(State s) { s.create }
	def dispatch ExecutionNode mapped(FinalState s) { s.create }
	def dispatch ExecutionNode mapped(Choice s) { s.create }
	def dispatch ExecutionNode mapped(Entry s) { s.create }
	def dispatch ExecutionNode mapped(Exit s) { s.create }
	def dispatch ExecutionNode mapped(Synchronization s) { s.create }


	//--------- UTILS ---------------
	def sexecFactory() { SexecFactory::eINSTANCE }
	def stextFactory() { StextFactory::eINSTANCE }
	
}