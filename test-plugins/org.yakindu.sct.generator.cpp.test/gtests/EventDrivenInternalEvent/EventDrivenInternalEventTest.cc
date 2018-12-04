#include <string>
#include "gtest/gtest.h"
#include "EventDrivenInternalEvent.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

eventdriven::EventDrivenInternalEvent* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class EventDrivenInternalEventTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new eventdriven::EventDrivenInternalEvent();
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


TEST_F(EventDrivenInternalEventTest, checkInternlEventQueueing) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenInternalEvent::EventDrivenInternalEvent_r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenInternalEvent::EventDrivenInternalEvent_r2_C));
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenInternalEvent::EventDrivenInternalEvent_check_VALID));
	
	statechart->getDefaultSCI()->raise_start();
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenInternalEvent::EventDrivenInternalEvent_r1_B));
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenInternalEvent::EventDrivenInternalEvent_r2_D));
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenInternalEvent::EventDrivenInternalEvent_check_VALID));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_i1_sequence()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_i2_sequence()== 3l);
	
	statechart->exit();
	
	
}

}

