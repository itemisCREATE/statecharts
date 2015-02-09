/**
* Copyright (c) 2015 committers of YAKINDU and others.
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
#include "TimedTransitions.h"
#include "TimedTransitionsRequired.h"


TimedTransitions handle;

TEST(StatemachineTest, Timer01) {
	timedTransitions_init(&handle);
	timedTransitions_enter(&handle);
	EXPECT_TRUE(timedTransitions_isActive(&handle, TimedTransitions_main_region_Start));
	// here should be waited 2030 Seconds
	timedTransitions_runCycle(&handle);
	EXPECT_TRUE(timedTransitions_isActive(&handle, TimedTransitions_main_region_End));
}

		
void timedTransitions_setTimer(const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	// Mockup
	timedTransitions_raiseTimeEvent(&handle, evid);
}

void timedTransitions_unsetTimer(const sc_eventid evid){
	// Mockup
}		
