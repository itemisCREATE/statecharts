#include <string>
#include "gtest/gtest.h"
#include "ConstOnlyNamedScope.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

declarations::ConstOnlyNamedScope* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ConstOnlyNamedScopeTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new declarations::ConstOnlyNamedScope();
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


TEST_F(ConstOnlyNamedScopeTest, statechartEntry) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(declarations::ConstOnlyNamedScope::ConstOnlyNamedScope_main_region_A));
	
	
}
TEST_F(ConstOnlyNamedScopeTest, stateTransition) {
	
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_e( 1l);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(declarations::ConstOnlyNamedScope::ConstOnlyNamedScope_main_region_B));
	
	
}

}

