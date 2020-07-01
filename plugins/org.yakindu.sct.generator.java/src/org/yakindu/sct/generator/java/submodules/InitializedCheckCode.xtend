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
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

/**
 * 
 * @author Thomas Kutz
 */
class InitializedCheckCode implements org.yakindu.sct.generator.core.submodules.lifecycle.InitializedCheckCode {

	@Inject extension SExecExtensions

	override initializedCheckCode(ExecutionFlow flow) '''
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		«IF flow.timed»
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		«ENDIF»
	'''

}
