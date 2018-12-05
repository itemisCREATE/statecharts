
#include "gtest/gtest.h"
#include "EventDrivenInternalEvent.h"

#include "sc_timer_service.h"

static EventDrivenInternalEvent statechart;


class EventDrivenInternalEventTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void checkInternlEventQueueing();
	void setTimer(EventDrivenInternalEvent* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(EventDrivenInternalEvent* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static EventDrivenInternalEventTest * tc;


void EventDrivenInternalEventTest::SetUp()
{
	eventDrivenInternalEvent_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &eventDrivenInternalEvent_runCycle,
		true,
		200,
		&statechart
	);
	
	
	tc = this;
}
void EventDrivenInternalEventTest::checkInternlEventQueueing()
{
	eventDrivenInternalEvent_enter(&statechart);
	EXPECT_TRUE(eventDrivenInternalEvent_isStateActive(&statechart, EventDrivenInternalEvent_EventDrivenInternalEvent_r1_A));
	EXPECT_TRUE(eventDrivenInternalEvent_isStateActive(&statechart, EventDrivenInternalEvent_EventDrivenInternalEvent_r2_C));
	EXPECT_TRUE(eventDrivenInternalEvent_isStateActive(&statechart, EventDrivenInternalEvent_EventDrivenInternalEvent_check_VALID));
	eventDrivenInternalEventIface_raise_start(&statechart);
	EXPECT_TRUE(eventDrivenInternalEvent_isStateActive(&statechart, EventDrivenInternalEvent_EventDrivenInternalEvent_r1_B));
	EXPECT_TRUE(eventDrivenInternalEvent_isStateActive(&statechart, EventDrivenInternalEvent_EventDrivenInternalEvent_r2_D));
	EXPECT_TRUE(eventDrivenInternalEvent_isStateActive(&statechart, EventDrivenInternalEvent_EventDrivenInternalEvent_check_VALID));
	EXPECT_TRUE(eventDrivenInternalEventIface_get_i1_sequence(&statechart)== 2l);
	EXPECT_TRUE(eventDrivenInternalEventIface_get_i2_sequence(&statechart)== 3l);
	eventDrivenInternalEvent_exit(&statechart);
}

void EventDrivenInternalEventTest::setTimer(EventDrivenInternalEvent* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void EventDrivenInternalEventTest::unsetTimer(EventDrivenInternalEvent* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(EventDrivenInternalEventTest, checkInternlEventQueueing) {
	checkInternlEventQueueing();
}


