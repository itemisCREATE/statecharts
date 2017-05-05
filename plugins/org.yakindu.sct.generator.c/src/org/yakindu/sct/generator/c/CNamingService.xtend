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
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.DefaultNamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.TimeEventSpec

import org.yakindu.sct.model.sgraph.Statechart

public class CNamingService extends DefaultNamingService {
	
	@Inject
	extension GenmodelEntries
	@Inject
	var GeneratorEntry entry
	
	override void initializeNamingService(Statechart statechart) {
		if (entry.identifierLength != null) {
			maxLength = entry.identifierLength
		}
		
		if (entry.separator != null) {
			separator = entry.separator.charAt(0)
		}
		
		super.initializeNamingService(statechart)
	}
	
	override void initializeNamingService(ExecutionFlow flow) {
		if (entry.identifierLength != null) {
			maxLength = entry.identifierLength
		}
		
		if (entry.separator != null) {
			separator = entry.separator.charAt(0)
		}
		
		super.initializeNamingService(flow)
	}
	
	override Map<NamedElement, String> getShortNameMap(ExecutionFlow flow) {
		if (entry.identifierLength != null) {
			maxLength = entry.identifierLength
		}
		
		if (entry.separator != null) {
			separator = entry.separator.charAt(0)
		}
		
		return super.getShortNameMap(flow)
	}
	
	override Map<NamedElement, String> getShortNameMap(Statechart statechart) {
		if (entry.identifierLength != null) {
			maxLength = entry.identifierLength
		}
		
		if (entry.separator != null) {
			separator = entry.separator.charAt(0)
		}
		
		return super.getShortNameMap(statechart)
	}
}