
#include "gtest/gtest.h"
#include "ConstOnlyDefaultScope.h"

#include "sc_timer_service.h"

static ConstOnlyDefaultScope statechart;


class ConstOnlyDefaultScopeTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void statechartEntry();
	void stateTransition();
	void setTimer(ConstOnlyDefaultScope* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ConstOnlyDefaultScope* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ConstOnlyDefaultScopeTest * tc;


void ConstOnlyDefaultScopeTest::SetUp()
{
	constOnlyDefaultScope_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &constOnlyDefaultScope_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ConstOnlyDefaultScopeTest::statechartEntry()
{
	constOnlyDefaultScope_enter(&statechart);
	EXPECT_TRUE(constOnlyDefaultScope_isStateActive(&statechart, ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A));
}
void ConstOnlyDefaultScopeTest::stateTransition()
{
	constOnlyDefaultScope_enter(&statechart);
	constOnlyDefaultScopeIfaceA_raise_e(&statechart, 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(constOnlyDefaultScope_isStateActive(&statechart, ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B));
}

void ConstOnlyDefaultScopeTest::setTimer(ConstOnlyDefaultScope* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ConstOnlyDefaultScopeTest::unsetTimer(ConstOnlyDefaultScope* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ConstOnlyDefaultScopeTest, statechartEntry) {
	statechartEntry();
}
TEST_F(ConstOnlyDefaultScopeTest, stateTransition) {
	stateTransition();
}


