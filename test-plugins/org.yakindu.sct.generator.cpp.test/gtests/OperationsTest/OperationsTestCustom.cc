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
#include "Operations.h"
#include "Operations_OCB.h"

bool internalOperation1Called;
bool internalOperation2Called;
sc_integer internalOp2Param;

bool interfaceOperation1Called;
bool interfaceOperation2Called;
sc_integer interfaceOp2Param;

bool unnamedInterfaceOperation1Called;
bool unnamedInterfaceOperation2Called;
sc_integer unnamedInterfaceOp2Param;

TEST(StatemachineTest, OperationCallback) {
	internalOperation1Called = false;
	internalOperation2Called = false;
	internalOp2Param = 0;

	interfaceOperation1Called = false;
	interfaceOperation2Called = false;
	interfaceOp2Param = 0;

	unnamedInterfaceOperation1Called = false;
	unnamedInterfaceOperation2Called = false;
	unnamedInterfaceOp2Param = 0;

	Operations* statechart = new Operations();
	statechart->setDefaultSCI_OCB(new DefaultCallBack());
	statechart->setInternalSCI_OCB(new InternalCallBack());
	statechart->setSCI_Interface1_OCB(new Interface1CallBack());

	statechart->init();
	statechart->enter();

	statechart->runCycle();
	EXPECT_TRUE(internalOperation1Called);
	EXPECT_TRUE(internalOperation2Called);
	EXPECT_TRUE(internalOp2Param == 4);

	statechart->raise_ev();
	statechart->runCycle();
	EXPECT_TRUE(interfaceOperation1Called);
	EXPECT_TRUE(interfaceOperation2Called);
	EXPECT_TRUE(interfaceOp2Param == 4);

	statechart->raise_ev();
	statechart->runCycle();
	EXPECT_TRUE(unnamedInterfaceOperation1Called);
	EXPECT_TRUE(unnamedInterfaceOperation2Called);
	EXPECT_TRUE(unnamedInterfaceOp2Param == 4);

	delete statechart;
}

void InternalCallBack::internalOperation1() {
	internalOperation1Called = true;
}

sc_boolean InternalCallBack::InternalOperation2(sc_integer param1) {
	internalOperation2Called = true;
	internalOp2Param = param1;
	return true;
}

void Interface1CallBack::interfaceOperation1() {
	interfaceOperation1Called = true;
}

sc_boolean Interface1CallBack::InterfaceOperation2(sc_integer param1) {
	interfaceOperation2Called = true;
	interfaceOp2Param = param1;
	return true;
}

void DefaultCallBack::unnamedInterfaceOperation1() {
	unnamedInterfaceOperation1Called = true;
}

sc_boolean DefaultCallBack::UnnamedInterfaceOperation2(sc_integer param1) {
	unnamedInterfaceOperation2Called = true;
	unnamedInterfaceOp2Param = param1;
	return true;
}

sc_boolean DefaultCallBack::alwaysTrue() {
	return true;
}

