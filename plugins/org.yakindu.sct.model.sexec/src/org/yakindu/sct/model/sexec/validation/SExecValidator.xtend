/**
 * Copyright (c) 2019 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	itemis AG - initial API and implementation
 *
 */
package org.yakindu.sct.model.sexec.validation;

import com.google.inject.Inject
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.validation.ComposedChecks
import org.yakindu.base.expressions.validation.ExpressionsValidator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.StateVectorBuilder
import org.yakindu.sct.model.sexec.transformation.StructureMapping
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator
import org.yakindu.sct.model.stext.validation.STextNamesAreUniqueValidator
import org.yakindu.sct.model.stext.validation.STextValidator

@ComposedChecks(validators=#[SGraphJavaValidator, ExpressionsValidator, STextNamesAreUniqueValidator])
class SExecValidator extends STextValidator{

	@Inject extension SexecElementMapping mapping
	@Inject extension StructureMapping structureMapping
	@Inject extension StateVectorBuilder svBuilder

	@Check(CheckType.NORMAL)
	def void checkInternalEventRaisedOutsideOfDownstreamScope(Statechart sc) {
		// Check all internal events in cycle based execution schema.
		
		var ExecutionFlow ef = sc.create
		
		// from ModelSequencer
		sc.mapScopes(ef) 
		sc.mapRegularStates(ef)
		sc.mapPseudoStates(ef)
		sc.mapRegions(ef)
		sc.mapTimeEvents(ef)
		ef.defineStateVector(sc)
		
		var stateVector = ef.getStateVector()
		
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		
		}

}
