/**
 * Copyright (c) 2017-2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.submodules

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.base.types.Expression
import com.google.inject.Singleton

/** 
 * To be completed.
 */
@Singleton
class EventConceptCode implements org.yakindu.sct.generator.core.submodules.lifecycle.EventCode {
	
	override eventClearCode(ExecutionFlow flow, Expression event) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override eventMoveCode(ExecutionFlow flow, Expression source, Expression target) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override eventNextCode(ExecutionFlow flow) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}