/* Generated by YAKINDU Statechart Tools code generator. */
#include <string>
#include "gtest/gtest.h"
#include "EventDrivenTriggeredByEvent.h"
#include "sc_runner_timed.h"
#include "sc_types.h"


//! The timers are managed by a timer service. */
static TimedSctUnitRunner * runner;

class EventDrivenTriggeredByEventTest : public ::testing::Test{
	protected:
	
	EventDrivenTriggeredByEvent* statechart;
	
	virtual void SetUp() {
		statechart = new EventDrivenTriggeredByEvent();
		statechart->init();
		runner = new TimedSctUnitRunner(
			statechart,
			true,
			200
		);
		statechart->setTimer(runner);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(EventDrivenTriggeredByEventTest, internalEventTriggersRunCycle) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenTriggeredByEvent::EventDrivenTriggeredByEvent_main_region_A));
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenTriggeredByEvent::EventDrivenTriggeredByEvent_main_region_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0l);
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenTriggeredByEvent::EventDrivenTriggeredByEvent_main_region_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0l);
	
	statechart->exit();
	
	
}
TEST_F(EventDrivenTriggeredByEventTest, proceedTimeDoesNotTriggerRunCycle) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EventDrivenTriggeredByEvent::EventDrivenTriggeredByEvent_main_region_A));
	
	runner->proceed_time(120000);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0l);
	
	statechart->exit();
	
	
}
