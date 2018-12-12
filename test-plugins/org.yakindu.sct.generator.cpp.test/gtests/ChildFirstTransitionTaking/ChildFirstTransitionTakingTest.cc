#include <string>
#include "gtest/gtest.h"
#include "ChildFirstTransitionTaking.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

executionorder::ChildFirstTransitionTaking* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ChildFirstTransitionTakingTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new executionorder::ChildFirstTransitionTaking();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			true,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(ChildFirstTransitionTakingTest, testParentTransitionFromSimpleState) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AA));
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_B));
	
	statechart->exit();
	
	
}
TEST_F(ChildFirstTransitionTakingTest, testParentTransitionFromOrthogonalChildState) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AA));
	
	statechart->getDefaultSCI()->raise_go();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA));
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB));
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_B));
	
	statechart->exit();
	
	
}
TEST_F(ChildFirstTransitionTakingTest, testParentLocalReactionOnTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AA));
	
	statechart->getDefaultSCI()->raise_go();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA));
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB));
	
	statechart->getDefaultSCI()->raise_go();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r1_A_r1_AA));
	
	statechart->exit();
	
	
}
TEST_F(ChildFirstTransitionTakingTest, testLocalReactionsOnTransitionsParentScope) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r2_C_r_CA_r_CAA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cLocalReaction()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_caLocalReaction()== 0);
	
	statechart->getDefaultSCI()->raise_go();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r2_C_r_CA_r_CAB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cLocalReaction()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_caLocalReaction()== 1);
	
	statechart->getDefaultSCI()->raise_go();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r2_C_r_CA_r_CAA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cLocalReaction()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_caLocalReaction()== 2);
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r2_C_r_CB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cLocalReaction()== 3);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_caLocalReaction()== 2);
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ChildFirstTransitionTaking::ChildFirstTransitionTaking_r2_C_r_CA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_cLocalReaction()== 4);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_caLocalReaction()== 2);
	
	
}

}

