/**
* Copyright (c) 2014 committers of YAKINDU and others.
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

TEST(StatemachineTest, SafeOpenSuccess) {
	NamedInterfaceAccess* statechart = new NamedInterfaceAccess();
	statechart->init();
	statechart->enter();
	statechart->runCycle();
	statechart->getSCI_User()->raise_numberPressed(3);
	statechart->runCycle();
	statechart->getSCI_User()->raise_numberPressed(7);
	statechart->runCycle();
	statechart->getSCI_User()->raise_numberPressed(5);
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCI_Safe()->isRaised_open());
	delete statechart;
}
