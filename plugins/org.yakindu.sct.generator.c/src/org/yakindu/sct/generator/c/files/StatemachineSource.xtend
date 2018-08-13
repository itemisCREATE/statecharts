/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.files

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.ISourceFragment

class StatemachineSource implements IContentTemplate {
	@Inject protected extension INamingService

	val protected List<ISourceFragment> contentProviders = newArrayList();
		
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) { 
		initializeNamingService
		
		'''
		«fileComment(entry, artifactConfigs)»
		
		«includes(entry, artifactConfigs)»
		
		«declarations(entry, artifactConfigs)»
		
		«implementations(entry, artifactConfigs)»
		'''
	}
	
	def CharSequence fileComment(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«FOR p : contentProviders»
		«p.fileComment(it, entry, artifactConfigs)»
		«ENDFOR»
		'''
	}
	
	def CharSequence includes(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«FOR p : contentProviders»
		«p.includes(it, entry, artifactConfigs)»
		«ENDFOR»
		'''
	}
	
	def CharSequence declarations(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«FOR p : contentProviders»
		«p.declarations(it, entry, artifactConfigs)»
		«ENDFOR»
		'''
	}
	
	def CharSequence implementations(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«FOR p : contentProviders»
		«p.implementations(it, entry, artifactConfigs)»
		«ENDFOR»
		'''
	}
	
	def getContentProviders() {
		return contentProviders
	}
	
	

}