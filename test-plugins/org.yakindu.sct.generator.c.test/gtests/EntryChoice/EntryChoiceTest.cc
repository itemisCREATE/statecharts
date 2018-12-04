
#include "gtest/gtest.h"
#include "EntryChoice.h"

#include "sc_timer_service.h"

static EntryChoice statechart;


class EntryChoiceTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void EntryChoiceTest();
	void setTimer(EntryChoice* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(EntryChoice* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static EntryChoiceTest * tc;


void EntryChoiceTest::SetUp()
{
	entryChoice_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &entryChoice_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void EntryChoiceTest::EntryChoiceTest()
{
	entryChoice_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(entryChoice_isStateActive(&statechart, EntryChoice_main_region_A));
}

void EntryChoiceTest::setTimer(EntryChoice* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void EntryChoiceTest::unsetTimer(EntryChoice* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(EntryChoiceTest, EntryChoiceTest) {
	EntryChoiceTest();
}


