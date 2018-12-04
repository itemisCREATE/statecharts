
#include "gtest/gtest.h"
#include "EntryExitSelfTransition.h"

#include "sc_timer_service.h"

static EntryExitSelfTransition statechart;


class EntryExitSelfTransitionTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void SelfTransitionToChildState();
	void SelfTransitionFromChildState();
	void init();
	void setTimer(EntryExitSelfTransition* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(EntryExitSelfTransition* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static EntryExitSelfTransitionTest * tc;

void init();

void EntryExitSelfTransitionTest::SetUp()
{
	entryExitSelfTransition_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &entryExitSelfTransition_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void EntryExitSelfTransitionTest::SelfTransitionToChildState()
{
	tc->init();
	entryExitSelfTransitionIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_C));
	entryExitSelfTransition_exit(&statechart);
}
void EntryExitSelfTransitionTest::SelfTransitionFromChildState()
{
	tc->init();
	entryExitSelfTransitionIface_raise_e1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 0l);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&statechart)== 0l);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_C));
	entryExitSelfTransitionIface_raise_e1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_B));
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&statechart)== 1l);
	entryExitSelfTransition_exit(&statechart);
}
void EntryExitSelfTransitionTest::init()
{
	entryExitSelfTransition_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_B));
	entryExitSelfTransitionIface_set_entries(&statechart,0l);
}

void EntryExitSelfTransitionTest::setTimer(EntryExitSelfTransition* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void EntryExitSelfTransitionTest::unsetTimer(EntryExitSelfTransition* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(EntryExitSelfTransitionTest, SelfTransitionToChildState) {
	SelfTransitionToChildState();
}
TEST_F(EntryExitSelfTransitionTest, SelfTransitionFromChildState) {
	SelfTransitionFromChildState();
}


