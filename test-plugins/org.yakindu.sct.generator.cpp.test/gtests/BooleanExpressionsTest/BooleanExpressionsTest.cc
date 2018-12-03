#include <string>
#include "gtest/gtest.h"
#include "BooleanExpressions.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

BooleanExpressions* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class BooleanExpressionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new BooleanExpressions();
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


TEST_F(BooleanExpressionsTest, booleanExpressions) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(BooleanExpressions::main_region_StateA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool1()== true);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool2()== false);
	
	statechart->getDefaultSCI()->raise_e1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(BooleanExpressions::main_region_StateB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_and()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_or()== true);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_not()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equal()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_notequal()== true);
	
	
}

	}

