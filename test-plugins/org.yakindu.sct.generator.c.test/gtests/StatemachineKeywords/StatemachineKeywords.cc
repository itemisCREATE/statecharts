/**
* Copyright (c) 2016 committers of YAKINDU and others.
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
#include "StatechartKeywords.h"
#include "StatechartKeywordsRequired.h"


StatechartKeywords handle;

TEST(StatemachineTest, statemachineKeywords) {
	statechartKeywords_init(&handle);
	statechartKeywords_enter(&handle);
	EXPECT_TRUE(statechartKeywords_isStateActive(&handle, StatechartKeywords_main_region_Timer));
}

		
void statemachineKeywords_setTimer(const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	// Mockup
	statemachineKeywords_raiseTimeEvent(&handle, evid);
}

void statemachineKeywords_unsetTimer(const sc_eventid evid){
	// Mockup
}		
