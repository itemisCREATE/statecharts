/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.model.sexec.ExecutionFlow

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class UsingNamespaceProvider implements ISourceFragment {
	@Inject extension EventNaming
	@Inject extension EventDrivenPredicate
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		if(!needsEventNamespace) return ''''''
		'''using namespace «eventNamespaceName»;'''
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		needsEventNamespace
	}
	
	override orderPriority(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		-10
	}
	
}