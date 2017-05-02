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
#include "Operations.h"
#include "sc_types.h"
#include "gmock/gmock.h"

using ::testing::AtLeast;
using ::testing::Return;
using ::testing::_;

class MockInternal : public Operations::InternalSCI_OCB {
	public:
	MOCK_METHOD0(internalOperation1, void());
	MOCK_METHOD1(InternalOperation2, sc_boolean(sc_integer param1));
	MOCK_METHOD0(internalOperation3, sc_real());
	MOCK_METHOD1(internalOperation3a, sc_real(sc_real param1));
	MOCK_METHOD0(internalOperation4, sc_integer());
	MOCK_METHOD1(internalOperation4a, sc_integer(sc_integer param1));
	MOCK_METHOD0(internalOperation5, sc_string());
	MOCK_METHOD1(internalOperation5a, sc_string(sc_string param1));
};
class MockInterface1 : public Operations::SCI_Interface1_OCB {
	public:
	MOCK_METHOD0(interfaceOperation1, void());
	MOCK_METHOD1(InterfaceOperation2, sc_boolean(sc_integer param1));
	MOCK_METHOD0(interfaceOperation3, sc_real());
	MOCK_METHOD1(interfaceOperation3a, sc_real(sc_real param1));
	MOCK_METHOD0(interfaceOperation4, sc_integer());
	MOCK_METHOD1(interfaceOperation4a, sc_integer(sc_integer param1));
	MOCK_METHOD0(interfaceOperation5, sc_string());
	MOCK_METHOD1(interfaceOperation5a, sc_string(sc_string param1));
};
class MockDefault : public Operations::DefaultSCI_OCB {
	public:
	MOCK_METHOD0(unnamedInterfaceOperation1, void());
	MOCK_METHOD1(UnnamedInterfaceOperation2, sc_boolean(sc_integer param1));
	MOCK_METHOD0(unnamedOperation3, sc_real());
	MOCK_METHOD1(unnamedOperation3a, sc_real(sc_real param1));
	MOCK_METHOD0(unnamedOperation4, sc_integer());
	MOCK_METHOD1(unnamedOperation4a, sc_integer(sc_integer param1));
	MOCK_METHOD0(unnamedOperation5, sc_string());
	MOCK_METHOD1(unnamedOperation5a, sc_string(sc_string param1));
	MOCK_METHOD0(alwaysTrue, sc_boolean());
};
Operations* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new Operations();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, operationsCalled) {
	MockDefault defaultMock;
	
	MockInternal internalMock;
	
	MockInterface1 interface1Mock;
	
	
	EXPECT_CALL(defaultMock, alwaysTrue()).WillRepeatedly(Return(true));
	
	EXPECT_CALL(internalMock, internalOperation1()).Times(AtLeast(1));
	
	EXPECT_CALL(internalMock, InternalOperation2(4l)).Times(AtLeast(1));
	
	EXPECT_CALL(internalMock, internalOperation3()).Times(AtLeast(1));
	
	EXPECT_CALL(internalMock, internalOperation3a(1.0)).Times(AtLeast(1));
	
	EXPECT_CALL(internalMock, internalOperation4()).Times(AtLeast(1));
	
	EXPECT_CALL(internalMock, internalOperation4a(5l)).Times(AtLeast(1));
	
	EXPECT_CALL(internalMock, internalOperation5()).Times(AtLeast(1));
	
	EXPECT_CALL(internalMock, internalOperation5a(_)).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, interfaceOperation1()).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, InterfaceOperation2(4l)).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, interfaceOperation3()).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, interfaceOperation3a(1.0)).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, interfaceOperation4()).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, interfaceOperation4a(5l)).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, interfaceOperation5()).Times(AtLeast(1));
	
	EXPECT_CALL(interface1Mock, interfaceOperation5a(_)).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, unnamedInterfaceOperation1()).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, UnnamedInterfaceOperation2(4l)).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, unnamedOperation3()).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, unnamedOperation3a(1.0)).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, unnamedOperation4()).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, unnamedOperation4a(5l)).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, unnamedOperation5()).Times(AtLeast(1));
	
	EXPECT_CALL(defaultMock, unnamedOperation5a(_)).Times(AtLeast(1));
	
	statechart->setDefaultSCI_OCB(&defaultMock);
	statechart->setInternalSCI_OCB(&internalMock);
	statechart->setSCI_Interface1_OCB(&interface1Mock);
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_A));
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_B));
	
	statechart->raise_ev();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_C));
	
	statechart->raise_ev();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Operations::main_region_D));
	
}
