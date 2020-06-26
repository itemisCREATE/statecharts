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
 * This one can probably be removed once the event buffer types are part of the execution flow
 * 
 * @author Thomas Kutz
 */
class InternalTypes {

	@Inject extension SExecExtensions
	@Inject extension TypeCode

	def internalTypes(ExecutionFlow it) {
		derivedComplexTypes.map[toCode].join
	}
	
}
