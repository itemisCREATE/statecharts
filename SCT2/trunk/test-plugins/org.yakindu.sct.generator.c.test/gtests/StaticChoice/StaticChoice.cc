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
#include "StaticChoice.h"


StaticChoice handle;

TEST(StatemachineTest, StaticChoiceTest) {
	staticChoice_init(&handle);
	staticChoice_enter(&handle);
	EXPECT_TRUE(staticChoice_isActive(&handle, StaticChoice_main_region_Start));
	staticChoice_runCycle(&handle);
}

		
