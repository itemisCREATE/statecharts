/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.SGraphFactory
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.TypedDeclaration
import org.yakindu.base.base.NamedElement

class StructureMapping {
	 
	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sct
	@Inject extension IQualifiedNameProvider
	@Inject extension StatechartUtil
	@Inject extension OriginTracing
	@Inject extension ExpressionBuilder
	@Inject extension ExpressionExtensions
	
	
	//==========================================================================
	// DECLARATION SCOPE MAPPING
	//
	
	/**
	 * maps all required scope defined in the statechart to the execution flow.
	 * This includes creating the scopes and adding all relevant declarations. Empty scopes wont be mapped.
	 */
	def ExecutionFlow mapScopes(Statechart sc, ExecutionFlow flow) {
		val usedDeclarations = sc.importedDeclarations
		flow.scopes.addAll(sc.scopes.map(scope | scope.mapScope(usedDeclarations)))
		flow
	}
	
	/**
	 * @return A set of used declaration that are imported from an external resource
	 */
	def protected importedDeclarations(Statechart it) {
		val allDeclarations = it.eAllContents.filter(ElementReferenceExpression).map[reference].filter(Declaration).toSet
		return if(it.eResource !== null)
			allDeclarations.filter[decl|!decl.eResource.URI.equals(it.eResource.URI)].toSet
		else allDeclarations
	}
	
	
	/**
	 *  Interface and internal scopes have declarations
	 */
	def dispatch Scope mapScope(Scope scope, Set<Declaration> usedDeclarationss) {
		val _scope = scope.createScope
		_scope.declarations.addAll(scope.declarations.map(decl | decl.map).filterNull)
		return _scope
	}
	
	/**
	 * Import scope has imports which needs to be resolved to get all imported variable and operation definitions
	 */
	def dispatch Scope mapScope(ImportScope scope, Set<Declaration> usedDeclarations) {
		val _scope = scope.createScope
		usedDeclarations.forEach[createImportDeclaration(_scope)]
		return _scope
	}
	
	protected dispatch def createImportDeclaration(Property decl, Scope scope) {
		decl.doCreateAndAddImportDecl(scope)
	}

	protected dispatch def createImportDeclaration(Operation decl, Scope scope) {
		decl.doCreateAndAddImportDecl(scope)
	}
	
	protected def doCreateAndAddImportDecl(Declaration decl, Scope scope){
		scope.members += SGraphFactory.eINSTANCE.createImportDeclaration => [
			name = decl.name
			declaration = decl
		]
	}
	
	protected dispatch def createImportDeclaration(EObject decl, Scope scope) {
		// Nothing to do
	}

	def dispatch Declaration map(Declaration decl) {
	}
	
	def dispatch Declaration map(EventDefinition e) {
		e.create
	}
	
	def dispatch Declaration map(VariableDefinition v) {
		v.create
	}
	def dispatch Declaration map(OperationDefinition v) {
		v.create
	}
	 
	
	//==========================================================================
	// REGULAR STATE MAPPING
	//

		
	def ExecutionFlow mapRegularStates(Statechart statechart, ExecutionFlow r){
		val allStates = statechart.allRegularStates
		r.states.addAll(allStates.map( s | s.mapState));
		return r
	}

	def dispatch ExecutionState mapState(FinalState state) {
		val _state = state.create
		_state.leaf = true
		_state.entryAction = null
		_state.exitAction = null
		return _state		
	}
	
	def dispatch ExecutionState mapState(State state) {
		val _state = state.create
		_state.leaf = state.simple
		return _state
	}
	 
	def dispatch ExecutionState mapState(RegularState state) {}

	
	//==========================================================================
	// REGION MAPPING
	//
	
	def ExecutionFlow mapRegions(Statechart statechart, ExecutionFlow flow){
		val allRegions = statechart.allRegions
		flow.regions.addAll( allRegions.map( r | r.mapRegion));
		return flow	
	}
	
	
	def ExecutionRegion mapRegion(Region region) {
		val _region = region.create
		
		if ( region.composite instanceof Statechart ) _region.superScope = (region.composite as Statechart).create
		else _region.superScope = (region.composite as State).create

		_region.subScopes.addAll( region.vertices.filter( typeof(RegularState) ).map( v | v.create as ExecutionScope ) )
		_region.nodes.addAll( region.vertices.filter( typeof(Vertex) ).map( v | v.mapped  ) )

		return _region
	}
	
	
	//==========================================================================
	// PSEUDO STATE MAPPING
	//

	def ExecutionFlow mapPseudoStates(Statechart statechart, ExecutionFlow r){
		r.nodes.addAll( statechart.allChoices.map( choice | choice.create ) );
		r.nodes.addAll( statechart.allEntries.map( entry | entry.create ) );
		r.nodes.addAll( statechart.allExits.map( exit | exit.create ) );
		r.nodes.addAll( statechart.allSynchronizations.map( sync | sync.create ) );
		return r
	}

	
	
