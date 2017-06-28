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
#include "NamedInterfaceAccess.h"

static NamedInterfaceAccess statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		namedInterfaceAccess_init(&statechart);
	}
};


TEST_F(StatemachineTest, SafeOpenSuccess) {					
	namedInterfaceAccess_enter(&statechart);
	namedInterfaceAccess_runCycle(&statechart);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&statechart, 3l);
	namedInterfaceAccess_runCycle(&statechart);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&statechart, 7l);
	namedInterfaceAccess_runCycle(&statechart);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&statechart, 5l);
	namedInterfaceAccess_runCycle(&statechart);
	EXPECT_TRUE(namedInterfaceAccessIfaceSafe_israised_open(&statechart));
}


