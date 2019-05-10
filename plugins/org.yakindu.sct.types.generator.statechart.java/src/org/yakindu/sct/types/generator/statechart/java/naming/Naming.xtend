/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.types.generator.statechart.java.naming

import com.google.inject.Inject
import org.yakindu.sct.model.sgraph.Statechart

class Naming {

	@Inject extension JavaNamingService namingService;
	
	def baseStatemachineName() {
		"IStatemachine"
	}

	def java(String it) {
		it + ".java"
	}
	
	def dispatch String statemachineName(String name) {
		// remove whitespaces;
		var String newName = name.replace(" ", "")
		if (name.isKeyword) {
			return newName + "SM"
		}
		return newName
	}

	def dispatch String statemachineName(Statechart it) {
		return name.statemachineName.toFirstUpper
	}

	def statemachineClassName(Statechart it) {
		statemachineName + "Statemachine"
	}

	def statemachineInterfaceName(Statechart it) {
		"I" + statemachineClassName
	}

}
