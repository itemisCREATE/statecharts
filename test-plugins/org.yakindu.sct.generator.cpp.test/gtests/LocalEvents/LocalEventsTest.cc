#include <string>
#include "gtest/gtest.h"
#include "LocalEvents.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

eventdriven::LocalEvents* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class LocalEventsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new eventdriven::LocalEvents();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			true,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(LocalEventsTest, test) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::LocalEvents::localEvents_r1_Comp1_r_A1));
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::LocalEvents::localEvents_r2_Comp2_r_A2));
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::LocalEvents::localEvents_r1_Comp1_r_D1));
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::LocalEvents::localEvents_r2_Comp2_r_D2));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cycleCountSm()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cycleCount1()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cycleCount2()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_checksum()== 3);
	
	statechart->exit();
	
	
}

}

