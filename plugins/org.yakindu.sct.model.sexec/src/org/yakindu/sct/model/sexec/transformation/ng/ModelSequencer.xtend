/** 
 * Copyright (c) 2015-2018 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.validation.IValidationIssueAcceptor
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sexec.transformation.IModelSequencer
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.StructureMapping
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping
import org.yakindu.sct.model.sexec.transformation.ReactionBuilder
import org.yakindu.sct.model.sexec.transformation.SequenceBuilder
import org.yakindu.sct.model.sexec.transformation.StateVectorBuilder
import org.yakindu.sct.model.sexec.transformation.RetargetReferences
import org.yakindu.sct.model.sexec.transformation.config.IFlowConfiguration
import org.yakindu.sct.model.sexec.concepts.EnterMethod
import org.yakindu.sct.model.sexec.concepts.ExitMethod
import org.yakindu.sct.model.sexec.concepts.ExecutionGuard
import org.yakindu.sct.model.sexec.concepts.SuperStep
import org.yakindu.sct.model.sexec.concepts.RunCycleMethod
import org.yakindu.sct.model.sexec.concepts.EventBuffer
import org.yakindu.sct.model.sexec.concepts.EventProcessing

class ModelSequencer implements IModelSequencer {
	 
	@Inject extension SexecElementMapping mapping
	@Inject extension StructureMapping structureMapping
	@Inject extension BehaviorMapping behaviorMapping
	@Inject extension ReactionBuilder reactBuilder
	@Inject extension SequenceBuilder seqBuilder
	@Inject extension StateVectorBuilder svBuilder
	@Inject extension RetargetReferences retageting
	
	@Inject extension ExecutionGuard executionGuard
	@Inject extension EventProcessing eventProcessing
	@Inject extension ReactMethod reactMethod
	@Inject extension SuperStep superStep
	@Inject extension EnterMethod enterMethod
	@Inject extension ExitMethod exitMethod
	@Inject extension RunCycleMethod runCycleMethod
	@Inject extension EventBuffer eventBuffer
	
	@Inject extension IFlowConfiguration config
	
	
	/* ==========================================================================
	 * TRANSFORMATION ROOT
	 */ 
	override ExecutionFlow transform(Statechart sc) {
		transform(sc, new ListBasedValidationIssueAcceptor)
	}

	override ExecutionFlow transform(Statechart sc, IValidationIssueAcceptor acceptor) {
		
		val ef = sc.create
		
		// derive configuration from statechart
		config.defineConfigurationForStatechart(sc)
		
		// during mapping the basic structural elements will be mapped from the source statechart to the execution flow
		sc.mapScopes(ef)
		sc.mapRegularStates(ef)
		sc.mapPseudoStates(ef)
		sc.mapRegions(ef)
		sc.mapTimeEvents(ef)

		ef.declareReactMethods

		// calculate state vectors
		ef.defineStateVector(sc)
		ef.defineHistoryVector(sc)
		
		// derive all additional information that is necessary for the execution
		sc.mapEntryActions(ef)
		sc.mapExitActions(ef)
		
		 
		ef.defineEnterSequences(sc)
		ef.defineStateExitSequences(sc)
		ef.defineDeepEnterSequences(sc)
		ef.defineShallowEnterSequences(sc)
		ef.defineStatechartEnterSequence(sc)
		ef.defineStatechartExitSequence(sc)

		ef.defineStatechartInitSequence(sc)
		ef.defineStatechartStaticInitSequence(sc)
		
		sc.mapLocalReactions(ef)
		sc.mapTransitions(ef)
		sc.mapEntries(ef)
		sc.mapChoiceTransitions(ef)
		sc.mapSyncTransitions(ef)
	
		sc.defineEntryReactions(ef)
		ef.definePseudoStateReactions(sc)
		
		ef.defineReactMethods
		
		// retarget declaration refs
		ef.retargetDeclRefs

		// map submachine out events to shadow events
		sc.mapReferencedMachineOutEvents(ef)
		
		// define event buffer
		ef.defineEventBuffer(sc)
		eventProcessing.transformEventAccess(ef)
		
		eventProcessing.defineFeatures(ef)
		executionGuard.defineFeatures(ef)
		enterMethod.defineFeatures(ef)
		exitMethod.defineFeatures(ef)
		superStep.defineFeatures(ef)
		runCycleMethod.defineFeatures(ef)


		//clear create caches to avoid memory leak with repetetive generator cycles
		mapping.cleanup
		
		return ef
	}

	/************** retarget declaration refs **************/
	
		 	
}