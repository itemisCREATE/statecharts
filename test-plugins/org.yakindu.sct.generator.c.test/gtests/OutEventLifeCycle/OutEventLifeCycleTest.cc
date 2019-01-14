
#include "gtest/gtest.h"
#include "OutEventLifeCycle.h"

#include "sc_timer_service.h"

static OutEventLifeCycle statechart;


class OutEventLifeCycleTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void availableAfterCycle();
	void availableWithinCycle();
	void unvailableWithin2ndCycle();
	void unvailableAfter2ndCycle();
	void init(sc_boolean sndCycle);
	void setTimer(OutEventLifeCycle* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(OutEventLifeCycle* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static OutEventLifeCycleTest * tc;

void init(sc_boolean sndCycle);

void OutEventLifeCycleTest::SetUp()
{
	outEventLifeCycle_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &outEventLifeCycle_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void OutEventLifeCycleTest::availableAfterCycle()
{
	outEventLifeCycle_enter(&statechart);
	outEventLifeCycleIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(outEventLifeCycleIface_israised_f(&statechart));
}
void OutEventLifeCycleTest::availableWithinCycle()
{
	tc->init(false);
	EXPECT_TRUE(outEventLifeCycleIface_get_f_available_in_cycle(&statechart));
}
void OutEventLifeCycleTest::unvailableWithin2ndCycle()
{
	tc->init(true);
	EXPECT_TRUE(!outEventLifeCycleIface_get_f_available_in_next_cycle(&statechart));
}
void OutEventLifeCycleTest::unvailableAfter2ndCycle()
{
	tc->init(true);
	EXPECT_TRUE(!outEventLifeCycleIface_israised_f(&statechart));
}
void OutEventLifeCycleTest::init(sc_boolean sndCycle)
{
	outEventLifeCycle_enter(&statechart);
	outEventLifeCycleIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	if (sndCycle) {
		sc_timer_service_proceed_cycles(&timer_service, 1);
	}
}

void OutEventLifeCycleTest::setTimer(OutEventLifeCycle* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void OutEventLifeCycleTest::unsetTimer(OutEventLifeCycle* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(OutEventLifeCycleTest, availableAfterCycle) {
	availableAfterCycle();
}
TEST_F(OutEventLifeCycleTest, availableWithinCycle) {
	availableWithinCycle();
}
TEST_F(OutEventLifeCycleTest, unvailableWithin2ndCycle) {
	unvailableWithin2ndCycle();
}
TEST_F(OutEventLifeCycleTest, unvailableAfter2ndCycle) {
	unvailableAfter2ndCycle();
}


