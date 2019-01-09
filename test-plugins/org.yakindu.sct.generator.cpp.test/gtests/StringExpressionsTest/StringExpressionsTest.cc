#include <string>
#include "gtest/gtest.h"
#include "StringExpressions.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

StringExpressions* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class StringExpressionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new StringExpressions();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(StringExpressionsTest, StringExpressionsTest) {
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_quotedStringX(), "\"X\"") == 0);
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_quotedStringY(), "\"Y\"") == 0);
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(StringExpressions::main_region_AssignmentChecked));
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(StringExpressions::main_region_VarToVarCompareSucceeded));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringNotEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarNotEqual());
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(StringExpressions::main_region_VarToConstCompareSucceeded));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringNotEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarNotEqual());
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(StringExpressions::main_region_ConstToVarCompareSucceeded));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringNotEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarNotEqual());
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(StringExpressions::main_region_ConstToConstCompareSucceeded));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guardStringNotEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarEqual());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_stringVarNotEqual());
	
	
}

}

