/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.generator.cpp.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class Tracing implements IContentTemplate {

	@Inject extension GenmodelEntries
	@Inject extension CppNaming

	override content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) '''
		«entry.licenseText»
		
		#ifndef «traceObserverModule.define»_H_
		#define «traceObserverModule.define»_H_
		
		namespace «YSCNamespace»{
		template<typename T>
		class «traceObserverModule»
		{
		public:
			virtual ~«traceObserverModule»(){}
		
			virtual void stateEntered(T state) = 0;
		
			virtual void stateExited(T state) = 0;
		};
		}
		
		#endif /* «traceObserverModule.define» */
		
	'''

}
