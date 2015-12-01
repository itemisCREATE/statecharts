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
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.generator.core.impl.SimpleResourceFileSystemAccess
import org.yakindu.sct.generator.core.util.GeneratorUtils
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_LIBRARY_TARGET_FOLDER

class Types {

	@Inject extension Naming
	@Inject extension GenmodelEntries

	def generateTypesH(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		if (GeneratorUtils.getOutletFeatureConfiguration(entry).getParameterValue(
			OUTLET_FEATURE_LIBRARY_TARGET_FOLDER) != null) {
			// sc_types.h is static, so we use the library target folder in case its configured
			fsa.generateFile(flow.typesModule.h, IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT,
				flow.typesHContent(entry))
		} else {
			// use default target folder path in case no library target folder is specified (the file will be overwritten there)
			if (fsa instanceof SimpleResourceFileSystemAccess &&
				!exists(flow.typesModule.h, fsa as SimpleResourceFileSystemAccess)) {
				fsa.generateFile(flow.typesModule.h, flow.typesHContent(entry))
			}
		}
	}

	def protected exists(String filename, SimpleResourceFileSystemAccess fsa) {
		val uri = fsa.getURI(filename);
		val file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		return file.exists;
	}

	def typesHContent(ExecutionFlow it, GeneratorEntry entry) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		#ifdef __cplusplus
		extern "C" {
		#endif 
		
		#include <stdint.h>
		#include <stdbool.h>
		
		#define sc_string		char*
		 
		typedef bool			sc_boolean;
		typedef int_fast16_t	sc_short;
		typedef uint_fast16_t	sc_ushort;
		typedef int32_t			sc_integer; 
		typedef uint32_t		sc_uinteger; 
		typedef double			sc_real;
		
		typedef void*			sc_eventid;
		
		#ifdef __cplusplus
		}
		#endif
		
		#ifndef «Naming::NULL_STRING»
			#ifdef __cplusplus
				#define «Naming::NULL_STRING» 0
			#else
				#define «Naming::NULL_STRING» ((void *)0)
			#endif
		#endif
		
		#define bool_true true
		#define bool_false false
		
		#endif /* «typesModule.define»_H_ */
	'''
}
