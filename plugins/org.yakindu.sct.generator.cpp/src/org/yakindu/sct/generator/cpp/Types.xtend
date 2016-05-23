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
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.generator.core.library.IOutletFeatureHelper

class Types {

	@Inject extension Naming
	@Inject extension GenmodelEntries

	@Inject
	protected IOutletFeatureHelper outletFeatureHelper;

	def generateTypesHpp(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) != null)
			fsa.generateFile(flow.typesModule.h, IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT,
				flow.typesHContent(entry))
		else
			fsa.generateFile(flow.typesModule.h, flow.typesHContent(entry))

	}

	def typesHContent(ExecutionFlow it, GeneratorEntry entry) '''
		«entry.licenseText»
		
		#ifndef «typesModule.define»_H_
		#define «typesModule.define»_H_
		
		#define sc_string		char*
		
		typedef unsigned char	sc_ushort;
		typedef int				sc_integer;
		typedef double			sc_real;
		typedef bool			sc_boolean;
		
		typedef void*			sc_eventid;
		
		#ifndef «Naming::NULL_STRING»
			#define «Naming::NULL_STRING» 0
		#endif
		
		#endif /* «typesModule.define»_H_ */
	'''
}
