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

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject
import org.yakindu.sct.model.sgen.GeneratorEntry

class Types {
	
	@Inject extension Naming
	@Inject extension GenmodelEntries
	 
	def generateTypesH(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 fsa.generateFile(flow.typesModule.h, flow.typesHContent(entry))
	}
	
	
	def typesHContent(ExecutionFlow it, GeneratorEntry entry) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		#ifdef __cplusplus
		extern "C" {
		#endif 
		
		#include <stdint.h>
		
		typedef enum {
			bool_false,
			bool_true
		} sc_boolean;
		
		typedef int_fast16_t  sc_short;
		typedef uint_fast16_t sc_ushort;
		typedef int32_t       sc_integer; 
		typedef uint32_t      sc_uinteger; 
		typedef double        sc_real;
		typedef char*         sc_string;
		
		typedef void*         sc_eventid;
		
		#ifdef __cplusplus
		}
		#endif 

		#endif /* «typesModule.define»_H_ */
	'''
}