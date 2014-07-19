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
#include "StringExpressions.h"

TEST(StatemachineTest, StringExpressionsTest) {
	StringExpressions* statechart = new StringExpressions();
	statechart->init();
	EXPECT_TRUE(strcmp(statechart->getSCInterface()->get_quotedStringX(), "\"X\"") == 0);
	EXPECT_TRUE(strcmp(statechart->getSCInterface()->get_quotedStringY(), "\"Y\"") == 0);
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(StringExpressions::AssignmentChecked));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(StringExpressions::VarToVarCompareSucceeded));
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringNotEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarNotEqual());
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(StringExpressions::VarToConstCompareSucceeded));
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringNotEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarNotEqual());
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(StringExpressions::ConstToVarCompareSucceeded));
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringNotEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarNotEqual());
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(StringExpressions::ConstToConstCompareSucceeded));
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_guardStringNotEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarEqual());
	EXPECT_TRUE(statechart->getSCInterface()->get_stringVarNotEqual());
	delete statechart;
}
