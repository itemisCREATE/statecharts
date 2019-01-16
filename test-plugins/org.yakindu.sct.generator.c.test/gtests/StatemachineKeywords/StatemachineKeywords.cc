
#include "gtest/gtest.h"
#include "StatechartKeywords.h"

#include "StatechartKeywordsRequired.h"
#include "sc_timer_service.h"

static StatechartKeywords statechart;


class StatemachineKeywords : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void statemachineKeywords();
	void setTimer(StatechartKeywords* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(StatechartKeywords* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static StatemachineKeywords * tc;


void StatemachineKeywords::SetUp()
{
	statechartKeywords_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		(sc_raise_time_event_fp) &statechartKeywords_raiseTimeEvent,
		(sc_run_cycle_fp) &statechartKeywords_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void StatemachineKeywords::statemachineKeywords()
{
	statechartKeywords_enter(&statechart);
	EXPECT_TRUE(statechartKeywords_isStateActive(&statechart, StatechartKeywords_main_region_Timer));
}

void StatemachineKeywords::setTimer(StatechartKeywords* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void StatemachineKeywords::unsetTimer(StatechartKeywords* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(StatemachineKeywords, statemachineKeywords) {
	statemachineKeywords();
}

void statechartKeywords_setTimer(StatechartKeywords* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	tc->setTimer(statechart, evid, time_ms, periodic);
}

void statechartKeywords_unsetTimer(StatechartKeywords* handle, const sc_eventid evid){
	tc->unsetTimer(handle, evid);
}

void statechartKeywordsIfaceIf_myOperation(const StatechartKeywords* statechart) {
}
void statechartKeywordsInternal_myOperation(const StatechartKeywords* statechart) {
}
