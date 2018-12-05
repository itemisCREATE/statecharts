
#include "gtest/gtest.h"
#include "Constants.h"

#include "sc_timer_service.h"

static Constants statechart;


class ConstantsTests : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void constantDefinition();
	void setTimer(Constants* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(Constants* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ConstantsTests * tc;


void ConstantsTests::SetUp()
{
	constants_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &constants_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ConstantsTests::constantDefinition()
{
	constants_enter(&statechart);
	EXPECT_TRUE(constants_isStateActive(&statechart, Constants_main_region_A));
	EXPECT_TRUE(constantsIface_get_x(&statechart)== 10l);
	EXPECT_TRUE(constantsIface_get_y(&statechart)== 20l);
	EXPECT_TRUE(strcmp(constantsIfaceNamed_get_y(&statechart) , "Hello World") == 0);
	constantsIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(constantsIface_get_result(&statechart)== 20l);
	constantsIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(constants_isStateActive(&statechart, Constants_main_region_C));
	EXPECT_TRUE(constantsIface_get_result(&statechart)== 100l);
	constantsIface_raise_e2(&statechart, constantsIface_get_x(&statechart));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(constantsIface_get_result(&statechart)== 1000l);
	EXPECT_TRUE(constants_isStateActive(&statechart, Constants_main_region_A));
}

void ConstantsTests::setTimer(Constants* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ConstantsTests::unsetTimer(Constants* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ConstantsTests, constantDefinition) {
	constantDefinition();
}


