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
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.IHeaderFragment

class StatemachineHeader implements IContentTemplate {
	@Inject protected extension Naming cNaming
	@Inject protected extension INamingService
	
	protected List<IHeaderFragment> contentProviders = newArrayList
	
	def List<IHeaderFragment> getContentProviders() {
		contentProviders
	}
	
	override content(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		initializeNamingService
	'''
			«fileComment(entry, artifactConfigs)»
			
			#ifndef «module.define»_H_
			#define «module.define»_H_
			
			#ifdef __cplusplus
			extern "C" { 
			#endif
			
			«forwardDeclarations(entry, artifactConfigs)»
			
			#ifdef __cplusplus
			}
			#endif
			
			«includes(entry, artifactConfigs)»
			
			#ifdef __cplusplus
			extern "C" { 
			#endif 
			
			/*! \file Header of the state machine '«name»'.
			*/
			
			«defines(entry, artifactConfigs)»
			
			«types(entry, artifactConfigs)»
			
			«functions(entry, artifactConfigs)»
			
			#ifdef __cplusplus
			}
			#endif 
			
			#endif /* «module.define»_H_ */
		'''
	}
	
	def fileComment(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
			«FOR p : contentProviders»
				«p.fileComment(it, entry, artifactConfigs)»
			«ENDFOR»
		'''
	}
	
	def forwardDeclarations(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
			«FOR p : contentProviders»
				«p.forwardDeclarations(it, entry, artifactConfigs)»
			«ENDFOR»
		'''
	}
	
	def includes(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
			«FOR p : contentProviders»
				«p.includes(it, entry, artifactConfigs)»
			«ENDFOR»
		'''
	}
	
	def defines(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
			«FOR p : contentProviders»
				«p.defines(it, entry, artifactConfigs)»
			«ENDFOR»
		'''
	}
	
	def types(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
			«FOR p : contentProviders»
				«p.types(it, entry, artifactConfigs)»
			«ENDFOR»
		'''
	}
	
	def functions(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
			«FOR p : contentProviders»
				«p.functions(it, entry, artifactConfigs)»
			«ENDFOR»
		'''
	}
}
