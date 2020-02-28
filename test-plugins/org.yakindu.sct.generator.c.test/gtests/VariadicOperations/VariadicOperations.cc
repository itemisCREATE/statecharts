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
#include <stdarg.h>
#include "gtest/gtest.h"
#include "VariadicFunctions.h"
#include "VariadicFunctionsRequired.h"

#define UNUSED(P) (void)(P)

bool myVarOperationCalled;


bool myVarOperation2Called;
int myVarOperation2Sum;

bool myInternalVarOperationCalled;


void variadicFunctionsIface_myVarOperation(const VariadicFunctions* handle, ...)
{
	UNUSED(handle);
	myVarOperationCalled = true;
}

void variadicFunctionsIfaceIF2_myVarOperation2(const VariadicFunctions* handle, const sc_integer argCount, ...)
{
	UNUSED(handle);
	myVarOperation2Called = true;
	myVarOperation2Sum = 0;

	va_list arg_p;
	va_start(arg_p, argCount); // set var args pointer to start of arg list
	for(int i = 0; i < argCount; i++) {
		myVarOperation2Sum += va_arg(arg_p, int);
	}
	va_end(arg_p);
}

sc_integer variadicFunctionsInternal_myInternalVarOperation(const VariadicFunctions* handle, ...)
{
	UNUSED(handle);
	myInternalVarOperationCalled = true;
	return 1;
}


VariadicFunctions handle;

TEST(StatemachineTest, OperationCallback) {
	variadicFunctions_init(&handle);

	myVarOperationCalled = false;
	myVarOperation2Called = false;
	myInternalVarOperationCalled = false;

	variadicFunctions_enter(&handle);

	ASSERT_TRUE(variadicFunctions_isStateActive(&handle, VariadicFunctions_main_region_StateA));
	ASSERT_TRUE(myVarOperationCalled);

	variadicFunctions_runCycle(&handle);

	ASSERT_TRUE(variadicFunctions_isStateActive(&handle, VariadicFunctions_main_region_StateB));
	ASSERT_TRUE(myInternalVarOperationCalled);
	ASSERT_TRUE(myVarOperation2Called);
	ASSERT_TRUE(myVarOperation2Sum == 2);
}
