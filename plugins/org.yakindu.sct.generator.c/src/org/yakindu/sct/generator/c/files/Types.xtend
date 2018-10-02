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
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class Types implements IContentTemplate {

	@Inject extension Naming
	@Inject extension GenmodelEntries

	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		#ifdef __cplusplus
		extern "C"
		{
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
		
		typedef intptr_t		sc_intptr_t;
		
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
		
		#define «CGeneratorConstants.TRUE» true
		#define «CGeneratorConstants.FALSE» false
		
		#endif /* «typesModule.define»_H_ */
	'''
}
