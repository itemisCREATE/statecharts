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
package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.model.sexec.ExecutionFlow

class TracingFunctions {
	@Inject protected extension CppNaming
	
	def tracedStatemachineFunctions(ExecutionFlow it)
		'''
		void set«traceObserverModule»(«YSCNamespace»::«traceObserverModule»<«statesEnumType»>* tracingcallback);
		
		«YSCNamespace»::«traceObserverModule»<«statesEnumType»>* get«traceObserverModule»();
	'''
}