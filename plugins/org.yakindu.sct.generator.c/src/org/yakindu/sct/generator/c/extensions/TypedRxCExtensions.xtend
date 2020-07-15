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
package org.yakindu.sct.generator.c.extensions

import org.yakindu.base.types.Event
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.base.types.typesystem.GenericTypeSystem
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

/**
 * @author Robin Herrmann
 */
class TypedRxCExtensions {
	@Inject extension GenericTypeSystem
	@Inject extension SExecExtensions

	/**
	 * Returns all payload types, except defaults (integer, boolean, etc.), 
	 * which are already defined & declared in the rcx module.
	 */
	def getPayloadTypes(ExecutionFlow it) {
		return eAllContents.filter(Event).filter[hasValue].map[type].
			filter[e|!concreteTypes.map[name].contains(e.name)].toSet
	}
}
