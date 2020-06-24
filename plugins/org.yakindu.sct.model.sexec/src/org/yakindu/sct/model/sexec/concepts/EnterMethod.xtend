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

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.SexecBuilder

/**
 * This class defines the general concept of entering a state machine. 
 * 
 * @author aterfloth
 */
class EnterMethod {

	public static val TRACE_ENTER = StateMachineBehaviorConcept.CONCEPT_NAME_PREFIX + "traceEnter"
	public static val ENTER = "enter"

	@Inject protected extension ExecutionGuard
	@Inject protected extension EventProcessing

	@Inject protected extension SExecExtensions
	@Inject protected extension TypeBuilder
	@Inject protected extension SexecBuilder
	

	
	def defineFeatures (ExecutionFlow it) {
		defineEnter	
	}
	
	def defineEnter(ExecutionFlow it) {
		
		it._method(ENTER) => [ m |
			m._public
			m._type(_void)
			m._body(
				_guardExecution( _sequence(
					_traceEnter,
					EcoreUtil.copy(enterSequences.defaultSequence)
				))
			)
			m.body.comment = "Activates the state machine."
		]
	}

	def Step _traceEnter(ExecutionFlow it) {
		_conceptSequence(TRACE_ENTER)	
	}
	
	
	def Method enter(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == ENTER).head
	}
	
}
