/* Generated by YAKINDU Statechart Tools code generator. */
#include <string>
#include "gtest/gtest.h"
#include "ConstOnlyDefaultScope.h"
#include "sc_runner.h"
#include "sc_types.h"


//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ConstOnlyDefaultScopeTest : public ::testing::Test{
	protected:
	
	ConstOnlyDefaultScope* statechart;
	
	virtual void SetUp() {
		statechart = new ConstOnlyDefaultScope();
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


TEST_F(ConstOnlyDefaultScopeTest, statechartEntry) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ConstOnlyDefaultScope::ConstOnlyDefaultScope_main_region_A));
	
	
}
TEST_F(ConstOnlyDefaultScopeTest, stateTransition) {
	
	statechart->enter();
	
	statechart->getSCI_A()->raise_e(1l);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ConstOnlyDefaultScope::ConstOnlyDefaultScope_main_region_B));
	
	
}
