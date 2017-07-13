/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include "gtest/gtest.h"
#include "TimedTransitions.h"
#include "TimedTransitionsRequired.h"
#include "sc_timer_service.h"

//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;

static TimedTransitions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		timedTransitions_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			(sc_raise_time_event_fp) &timedTransitions_raiseTimeEvent,
			(sc_run_cycle_fp) &timedTransitions_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(StatemachineTest, Timer01) {					
	timedTransitions_enter(&statechart);
	EXPECT_TRUE(timedTransitions_isStateActive(&statechart, TimedTransitions_main_region_Start));
	sc_timer_service_proceed(&timer_service, 2030);
	EXPECT_TRUE(timedTransitions_isStateActive(&statechart, TimedTransitions_main_region_End));
}

void timedTransitions_setTimer(TimedTransitions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&timer_service, timer);
}

void timedTransitions_unsetTimer(TimedTransitions* handle, const sc_eventid evid){
	delete_task(&timer_service, find_time_event(&timer_service, evid));
}		

