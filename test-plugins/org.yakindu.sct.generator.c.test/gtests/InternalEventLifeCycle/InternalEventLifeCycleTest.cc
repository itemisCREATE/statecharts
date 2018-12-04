
#include "gtest/gtest.h"
#include "InternalEventLifeCycle.h"

#include "sc_timer_service.h"

static InternalEventLifeCycle statechart;


class InternalEventLifeCycleTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void InternalEventLifeCycleTest();
	void setTimer(InternalEventLifeCycle* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(InternalEventLifeCycle* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static InternalEventLifeCycleTest * tc;


void InternalEventLifeCycleTest::SetUp()
{
	internalEventLifeCycle_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &internalEventLifeCycle_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void InternalEventLifeCycleTest::InternalEventLifeCycleTest()
{
	internalEventLifeCycle_enter(&statechart);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r2_C));
	internalEventLifeCycleIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r2_D));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r2_D));
	internalEventLifeCycleIface_raise_f(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r2_C));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&statechart, InternalEventLifeCycle_r2_C));
}

void InternalEventLifeCycleTest::setTimer(InternalEventLifeCycle* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void InternalEventLifeCycleTest::unsetTimer(InternalEventLifeCycle* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(InternalEventLifeCycleTest, InternalEventLifeCycleTest) {
	InternalEventLifeCycleTest();
}


