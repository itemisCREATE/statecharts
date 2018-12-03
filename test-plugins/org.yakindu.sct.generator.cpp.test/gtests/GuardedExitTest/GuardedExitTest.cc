#include <string>
#include "gtest/gtest.h"
#include "GuardedExit.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

void checkDone(sc_boolean shouldBeDone);
GuardedExit* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class GuardedExitTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new GuardedExit();
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

void checkDone(sc_boolean shouldBeDone){
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(GuardedExit::main_region_B));
	
	EXPECT_TRUE(shouldBeDone ? statechart->getDefaultSCI()->get_done() : !statechart->getDefaultSCI()->get_done());
	
	
}

TEST_F(GuardedExitTest, ExitTaken) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedExit::main_region_A));
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_guard());
	
	checkDone(false);
	
	
}
TEST_F(GuardedExitTest, ExitNotTaken) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedExit::main_region_A));
	
	statechart->getDefaultSCI()->set_guard(true);
	
	checkDone(true);
	
	
}

	}

