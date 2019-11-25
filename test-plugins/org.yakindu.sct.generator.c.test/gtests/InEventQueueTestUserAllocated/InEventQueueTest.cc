/*
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

#include <string>
#include "gtest/gtest.h"
#include "InEventQueue.h"
#include "InEventQueueRequired.h"

InEventQueue machine;
char nextEvent;

int16_t expectcnt = 0;


void inEventQueueIface_askOracle(InEventQueue* handle) {
	switch (nextEvent) {

			case 'e':
				inEventQueueIface_raise_e(handle);
				break;
			case 'f':
				inEventQueueIface_raise_f(handle, 42);
				break;
			case 'g':
				inEventQueueIfaceI_raise_g(handle);
				break;
		}
}


TEST(InEventQueue, InEventQueue) {
	ineventqueue_event internal_queue[20];
	ineventqueue_event in_queue[20];
	inEventQueue_init(&machine, internal_queue, 20, in_queue, 20);
	inEventQueue_enter(&machine);
	
	EXPECT_TRUE( inEventQueue_isStateActive(&machine, InEventQueue_InEventQueue_main_region_A) );


	nextEvent = 'f';
	inEventQueueIface_raise_e(&machine);
	EXPECT_TRUE( inEventQueue_isStateActive(&machine, InEventQueue_InEventQueue_main_region_B) );


	nextEvent = 'g';
	 inEventQueueIface_raise_e(&machine);
	EXPECT_TRUE( inEventQueue_isStateActive(&machine, InEventQueue_InEventQueue_main_region_C) );


	nextEvent = 'e';
	inEventQueueIface_raise_f(&machine, 43);
	EXPECT_TRUE( inEventQueue_isStateActive(&machine, InEventQueue_InEventQueue_main_region_A) );

	}
