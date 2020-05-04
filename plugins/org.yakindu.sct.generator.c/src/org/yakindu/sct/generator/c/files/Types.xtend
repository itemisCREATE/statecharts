/**
 * Copyright (c) 2020 committers of YAKINDU and others.
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
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.extensions.Naming

class Types implements IContentTemplate {

	@Inject extension GenmodelEntries
	@Inject extension Naming

	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «typeModule.define»_H_
		#define «typeModule.define»_H_
		
		#ifdef __cplusplus
		extern "C"
		{
		#endif
		
		/*!
		 * Forward declaration for the «type» state machine.
		 */
		typedef struct «type» «type»;
		
		#ifdef __cplusplus
		}
		#endif
		
		#endif /* «typeModule.define»_H_ */
	'''

}
