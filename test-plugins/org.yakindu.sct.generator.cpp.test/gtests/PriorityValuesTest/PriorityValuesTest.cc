#include <string>
#include "gtest/gtest.h"
#include "PriorityValues.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

PriorityValues* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class PriorityValuesTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new PriorityValues();
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


TEST_F(PriorityValuesTest, transitionPriority) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::main_region_A));
	
	statechart->getDefaultSCI()->raise_event1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::main_region_C));
	
	
}
TEST_F(PriorityValuesTest, regionPriority) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::someRegion_A));
	
	statechart->getDefaultSCI()->raise_event2();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::someRegion_B));
	
	EXPECT_TRUE(!statechart->isStateActive(PriorityValues::main_region_E));
	
	
}

	}

