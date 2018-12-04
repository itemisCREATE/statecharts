
#include "gtest/gtest.h"
#include "ChildFirstLocalReactions.h"

#include "sc_timer_service.h"

static ChildFirstLocalReactions statechart;

static sc_integer counter = 0l;

class ChildFirstLocalReactionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void expectBottomUpLocalReactionOrder();
	void expectParentLocalReactionOnChildLocalTransition();
	void expectGrandparentLocalReactionOnParentLocalTransition();
	void expectNoLocalReactionOnGrandparentTransition();
	void setTimer(ChildFirstLocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ChildFirstLocalReactions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ChildFirstLocalReactionsTest * tc;


void ChildFirstLocalReactionsTest::SetUp()
{
	childFirstLocalReactions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &childFirstLocalReactions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ChildFirstLocalReactionsTest::expectBottomUpLocalReactionOrder()
{
	childFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aaa_local(&statechart)== 1l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aa_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_a_local(&statechart)== 3l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_sm_local(&statechart)== 4l);
}
void ChildFirstLocalReactionsTest::expectParentLocalReactionOnChildLocalTransition()
{
	childFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	childFirstLocalReactionsIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_A_r_AA_r_AAB));
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aaa_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aa_local(&statechart)== 1l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_a_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_sm_local(&statechart)== 3l);
}
void ChildFirstLocalReactionsTest::expectGrandparentLocalReactionOnParentLocalTransition()
{
	childFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	childFirstLocalReactionsIface_set_disable_aaa(&statechart,true);
	childFirstLocalReactionsIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_A_r_AB));
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aaa_local(&statechart)== 1l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aa_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_a_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_sm_local(&statechart)== 3l);
}
void ChildFirstLocalReactionsTest::expectNoLocalReactionOnGrandparentTransition()
{
	childFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	childFirstLocalReactionsIface_set_disable_aaa(&statechart,true);
	childFirstLocalReactionsIface_set_disable_aa(&statechart,true);
	childFirstLocalReactionsIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstLocalReactions_isStateActive(&statechart, ChildFirstLocalReactions_ChildFirstLocalReactions_r_B));
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aaa_local(&statechart)== 1l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_aa_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_a_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstLocalReactionsIface_get_sm_local(&statechart)== 3l);
}

void ChildFirstLocalReactionsTest::setTimer(ChildFirstLocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ChildFirstLocalReactionsTest::unsetTimer(ChildFirstLocalReactions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ChildFirstLocalReactionsTest, expectBottomUpLocalReactionOrder) {
	expectBottomUpLocalReactionOrder();
}
TEST_F(ChildFirstLocalReactionsTest, expectParentLocalReactionOnChildLocalTransition) {
	expectParentLocalReactionOnChildLocalTransition();
}
TEST_F(ChildFirstLocalReactionsTest, expectGrandparentLocalReactionOnParentLocalTransition) {
	expectGrandparentLocalReactionOnParentLocalTransition();
}
TEST_F(ChildFirstLocalReactionsTest, expectNoLocalReactionOnGrandparentTransition) {
	expectNoLocalReactionOnGrandparentTransition();
}


