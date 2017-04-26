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

char myChar;

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

sc_real InternalCallBack::internalOperation3() {
	return 0.0d;
}

sc_real InternalCallBack::internalOperation3a(sc_real param1) {
	return 0.0d;
}

sc_integer InternalCallBack::internalOperation4() {
	return 0;
}

sc_integer InternalCallBack::internalOperation4a(sc_integer param1) {
	return 0;
}

sc_string InternalCallBack::internalOperation5() {
	return &myChar;
}

sc_string InternalCallBack::internalOperation5a(sc_string param1) {
	return &myChar;
}














void Interface1CallBack::interfaceOperation1() {
	interfaceOperation1Called = true;
}

sc_boolean Interface1CallBack::InterfaceOperation2(sc_integer param1) {
	interfaceOperation2Called = true;
	interfaceOp2Param = param1;
	return true;
}

sc_real Interface1CallBack::interfaceOperation3() {
	return 0.0d;
}

sc_real Interface1CallBack::interfaceOperation3a(sc_real param1) {
	return 0.0d;
}

sc_integer Interface1CallBack::interfaceOperation4() {
	return 0;
}

sc_integer Interface1CallBack::interfaceOperation4a(sc_integer param1) {
	return 0;
}

sc_string Interface1CallBack::interfaceOperation5() {
	return &myChar;
}

sc_string Interface1CallBack::interfaceOperation5a(sc_string param1) {
	return &myChar;
}





void DefaultCallBack::unnamedInterfaceOperation1() {
	unnamedInterfaceOperation1Called = true;
}

sc_boolean DefaultCallBack::UnnamedInterfaceOperation2(sc_integer param1) {
	unnamedInterfaceOperation2Called = true;
	unnamedInterfaceOp2Param = param1;
	return true;
}

sc_real DefaultCallBack::unnamedOperation3() {
	return 0.0d;
}

sc_real DefaultCallBack::unnamedOperation3a(sc_real param1) {
	return 0.0d;
}

sc_integer DefaultCallBack::unnamedOperation4() {
	return 0;
}

sc_integer DefaultCallBack::unnamedOperation4a(sc_integer param1) {
	return 0;
}

sc_string DefaultCallBack::unnamedOperation5() {
	return &myChar;
}

sc_string DefaultCallBack::unnamedOperation5a(sc_string param1) {
	return &myChar;
}

sc_boolean DefaultCallBack::alwaysTrue() {
	return true;
}

