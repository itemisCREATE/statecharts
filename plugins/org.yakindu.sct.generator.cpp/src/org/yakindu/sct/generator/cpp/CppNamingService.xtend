/**
  Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
*/

package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.Arrays
import org.yakindu.sct.generator.c.CNamingService
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.TimeEventSpec

import static org.yakindu.sct.generator.cpp.CppKeywords.*
import org.yakindu.base.base.NamedElement

class CppNamingService extends CNamingService {

	@Inject extension GenmodelEntries

	@Inject extension SExecExtensions

	@Inject
	GeneratorEntry entry

	

	override isKeyword(String name) {
		var isKeyword = !Arrays::asList(CPP_KEYWORDS).findFirst[it.equalsIgnoreCase(name)].nullOrEmpty
		return isKeyword || super.isKeyword(name)
	}
}
