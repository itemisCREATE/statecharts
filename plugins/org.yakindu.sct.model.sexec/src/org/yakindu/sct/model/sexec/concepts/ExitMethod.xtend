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
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.SexecBuilder

/**
 * This class defines the general concept of exiting a state machine. 
 * 
 * @author aterfloth
 */
class ExitMethod {

	public static val TRACE_EXIT = StateMachineBehaviorConcept.CONCEPT_NAME_PREFIX + "traceExit"
	public static val EXIT = "exit"

	@Inject protected extension ExecutionGuard
	@Inject protected extension EventProcessing

	@Inject protected extension SExecExtensions
	@Inject protected extension TypeBuilder
	@Inject protected extension SexecBuilder
	
	def defineFeatures (ExecutionFlow it) {
		defineExit	
	}
	
	def defineExit(ExecutionFlow it) {
		
		it._method(EXIT) => [ m |
			m._public
			m._type(_void)
			m._body(
				_guardExecution( _sequence(
					_traceExit,
					exitSequence._clone
				))
			)
			m.body.comment = "Deactivates the state machine."
		]
	}

	def Step _traceExit(ExecutionFlow it) {
		_conceptSequence(TRACE_EXIT)	
	}
}