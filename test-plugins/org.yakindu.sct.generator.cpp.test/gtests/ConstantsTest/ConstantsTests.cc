#include <string>
#include "gtest/gtest.h"
#include "Constants.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

Constants* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ConstantsTests : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new Constants();
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


TEST_F(ConstantsTests, constantDefinition) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Constants::main_region_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 10l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 20l);
	
	EXPECT_TRUE(strcmp(statechart->getSCI_Named()->get_y(), "Hello World") == 0);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_result()== 20l);
	
	statechart->getDefaultSCI()->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(Constants::main_region_C));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_result()== 100l);
	
	statechart->getDefaultSCI()->raise_e2( statechart->getDefaultSCI()->get_x());
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_result()== 1000l);
	
	EXPECT_TRUE(statechart->isStateActive(Constants::main_region_A));
	
	
}

	}

