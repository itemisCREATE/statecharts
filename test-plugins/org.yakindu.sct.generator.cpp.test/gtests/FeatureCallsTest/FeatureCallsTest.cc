#include <string>
#include "gtest/gtest.h"
#include "FeatureCalls.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

FeatureCalls* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class FeatureCallsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new FeatureCalls();
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


TEST_F(FeatureCallsTest, FeatureCalls) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(FeatureCalls::main_region_A));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(FeatureCalls::main_region_A));
	
	
}

	}

