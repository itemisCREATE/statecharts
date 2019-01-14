
#include "gtest/gtest.h"
#include "AssignmentAsExpression.h"

#include "sc_timer_service.h"

static AssignmentAsExpression statechart;


class AssignmentAsExpressionTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void simpleAssignment();
	void setTimer(AssignmentAsExpression* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(AssignmentAsExpression* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static AssignmentAsExpressionTest * tc;


void AssignmentAsExpressionTest::SetUp()
{
	assignmentAsExpression_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &assignmentAsExpression_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void AssignmentAsExpressionTest::simpleAssignment()
{
	assignmentAsExpression_enter(&statechart);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_Add));
	EXPECT_TRUE(assignmentAsExpressionIface_get_b(&statechart)== 5);
	EXPECT_TRUE(assignmentAsExpressionIface_get_a(&statechart)== 9);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_Subtract));
	EXPECT_TRUE(assignmentAsExpressionIface_get_d(&statechart)== 6);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_Multiply));
	EXPECT_TRUE(assignmentAsExpressionIface_get_e(&statechart)== 15);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_Divide));
	EXPECT_TRUE(assignmentAsExpressionIface_get_g(&statechart)== 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_Modulo));
	EXPECT_TRUE(assignmentAsExpressionIface_get_i(&statechart)== 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_Shift));
	EXPECT_TRUE(assignmentAsExpressionIface_get_j(&statechart)== 16);
	EXPECT_TRUE(assignmentAsExpressionIface_get_k(&statechart)== 4);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_boolean_And));
	EXPECT_TRUE(assignmentAsExpressionIface_get_l(&statechart)== 1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_boolean_Or));
	EXPECT_TRUE(assignmentAsExpressionIface_get_p(&statechart)== 15);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(assignmentAsExpression_isStateActive(&statechart, AssignmentAsExpression_main_region_boolean_Xor));
	EXPECT_TRUE(assignmentAsExpressionIface_get_u(&statechart)== 12);
	assignmentAsExpression_exit(&statechart);
}

void AssignmentAsExpressionTest::setTimer(AssignmentAsExpression* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void AssignmentAsExpressionTest::unsetTimer(AssignmentAsExpression* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(AssignmentAsExpressionTest, simpleAssignment) {
	simpleAssignment();
}


