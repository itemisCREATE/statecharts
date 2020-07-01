/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.concepts

import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.ExecutionFlow
import com.google.inject.Inject
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.sgraph.Statechart

/**
 * This class defines the concept of super steps processing.
 *  
 * @author aterfloth
 */
class SuperStep {
	
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	@Inject extension StatechartAnnotations
	

	static val String STATE_CHANGED = "stateConfVectorChanged"
	
	
	def void defineFeatures (ExecutionFlow it) {
		if (appliesSuperStep) 
			it.features += _variable(STATE_CHANGED, _boolean)		
	}
	
	def Step _superStepLoop(ExecutionFlow it, Step body) {
		
		if (appliesSuperStep)
			_do( _sequence(
				stateChangedProperty._assign(_false),
				body
			))._while(stateChangedProperty._ref)
		else 
			body
	}
	
	def _stateChanged(ExecutionFlow it) {
		if (stateChangedProperty !== null) 
			stateChangedProperty._assign(_true)
		else
			_empty
	}	
	
	def Property stateChangedProperty(ExecutionFlow it) {
		features.filter(Property).filter( m | m.name == STATE_CHANGED).head
	}
	
	
	def appliesSuperStep(ExecutionFlow it) {
		(it.sourceElement as Statechart).isSuperStep
	}
}