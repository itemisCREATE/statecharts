/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Markus Mühlbrnadt - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class Types implements IContentTemplate {

	@Inject extension CppNaming
	@Inject extension GenmodelEntries

	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		/* As <cstdint> is not available on all platforms we choose to include <stdint.h>. You can switch to <cstdint> by commenting and uncommenting the lines below.*/
		// #include <cstdint>
		#include <stdint.h>
		
		#ifndef sc_string
		#define sc_string      char*
		#endif
		
		typedef int_fast16_t   sc_short;
		typedef uint_fast16_t  sc_ushort;
		typedef int32_t        sc_integer;
		typedef int16_t		   sc_errorCode;
		typedef double         sc_real;
		typedef bool           sc_boolean;
		
		typedef intptr_t       sc_eventid;
		
		#ifndef «CppNaming::NULL_STRING»
		#define «CppNaming::NULL_STRING» 0
		#endif
		
		/* Error codes and mask can be used to check unimplemented operation callbacks. They can be activated in the API feature within the .sgen file.*/
		#ifndef «ErrorCode.OCB_INIT_MASK.name»
		#define «ErrorCode.OCB_INIT_MASK.name» «ErrorCode.OCB_INIT_MASK.value»
		#endif

		#ifndef «ErrorCode.OCB_DEFAULT_INIT.name»
		#define «ErrorCode.OCB_DEFAULT_INIT.name» («ErrorCode.OCB_INIT_MASK.name» | «ErrorCode.OCB_DEFAULT_INIT.value»)
		#endif

		#ifndef «ErrorCode.OCB_NAMED_INIT.name»
		#define «ErrorCode.OCB_NAMED_INIT.name» («ErrorCode.OCB_INIT_MASK.name» | «ErrorCode.OCB_NAMED_INIT.value»)
		#endif

		#ifndef «ErrorCode.OCB_INTERNAL_INIT.name»
		#define «ErrorCode.OCB_INTERNAL_INIT.name» («ErrorCode.OCB_INIT_MASK.name» | «ErrorCode.OCB_INTERNAL_INIT.value»)
		#endif			
		
		#endif /* «typesModule.define»_H_ */
	'''
	
}
