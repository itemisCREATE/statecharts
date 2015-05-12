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
#include "FinalState.h"


FinalState handle;

TEST(StatemachineTest, StatechartNameTest) {
	finalState_init(&handle);
	finalState_enter(&handle);
	finalState_runCycle(&handle);
	EXPECT_TRUE(finalState_isFinal(&handle));
}

		
