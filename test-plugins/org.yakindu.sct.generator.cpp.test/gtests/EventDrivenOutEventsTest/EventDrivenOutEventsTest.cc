#include <string>
#include "gtest/gtest.h"
#include "EventDrivenOutEvents.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

EventDrivenOutEvents* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class EventDrivenOutEventsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new EventDrivenOutEvents();
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


TEST_F(EventDrivenOutEventsTest, test) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenOutEvents::main_region_StateA));
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenOutEvents::second_region_StateC));
	
	statechart->getDefaultSCI()->raise_e1();
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenOutEvents::main_region_StateB));
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenOutEvents::second_region_StateD));
	
	statechart->exit();
	
	
}

}

