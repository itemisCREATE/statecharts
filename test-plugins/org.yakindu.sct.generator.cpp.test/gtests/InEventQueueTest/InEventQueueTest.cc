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


using namespace ineventqueue;


InEventQueue* machine = sc_null;
char nextEvent;


class Callback : public InEventQueue::DefaultSCI_OCB {
	virtual void askOracle();
};



void Callback::askOracle() {
	switch (nextEvent) {

		case 'e':
			machine->getDefaultSCI()->raise_e();
			break;
		case 'f':
			machine->getDefaultSCI()->raise_f(42);
			break;
		case 'g':
			machine->getSCI_I()->raise_g();
			break;
	}
}

int16_t expectcnt = 0;




TEST(InEventQueue, InEventQueue) {

	Callback callback;

	machine = new InEventQueue();
	machine->setDefaultSCI_OCB(&callback);

	machine->init();
	machine->enter();
	
	EXPECT_TRUE( machine->isStateActive(InEventQueue::InEventQueueStates::InEventQueue_main_region_A) );


	nextEvent = 'f';
	machine->getDefaultSCI()->raise_e();
	EXPECT_TRUE( machine->isStateActive(InEventQueue::InEventQueueStates::InEventQueue_main_region_B) );


	nextEvent = 'g';
	machine->getDefaultSCI()->raise_e();
	EXPECT_TRUE( machine->isStateActive(InEventQueue::InEventQueueStates::InEventQueue_main_region_C) );


	nextEvent = 'e';
	machine->getDefaultSCI()->raise_f(43);
	EXPECT_TRUE( machine->isStateActive(InEventQueue::InEventQueueStates::InEventQueue_main_region_A) );

	}
