#include <string>
#include "gtest/gtest.h"
#include "CastExpressions.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

CastExpressions* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class CastExpressionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new CastExpressions();
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


TEST_F(CastExpressionsTest, CastExpressionTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_realValue()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_intValue()== 5l);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_realValue()== 15l);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(CastExpressions::main_region_C));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_realValue()== 757l);
	
	
}

}

