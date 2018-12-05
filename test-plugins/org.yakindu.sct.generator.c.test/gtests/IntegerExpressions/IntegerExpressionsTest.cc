
#include "gtest/gtest.h"
#include "IntegerExpressions.h"

#include "sc_timer_service.h"

static IntegerExpressions statechart;


class IntegerExpressionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void integerExpressions();
	void setTimer(IntegerExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(IntegerExpressions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static IntegerExpressionsTest * tc;


void IntegerExpressionsTest::SetUp()
{
	integerExpressions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &integerExpressions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void IntegerExpressionsTest::integerExpressions()
{
	integerExpressions_enter(&statechart);
	EXPECT_TRUE(integerExpressions_isStateActive(&statechart, IntegerExpressions_main_region_StateA));
	EXPECT_TRUE(integerExpressionsIface_get_myInt1(&statechart)== 10l);
	EXPECT_TRUE(integerExpressionsIface_get_myInt2(&statechart)== 5l);
	integerExpressionsIface_raise_e1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(integerExpressionsIface_get_less(&statechart)== false);
	EXPECT_TRUE(integerExpressionsIface_get_greater(&statechart)== true);
	EXPECT_TRUE(integerExpressionsIface_get_equalOrLess(&statechart)== false);
	EXPECT_TRUE(integerExpressionsIface_get_equalOrGreater(&statechart)== true);
	EXPECT_TRUE(integerExpressionsIface_get_equal(&statechart)== false);
	EXPECT_TRUE(integerExpressionsIface_get_notEqual(&statechart)== true);
	EXPECT_TRUE(integerExpressionsIface_get_plus(&statechart)== 15l);
	EXPECT_TRUE(integerExpressionsIface_get_minus(&statechart)== 5l);
	EXPECT_TRUE(integerExpressionsIface_get_multiply(&statechart)== 50l);
	EXPECT_TRUE(integerExpressionsIface_get_division(&statechart)== 2l);
	EXPECT_TRUE(integerExpressionsIface_get_modulo(&statechart)== 0l);
	EXPECT_TRUE(integerExpressionsIface_get_negat(&statechart)== - 10l );
	EXPECT_TRUE(integerExpressionsIface_get_multiAssign(&statechart)== 20l);
	EXPECT_TRUE(integerExpressionsIface_get_divAssign(&statechart)== 2l);
	EXPECT_TRUE(integerExpressionsIface_get_plusAssign(&statechart)== 12l);
	EXPECT_TRUE(integerExpressionsIface_get_minusAssign(&statechart)== - 8l );
	EXPECT_TRUE(integerExpressionsIface_get_moduloAssign(&statechart)== 0l);
	EXPECT_TRUE(integerExpressionsIface_get_decrementAssign(&statechart)== 0l);
	EXPECT_TRUE(integerExpressionsIface_get_decrement(&statechart)== 1l);
	EXPECT_TRUE(integerExpressionsIface_get_incrementAssign(&statechart)== 0l);
	EXPECT_TRUE(integerExpressionsIface_get_increment(&statechart)== 1l);
}

void IntegerExpressionsTest::setTimer(IntegerExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void IntegerExpressionsTest::unsetTimer(IntegerExpressions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(IntegerExpressionsTest, integerExpressions) {
	integerExpressions();
}


