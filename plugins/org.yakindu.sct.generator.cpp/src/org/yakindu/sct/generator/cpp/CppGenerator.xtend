/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart

/**
 * This is the CPP code generators main class. 
 * 
 * @author Markus Mühlbrandt
 */
class CppGenerator implements IExecutionFlowGenerator {
	 
	@Inject extension Types
	@Inject extension ITimedStatemachine
	@Inject extension ITimerService
	@Inject extension IStatemachine
	@Inject extension StatemachineHeader
	@Inject extension StatemachineImplementation

	@Inject extension Navigation
	
	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {

		flow.generateTypesHpp(flow.sourceElement as Statechart, fsa, entry)
		
		flow.generateIStatemachine(entry, fsa);
		
		if (flow.timed) {
			flow.generateITimedStatemachine(entry, fsa);
			flow.generateITimerService(entry, fsa);
		}
		
		flow.generateStatemachineHeader(flow.sourceElement as Statechart, fsa, entry)
		flow.generateStatemachineImplemenation(flow.sourceElement as Statechart, fsa, entry)
	}
}