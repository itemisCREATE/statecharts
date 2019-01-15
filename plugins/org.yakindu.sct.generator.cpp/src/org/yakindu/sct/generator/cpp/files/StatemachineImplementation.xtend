/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
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
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.cpp.CodeGeneratorFragmentProvider
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * @author axel terfloth
 */
class StatemachineImplementation implements IContentTemplate {
	
	@Inject protected CodeGeneratorFragmentProvider provider;
	
	@Inject protected extension CppNaming
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension ExpressionsChecker
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		val namespace = statechartNamespace
	'''	
		«entry.licenseText»
		
		#include "«module.h»"
		«IF hasStringComparison»
		#include <string.h>
		«ENDIF»
		«IF modOnReal»#include <math.h>«ENDIF»
		
		/*! \file Implementation of the state machine '«name»'
		*/
		
		«IF !namespace.nullOrEmpty»
		«FOR ns : namespace»
		namespace «ns» {
		«ENDFOR»
		«ENDIF»
		
		«provider.get(this.class.simpleName, it, artifactConfigs)»
		
		«IF !namespace.nullOrEmpty»
		«FOR ns : namespace»
		}
		«ENDFOR»
		«ENDIF»
	'''
	}
}