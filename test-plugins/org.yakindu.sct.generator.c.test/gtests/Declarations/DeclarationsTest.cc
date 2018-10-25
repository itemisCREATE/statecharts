/* Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "Declarations.h"

#include "sc_timer_service.h"


static Declarations statechart;


//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;
			
class DeclarationsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		declarations_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			0,
			(sc_run_cycle_fp) &declarations_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(DeclarationsTest, declarationsTest) {
	
	declarations_enter(&statechart);
}


