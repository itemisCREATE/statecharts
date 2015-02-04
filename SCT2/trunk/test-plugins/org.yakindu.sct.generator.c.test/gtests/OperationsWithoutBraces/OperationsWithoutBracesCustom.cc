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
#include "OperationsWithoutBraces.h"
#include "OperationsWithoutBracesRequired.h"

OperationsWithoutBraces handle;

TEST(StatemachineTest, OperationsWithoutBracesTest) {
	operationsWithoutBraces_init(&handle);
	operationsWithoutBraces_enter(&handle);
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_main_region_A));
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_another_region_A));
	operationsWithoutBraces_runCycle(&handle);
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_main_region_B));
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_another_region_B));
	operationsWithoutBraces_runCycle(&handle);
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_main_region_C));
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_another_region_C));
	operationsWithoutBraces_runCycle(&handle);
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_main_region_D));
	EXPECT_TRUE(operationsWithoutBraces_isActive(&handle, OperationsWithoutBraces_another_region_D));
}
		
sc_boolean operationsWithoutBracesIface_myBoolOp(){
	return false;
}

sc_integer operationsWithoutBracesIface_myIntOp(){
	return 0;
}

sc_real operationsWithoutBracesIface_myRealOp(){
	return 0.0;
}