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
#include "NamedInterfaceAccess.h"
#include "sc_types.h"
NamedInterfaceAccess* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new NamedInterfaceAccess();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, SafeOpenSuccess) {
	
	
	statechart->enter();
	
	statechart->runCycle();
	
	statechart->getSCI_User()->raise_numberPressed(3l);
	
	statechart->runCycle();
	
	statechart->getSCI_User()->raise_numberPressed(7l);
	
	statechart->runCycle();
	
	statechart->getSCI_User()->raise_numberPressed(5l);
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->getSCI_Safe()->isRaised_open());
	
}
