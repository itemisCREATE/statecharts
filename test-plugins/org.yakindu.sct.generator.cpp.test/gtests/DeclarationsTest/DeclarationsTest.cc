/**
* Copyright (c) 2013 committers of YAKINDU and others.
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
#include "Declarations.hpp"

TEST(StatemachineTest, declarationsTest) {
	Declarations* statechart = new Declarations();
	statechart->init();
	statechart->enter();
	delete statechart;
}
