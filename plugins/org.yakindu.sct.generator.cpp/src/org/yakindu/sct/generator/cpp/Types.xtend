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
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class Types implements IContentTemplate {

	@Inject extension Naming
	@Inject extension GenmodelEntries

	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		#include <cstdint>
		
		#define sc_string      char*
		
		typedef int_fast16_t   sc_short;
		typedef uint_fast16_t  sc_ushort;
		typedef int32_t        sc_integer;
		typedef double         sc_real;
		typedef bool           sc_boolean;
		
		typedef intptr_t       sc_eventid;
		
		#ifndef «Naming::NULL_STRING»
			#define «Naming::NULL_STRING» 0
		#endif
		
		#endif /* «typesModule.define»_H_ */
	'''
	
}
