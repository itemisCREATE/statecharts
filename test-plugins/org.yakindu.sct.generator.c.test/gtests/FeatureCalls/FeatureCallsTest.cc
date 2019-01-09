
#include "gtest/gtest.h"
#include "FeatureCalls.h"

#include "sc_timer_service.h"

static FeatureCalls statechart;


class FeatureCallsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void featureCalls();
	void setTimer(FeatureCalls* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(FeatureCalls* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static FeatureCallsTest * tc;


void FeatureCallsTest::SetUp()
{
	featureCalls_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &featureCalls_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void FeatureCallsTest::featureCalls()
{
	featureCalls_enter(&statechart);
	EXPECT_TRUE(featureCalls_isStateActive(&statechart, FeatureCalls_main_region_A));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(featureCalls_isStateActive(&statechart, FeatureCalls_main_region_A));
}

void FeatureCallsTest::setTimer(FeatureCalls* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void FeatureCallsTest::unsetTimer(FeatureCalls* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(FeatureCallsTest, FeatureCalls) {
	featureCalls();
}


