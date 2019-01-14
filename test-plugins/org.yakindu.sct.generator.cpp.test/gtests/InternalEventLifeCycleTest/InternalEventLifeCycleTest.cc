#include <string>
#include "gtest/gtest.h"
#include "InternalEventLifeCycle.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

InternalEventLifeCycle* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class InternalEventLifeCycleTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new InternalEventLifeCycle();
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


TEST_F(InternalEventLifeCycleTest, InternalEventLifeCycleTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r2_C));
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r2_D));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r2_D));
	
	statechart->getDefaultSCI()->raise_f();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r2_C));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(InternalEventLifeCycle::r2_C));
	
	
}

}

