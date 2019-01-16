
#include "gtest/gtest.h"
#include "GuardedEntry.h"

#include "sc_timer_service.h"

static GuardedEntry statechart;


class GuardedEntryTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void EntryNotTakenOnStatechartEnter();
	void EntryTakenOnStatechartEnter();
	void EntryTakenInTransition();
	void EntryNotTakenInTransition();
	void initEntryInTransition(sc_boolean guardVar, sc_boolean doneVar);
	void setTimer(GuardedEntry* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(GuardedEntry* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static GuardedEntryTest * tc;

void initEntryInTransition(sc_boolean guardVar, sc_boolean doneVar);

void GuardedEntryTest::SetUp()
{
	guardedEntry_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &guardedEntry_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void GuardedEntryTest::EntryNotTakenOnStatechartEnter()
{
	EXPECT_TRUE(guardedEntryIface_get_guard(&statechart)== false);
	guardedEntry_enter(&statechart);
	EXPECT_TRUE(guardedEntry_isStateActive(&statechart, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&statechart)== false);
}
void GuardedEntryTest::EntryTakenOnStatechartEnter()
{
	guardedEntryIface_set_guard(&statechart,true);
	guardedEntry_enter(&statechart);
	EXPECT_TRUE(guardedEntry_isStateActive(&statechart, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&statechart)== true);
}
void GuardedEntryTest::EntryTakenInTransition()
{
	tc->initEntryInTransition(true, false);
	EXPECT_TRUE(guardedEntryIface_get_done(&statechart));
}
void GuardedEntryTest::EntryNotTakenInTransition()
{
	tc->initEntryInTransition(false, false);
	EXPECT_TRUE(!guardedEntryIface_get_done(&statechart));
}
void GuardedEntryTest::initEntryInTransition(sc_boolean guardVar, sc_boolean doneVar)
{
	guardedEntry_enter(&statechart);
	EXPECT_TRUE(guardedEntry_isStateActive(&statechart, GuardedEntry_main_region_A));
	guardedEntryIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(guardedEntry_isStateActive(&statechart, GuardedEntry_main_region_B));
	guardedEntryIface_set_guard(&statechart,guardVar);
	guardedEntryIface_set_done(&statechart,doneVar);
	guardedEntryIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(guardedEntry_isStateActive(&statechart, GuardedEntry_main_region_A));
}

void GuardedEntryTest::setTimer(GuardedEntry* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void GuardedEntryTest::unsetTimer(GuardedEntry* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(GuardedEntryTest, EntryNotTakenOnStatechartEnter) {
	EntryNotTakenOnStatechartEnter();
}
TEST_F(GuardedEntryTest, EntryTakenOnStatechartEnter) {
	EntryTakenOnStatechartEnter();
}
TEST_F(GuardedEntryTest, EntryTakenInTransition) {
	EntryTakenInTransition();
}
TEST_F(GuardedEntryTest, EntryNotTakenInTransition) {
	EntryNotTakenInTransition();
}