	//==========================================================================
	// TIME EVENT MAPPING
	//
	
	/** Time trigger will be mapped to execution model time events for each real state. */
	def ExecutionFlow mapTimeEvents(Statechart statechart, ExecutionFlow r) {
		var content = EcoreUtil2::eAllContentsAsList(statechart)
		val allStates = content.filter(typeof(State))
		allStates.forEach( s | s.mapTimeEventSpecs)
		statechart.mapTimeEventSpecs
		return r
	}
	
	
	
	def mapTimeEventSpecs(State state) {
		
		val timeEventSpecs = state.timeEventSpecs
		
		val result = new ArrayList<TimeEvent>();
		for (tes : timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			timeEvent.name = state.fullyQualifiedName + "_time_event_" + timeEventSpecs.indexOf(tes);
			state.statechart.create.timeEventScope.declarations.add(timeEvent);
			result.add(timeEvent);
			
		}	
		
		result
	}
	
	
	def mapTimeEventSpecs(Statechart statechart) {
		
		val timeEventSpecs = statechart.timeEventSpecs
		
		val result = new ArrayList<TimeEvent>();
		for (tes : timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			timeEvent.name = statechart.name + "_time_event_" + timeEventSpecs.indexOf(tes);
			statechart.create.timeEventScope.declarations.add(timeEvent);
			result.add(timeEvent);
			
		}	
		
		result
	}
	
	//==========================================================================
	// REFERENCED MACHINE OUT EVENT MAPPING
	//
	
	/** creates shadow variables for referenced machines' out events */
	def mapReferencedMachineOutEvents(Statechart statechart, ExecutionFlow flow) {
		// get all references to out events of submachines
		val allContent = EcoreUtil2::eAllContentsAsList(flow)
		val allFeatureCalls = allContent.filter(FeatureCall)
		val outEventCalls = allFeatureCalls.filter[feature instanceof Event && (feature as Event).direction == Direction.OUT]
		val submachineOutEventCalls = outEventCalls.filter[isCallOnStatechartMember(it, statechart)]
		
		submachineOutEventCalls.forEach[fc |
			val submachineMember = fc.toCallStack.map[featureOrReference].findFirst[isStatechartRef]
			val outEvent = fc.feature as Event
			val shadowEventName = fc.shadowEventName
			val shadowEvent = createShadowEvent(shadowEventName, outEvent, flow)
			// trace to statechart event, not the one in the statechart type
			shadowEvent.traceOrigin(outEvent.originTraces.filter(Event).head)
			// also trace to submachine member, so we can properly trace back later based on (member, event)
			shadowEvent.traceOrigin(submachineMember)
			// retarget feature call to new shadow event
			EcoreUtil.replace(fc, shadowEvent._ref)
		]
	}
	
	/**
	 * Returns true if the feature call is on a statechart reference which is a direct member of the given statechart, e.g.
	 * <br><br>
	 * <code>submachine.outEvent</code> or 
	 * <br>
	 * <code>submachine.Iface.outEvent</code>.
	 * <br>
	 * Returns false otherwise, especially when the owner is not a direct member of the given statechart, e.g.
	 * <br><br>
	 * <code>submachine1.submachine2.outEvent</code>.
	 * 
	 */
	protected def isCallOnStatechartMember(FeatureCall it, Statechart statechart) {
		val statechartRefs = toCallStack.map[featureOrReference].filter[isStatechartRef]
		if (statechartRefs.size !== 1) return false
		
		val statechartContainer = EcoreUtil2.getContainerOfType(statechartRefs.head, ExecutionFlow)?.sourceElement
		return (statechartContainer !== null && statechart == statechartContainer)
	}
	
	protected def dispatch isStatechartRef(EObject it) {
		false
	}
	
	protected def dispatch isStatechartRef(TypedDeclaration it) {
		type.isOriginStatechart
	}
	
	protected def shadowEventName(FeatureCall fc) {
		fc.toCallStack.map[featureOrReference].filter(NamedElement).map[name].join("_")
	}
	
	protected def create StextFactory.eINSTANCE.createEventDefinition createShadowEvent(String shadowEventName, Event originEvent, ExecutionFlow flow) {
		name = shadowEventName
		direction = Direction.IN
		typeSpecifier = EcoreUtil.copy(originEvent.typeSpecifier)
		
		flow.shadowMemberScope.members += it
	}

	protected def Scope create StextFactory.eINSTANCE.createInternalScope shadowMemberScope(ExecutionFlow flow) {
		flow.scopes += it
	}
	
}