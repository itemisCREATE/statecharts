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
#include "EntryReactionAction.h"

static EntryReactionAction statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		entryReactionAction_init(&statechart);
	}
};

void init(){
	entryReactionAction_enter(&statechart);
	entryReactionActionIface_raise_b(&statechart);
	entryReactionAction_runCycle(&statechart);
	entryReactionActionIface_raise_d(&statechart);
	entryReactionAction_runCycle(&statechart);
	entryReactionActionIface_set_enteredR1(&statechart,false);
	entryReactionActionIface_set_enteredR2(&statechart,false);
	entryReactionActionIface_set_enteredBdefault(&statechart,false);
	entryReactionActionIface_set_enteredBother(&statechart,false);
}

TEST_F(StatemachineTest, entryTransitionActionOnStatechartEnter) {					
	entryReactionAction_enter(&statechart);
	EXPECT_TRUE(entryReactionActionIface_get_enteredR1(&statechart));
	EXPECT_TRUE(entryReactionActionIface_get_enteredR2(&statechart));
	EXPECT_TRUE(entryReactionActionIface_get_enteredBdefault(&statechart));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBother(&statechart));
}
TEST_F(StatemachineTest, entryOnRTS) {					
	init();
	entryReactionActionIface_raise_b(&statechart);
	entryReactionAction_runCycle(&statechart);
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR1(&statechart));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR2(&statechart));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBdefault(&statechart));
	EXPECT_TRUE(entryReactionActionIface_get_enteredBother(&statechart));
}
TEST_F(StatemachineTest, noEntryTransitionActionOnHistory) {					
	init();
	entryReactionActionIface_raise_d(&statechart);
	entryReactionAction_runCycle(&statechart);
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR1(&statechart));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR2(&statechart));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBdefault(&statechart));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBother(&statechart));
}


