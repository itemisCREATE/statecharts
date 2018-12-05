
#include "gtest/gtest.h"
#include "ParentFirstExecutionHierarchy.h"

#include "sc_timer_service.h"

static ParentFirstExecutionHierarchy statechart;


class ParentFirstExecutionHierarchyTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void childShouldTakeTransition();
	void parentShouldTakeTransition();
	void grandparentShouldTakeTransition();
	void expectLocalReactrionsExecuteWithNoTransition();
	void assertNoLocalReaction();
	void setTimer(ParentFirstExecutionHierarchy* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ParentFirstExecutionHierarchy* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ParentFirstExecutionHierarchyTest * tc;

void assertNoLocalReaction();

void ParentFirstExecutionHierarchyTest::SetUp()
{
	parentFirstExecutionHierarchy_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &parentFirstExecutionHierarchy_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ParentFirstExecutionHierarchyTest::childShouldTakeTransition()
{
	parentFirstExecutionHierarchy_enter(&statechart);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	parentFirstExecutionHierarchyIface_set_disable_a(&statechart,true);
	parentFirstExecutionHierarchyIface_set_disable_aa(&statechart,true);
	parentFirstExecutionHierarchyIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_B));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_a_reacted(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aa_reacted(&statechart));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_aaa_reacted(&statechart));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_a_local(&statechart));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_aa_local(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aaa_local(&statechart));
}
void ParentFirstExecutionHierarchyTest::parentShouldTakeTransition()
{
	parentFirstExecutionHierarchy_enter(&statechart);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	parentFirstExecutionHierarchyIface_set_disable_a(&statechart,true);
	parentFirstExecutionHierarchyIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_B));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_a_reacted(&statechart));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_aa_reacted(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aaa_reacted(&statechart));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_a_local(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aa_local(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aaa_local(&statechart));
}
void ParentFirstExecutionHierarchyTest::grandparentShouldTakeTransition()
{
	parentFirstExecutionHierarchy_enter(&statechart);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	parentFirstExecutionHierarchyIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_B));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_a_reacted(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aa_reacted(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aaa_reacted(&statechart));
	assertNoLocalReaction();
}
void ParentFirstExecutionHierarchyTest::expectLocalReactrionsExecuteWithNoTransition()
{
	parentFirstExecutionHierarchy_enter(&statechart);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstExecutionHierarchy_isStateActive(&statechart, ParentFirstExecutionHierarchy_ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_a_local(&statechart));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_aa_local(&statechart));
	EXPECT_TRUE(parentFirstExecutionHierarchyIface_get_aaa_local(&statechart));
}
void ParentFirstExecutionHierarchyTest::assertNoLocalReaction()
{
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_a_local(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aa_local(&statechart));
	EXPECT_TRUE(!parentFirstExecutionHierarchyIface_get_aaa_local(&statechart));
}

void ParentFirstExecutionHierarchyTest::setTimer(ParentFirstExecutionHierarchy* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ParentFirstExecutionHierarchyTest::unsetTimer(ParentFirstExecutionHierarchy* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ParentFirstExecutionHierarchyTest, childShouldTakeTransition) {
	childShouldTakeTransition();
}
TEST_F(ParentFirstExecutionHierarchyTest, parentShouldTakeTransition) {
	parentShouldTakeTransition();
}
TEST_F(ParentFirstExecutionHierarchyTest, grandparentShouldTakeTransition) {
	grandparentShouldTakeTransition();
}
TEST_F(ParentFirstExecutionHierarchyTest, expectLocalReactrionsExecuteWithNoTransition) {
	expectLocalReactrionsExecuteWithNoTransition();
}


