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

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.GenmodelEntries

class Types {
	
	@Inject extension Naming
	@Inject extension GenmodelEntries
	 
	def generateTypesHpp(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 fsa.generateFile(flow.typesModule.h, flow.typesHContent(entry))
	}
	
	def typesHContent(ExecutionFlow it, GeneratorEntry entry) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		#include <string>
		
		typedef unsigned char	sc_ushort;
		typedef int				sc_integer;  
		typedef double			sc_real;
		typedef std::string		sc_string;
		typedef bool			sc_boolean;
		
		typedef void*			sc_eventid;
		
		#endif /* «typesModule.define»_H_ */
	'''
}