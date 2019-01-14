
#include "gtest/gtest.h"
#include "StatechartLocalReactions.h"

#include "sc_timer_service.h"

static StatechartLocalReactions statechart;


class StatechartLocalReactionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void statechartLocalReactionsTest();
	void setTimer(StatechartLocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(StatechartLocalReactions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static StatechartLocalReactionsTest * tc;


void StatechartLocalReactionsTest::SetUp()
{
	statechartLocalReactions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &statechartLocalReactions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void StatechartLocalReactionsTest::statechartLocalReactionsTest()
{
	statechartLocalReactions_enter(&statechart);
	EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_main_region_S1));
	EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_region2_a));
	sc_integer cycles = 0;
	while (cycles< 10) {
		EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_region2_a));
		if (statechartLocalReactionsIface_get_myInt(&statechart)%2== 0) {
			EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_main_region_S1));
		}
		else {
			EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_main_region_S2));
		}
		sc_timer_service_proceed_cycles(&timer_service, 1);
		cycles += 1;
		EXPECT_TRUE((statechartLocalReactionsIface_get_myInt(&statechart)== cycles));
	}
}

void StatechartLocalReactionsTest::setTimer(StatechartLocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void StatechartLocalReactionsTest::unsetTimer(StatechartLocalReactions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(StatechartLocalReactionsTest, statechartLocalReactionsTest) {
	statechartLocalReactionsTest();
}


