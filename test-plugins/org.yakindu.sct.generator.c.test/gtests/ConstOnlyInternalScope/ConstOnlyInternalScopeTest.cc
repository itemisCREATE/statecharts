
#include "gtest/gtest.h"
#include "ConstOnlyInternalScope.h"

#include "sc_timer_service.h"

static ConstOnlyInternalScope statechart;


class ConstOnlyInternalScopeTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void statechartEntry();
	void stateTransition();
	void setTimer(ConstOnlyInternalScope* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ConstOnlyInternalScope* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ConstOnlyInternalScopeTest * tc;


void ConstOnlyInternalScopeTest::SetUp()
{
	constOnlyInternalScope_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &constOnlyInternalScope_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ConstOnlyInternalScopeTest::statechartEntry()
{
	constOnlyInternalScope_enter(&statechart);
	EXPECT_TRUE(constOnlyInternalScope_isStateActive(&statechart, ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A));
}
void ConstOnlyInternalScopeTest::stateTransition()
{
	constOnlyInternalScope_enter(&statechart);
	constOnlyInternalScopeIface_raise_e(&statechart, 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(constOnlyInternalScope_isStateActive(&statechart, ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B));
}

void ConstOnlyInternalScopeTest::setTimer(ConstOnlyInternalScope* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ConstOnlyInternalScopeTest::unsetTimer(ConstOnlyInternalScope* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ConstOnlyInternalScopeTest, statechartEntry) {
	statechartEntry();
}
TEST_F(ConstOnlyInternalScopeTest, stateTransition) {
	stateTransition();
}


