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
#include "Parenthesis.h"

TEST(StatemachineTest, simple) {
	Parenthesis handle;
	parenthesis_init(&handle);
	parenthesis_enter(&handle);
	EXPECT_TRUE(parenthesis_isActive(&handle, Parenthesis_mainRegion_A));
	EXPECT_TRUE(parenthesisIface_get_erg(&handle) == 8);
}
