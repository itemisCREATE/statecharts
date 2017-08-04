/* Generated by YAKINDU Statechart Tools code generator. */
#include <string>
#include "gtest/gtest.h"
#include "TriggerExpressionPrecedence.h"
#include "sc_runner.h"
#include "sc_types.h"



static TriggerExpressionPrecedence* statechart;

//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class TriggerExpressionPrecedenceTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new TriggerExpressionPrecedence();
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


TEST_F(TriggerExpressionPrecedenceTest, unsatisfiedTriggerAndFGuardFalseOrFalse) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(false);
	
	statechart->getDefaultSCI()->set_c2(false);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
}
TEST_F(TriggerExpressionPrecedenceTest, unsatisfiedTriggerAndFGuardTrueOrFalse) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(true);
	
	statechart->getDefaultSCI()->set_c2(false);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
}
TEST_F(TriggerExpressionPrecedenceTest, unsatisfiedTriggerAndFGuardFalseOrTrue) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(false);
	
	statechart->getDefaultSCI()->set_c2(true);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
}
TEST_F(TriggerExpressionPrecedenceTest, unsatisfiedTriggerAndFGuardTrueOrTrue) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(true);
	
	statechart->getDefaultSCI()->set_c2(true);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
}
