/**
  Copyright (c) 2019 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.yakindu.sct.generator.core.extensions.AnnotationExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

class GeneratorPredicate {
	@Inject protected AnnotationExtensions annotations
	
	def isEventDriven(GeneratorEntry entry) {
		annotations.isEventDriven(entry)
	}
}