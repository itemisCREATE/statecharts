#include <string>
#include "gtest/gtest.h"
#include "RaiseEvent.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

RaiseEvent* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class RaiseEventTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new RaiseEvent();
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


TEST_F(RaiseEventTest, raiseEvent) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::second_region_SateA));
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::main_region_StateA));
	
	statechart->getDefaultSCI()->raise_e2();
	
	runner->proceed_cycles(1);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::second_region_StateB));
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::main_region_StateB));
	
	
}

	}

