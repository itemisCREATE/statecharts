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
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.core.extensions.GeneratorPredicate
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension

class EventDrivenPredicate extends GeneratorPredicate {
	@Inject protected extension GenmodelEntriesExtension
	
	override useInEventQueueDeprecated() {
		entry.inEventQueue
	}
	
}