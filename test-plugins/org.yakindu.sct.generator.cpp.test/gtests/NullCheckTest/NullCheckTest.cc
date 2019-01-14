#include <string>
#include "gtest/gtest.h"
#include "NullCheck.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

NullCheck* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class NullCheckTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new NullCheck();
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


TEST_F(NullCheckTest, SimpleNullCheckTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(NullCheck::main_region_A));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(NullCheck::main_region_B));
	
	
}

}

