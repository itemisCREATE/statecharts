/*
  Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
  	Axel Terfloth - Initial contribution
*/
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import java.util.Arrays
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.DefaultNamingService

/** 
 * Specific adaption of the default naming service to the needs of the java code generator.
 * 
 * @author axel terfloth (terfloth@itemis.de)
 */
class JavaNamingService extends DefaultNamingService implements JavaKeywords {
	
	@Inject extension SExecExtensions
	
  override protected prefix(Step it, char separator) {
		switch (it) {
			case isCheckFunction: "check"
			case isEntryAction: "entryAction"
			case isExitAction: "exitAction"
			case isEffect: "effect"
			case isEnterSequence: "enterSequence"
			case isDeepEnterSequence: "deepEnterSequence"
			case isShallowEnterSequence: "shallowEnterSequence"
			case isExitSequence: "exitSequence"
			case isReactSequence: "react"
			default: ""
		}
	}

		
	override boolean isKeyword(String name) {
		return !Arrays::asList(KEYWORDS).findFirst[it.equalsIgnoreCase(name)].nullOrEmpty
	}

}