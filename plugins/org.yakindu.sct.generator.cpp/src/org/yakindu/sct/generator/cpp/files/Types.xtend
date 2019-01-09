/**
 * Copyright (c) 2013-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Markus Mühlbrnadt - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.ErrorCode
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*
import org.yakindu.sct.generator.c.types.CLiterals

class Types implements IContentTemplate {

	@Inject extension CppNaming
	@Inject extension GenmodelEntries
	@Inject extension CLiterals

	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		/* As <cstdint> is not available on all platforms we choose to include <stdint.h>. You can switch to <cstdint> by commenting and uncommenting the lines below.*/
		// #include <cstdint>
		#include <stdint.h>
		
		#ifndef «STRING_TYPE»
		#define «STRING_TYPE»      char*
		#endif
		
		typedef int_fast16_t   «SHORT_TYPE»;
		typedef uint_fast16_t  «USHORT_TYPE»;
		typedef int32_t        «INT_TYPE»;
		typedef int16_t		   «ERROR_TYPE»;
		typedef double         «REAL_TYPE»;
		typedef bool           «BOOL_TYPE»;
		
		typedef intptr_t       «EVENT_TYPE»;
		
		#ifndef «NULL_LITERAL»
			#ifdef __cplusplus
				#if __cplusplus >= 201103L || (defined(_MSC_VER) && _MSC_VER >= 1900)
			  		#define «NULL_LITERAL» nullptr
				#else
					#define «NULL_LITERAL» 0
				#endif
			#else
				#define «NULL_LITERAL» ((void *)0)
			#endif
		#endif
		
		/* Error codes and mask can be used to check unimplemented operation callbacks. They can be activated in the API feature within the .sgen file.*/
		#ifndef «ErrorCode.OCB_INIT_MASK.getName()»
		#define «ErrorCode.OCB_INIT_MASK.getName» «ErrorCode.OCB_INIT_MASK.value»
		#endif

		#ifndef «ErrorCode.OCB_DEFAULT_INIT.getName»
		#define «ErrorCode.OCB_DEFAULT_INIT.getName» («ErrorCode.OCB_INIT_MASK.getName» | «ErrorCode.OCB_DEFAULT_INIT.value»)
		#endif

		#ifndef «ErrorCode.OCB_NAMED_INIT.getName»
		#define «ErrorCode.OCB_NAMED_INIT.getName» («ErrorCode.OCB_INIT_MASK.getName» | «ErrorCode.OCB_NAMED_INIT.value»)
		#endif

		#ifndef «ErrorCode.OCB_INTERNAL_INIT.getName»
		#define «ErrorCode.OCB_INTERNAL_INIT.getName» («ErrorCode.OCB_INIT_MASK.getName» | «ErrorCode.OCB_INTERNAL_INIT.value»)
		#endif			
		
		#endif /* «typesModule.define»_H_ */
	'''
	
}
