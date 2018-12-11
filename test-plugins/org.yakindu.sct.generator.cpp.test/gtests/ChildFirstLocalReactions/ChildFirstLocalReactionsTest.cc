#include <string>
#include "gtest/gtest.h"
#include "ChildFirstLocalReactions.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

executionorder::ChildFirstLocalReactions* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ChildFirstLocalReactionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new executionorder::ChildFirstLocalReactions();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(ChildFirstLocalReactionsTest, expectBottomUpLocalReactionOrder) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 3l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 4l);
	
	
}
TEST_F(ChildFirstLocalReactionsTest, expectParentLocalReactionOnChildLocalTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_A_r_AA_r_AAB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 3l);
	
	
}
TEST_F(ChildFirstLocalReactionsTest, expectGrandparentLocalReactionOnParentLocalTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->set_disable_aaa(true);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_A_r_AB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 3l);
	
	
}
TEST_F(ChildFirstLocalReactionsTest, expectNoLocalReactionOnGrandparentTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->set_disable_aaa(true);
	
	statechart->getDefaultSCI()->set_disable_aa(true);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstLocalReactions::ChildFirstLocalReactions_r_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 3l);
	
	
}

}

