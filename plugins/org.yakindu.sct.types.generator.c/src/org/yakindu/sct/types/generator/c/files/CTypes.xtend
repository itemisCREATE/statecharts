/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c.files

import com.google.inject.Inject
import org.yakindu.sct.types.generator.c.CGeneratorConstants
import org.yakindu.sct.types.generator.c.CLiterals

class CTypes {
		@Inject extension CLiterals
	def createScTypes() '''
		
		//#ifndef TODO Types module define_H_
		//#define TODO Types module define_H_
		
		// TODO licence header
		
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
		
		#define «TRUE_LITERAL» true
		#define «FALSE_LITERAL» false
		
		//#endif /* TODO Types module define_H_ */
	'''
}
