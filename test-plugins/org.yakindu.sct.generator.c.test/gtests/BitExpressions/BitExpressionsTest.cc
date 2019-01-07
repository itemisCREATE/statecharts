
#include "gtest/gtest.h"
#include "BitExpressions.h"

#include "sc_timer_service.h"

static BitExpressions statechart;


class BitExpressionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void bitExpressions();
	void setTimer(BitExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(BitExpressions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static BitExpressionsTest * tc;


void BitExpressionsTest::SetUp()
{
	bitExpressions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &bitExpressions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void BitExpressionsTest::bitExpressions()
{
	bitExpressions_enter(&statechart);
	EXPECT_TRUE(bitExpressions_isStateActive(&statechart, BitExpressions_main_region_StateA));
	EXPECT_TRUE(bitExpressionsIface_get_myBit1(&statechart)== 5);
	EXPECT_TRUE(bitExpressionsIface_get_myBit2(&statechart)== 7);
	bitExpressionsIface_raise_e1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(bitExpressions_isStateActive(&statechart, BitExpressions_main_region_StateB));
	EXPECT_TRUE(bitExpressionsIface_get_leftBitshift(&statechart)== 10);
	EXPECT_TRUE(bitExpressionsIface_get_rightBitshift(&statechart)== 2);
	EXPECT_TRUE(bitExpressionsIface_get_complementBitshift(&statechart)== - 6 );
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseAnd(&statechart)== 5);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseOr(&statechart)== 7);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseXor(&statechart)== 2);
}

void BitExpressionsTest::setTimer(BitExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void BitExpressionsTest::unsetTimer(BitExpressions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(BitExpressionsTest, BitExpressions) {
	bitExpressions();
}


