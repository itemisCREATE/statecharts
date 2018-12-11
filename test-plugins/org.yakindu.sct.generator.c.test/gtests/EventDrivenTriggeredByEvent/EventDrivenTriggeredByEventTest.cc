
#include "gtest/gtest.h"
#include "EventDrivenTriggeredByEvent.h"

#include "EventDrivenTriggeredByEventRequired.h"
#include "sc_timer_service.h"

static EventDrivenTriggeredByEvent statechart;


class EventDrivenTriggeredByEventTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void internalEventTriggersRunCycle();
	void proceedTimeDoesNotTriggerRunCycle();
	void setTimer(EventDrivenTriggeredByEvent* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(EventDrivenTriggeredByEvent* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static EventDrivenTriggeredByEventTest * tc;


void EventDrivenTriggeredByEventTest::SetUp()
{
	eventDrivenTriggeredByEvent_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		(sc_raise_time_event_fp) &eventDrivenTriggeredByEvent_raiseTimeEvent,
		(sc_run_cycle_fp) &eventDrivenTriggeredByEvent_runCycle,
		true,
		200,
		&statechart
	);
	
	
	tc = this;
}
void EventDrivenTriggeredByEventTest::internalEventTriggersRunCycle()
{
	eventDrivenTriggeredByEvent_enter(&statechart);
	EXPECT_TRUE(eventDrivenTriggeredByEvent_isStateActive(&statechart, EventDrivenTriggeredByEvent_EventDrivenTriggeredByEvent_main_region_A));
	eventDrivenTriggeredByEventIface_raise_e(&statechart);
	EXPECT_TRUE(eventDrivenTriggeredByEvent_isStateActive(&statechart, EventDrivenTriggeredByEvent_EventDrivenTriggeredByEvent_main_region_B));
	EXPECT_TRUE(eventDrivenTriggeredByEventIface_get_x(&statechart)== 0);
	eventDrivenTriggeredByEventIface_raise_e(&statechart);
	EXPECT_TRUE(eventDrivenTriggeredByEvent_isStateActive(&statechart, EventDrivenTriggeredByEvent_EventDrivenTriggeredByEvent_main_region_A));
	EXPECT_TRUE(eventDrivenTriggeredByEventIface_get_x(&statechart)== 0);
	eventDrivenTriggeredByEvent_exit(&statechart);
}
void EventDrivenTriggeredByEventTest::proceedTimeDoesNotTriggerRunCycle()
{
	eventDrivenTriggeredByEvent_enter(&statechart);
	EXPECT_TRUE(eventDrivenTriggeredByEvent_isStateActive(&statechart, EventDrivenTriggeredByEvent_EventDrivenTriggeredByEvent_main_region_A));
	sc_timer_service_proceed_time(&timer_service, 120000);
	EXPECT_TRUE(eventDrivenTriggeredByEventIface_get_x(&statechart)== 0);
	eventDrivenTriggeredByEvent_exit(&statechart);
}

void EventDrivenTriggeredByEventTest::setTimer(EventDrivenTriggeredByEvent* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void EventDrivenTriggeredByEventTest::unsetTimer(EventDrivenTriggeredByEvent* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(EventDrivenTriggeredByEventTest, internalEventTriggersRunCycle) {
	internalEventTriggersRunCycle();
}
TEST_F(EventDrivenTriggeredByEventTest, proceedTimeDoesNotTriggerRunCycle) {
	proceedTimeDoesNotTriggerRunCycle();
}

void eventDrivenTriggeredByEvent_setTimer(EventDrivenTriggeredByEvent* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	tc->setTimer(statechart, evid, time_ms, periodic);
}

void eventDrivenTriggeredByEvent_unsetTimer(EventDrivenTriggeredByEvent* handle, const sc_eventid evid){
	tc->unsetTimer(handle, evid);
}

