#include <string>
#include "gtest/gtest.h"
#include "AlwaysOncycle.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

AlwaysOncycle* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class AlwaysOncycleTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new AlwaysOncycle();
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


TEST_F(AlwaysOncycleTest, alwaysOnCycleTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(AlwaysOncycle::main_region_StateA));
	
	sc_integer count = 0l;
	
	while (count< 5l) {
		runner->proceed_cycles(1);
		EXPECT_TRUE(statechart->isStateActive(AlwaysOncycle::main_region_StateA));
		count++;
	}
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_value()== 5l));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AlwaysOncycle::main_region_StateB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_value()== 0l);
	
	count = 0l;
	
	while (count< 5l) {
		runner->proceed_cycles(1);
		EXPECT_TRUE(statechart->isStateActive(AlwaysOncycle::main_region_StateB));
		count++;
	}
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_value()== 5l));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AlwaysOncycle::main_region_StateA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_value()== 0l);
	
	
}

}

