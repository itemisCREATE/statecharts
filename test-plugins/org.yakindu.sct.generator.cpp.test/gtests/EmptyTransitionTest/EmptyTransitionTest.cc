#include <string>
#include "gtest/gtest.h"
#include "EmptyTransition.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

EmptyTransition* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class EmptyTransitionTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new EmptyTransition();
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


TEST_F(EmptyTransitionTest, EmptyTransitionTest) {
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->isStateActive(EmptyTransition::main_region_B));
	
	EXPECT_TRUE(statechart->isStateActive(EmptyTransition::main_region_A));
	
	
}

}

