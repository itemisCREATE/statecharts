/* Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "SimpleEvent.h"

#include "sc_timer_service.h"


static SimpleEvent statechart;


//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;
			
class SimpleEventTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		simpleEvent_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			0,
			(sc_run_cycle_fp) &simpleEvent_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(SimpleEventTest, simpleEventTest) {
	
	simpleEvent_enter(&statechart);
	EXPECT_TRUE(simpleEvent_isStateActive(&statechart, SimpleEvent_main_region_A)) << "Expected A to be active" ;
	EXPECT_TRUE(5l== 5l);
	simpleEventIface_raise_event1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(simpleEvent_isStateActive(&statechart, SimpleEvent_main_region_B)) << "Expected B to be active" ;
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(!simpleEvent_isStateActive(&statechart, SimpleEvent_main_region_B));
}


