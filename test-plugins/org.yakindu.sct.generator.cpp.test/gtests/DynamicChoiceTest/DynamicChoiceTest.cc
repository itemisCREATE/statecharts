#include <string>
#include "gtest/gtest.h"
#include "DynamicChoice.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

DynamicChoice* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class DynamicChoiceTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new DynamicChoice();
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


TEST_F(DynamicChoiceTest, DynamicChoiceTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(DynamicChoice::main_region_Start));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(DynamicChoice::main_region_A));
	
	
}

}

