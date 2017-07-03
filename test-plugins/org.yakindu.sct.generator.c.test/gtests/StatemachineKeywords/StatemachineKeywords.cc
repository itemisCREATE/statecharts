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
#include "StatechartKeywords.h"
#include "StatechartKeywordsRequired.h"

static StatechartKeywords statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechartKeywords_init(&statechart);
	}
};


TEST_F(StatemachineTest, statemachineKeywords) {					
	statechartKeywords_enter(&statechart);
	EXPECT_TRUE(statechartKeywords_isStateActive(&statechart, StatechartKeywords_main_region_Timer));
}

void statechartKeywords_setTimer(StatechartKeywords* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	// Mockup
	statechartKeywords_raiseTimeEvent(handle, evid);
}

void statechartKeywords_unsetTimer(StatechartKeywords* statechart, const sc_eventid evid){
	// Mockup
}		

void statechartKeywordsIfaceIf_myOperation(const StatechartKeywords* statechart){
}
void statechartKeywordsInternal_myOperation(const StatechartKeywords* statechart){
}
