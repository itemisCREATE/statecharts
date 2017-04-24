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
#include <string>
#include "gtest/gtest.h"
#include "EntryReactionAction.h"

EntryReactionAction handle;

TEST(StatemachineTest, entryTransitionActionOnStatechartEnter) {
	entryReactionAction_init(&handle);
	
	entryReactionAction_enter(&handle);
	EXPECT_TRUE(entryReactionActionIface_get_enteredR1(&handle));
	EXPECT_TRUE(entryReactionActionIface_get_enteredR2(&handle));
	EXPECT_TRUE(entryReactionActionIface_get_enteredBdefault(&handle));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBother(&handle));
}
TEST(StatemachineTest, entryOnRTS) {
	entryReactionAction_init(&handle);
	
	entryReactionAction_enter(&handle);
	entryReactionActionIface_raise_b(&handle);
	entryReactionAction_runCycle(&handle);
	entryReactionActionIface_raise_d(&handle);
	entryReactionAction_runCycle(&handle);
	entryReactionActionIface_set_enteredR1(false);
	entryReactionActionIface_set_enteredR2(false);
	entryReactionActionIface_set_enteredBdefault(false);
	entryReactionActionIface_set_enteredBother(false);
	entryReactionActionIface_raise_b(&handle);
	entryReactionAction_runCycle(&handle);
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR1(&handle));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR2(&handle));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBdefault(&handle));
	EXPECT_TRUE(entryReactionActionIface_get_enteredBother(&handle));
}
TEST(StatemachineTest, noEntryTransitionActionOnHistory) {
	entryReactionAction_init(&handle);
	
	entryReactionAction_enter(&handle);
	entryReactionActionIface_raise_b(&handle);
	entryReactionAction_runCycle(&handle);
	entryReactionActionIface_raise_d(&handle);
	entryReactionAction_runCycle(&handle);
	entryReactionActionIface_set_enteredR1(false);
	entryReactionActionIface_set_enteredR2(false);
	entryReactionActionIface_set_enteredBdefault(false);
	entryReactionActionIface_set_enteredBother(false);
	entryReactionActionIface_raise_d(&handle);
	entryReactionAction_runCycle(&handle);
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR1(&handle));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredR2(&handle));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBdefault(&handle));
	EXPECT_TRUE(!entryReactionActionIface_get_enteredBother(&handle));
}


