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
		 
		typedef bool			«CGeneratorConstants::BOOL_TYPE»;
		typedef int_fast16_t	«CGeneratorConstants::SHORT_TYPE»;
		typedef uint_fast16_t	«CGeneratorConstants::USHORT_TYPE»;
		typedef int32_t			«CGeneratorConstants::INT_TYPE»;
		typedef uint32_t		«CGeneratorConstants::UINT_TYPE»;
		
		typedef double			«CGeneratorConstants::REAL_TYPE»;
		
		typedef void*			«CGeneratorConstants::EVENT_TYPE»;
		
		typedef intptr_t		sc_intptr_t;
		
		#ifdef __cplusplus
		}
		#endif
		
		#ifndef «CGeneratorConstants::NULL_STRING»
			#ifdef __cplusplus
				#define «CGeneratorConstants::NULL_STRING» 0
			#else
				#define «CGeneratorConstants::NULL_STRING» ((void *)0)
			#endif
		#endif
		
		#define «CGeneratorConstants.TRUE» true
		#define «CGeneratorConstants.FALSE» false
		
		#endif /* «typesModule.define»_H_ */
	'''
}
