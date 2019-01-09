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
package org.yakindu.sct.generator.cpp.files

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.Set
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.generator.cpp.CodeGeneratorFragmentProvider

class StatemachineHeader extends org.yakindu.sct.generator.c.files.StatemachineHeader {

	@Inject protected Set<IncludeProvider> includeProviders
	@Inject protected CodeGeneratorFragmentProvider fragmentProvider

	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension INamingService
	@Inject protected extension StatechartExtensions
	@Inject protected extension ExpressionsChecker
	
	@Inject protected extension InterfaceFunctions

	protected GeneratorEntry entry
	
	public static final String HEADER_TARGET = "Header"
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		this.entry = entry
		val namespace = statechartNamespace
		'''
			«entry.licenseText»
			
			#ifndef «module().define»_H_
			#define «module().define»_H_
			
			
			«includes(artifactConfigs)»
			
			/*! \file Header of the state machine '«name»'.
			*/
			
			«IF !namespace.nullOrEmpty»
				«FOR ns : namespace»
					namespace «ns» {
				«ENDFOR»
			«ENDIF»
			
			«FOR sourceProvider : fragmentProvider.get(HEADER_TARGET, it, artifactConfigs)»
			«sourceProvider.get(it, artifactConfigs)»
			
			«ENDFOR»
			
			«IF !namespace.nullOrEmpty»
				«FOR ns : namespace»
					}
				«ENDFOR»
			«ENDIF»
			
			#endif /* «module().define»_H_ */
		'''
	}
	
	def final includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
			«FOR provider : includeProviders»
				«FOR i : provider.getIncludes(it, artifactConfigs)»
					«i»
				«ENDFOR»
			«ENDFOR»
		'''
	}
}
