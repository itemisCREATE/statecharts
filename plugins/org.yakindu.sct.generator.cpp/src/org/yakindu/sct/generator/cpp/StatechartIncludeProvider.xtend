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
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.sct.model.sgraph.Statechart

class StatechartIncludeProvider extends org.yakindu.sct.generator.c.StatechartIncludeProvider {

	@Inject extension CppNaming

	override submachineInclude(Statechart submachine) {
		'''#include "«submachine.module.h»"'''
	} 	
}