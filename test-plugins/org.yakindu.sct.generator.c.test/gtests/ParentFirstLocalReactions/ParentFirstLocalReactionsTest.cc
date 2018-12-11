
#include "gtest/gtest.h"
#include "ParentFirstLocalReactions.h"

#include "sc_timer_service.h"

static ParentFirstLocalReactions statechart;


class ParentFirstLocalReactionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void expectBottomUpLocalReactionOrder();
	void expectParentLocalReactionOnChildLocalTransition();
	void expectGrandparentLocalReactionOnParentLocalTransition();
	void expectNoLocalReactionOnGrandparentTransition();
	void setTimer(ParentFirstLocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ParentFirstLocalReactions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ParentFirstLocalReactionsTest * tc;


void ParentFirstLocalReactionsTest::SetUp()
{
	parentFirstLocalReactions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &parentFirstLocalReactions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ParentFirstLocalReactionsTest::expectBottomUpLocalReactionOrder()
{
	parentFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_A_r_AA_r_AAA));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_A_r_AA_r_AAA));
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_sm_local(&statechart)== 1l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_a_local(&statechart)== 2l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aa_local(&statechart)== 3l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aaa_local(&statechart)== 4l);
}
void ParentFirstLocalReactionsTest::expectParentLocalReactionOnChildLocalTransition()
{
	parentFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_A_r_AA_r_AAA));
	parentFirstLocalReactionsIface_raise_e(&statechart);
	parentFirstLocalReactionsIface_set_disable_a(&statechart,true);
	parentFirstLocalReactionsIface_set_disable_aa(&statechart,true);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_A_r_AA_r_AAB));
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_sm_local(&statechart)== 1l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_a_local(&statechart)== 2l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aa_local(&statechart)== 3l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aaa_local(&statechart)== 0l);
}
void ParentFirstLocalReactionsTest::expectGrandparentLocalReactionOnParentLocalTransition()
{
	parentFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_A_r_AA_r_AAA));
	parentFirstLocalReactionsIface_set_disable_a(&statechart,true);
	parentFirstLocalReactionsIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_A_r_AB));
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_sm_local(&statechart)== 1l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_a_local(&statechart)== 2l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aa_local(&statechart)== 0l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aaa_local(&statechart)== 0l);
}
void ParentFirstLocalReactionsTest::expectNoLocalReactionOnGrandparentTransition()
{
	parentFirstLocalReactions_enter(&statechart);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_A_r_AA_r_AAA));
	parentFirstLocalReactionsIface_set_disable_aaa(&statechart,true);
	parentFirstLocalReactionsIface_set_disable_aa(&statechart,true);
	parentFirstLocalReactionsIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstLocalReactions_isStateActive(&statechart, ParentFirstLocalReactions_ParentFirstLocalReactions_r_B));
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_sm_local(&statechart)== 1l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_a_local(&statechart)== 0l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aa_local(&statechart)== 0l);
	EXPECT_TRUE(parentFirstLocalReactionsIface_get_aaa_local(&statechart)== 0l);
}

void ParentFirstLocalReactionsTest::setTimer(ParentFirstLocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ParentFirstLocalReactionsTest::unsetTimer(ParentFirstLocalReactions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ParentFirstLocalReactionsTest, expectBottomUpLocalReactionOrder) {
	expectBottomUpLocalReactionOrder();
}
TEST_F(ParentFirstLocalReactionsTest, expectParentLocalReactionOnChildLocalTransition) {
	expectParentLocalReactionOnChildLocalTransition();
}
TEST_F(ParentFirstLocalReactionsTest, expectGrandparentLocalReactionOnParentLocalTransition) {
	expectGrandparentLocalReactionOnParentLocalTransition();
}
TEST_F(ParentFirstLocalReactionsTest, expectNoLocalReactionOnGrandparentTransition) {
	expectNoLocalReactionOnGrandparentTransition();
}


