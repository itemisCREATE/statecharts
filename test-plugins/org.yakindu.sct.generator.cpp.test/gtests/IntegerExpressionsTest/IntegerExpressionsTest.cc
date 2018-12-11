#include <string>
#include "gtest/gtest.h"
#include "IntegerExpressions.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

IntegerExpressions* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class IntegerExpressionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new IntegerExpressions();
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


TEST_F(IntegerExpressionsTest, integerExpressions) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(IntegerExpressions::main_region_StateA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt1()== 10);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt2()== 5);
	
	statechart->getDefaultSCI()->raise_e1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_less()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_greater()== true);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equalOrLess()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equalOrGreater()== true);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equal()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_notEqual()== true);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_plus()== 15);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_minus()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_multiply()== 50);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_division()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_modulo()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_negat()== - 10 );
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_multiAssign()== 20);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_divAssign()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_plusAssign()== 12);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_minusAssign()== - 8 );
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_moduloAssign()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_decrementAssign()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_decrement()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_incrementAssign()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_increment()== 1);
	
	
}

}

