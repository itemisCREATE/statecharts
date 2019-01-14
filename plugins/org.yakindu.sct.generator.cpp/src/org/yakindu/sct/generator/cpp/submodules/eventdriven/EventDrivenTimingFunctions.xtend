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
package org.yakindu.sct.generator.cpp.submodules.eventdriven

import org.yakindu.sct.generator.cpp.submodules.TimingFunctions
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

class EventDrivenTimingFunctions extends TimingFunctions {
	override raiseTimeEventFunction(ExecutionFlow it) '''
		void «module»::«raiseTimeEventFctID»(«EVENT_TYPE» evid)
		{
			if ((evid >= («EVENT_TYPE»)«timeEventsInstance») && (evid < («EVENT_TYPE»)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(«BOOL_TYPE»*)evid = true;
				«runCycleFctID»();
			}
		}
	'''
}