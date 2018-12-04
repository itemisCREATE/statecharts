
#include "gtest/gtest.h"
#include "Parenthesis.h"

#include "sc_timer_service.h"

static Parenthesis statechart;


class ParenthesisTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void simple();
	void setTimer(Parenthesis* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(Parenthesis* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ParenthesisTest * tc;


void ParenthesisTest::SetUp()
{
	parenthesis_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &parenthesis_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ParenthesisTest::simple()
{
	parenthesis_enter(&statechart);
	EXPECT_TRUE(parenthesis_isStateActive(&statechart, Parenthesis_mainRegion_A));
	EXPECT_TRUE(parenthesisIface_get_erg(&statechart)== 8l);
}

void ParenthesisTest::setTimer(Parenthesis* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ParenthesisTest::unsetTimer(Parenthesis* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ParenthesisTest, simple) {
	simple();
}


