/**
  Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
*/

package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.Arrays
import java.util.Map
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.tree.TreeNamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.TimeEventSpec

import static org.yakindu.sct.generator.c.CKeywords.*

public class CTreeNamingService extends TreeNamingService {
	
	@Inject
	extension GenmodelEntries
	@Inject
	extension SExecExtensions
	@Inject
	var GeneratorEntry entry
	
	override void initializeNamingService(Statechart statechart) {
		if (entry.identifierLength !== null) {
			setMaxLength(entry.identifierLength)
		}
		
		if (entry.separator !== null) {
			setSeparator(entry.separator.charAt(0))
		}
		
		super.initializeNamingService(statechart)
	}
	
	override void initializeNamingService(ExecutionFlow flow) {
		if (entry.identifierLength !== null) {
			setMaxLength(entry.identifierLength)
		}
		
		if (entry.separator !== null) {
			setSeparator(entry.separator.charAt(0))
		}
		
		super.initializeNamingService(flow)
	}
	
	override Map<NamedElement, String> getShortNameMap(ExecutionFlow flow) {
		if (entry.identifierLength !== null) {
			setMaxLength(entry.identifierLength)
		}
		
		if (entry.separator !== null) {
			setSeparator(entry.separator.charAt(0))
		}
		
		return super.getShortNameMap(flow)
	}
	
	override Map<NamedElement, String> getShortNameMap(Statechart statechart) {
		if (entry.identifierLength !== null) {
			setMaxLength(entry.identifierLength)
		}
		
		if (entry.separator !== null) {
			setSeparator(entry.separator.charAt(0))
		}
		
		return super.getShortNameMap(statechart)
	}
	
	override protected prefix(Step it) {
		val prefix = newArrayList
		if (entry.statemachinePrefix != null) {
			prefix.add(entry.statemachinePrefix)
		} else {
			prefix.add(flow.name.toFirstLower)
		}
		prefix.add(switch (it) {
			case isCheckFunction:"check"
			case isEntryAction: "enact"
			case isExitAction: "exact"
			case isEffect: "effect"
			case isEnterSequence: "enseq"
			case isDeepEnterSequence: "dhenseq"
			case isShallowEnterSequence: "shenseq"
			case isExitSequence: "exseq"
			case isReactSequence: "react"
			default: ""
		})
		return prefix
	}
	
	override protected prefix(ExecutionState it) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			super.prefix(it).toFirstUpper		
		} else {
			#[entry.statemachinePrefix]
		}
	}
	
	override protected prefix(State it) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			super.prefix(it).toFirstUpper
		} else {
			#[entry.statemachinePrefix]
		}
	}
	
	override protected prefix(TimeEventSpec it, NamedElement element) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			super.prefix(it, element).toFirstUpper
		} else {
			#[entry.statemachinePrefix]
		}
	}
	
	override asEscapedIdentifier(String it) {
		var s = it
		if (s.isKeyword) {
			s = s + separator +'ID'
		}
		return s.asIdentifier
	}
	
	override boolean isKeyword(String name) {
		return !Arrays::asList(C_KEYWORDS).findFirst[it.equalsIgnoreCase(name)].nullOrEmpty
	}
}