
#include "gtest/gtest.h"
#include "TransitionWithoutCondition.h"

#include "sc_timer_service.h"

static TransitionWithoutCondition statechart;


class TransitionWithoutConditionTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void transitionWithoutConditionTest();
	void setTimer(TransitionWithoutCondition* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(TransitionWithoutCondition* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static TransitionWithoutConditionTest * tc;


void TransitionWithoutConditionTest::SetUp()
{
	transitionWithoutCondition_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &transitionWithoutCondition_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void TransitionWithoutConditionTest::transitionWithoutConditionTest()
{
	transitionWithoutCondition_enter(&statechart);
	EXPECT_TRUE(transitionWithoutCondition_isStateActive(&statechart, TransitionWithoutCondition_main_region_A));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(transitionWithoutCondition_isStateActive(&statechart, TransitionWithoutCondition_main_region_B));
}

void TransitionWithoutConditionTest::setTimer(TransitionWithoutCondition* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void TransitionWithoutConditionTest::unsetTimer(TransitionWithoutCondition* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(TransitionWithoutConditionTest, TransitionWithoutConditionTest) {
	transitionWithoutConditionTest();
}


