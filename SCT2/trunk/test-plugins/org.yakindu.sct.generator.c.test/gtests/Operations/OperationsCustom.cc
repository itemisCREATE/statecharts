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
#include "OperationsRequired.h"

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


Operations handle;

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


	operations_init(&handle);
	operations_enter(&handle);
	operations_runCycle(&handle);
	EXPECT_TRUE(operations_isActive(&handle, Operations_main_region_B));
	EXPECT_TRUE(internalOperation1Called);
	EXPECT_TRUE(internalOperation2Called);
	EXPECT_TRUE(internalOp2Param == 4);
	
	
	
	
	
	operationsIface_raise_ev(&handle);
	operations_runCycle(&handle);
	EXPECT_TRUE(operations_isActive(&handle, Operations_main_region_C));
	EXPECT_TRUE(interfaceOperation1Called);
	EXPECT_TRUE(interfaceOperation2Called);
	EXPECT_TRUE(interfaceOp2Param == 4);
	
	
	
	operationsIface_raise_ev(&handle);
	operations_runCycle(&handle);
	EXPECT_TRUE(operations_isActive(&handle, Operations_main_region_D));
	EXPECT_TRUE(unnamedInterfaceOperation1Called);
	EXPECT_TRUE(unnamedInterfaceOperation2Called);
	EXPECT_TRUE(unnamedInterfaceOp2Param == 4);
	
}


void operationsInternal_internalOperation1(){
	internalOperation1Called = true;
}

sc_boolean operationsInternal_internalOperation2(const sc_integer param1){
	internalOperation2Called = true;
	internalOp2Param = param1;
	return true;
}

sc_real operationsInternal_internalOperation3(){
	return 0.0d;
}

sc_real operationsInternal_internalOperation3a(const sc_real param1){
	return 0.0d;
}

sc_integer operationsInternal_internalOperation4(){
	return 0;
}

sc_integer operationsInternal_internalOperation4a(const sc_integer param1){
	return 0;
}

sc_string operationsInternal_internalOperation5(){
	return &myChar;
}

sc_string operationsInternal_internalOperation5a(const sc_string param1){
	return &myChar;
}









void operationsIfaceInterface1_interfaceOperation1(){
	interfaceOperation1Called = true;
}

sc_boolean operationsIfaceInterface1_interfaceOperation2(const sc_integer param1){
	interfaceOperation2Called = true;
	interfaceOp2Param = param1;
	return true;
}

sc_real operationsIfaceInterface1_interfaceOperation3(){
	return 0.0d;
}

sc_real operationsIfaceInterface1_interfaceOperation3a(const sc_real param1){
	return 0.0d;
}

sc_integer operationsIfaceInterface1_interfaceOperation4(){
	return 0;
}

sc_integer operationsIfaceInterface1_interfaceOperation4a(const sc_integer param1){
	return 0;
}

sc_string operationsIfaceInterface1_interfaceOperation5(){
	return &myChar;
}

sc_string operationsIfaceInterface1_interfaceOperation5a(const sc_string param1){
	return &myChar;
}











void operationsIface_unnamedInterfaceOperation1(){
	unnamedInterfaceOperation1Called = true;
}

sc_boolean operationsIface_unnamedInterfaceOperation2(const sc_integer param1){
	unnamedInterfaceOperation2Called = true;
	unnamedInterfaceOp2Param = param1;
	return true;
}

sc_real operationsIface_unnamedOperation3(){
	return 0.0d;
}

sc_real operationsIface_unnamedOperation3a(const sc_real param1){
	return 0.0d;
}

sc_integer operationsIface_unnamedOperation4(){
	return 0;
}

sc_integer operationsIface_unnamedOperation4a(const sc_integer param1){
	return 0;
}

sc_string operationsIface_unnamedOperation5(){
	return &myChar;
}

sc_string operationsIface_unnamedOperation5a(const sc_string param1){
	return &myChar;
}

sc_boolean operationsIface_alwaysTrue(){
	return true;
}