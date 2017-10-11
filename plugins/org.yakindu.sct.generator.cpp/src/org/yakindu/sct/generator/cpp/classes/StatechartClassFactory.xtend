/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.classes

import com.google.inject.Inject
import com.google.inject.Injector
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author rbeckmann
 *
 */
class StatechartClassFactory {
	@Inject protected Injector injector
	
	def StatechartClass createStatechartClass(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		val cls = new StatechartClass()
		injector.injectMembers(cls)
		cls.build(flow, entry, artifactConfigs)
		cls
	}
	
	def StatechartInterfaceClass createStatechartInterfaceClass(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent,
		StatechartScope scope) {
		val cls = new StatechartInterfaceClass()
		injector.injectMembers(cls)
		cls.build(flow, entry, artifactConfigs, parent, scope)
		cls	
	}
	
	def StatechartOCBInterfaceClass createStatechartOCBInterfaceClass(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs, IModule parent,
		StatechartScope scope) {
		val cls = new StatechartOCBInterfaceClass()
		injector.injectMembers(cls)
		cls.build(flow, entry, artifactConfigs, parent, scope)
		cls
	}
}