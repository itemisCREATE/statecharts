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
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SexecBuilder

/**
 * This class defines the general concept of checking the initialization state of a state machine.
 * 
 * @author Thomas Kutz
 */
class InitializedCheck {
	
	@Inject extension SexecBuilder
	
	public static val INIT_CHECK = StateMachineBehaviorConcept.CONCEPT_NAME_PREFIX + "isInitializedCheck"
		
	def Step _isInitializedCheck(ExecutionFlow it) {
		_conceptSequence(org.yakindu.sct.model.sexec.concepts.InitializedCheck.INIT_CHECK)
	}
}