#include <string>
#include "gtest/gtest.h"
#include "ExitState.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

ExitState* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ExitStateTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ExitState();
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


TEST_F(ExitStateTest, defaultExit) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	
	
}
TEST_F(ExitStateTest, namedExitThroughNamedTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->getDefaultSCI()->raise_f();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_F));
	
	
}
TEST_F(ExitStateTest, namedExitThroughDefaultTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->getDefaultSCI()->raise_g();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	
	
}
TEST_F(ExitStateTest, remainInA) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	
}

	}

