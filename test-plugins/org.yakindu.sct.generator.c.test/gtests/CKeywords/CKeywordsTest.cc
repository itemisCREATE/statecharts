
#include "gtest/gtest.h"
#include "CKeywords.h"

#include "sc_timer_service.h"

static CKeywords statechart;


class CKeywordsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void cKeywordsTest();
	void setTimer(CKeywords* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(CKeywords* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static CKeywordsTest * tc;


void CKeywordsTest::SetUp()
{
	cKeywords_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &cKeywords_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void CKeywordsTest::cKeywordsTest()
{
	cKeywords_enter(&statechart);
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_char));
	cKeywordsIface_raise_auto(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop));
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop_switch_case));
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop_switch_case_enum_asm));
}

void CKeywordsTest::setTimer(CKeywords* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void CKeywordsTest::unsetTimer(CKeywords* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(CKeywordsTest, CKeywordsTest) {
	cKeywordsTest();
}


