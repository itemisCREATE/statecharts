#include <string>
#include "gtest/gtest.h"
#include "FinalState.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

FinalState* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class FinalStateTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new FinalState();
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


TEST_F(FinalStateTest, StatechartNameTest) {
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isFinal());
	
	
}

	}

