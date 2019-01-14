#include <string>
#include "gtest/gtest.h"
#include "ParentFirstExecutionHierarchy.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

void assertNoLocalReaction();
executionorder::ParentFirstExecutionHierarchy* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ParentFirstExecutionHierarchyTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new executionorder::ParentFirstExecutionHierarchy();
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

void assertNoLocalReaction(){
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_local());
	
	
}

TEST_F(ParentFirstExecutionHierarchyTest, childShouldTakeTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->set_disable_a(true);
	
	statechart->getDefaultSCI()->set_disable_aa(true);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_B));
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_reacted());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_reacted());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_local());
	
	
}
TEST_F(ParentFirstExecutionHierarchyTest, parentShouldTakeTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->set_disable_a(true);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_B));
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_a_reacted());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_reacted());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_local());
	
	
}
TEST_F(ParentFirstExecutionHierarchyTest, grandparentShouldTakeTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aa_reacted());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_aaa_reacted());
	
	assertNoLocalReaction();
	
	
}
TEST_F(ParentFirstExecutionHierarchyTest, expectLocalReactrionsExecuteWithNoTransition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(executionorder::ParentFirstExecutionHierarchy::ParentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local());
	
	
}

}

