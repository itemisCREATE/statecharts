
#include "gtest/gtest.h"
#include "DynamicChoice.h"

#include "sc_timer_service.h"

static DynamicChoice statechart;


class DynamicChoiceTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void DynamicChoiceTest();
	void setTimer(DynamicChoice* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(DynamicChoice* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static DynamicChoiceTest * tc;


void DynamicChoiceTest::SetUp()
{
	dynamicChoice_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &dynamicChoice_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void DynamicChoiceTest::DynamicChoiceTest()
{
	dynamicChoice_enter(&statechart);
	EXPECT_TRUE(dynamicChoice_isStateActive(&statechart, DynamicChoice_main_region_Start));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(dynamicChoice_isStateActive(&statechart, DynamicChoice_main_region_A));
}

void DynamicChoiceTest::setTimer(DynamicChoice* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void DynamicChoiceTest::unsetTimer(DynamicChoice* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(DynamicChoiceTest, DynamicChoiceTest) {
	DynamicChoiceTest();
}


